package com.mycom.notice;

import java.util.List;

public interface NoticeDAO {

	//글목록
	List<NoticeModel> noticeList();

	//글쓰기
	int noticeWrite(NoticeModel noticeModel);

	//글 상세보기
	NoticeModel noticeView(int no);
	
	//조회수 증가
	int noticeUpdateReadcount(int no);

	//검색 (0=제목, 1=내용, 2=이름)
	List<NoticeModel> noticeSearch0(String search);
	List<NoticeModel> noticeSearch1(String search);
	List<NoticeModel> noticeSearch2(String search);
	
	//글수정
	int noticeModify(NoticeModel noticeModel);

	//글삭제
	int noticeDelete(int no);
	
}