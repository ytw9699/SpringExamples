package com.mycom.QnA;

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

import com.mycom.util.Paging;
import com.mycom.validator.QnAValidator;
import com.mycom.validator.ReviewValidator;

@Controller
@RequestMapping("/QnA")
public class QnAController {

	@Resource
	private QnAService qnAService;
	private int searchNum;
	private String replyNum;
	private String isSearch;

	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 5;
	private String pagingHtml;
	private Paging page;

	private int comment_count;
	private int commupdate1;
	private String commenter;

	@ModelAttribute("qnaModel")
	public QnAModel formBack() {
		return new QnAModel(); // 객체 생성후 반환
	}

	@RequestMapping(value = "/QnAList.dog")
	public ModelAndView qnaList(HttpServletRequest request, QnAModel qnaModel) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();

		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		List<QnAModel> list;
		list = qnAService.QnAList();

		/* 게시판 검색 */
		String isSearch = request.getParameter("isSearch");
		if(isSearch != null) isSearch = new String(isSearch.getBytes("8859_1"), "UTF-8");

		if (isSearch != null) {
			searchNum = Integer.parseInt(request.getParameter("searchNum"));

			if (searchNum == 0) {
				list = qnAService.QnASearch0(isSearch);
			} else if (searchNum == 1) {
				list = qnAService.QnASearch1(isSearch);
			} else if (searchNum == 2) {
				list = qnAService.QnASearch2(isSearch);
				
			}
		}
		/* 답변 유무 카테고리 분류 */
		replyNum = request.getParameter("replyNum");

		if (replyNum == null) {
			System.out.println(replyNum);
			// 콤보박스가 입력이 안 된 상태
		} else {
			System.out.println(replyNum);
			// 콤보박스가 입력이 된 상태
			if (!(replyNum.equals("null"))) {
				if (replyNum.equals("1")) {
					list = qnAService.QnAreply1();
				} else if (replyNum.equals("2")) {
					list = qnAService.QnAreply2();
				}
			}

		}

