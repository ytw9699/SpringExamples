package madvirus.spring.chap07.controller;

	public class MockAuthenticator implements Authenticator {

		@Override
		public void authenticate(String id, String password) {//�𵨴�
			if (!id.equals("madvirus")) {//���̵�� �ݵ�� madvirus�����Ѵ�
				throw new AuthenticationException("invalid id "+id);
			}
		}

	}