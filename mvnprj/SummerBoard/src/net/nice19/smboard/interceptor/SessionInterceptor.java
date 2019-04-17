package net.nice19.smboard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, //오버라이드 요청을 가로채서 컨트롤러까지 일단 요청 못들어감
			HttpServletResponse response, Object handler) throws Exception {
		// check variable
		Object userId = request.getSession().getAttribute("userId");
		//세션영역에서 값을가져옴 로그인이 됬으면 값이 저장되고 안되면 null
		//System.out.println(request.getRequestURI());
// pass through when access login.do, join.do
if(request.getRequestURI().equals("/SummerBoard/login.do") || request.getRequestURI().equals("/SummerBoard/member/join.do")){
	//클라이언트가 요청을 이렇게 했으면
	
	if(userId != null){//로그인했다면
		response.sendRedirect(request.getContextPath() + "/board/list.do");//리다이렉트 
		return true;//request.getContextPath() == /SummerBoard
	} else {
		return true;//여기 투르 맞음!왜냐면 http://localhost:8080/SummerBoard/member/join.do라고 했을때 true주고 컨트롤러 찾아야해서
	}
}//여기서 if문끝 구분잘해야함 
		// where other pages		
		if(userId == null){//로그인안하면
			response.sendRedirect(request.getContextPath() + "/login.do");//무조건 로그인으로 넘어가게하라고
			//인터셉터로 이러한것들을 만드는거
			return false;
		} else {
			return true;
		}
	}//preHandle메소드끝
	@Override
	public void postHandle(HttpServletRequest request,//클라이언트의 요청을 가로채되 컨트롤러 처리 후 하는작업들
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
}
