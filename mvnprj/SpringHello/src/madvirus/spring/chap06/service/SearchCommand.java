package madvirus.spring.chap06.service;
public class SearchCommand {

		private String type;
		private String query;
		private int page;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getQuery() {
			return query;
		}

		public void setQuery(String query) {
			this.query = query;
		}

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

	}