package life4fun.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.util.StringUtils;

import life4fun.dto.RequestResult;
import life4fun.entity.CartItem;
import life4fun.entity.Member;
import life4fun.entity.Product;
import life4fun.service.MemberService;
import life4fun.service.OrderService;
import life4fun.service.ProductService;
import life4fun.service.impl.MemberServiceImpl;
import life4fun.service.impl.OrderServiceImpl;
import life4fun.utils.ApplicationUtils;
import life4fun.utils.ConstantUtils;
import life4fun.utils.JsonUtils;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final String JSP_SOURCE = "/jsp/cart/";
	public static final String JS_SOURCE = "js/cart";
	public static final String STATIC_SOURCE = "static";
	
	private MemberService memberService = new MemberServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * call servlet後，對應method
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute(ApplicationUtils.JS_SOURCE_KEY, JS_SOURCE);
		request.setAttribute(ApplicationUtils.STATIC_SOURCE_KEY, STATIC_SOURCE);
		
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method") == null ? "cart" : request.getParameter("method");
		System.out.println("CartServlet method -> " + method);
		
		switch (method) {
		case "addCart":
			addCart(request, response);
			break;
		case "updateCart":
			updateCart(request, response);
			break;
		case "cart":
		default:
			cart(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		
		//1.驗證登入狀態：若未登入，跳轉登入畫面
		try {
			Integer memberId = Integer.valueOf((String) request.getSession().getAttribute(ConstantUtils.LOGIN_MEMBER_ID));
			Member sessionMember = memberService.findMemberById(memberId).getData();
			String phoneNumber = sessionMember.getPhoneNumber();
			
			if (StringUtils.isNullOrEmpty(sessionMember.getPhoneNumber())) {
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("非登入狀態!")));
				request.getRequestDispatcher("/jsp/member/login.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			// 500
			System.out.println(e.getMessage());
			request.getRequestDispatcher("/jsp/member/login.jsp").forward(request, response);
		}	
		
		//2.若已有登入，則跳轉購物車
		List<CartItem> cartItemList = (List<CartItem>)session.getAttribute("cart");				
		if(cartItemList==null || cartItemList.isEmpty()){
			String msg = "購物車是空的";
		}else{ 
			System.out.println("購物車有東西");
			//request.getRequestDispatcher("/jsp/cart/cart.jsp").forward(request, response);//這段要寫嗎?
			request.setAttribute("cart", cartItemList);
		}	

	}
	
	
		
	public void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<String> errorsList = new ArrayList<>();
		HttpSession session = request.getSession();
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		
		//1.讀取request的Form Data: productId, quantity
		String productId = request.getParameter("productId");
		String quantity = request.getParameter("quantity");
		System.out.printf("productId:%s, quantity:%s\n", productId, quantity);
		
		if (StringUtils.isNullOrEmpty(productId)) {
			errorsList.add("沒有productId無法加入購物車");	
		}
		if (StringUtils.isNullOrEmpty(quantity)|| !quantity.matches("\\d+")) {
			errorsList.add("quantity必須為整數樣式:" + quantity);	
		}
		
		//2.若無誤執行商業邏輯
		if(errorsList.isEmpty()) {
			ProductService pService = new ProductService();	
			
			try {
				Product p = pService.getProductById(productId);//查詢商品
				
				if(p!=null) {
					
					int qty = Integer.parseInt(quantity);//前端訂購的數量					
					if(qty>0) {//如果大於零
						List<CartItem> cartItemList = (List<CartItem>)session.getAttribute("cart");//從session取得cart
						System.out.println("sessionHas: "+cartItemList);
						if(cartItemList==null || cartItemList.size()==0) {//如果沒有cart
							cartItemList = new ArrayList<CartItem>();//就建立一個
							session.setAttribute("cart", cartItemList);//並放入session
							//System.out.println("sessionNew: "+session);
						}	
						CartItem cartItem =new CartItem();
						cartItem.setProduct(p);
						cartItem.setQuantity(qty);
						cartItemList.add(cartItem);		
						//System.out.println("cartItemList: "+cartItemList);
					}else {
						errorsList.add("加入購物車時qty必須>0: " + qty);	
					}	
				
				}else {
					errorsList.add("加入購物車時查無此產品:" + productId);					
				}
				
			} catch (Exception e) {
				this.log("發生非預期錯誤!", e);	
				System.out.println("errorsList: "+errorsList);
			}	
		}
		if(errorsList.size()>0) {
			this.log("加入購物車發生錯誤:\n" + errorsList.toString());
		}
		//System.out.println("SessionCartItemList: "+session.getAttribute("cart"));
		request.getRequestDispatcher(JSP_SOURCE +"cart.jsp").forward(request, response);
		//System.out.println(request.getContextPath()+"/jsp/cart/cart.jsp");
		System.out.println(JSP_SOURCE +"cart.jsp");
	}

	public void updateCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		List<String> errorsList = new ArrayList<>();
		HttpSession session = request.getSession();
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		List<CartItem> cartItemList = (List<CartItem>)session.getAttribute("cart");//從session取得cart
		
		if(cartItemList!=null) {
			for(CartItem item:cartItemList) {
				//1.取得form data
				Integer integer =cartItemList.indexOf(item);
				String quantity = request.getParameter("quantity" + item.hashCode()); 
				String delete = request.getParameter("delete" + item.hashCode());
				
				if(delete==null) { //修改數量
					if(quantity!=null && quantity.matches("\\d+")) {
						int qty = Integer.parseInt(quantity);//要修改的數量		
						if(qty>0) {
							item.setQuantity(qty);
							cartItemList.set(integer, item);
						}else {
							cartItemList.remove(item);
						}
					}else {
						errorsList.add( item.getProductId() + "-" + "數量不正確: " + quantity);
					}					
				}else{ //刪除明細
					cartItemList.remove(item);
				}
			}
		}
		
		//3.redirect 回/member/cart.jsp
		String submit = request.getParameter("submit");
		if("checkout".equals(submit)) {
			response.sendRedirect("check_out.jsp");
		}else {
			response.sendRedirect(request.getContextPath() + "/cart/cart.jsp");
		}
	}
	
	
	
	
}
