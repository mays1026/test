package org.fh.shop.admin.mays.common;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Servlet Filter implementation class WebContextThreadLocalFilter
 */
@WebFilter(description = "web", urlPatterns = { "/WebContextThreadLocalFilter" })
public class WebContextThreadLocalFilter implements Filter {

    /**
     * Default constructor. 
     */
    public WebContextThreadLocalFilter() {
    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try{
			WebContextThreadLocal.setRequest((HttpServletRequest) request);
			//执行代码逻辑
			chain.doFilter(request, response);
		} finally{
			WebContextThreadLocal.remove();
		}
	}

	/**`
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
