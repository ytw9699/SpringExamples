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
	private int showArticleLimit = 3; //���������� �Խñ� �� ���� change value if want to show more articles by one page
	private int showPageLimit = 10; //��� �� ������ �� ���� change value if want to show more page links
	private int startArticleNum = 0;//Ư�� �������� �ҷ��� �Խñ��� ù��° ��ȣ �⺻��
	private int endArticleNum = 0;//Ư�� �������� �ҷ��� �Խñ��� ������ ��ȣ �⺻��
	private int totalNum = 0;
	private String uploadPath = "F:\\java\\App\\SummerBoard\\WebContent\\files\\";//���� \\�������
	
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
startArticleNum = (currentPage - 1) * showArticleLimit + 1;//1 Ư�� �������� �ҷ��� �Խñ��� ù��° ��ȣ
endArticleNum = startArticleNum + showArticleLimit -1;//10 Ư�� �������� �ҷ��� �Խñ��� ������ ��ȣ

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
	//����¡�ϴ� �޼ҵ� ��Ʈ���������� Ŭ������ ���µ� ���⼭�� �޼ҵ�� �����������
	private StringBuffer getPageHtml(int currentPage, int totalNum, int showArticleLimit, int showPageLimit, String type, String keyword) {
		StringBuffer pageHtml = new StringBuffer();//����¡�κ�
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
				pageHtml.append("<span><a href=\"list.do?page=" + (currentPage-1) + "\"><����></a>&nbsp;&nbsp;");
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
				pageHtml.append(".&nbsp;&nbsp;<a href=\"list.do?page=" + (currentPage+1) + "\"><����></a></span>");
			}
		//
		// else: when search
		} else {			
			if(currentPage == 1){
				pageHtml.append("<span>");
			} else {
				pageHtml.append("<span><a href=\"list.do?page=" + (currentPage-1) + "&type=" + type + "&keyword=" + keyword + "\"><����></a>&nbsp;&nbsp;");
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
				pageHtml.append(".&nbsp;&nbsp;<a href=\"list.do?page=" + (currentPage+1) + "&type=" + type + "&keyword=" + keyword + "\"><����></a></span>");
			}
		}
		//		
		return pageHtml;
	}
	@RequestMapping("/AlarmWrite.do")//�˶��Է�
	public ModelAndView commentWriteProc(@ModelAttribute("AlarmModel") AlarmModel AlarmModel){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:list.do");
		boardService.pushinsert(AlarmModel);
		
		return mav;
	}
	@RequestMapping("/alarm.do")
	public ModelAndView alarm(HttpSession session){		
		
		String userId = (String) session.getAttribute("userId");//�߰� 

		ModelAndView mav = new ModelAndView();

		if(userId != null){
		List<AlarmModel> alarm = boardService.getAlarm(userId);//�߰�//board���̺� ����Ʈ ����
		mav.addObject("alarmList", alarm);
		}
		mav.setViewName("/board/alarm");//list.jsp
			
	    return mav;
	}
	/*@RequestMapping("/alarm.do")
	public ModelAndView alarm(HttpSession session){		
		
		String userId = (String) session.getAttribute("userId");//�߰� 

		ModelAndView mav = new ModelAndView();

		if(userId != null){
		List<BoardModel> board = boardService.getPush(userId);//�߰�//board���̺� ����Ʈ ����
		mav.addObject("pushList", board);
		}
		mav.setViewName("/board/alarm");//list.jsp
			
	    return mav;
	}*/
	@RequestMapping("/write.do")//������
	public String boardWrite(){		
		return "/board/write";//������
	}
	@RequestMapping(value="/write.do", method=RequestMethod.POST)//���Է�ó��
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
			file.transferTo(uploadFile);//���ε� �Ϸ�
		} catch (Exception e) {
			
		}
		boardModel.setFileName(fileName);
		// new line code change to <br /> tag	
		String content =  boardModel.getContent().replaceAll("\r\n", "<br />");//\r\n �ٹٲ� ���͸�   br�±׷� �ٲ��		
		//getContent() ������ ��Ʈ����ü���� �� ����κ�//�ٹٲ㼭 ������ ������ , or <pre>�±� �ᵵ��
		boardModel.setContent(content);
		//
		boardService.writeArticle(boardModel);	
		
		return "redirect:list.do";
	}
