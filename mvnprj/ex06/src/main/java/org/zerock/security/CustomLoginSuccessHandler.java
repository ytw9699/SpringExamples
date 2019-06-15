package org.zerock.security;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.springframework.security.core.Authentication;
	import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
	import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {

		log.warn("Login Success");

		List<String> roleNames = new ArrayList<>();

		auth.getAuthorities().forEach(authority -> {

				roleNames.add(authority.getAuthority());//반복해서 추가해주고
			});
		
			log.warn("ROLE NAMES: " + roleNames);// 사용자에 부뎌된 권한 Authentication 객체를 이용해서 사용자가 가진 모든 권한을 문자열로 저장해둠

			if (roleNames.contains("ROLE_ADMIN")) {//그후 체크한다
	
				response.sendRedirect("/sample/admin");
				return;
			}
			if (roleNames.contains("ROLE_MEMBER")) {
	
				response.sendRedirect("/sample/member");
				return;
			}
			
		response.sendRedirect("/");
	}
}


