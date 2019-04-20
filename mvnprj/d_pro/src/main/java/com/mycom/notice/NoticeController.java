package com.mycom.notice;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.notice.NoticeModel;
import com.mycom.notice.NoticeService;
import com.mycom.util.Paging;
import com.mycom.validator.NoticeValidator;

@Controller
public class NoticeController {

	@Resource
	private NoticeService noticeService;
	private int searchNum;
	private String isSearch;
	
	//페이징을 위한 변수 설정
	private int currentPage = 1;	 
	private int totalCount; 		 
	private int blockCount = 10;	 
	private int blockPage = 5; 	 
	private String pagingHtml;  
	private Paging page;

	//리스트 처리(검색)
	@RequestMapping(value="/notice/noticeList.dog", method=RequestMethod.GET)
	public ModelAndView noticeList(HttpServletRequest request) throws UnsupportedEncodingException{
		
		ModelAndView mav = new ModelAndView();
		
		if(request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty() || request.getParameter("currentPage").equals("0")) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }

		List<NoticeModel> noticeList;
		
		
		String isSearch = request.getParameter("isSearch");
		if(isSearch != null) isSearch = new String(isSearch.getBytes("8859_1"), "UTF-8");
		
		
		if(isSearch != null)
		{
			searchNum = Integer.parseInt(request.getParameter("searchNum"));

			if(searchNum==0)
				noticeList = noticeService.noticeSearch0(isSearch);
			else if(searchNum==1)
				noticeList = noticeService.noticeSearch1(isSearch);
			else /*if(searchN==2)*/
				noticeList = noticeService.noticeSearch2(isSearch);
		
			totalCount = noticeList.size();
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "noticeList", searchNum, isSearch);
			pagingHtml = page.getPagingHtml().toString();
		
			int lastCount = totalCount;
		
			if(page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;
			
			noticeList = noticeList.subList(page.getStartCount(), lastCount);
		
			mav.addObject("isSearch", isSearch);
			mav.addObject("searchNum", searchNum);
			mav.addObject("totalCount", totalCount);
			mav.addObject("pagingHtml", pagingHtml);
			mav.addObject("currentPage", currentPage);
			mav.addObject("noticeList", noticeList);
			mav.setViewName("noticeList");
			return mav;
		}
		
		noticeList = noticeService.noticeList();
		
		totalCount = noticeList.size();
		
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "noticeList");
		pagingHtml=page.getPagingHtml().toString();  
		
		int lastCount = totalCount;
		 
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		 
		noticeList = noticeList.subList(page.getStartCount(), lastCount);
		
		mav.addObject("totalCount", totalCount);
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("currentPage", currentPage);
		mav.addObject("noticeList", noticeList);
		mav.setViewName("noticeList");
		return mav;
	}

	//공지사항 상세보기
	@RequestMapping("/notice/noticeView.dog")
	public ModelAndView noticeView(HttpServletRequest request){
		   
		ModelAndView mav = new ModelAndView();
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		NoticeModel noticeModel = noticeService.noticeView(no);
		
		noticeService.noticeUpdateReadcount(no);
		
		mav.addObject("currentPage", currentPage);
		mav.addObject("noticeModel", noticeModel);
		mav.setViewName("noticeView");
		
		return mav;
	}
	
	//공지사항 글쓰기 폼
	@RequestMapping(value="/notice/noticeWrite.dog", method=RequestMethod.GET)
	public ModelAndView noticeForm(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeModel", new NoticeModel());
		mav.setViewName("noticeForm");
		return mav;
	}
	
	//공지사항 글쓰기
	@RequestMapping(value="/notice/noticeWrite.dog", method=RequestMethod.POST)
	public ModelAndView noticeWrite(@ModelAttribute("noticeModel") NoticeModel noticeModel, BindingResult result, 
			HttpServletRequest request, HttpSession session){
		
		ModelAndView mav = new ModelAndView();
		
		new NoticeValidator().validate(noticeModel, result);
		
		if(result.hasErrors()) {
			mav.setViewName("noticeForm");
			return mav;
		}
		
		String content = noticeModel.getContent().replaceAll("\r\n", "<br />");
		noticeModel.setContent(content);
		
		noticeService.noticeWrite(noticeModel);
		
		mav.addObject("noticeModel", noticeModel);
		mav.setViewName("redirect:noticeList.dog");
		
		return mav;
	}
	
	//공지사항 삭제
	@RequestMapping("/notice/noticeDelete.dog")
	public ModelAndView noticeDelete(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		int no = Integer.parseInt(request.getParameter("no"));
		noticeService.noticeDelete(no);
		mav.setViewName("redirect:noticeList.dog");
		
		return mav;	
	}
	
	//공지사항 수정폼
	@RequestMapping("/notice/noticeModify.dog")
	public ModelAndView noticeModifyForm(@ModelAttribute("noticeModel") NoticeModel noticeModel, BindingResult result, HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		noticeModel = noticeService.noticeView(noticeModel.getNo());
		
		String content = noticeModel.getContent().replaceAll("<br />", "\r\n");
		noticeModel.setContent(content);
		
		mav.addObject("noticeModel", noticeModel);
		mav.setViewName("noticeModify");
		
		return mav;	
	}
	
	//공지사항 수정
	@RequestMapping("/notice/noticeModifySuccess.dog")
	public ModelAndView noticeModify(@ModelAttribute("noticeModel") NoticeModel noticeModel, HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView("redirect:noticeView.dog");
		
		String content = noticeModel.getContent().replaceAll("\r\n", "<br />");
		noticeModel.setContent(content);
		
		noticeService.noticeModify(noticeModel);
		
		mav.addObject("no", noticeModel.getNo());
		
		return mav;	
	}
}
