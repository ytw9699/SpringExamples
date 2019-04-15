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
	//String path = context.getServletContext().getRealPath("/WEB-INF/����.txt");�̰žȾ��Ÿ� ApplicationContextAware
	//�̰� �������ص���
	private WebApplicationContext context = null;

	@RequestMapping("/file")
	public ModelAndView download() throws Exception {
		File downloadFile = getFile();
		return new ModelAndView("download", "downloadFile", downloadFile);
	}//<bean id="viewResolver" class="org.springframework.web.servlet.view.BeanNameViewResolver"/>
	//����� "viewResolver"�� "download"��� �並 ã����,�̺並 ������Ѽ� �ٿ�ε尡 ��
	//<bean id="download" class="madvirus.spring.chap07.view.DownloadView"/>
	//�ᱹ ��Ʈ�ѷ��� �������� DownloadViewŬ������ ��ü��

	private File getFile() {
String path = context.getServletContext().getRealPath("/WEB-INF/����.txt");
//�̰�θ� �׳� C����̺� ���� �������൵ ��
//System.out.println(path);
//D:\APP\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringView\WEB-INF\����.txt
//private String realPath = getClass().getResource("/").getPath().substring(0, (getClass().getResource("/").getPath()).indexOf(".metadata"))+"/SQUARE/WebContent/static/img/profile_img/";
//D:\APP\SQUARE\src\mypage\modify.java �̰Ͱ� ���ٰ�
return new File(path);
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
		this.context = (WebApplicationContext) applicationContext;//�̹� ��ӹ����ʿ��� ������ �޾Ƴ�Ŷ� ���μ������ص���
	}
}

