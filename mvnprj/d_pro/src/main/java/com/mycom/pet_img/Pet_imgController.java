package com.mycom.pet_img;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.mycom.util.FileUpload;
import com.mycom.util.Paging;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value="/pet_img")
public class Pet_imgController {
	
	String session_member_id;

	@Resource(name="pet_imgService")
	private Pet_imgService pet_imgService;
	
	private int readNo;
	
	private int searchNum;
	private String isSearch;
	
	private int currentPage = 1;	 
	private int totalCount; 		 
	private int blockCount = 10;	 
	private int blockPage = 5; 	 
	private String pagingHtml;  
	private Paging page;
	
	private List<Pet_imgModel> pet_imgList = new ArrayList<Pet_imgModel>();
	
	
	@RequestMapping(value="/pet_imgList.dog")
	public String pet_imgList(Model model,Pet_imgModel pet_imgModel, HttpServletRequest request ){
		
		
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
				pet_imgList = pet_imgService.pet_imgSearch0(isSearch);
			else if(searchNum==1)
				pet_imgList = pet_imgService.pet_imgSearch1(isSearch);
			else /*if(searchN==2)*/
				pet_imgList = pet_imgService.pet_imgSearch2(isSearch);
			
			totalCount = pet_imgList.size();
			
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "pet_imgList", searchNum, isSearch);
			pagingHtml = page.getPagingHtml().toString();
		
			int lastCount = totalCount;
		
			if(page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;
			
			pet_imgList = pet_imgList.subList(page.getStartCount(), lastCount);
			
			model.addAttribute("isSearch", isSearch);
			model.addAttribute("searchNum", searchNum);
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("pagingHtml", pagingHtml);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("list", pet_imgList);
			
			return "pet_imgList";
		}
		
		pet_imgList = pet_imgService.pet_imgGetList(pet_imgModel);
		
