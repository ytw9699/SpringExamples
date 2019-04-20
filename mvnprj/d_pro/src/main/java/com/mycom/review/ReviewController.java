package com.mycom.review;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


import com.mycom.util.Paging;
import com.mycom.review.ReviewModel;
import com.mycom.review.ReviewService;
import com.mycom.validator.ReviewValidator;


@Controller
public class ReviewController {
	
	private static final String uploadPath = "E:\\app3\\d_pro\\src\\main\\webapp\\resources\\reviewUpload\\";
	
	@Resource
	private ReviewService reviewService;

	private ReviewService review;
	private int searchNum;
	private String isSearch;
	
	private int currentPage = 1;	 
	private int totalCount; 		 
	private int blockCount = 5;	 
	private int blockPage = 5; 	 
	private String pagingHtml;  
	private Paging page;
	private int comment_count;
	private int commupdate1;
	private String commenter;
	
	/*@ModelAttribute
	public ReviewModel formBack() {
		return new ReviewModel();
	}
	
	/*/////////////////////////////////////�۸��/////////////////////////////////////*/
	@RequestMapping(value="/review/reviewList.dog")
	public ModelAndView reviewList(HttpServletRequest request) throws UnsupportedEncodingException{
		
		ModelAndView mav = new ModelAndView();
		
		if(request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty() || request.getParameter("currentPage").equals("0")) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
		
		List<ReviewModel> reviewList = null;
		
		String isSearch = request.getParameter("isSearch");
		if(isSearch != null) isSearch = new String(isSearch.getBytes("8859_1"), "UTF-8");
		
		if(isSearch != null)
		{
			searchNum = Integer.parseInt(request.getParameter("searchNum"));
			
			if(searchNum==0)
				reviewList = reviewService.reviewSearch0(isSearch);
			else if(searchNum==1)
				reviewList = reviewService.reviewSearch1(isSearch);
			else if(searchNum==2)
				reviewList = reviewService.reviewSearch2(isSearch);
		
			totalCount = reviewList.size();
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "reviewList", searchNum, isSearch);
			pagingHtml = page.getPagingHtml().toString();
		
			int lastCount = totalCount;
		
			if(page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;
			
			reviewList = reviewList.subList(page.getStartCount(), lastCount);
		
			mav.addObject("isSearch", isSearch);
			mav.addObject("searchNum", searchNum);
			mav.addObject("totalCount", totalCount);
			mav.addObject("pagingHtml", pagingHtml);
			mav.addObject("currentPage", currentPage);
			mav.addObject("reviewList", reviewList);
			mav.setViewName("reviewList");
			return mav;
		}
		
		reviewList = reviewService.reviewList();
		
		totalCount = reviewList.size();
		
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "reviewList");
		pagingHtml=page.getPagingHtml().toString();
		
		int lastCount = totalCount;
		 
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		 
		reviewList = reviewList.subList(page.getStartCount(), lastCount);
		
