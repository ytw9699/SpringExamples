package madvirus.spring.chap06.controller;
	import java.io.File;
	import java.util.Date;
	import org.springframework.web.multipart.MultipartFile;
	import org.springframework.web.multipart.MultipartHttpServletRequest;
	//���Ͼ��ε� ���� ����
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ReportSubmissionController {
							
private String uploadPath = "G:\\java\\GitApp\\SpringExamples\\mvnprj\\SpringHello\\WebContent\\files\\";
								//��θ� �̷��� ��Ȯ�� ����־���� ������ \\
	@RequestMapping(value = "/report/submission.do", method = RequestMethod.GET)
	public String form() {
		return "report/submissionForm";
	}//http://localhost:8080/SpringHello/report/submission.do

	@RequestMapping(value = "/report/submitReport1.do", method = RequestMethod.POST)
	public String submitReport1(
		@RequestParam("studentNumber") String studentNumber,
		@RequestParam("report") MultipartFile report) {
	printInfo(studentNumber, report);		
	String fileName = report.getOriginalFilename();//���ε��� �����̸��� �̾Ƴ���
	File uploadFile = new File(uploadPath + fileName);//�̰Ŵ� ���� ��ü�� �����Ѱ��� ������ ��¥ ����ԾƳ�
	//G:\\java\\GitApp\\SpringExamples\\mvnprj\\SpringHello\\WebContent\\files\\fileName
	//File f3 = new File("G:\\io\\test.txt");
	//���⼱ ����������°� �ƴ϶�  �̷��� ��θ� ���� "G:\\io\\test.txt"�� ��ü�� �����Ѵٴ°�
	if(uploadFile.exists()){//�����̳� ���丮�� �̹� �����ϸ� true, ���������� ������ �ȸ�������� false�ΰ���
		fileName = new Date().getTime() + fileName;//new Date().getTime()
		//system.currenttimemiseconds������ ��¥���� ��
		uploadFile = new File(uploadPath + fileName);//���ϰ�ü�� �ٽ� �̸��ٿ��� ����
	}
	try {
		report.transferTo(uploadFile);//���Ⱑ ���������� ���ε� ���ִ°�//���� ������ ���ε� ���شٴ°�
		//���� �����͸� �������ϴ� ���丮�� �������ϴ� ���ϸ����� �����Ѵ�.
		//MultipartFile�� �����Ѵ� to file��ü��
		//FileUtils.copyFile(doc, savedFile);//���ε�� �ӽ����ϰ�ü�� ���ϴ� ���丮�� ���ϰ�ü�� ī��,���ο������ ī�Ǵ���ϴ°�
	} catch (Exception e) {
		
	}
	return "report/submissionComplete";
}
/*	String getName()					�Ķ���� �̸��� ���Ѵ�.
	----------------------------------------------------------------------------------------------------------------------------------------------------
	String getOriginalFilename()			���ε� �� ������ �̸��� ���Ѵ�.
	----------------------------------------------------------------------------------------------------------------------------------------------------
	boolean isEmpty()					���ε� �� ������ �������� ���� ��� true�� �����Ѵ�.
	----------------------------------------------------------------------------------------------------------------------------------------------------
	long getSize()						���ε� �� ������ ũ�⸦ ���Ѵ�.
	----------------------------------------------------------------------------------------------------------------------------------------------------
	byte[] getBytes() 					���ε� �� ������ �����͸� ���Ѵ�.
	throws IOException
	----------------------------------------------------------------------------------------------------------------------------------------------------
	InpuStream getInputStream()			���ε� �� ���� �����͸� �о���� InputStream�� ���Ѵ�.
	throws IOException					InputStream�� ����� ������ �˸°� ������ �־�� �Ѵ�.
	----------------------------------------------------------------------------------------------------------------------------------------------------
	void transferTo(File dest)			���� �����͸� �������ϴ� ���丮�� �������ϴ� ���ϸ����� �����Ѵ�.
	throws IOEception
*/
	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "�� ���ε� �� ����: "
				+ report.getOriginalFilename());
	}
	@RequestMapping(value = "/report/submitReport2.do", method = RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request) {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		printInfo(studentNumber, report);
		return "report/submissionComplete";
		/*
		 * MultipartRequest Interface�� �����ϴ� ���ε� ���� ���� �ֿ� �޼���� �Ʒ��� ����.
		 
		Iterator<String> getFileNames()					���ε� �� ���ϵ��� �̸� ����� �����ϴ� Iterator�� ���Ѵ�.
		----------------------------------------------------------------------------------------------------------------------------------------------------------
		MultipartFile getFile(String name)					�Ķ���� �̸��� name�� ���ε� ���� ������ ���Ѵ�.
		----------------------------------------------------------------------------------------------------------------------------------------------------------
		List<MultipartFile> getFiles(String name)			�Ķ���� �̸��� name�� ���ε� ���� ���� ����� ���Ѵ�.
		----------------------------------------------------------------------------------------------------------------------------------------------------------
		Map<String, MultipartFile> getFileMap()   			�Ķ���� �̸��� Ű�� �Ķ���Ϳ� �ش��ϴ� ���� ������ ������ �ϴ�
												Map�� ���Ѵ�.*/
	}
	/*Ŀ�ǵ� ��ü�� �̿��ص� ���ε� �� ������ ���޹��� �� �ִ�. ���� Ŀ�ǵ� Class�� �Ķ���Ϳ� ������ �̸��� MultipartFile Ÿ��
    ������Ƽ�� �߰����ֱ⸸ �ϸ� �ȴ�. ���� ���, ���ε� ������ �Ķ���� �̸��� "report"�� ���, ������ ���� "report" ������Ƽ��
    Ŀ�ǵ� Class�� �߰��� �ָ� �ȴ�.*/
	@RequestMapping(value = "/report/submitReport3.do", method = RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand) {
		printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
		return "report/submissionComplete";
	}
	
}











