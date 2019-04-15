package madvirus.spring.chap07.controller;

	public class MockAuthenticator implements Authenticator {

		@Override
		public void authenticate(String id, String password) {//모델단
			if (!id.equals("madvirus")) {//아이디는 반드시 madvirus여야한다
				throw new AuthenticationException("invalid id "+id);
			}
		}

	}