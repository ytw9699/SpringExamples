package com.mycom.pet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;


import com.mycom.util.FileUpload;
import com.mycom.util.Paging;



@Controller
@RequestMapping(value="/pet")
public class PetController {

	String session_member_id;

	@Resource(name="petService")
	private PetService petService;
	
	private int readNo;
	
	private int searchNum;
	private String isSearch;
	
	private int currentPage = 1;	 
	private int totalCount; 		 
	private int blockCount = 9;	 
	private int blockPage = 5; 	 
	private String pagingHtml;  
	private Paging page;
	
	private List<PetModel> petList = new ArrayList<PetModel>();
	
	
	@RequestMapping(value="/petList.dog")
	public String petList(Model model,PetModel petModel, HttpServletRequest request ){
		
		
		if(request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty() || request.getParameter("currentPage").equals("0")) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
		
		
		
		
		isSearch = request.getParameter("isSearch");
		
		if(isSearch != null)
		{
			searchNum = Integer.parseInt(request.getParameter("searchNum"));
			
			
			if(searchNum==0)
				petList = petService.petSearch0(isSearch);
			else if(searchNum==1)
				petList = petService.petSearch1(isSearch);
			else /*if(searchN==2)*/
				petList = petService.petSearch2(isSearch);
			
			
			
			totalCount = petList.size();
			
			
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "petList", searchNum, isSearch);
			pagingHtml = page.getPagingHtml().toString();
		
			int lastCount = totalCount;
		
			if(page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;
			
			petList = petList.subList(page.getStartCount(), lastCount);
		
			
			model.addAttribute("isSearch", isSearch);
			model.addAttribute("searchNum", searchNum);
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("pagingHtml", pagingHtml);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("list", petList);
			
			return "petList";
		}
		
		
		
		petList = petService.petGetList(petModel);
		
		totalCount = petList.size();
		
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "petList");
		pagingHtml=page.getPagingHtml().toString();  
		
		int lastCount = totalCount;
		 
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		 
		petList = petList.subList(page.getStartCount(), lastCount);
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("currentPage", currentPage);
		
		model.addAttribute("list", petList);
		
		return "petList";
		/*return "pet/petList";*/
	}
	
	
	@RequestMapping(value="/petWriteForm.dog", method=RequestMethod.GET)
	public String form(Model model) {
		/*return "pet/petWrite";*/
		return "petWrite";
	}
	
	@RequestMapping(value="/petWriteForm.dog", method=RequestMethod.POST)
	public String write(Model model, PetModel petModel ) {
		
		
		System.out.println("글쓰기 시작");
		
		petModel.setContent(petModel.getContent().replaceAll("\n", "").replaceAll("\t", "").replaceAll("\r", "").replaceAll("'", "&apos;"));
		
		String imgName = petModel.getContent();
		
		int index1 = imgName.indexOf("pet_img_upload/");
		int index2 = imgName.indexOf("pet_img_upload/");
		index1 += 15;
		index2 += 32;
		
		/*System.out.println(index1+"  1번인데긋");
		System.out.println(index2+"  2번인덱스");
		System.out.println(imgName);*/
		imgName = imgName.substring(index1, index2);
		/*System.out.println(imgName);*/
		
		
		petModel.setImagefile_savname(imgName);
		petService.insertPet(petModel);
		
		
		return "redirect:petList.dog";
	}
	
	@RequestMapping(value = "/petUpdate.dog")
	   public String form(Model model, PetModel petModel) {
	      
	      model.addAttribute("item", petService.petGetOne(petModel));
	      model.addAttribute("modify", "true");
	      return "petWrite";
	   }
	   
	   @RequestMapping(value = "/petUpdateAction.dog", method = RequestMethod.POST)
	   public String modify(Model model, PetModel petModel) {
	
	      petModel.setContent(petModel.getContent().replaceAll("\n", "").replaceAll("\t", "").replaceAll("\r", "").replaceAll("'", "&apos;"));
	     
	      petService.updatePet(petModel);
	      return "redirect:petList.dog";
	   }
	
	   
	   
	   
	   
	@RequestMapping(value = "/petView.dog", method = RequestMethod.GET)
	public String petView(Model model, PetModel petModel, HttpServletRequest request, HttpSession session) {
		
		
		session = request.getSession();
		
		if(readNo != petModel.getNo()){
			session.setAttribute("TOKEN_SAVE_CHECK", "TRUE");
			readNo = petModel.getNo();
		}
		
		
		if("TRUE".equals(session.getAttribute("TOKEN_SAVE_CHECK"))) {
			
			int pet_no = Integer.parseInt(request.getParameter("no"));
			
			petService.readhit(pet_no);
			
			session.setAttribute("TOKEN_SAVE_CHECK", "FALSE");
			
			model.addAttribute("item", petService.petGetOne(petModel));
			model.addAttribute("commentlist", petService.commentList(pet_no));
			return "petView";
			} else {
				
				int pet_no = Integer.parseInt(request.getParameter("no"));
				model.addAttribute("item", petService.petGetOne(petModel));
				model.addAttribute("commentlist", petService.commentList(pet_no));
				return "petView";
			}
		
	}
	
	
	



