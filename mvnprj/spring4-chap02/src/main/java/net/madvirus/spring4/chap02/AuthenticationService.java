package net.madvirus.spring4.chap02;

public class AuthenticationService {
//아이디,암호를 입력받아 인증을 수행한다. UserRepository로부터 User 객체를 구한 뒤
//User 객체의 matchPassword 메서드를 이용해서 아이디/암호 일치 여부를 판단한다.
//아이디,암호가 일치하지 않을 경우 AuthFailLogger의	insertBadPw 메서드를 실행해서 실패 기록을 남긴다
	private UserRepository userRepository;
	private AuthFailLogger failLogger;

	public AuthInfo authenticate(String id, String password) {
		
		User user = userRepository.findUserById(id);
		
		if (user == null) {
			System.out.println("id가 없습니다");
			throw new UserNotFoundException();
		}
		if (!user.matchPassword(password)) {//패스워드가 틀리면
			failLogger.insertBadPw(id, password);
			throw new AuthException();
		}
		if (user.matchPassword(password)) {
			System.out.println("로그인에 성공했습니다");
		}

		return new AuthInfo(user.getId());
	}

	public void setUserRepository(UserRepository userRepository) {//이런게 di설정
		this.userRepository = userRepository;
	}

	public void setFailLogger(AuthFailLogger failLogger) {//이런게 di설정
		this.failLogger = failLogger;
	}
}
