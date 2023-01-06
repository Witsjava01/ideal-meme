package life4fun.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.util.StringUtils;

import life4fun.dto.RequestResult;
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

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String JSP_SOURCE = "/jsp/order/";
	public static final String JS_SOURCE = "js/order";
	public static final String STATIC_SOURCE = "static";
	
	private MemberService memberService = new MemberServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
		System.out.println("OrderServlet method -> " + method);
		switch (method) {
		case "orderSearch":
			orderSearch(request, response);
			break;
		case "findOrderDetails":
			findOrderDetails(request, response);
			break;
		case "showOrderDetails":
			showOrderDetails(request, response);
			break;
		case "order":
		default:
			order(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		Integer memberId = Integer.valueOf((String) request.getSession().getAttribute(ConstantUtils.LOGIN_MEMBER_ID));
		try {
			Member sessionMember = memberService.findMemberById(memberId).getData();
			String phoneNumber = sessionMember.getPhoneNumber();
			if (StringUtils.isNullOrEmpty(sessionMember.getPhoneNumber())) {
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("非登入狀態!")));
				return;
			} else {
				request.setAttribute("orderList", orderService.findOrder(phoneNumber).getData());
				request.getRequestDispatcher(JSP_SOURCE + "order.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// 500
			System.out.println(e.getMessage());
		}
		
	}

	public void orderSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		Integer memberId = Integer.valueOf((String) request.getSession().getAttribute(ConstantUtils.LOGIN_MEMBER_ID));
		try {
			Member sessionMember = memberService.findMemberById(memberId).getData();
			String phoneNumber = sessionMember.getPhoneNumber();
			if (StringUtils.isNullOrEmpty(phoneNumber)) {
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("非登入狀態!")));
				return;
			}
			//判斷orderId是否為空 為空=查全部 有值=+條件查詢
			String orderId = request.getParameter("order_id");
			if(orderId == "") {
				List<Order> orderList = orderService.findOrder(phoneNumber).getData();
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.success(orderList)));
			}else {
				List<Order> orderList = orderService.findOrder(phoneNumber, Integer.valueOf(orderId)).getData();
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.success(orderList)));
			}
		} catch (Exception e) {
			// 500
			System.out.println(e.getMessage());
		}
		
	}
	
	public void showOrderDetails (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer memberId = Integer.valueOf((String) request.getSession().getAttribute(ConstantUtils.LOGIN_MEMBER_ID));
		try {
			Member sessionMember = memberService.findMemberById(memberId).getData();
			if(StringUtils.isNullOrEmpty(sessionMember.getPhoneNumber())) {
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("非登入狀態!")));
				return;
			}else {
				List<Order> order = (List<Order>) request.getSession().getAttribute("orderItem");
				List<OrderDetails> orderDetails = (List<OrderDetails>) request.getSession().getAttribute("orderDetailsItem");
				request.setAttribute("orderItem", order);
				request.setAttribute("orderDetailsItem", orderDetails);
				response.setCharacterEncoding(StandardCharsets.UTF_8.name());
				request.getRequestDispatcher(JSP_SOURCE + "orderDetails.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// 500
			System.out.println(e.getMessage());
		}
		
	}
	
	public void findOrderDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		Integer memberId = Integer.valueOf((String) request.getSession().getAttribute(ConstantUtils.LOGIN_MEMBER_ID));
		try {
			Member sessionMember = memberService.findMemberById(memberId).getData();
			String phoneNumber = sessionMember.getPhoneNumber();
			if (StringUtils.isNullOrEmpty(phoneNumber)) {
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("非登入狀態!")));
				return;
			}
			String orderId = request.getParameter("orderId");
			if(StringUtils.isNullOrEmpty(orderId)) {
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("訂單編號為空")));
				return;
			}else {
				List<Order> order = orderService.findOrderToDetails(phoneNumber, Integer.valueOf(orderId)).getData();
				List<OrderDetails> orderDetails = orderService.findOrderetails(Integer.valueOf(orderId)).getData();
				request.getSession().setAttribute("orderItem", order);
				request.getSession().setAttribute("orderDetailsItem", orderDetails);
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.success()));
			}
		} catch (Exception e) {
			// 500
			System.out.println(e.getMessage());
		}
	}

}