		totalCount = pet_imgList.size();
		
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "pet_imgList");
		pagingHtml=page.getPagingHtml().toString();  
		
		int lastCount = totalCount;
		 
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		 
		pet_imgList = pet_imgList.subList(page.getStartCount(), lastCount);
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("currentPage", currentPage);
		
		model.addAttribute("list", pet_imgList);
		
		return "pet_imgList";
		/*return "pet_img/pet_imgList";*/
	}
	
	
	@RequestMapping(value="/pet_imgWriteForm.dog", method=RequestMethod.GET)
	public String form(Model model) {
		/*return "pet_img/pet_imgWrite";*/
		return "pet_imgWrite";
	}
	
	@RequestMapping(value="/pet_imgWriteForm.dog", method=RequestMethod.POST)
	public String write(Model model, Pet_imgModel pet_imgModel ) {
		
		pet_imgModel.setContent(pet_imgModel.getContent().replaceAll("\n", "").replaceAll("\t", "").replaceAll("\r", "").replaceAll("'", "&apos;"));
		
		pet_imgService.insertPet_img(pet_imgModel);
		
		return "redirect:pet_imgList.dog";
	}
	
	@RequestMapping(value = "/pet_imgUpdate.dog")
	   public String form(Model model, Pet_imgModel pet_imgModel) {
	      
	      model.addAttribute("item", pet_imgService.pet_imgGetOne(pet_imgModel));
	      model.addAttribute("modify", "true");
	      return "pet_imgWrite";
	   }
	   
	   @RequestMapping(value = "/pet_imgUpdateAction.dog", method = RequestMethod.POST)
	   public String modify(Model model, Pet_imgModel pet_imgModel) {
		   
	      pet_imgModel.setContent(pet_imgModel.getContent().replaceAll("\n", "").replaceAll("\t", "").replaceAll("\r", "").replaceAll("'", "&apos;"));
	     
	      pet_imgService.updatePet_img(pet_imgModel);
	      return "redirect:pet_imgList.dog";
	   }
	   
	   @RequestMapping(value = "/pet_imgView.dog", method = RequestMethod.GET)
	   public String pet_imgView(Model model, Pet_imgModel pet_imgModel, HttpServletRequest request, HttpSession session) {
		
		session = request.getSession();
		
		if(readNo != pet_imgModel.getNo()){
			session.setAttribute("TOKEN_SAVE_CHECK", "TRUE");
			readNo = pet_imgModel.getNo();
		}
		
		if("TRUE".equals(session.getAttribute("TOKEN_SAVE_CHECK"))) {
			
			int pet_img_no = Integer.parseInt(request.getParameter("no"));
			
			pet_imgService.readhit(pet_img_no);
			session.setAttribute("TOKEN_SAVE_CHECK", "FALSE");
			
			model.addAttribute("item", pet_imgService.pet_imgGetOne(pet_imgModel));
			model.addAttribute("commentlist", pet_imgService.commentList(pet_img_no));
			return "pet_imgView";
			} else {
				int pet_img_no = Integer.parseInt(request.getParameter("no"));
				model.addAttribute("item", pet_imgService.pet_imgGetOne(pet_imgModel));
				model.addAttribute("commentlist", pet_imgService.commentList(pet_img_no));
				return "pet_imgView";
			}
		
	}
	
	
	@RequestMapping(value = "/fileUpload.dog", method = RequestMethod.POST)
	public String fileUpload(Model model, MultipartRequest multipartRequest, HttpServletRequest request) throws IOException{
		MultipartFile imgfile = multipartRequest.getFile("Filedata");
		Calendar cal = Calendar.getInstance();
		String fileName = imgfile.getOriginalFilename();
		String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		String replaceName = cal.getTimeInMillis() + fileType;  
		
		//서버에 올리기
		String path = request.getSession().getServletContext().getRealPath("/")+File.separator+"resources/pet_img_upload";
		//피시에 올리기
		/*String path = "C:\\Users\\gram\\workspace2\\d_pro\\src\\main\\webapp\\resources\\pet_img_upload\\";*/
		
		FileUpload.fileUpload(imgfile, path, replaceName);
		model.addAttribute("path", path);
		model.addAttribute("filename", replaceName);
		return "pet_img/file_upload";
	}


	@RequestMapping("/commentWrite.dog")
	public ModelAndView commentWrite(HttpServletRequest request, HttpSession session) {
	
		ModelAndView mav=new ModelAndView();
		Pet_imgCommentModel pet_imgCommentModel=new Pet_imgCommentModel();
	
		try{
			session_member_id=session.getAttribute("session_member_id").toString();
		
			if(session_member_id == null){
				mav.setViewName("pet_img/loginConfirm");
				return mav;
		}
			if(request.getParameter("commentt").equals("") || request.getParameter("commentt").trim().isEmpty()) {
				mav.setViewName("pet_img/commentConfirm");
			return mav;
		}
		
	}	
	catch(NullPointerException np) {
		mav.setViewName("pet_img/commentConfirm");
		
		return mav;
	}
	
	int pet_img_no = Integer.parseInt(request.getParameter("item_no"));
	
	pet_imgCommentModel.setCommentt(request.getParameter("commentt").replaceAll("\r\n", "<br />"));
	pet_imgCommentModel.setPet_img_no(pet_img_no);
	pet_imgCommentModel.setCmter(session_member_id);
	
	pet_imgService.writecomment(pet_imgCommentModel);
	
	mav.setViewName("redirect:pet_imgView.dog?no="+pet_img_no);
	
	return mav;
	
	
}

	@RequestMapping("/commentDelete.dog")
	public ModelAndView commentDelete(HttpServletRequest request, Pet_imgCommentModel pet_imgCommentModel ){
	
		ModelAndView mav=new ModelAndView();
	
		pet_imgService.deletecomment(pet_imgCommentModel);
	
		mav.setViewName("redirect:pet_imgView.dog?no="+pet_imgCommentModel.getPet_img_no());
	
		return mav;
	
}
	
	@RequestMapping("/pet_imgDelete.dog")
	public ModelAndView pet_imgDelete(HttpServletRequest request, Pet_imgModel pet_imgModel ){
	
		ModelAndView mav=new ModelAndView();
	
		pet_imgService.deletePet_img(pet_imgModel);
	
		mav.setViewName("redirect:pet_imgList.dog");
	
		return mav;
	
}


}




