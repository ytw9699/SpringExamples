package net.example15;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.OutputStream;
	import java.net.URLEncoder;
	import java.util.Map;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.springframework.util.FileCopyUtils;
	import org.springframework.web.servlet.view.AbstractView;
												//직접 뷰를 만드는것
public class DownloadView extends AbstractView {//AbstractView를 상속
	public DownloadView() {//생성자
		setContentType("application/download; charset=utf-8");
		//다운로드 컨텐츠 타입으로 application/download 인코딩은 utf-8
	}
	@Override//무엇을 다운로드할지를  renderMergedOutputModel 메소드 오버라이드에서 처리
	//도대체 어떤 뷰를 만들어서 동작을 시킬건지에 대한 코드
	protected void renderMergedOutputModel(Map<String, Object> model,//ModelAndView를 여기서 다형성개념으로 받는듯 MAP이 최상위
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		File file = (File) model.get("downloadFile");//다운로드할 파일객체
		//return new ModelAndView("download", "downloadFile", downloadFile);
		//System.out.println(getContentType());//application/download; charset=utf-8
		response.setContentType(getContentType());//리스폰스에 설정//다운로드타입이어야하니까
		//System.out.println(file.length());//14
		response.setContentLength((int) file.length());//파일 크기설정

		String userAgent = request.getHeader("User-Agent");
		boolean ie = userAgent.indexOf("MSIE") > -1;//MSIE가 0번째에있으면 0을리턴한다 //M의 시작위치
		//여기서는 굳이 조건을 줘서 브라우저가 인터넷 익스플로어인지 그외의것들인지 구분해서 다운로드되게끔
		String fileName = null;
		if (ie) {
			fileName = URLEncoder.encode(file.getName(), "UTF-8");
			//파일이름 꺼내서 안깨지게끔 해주는작업도 하고,설명.TXT속성에서도 UTF-8로맞춰줘야함
		} else {
			fileName = new String(file.getName().getBytes("UTF-8"),
					"iso-8859-1");
		}
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ fileName + "\";");//다운로드할때의 파일이름설정을 해줘야한다!
		response.setHeader("Content-Transfer-Encoding", "binary");//전송되는 데이터의  인코딩이 바이너리 타입이다.
		OutputStream out = response.getOutputStream();//아웃풋스트림객체얻어내고
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);//인풋스트림객체얻어내서
			//다운로드할 파일객체를 읽어들여서 response객체로 이용해서 쓰는거 클라이언트쪽에
			FileCopyUtils.copy(fis, out);
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException ex) {
				}
		}
		out.flush();
	}
}