		mav.addObject("totalCount", totalCount);
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("currentPage", currentPage);
		mav.addObject("reviewList", reviewList);
		mav.setViewName("reviewList");
		return mav;
	}
	
	/*/////////////////////////////////////�۾��� �� �̵�/////////////////////////////////////*/
	@RequestMapping(value="/review/reviewWrite.dog", method=RequestMethod.GET)
	public ModelAndView reviewForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("reviewWrite");
		return mav;
	}
	
	/*/////////////////////////////�۾���/////////////////////////////////////*/
	@RequestMapping(value="/review/reviewWrite.dog", method=RequestMethod.POST)
	public String reviewWrite(ReviewModel reviewModel,  BindingResult result,
			MultipartHttpServletRequest multipartHttpServletRequest) throws Exception, Exception{
		ModelAndView mav = new ModelAndView();
		/*��������Ʈ*/
		new ReviewValidator().validate(reviewModel, result);
		if(result.hasErrors()) {
			mav.setViewName("reviewWrite");
			return "reviewWrite";
		}
		
		/*�ٹٲ�*/
		String content = reviewModel.getContent().replaceAll("\r\n", "<br />");
		reviewModel.setContent(content);
				
		//���ε�
		MultipartFile multipartFile = multipartHttpServletRequest.getFile("file");
    	String filename = multipartFile.getOriginalFilename();
        	if (filename != ""){ 
			    reviewModel.setImagefile_savname(System.currentTimeMillis()+"_"+multipartFile.getOriginalFilename());
			    String savimagename = System.currentTimeMillis()+"_"+multipartFile.getOriginalFilename();
		        FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(uploadPath+"/"+savimagename));
		        reviewModel.setImagefile_savname(savimagename);
        	}else{
        		reviewModel.setImagefile_savname("NULL");		
        	}
		
		reviewService.reviewWrite(reviewModel);
	
		mav.setViewName("redirect:reviewList.dog");
		
		return "redirect:reviewList.dog";
	}
	
	/*/////////////////////////////////////�ڸ�Ʈ/////////////////////////////////////*/
	@RequestMapping(value="/review/reviewcommWrite.dog", method=RequestMethod.POST)
	public ModelAndView reviewcommWrite( ReviewcommModel reviewcommModel,
			HttpServletRequest request, HttpSession session){
	    
		ModelAndView mav = new ModelAndView();
		int no = reviewcommModel.getContent_num();
		
		/*�ٹٲ�*/
		String contentt = reviewcommModel.getCommentt().replaceAll("\r\n", "<br />");
		reviewcommModel.setCommentt(contentt);
				
		reviewService.reviewcommWrite(reviewcommModel);
		reviewService.reviewcommUpdate1(no);
		commenter = reviewcommModel.getCommenter();
		
		mav.setViewName("redirect:/review/reviewView.dog?no="+reviewcommModel.getContent_num());
		
		return mav;
	}
	
	/*/////////////////////////////////////�󼼺���/////////////////////////////////////*/
	
	@RequestMapping("/review/reviewView.dog")
	public ModelAndView reviewView(HttpServletRequest request){			   
		ModelAndView mav = new ModelAndView();
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		ReviewModel reviewModel = reviewService.reviewView(no);
		reviewService.reviewUpdateReadhit(no);
		comment_count =  reviewService.reviewcommCount(no);
		
		List<ReviewcommModel> reviewcommList;
		reviewcommList = reviewService.reviewcommList(no);
		comment_count = reviewcommList.size();
		
		mav.addObject("CommList", reviewcommList);
		mav.addObject("reviewModel", reviewModel);
		mav.addObject("comment_count", comment_count);
		mav.setViewName("reviewView");
		
		return mav;
	}
	
	/*/////////////////////////////////////�ۻ���/////////////////////////////////////*/
	@RequestMapping("/review/reviewDelete.dog")
	public ModelAndView reviewDelete(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		int no = Integer.parseInt(request.getParameter("no"));
		reviewService.reviewDelete(no);
		reviewService.reviewallcommDelete(no);
		mav.setViewName("redirect:/review/reviewList.dog");
		
		return mav;	
	}
	
	/*/////////////////////////////////////�ڸ�Ʈ����/////////////////////////////////////*/
	@RequestMapping(value="/review/reviewcommDelete.dog")
	public ModelAndView qnacommDelete(HttpServletRequest request, ReviewModel reviewModel, ReviewcommModel reviewcommModel){			   
			ModelAndView mav = new ModelAndView();
			
			System.out.println(reviewcommModel.getComment_num());
			
			int no = reviewModel.getNo();
			reviewService.reviewcommDelete(reviewcommModel);
			reviewService.reviewView(reviewModel.getNo());
			reviewService.reviewcommUpdate2(no);
			
			mav.setViewName("redirect:/review/reviewView.dog?no="+reviewModel.getNo());
			
			return mav;
	}
	/*/////////////////////////////////////�ۼ��� �̵�/////////////////////////////////////*/
	@RequestMapping("/review/reviewModify.dog")
	public ModelAndView reviewModifyForm(@ModelAttribute("reviewModel") ReviewModel reviewModel, BindingResult result, HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		reviewModel = reviewService.reviewView(reviewModel.getNo());
		
		String contents = reviewModel.getContent().replaceAll("<br />", "\r\n");
		reviewModel.setContent(contents);
		
		mav.addObject("reviewModel", reviewModel);
		mav.setViewName("reviewModify");
		
		return mav;	
	}
	
	/*/////////////////////////////////////�� ����/////////////////////////////////////*/
	@RequestMapping("/review/reviewModifySuccess.dog")
	public ModelAndView reviewModify(ReviewModel reviewModel, MultipartHttpServletRequest multipartHttpServletRequest){
		
		ModelAndView mav = new ModelAndView();
        
        /*�ٹٲ�*/
		String content = reviewModel.getContent().replaceAll("\r\n", "<br />");
		reviewModel.setContent(content);
	    
        if (multipartHttpServletRequest.getFile("file") != null){
 		//���� ��ǰ�̹���
        	MultipartFile multipartFile = multipartHttpServletRequest.getFile("file");
        	String filename = multipartFile.getOriginalFilename();
	        	if (filename != ""){ 
				    reviewModel.setImagefile_savname(System.currentTimeMillis()+"_"+multipartFile.getOriginalFilename());					    
				    String savimagename = System.currentTimeMillis()+"_"+multipartFile.getOriginalFilename();				    
			        try {
						FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(uploadPath+"/"+savimagename));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			            	        
	        	}/*else{
	        		reviewModel.setImagefile_savname("NULL");
	        	}*/
        }
        else{
        	reviewModel.setImagefile_savname(multipartHttpServletRequest.getParameter("imagefile_savname"));
        }
        
        reviewService.reviewModify(reviewModel);
		
		mav.addObject("no", reviewModel.getNo());
		mav.setViewName("redirect:/review/reviewView.dog");
		return mav;	
	}
}
