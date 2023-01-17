package life4fun.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.util.StringUtils;

import life4fun.dto.RequestResult;
import life4fun.entity.CartItem;
import life4fun.entity.Member;
import life4fun.entity.Order;
import life4fun.entity.OrderDetails;
import life4fun.service.MemberService;
import life4fun.service.OrderService;
import life4fun.service.impl.MemberServiceImpl;
import life4fun.service.impl.OrderServiceImpl;
import life4fun.utils.ApplicationUtils;
import life4fun.utils.ConstantUtils;
import life4fun.utils.JsonUtils;
import com.google.common.base.Splitter;
import com.google.gson.*;
import com.google.gson.Gson;

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
		
		String method = request.getParameter("method") == null ? "login" : request.getParameter("method");
		System.out.println("CheckOutServlet method -> " + method);
		
		switch (method) {
		case "sendOrder":
			sendOrder(request, response);
			break;
		
		case "checkout":
		default:
			checkout(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}
	Gson gson = new Gson();
	protected void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		
		//1. 驗證是否登入， 取得member
		String phoneNumber;
		Integer memberId = Integer.valueOf((String) request.getSession().getAttribute(ConstantUtils.LOGIN_MEMBER_ID));
		Member sessionMember = memberService.findMemberById(memberId).getData();
		phoneNumber = sessionMember.getPhoneNumber();
		if (StringUtils.isNullOrEmpty(sessionMember.getPhoneNumber())) {
			response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("非登入狀態!")));
			return;
		}
		request.setAttribute("member",sessionMember);
		System.out.println("member： "+sessionMember);
		
		String[] cartItemList = request.getParameterValues("carData");
		String cartItem = Arrays.toString(gson.fromJson(request.getParameter("carData"), Object[].class)).replaceAll("\\=", "\\:").replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\{", "");
		cartItem=cartItem.substring(0, cartItem.length()-1);
		System.out.println("cartItem:"+ cartItem);
		String[] item = cartItem.split("\\}, ");
		ObjectMapper mapper = new ObjectMapper();   
		//CartItem item = mapper.readValue(cartItem, CartItem.class);
		//System.out.println(item);
		//List<String> cartItemList1 = (List<String>) request.getAttribute("carData");
		//System.out.println("cartItemList："+cartItemList);
		//System.out.println("cartItemList1："+cartItemList1);
		Map<Integer, Map<String,String>> properties = new HashMap<Integer, Map<String,String>>();
		int idx = 0;
		if(null!=cartItemList) {
			for(String i:item) {
				i=i.replace(" ","");
				properties.put(idx,Splitter.on(",")
					    .withKeyValueSeparator(":")
					    .split(i));
				System.out.println(i);
				System.out.println(properties);//後端接到的formdata
				idx++;
			}
			System.out.println("properties:"+properties);
			System.out.println(properties.get(0).get("quantity")); 
			System.out.println(properties.get(0).get("productId")); 
			response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.success()));
		}else {
			response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("購物清單不可為空!")));
			return;
		}
//		List<String> cartItemList = Arrays.asList(request.getParameterValues("cartItemList"));
//		System.out.println(cartItemList);
		
		String productId = request.getParameter("productId");
		String quantity = request.getParameter("quantity");
		System.out.println("productId"+productId);
		System.out.println("quantity"+quantity);
		// 3. Convert received JSON to Article
		
//		ProductService productService = new ProductService();
//		Product product = productService.getProductById(productId);
//		Double itemAmount = product.getPrice()*Integer.valueOf(quantity);
//		for(CartItem item: cartItemList) {
//			Double totalAmountDouble = 
//		}
//		request.setAttribute("productId",productId);
//		request.setAttribute("productName",product.getProductName());
//		request.setAttribute("quantity",quantity);
//		request.setAttribute("itemAmount",itemAmount);
//		request.setAttribute("quantity",quantity);
		
		//3.回傳前端
		request.getRequestDispatcher(JSP_SOURCE + "checkout.jsp").forward(request, response);
	}
/*	
private static Order getOrder(HttpServletRequest request) {
	
	
}*/
	public void showOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		//request.getRequestDispatcher("/jsp/cart/cart.jsp").forward(request, response);
		request.getRequestDispatcher(JSP_SOURCE+"order.jsp").forward(request, response);
	}
	
	public void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
	
		//2.檢查購物車是否存在
//		List<CartItem> cartItemList = (List<CartItem>) session.getAttribute("cart");
//		if (cartItemList == null || cartItemList.isEmpty()) {
//			response.sendRedirect("cart.jsp");
//			return;
//		}
		
		//1.取得request中的Data
		String recipientName = request.getParameter("recipientName");
		String recipientPhoneNumber = request.getParameter("recipientPhoneNumber");
		String recipientPostalCode = request.getParameter("recipientPostalCode");
		String recipientCity = request.getParameter("recipientCity");
		String recipientDistrict = request.getParameter("recipientDistrict");
		String recipientRoad = request.getParameter("recipientRoad");
		String recipientAddress = request.getParameter("recipientAddress");
		Timestamp createTime ;
		String paymentType = request.getParameter("paymentType");
		String shippingType = request.getParameter("shippingType");
		System.out.println("recipientName:"+recipientName);
		System.out.println("recipientPhoneNumber:"+recipientPhoneNumber);
		System.out.println("recipientAddress:"+recipientAddress);
		System.out.println("shippingType:"+shippingType);
		
		List<String> errorsList = new ArrayList<>();
		if (StringUtils.isNullOrEmpty(paymentType)||StringUtils.isNullOrEmpty(shippingType)) {
			errorsList.add("必須選擇付款方式/貨運方式");
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
			order.setPhoneNumber(recipientPhoneNumber);
			//order.setCreatedTime(createTime);//todo
			order.setRecipientName(recipientName);
			order.setRecipientPhoneNumber(recipientPhoneNumber);
			order.setRecipientPostalCode(recipientPostalCode);
			order.setRecipientCity(recipientCity);
			order.setRecipientDistrict(recipientDistrict);
			order.setRecipientRoad(recipientRoad);
			order.setRecipientAddress(recipientAddress);
			order.setPaymentType(paymentType);
			order.setShippingType(shippingType);
			
			OrderDetails orderDetails = new OrderDetails();
			List<OrderDetails> orderDetailsList =new ArrayList<>();
//			for(CartItem item: cartItemList) {
//				orderDetails.setProductId(item.getProductId());
//				orderDetails.setProductName(item.getProductName());
//				orderDetails.setProductColor(item.getProductColor());
//				orderDetails.setProductSize(item.getProductSize());
//				orderDetails.setPrice(item.getPrice());
//				orderDetails.setQuantity(item.getQuantity());				
//				orderDetailsList.add(orderDetails);
			}		
					
			OrderService oService = new OrderServiceImpl();
			
			try {
//				oService.createOrder(order,orderDetailsList);
				
				//3.1 成功:redirect to orders_history.jsp
//				session.removeAttribute("cart");
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.success()));
				request.getRequestDispatcher("/jsp/checkout/orderDetails.jsp").forward(request, response);
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
//		request.setAttribute("error", errorsList);
//		request.setAttribute("orderList", orderService.findOrder(phoneNumber).getData());
//		request.getRequestDispatcher(JSP_SOURCE + "order.jsp").forward(request, response);
//		
//	}


}

