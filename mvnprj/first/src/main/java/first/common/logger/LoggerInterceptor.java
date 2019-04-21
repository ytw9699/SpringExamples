package first.common.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import first.common.logger.LoggerInterceptor;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);
	
	@Override//컨트롤러전 로그찍자
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("===============        START        ================");
			log.debug(" Request URI \t:  " + request.getRequestURI());
		}
		return super.preHandle(request, response, handler);//return true;
	}
	
	@Override//컨트롤러 처리후
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			ModelAndView modelAndView) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("==============          END         ==============\n");
		}
	}
}
/*public class MeasuringInterceptor extends HandlerInterceptorAdapter{
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
}*/