		totalCount = list.size();
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "QnAList");
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount) {
			lastCount = page.getEndCount() + 1;
		}

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
		mav.addObject("commupdate1", commupdate1);
		mav.setViewName("QnAList");
		return mav;
	}

	@RequestMapping(value = "/QnAWrite.dog", method = RequestMethod.GET)
	public ModelAndView qnaForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("QnAForm");
		return mav;
	}

	@RequestMapping(value = "/QnAWrite.dog", method = RequestMethod.POST)
	public ModelAndView qnaWrite(@ModelAttribute("qnaModel") QnAModel qnaModel, HttpServletRequest request,
			HttpSession session, BindingResult result) {

		ModelAndView mav = new ModelAndView();

		/* 벨리데이트 */
		new QnAValidator().validate(qnaModel, result);
		if (result.hasErrors()) {
			System.out.println("출력" + result.getErrorCount());
			mav.setViewName("QnAForm");
			return mav;
		}

		String contents = qnaModel.getContents().replaceAll("\r\n", "<br />");
		qnaModel.setContents(contents);

		if (qnaModel.getSecret() == null) {
			qnaModel.setSecret("0");
		} else {
			qnaModel.setSecret("1");
		}

		int no = qnaModel.getNo();

		qnAService.qnaWrite(qnaModel);
		qnAService.QnAcommUpdate1(no);

		mav.addObject("QnAModel", qnaModel);
		mav.setViewName("redirect:/QnA/QnAList.dog");

		return mav;
	}

	@RequestMapping(value = "/QnAModify.dog")
	public ModelAndView qnaModifyForm(HttpServletRequest request, QnAModel qnaModel) {
		ModelAndView mav = new ModelAndView();
		qnaModel = qnAService.QnAView(qnaModel.getNo());
		String contents = qnaModel.getContents().replaceAll("\r\n", "<br />");
		qnaModel.setContents(contents);

		if (qnaModel.getSecret().equals("0"))
			qnaModel.setSecret("false");
		else {
			qnaModel.setSecret("true");
		}

		mav.addObject("qnaModel", qnaModel);
		mav.setViewName("QnAModify");

		return mav;
	}

	@RequestMapping("/QnAModifySuccess.dog")
	public ModelAndView qnaModify(@ModelAttribute("qnaModel") QnAModel qnaModel, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		String contents = qnaModel.getContents().replaceAll("\r\n", "<br />");
		qnaModel.setContents(contents);

		if (qnaModel.getSecret() == null) {
			qnaModel.setSecret("0");
		} else {
			qnaModel.setSecret("1");
		}

		qnAService.QnAModify(qnaModel);

		mav.setViewName("redirect:/QnA/QnAView.dog?no=" + qnaModel.getNo());
		return mav;
	}

	@RequestMapping(value = "/QnAView.dog")
	public ModelAndView qnaView(HttpServletRequest request, QnAModel qnaModel) {
		ModelAndView mav = new ModelAndView();

		int no = qnaModel.getNo();

		qnAService.QnAView(no);
		qnaModel = qnAService.QnAView(no);
		qnAService.QnAUpdateReadcount(no);
		comment_count = qnAService.QnAcommCount(no);
		List<QnAcommModel> QnAcommList;
		QnAcommList = qnAService.QnAcommList(no);

		/* 댓글 세기 */
		comment_count = QnAcommList.size();

		mav.addObject("CommList", QnAcommList);
		mav.addObject("comment_count", comment_count);
		mav.addObject("QnAModel", qnaModel);
		mav.setViewName("QnAView");

		return mav;
	}

	@RequestMapping(value = "/QnAcommWrite.dog", method = RequestMethod.POST)
	public ModelAndView qnacommWrite(QnAcommModel qnacommModel, QnAModel qnaModel, HttpServletRequest request,
			HttpSession session) {

		int no = qnacommModel.getContent_num();

		ModelAndView mav = new ModelAndView();
		String commentt = qnacommModel.getCommentt().replaceAll("\r\n", "<br />");
		qnacommModel.setCommentt(commentt);

		qnAService.QnAcommWrite(qnacommModel);
		qnAService.QnAcommUpdate1(no);
		commenter = qnacommModel.getCommenter();
		System.out.println(commenter);

		if (commenter.equals("admin")) {
			qnAService.AdminupdateReply(no);
		}
		mav.setViewName("redirect:/QnA/QnAView.dog?no=" + qnacommModel.getContent_num());

		return mav;
	}

	@RequestMapping(value = "/QnADelete.dog")
	public ModelAndView qnaDelete(HttpServletRequest request, QnAModel qnaModel) {
		ModelAndView mav = new ModelAndView();

		qnAService.QnADelete(qnaModel.getNo());
		qnAService.QnAallcommDelete(qnaModel.getNo());
		mav.setViewName("redirect:/QnA/QnAList.dog");

		return mav;
	}

	@RequestMapping(value = "/QnAcommDelete.dog", method = RequestMethod.GET)
	public ModelAndView qnacommDelete(HttpServletRequest request, QnAcommModel qnacommModel, QnAModel qnaModel,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();

		// System.out.println("시작할때 댓글번호 : " + qnacommModel.getComment_num());
		// System.out.println("댓글쓴사람 : "+
		// session.getAttribute("session_member_id"));

		int no = qnaModel.getNo();

		qnAService.QnAcommDelete(qnacommModel);
		// 지우는SQL 실행

		qnAService.QnAView(no);
		qnAService.QnAcommUpdate2(no);
		commenter = (String) session.getAttribute("session_member_id");
		// System.out.println("쿼리실행후 코멘터"+commenter);

		if (commenter.equals("admin")) {
			// System.out.println("if문 진입");
			qnAService.AdmindeleteReply(no);
		}

		mav.setViewName("redirect:/QnA/QnAView.dog?no=" + no);

		return mav;
	}

}
