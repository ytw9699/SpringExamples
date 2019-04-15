package madvirus.spring.chap07.controller;

	public class AuthenticationException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public AuthenticationException(String message) {
			super(message);
		}

	}