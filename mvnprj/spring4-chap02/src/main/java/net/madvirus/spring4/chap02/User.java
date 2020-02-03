package net.madvirus.spring4.chap02;

public class User {//사용자 정보를 보관하고，암호 일치 여부(matchPasswoixl)와 암호 변경 기능(changePassword)을 제공한다.

	private String id;
	private String password;

	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public boolean matchPassword(String inputPasswd) {//패스워드 체크
		return password.equals(inputPasswd);
	}

	public void changePassword(String oldPassword, String newPassword) {//패스워드 변경
		if (!matchPassword(oldPassword))
			throw new IllegalArgumentException("illegal password");
		
		password = newPassword;
	}
}
