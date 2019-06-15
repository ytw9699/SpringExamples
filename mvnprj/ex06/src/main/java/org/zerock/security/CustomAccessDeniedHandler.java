package org.zerock.security;
	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.springframework.security.access.AccessDeniedException;
	import org.springframework.security.web.access.AccessDeniedHandler;
	import lombok.extern.log4j.Log4j;

@Log4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
					//AccessDeniedHandler 인터페이스를 직접구현
  @Override
  public void handle(HttpServletRequest request, 
      HttpServletResponse response, AccessDeniedException accessException)
      throws IOException, ServletException {
	  /*인터페이스의 메서드는 handle() 뿐이고 HttpServletRequest，
	  HttpServletResponse를 파라미터로 사용하기 때문에 직접적으로 서블릿 API를 이용
	  하는 처리가 가능하다는 차이가 있다.*/
    log.error("Access Denied Handler");

    log.error("Redirect....");

    response.sendRedirect("/accessError"); // 접근 제한에 걸리는 경우 리다이렉트 하는 방식으로 동작
  }
}
/*security-context.xml에서는 error-page 속성 대신에 CustxDmAccessDeniedHandler 를 빈으로 등록해서 사용*/
