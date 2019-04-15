package madvirus.spring.chap06.controller;
	import java.io.File;
	import java.util.Date;
	import org.springframework.web.multipart.MultipartFile;
	import org.springframework.web.multipart.MultipartHttpServletRequest;
	//파일업로드 관련 상위
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ReportSubmissionController {
							
private String uploadPath = "G:\\java\\GitApp\\SpringExamples\\mvnprj\\SpringHello\\WebContent\\files\\";
								//경로를 이렇게 정확히 집어넣어야함 마지막 \\
	@RequestMapping(value = "/report/submission.do", method = RequestMethod.GET)
	public String form() {
		return "report/submissionForm";
	}//http://localhost:8080/SpringHello/report/submission.do

	@RequestMapping(value = "/report/submitReport1.do", method = RequestMethod.POST)
	public String submitReport1(
		@RequestParam("studentNumber") String studentNumber,
		@RequestParam("report") MultipartFile report) {
	printInfo(studentNumber, report);		
	String fileName = report.getOriginalFilename();//업로드한 파일이름을 뽑아내고
	File uploadFile = new File(uploadPath + fileName);//이거는 파일 객체를 생성한거지 파일을 진짜 만든게아냐
	//G:\\java\\GitApp\\SpringExamples\\mvnprj\\SpringHello\\WebContent\\files\\fileName
	//File f3 = new File("G:\\io\\test.txt");
	//여기선 파일을만드는게 아니라  이러한 경로를 토대로 "G:\\io\\test.txt"한 객체를 생성한다는거
	if(uploadFile.exists()){//파일이나 디렉토리가 이미 존재하면 true, 아직실제로 파일을 안만들었으니 false인거지
		fileName = new Date().getTime() + fileName;//new Date().getTime()
		//system.currenttimemiseconds롱형의 날짜값을 얻어냄
		uploadFile = new File(uploadPath + fileName);//파일객체를 다시 이름붙여서 생성
	}
	try {
		report.transferTo(uploadFile);//여기가 실제적으로 업로드 해주는곳//실제 파일을 업로드 해준다는것
		//파일 데이터를 내가원하는 디렉토리에 내가원하는 파일명으로 저장한다.
		//MultipartFile을 이전한다 to file객체로
		//FileUtils.copyFile(doc, savedFile);//업로드된 임시파일객체를 원하는 디렉토리에 파일객체로 카피,새로운곳으로 카피대신하는거
	} catch (Exception e) {
		
	}
	return "report/submissionComplete";
}
/*	String getName()					파라미터 이름을 구한다.
	----------------------------------------------------------------------------------------------------------------------------------------------------
	String getOriginalFilename()			업로드 한 파일의 이름을 구한다.
	----------------------------------------------------------------------------------------------------------------------------------------------------
	boolean isEmpty()					업로드 한 파일이 존재하지 않을 경우 true를 리턴한다.
	----------------------------------------------------------------------------------------------------------------------------------------------------
	long getSize()						업로드 한 파일의 크기를 구한다.
	----------------------------------------------------------------------------------------------------------------------------------------------------
	byte[] getBytes() 					업로드 한 파일의 데이터를 구한다.
	throws IOException
	----------------------------------------------------------------------------------------------------------------------------------------------------
	InpuStream getInputStream()			업로드 한 파일 데이터를 읽어오는 InputStream을 구한다.
	throws IOException					InputStream의 사용이 끝나면 알맞게 종료해 주어야 한다.
	----------------------------------------------------------------------------------------------------------------------------------------------------
	void transferTo(File dest)			파일 데이터를 내가원하는 디렉토리에 내가원하는 파일명으로 저장한다.
	throws IOEception
*/
	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드 한 파일: "
				+ report.getOriginalFilename());
	}
	@RequestMapping(value = "/report/submitReport2.do", method = RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request) {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		printInfo(studentNumber, report);
		return "report/submissionComplete";
		/*
		 * MultipartRequest Interface가 제공하는 업로드 파일 관련 주요 메서드는 아래와 같다.
		 
		Iterator<String> getFileNames()					업로드 된 파일들의 이름 목록을 제공하는 Iterator를 구한다.
		----------------------------------------------------------------------------------------------------------------------------------------------------------
		MultipartFile getFile(String name)					파라미터 이름이 name인 업로드 파일 정보를 구한다.
		----------------------------------------------------------------------------------------------------------------------------------------------------------
		List<MultipartFile> getFiles(String name)			파라미터 이름이 name인 업로드 파일 정보 목록을 구한다.
		----------------------------------------------------------------------------------------------------------------------------------------------------------
		Map<String, MultipartFile> getFileMap()   			파라미터 이름을 키로 파라미터에 해당하는 파일 정보를 값으로 하는
												Map을 구한다.*/
	}
	/*커맨드 객체를 이용해도 업로드 한 파일을 전달받을 수 있다. 단지 커맨드 Class에 파라미터와 동일한 이름의 MultipartFile 타입
    프로퍼티만 추가해주기만 하면 된다. 예를 들어, 업로드 파일의 파라미터 이름이 "report"인 경우, 다음과 같이 "report" 프로퍼티를
    커맨드 Class에 추가해 주면 된다.*/
	@RequestMapping(value = "/report/submitReport3.do", method = RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand) {
		printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
		return "report/submissionComplete";
	}
	
}











