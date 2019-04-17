package net.nice19.smboard.board.controller;

import java.io.File;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.nice19.smboard.board.model.BoardCommentModel;
import net.nice19.smboard.board.model.BoardModel;
import net.nice19.smboard.board.model.AlarmModel;
import net.nice19.smboard.board.service.BoardService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {
	// DI
	private ApplicationContext context = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
	private BoardService boardService = (BoardService) context.getBean("boardService");
	//
	// * User variable
	// article, page variables
	private int currentPage = 1;
	private int showArticleLimit = 3; //한페이지의 게시글 수 제한 change value if want to show more articles by one page
	private int showPageLimit = 10; //모든 총 페이지 수 제한 change value if want to show more page links
	private int startArticleNum = 0;//특정 페이지에 불러올 게시글의 첫번째 번호 기본값
	private int endArticleNum = 0;//특정 페이지에 불러올 게시글의 마지막 번호 기본값
	private int totalNum = 0;
	private String uploadPath = "F:\\java\\App\\SummerBoard\\WebContent\\files\\";//끝에 \\써줘야함
	
@RequestMapping("/list.do")
public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response,HttpSession session){
	
	String type = null;
	String keyword = null;		
	
	// set variables from request parameter
if(request.getParameter("page") == null || request.getParameter("page").trim().isEmpty() || request.getParameter("page").equals("0")) {
	currentPage = 1;
} else {
	currentPage = Integer.parseInt(request.getParameter("page"));
}

if(request.getParameter("type") != null){
	type = request.getParameter("type").trim();
}

if(request.getParameter("keyword") != null){
	keyword = request.getParameter("keyword").trim();
}
// expression article variables value
startArticleNum = (currentPage - 1) * showArticleLimit + 1;//1 특정 페이지에 불러올 게시글의 첫번째 번호
endArticleNum = startArticleNum + showArticleLimit -1;//10 특정 페이지에 불러올 게시글의 마지막 번호

// get boardList and get page html code
List<BoardModel> boardList;
if(type != null && keyword != null){
	boardList = boardService.searchArticle(type, keyword, startArticleNum, endArticleNum);
	totalNum = boardService.getSearchTotalNum(type, keyword);
} else {
	boardList = boardService.getBoardList(startArticleNum, endArticleNum);
	totalNum = boardService.getTotalNum();
}
StringBuffer pageHtml = getPageHtml(currentPage, totalNum, showArticleLimit, showPageLimit, type, keyword);


ModelAndView mav = new ModelAndView();

mav.addObject("boardList", boardList);
mav.addObject("pageHtml", pageHtml);
mav.setViewName("/board/list");//list.jsp
	
	return mav;
}
	
	// A method for Creating page html code
	//페이징하는 메소드 스트러츠에서는 클래스로 뺐는데 여기서는 메소드로 빼도상관없음
	private StringBuffer getPageHtml(int currentPage, int totalNum, int showArticleLimit, int showPageLimit, String type, String keyword) {
		StringBuffer pageHtml = new StringBuffer();//페이징부분
		int startPage = 0;
		int lastPage = 0;
		
		// expression page variables
		startPage = ((currentPage-1) / showPageLimit) * showPageLimit + 1;
		lastPage = startPage + showPageLimit - 1;
		
		if(lastPage > totalNum / showArticleLimit) {
			lastPage = (totalNum / showArticleLimit) + 1;
		}
		// create page html code
		// if: when no search	
		if(type == null && keyword == null){			
			if(currentPage == 1){
				pageHtml.append("<span>");
			} else {
				pageHtml.append("<span><a href=\"list.do?page=" + (currentPage-1) + "\"><이전></a>&nbsp;&nbsp;");
			}
			
			for(int i = startPage ; i <= lastPage ; i++) {
				if(i == currentPage){
					pageHtml.append(".&nbsp;<strong>");
					pageHtml.append("<a href=\"list.do?page=" +i + "\" class=\"page\">" + i + "</a>");
					pageHtml.append("&nbsp;</strong>");
				} else {
					pageHtml.append(".&nbsp;<a href=\"list.do?page=" +i + "\" class=\"page\">" + i + "</a>&nbsp;");
				}
				
			}
			if(currentPage == lastPage){
				pageHtml.append(".</span>");
			} else {
				pageHtml.append(".&nbsp;&nbsp;<a href=\"list.do?page=" + (currentPage+1) + "\"><다음></a></span>");
			}
		//
		// else: when search
		} else {			
			if(currentPage == 1){
				pageHtml.append("<span>");
			} else {
				pageHtml.append("<span><a href=\"list.do?page=" + (currentPage-1) + "&type=" + type + "&keyword=" + keyword + "\"><이전></a>&nbsp;&nbsp;");
			}
			
			for(int i = startPage ; i <= lastPage ; i++) {
				if(i == currentPage){
					pageHtml.append(".&nbsp;<strong>");
					pageHtml.append("<a href=\"list.do?page=" +i + "&type=" + type + "&keyword=" + keyword + "\" class=\"page\">" + i + "</a>&nbsp;");
					pageHtml.append("&nbsp;</strong>");
				} else {
					pageHtml.append(".&nbsp;<a href=\"list.do?page=" +i + "&type=" + type + "&keyword=" + keyword + "\" class=\"page\">" + i + "</a>&nbsp;");
				}
				
			}
			if(currentPage == lastPage){
				pageHtml.append("</span>");
			} else {
				pageHtml.append(".&nbsp;&nbsp;<a href=\"list.do?page=" + (currentPage+1) + "&type=" + type + "&keyword=" + keyword + "\"><다음></a></span>");
			}
		}
		//		
		return pageHtml;
	}
	@RequestMapping("/AlarmWrite.do")//알람입력
	public ModelAndView commentWriteProc(@ModelAttribute("AlarmModel") AlarmModel AlarmModel){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:list.do");
		boardService.pushinsert(AlarmModel);
		
		return mav;
	}
	@RequestMapping("/alarm.do")
	public ModelAndView alarm(HttpSession session){		
		
		String userId = (String) session.getAttribute("userId");//추가 

		ModelAndView mav = new ModelAndView();

		if(userId != null){
		List<AlarmModel> alarm = boardService.getAlarm(userId);//추가//board테이블 리스트 리턴
		mav.addObject("alarmList", alarm);
		}
		mav.setViewName("/board/alarm");//list.jsp
			
	    return mav;
	}
	/*@RequestMapping("/alarm.do")
	public ModelAndView alarm(HttpSession session){		
		
		String userId = (String) session.getAttribute("userId");//추가 

		ModelAndView mav = new ModelAndView();

		if(userId != null){
		List<BoardModel> board = boardService.getPush(userId);//추가//board테이블 리스트 리턴
		mav.addObject("pushList", board);
		}
		mav.setViewName("/board/alarm");//list.jsp
			
	    return mav;
	}*/
	@RequestMapping("/write.do")//폼띄우기
	public String boardWrite(){		
		return "/board/write";//포워딩
	}
	@RequestMapping(value="/write.do", method=RequestMethod.POST)//글입력처리
	public String boardWriteProc(@ModelAttribute("BoardModel") BoardModel boardModel, 
			MultipartHttpServletRequest request){
		// get upload file
		MultipartFile file = request.getFile("file");
		String fileName = file.getOriginalFilename();
		File uploadFile = new File(uploadPath + fileName);
		// when file exists as same name
		if(uploadFile.exists()){
			fileName = new Date().getTime() + fileName;
			uploadFile = new File(uploadPath + fileName);
		}
		// save upload file to uploadPath
		try {
			file.transferTo(uploadFile);//업로드 완료
		} catch (Exception e) {
			
		}
		boardModel.setFileName(fileName);
		// new line code change to <br /> tag	
		String content =  boardModel.getContent().replaceAll("\r\n", "<br />");//\r\n 줄바꿈 엔터를   br태그로 바꿔라		
		//getContent() 컨텐츠 스트링객체리턴 글 내용부분//줄바꿔서 내용이 쓰여짐 , or <pre>태그 써도됨
		boardModel.setContent(content);
		//
		boardService.writeArticle(boardModel);	
		
		return "redirect:list.do";
	}
