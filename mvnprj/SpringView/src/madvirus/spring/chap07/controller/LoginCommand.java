package madvirus.spring.chap07.controller;

	public class LoginCommand {

		private String id;
		private String password;
		private String loginType;

		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getLoginType() {
			return loginType;
		}

		public void setLoginType(String loginType) {
			this.loginType = loginType;
		}

	}