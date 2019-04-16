package madvirus.spring.chap07.view;
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
	
public class DownloadView extends AbstractView {//AbstractView�� ���
	public DownloadView() {//������
		setContentType("application/download; charset=utf-8");
		//�ٿ�ε� ������ Ÿ������ application/download ���ڵ��� utf-8
	}
	@Override//������ �ٿ�ε�������  renderMergedOutputModel �޼ҵ� �������̵忡�� ó��
	//����ü � �並 ���� ������ ��ų������ ���� �ڵ�
	protected void renderMergedOutputModel(Map<String, Object> model,//ModelAndView�� ���⼭ �������������� �޴µ� MAP�� �ֻ���
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		File file = (File) model.get("downloadFile");//�ٿ�ε��� ���ϰ�ü
		//return new ModelAndView("download", "downloadFile", downloadFile);
		//System.out.println(getContentType());//application/download; charset=utf-8
		response.setContentType(getContentType());//���������� ����//�ٿ�ε�Ÿ���̾���ϴϱ�
		//System.out.println(file.length());//14
		response.setContentLength((int) file.length());//���� ũ�⼳��

		String userAgent = request.getHeader("User-Agent");
		boolean ie = userAgent.indexOf("MSIE") > -1;//MSIE�� 0��°�������� 0�������Ѵ� //M�� ������ġ
		//���⼭�� ���� ������ �༭ �������� ���ͳ� �ͽ��÷ξ����� �׿��ǰ͵����� �����ؼ� �ٿ�ε�ǰԲ�
		String fileName = null;
		if (ie) {
			fileName = URLEncoder.encode(file.getName(), "UTF-8");
			//�����̸� ������ �ȱ����Բ� ���ִ��۾��� �ϰ�,����.TXT�Ӽ������� UTF-8�θ��������
		} else {
			fileName = new String(file.getName().getBytes("UTF-8"),
					"iso-8859-1");
		}
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ fileName + "\";");//�ٿ�ε��Ҷ��� �����̸������� ������Ѵ�!
		response.setHeader("Content-Transfer-Encoding", "binary");//���ڵ�����
		OutputStream out = response.getOutputStream();//�ƿ�ǲ��Ʈ����ü����
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);//��ǲ��Ʈ����ü����
			//�ٿ�ε��� ���ϰ�ü�� �о�鿩�� response��ü�� �̿��ؼ� ���°� Ŭ���̾�Ʈ�ʿ�
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