@RequestMapping("/commentWrite.dog")
public ModelAndView commentWrite(HttpServletRequest request, HttpSession session) {
	
	ModelAndView mav=new ModelAndView();
	PetCommentModel petCommentModel=new PetCommentModel();
	
	
	try{
		session_member_id=session.getAttribute("session_member_id").toString();
		
		
		
		if(session_member_id == null){
			mav.setViewName("pet/loginConfirm");
			return mav;
		}
		System.out.println("13");
		if(request.getParameter("commentt").equals("") || request.getParameter("commentt").trim().isEmpty()) {
			System.out.println("14");
			mav.setViewName("pet/commentConfirm");
			return mav;
		}
		
	}	
	catch(NullPointerException np) {
		mav.setViewName("pet/commentConfirm");
		
		return mav;
	}
	
	
	int pet_no = Integer.parseInt(request.getParameter("item_no"));
	
	petCommentModel.setCommentt(request.getParameter("commentt").replaceAll("\r\n", "<br />"));
	petCommentModel.setPet_no(pet_no);
	petCommentModel.setCmter(session_member_id);
	
	petService.writecomment(petCommentModel);
	
	mav.setViewName("redirect:petView.dog?no="+pet_no);
	
	return mav;
	
	
}

	@RequestMapping("/commentDelete.dog")
	public ModelAndView commentDelete(HttpServletRequest request, PetCommentModel petCommentModel ){
	
		ModelAndView mav=new ModelAndView();
	
		petService.deletecomment(petCommentModel);
	
		mav.setViewName("redirect:petView.dog?no="+petCommentModel.getPet_no());
	
		return mav;
	
}
	
	@RequestMapping("/petDelete.dog")
	public ModelAndView petDelete(HttpServletRequest request, PetModel petModel ){
	
		ModelAndView mav=new ModelAndView();
	
		petService.deletePet(petModel);
	
		mav.setViewName("redirect:petList.dog");
	
		return mav;
	
}

	
	@RequestMapping(value = "/fileUpload.dog", method = RequestMethod.POST)
	public String fileUpload(Model model, MultipartRequest multipartRequest, HttpServletRequest request) throws IOException{
		MultipartFile imgfile = multipartRequest.getFile("Filedata");
		Calendar cal = Calendar.getInstance();
		String fileName = imgfile.getOriginalFilename();
		String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		String replaceName = cal.getTimeInMillis() + fileType;  
		
		
		
		/*String path = request.getSession().getServletContext().getRealPath("/")+File.separator+"resources/pet_upload";*/
		
		
		String path = "C:\\workspace\\d_pro\\src\\main\\webapp\\resources\\pet_img_upload\\";	
		
		FileUpload.fileUpload(imgfile, path, replaceName);
		model.addAttribute("path", path);
		model.addAttribute("filename", replaceName);
		return "pet/file_upload";
	}
	
	


	
	
}
