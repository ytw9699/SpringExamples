package madvirus.spring.chap07.controller;
import java.io.File;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.context.ApplicationContextAware;

@Controller
public class DownloadController implements ApplicationContextAware {
	//String path = context.getServletContext().getRealPath("/WEB-INF/설명.txt");이거안쓸거면 ApplicationContextAware
	//이거 구현안해도됨
	private WebApplicationContext context = null;

	@RequestMapping("/file")
	public ModelAndView download() throws Exception {
		File downloadFile = getFile();
		return new ModelAndView("download", "downloadFile", downloadFile);
	}//<bean id="viewResolver" class="org.springframework.web.servlet.view.BeanNameViewResolver"/>
	//결론은 "viewResolver"가 "download"라는 뷰를 찾은거,이뷰를 실행시켜서 다운로드가 됨
	//<bean id="download" class="madvirus.spring.chap07.view.DownloadView"/>
	//결국 컨트롤러의 실행결과는 DownloadView클래스의 객체다

	private File getFile() {
String path = context.getServletContext().getRealPath("/WEB-INF/설명.txt");
//이경로를 그냥 C드라이브 부터 설정해줘도 됨
//System.out.println(path);
//D:\APP\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringView\WEB-INF\설명.txt
//private String realPath = getClass().getResource("/").getPath().substring(0, (getClass().getResource("/").getPath()).indexOf(".metadata"))+"/SQUARE/WebContent/static/img/profile_img/";
//D:\APP\SQUARE\src\mypage\modify.java 이것과 같다고봄
return new File(path);
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
		this.context = (WebApplicationContext) applicationContext;//이미 상속받은쪽에서 주입을 받아논거라 따로설정안해도됨
	}
}

