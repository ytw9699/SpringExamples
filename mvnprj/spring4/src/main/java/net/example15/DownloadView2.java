package net.example15;
	import java.io.IOException;
	import java.io.OutputStream;
	import java.util.Map;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.springframework.web.servlet.view.AbstractView;
	import com.amazonaws.regions.Regions;
	import com.amazonaws.services.s3.AmazonS3;
	import com.amazonaws.services.s3.AmazonS3ClientBuilder;
	import com.amazonaws.services.s3.model.S3Object;
	import com.amazonaws.services.s3.model.S3ObjectInputStream;
												
public class DownloadView2 extends AbstractView {//AbstractView를 상속
	
	public DownloadView2() {//생성자
		setContentType("application/download; charset=utf-8");
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		final AmazonS3 s3 = AmazonS3ClientBuilder.
									   standard().
			   withRegion(Regions.AP_NORTHEAST_2).
										  build();
			
		String bucket_name = "picksell-bucket";
		String folder_name = "/upload";
		String fileName = (String)model.get("fileName");
		
		try {
		
			S3Object s3Object = s3.getObject(bucket_name + folder_name, fileName);
			
			response.setContentType(getContentType());//리스폰스에 설정//다운로드타입이어야하니까
			
			response.setContentLength((int)s3Object.getObjectMetadata().getContentLength());//파일 크기설정

			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");//다운로드할때의 파일이름설정을 해줘야한다!
			
			response.setHeader("Content-Transfer-Encoding", "binary");//인코딩설정
			
			S3ObjectInputStream s3ObjectInputStream = s3Object.getObjectContent();
			
			OutputStream out = response.getOutputStream();//아웃풋스트림객체얻어내고
			
			byte[] bytesArray = new byte[4096];
			
			int bytesRead = -1;
			
			while ((bytesRead = s3ObjectInputStream.read(bytesArray)) != -1) {
				out.write(bytesArray, 0, bytesRead);
			}
			
			out.close();
			s3ObjectInputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}