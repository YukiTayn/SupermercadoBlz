package sm.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutInt extends HandlerInterceptorAdapter{

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String uri = request.getRequestURI();
		if(uri.endsWith("sess/form") || uri.contains("resources")) {
			return true;
		}
		
		if(request.getSession().getAttribute("nome") != null) {
			return true;
		}
		
		response.sendRedirect("sess/form");
		return false;
	}
}
