package life4fun.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import life4fun.dto.RequestResult;
import life4fun.dto.ServiceResult;
import life4fun.entity.Member;
import life4fun.service.LoginService;
import life4fun.service.StreetNameService;
import life4fun.service.impl.LoginServiceImpl;
import life4fun.service.impl.StreetNameServiceImpl;
import life4fun.utils.ApplicationUtils;
import life4fun.utils.JsonUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JSP_SOURCE = "/jsp/member/";
	private static final String JS_SOURCE = "/js/member/";
	private static final String STATIC_SOURCE = "static";
	
	private LoginService loginService = new LoginServiceImpl();
	private StreetNameService streetNameService = new StreetNameServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(ApplicationUtils.JSP_SOURCE_KEY, JSP_SOURCE);
		request.setAttribute(ApplicationUtils.JS_SOURCE_KEY, JS_SOURCE);
		request.setAttribute(ApplicationUtils.STATIC_SOURCE_KEY, STATIC_SOURCE);
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method") == null ? "login" : request.getParameter("method");
		System.out.println("method -> " + method);
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
		case "login":
		default:
			login(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(JSP_SOURCE + "login.jsp").forward(request, response);
	}
	
	public void member(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("isUpdate", true);
		request.setAttribute("streetNameList",streetNameService.findAllStreetName().getData());
		request.getRequestDispatcher(JSP_SOURCE + "member.jsp").forward(request, response);
	}
	
	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("isUpdate", false);
		request.setAttribute("streetNameList",streetNameService.findAllStreetName().getData());
		request.getRequestDispatcher(JSP_SOURCE + "member.jsp").forward(request, response);
	}
	
	protected void findMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String phoneNumber = request.getParameter("account");
			String password = request.getParameter("password");
			// 要加參數驗證

			ServiceResult<Member> queryResult = loginService.findMember(phoneNumber, password);

			response.setCharacterEncoding(StandardCharsets.UTF_8.name());
			if (queryResult.getMsg() != null) {
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail(queryResult.getMsg())));
				return;
			} else if (queryResult.getData() == null) {
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.fail("查無此用戶!")));
				return;
			} else {
				System.out.println("findMember_resultList:" + JsonUtils.getGson().toJson(queryResult));
				request.getSession().setAttribute("account", queryResult.getData());
				response.getWriter().append(JsonUtils.getGson().toJson(RequestResult.success(queryResult.getData())));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage()); //這行在正式代碼要用logger
			// 這邊response要return 500給client
			// TODO: handle exception
		}
	}

}
