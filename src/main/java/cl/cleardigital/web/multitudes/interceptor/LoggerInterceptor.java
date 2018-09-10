package cl.cleardigital.web.multitudes.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = Logger.getLogger(LoggerInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		LOGGER.info("CONTROLLER - " + request.getMethod() + " " +  request.getRequestURL().toString() + " " + StringUtils.trimToEmpty(request.getQueryString()));	

		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		long startTime = (Long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		LOGGER.info("CONTROLLER - " + request.getMethod() + " " +  request.getRequestURL().toString() + " " + StringUtils.trimToEmpty(request.getQueryString()) + " - " + (endTime - startTime) + " ms");
	}

}