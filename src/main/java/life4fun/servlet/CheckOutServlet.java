package life4fun.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.cfg.EnumFeature;
import com.mysql.cj.util.StringUtils;

import life4fun.dto.RequestResult;
import life4fun.entity.CartItem;
import life4fun.entity.Member;
import life4fun.entity.Order;
import life4fun.entity.OrderDetails;
import life4fun.entity.ShoppingCart;
import life4fun.enumerate.PaymentType;
import life4fun.enumerate.ShippingType;
import life4fun.exception.StockShortageException;
import life4fun.exception.VGBException;
import life4fun.service.MemberService;
import life4fun.service.OrderService;
import life4fun.service.impl.MemberServiceImpl;
import life4fun.service.impl.OrderServiceImpl;
import life4fun.utils.ApplicationUtils;
import life4fun.utils.ConstantUtils;
import life4fun.utils.JsonUtils;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String JSP_SOURCE = "/jsp/checkout/";
	public static final String JS_SOURCE = "js/checkout";
	public static final String STATIC_SOURCE = "static";
	
	private MemberService memberService = new MemberServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute(ApplicationUtils.JS_SOURCE_KEY, JS_SOURCE);
		request.setAttribute(ApplicationUtils.STATIC_SOURCE_KEY, STATIC_SOURCE);
		request.setCharacterEncoding("UTF-8");
		
		String method = request.getParameter("method") == null ? "checkout" : request.getParameter("method");
		System.out.println("CheckOutServlet method -> " + method);
		
		switch (method) {
//		case "orderSearch":
//			orderSearch(request, response);
//			break;
		
		case "checkOut":
		default:
			checkOut(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void checkOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<String> errorsList = new ArrayList<>();
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
	
		//1. 驗證是否登入
		String phoneNumber;
		Integer memberId = Integer.valueOf((String) request.getSession().getAttribute(ConstantUtils.LOGIN_MEMBER_ID));
		Member sessionMember = memberService.findMemberById(memberId).getData();
		phoneNumber = sessionMember.getPhoneNumber();
		if (StringUtils.isNullOrEmpty(sessionMember.getPhoneNumber())) {
			response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("非登入狀態!")));
			return;
		}	
		
		//2.檢查購物車是否存在
		List<CartItem> cartItemList = (List<CartItem>) session.getAttribute("cart");
		if (cartItemList == null || cartItemList.isEmpty()) {
			response.sendRedirect("cart.jsp");
			return;
		}
			
		
		//1.取得request中的Form Data
		String paymentType = request.getParameter("paymentType");
		String shippingType = request.getParameter("shippingType");
		String recipientName = request.getParameter("recipientName");
		String recipientPhoneNumber = request.getParameter("recipientPhoneNumber");
		String recipientPostalCode = request.getParameter("recipientPostalCode");
		String recipientCity = request.getParameter("recipientCity");
		String recipientDistrict = request.getParameter("recipientDistrict");
		String recipientRoad = request.getParameter("recipientRoad");
		String recipientAddress = request.getParameter("recipientAddress");
		Timestamp createTime = Timestamp.valueOf(request.getParameter("createTime"));
		
		PaymentType pType = null;
		ShippingType shType = null;		
		if (StringUtils.isNullOrEmpty(paymentType)||StringUtils.isNullOrEmpty(shippingType)) {
			errorsList.add("必須選擇付款方式/貨運方式");
		}else {
			try {
				pType = PaymentType.valueOf(paymentType);				
			}catch(RuntimeException e) {
				errorsList.add("付款方式不正確: " + paymentType);
			}
			
			try {
				shType = ShippingType.valueOf(shippingType);
			}catch(RuntimeException e) {
				errorsList.add("貨運方式不正確: " + shippingType);
			}			
		}
		if (StringUtils.isNullOrEmpty(recipientName)) {
			errorsList.add("必須輸入收件人姓名");
		}
		if(StringUtils.isNullOrEmpty(recipientPhoneNumber)) {
			errorsList.add("必須輸入收件人電話");
		}
		if(StringUtils.isNullOrEmpty(recipientPostalCode)||StringUtils.isNullOrEmpty(recipientCity)
				||StringUtils.isNullOrEmpty(recipientDistrict)||StringUtils.isNullOrEmpty(recipientRoad)
				||StringUtils.isNullOrEmpty(recipientAddress)) {
			errorsList.add("必須輸入收件地址");
		}
		
		//2.若無誤則呼叫商業邏輯
		if(errorsList.isEmpty()) {
			Order order = new Order();
			order.setPhoneNumber(phoneNumber);
			order.setCreatedTime(createTime);//todo
			order.setPaymentType(pType);
			order.setShippingType(shType);
			order.setRecipientName(recipientName);
			order.setRecipientPhoneNumber(recipientPhoneNumber);
			order.setRecipientPostalCode(recipientPostalCode);
			order.setRecipientCity(recipientCity);
			order.setRecipientDistrict(recipientDistrict);
			order.setRecipientRoad(recipientRoad);
			order.setRecipientAddress(recipientAddress);
			
			OrderDetails orderDetails = new OrderDetails();
			List<OrderDetails> orderDetailsList =new ArrayList<>();
			for(CartItem item: cartItemList) {
				orderDetails.setProductId(item.getProductId());
				orderDetails.setProductName(item.getProductName());
				orderDetails.setProductColor(item.getProductColor());
				orderDetails.setProductSize(item.getProductSize());
				orderDetails.setPrice(item.getPrice());
				orderDetails.setQuantity(item.getQuantity());				
				orderDetailsList.add(orderDetails);
			}		
					
			OrderService oService = new OrderServiceImpl();
			
			try {
				oService.createOrder(order,orderDetailsList);
				
				//3.1 成功:redirect to orders_history.jsp
				session.removeAttribute("cart");
				response.sendRedirect( request.getContextPath() + "/jsp/order/orderDetails.jsp");
				return;
//			} catch (StockShortageException e) {
//				this.log(e.getMessage(),e);
//				errorsList.add(e.toString());
//				session.setAttribute("stockError", errorsList);
//				response.sendRedirect( request.getContextPath() + "/member/cart.jsp");
//				return;
			
			} catch (Exception e) {
				this.log("建立訂單發生非預期錯誤",e);
				errorsList.add("建立訂單發生錯誤:" + e);
			}
		}
		//3.2 失敗:forward to /member/check_out.jsp
		request.setAttribute("error", errorsList);
		request.getRequestDispatcher("check_out.jsp").forward(request, response);
		
		request.setAttribute("orderList", orderService.findOrder(phoneNumber).getData());
		request.getRequestDispatcher(JSP_SOURCE + "order.jsp").forward(request, response);
	}


}

