package net.madvirus.spring4.chap02;

public class AuthenticationService {

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
