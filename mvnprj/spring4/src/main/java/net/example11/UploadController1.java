package net.example11;
	import java.io.File;
	import java.util.Date;
	import org.springframework.web.multipart.MultipartFile;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
@Controller  
public class UploadController1 {
	
private String uploadPath= "F:\\java\\GitApp\\SpringExamples\\mvnprj\\spring4\\src\\main\\webapp\\WEB-INF\\files\\";
				//경로를 이렇게 정확히 집어넣어야함 마지막 \\
				//request.getSession().getServletContext().getRealPath("/");

@RequestMapping(value = "/example11/submission.do1", method = RequestMethod.GET)
public String form() {
	return "example11/submissionForm";
}

@RequestMapping(value = "/example11/submitReport.do1", method = RequestMethod.POST)
public String submitReport1(
		@RequestParam("studentNumber") String studentNumber,
		@RequestParam("report") MultipartFile report) { 
	printInfo(studentNumber, report);		
	String fileName = report.getOriginalFilename();//업로드한 오리지날 파일이름을 뽑아내고
	File uploadFile = new File(uploadPath + fileName);//이거는 파일 객체를 생성한거지 파일을 진짜 만든게아냐
	//F:\\java\\App\\SpringHello\\WebContent\\files\\fileName
	//File f3 = new File("F:\\io\\test.txt");
	//여기선 파일을만드는게 아니라  이러한 경로를 토대로 "F:\\io\\test.txt"한 객체를 생성한다는거
	if(uploadFile.exists()){//파일이나 디렉토리가 존재하면 true, 아직실제로 파일을 안만들었으니 false인거지
		fileName = new Date().getTime() +"."+ fileName;//new Date().getTime()은 system.currenttimemiseconds롱형의 날짜값을 얻어냄
		uploadFile = new File(uploadPath + fileName);//파일객체를 다시 이름붙여서 생성
	}
	try {
		report.transferTo(uploadFile);//여기가 실제적으로 업로드 해주는곳//실제 파일을 업로드 해준다는것
		//파일 데이터를 내가원하는 디렉토리에 내가원하는 파일명으로 저장한다.
		//MultipartFile을 이전한다 to file객체로
		//FileUtils.copyFile(doc, savedFile);//업로드된 임시파일객체를 원하는 디렉토리에 파일객체로 카피,새로운곳으로 카피대신하는거
	} catch (Exception e) {
		
	}
	return "example11/submissionComplete";
}
	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드 한 파일: "
				+ report.getOriginalFilename());
	}
}


















