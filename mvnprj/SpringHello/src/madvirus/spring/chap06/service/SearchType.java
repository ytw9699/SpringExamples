package madvirus.spring.chap06.service;

	public class SearchType {

		private int code;
		private String text;
	/*	options.add(new SearchType(1, "��ü"));
		options.add(new SearchType(2, "������"));
		options.add(new SearchType(3, "ĳ����"));*/

		public SearchType(int code, String text) {
			this.code = code;
			this.text = text;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

	}