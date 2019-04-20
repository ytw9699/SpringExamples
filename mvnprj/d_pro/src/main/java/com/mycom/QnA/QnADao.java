package com.mycom.QnA;

import java.util.List;


public interface QnADao {
	
		//글목록
		List<QnAModel> QnAList();
		
		//글쓰기
		int qnaWrite(QnAModel QnAmodel);

		//글 상세보기
		QnAModel QnAView(int no);
		
		//조회수 증가
		int QnAUpdateReadcount(int no);
		
		//글삭제
		int QnADelete(int no);
		
		//글수정
		int QnAModify(QnAModel QnAmodel);
		
		//댓글목록
		List<QnAcommModel> QnAcommList(int no);
		
		//댓글쓰기
		int QnAcommWrite(QnAcommModel QnAcommModel);
	
		//댓글삭제
		int QnAcommDelete(QnAcommModel QnAcommModel);
		
		//댓글 모두 삭제
		int QnAallcommDelete(int no);
		
		//댓글 총 개수
		int QnAcommCount(int no);
		
		//댓글 1 상승
		int QnAcommUpdate1(int no);
		
		//댓글 1 하락
		int QnAcommUpdate2(int no);
		
		//검색 (0=제목, 1=내용, 2=이름)
		List<QnAModel> QnASearch0(String search);
		List<QnAModel> QnASearch1(String search);
		List<QnAModel> QnASearch2(String search);
		
		//답변유무 검색(1=답변완료, 2=답변전)
		List<QnAModel> QnAreply1();
		List<QnAModel> QnAreply2();
	
		//관리자 댓글 +1
		int AdminupdateReply(int no);
		
		//관리자 댓글 -1
		int AdmindeleteReply(int no);
}
