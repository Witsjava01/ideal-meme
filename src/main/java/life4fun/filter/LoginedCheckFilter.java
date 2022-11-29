package life4fun.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import life4fun.entity.Member;


/**
 * Servlet Filter implementation class LoginedCheckFilter
 */
@WebFilter(	urlPatterns = {"/login.jsp", "/register.jsp"}, 
initParams = {@WebInitParam(name = "member", value = "member")})
public class LoginedCheckFilter extends HttpFilter implements Filter {
	private String member = "member";
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoginedCheckFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest)request;
		HttpServletResponse httpRes = (HttpServletResponse)response;		
		//強制登入檢查
		HttpSession session = httpReq.getSession();		
		Member memberObj= (Member)session.getAttribute(member);
		if(memberObj==null) { //尚未登入
			chain.doFilter(request, response);
		} else {
			session.setAttribute("login.prev.uri", httpReq.getRequestURI());
			//已登入則強迫轉址給首頁
			httpRes.sendRedirect( httpReq.getContextPath()+"/");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String member = this.getInitParameter("member");
		if(member!=null && member.length()>0) this.member = member;
	}

}
