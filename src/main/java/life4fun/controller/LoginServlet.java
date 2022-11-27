package life4fun.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import life4fun.entity.Member;
import life4fun.exception.LoginFailedException;
import life4fun.exception.VGBException;
import life4fun.service.IMemberService;
import life4fun.service.MemberService;
import uuu.vgb.controller.RequestDispatcher;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMemberService service = new MemberService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errorsList = new ArrayList<>();
		HttpSession session = request.getSession();
		String phoneNumber = request.getParameter("phoneNumber");
		String password = request.getParameter("password");
		String captcha = request.getParameter("captcha");
		if(phoneNumber==null || (phoneNumber=phoneNumber.trim()).length()==0) {
			errorsList.add("必須輸入帳號");
		}
		
		if(password==null || password.length()==0) {
			errorsList.add("必須輸入密碼");
		}
		
		if(captcha==null || (captcha=captcha.trim()).length()==0) {
			errorsList.add("必須輸入驗證碼");
		}else {
			String oldCaptcha = (String)session.getAttribute("LoginCaptchaServlet");
			if(!captcha.equalsIgnoreCase(oldCaptcha)){
				errorsList.add("驗證碼不正確");
			}
		}
		session.removeAttribute("LoginCaptchaServlet");
		if(errorsList.isEmpty()) {
			
			try {
				Member c = service.login(phoneNumber, password);
				//session.setMaxInactiveInterval(30); //30 sec., 不要隨便uncomment
				session.setAttribute("member", c);
				
				String prevURI = (String)session.getAttribute("login.prev.uri");
				session.removeAttribute("login.prev.uri");
				if(prevURI!=null) request.setAttribute("login.prev.uri", prevURI);
				//3.1 內部轉交(forward)登入成功網頁(login_ok.jsp), for user, (mod09) 			
				request.getRequestDispatcher("/login_ok.jsp").forward(request, response);
				
				//3.1 外部轉址(redirect)首頁, for user, (mod15)			
				//response.sendRedirect(request.getContextPath());				
				return;
			} catch (LoginFailedException e) {
				errorsList.add(e.getMessage());    //for user
			} catch (VGBException e) {			
				//將商業邏輯log在console
				this.log(e.getMessage(), e);		//for admin				
				errorsList.add(e.getMessage()+",請聯絡管理人員"); //for user, 
			} catch(Exception e) {
				this.log("系統發生錯誤", e);		//for admin
				errorsList.add("系統發生錯誤:" + e.toString());	  //for user		
			}
		}
		request.setAttribute("error", errorsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);	
		//doGet(request, response);
	}

}
