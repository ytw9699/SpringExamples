package net.madvirus.spring4.chap02;

public class PasswordChangeService {

	private UserRepository userRepository;

	public PasswordChangeService(UserRepository userRepository) {//생성자통해서도 설정해보자 다양하게
		this.userRepository = userRepository;
	}

	public void changePassword(String userId, String oldPw, String newPw) {
		User user = userRepository.findUserById(userId);
		if (user == null)
			throw new UserNotFoundException();

		user.changePassword(oldPw, newPw);
		System.out.println(userId+"아이디의 비밀번호를"+newPw+"로 변경했습니다");
	}

}
