package org.zerock.controller;
	import java.io.File;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.UnsupportedEncodingException;
	import java.net.URLDecoder;
	import java.net.URLEncoder;
	import java.nio.file.Files;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;
	import java.util.UUID;
	import org.springframework.core.io.FileSystemResource;
	import org.springframework.core.io.Resource;
	import org.springframework.http.HttpHeaders;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.MediaType;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.util.FileCopyUtils;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestHeader;
	import org.springframework.web.bind.annotation.ResponseBody;
	import org.springframework.web.multipart.MultipartFile;
	import org.zerock.domain.AttachFileDTO;
	import lombok.extern.log4j.Log4j;
	import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadForm() {

		log.info("upload form");
	}

	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {

		String uploadFolder = "C:\\upload";

		for (MultipartFile multipartFile : uploadFile) {

			log.info("-------------------------------------");
			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size: " + multipartFile.getSize());

			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());

			try {
				multipartFile.transferTo(saveFile);//업로드되는 파일저장
			} catch (Exception e) {
				log.error(e.getMessage());
			} // end catch
		} // end for

	}

	@GetMapping("/uploadAjax")
	public void uploadAjax() {

		log.info("upload ajax");
	}
	@GetMapping("/uploadAjax2")
	public void uploadAjax2() {

		log.info("upload ajax2");
	}
	@GetMapping("/uploadAjax3")
	public void uploadAjax3() {

		log.info("upload ajax3");  
	}
	@GetMapping("/uploadAjax4")
	public void uploadAjax4() { 

		log.info("upload ajax4");   
	}
	@GetMapping("/uploadAjax5")
	public void uploadAjax5() {

		log.info("upload ajax5");   
	}
	@GetMapping("/uploadAjax6")
	public void uploadAjax6() {
 
		log.info("upload ajax6");   
	}
	@GetMapping("/uploadAjax7")
	public void uploadAjax7() {
 
		log.info("upload ajax7");   
	}
	@GetMapping("/uploadAjax8")
	public void uploadAjax8() {
 
		log.info("upload ajax8");   
	}
	@GetMapping("/uploadAjax9")
	public void uploadAjax9() {
 
		log.info("upload ajax9");   
	}

	 @PostMapping("/uploadAjaxAction2")
	 public void uploadAjaxPost2(MultipartFile[] uploadFile) {
	
		 log.info("update ajax post.........");
		
		 String uploadFolder = "C:\\upload";
		
		 for (MultipartFile multipartFile : uploadFile) {
		
			 log.info("-------------------------------------");
			 log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			 log.info("Upload File Size: " + multipartFile.getSize());
			
			 String uploadFileName = multipartFile.getOriginalFilename();
			
			 // IE has file path
			 uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			//IE의 경우에는 전체 파일 경로가 전송되므로，마지막 \를 기준으로 잘라낸 문자열이 실제 파일 이름
			 log.info("only file name: " + uploadFileName);
			
			 File saveFile = new File(uploadFolder, uploadFileName);
		
		 try {
			 multipartFile.transferTo(saveFile);
		 } catch (Exception e) {
			 log.error(e.getMessage());
		 } // end catch
		 }//  end for
	 }

	private String getFolder() {//년월일로쪼개서 폴더를 만들수있게

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();

		String str = sdf.format(date);

		return str.replace("-", File.separator);
	}

	 @PostMapping("/uploadAjaxAction3")
	 public void uploadAjaxPost3(MultipartFile[] uploadFile) {//같은 폴더에 많은파일을 만들면 성능이떨어지는 문제해결
	
		 String uploadFolder = "C:\\upload";
		 
		 String getFolder = getFolder();
		 log.info("getFolder: " + getFolder);//2019\08\14
		
		  //make folder --------
		 File uploadPath = new File(uploadFolder, getFolder); //parent, child 
		 log.info("upload path: " + uploadPath); //C:/upload\2019\08\14 이런경로가 비슷하게나옴
		
		 if (uploadPath.exists() == false) {
			 
			 uploadPath.mkdirs();//폴더를 만든다
		 }
		 // make yyyy/MM/dd folder
		
		 for (MultipartFile multipartFile : uploadFile) {
		
			 log.info("-------------------------------------");
			 log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			 log.info("Upload File Size: " + multipartFile.getSize());
			 
			 String uploadFileName = multipartFile.getOriginalFilename();
			
			  //IE has file path
			 uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") +
			 1);
			 log.info("only file name: " + uploadFileName);
			
			 // File saveFile = new File(uploadFolder, uploadFileName);
			 File saveFile = new File(uploadPath, uploadFileName);//파일객체와, 스트링 값, 년원일 폴더에 파일을 만드는듯
		
		 try {
		
		 multipartFile.transferTo(saveFile);//파일저장
		 } catch (Exception e) {
		 log.error(e.getMessage());
		 }  //end catch
		
		 }//  end for
		
	 }

	 @PostMapping("/uploadAjaxAction4")//uuid로 파일 중복문제 제거
	 public void uploadAjaxPost4(MultipartFile[] uploadFile) {
	
	 String uploadFolder = "C:\\upload";
	
	  //make folder --------
	 File uploadPath = new File(uploadFolder, getFolder());
	 log.info("upload path: " + uploadPath);
	
	 if (uploadPath.exists() == false) {
	 uploadPath.mkdirs();
	 }
	//  make yyyy/MM/dd folder
	
	 for (MultipartFile multipartFile : uploadFile) {
	
	 log.info("-------------------------------------");
	 log.info("Upload File Name: " + multipartFile.getOriginalFilename());
	 log.info("Upload File Size: " + multipartFile.getSize());
	
	 String uploadFileName = multipartFile.getOriginalFilename();
	
	  //IE has file path
	 uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") +
	 1);
	 log.info("only file name: " + uploadFileName);
	
	 UUID uuid = UUID.randomUUID();
	 
	 uploadFileName = uuid.toString() + "_" + uploadFileName;
	
	 File saveFile = new File(uploadPath, uploadFileName);
	
	 try {
	
	 multipartFile.transferTo(saveFile);
	 } catch (Exception e) {
	 log.error(e.getMessage());
	 }  //end catch
	
	 }  //end for
	
	 }

	private boolean checkImageType(File file) {//이미지 파일확인 여부
		/*화면에서 약간의 검사를 통해서 업로드되는 파일의 확장자를 검사하기는 하지만，Ajax로
		사용하는 호출은 반드시 브라우저만을 통해서 들어오는 것이 아니므로 확인할 필요가 있
		습니다*/
			//System.out.println(file.toPath());
		try {
			String contentType = Files.probeContentType(file.toPath());
			
			//System.out.println(contentType);
			return contentType.startsWith("image");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	} 

	 @PostMapping("/uploadAjaxAction5")//썸네일 이미지까지 생성 
	 public void uploadAjaxPost5(MultipartFile[] uploadFile) {
	
		 String uploadFolder = "C:\\upload";
		
		 // make folder --------
		 File uploadPath = new File(uploadFolder, getFolder());
		 log.info("upload path: " + uploadPath);
		
		 if (uploadPath.exists() == false) {
		 uploadPath.mkdirs();
		 }
		 //make yyyy/MM/dd folder
	
	 for (MultipartFile multipartFile : uploadFile) {
	
		 log.info("-------------------------------------");
		 log.info("Upload File Name: " + multipartFile.getOriginalFilename());
		 log.info("Upload File Size: " + multipartFile.getSize());
		
		 String uploadFileName = multipartFile.getOriginalFilename();
		
		 // IE has file path
		 uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") +
		 1);
		 log.info("only file name: " + uploadFileName);
		
		 UUID uuid = UUID.randomUUID();
		
		 uploadFileName = uuid.toString() + "_" + uploadFileName;
		
	 try {
		 File saveFile = new File(uploadPath, uploadFileName);
		 multipartFile.transferTo(saveFile);
		//  check image type file
		 if (checkImageType(saveFile)) {//이미지파일이라면
			 //System.out.println(checkImageType(saveFile));
			 FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" +
			 uploadFileName));//이름이 s_로 시작하는 썸네일
			
			 Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100,
			 100);//가로width 세로height 크기 조정 썸네일 생성까지 다함
			
			 thumbnail.close();
			 }
		
	 } catch (Exception e) {
	 e.printStackTrace();
	 }// end catch
	 }  //end for
	
	 }

	@PostMapping(value = "/uploadAjaxAction6", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost6(MultipartFile[] uploadFile) {
		//System.out.println(1);
		List<AttachFileDTO> list = new ArrayList<>();
		String uploadFolder = "C:\\upload";
 
		String uploadFolderPath = getFolder();
		// make folder --------
		File uploadPath = new File(uploadFolder, uploadFolderPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		// make yyyy/MM/dd folder
		//System.out.println(2);

		for (MultipartFile multipartFile : uploadFile) {

			AttachFileDTO attachDTO = new AttachFileDTO();//0

			String uploadFileName = multipartFile.getOriginalFilename();

			// IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			log.info("only file name: " + uploadFileName);
			
			attachDTO.setFileName(uploadFileName);//1.

			UUID uuid = UUID.randomUUID();

			uploadFileName = uuid.toString() + "_" + uploadFileName;
			//System.out.println(3);
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);

				attachDTO.setUuid(uuid.toString());//2.
				attachDTO.setUploadPath(uploadFolderPath);//3
				//System.out.println(4);
				// check image type file
				if (checkImageType(saveFile)) {

					attachDTO.setImage(true);//4

					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));

					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);

					thumbnail.close();
				}
 
				// add to List
				//System.out.println(5);
				list.add(attachDTO);//리스트에 추가
				//System.out.println(attachDTO);
				//System.out.println(6);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} // end for
		return new ResponseEntity<>(list, HttpStatus.OK);//리스트 넘기기//json데이터 반환
	}
	
	@PostMapping(value = "/uploadAjaxAction7", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)//쿠키님 도와주신것
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost7(MultipartFile[] uploadFile) {
		List<AttachFileDTO> list = new ArrayList<>();
		String uploadFolder = "C:\\upload";
 
		String uploadFolderPath = getFolder();
		// make folder --------
		File uploadPath = new File(uploadFolder, uploadFolderPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		// make yyyy/MM/dd folder

		for (MultipartFile multipartFile : uploadFile) {

			AttachFileDTO attachDTO = new AttachFileDTO();//0

			String uploadFileName = multipartFile.getOriginalFilename();
			
			//파일의 확장자가 올바른지 체크 //쿠키님
			String fileExt = uploadFileName.substring(uploadFileName.lastIndexOf(".") +1);
			
			log.info("=========================================");
			log.info(fileExt);
			log.info("=========================================");
			
			if(fileExt.contains("ahk")) {//해당 파일은 건너뛰게 하는 방식
				
				return new ResponseEntity<>(list, HttpStatus.OK);//리스트 넘기기 
			}

			// IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			log.info("only file name: " + uploadFileName);
			
			attachDTO.setFileName(uploadFileName);//1.

			UUID uuid = UUID.randomUUID();

			uploadFileName = uuid.toString() + "_" + uploadFileName;
			try { 
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);//
 
				attachDTO.setUuid(uuid.toString());//2.
				attachDTO.setUploadPath(uploadFolderPath);//3
				// check image type file
				if (checkImageType(saveFile)) {

					attachDTO.setImage(true);//4

					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));

					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);

					thumbnail.close();
				}
 
				// add to List
				list.add(attachDTO);//리스트에 추가
			} catch (Exception e) {
				e.printStackTrace();
			}

		} // end for
		return new ResponseEntity<>(list, HttpStatus.OK);//리스트 넘기기
	}
	
		@GetMapping("/display")
		@ResponseBody//섬네일 데이터 전송
		public ResponseEntity<byte[]> getFile(String fileName) {//특정한 파일 이름을 받아서 이미지 데이터를 전송하는 코드를우선 생성
	//UploadController에서는 특정한 파일 이름을 받아서 이미지 데이터를 전송하는 코드를우선 생성합
			log.info("fileName: " + fileName);
	
			File file = new File("c:\\upload\\" + fileName);
	
			log.info("file: " + file);
			log.info("file toPath: " + file.toPath());
	/*INFO : org.zerock.controller.UploadController - fileName: 2019\08\16/s_c88abf2b-e72b-47d9-af52-ee22160b0378_2560f4af87b3867b2f6b32a9782f42d2.png
	INFO : org.zerock.controller.UploadController - file: c:/upload\2019\08\16\s_c88abf2b-e72b-47d9-af52-ee22160b0378_2560f4af87b3867b2f6b32a9782f42d2.png
	INFO : org.zerock.controller.UploadController - file toPath: c:/upload\2019\08\16\s_c88abf2b-e72b-47d9-af52-ee22160b0378_2560f4af87b3867b2f6b32a9782f42d2.png
	*/
			ResponseEntity<byte[]> result = null;
	
			try {
				HttpHeaders header = new HttpHeaders();
	
				header.add("Content-Type", Files.probeContentType(file.toPath()));//image/jpeg, image/png
				/*byte[ ]로 이미지 파일의 데이터를 전송할 때  브라우저에 보
				내주는 MIME 타입이 파일의 종류에 따라 달라지는 점. 이 부분을 해결하기 위해
				서probeContentType()을 이용해서 적절한 MIME 타입 데이터를 Http의 헤더 메시지에 포함할수 있도록 처리*/
				result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return result;
		}
	
	@PostMapping(value = "/uploadAjaxAction8", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost8(MultipartFile[] uploadFile) {
		//System.out.println(1);
		List<AttachFileDTO> list = new ArrayList<>();
		String uploadFolder = "C:\\upload";
 
		String uploadFolderPath = getFolder();
		// make folder --------
		File uploadPath = new File(uploadFolder, uploadFolderPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		// make yyyy/MM/dd folder
		//System.out.println(2);

		for (MultipartFile multipartFile : uploadFile) {

			AttachFileDTO attachDTO = new AttachFileDTO();//0

			String uploadFileName = multipartFile.getOriginalFilename();

			// IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			log.info("only file name: " + uploadFileName);
			
			attachDTO.setFileName(uploadFileName);//1.

			UUID uuid = UUID.randomUUID();

			uploadFileName = uuid.toString() + "_" + uploadFileName;
			//System.out.println(3);
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);

				attachDTO.setUuid(uuid.toString());//2.
				attachDTO.setUploadPath(uploadFolderPath);//3
				//System.out.println(4);
				// check image type file
				if (checkImageType(saveFile)) {

					attachDTO.setImage(true);//4

					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));

					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);

					thumbnail.close();
				}else {
					attachDTO.setImage(false); 
				}
 
				// add to List
				//System.out.println(5);
				list.add(attachDTO);//리스트에 추가
				//System.out.println(attachDTO);
				//System.out.println(6);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} // end for
		return new ResponseEntity<>(list, HttpStatus.OK);//리스트 넘기기
	}
	@PostMapping(value = "/uploadAjaxAction9", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost9(MultipartFile[] uploadFile) {
		//System.out.println(1);
		List<AttachFileDTO> list = new ArrayList<>();
		String uploadFolder = "C:\\upload";
 
		String uploadFolderPath = getFolder();
		// make folder --------
		File uploadPath = new File(uploadFolder, uploadFolderPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		// make yyyy/MM/dd folder
		//System.out.println(2);

		for (MultipartFile multipartFile : uploadFile) {

			AttachFileDTO attachDTO = new AttachFileDTO();//0

			String uploadFileName = multipartFile.getOriginalFilename();

			// IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			log.info("only file name: " + uploadFileName);
			
			attachDTO.setFileName(uploadFileName);//1.

			UUID uuid = UUID.randomUUID();

			uploadFileName = uuid.toString() + "_" + uploadFileName;
			//System.out.println(3);
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);

				attachDTO.setUuid(uuid.toString());//2.
				attachDTO.setUploadPath(uploadFolderPath);//3
				//System.out.println(4);
				// check image type file
				if (checkImageType(saveFile)) {

					attachDTO.setImage(true);//4

					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));

					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);

					thumbnail.close();
				}else {
					attachDTO.setImage(false); 
				}
 
				// add to List
				//System.out.println(5);
				list.add(attachDTO);//리스트에 추가
				//System.out.println(attachDTO);
				//System.out.println(6);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} // end for
		return new ResponseEntity<>(list, HttpStatus.OK);//리스트 넘기기
	}


	 /*@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	 @ResponseBody
	 public ResponseEntity<Resource> downloadFile(String fileName) {
	
	 log.info("download file: " + fileName);
	
	 Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
	
	 log.info("resource: " + resource);
	
	 return null;
	 }*/
	
	/*
	 @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)//mime타입은 다운로드할수있는 application/octet-stream 지정
	 @ResponseBody 
	 public ResponseEntity<Resource> downloadFile(String fileName) {//http://localhost:8080/download?fileName=text.txt
	
		 log.info("download file: " + fileName);
		
		 Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
		
		 log.info("resource: " + resource);
		
		 String resourceName = resource.getFilename();
		
		 HttpHeaders headers = new HttpHeaders();
		 try {
			 headers.add("Content-Disposition", "attachment; filename=" + new String(resourceName.getBytes("UTF-8"),//다운로드이름 지정
			 "ISO-8859-1"));//한글일 경우 깨지는 것을 감안해 문자열 인코딩 지정
		 } catch (UnsupportedEncodingException e) {
			 e.printStackTrace();
		 }
	 return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	 }*/
	
	/*
	 @GetMapping(value="/download" , produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	 @ResponseBody
	 public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent")String userAgent, String fileName){
		
		 Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
		
		 if(resource.exists() == false) {//다운로드할 파일이 존재하는지 확인
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		
		 String resourceName = resource.getFilename();
		
		 HttpHeaders headers = new HttpHeaders();
		 try {
		
			 boolean checkIE = (userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("Trident") > -1);//인터넷 익스플로어인지
			
			 String downloadName = null;
			
		 if (checkIE) {
			 downloadName = URLEncoder.encode(resourceName, "UTF8").replaceAll("\\+", " ");
		 } else {
			 downloadName = new String(resourceName.getBytes("UTF-8"), "ISO-8859-1");
		 }
		
		 headers.add("Content-Disposition", "attachment; filename=" + downloadName);

		 } catch (UnsupportedEncodingException e) {
			 e.printStackTrace();
		 }
	
	 return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	 }*/

	 @GetMapping(value="/download" , produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	 @ResponseBody
	 public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent")String userAgent, String fileName){
	
		 Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
		
		 if(resource.exists() == false) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		
		 String resourceName = resource.getFilename();
			
		 String resourceOriginalName = resourceName.substring(resourceName.indexOf("_")+1); //remove UUID
		
		 HttpHeaders headers = new HttpHeaders();
		 try {
		
		 boolean checkIE = (userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("Trident") > -1);
		
		 String downloadName = null;
		
		 if(checkIE) {
			 downloadName = URLEncoder.encode(resourceOriginalName,"UTF8").replaceAll("\\+", " ");
		 }else {
			 downloadName = new String(resourceOriginalName.getBytes("UTF-8"),"ISO-8859-1");
		 }
		
		 headers.add("Content-Disposition", "attachment; filename="+downloadName);//downloadName이름으로 다운로드되게됨	
		
		 } catch (UnsupportedEncodingException e) {
		 e.printStackTrace();
		 }
		
	 return new ResponseEntity<Resource>(resource, headers,HttpStatus.OK);
	 }


	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type) {

		log.info("deleteFile: " + fileName);

		File file;

		try {
			file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));

			file.delete();//섬네일 파일 ,일반파일 삭제

			if (type.equals("image")) {

				String largeFileName = file.getAbsolutePath().replace("s_", "");//이미지의 경우 원본파일도 삭제

				log.info("largeFileName: " + largeFileName);

				file = new File(largeFileName);

				file.delete();
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}///deleteFile 끝
	
}
