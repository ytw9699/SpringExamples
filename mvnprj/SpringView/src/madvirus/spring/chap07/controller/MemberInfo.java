package madvirus.spring.chap07.controller;

	public class MemberInfo {

		private String userId;
		private String name;
		private Address address;
		private String[] favorites;
		private String jobCode;
		private String tool;
		private String etc;
		private boolean contractAgreement;

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public String[] getFavorites() {
			return favorites;
		}

		public void setFavorites(String[] favorates) {
			this.favorites = favorates;
		}

		public String getJobCode() {
			return jobCode;
		}

		public void setJobCode(String jobCode) {
			this.jobCode = jobCode;
		}

		public String getTool() {
			return tool;
		}

		public void setTool(String tool) {
			this.tool = tool;
		}

		public String getEtc() {
			return etc;
		}

		public void setEtc(String etc) {
			this.etc = etc;
		}

		public boolean isContractAgreement() {
			return contractAgreement;
		}

		public void setContractAgreement(boolean contractAgreement) {
			this.contractAgreement = contractAgreement;
		}

	}