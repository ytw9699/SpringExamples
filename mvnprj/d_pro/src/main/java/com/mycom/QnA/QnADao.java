package com.mycom.QnA;

import java.util.List;


public interface QnADao {
	
		//�۸��
		List<QnAModel> QnAList();
		
		//�۾���
		int qnaWrite(QnAModel QnAmodel);

		//�� �󼼺���
		QnAModel QnAView(int no);
		
		//��ȸ�� ����
		int QnAUpdateReadcount(int no);
		
		//�ۻ���
		int QnADelete(int no);
		
		//�ۼ���
		int QnAModify(QnAModel QnAmodel);
		
		//��۸��
		List<QnAcommModel> QnAcommList(int no);
		
		//��۾���
		int QnAcommWrite(QnAcommModel QnAcommModel);
	
		//��ۻ���
		int QnAcommDelete(QnAcommModel QnAcommModel);
		
		//��� ��� ����
		int QnAallcommDelete(int no);
		
		//��� �� ����
		int QnAcommCount(int no);
		
		//��� 1 ���
		int QnAcommUpdate1(int no);
		
		//��� 1 �϶�
		int QnAcommUpdate2(int no);
		
		//�˻� (0=����, 1=����, 2=�̸�)
		List<QnAModel> QnASearch0(String search);
		List<QnAModel> QnASearch1(String search);
		List<QnAModel> QnASearch2(String search);
		
		//�亯���� �˻�(1=�亯�Ϸ�, 2=�亯��)
		List<QnAModel> QnAreply1();
		List<QnAModel> QnAreply2();
	
		//������ ��� +1
		int AdminupdateReply(int no);
		
		//������ ��� -1
		int AdmindeleteReply(int no);
}
