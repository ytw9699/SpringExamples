package madvirus.spring.chap07.controller;

	public interface Authenticator {//인터페이스를 만드는게 기능을 추가해갈수있다
		void authenticate(String id, String password);
	}

