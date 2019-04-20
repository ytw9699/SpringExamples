package com.mycom.QnA;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class QnAService implements QnADao{

		@Resource
		private SqlSessionTemplate sqlSessionTemplate;
		
		//�۸��
		@Override
		public List<QnAModel> QnAList() {
			return sqlSessionTemplate.selectList("QnA.QnAList"); 
		}

		//�۾���
		@Override
		public int qnaWrite(QnAModel qnaModel) {
			return sqlSessionTemplate.insert("QnA.QnAWrite", qnaModel);
		}

		
		//�� �ϳ� �ҷ�����
		@Override
		public QnAModel QnAView(int no) {
			return sqlSessionTemplate.selectOne("QnA.QnAView",no); 
		}
		
		//��ȸ�� ����
		@Override
		public int QnAUpdateReadcount(int no) {
			return sqlSessionTemplate.update("QnA.QnAUpdateReadcount",no); 
		}
		
		//�ۻ���
				@Override
		public int QnADelete(int no) {
			return sqlSessionTemplate.update("QnA.QnADelete",no); 
			}
				
		//�ۼ���
			@Override
		public int QnAModify(QnAModel qnaModel) {
				return sqlSessionTemplate.update("QnA.QnAModify",qnaModel); 
				}
			
		//��۸��
			@Override
			public List<QnAcommModel> QnAcommList(int no) {
				return sqlSessionTemplate.selectList("QnA.QnAcommList", no); 
			}
	

		//��۾���
			@Override
		 public int QnAcommWrite(QnAcommModel QnAcommModel){
				return sqlSessionTemplate.insert("QnA.QnAcommWrite", QnAcommModel); 
			}
					
		//��ۻ���
			@Override
		public int QnAcommDelete(QnAcommModel QnAcommModel){
				return sqlSessionTemplate.delete("QnA.QnAcommDelete",  QnAcommModel); 
			}
			
		//��� ��� ����
			@Override
		public int QnAallcommDelete(int no){
				return sqlSessionTemplate.delete("QnA.QnAallcommDelete", no); 
			}
	
		//��� �� ����
		public int QnAcommCount(int no){
			return sqlSessionTemplate.selectOne("QnA.QnAcommCount", no); 
			
		}
		
		//��� 1 ���
		public int QnAcommUpdate1(int no){
			return sqlSessionTemplate.update("QnA.QnAcommUpdate1",no);
		}
		
		//��� 1 �϶�
		public int QnAcommUpdate2(int no){
			return sqlSessionTemplate.update("QnA.QnAcommUpdate2",no);
		}
		//�Խ��� �˻�
		//�������� �˻�
		@Override
		public List<QnAModel> QnASearch0(String search) {
			return sqlSessionTemplate.selectList("QnA.QnASearch0", "%"+search+"%"); 
		}
		
		//�������� �˻�
		@Override
		public List<QnAModel> QnASearch1(String search) {
			return sqlSessionTemplate.selectList("QnA.QnASearch1", "%"+search+"%"); 
		}
		
		//�ۼ��ڷ� �˻�
		@Override
		public List<QnAModel> QnASearch2(String search) {
			return sqlSessionTemplate.selectList("QnA.QnASearch2", "%"+search+"%"); 
		}
		
		//������ �亯���� Ȯ�� �޺��ڽ�
		//�亯�Ϸ�
		@Override
		public List<QnAModel> QnAreply1() {
			return sqlSessionTemplate.selectList("QnA.QnAreply1"); 
		}
		
		//�亯��
		@Override
		public List<QnAModel> QnAreply2(){
			return sqlSessionTemplate.selectList("QnA.QnAreply2"); 
		}
		
		
		//������ ��� +1
		public int AdminupdateReply(int no){
			return sqlSessionTemplate.update("QnA.AdminupdateReply",no);
		}
		
		//������ ��� -1
		public int AdmindeleteReply(int no){
			return sqlSessionTemplate.update("QnA.AdmindeleteReply",no);
		}
}