package madvirus.spring.chap06.controller;

import org.springframework.web.multipart.MultipartFile;

public class ReportCommand {

	private String studentNumber;
	private MultipartFile report;

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public MultipartFile getReport() {
		return report;
	}

	public void setReport(MultipartFile report) {
		this.report = report;
	}

}