@RequestMapping("/view.do")//상세보기
public ModelAndView boardView(HttpServletRequest request){
	int idx = Integer.parseInt(request.getParameter("idx"));		
	
	BoardModel board = boardService.getOneArticle(idx); // get selected article model
	boardService.updateHitcount(board.getHitcount()+1, idx); // update hitcount
	//System.out.println(BackPush);
	List<BoardCommentModel> commentList = boardService.getCommentList(idx); // get comment list
	
	if( request.getParameter("BackPush") != null ){
		String BackPush = request.getParameter("BackPush");
		if( BackPush.equals("0") ){
			boardService.BackPush(idx);//추가
			}
		}
	if( request.getParameter("alarmidx") != null ){
		int alarmidx = Integer.parseInt(request.getParameter("alarmidx"));//추가	
		boardService.deleteAlarm(alarmidx);//추가
		}
	ModelAndView mav = new ModelAndView();
	mav.addObject("board", board);
	mav.addObject("commentList", commentList);
	mav.setViewName("/board/view");
	return mav;
}
@RequestMapping("/download")
public ModelAndView download(HttpServletRequest request) throws Exception {
	String fileName = request.getParameter("fileName");
	String path="F:\\java\\App\\SummerBoard\\WebContent\\files\\"+fileName;
	File downloadFile = new File(path);
	return new ModelAndView("download", "downloadFile", downloadFile);
}
	@RequestMapping("/commentWrite.do")//댓글입력
	public ModelAndView commentWriteProc(@ModelAttribute("CommentModel") BoardCommentModel commentModel){
		// new line code change to <br /> tag
		String content = commentModel.getContent().replaceAll("\r\n", "<br />");
		commentModel.setContent(content);
		//
		boardService.writeComment(commentModel);
		ModelAndView mav = new ModelAndView();
		mav.addObject("idx", commentModel.getLinkedArticleNum());
		mav.setViewName("redirect:view.do");//리다이렉트하면 addObject로 추가한게 겟방식으로는 넘어간다 리퀘스트영역에는 저장안됨
		
		boardService.push(commentModel.getLinkedArticleNum());	//알림 추가부분//해당글에 push를 1증가
		
		return mav;
	}
	
	@RequestMapping("/modify.do")//데이터꺼내와서 폼으로 보여주는거
	public ModelAndView boardModify(HttpServletRequest request, HttpSession session){
		String userId = (String) session.getAttribute("userId");
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardModel board = boardService.getOneArticle(idx);
		// <br /> tag change to new line code
		String content = board.getContent().replaceAll("<br />", "\r\n");//꺼내와서는 다시 꺼꾸로 br태그를 \r\n으로
		board.setContent(content);
		//
		
		ModelAndView mav = new ModelAndView();
		
		if(!userId.equals(board.getWriterId())){
			mav.addObject("errCode", "1");	// forbidden connection
			mav.addObject("idx", idx);
			mav.setViewName("redirect:view.do");
		} else {
			mav.addObject("board", board);
			mav.setViewName("/board/modify");
		}		
		return mav;
	}
	@RequestMapping(value = "/modify.do", method=RequestMethod.POST)//진짜 수정
	public ModelAndView boardModifyProc(@ModelAttribute("BoardModel") BoardModel boardModel, MultipartHttpServletRequest request){
		String orgFileName = request.getParameter("orgFile");//업로드되있는 파일
		MultipartFile newFile = request.getFile("newFile");
		String newFileName = newFile.getOriginalFilename();//새롭게업로드한 파일이름꺼냄
		
		boardModel.setFileName(orgFileName);
		
		// if: when want to change upload file
		if(newFile != null && !newFileName.equals("")){//수정하면서 새로운파일을 업로드했으면
			if(orgFileName != null || !orgFileName.equals("")){//기존에파일업로드된게있으면
				// remove uploaded file
				File removeFile = new File(uploadPath  + orgFileName);
				removeFile.delete();//기존꺼는 일단 삭제시켜라
				//
			}
			// create new upload file
			File newUploadFile = new File(uploadPath +newFileName);
			try {
				newFile.transferTo(newUploadFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//
			boardModel.setFileName(newFileName);
		}
		//
		// new line code change to <br /> tag
		String content =  boardModel.getContent().replaceAll("\r\n", "<br />");		
		boardModel.setContent(content);
		//
		
		boardService.modifyArticle(boardModel);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("idx", boardModel.getIdx());
		mav.setViewName("redirect:/board/view.do");
		return mav;
	}
	
	@RequestMapping("/delete.do")//삭제
	public ModelAndView boardDelete(HttpServletRequest request, HttpSession session){
		String userId = (String) session.getAttribute("userId");
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardModel board = boardService.getOneArticle(idx);
		
		ModelAndView mav = new ModelAndView();
		
		if(!userId.equals(board.getWriterId())){
			mav.addObject("errCode", "1");	// it's forbidden connection
			mav.addObject("idx", idx);
			mav.setViewName("redirect:view.do");
		} else {
			List<BoardCommentModel> commentList = boardService.getCommentList(idx); // check comments
			if(commentList.size() > 0){
				mav.addObject("errCode", "2"); // can't delete because a article has comments
				mav.addObject("idx", idx);
				mav.setViewName("redirect:view.do");
			} else {
				// if: when the article has upload file - remove that
				if(board.getFileName() != null){
					File removeFile = new File(uploadPath + board.getFileName());
					removeFile.delete();
				}
				//				
				boardService.deleteArticle(idx);
				
				mav.setViewName("redirect:list.do");
			}
		}		
		return mav;
	}
	
	@RequestMapping("/commentDelete.do")//댓글삭제
	public ModelAndView commendDelete(HttpServletRequest request, HttpSession session){
		int idx = Integer.parseInt(request.getParameter("idx"));
		int linkedArticleNum = Integer.parseInt(request.getParameter("linkedArticleNum"));
		
		String userId = (String) session.getAttribute("userId");
		BoardCommentModel comment = boardService.getOneComment(idx);
		
		ModelAndView mav = new ModelAndView();
		
		if(!userId.equals(comment.getWriterId())){
			mav.addObject("errCode", "1");
		} else {
			boardService.deleteComment(idx);
		}		
		//mav.addObject("a","a");		
		mav.addObject("idx", linkedArticleNum); // move back to the article//여기도 질문
		mav.setViewName("redirect:view.do");//질문 리다이렉트인데 어떻게?errCode와 idx의값을 가져가나?
			//왜 모든값이 get방식으로 넘어가는가?
		//mav.setViewName("redirect:/board/view.do");왜 둘다되는가..
		
		return mav;
	}
	
	@RequestMapping("/recommend.do")//추천하기
	public ModelAndView updateRecommendcount(HttpServletRequest request, HttpSession session){
		int idx = Integer.parseInt(request.getParameter("idx"));
		String userId = (String) session.getAttribute("userId");
		BoardModel board = boardService.getOneArticle(idx);
		
		ModelAndView mav = new ModelAndView();
		
		if(userId.equals(board.getWriterId())){
			mav.addObject("errCode", "1");
		} else {
			boardService.updateRecommendCount(board.getRecommendcount()+1, idx);
		}
		
		mav.addObject("idx", idx);
		mav.setViewName("redirect:/board/view.do");
		
		return mav;
	}
}
