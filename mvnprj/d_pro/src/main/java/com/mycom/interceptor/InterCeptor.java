package com.mycom.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 
public class InterCeptor extends HandlerInterceptorAdapter {
 
 @Override
 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

  System.out.println("Interceptor : PreHandle");
  
  // Session userid check
  HttpSession session = request.getSession();   
  String userid = (String) session.getAttribute("session_member_id");
  
	  // Login false
	  if(userid == null){
		  response.sendRedirect("/pet/main.dog");
	 		return false;
	  }else if(userid.equals("admin")){
		  
	 		return super.preHandle(request, response, handler);
	 		
	  }
	  else{
	 		response.sendRedirect("/pet/main.dog");
	   		return false;
	  }
  
 }
}