package org.zerock.security;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.core.userdetails.UsernameNotFoundException;
	import org.zerock.domain.MemberVO;
	import org.zerock.mapper.MemberMapper;
	import org.zerock.security.domain.CustomUser;
	import lombok.Setter;
	import lombok.extern.log4j.Log4j;
@Log4j
public class CustomUserDetailsService implements UserDetailsService {	
	/* 스프링 시큐리티에서 username이라고 부르는 사용자의 정보만을 이용하
	 기 때문에 실제 프로젝트에서 사용자의 이름이나 이메일 등의 자세한 정보를 이용할 경우
	 에는 충분하지 못하다는 단점 .
	 이러한 문제를 해결하기 위해서는 직접 UserDetailsService를 구현하는 방식을 이용하
	 는 것이 좋다. 흔히 커스텀 UserDetailsServcie라고 하는데，이를 이용하면 원하는
	 객체를 인증과 권한 체크에 활용할수 있기 때문에 많이 사용*/
	@Setter(onMethod_ = { @Autowired })
	private MemberMapper memberMapper;

	@Override//661페이지,665,669
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		log.warn("Load User By UserName : " + userName);
 
		// userName means userid
		MemberVO vo = memberMapper.read(userName);
		//MemberVO vo = memberMapper.read(userName);//만약 이부분에서 아이디가 아닌 다른 이메일등으로 vo를 가져올수도 있는듯
		

		log.warn("queried by member mapper: " + vo);

		return vo == null ? null : new CustomUser(vo);
	} 
}
