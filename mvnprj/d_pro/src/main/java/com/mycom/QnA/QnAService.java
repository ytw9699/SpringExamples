package com.mycom.QnA;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class QnAService implements QnADao{

		@Resource
		private SqlSessionTemplate sqlSessionTemplate;
		
		//글목록
		@Override
		public List<QnAModel> QnAList() {
			return sqlSessionTemplate.selectList("QnA.QnAList"); 
		}

		//글쓰기
		@Override
		public int qnaWrite(QnAModel qnaModel) {
			return sqlSessionTemplate.insert("QnA.QnAWrite", qnaModel);
		}

		
		//글 하나 불러오기
		@Override
		public QnAModel QnAView(int no) {
			return sqlSessionTemplate.selectOne("QnA.QnAView",no); 
		}
		
		//조회수 증가
		@Override
		public int QnAUpdateReadcount(int no) {
			return sqlSessionTemplate.update("QnA.QnAUpdateReadcount",no); 
		}
		
		//글삭제
				@Override
		public int QnADelete(int no) {
			return sqlSessionTemplate.update("QnA.QnADelete",no); 
			}
				
		//글수정
			@Override
		public int QnAModify(QnAModel qnaModel) {
				return sqlSessionTemplate.update("QnA.QnAModify",qnaModel); 
				}
			
		//댓글목록
			@Override
			public List<QnAcommModel> QnAcommList(int no) {
				return sqlSessionTemplate.selectList("QnA.QnAcommList", no); 
			}
	

		//댓글쓰기
			@Override
		 public int QnAcommWrite(QnAcommModel QnAcommModel){
				return sqlSessionTemplate.insert("QnA.QnAcommWrite", QnAcommModel); 
			}
					
		//댓글삭제
			@Override
		public int QnAcommDelete(QnAcommModel QnAcommModel){
				return sqlSessionTemplate.delete("QnA.QnAcommDelete",  QnAcommModel); 
			}
			
		//댓글 모두 삭제
			@Override
		public int QnAallcommDelete(int no){
				return sqlSessionTemplate.delete("QnA.QnAallcommDelete", no); 
			}
	
		//댓글 총 개수
		public int QnAcommCount(int no){
			return sqlSessionTemplate.selectOne("QnA.QnAcommCount", no); 
			
		}
		
		//댓글 1 상승
		public int QnAcommUpdate1(int no){
			return sqlSessionTemplate.update("QnA.QnAcommUpdate1",no);
		}
		
		//댓글 1 하락
		public int QnAcommUpdate2(int no){
			return sqlSessionTemplate.update("QnA.QnAcommUpdate2",no);
		}
		//게시판 검색
		//제목으로 검색
		@Override
		public List<QnAModel> QnASearch0(String search) {
			return sqlSessionTemplate.selectList("QnA.QnASearch0", "%"+search+"%"); 
		}
		
		//내용으로 검색
		@Override
		public List<QnAModel> QnASearch1(String search) {
			return sqlSessionTemplate.selectList("QnA.QnASearch1", "%"+search+"%"); 
		}
		
		//작성자로 검색
		@Override
		public List<QnAModel> QnASearch2(String search) {
			return sqlSessionTemplate.selectList("QnA.QnASearch2", "%"+search+"%"); 
		}
		
		//관리자 답변유무 확인 콤보박스
		//답변완료
		@Override
		public List<QnAModel> QnAreply1() {
			return sqlSessionTemplate.selectList("QnA.QnAreply1"); 
		}
		
		//답변전
		@Override
		public List<QnAModel> QnAreply2(){
			return sqlSessionTemplate.selectList("QnA.QnAreply2"); 
		}
		
		
		//관리자 댓글 +1
		public int AdminupdateReply(int no){
			return sqlSessionTemplate.update("QnA.AdminupdateReply",no);
		}
		
		//관리자 댓글 -1
		public int AdmindeleteReply(int no){
			return sqlSessionTemplate.update("QnA.AdmindeleteReply",no);
		}
}