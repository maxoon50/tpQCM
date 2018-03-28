package tpQCM.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/*" })
public class SessionFilter implements Filter {


	/**
	 *  Méthode qui va filtrer toutes les url => renverra sur login si /login ou si pas d'attribut user dans session
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
	
		if(req.getServletPath().toLowerCase().contains("login")) {
			chain.doFilter(request, response);	
		}else if(session.getAttribute("user") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/login.jsp");
			rd.forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
	}

    public SessionFilter() {
    }


	public void destroy() {
	}
	
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