@RequestMapping("/view.do")//�󼼺���
public ModelAndView boardView(HttpServletRequest request){
	int idx = Integer.parseInt(request.getParameter("idx"));		
	
	BoardModel board = boardService.getOneArticle(idx); // get selected article model
	boardService.updateHitcount(board.getHitcount()+1, idx); // update hitcount
	//System.out.println(BackPush);
	List<BoardCommentModel> commentList = boardService.getCommentList(idx); // get comment list
	
	if( request.getParameter("BackPush") != null ){
		String BackPush = request.getParameter("BackPush");
		if( BackPush.equals("0") ){
			boardService.BackPush(idx);//�߰�
			}
		}
	if( request.getParameter("alarmidx") != null ){
		int alarmidx = Integer.parseInt(request.getParameter("alarmidx"));//�߰�	
		boardService.deleteAlarm(alarmidx);//�߰�
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
	@RequestMapping("/commentWrite.do")//����Է�
	public ModelAndView commentWriteProc(@ModelAttribute("CommentModel") BoardCommentModel commentModel){
		// new line code change to <br /> tag
		String content = commentModel.getContent().replaceAll("\r\n", "<br />");
		commentModel.setContent(content);
		//
		boardService.writeComment(commentModel);
		ModelAndView mav = new ModelAndView();
		mav.addObject("idx", commentModel.getLinkedArticleNum());
		mav.setViewName("redirect:view.do");//�����̷�Ʈ�ϸ� addObject�� �߰��Ѱ� �ٹ�����δ� �Ѿ�� ������Ʈ�������� ����ȵ�
		
		boardService.push(commentModel.getLinkedArticleNum());	//�˸� �߰��κ�//�ش�ۿ� push�� 1����
		
		return mav;
	}
	
	@RequestMapping("/modify.do")//�����Ͳ����ͼ� ������ �����ִ°�
	public ModelAndView boardModify(HttpServletRequest request, HttpSession session){
		String userId = (String) session.getAttribute("userId");
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardModel board = boardService.getOneArticle(idx);
		// <br /> tag change to new line code
		String content = board.getContent().replaceAll("<br />", "\r\n");//�����ͼ��� �ٽ� ���ٷ� br�±׸� \r\n����
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
	@RequestMapping(value = "/modify.do", method=RequestMethod.POST)//��¥ ����
	public ModelAndView boardModifyProc(@ModelAttribute("BoardModel") BoardModel boardModel, MultipartHttpServletRequest request){
		String orgFileName = request.getParameter("orgFile");//���ε���ִ� ����
		MultipartFile newFile = request.getFile("newFile");
		String newFileName = newFile.getOriginalFilename();//���ӰԾ��ε��� �����̸�����
		
		boardModel.setFileName(orgFileName);
		
		// if: when want to change upload file
		if(newFile != null && !newFileName.equals("")){//�����ϸ鼭 ���ο������� ���ε�������
			if(orgFileName != null || !orgFileName.equals("")){//���������Ͼ��ε�Ȱ�������
				// remove uploaded file
				File removeFile = new File(uploadPath  + orgFileName);
				removeFile.delete();//�������� �ϴ� �������Ѷ�
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
	
	@RequestMapping("/delete.do")//����
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
	
	@RequestMapping("/commentDelete.do")//��ۻ���
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
		mav.addObject("idx", linkedArticleNum); // move back to the article//���⵵ ����
		mav.setViewName("redirect:view.do");//���� �����̷�Ʈ�ε� ���?errCode�� idx�ǰ��� ��������?
			//�� ��簪�� get������� �Ѿ�°�?
		//mav.setViewName("redirect:/board/view.do");�� �ѴٵǴ°�..
		
		return mav;
	}
	
	@RequestMapping("/recommend.do")//��õ�ϱ�
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
