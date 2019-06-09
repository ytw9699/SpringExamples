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

	private String getFolder() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();

		String str = sdf.format(date);

		return str.replace("-", File.separator);
	}

	 @PostMapping("/uploadAjaxAction3")
	 public void uploadAjaxPost3(MultipartFile[] uploadFile) {
	
	 String uploadFolder = "C:\\upload";
	 
	 String getFolder = getFolder();
	 log.info("getFolder: " + getFolder);
	
	  //make folder --------
	 File uploadPath = new File(uploadFolder, getFolder);
	 log.info("upload path: " + uploadPath);
	
	 if (uploadPath.exists() == false) {
	 uploadPath.mkdirs();//폴더를 만드는듯
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
		 File saveFile = new File(uploadPath, uploadFileName);//년원일 폴더에 파일을 만드는듯
	
	 try {
	
	 multipartFile.transferTo(saveFile);//파일저장
	 } catch (Exception e) {
	 log.error(e.getMessage());
	 }  //end catch
	
	 }//  end for
	
	 }

	 @PostMapping("/uploadAjaxAction4")
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

	private boolean checkImageType(File file) {
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

	 @PostMapping("/uploadAjaxAction5")
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
			 uploadFileName));
			
			 Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100,
			 100);//가로 세로 크기 조정 썸네일 생성
			
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
		return new ResponseEntity<>(list, HttpStatus.OK);//리스트 넘기기
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

	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName) {//특정한 파일 이름을 받아서 이미지 데이터를 전송하는 코드를우선 생성

		log.info("fileName: " + fileName);

		File file = new File("c:\\upload\\" + fileName);

		log.info("file: " + file);

		ResponseEntity<byte[]> result = null;

		try {
			HttpHeaders header = new HttpHeaders();

			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return result;
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
	 @GetMapping(value = "/download", produces =
	 MediaType.APPLICATION_OCTET_STREAM_VALUE)
	 @ResponseBody 
	 public ResponseEntity<Resource> downloadFile(String fileName) {//http://localhost:8080/download?fileName=text.txt
	
		 log.info("download file: " + fileName);
		
		 Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
		
		 log.info("resource: " + resource);
		
		 String resourceName = resource.getFilename();
		
		 HttpHeaders headers = new HttpHeaders();
		 try {
			 headers.add("Content-Disposition",
			 "attachment; filename=" + new String(resourceName.getBytes("UTF-8"),
			 "ISO-8859-1"));
		 } catch (UnsupportedEncodingException e) {
			 e.printStackTrace();
		 }
	 return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	 }*/

	 /*@GetMapping(value="/download" , produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	 @ResponseBody
	 public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent")String userAgent, String fileName){
		
		 Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
		
		 if(resource.exists() == false) {
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
	 public ResponseEntity<Resource>
	 downloadFile(@RequestHeader("User-Agent")String userAgent, String fileName){
	
	 Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
	
	 if(resource.exists() == false) {
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	
	 String resourceName = resource.getFilename();
	 //remove UUID
	 String resourceOriginalName = resourceName.substring(resourceName.indexOf("_")+1);
	
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

	/*@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String fileName) {

		Resource resource = new FileSystemResource("c:\\upload\\" + fileName);

		if (resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		String resourceName = resource.getFilename();

		// remove UUID
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);

		HttpHeaders headers = new HttpHeaders();
		try {

			boolean checkIE = (userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("Trident") > -1);

			String downloadName = null;

			if (checkIE) {
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF8").replaceAll("\\+", " ");
			} else {
				downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
			}

			headers.add("Content-Disposition", "attachment; filename=" + downloadName);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	*/

	/*@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type) {

		log.info("deleteFile: " + fileName);

		File file;

		try {
			file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));

			file.delete();

			if (type.equals("image")) {

				String largeFileName = file.getAbsolutePath().replace("s_", "");

				log.info("largeFileName: " + largeFileName);

				file = new File(largeFileName);

				file.delete();
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}*/
	
}
