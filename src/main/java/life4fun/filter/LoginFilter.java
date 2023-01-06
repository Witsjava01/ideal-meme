package life4fun.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import life4fun.enumerate.LoginFilterValidate;
import life4fun.servlet.MemberServlet;
import life4fun.utils.ApplicationUtils;
import life4fun.utils.ConstantUtils;

@WebFilter("/*")
public class LoginFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 2165570948201553851L;
	//建立一個List是LoginFiltervalidate型別
	private List<LoginFilterValidate> needLogin = Arrays.asList(LoginFilterValidate.values());

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//servlet=/TestServlet
		String servlet = request.getRequestURI().replaceAll(request.getContextPath(), "");
		//list=TEST_TEST("/TestServlet", new KeyValue<String, String>("method1", "test"))
		List<LoginFilterValidate> list = needLogin.stream().filter(v -> v.getPath().equals(servlet))
				.collect(Collectors.toList());
		
		for (LoginFilterValidate validate : list) {
			//validate的"test" equals 請求參數(method1)的值
			if (validate.getParam().getValue().equals(request.getParameter(validate.getParam().getKey()))
					//請求時的Session裡的Attribute叫做LOGIN_MEMBER_ID的不能是null
					&& request.getSession().getAttribute(ConstantUtils.LOGIN_MEMBER_ID) == null) {
				//給前端JS_SOURCE跟STATIC_SOURCE的值 再導到login.jsp 
				request.setCharacterEncoding("UTF-8");
				request.setAttribute(ApplicationUtils.JS_SOURCE_KEY, MemberServlet.JS_SOURCE);
				request.setAttribute(ApplicationUtils.STATIC_SOURCE_KEY, MemberServlet.STATIC_SOURCE);
				request.getRequestDispatcher(MemberServlet.JSP_SOURCE + "login.jsp").forward(request, response);
				return;
			}
		}

		chain.doFilter(request, response);
	}

	public LoginFilter() {
		super();
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
