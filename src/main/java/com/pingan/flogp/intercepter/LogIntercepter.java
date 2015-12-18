package com.pingan.flogp.intercepter;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.NDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LogIntercepter implements HandlerInterceptor {
	
	private final static Logger logger = Logger.getLogger(LogIntercepter.class);
	
	private static String ipAddress = null;
	
	static {
		try {
			ipAddress = InetAddress.getLocalHost().getHostAddress().toString();
		} catch (UnknownHostException e) {
			logger.warn("Can't get host ip!");
		}
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		NDC.push(ipAddress);
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		NDC.pop();
		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
