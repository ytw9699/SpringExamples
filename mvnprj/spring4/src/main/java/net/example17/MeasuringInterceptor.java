package net.example17;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MeasuringInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, //오버라이드 요청을 가로채서 컨트롤러까지 일단 요청 못들어감
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("인터셉터 정상동작");
	return true;
	}
	@Override
	public void postHandle(HttpServletRequest request,//클라이언트의 요청을 가로채되 컨트롤러 처리 후 하는작업들
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
}
