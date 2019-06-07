package net.example11;
import java.io.File;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class UploadController3 {
							
private String uploadPath = "F:\\java\\GitApp\\SpringExamples\\mvnprj\\spring4\\src\\main\\webapp\\WEB-INF\\files\\";
	
								//경로를 이렇게 정확히 집어넣어야함 마지막 \\
@RequestMapping(value = "/example11/submission.do3", method = RequestMethod.GET)
public String form() {
	return "example11/submissionForm";
}
@RequestMapping(value = "/example11/submitReport.do3", method = RequestMethod.POST)
public String submitReport3(ReportCommand reportCommand) {//자바빈에 꽃고서 사용
	MultipartFile report = reportCommand.getReport();
	String studentNumber =  reportCommand.getStudentNumber();
	
	printInfo(studentNumber, report);
	
	String fileName = report.getOriginalFilename();
	
	File uploadFile = new File(uploadPath + fileName);
	if(uploadFile.exists()){
		fileName = new Date().getTime() +"."+ fileName;
		uploadFile = new File(uploadPath + fileName);
	}
	try {
		report.transferTo(uploadFile);
	} catch (Exception e) {
		
	}
	return "example11/submissionComplete";
}
private void printInfo(String studentNumber, MultipartFile report) {
	System.out.println(studentNumber + "가 업로드 한 파일: "
			+ report.getOriginalFilename());
}
}


















