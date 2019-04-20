package com.mycom.admin;

/**
 * @author 박준영
 * 
 * 
 * 
 * 
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.QnA.QnAModel;
import com.mycom.QnA.QnAService;
import com.mycom.goods.GoodsModel;
import com.mycom.goods.GoodsService;
import com.mycom.member.MemberModel;
import com.mycom.member.MemberService;
import com.mycom.notice.NoticeModel;
import com.mycom.notice.NoticeService;
import com.mycom.order.OrderModel;
import com.mycom.order.OrderService;
import com.mycom.pet.PetModel;
import com.mycom.pet.PetService;
import com.mycom.pet_img.Pet_imgModel;
import com.mycom.pet_img.Pet_imgService;
import com.mycom.review.ReviewModel;
import com.mycom.review.ReviewService;
import com.mycom.util.Paging;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private AdminService adminService;
	
	@Resource
	private GoodsService goodsService;
	
	@Resource
	private MemberService memberService;
	
	@Resource
	private OrderService orderService;
	
	@Resource
	private NoticeService noticeService;
	
	@Resource
	private Pet_imgService pet_imgService;
	
	@Resource
	private PetService petService;
	
	@Resource
	private QnAService qnAService;
	
	@Resource
	private ReviewService reviewService;
	
	String uploadPath = "E:\\app3\\d_pro\\src\\main\\webapp\\resources\\goods_upload\\";
	
	//페이징
	private int searchNum;
	private String isSearch;
	
	private int currentPage = 1;	 
	private int totalCount; 		 
	private int blockCount = 7;	 
	private int blockPage = 5; 	 
	private String pagingHtml;  
	private Paging page;
	
	ModelAndView mav = new ModelAndView();
	
	@RequestMapping(value="admin.dog")
	public String mainForm(){
		return "adminForm";
	}
	
	//goods admin 리스트
	@RequestMapping("goodsadminList.dog")
	public ModelAndView goodsList(HttpServletRequest request) throws Exception{
		
		if(request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty() || request.getParameter("currentPage").equals("0")) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
		
		List<GoodsModel> goodslist=adminService.goodsList();
		
		isSearch = request.getParameter("isSearch");
		if(isSearch != null)
		{
			searchNum = Integer.parseInt(request.getParameter("searchNum"));

			if(searchNum==0)//상품이름
				goodslist = adminService.goodsSearch0(isSearch);
			else if(searchNum == 1)//글번호
				goodslist = adminService.goodsSearch1(isSearch);
			else if(searchNum == 2)//카테고리
				goodslist = adminService.goodsSearch2(isSearch);
			else if(searchNum == 3)//goods_best 신상, 추천,베스트
				goodslist = adminService.goodsSearch3(isSearch);
		
			totalCount = goodslist.size();
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "goodsadminList", searchNum, isSearch);
			pagingHtml = page.getPagingHtml().toString();
		
			int lastCount = totalCount;
		
			if(page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;
			
			goodslist = goodslist.subList(page.getStartCount(), lastCount);
		
			mav.addObject("isSearch", isSearch);
			mav.addObject("searchNum", searchNum);
			mav.addObject("totalCount", totalCount);
			mav.addObject("pagingHtml", pagingHtml);
			mav.addObject("currentPage", currentPage);
			mav.addObject("goodsList", goodslist);
			mav.setViewName("goodsadminList");
			return mav;
		}
		
		totalCount = goodslist.size();
		
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "goodsadminList");
		pagingHtml=page.getPagingHtml().toString(); 
		

		int lastCount = totalCount;
		 
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		 
		goodslist = goodslist.subList(page.getStartCount(), lastCount);
		
		mav.addObject("totalCount", totalCount);
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("currentPage", currentPage);
		
		mav.addObject("goodsList", goodslist);
		mav.setViewName("goodsadminList");
		
		return mav;
	}
	
	//goods 등록화면
	@RequestMapping("goodsInsertForm.dog")
	public ModelAndView goodsInsertForm(){
		
		mav.addObject("goods", new GoodsModel());
		mav.setViewName("admingoodsInsert");
		return mav;
	}
	
	//상품 등록하기
	 @RequestMapping(value="goodsInsert.dog")    
	    public String insertGoods(MultipartHttpServletRequest multipartHttpServletRequest,GoodsModel GoodsModel) throws Exception {        
	       
	 
	        System.out.println("UPLOAD_PATH : "+uploadPath);
		        	
        		//메인 상품이미지
	        	MultipartFile multipartFile = multipartHttpServletRequest.getFile("file[0]");
	        	String filename = multipartFile.getOriginalFilename();
		        	if (filename != ""){ 
					    GoodsModel.setGoods_image(System.currentTimeMillis()+"_"+multipartFile.getOriginalFilename());					    
					    String savimagename = System.currentTimeMillis()+"_"+multipartFile.getOriginalFilename();				    
				        FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(uploadPath+"/"+savimagename));			            	        
		        	}else{
		        		GoodsModel.setGoods_image("NULL");		
		        	}
		        	
		        //contentimage
		        MultipartFile multipartFile1 = multipartHttpServletRequest.getFile("file[1]");
		        String filename1 = multipartFile1.getOriginalFilename();
		        	if (filename1 != ""){
					    GoodsModel.setGoods_contentimage(System.currentTimeMillis()+"_content"+multipartFile1.getOriginalFilename());					    
					    String savimagename1 = System.currentTimeMillis()+"_content"+multipartFile1.getOriginalFilename();				    
				        FileCopyUtils.copy(multipartFile1.getInputStream(), new FileOutputStream(uploadPath+"/"+savimagename1));
		        	}else{
		        		GoodsModel.setGoods_contentimage("NULL");		
		        	}
		        	
		      //delevimage 배송 이미지
		        MultipartFile multipartFile2 = multipartHttpServletRequest.getFile("file[2]");
		        String filename2 = multipartFile2.getOriginalFilename();
		        	if (filename2 != ""){
					    GoodsModel.setGoods_delevimage(System.currentTimeMillis()+"_delev"+multipartFile2.getOriginalFilename());					    
					    String savimagename2 = System.currentTimeMillis()+"_delev"+multipartFile2.getOriginalFilename();				    
				        FileCopyUtils.copy(multipartFile2.getInputStream(), new FileOutputStream(uploadPath+"/"+savimagename2));
		        	}else{
		        		GoodsModel.setGoods_delevimage("NULL");		
		        	}    
		       
				
				
	        
	        adminService.insertGoods(GoodsModel);
	        return "redirect:goodsadminList.dog";
	    }
	 
	 //상품수정하기 폼
	 @RequestMapping("goodsModifyForm.dog")
		public ModelAndView noticeModifyForm(GoodsModel goodsModel, HttpServletRequest request){
			
		 
			goodsModel = adminService.goodsAdminView(goodsModel.getGoods_num());
			
			mav.addObject("goodsModel", goodsModel);
			mav.setViewName("goodsModify");
			
			return mav;	
		}
	
	 //상품수정
	 @RequestMapping("goodsModify.dog")
		public ModelAndView goodsModify(GoodsModel GoodsModel, MultipartHttpServletRequest multipartHttpServletRequest){
		
		 	
	        System.out.println("UPLOAD_PATH : "+uploadPath);
		    
	        if (multipartHttpServletRequest.getFile("file[0]") != null){
     		//메인 상품이미지
	        	MultipartFile multipartFile = multipartHttpServletRequest.getFile("file[0]");
	        	String filename = multipartFile.getOriginalFilename();
		        	if (filename != ""){ 
					    GoodsModel.setGoods_image(System.currentTimeMillis()+"_"+multipartFile.getOriginalFilename());					    
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
		        	}
	        }else{
	        	GoodsModel.setGoods_image(multipartHttpServletRequest.getParameter("goods_image"));
	        }
	        
	        if (multipartHttpServletRequest.getFile("file[1]") != null){
		        //contentimage
		        MultipartFile multipartFile1 = multipartHttpServletRequest.getFile("file[1]");
		        String filename1 = multipartFile1.getOriginalFilename();
		        	if (filename1 != ""){
					    GoodsModel.setGoods_contentimage(System.currentTimeMillis()+"_content"+multipartFile1.getOriginalFilename());					    
					    String savimagename1 = System.currentTimeMillis()+"_content"+multipartFile1.getOriginalFilename();				    
				        try {
							FileCopyUtils.copy(multipartFile1.getInputStream(), new FileOutputStream(uploadPath+"/"+savimagename1));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
	        }else{
	        	GoodsModel.setGoods_contentimage(multipartHttpServletRequest.getParameter("goods_contentimage"));
	        }
	        
	        if (multipartHttpServletRequest.getFile("file[2]") != null){
		      //delevimage 배송 이미지
		        MultipartFile multipartFile2 = multipartHttpServletRequest.getFile("file[2]");
		        String filename2 = multipartFile2.getOriginalFilename();
		        	if (filename2 != ""){
					    GoodsModel.setGoods_delevimage(System.currentTimeMillis()+"_delev"+multipartFile2.getOriginalFilename());					    
					    String savimagename2 = System.currentTimeMillis()+"_delev"+multipartFile2.getOriginalFilename();				    
				        try {
							FileCopyUtils.copy(multipartFile2.getInputStream(), new FileOutputStream(uploadPath+"/"+savimagename2));
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
		        	} 
	        }else{
	        	GoodsModel.setGoods_delevimage(multipartHttpServletRequest.getParameter("goods_delevimage"));
	        }		
			
			adminService.goodsModify(GoodsModel);
			mav.addObject("goodsModel", GoodsModel);
  			mav.setViewName("redirect:goodsadminList.dog");
  			return mav;
		}
	 //상품삭제하기
	 @RequestMapping("goodsDelete.dog")
		public ModelAndView goodsDelete(HttpServletRequest request, GoodsModel GoodsModel){
		 int goods_num = Integer.parseInt(request.getParameter("goods_num"));
		 GoodsModel = goodsService.goodsView(goods_num);
		 
		 String filename = GoodsModel.getGoods_image();
		 String filename1 = GoodsModel.getGoods_contentimage();
		 String filename2 = GoodsModel.getGoods_delevimage();
		 System.out.println(filename);
		 
		 File f = new File(uploadPath + filename);
		 System.out.println(f.isFile());
		 if(f.exists()){
			 f.delete();
			 System.out.println("goods_image 파일 삭제");
		 }else{
			 System.out.println("goods_image 파일없음");
		 }
		 
		 f = new File(uploadPath + filename1);
		 if(f.exists()){
			 f.delete();
			 System.out.println("getGoods_contentimage 파일 삭제");
		 }else{
			 System.out.println("getGoods_contentimage 파일없음");
		 }
		 
		 f = new File(uploadPath + filename2);
		 if(f.exists()){
			 f.delete();
			 System.out.println("getGoods_delevimage 파일 삭제");
		 }else{
			 System.out.println("getGoods_delevimage 파일없음");
		 }
		 
		 
		 adminService.goodsDelete(goods_num);
		 mav.setViewName("redirect:goodsadminList.dog");
			
		 return mav;	
	}
	 
	 //회원목록
		@RequestMapping("memberadminList.dog")
		public ModelAndView memberList(HttpServletRequest request) throws Exception{
			
			if(request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty() || request.getParameter("currentPage").equals("0")) {
	            currentPage = 1;
	        } else {
	            currentPage = Integer.parseInt(request.getParameter("currentPage"));
	        }
			
			List<MemberModel> memberlist=adminService.memberList();
			
			isSearch = request.getParameter("isSearch");
			if(isSearch != null)
			{
				searchNum = Integer.parseInt(request.getParameter("searchNum"));

				if(searchNum==0)//상품이름
					memberlist = adminService.memberSearch0(isSearch);
			
				totalCount = memberlist.size();
				page = new Paging(currentPage, totalCount, blockCount, blockPage, "memberadminList", searchNum, isSearch);
				pagingHtml = page.getPagingHtml().toString();
			
				int lastCount = totalCount;
			
				if(page.getEndCount() < totalCount)
					lastCount = page.getEndCount() + 1;
				
				memberlist = memberlist.subList(page.getStartCount(), lastCount);
			
				mav.addObject("isSearch", isSearch);
				mav.addObject("searchNum", searchNum);
				mav.addObject("totalCount", totalCount);
				mav.addObject("pagingHtml", pagingHtml);
				mav.addObject("currentPage", currentPage);
				mav.addObject("memberlist", memberlist);
				mav.setViewName("memberadminList");
				return mav;
			}
			
			totalCount = memberlist.size();
			
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "memberadminList");
			pagingHtml=page.getPagingHtml().toString(); 
			

			int lastCount = totalCount;
			 
			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;
			 
			memberlist = memberlist.subList(page.getStartCount(), lastCount);
			
			mav.addObject("totalCount", totalCount);
			mav.addObject("pagingHtml", pagingHtml);
			mav.addObject("currentPage", currentPage);
			
			mav.addObject("memberlist", memberlist);
			mav.setViewName("memberadminList");
			
			return mav;
		}
		
		//회원삭제하기
		 @RequestMapping("adminMemberDelete.dog")
			public ModelAndView memberDelete(HttpServletRequest request){		
			 String id = request.getParameter("id");
			 adminService.memberDelete(id);
			 mav.setViewName("redirect:memberadminList.dog");
				
			 return mav;	
		}
		 
		//회원 1명 View 상세보기
		// 회원정보수정
	  	@RequestMapping("adminmemberModify.dog")
	  	public ModelAndView memberModify(MemberModel member, HttpServletRequest request) {		  		 		
	  		
  			member =  memberService.getMember(member.getId());
  	
  			mav.addObject("member", member);
  			mav.setViewName("memberadminModify");
  			return mav;
	  	}
	  	
	  	//회원수정 등록
	    @RequestMapping("adminmemberModifyEnd.dog")
  		public ModelAndView adminmemberModifyEnd(MemberModel member) {
  		
		System.out.println("수정시작");
		
  			adminService.adminmemberModify(member);
  			mav.setViewName("redirect:memberadminList.dog");
  			return mav;
	    }
	    
	    
	    //주문리스트
	    @RequestMapping("adminOrderAllList.dog")
		public ModelAndView OrderList(HttpServletRequest request) throws Exception{
			
			if(request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty() || request.getParameter("currentPage").equals("0")) {
	            currentPage = 1;
	        } else {
	            currentPage = Integer.parseInt(request.getParameter("currentPage"));
	        }
			
			List<OrderModel> orderlist=adminService.orderAllList();
			
			String isSearch = request.getParameter("isSearch");
			if(isSearch != null) isSearch = new String(isSearch.getBytes("8859_1"), "UTF-8");
			
			
			if(isSearch != null)
			{
				searchNum = Integer.parseInt(request.getParameter("searchNum"));

				if(searchNum==0)//전체
					orderlist = adminService.orderSearch0(isSearch);
				else if(searchNum==1)//결재방식
					orderlist = adminService.orderSearch1(isSearch);
				else if(searchNum==2)//주문상태
					orderlist = adminService.orderSearch2(isSearch);
			
				totalCount = orderlist.size();
				page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminOrderAllList", searchNum, isSearch);
				pagingHtml = page.getPagingHtml().toString();
			
				int lastCount = totalCount;
			
				if(page.getEndCount() < totalCount)
					lastCount = page.getEndCount() + 1;
				
				orderlist = orderlist.subList(page.getStartCount(), lastCount);
			
				mav.addObject("isSearch", isSearch);
				mav.addObject("searchNum", searchNum);
				mav.addObject("totalCount", totalCount);
				mav.addObject("pagingHtml", pagingHtml);
				mav.addObject("currentPage", currentPage);
				mav.addObject("orderList", orderlist);
				mav.setViewName("orderAllList");
				return mav;
			}
			
			totalCount = orderlist.size();
			
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminOrderAllList");
			pagingHtml=page.getPagingHtml().toString(); 
			

			int lastCount = totalCount;
			 
			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;
			 
			orderlist = orderlist.subList(page.getStartCount(), lastCount);
			
			mav.addObject("totalCount", totalCount);
			mav.addObject("pagingHtml", pagingHtml);
			mav.addObject("currentPage", currentPage);
			
			mav.addObject("orderList", orderlist);
			mav.setViewName("orderAllList");
			
			return mav;
		}
	    
	  //주문 수정하기 폼
		 @RequestMapping("orderModifyForm.dog")
		public ModelAndView orderModifyForm(OrderModel orderModel, HttpServletRequest request){
			
		 
			orderModel = orderService.OrdergetOne(orderModel.getOrder_num());
			
			mav.addObject("orderModel", orderModel);
			mav.setViewName("orderModify");
			
			return mav;	
		}
		// 주문수정
		  	@RequestMapping("orderModify.dog")
		  	public ModelAndView orderModify(OrderModel OrderModel, HttpServletRequest request) {		  		 		
		  		
		 
		  	
		  		adminService.orderModify(OrderModel);
	  	
	  			mav.setViewName("redirect:adminOrderAllList.dog");
	  			return mav;
		  	}
		  	/*public ModelAndView adminmemberModifyEnd(MemberModel member) {
		  		
				System.out.println("수정시작");
				
		  			adminService.adminmemberModify(member);
		  			mav.setViewName("redirect:memberadminList.dog");
		  			return mav;
			    }*/
	    
	  //주문목록 삭제
        @RequestMapping(value="orderadmindelete.dog")
        public ModelAndView orderdelete(HttpServletRequest request, OrderModel orderModel){
        	
        	orderService.deleteOrder(orderModel);
        	
        	mav.setViewName("redirect:adminOrderAllList.dog"); 
        	return mav;
        }
        
        
        
       //게시판관리/////////////////////////////////
       //공지사항//
        @RequestMapping(value="adminnoticeList.dog", method=RequestMethod.GET)
    	public ModelAndView noticeList(HttpServletRequest request){
    		
    		ModelAndView mav = new ModelAndView();
    		
    		if(request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty() || request.getParameter("currentPage").equals("0")) {
                currentPage = 1;
            } else {
                currentPage = Integer.parseInt(request.getParameter("currentPage"));
            }

    		List<NoticeModel> noticeList;
    		
    		isSearch = request.getParameter("isSearch");
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
    			page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminnoticeList", searchNum, isSearch);
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
    			mav.setViewName("noticeadminList");
    			return mav;
    		}
    		
    		noticeList = noticeService.noticeList();
    		
    		totalCount = noticeList.size();
    		
    		page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminnoticeList");
    		pagingHtml=page.getPagingHtml().toString();  
    		
    		int lastCount = totalCount;
    		 
    		if (page.getEndCount() < totalCount)
    			lastCount = page.getEndCount() + 1;
    		 
    		noticeList = noticeList.subList(page.getStartCount(), lastCount);
    		
    		mav.addObject("totalCount", totalCount);
    		mav.addObject("pagingHtml", pagingHtml);
    		mav.addObject("currentPage", currentPage);
    		mav.addObject("noticeList", noticeList);
    		mav.setViewName("noticeadminList");
    		return mav;
    	}
        
        //공지사항삭제
        @RequestMapping("adminnoticeDelete.dog")
    	public ModelAndView noticeDelete(HttpServletRequest request){
    		
    		ModelAndView mav = new ModelAndView();
    		int no = Integer.parseInt(request.getParameter("no"));
    		noticeService.noticeDelete(no);
    		mav.setViewName("redirect:adminnoticeList.dog");
    		
    		return mav;	
    	}
        
        //마이펫리스트
        @RequestMapping("adminpet_imgList.dog")
    	public String pet_imgList(Model model,Pet_imgModel pet_imgModel, HttpServletRequest request ){
    		
    		
        	List<Pet_imgModel> pet_imgList;
        	
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
    			
    			
    			page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminpet_imgList", searchNum, isSearch);
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
    			
    			return "adminpet_imgList";
    		}
    		
    		
    		
    		pet_imgList = pet_imgService.pet_imgGetList(pet_imgModel);
    		
    		totalCount = pet_imgList.size();
    		
    		page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminpet_imgList");
    		pagingHtml=page.getPagingHtml().toString();  
    		
    		int lastCount = totalCount;
    		 
    		if (page.getEndCount() < totalCount)
    			lastCount = page.getEndCount() + 1;
    		 
    		pet_imgList = pet_imgList.subList(page.getStartCount(), lastCount);
    		
    		model.addAttribute("totalCount", totalCount);
    		model.addAttribute("pagingHtml", pagingHtml);
    		model.addAttribute("currentPage", currentPage);
    		
    		model.addAttribute("list", pet_imgList);
    		
    		return "adminpet_imgList";
    	}
        
        //마이펫 삭제
        @RequestMapping("adminpet_imgDelete.dog")
    	public ModelAndView pet_imgDelete(HttpServletRequest request, Pet_imgModel pet_imgModel ){
    	
    		ModelAndView mav=new ModelAndView();
    	
    		pet_imgService.deletePet_img(pet_imgModel);
    	
    		mav.setViewName("redirect:adminpet_imgList.dog");
    	
    		return mav;
    	
        }
        
        
        //분양게시판 리스트
        @RequestMapping(value="adminpetList.dog")
    	public String petList(Model model,PetModel petModel, HttpServletRequest request ){
    		
        	List<PetModel> petList;
    		
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
    			
    			
    			page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminpetList", searchNum, isSearch);
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
    			
    			return "adminpetList";
    		}
    		
    		
    		
    		petList = petService.petGetList(petModel);
    		
    		totalCount = petList.size();
    		
    		page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminpetList");
    		pagingHtml=page.getPagingHtml().toString();  
    		
    		int lastCount = totalCount;
    		 
    		if (page.getEndCount() < totalCount)
    			lastCount = page.getEndCount() + 1;
    		 
    		petList = petList.subList(page.getStartCount(), lastCount);
    		
    		model.addAttribute("totalCount", totalCount);
    		model.addAttribute("pagingHtml", pagingHtml);
    		model.addAttribute("currentPage", currentPage);
    		
    		model.addAttribute("list", petList);
    		
    		return "adminpetList";
    	}
        //분양게시판 삭제
        @RequestMapping("adminpetDelete.dog")
    	public ModelAndView petDelete(HttpServletRequest request, PetModel petModel ){
    	
    		ModelAndView mav=new ModelAndView();
    	
    		petService.deletePet(petModel);
    	
    		mav.setViewName("redirect:adminpetList.dog");
    	
    		return mav;
    	
      }
        //Qna리스트
        @RequestMapping(value="adminQnAList.dog")
    	public ModelAndView qnaList(HttpServletRequest request, QnAModel qnaModel){
    		ModelAndView mav = new ModelAndView();

    		if(request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty() || request.getParameter("currentPage").equals("0")) {
                currentPage = 1;
            } else {
                currentPage = Integer.parseInt(request.getParameter("currentPage"));
            }
    		
    		int commupdate1;
    		List<QnAModel> list;
    		list = qnAService.QnAList();
    		
    		isSearch = request.getParameter("isSearch");
    		
    		if(isSearch != null)		{
    			searchNum = Integer.parseInt(request.getParameter("searchNum"));
    			
    			if(searchNum==0){
    				list = qnAService.QnASearch0(isSearch);
    			}else if(searchNum==1){
    				list =  qnAService.QnASearch1(isSearch);
    			}else if(searchNum==2){
    				list =  qnAService.QnASearch2(isSearch);
    			}
    		}
    			
    		totalCount = list.size();
    		page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminQnAList");
    		pagingHtml=page.getPagingHtml().toString();  
    		
    		int lastCount = totalCount;
    		
    		if (page.getEndCount() < totalCount){
    			lastCount = page.getEndCount() + 1;}
    			
    		list = list.subList(page.getStartCount(), lastCount);

    		int no = qnaModel.getNo();
    		commupdate1 = qnAService.QnAcommUpdate1(no);
    		
    		mav.addObject("QnAModel", qnaModel);
    		mav.setViewName("QnAView");

    		mav.addObject("isSearch", isSearch);
    		mav.addObject("searchNum", searchNum);
    		mav.addObject("totalCount", totalCount);
    		mav.addObject("pagingHtml", pagingHtml);
    		mav.addObject("currentPage", currentPage);
    		mav.addObject("list", list);
    		mav.addObject("commupdate1",commupdate1);
    		mav.setViewName("adminQnAList");
    		
    		return mav;
    	}
        
        //qna삭제
        @RequestMapping(value="adminQnADelete.dog")
    	public ModelAndView qnaDelete(HttpServletRequest request, QnAModel qnaModel){			   
    			ModelAndView mav = new ModelAndView();
    			
    			
    			qnAService.QnADelete(qnaModel.getNo());
    			qnAService.QnAallcommDelete(qnaModel.getNo());
    			mav.setViewName("redirect:adminQnAList.dog");
    			
    			return mav;
    	}
        
        //구매후기 리스트
    	@RequestMapping(value="adminreviewList.dog")
    	public ModelAndView reviewList(HttpServletRequest request){
    		
    		ModelAndView mav = new ModelAndView();
    		
    		if(request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty() || request.getParameter("currentPage").equals("0")) {
                currentPage = 1;
            } else {
                currentPage = Integer.parseInt(request.getParameter("currentPage"));
            }
    		
    		List<ReviewModel> reviewList = null;
    		
    		isSearch = request.getParameter("isSearch");
    		
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
    			page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminreviewList", searchNum, isSearch);
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
    			mav.setViewName("adminreviewList");
    			return mav;
    		}
    		
    		reviewList = reviewService.reviewList();
    		
    		totalCount = reviewList.size();
    		
    		page = new Paging(currentPage, totalCount, blockCount, blockPage, "adminreviewList");
    		pagingHtml=page.getPagingHtml().toString();
    		
    		int lastCount = totalCount;
    		 
    		if (page.getEndCount() < totalCount)
    			lastCount = page.getEndCount() + 1;
    		 
    		reviewList = reviewList.subList(page.getStartCount(), lastCount);
    		
    		mav.addObject("totalCount", totalCount);
    		mav.addObject("pagingHtml", pagingHtml);
    		mav.addObject("currentPage", currentPage);
    		mav.addObject("reviewList", reviewList);
    		mav.setViewName("adminreviewList");
    		return mav;
    	}
    	
    	//구매후기 삭제
    	@RequestMapping("adminreviewDelete.dog")
    	public ModelAndView reviewDelete(HttpServletRequest request){
    		
    		ModelAndView mav = new ModelAndView();
    		int no = Integer.parseInt(request.getParameter("no"));
    		reviewService.reviewDelete(no);
    		mav.setViewName("redirect:adminreviewList.dog");
    		
    		return mav;	
    	}
    	
	
}
