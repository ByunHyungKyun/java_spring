package com.spring.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PostIntercepter extends HandlerInterceptorAdapter {

	
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String turn = (String)modelAndView.getModel().get("turn");
		
		
		
		
		if(!(turn == null || turn.isEmpty())) {
			modelAndView.setViewName(turn);
		}
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
}
