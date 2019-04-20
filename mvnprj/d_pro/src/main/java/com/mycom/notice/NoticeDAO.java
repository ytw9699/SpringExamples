package com.mycom.notice;

import java.util.List;

public interface NoticeDAO {

	//�۸��
	List<NoticeModel> noticeList();

	//�۾���
	int noticeWrite(NoticeModel noticeModel);

	//�� �󼼺���
	NoticeModel noticeView(int no);
	
	//��ȸ�� ����
	int noticeUpdateReadcount(int no);

	//�˻� (0=����, 1=����, 2=�̸�)
	List<NoticeModel> noticeSearch0(String search);
	List<NoticeModel> noticeSearch1(String search);
	List<NoticeModel> noticeSearch2(String search);
	
	//�ۼ���
	int noticeModify(NoticeModel noticeModel);

	//�ۻ���
	int noticeDelete(int no);
	
}