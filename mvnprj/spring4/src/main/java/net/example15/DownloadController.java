package net.example15;
	import java.io.File;
	import javax.servlet.http.HttpServletRequest;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;
	
@Controller
public class DownloadController {
	@RequestMapping("/example15/DownloadForm")
	public String download() throws Exception {
	return "example15/DownloadForm";
	}
	
	@RequestMapping("/example15/Download.do")
	public ModelAndView download2(HttpServletRequest request) throws Exception {
		String fileName = request.getParameter("fileName");
		 String path = "G:\\java\\GitApp\\SpringExamples\\mvnprj\\spring4\\src\\main\\webapp\\WEB-INF\\files\\"+fileName;
		File downloadFile = new File(path);
		return new ModelAndView("download", "downloadFile", downloadFile);
	}
}

