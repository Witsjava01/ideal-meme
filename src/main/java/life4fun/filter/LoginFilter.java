package life4fun.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import life4fun.enumerate.LoginFilterVaildate;

@WebFilter("/*")
public class LoginFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 2165570948201553851L;
	
	private List<LoginFilterVaildate> needLogin = Arrays.asList(LoginFilterVaildate.values());
	
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//List<LoginFilterVaildate> list = needLogin.stream().filter(v -> request.getPathInfo().startsWith(v.getPath())).collect(Collectors.toList());
		
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
