package life4fun.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.util.StringUtils;

import life4fun.dto.RequestResult;
import life4fun.dto.ServiceResult;
import life4fun.entity.Member;
import life4fun.entity.Order;
import life4fun.entity.OrderDetails;
import life4fun.service.MemberService;
import life4fun.service.StreetNameService;
import life4fun.service.impl.MemberServiceImpl;
import life4fun.service.impl.StreetNameServiceImpl;
import life4fun.utils.ApplicationUtils;
import life4fun.utils.ConstantUtils;
import life4fun.utils.JsonUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String JSP_SOURCE = "/jsp/member/";
	public static final String JS_SOURCE = "js/member";
	public static final String STATIC_SOURCE = "static";

	private MemberService memberService = new MemberServiceImpl();
	private StreetNameService streetNameService = new StreetNameServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute(ApplicationUtils.JS_SOURCE_KEY, JS_SOURCE);
		request.setAttribute(ApplicationUtils.STATIC_SOURCE_KEY, STATIC_SOURCE);
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method") == null ? "login" : request.getParameter("method");
		System.out.println("MemberServlet method -> " + method);
		switch (method) {
		case "findMember":
			findMember(request, response);
			break;
		case "member":
			member(request, response);
			break;
		case "register":
			register(request, response);
			break;
		case "password":
			password(request, response);
			break;
		case "addMember":
			addMember(request, response);
			break;
		case "updateMember":
			updateMember(request, response);
			break;
		case "updatePassword":
			updatePassword(request, response);
			break;
		case "login":
		default:
			login(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().removeAttribute(ConstantUtils.LOGIN_MEMBER_ID);
		request.getRequestDispatcher(JSP_SOURCE + "login.jsp").forward(request, response);
	}

	public void password(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer memberId = Integer.valueOf((String) request.getSession().getAttribute(ConstantUtils.LOGIN_MEMBER_ID));
		try {
			Member member = memberService.findMemberById(memberId).getData();
			request.setAttribute("password", member.getPassword());
			request.setAttribute("phoneNumber", member.getPhoneNumber());
			request.getRequestDispatcher(JSP_SOURCE + "password.jsp").forward(request, response);
		} catch (Exception e) {
			// 500
			System.out.println(e.getMessage());
		}
	}

	public void updatePassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		Integer memberId = Integer.valueOf((String) request.getSession().getAttribute(ConstantUtils.LOGIN_MEMBER_ID));
		try {
			Member member = memberService.findMemberById(memberId).getData();
			
			String sessionPassword = member.getPassword();
			String password = request.getParameter("password");
			if (sessionPassword.equals(password)) {
				String newPassword = request.getParameter("newPassword");
				if (newPassword.equals(password)) {
					response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("新密碼與舊密碼不可相同!")));
					return;
				} else {
					memberService.updatePassword(member.getPhoneNumber(), newPassword);
					member.setPassword(newPassword);
					response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.success()));
				}
			} else {
				response.setCharacterEncoding(StandardCharsets.UTF_8.name());
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("舊密碼錯誤，請確認後重新輸入!")));
			}
		} catch (Exception e) {
			// 500
			System.out.println(e.getMessage());
		}
		
	}

	public void member(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("isUpdate", true);
		request.setAttribute("streetNameList", streetNameService.findAllStreetName().getData());
		Integer memberId = Integer.valueOf((String) request.getSession().getAttribute(ConstantUtils.LOGIN_MEMBER_ID));
		try {
			Member sessionMember = memberService.findMemberById(memberId).getData();
			
			request.setAttribute("member", sessionMember);

			request.setAttribute("account", streetNameService.findAllStreetName().getData());
			request.getRequestDispatcher(JSP_SOURCE + "member.jsp").forward(request, response);
		} catch (Exception e) {
			// 500
			System.out.println(e.getMessage());
		}
		
	}

	protected void updateMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		Integer memberId = Integer.valueOf((String) request.getSession().getAttribute(ConstantUtils.LOGIN_MEMBER_ID));
		if (memberId == null) {
			response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("非登入狀態!")));
			return;
		}
		Member member;
		try {
			member = getMember(request);
		} catch (RuntimeException e) {
			response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail(e.getMessage())));
			return;
		}
		try {
			Member sessionMember = memberService.findMemberById(memberId).getData();
			Boolean checkMember = memberService.checkMember(sessionMember.getPhoneNumber());
			if (checkMember == false) {
				memberService.updateMember(member);
				ServiceResult<Member> queryResult = memberService.findMember(sessionMember.getPhoneNumber(),
						sessionMember.getPassword());
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.success()));
			} else {
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("此電話號碼已存在!")));
			}
		} catch (Exception e) {
			// 500
			System.out.println(e.getMessage());
		}
	}

	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("isUpdate", false);
		request.setAttribute("streetName", streetNameService.findAllStreetName().getData());
		request.getRequestDispatcher(JSP_SOURCE + "member.jsp").forward(request, response);
	}
	
	public void addMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member member;
		try {
			member = getMember(request);
			System.out.println("addMember > member: "+member);
		} catch (RuntimeException e) {
			response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail(e.getMessage())));
			return;
		}
		Boolean checkMember = memberService.checkMember(member.getPhoneNumber());
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		if (checkMember) {
			try {
				memberService.addMember(member);
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.success()));
			} catch (RuntimeException e) {
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail(e.getMessage())));
			}
		} else {
			response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("此電話號碼已存在!")));
		}

	}

	protected void findMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String phoneNumber = request.getParameter("account");
			String password = request.getParameter("password");
			// 要加參數驗證
			if (phoneNumber == null || password == null) {
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("輸入帳號或密碼不可為空")));
				return;
			}
			ServiceResult<Member> queryResult = memberService.findMember(phoneNumber, password);

			response.setCharacterEncoding(StandardCharsets.UTF_8.name());
			if (queryResult.getMsg() != null) {
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail(queryResult.getMsg())));
				return;
			} else if (queryResult.getData() == null) {
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("查無此用戶!")));
				return;
			} else {
				request.getSession().setAttribute(ConstantUtils.LOGIN_MEMBER_ID, queryResult.getData().getId());
				System.out.println(queryResult.getData().getId());
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.success(queryResult.getData())));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			// 這邊response要return 500給client
		}
	}

	private static Member getMember(HttpServletRequest request) {
		// 驗證
		String name = request.getParameter("name");
		if (StringUtils.isNullOrEmpty(name)) {
			throw new RuntimeException("name不得為空!");
		}
		String password = request.getParameter("password");
		if (StringUtils.isNullOrEmpty(password)) {
			throw new RuntimeException("password不得為空!");
		} else if (password.length() < 6) {
			throw new RuntimeException("password長度必須為6~12位!");
		}
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String birthdayDate = request.getParameter("birthday");
		if (StringUtils.isNullOrEmpty(birthdayDate)) {
			throw new RuntimeException("birthdayDate不得為空!");
		}
		String postalCode = request.getParameter("postalCode");
		String city = request.getParameter("city");
		String district = request.getParameter("district");
		String road = request.getParameter("road");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		if (StringUtils.isNullOrEmpty(phoneNumber)) {
			throw new RuntimeException("phoneNumber不得為空!");
		}
		Timestamp create_time = Timestamp.valueOf(request.getParameter("create_time"));
		Timestamp update_time = Timestamp.valueOf(request.getParameter("update_time"));
		
		Date birthday = Date.valueOf(birthdayDate);
		if (StringUtils.isNullOrEmpty(request.getParameter("age"))) {
			throw new RuntimeException("age不得為空!");
		}
		Integer age = Integer.valueOf(request.getParameter("age"));

		if (phoneNumber.equals(password)) {
			throw new RuntimeException("電話號碼與密碼不可相同!");
		}

		Member member = new Member();
		member.setName(name);
		member.setPassword(password);
		member.setGender(gender);
		member.setEmail(email);
		member.setPostalCode(postalCode);
		member.setCity(city);
		member.setDistrict(district);
		member.setRoad(road);
		member.setAddress(address);
		member.setPhoneNumber(phoneNumber);
		member.setBirthday(birthday);
		member.setAge(age);
		member.setCreate_time(create_time);
		member.setUpdate_time(update_time);
		return member;

	}

}
