package life4fun.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import life4fun.entity.Member;
import life4fun.exception.VGBDataInvalidException;
import life4fun.exception.VGBException;
import life4fun.service.IMemberService;
import life4fun.service.impl.MemberServiceImpl;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(urlPatterns="/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errorsList = new ArrayList<>();
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		//1.取得request的Form data(mod10),並檢查之
		String userid=request.getParameter("userid");
		String name=request.getParameter("name");
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String birthday=request.getParameter("birthday");
		String city=request.getParameter("city");
		String district=request.getParameter("district");
		String address=request.getParameter("address");
		String phoneNumber=request.getParameter("phoneNumber");
		String bloodType=request.getParameter("bloodType"); //目前用不到
		String captcha=request.getParameter("captcha");
		//System.out.println(name); //for test
		
		if(userid==null || (userid=userid.trim()).length()==0) {
			errorsList.add("必須輸入帳號");
		}
		
		if(password1==null || password1.length()==0) {
			errorsList.add("必須輸入密碼與確認密碼");
		} 
		
		if (password2==null || !password2.equals(password1)) {
			errorsList.add("必須輸入一致的密碼與確認密碼");
		}
		
		if(name==null || (name=name.trim()).length()==0) {
			errorsList.add("必須輸入姓名");
		}
		
		if(gender==null || (gender=gender.trim()).length()==0) {
			errorsList.add("必須選擇性別");
		}
		
		if(email==null || (email=email.trim()).length()==0) {
			errorsList.add("必須輸入email");
		}

		if(birthday==null || (birthday=birthday.trim()).length()==0) {
			errorsList.add("必須輸入出生日期");
		}
		if(city==null || (city=city.trim()).length()==0) {
			errorsList.add("必須選擇縣/市");
		}
		
		if(district==null || (district=district.trim()).length()==0) {
			errorsList.add("必須選擇區域");
		}
		
		if(captcha==null || (captcha=captcha.trim()).length()==0) {
			errorsList.add("必須輸入驗證碼");
		}else {
			//檢查驗證碼正確與否		
			String oldCaptcha = (String)session.getAttribute("RegisterCaptchaServlet");
			if(!captcha.equalsIgnoreCase(oldCaptcha)){
				errorsList.add("驗證碼不正確");
			}
		}
		session.removeAttribute("RegisterCaptchaServlet");
		
		//2. 若無誤呼叫商業邏輯
		if(errorsList.isEmpty()) {			
			try {
				Member c = new Member();				
				c.setId(userid);
				c.setName(name);
				c.setPassword(password1);
				c.setEmail(email);
				c.setBirthday(birthday);
				c.setGender(gender.charAt(0));
				c.setAddress(city);
				c.setAddress(district);
				c.setAddress(address);
				c.setPhoneNumber(phoneNumber);
				
				IMemberService service = new MemberServiceImpl();
				service.register(c);
				
				request.setAttribute("customer", c);
				//3.1 內部轉交(forward)登入成功網頁(register_ok.jsp), for user, (mod09)				
				RequestDispatcher dispatcher = request.getRequestDispatcher("register_ok.jsp");
				dispatcher.forward(request, response);
				
				return;
			} catch (VGBDataInvalidException e) {
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
		
		//3.2 內部轉交(forward)登入網頁(register.jsp)將錯誤顯示在網頁上,for user (mod09)
		request.setAttribute("error", errorsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
	}

}
