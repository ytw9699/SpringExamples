package com.mycom.notice;

import java.util.List;
import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.mycom.notice.NoticeDAO;
import com.mycom.notice.NoticeModel;


@Service
public class NoticeService implements NoticeDAO{
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	//�۸��
	@Override
	public List<NoticeModel> noticeList() {
		return sqlSessionTemplate.selectList("notice.noticeList"); 
	}

	//�۾���
	@Override
	public int noticeWrite(NoticeModel noticeModel) {
		return sqlSessionTemplate.insert("notice.noticeWrite", noticeModel);
	}
	
	//�� �ϳ� �ҷ�����
	@Override
	public NoticeModel noticeView(int no) {
		return sqlSessionTemplate.selectOne("notice.noticeView",no); 
	}
	
	//��ȸ�� ����
	@Override
	public int noticeUpdateReadcount(int no) {
		return sqlSessionTemplate.update("notice.noticeUpdateReadcount",no); 
	}

	//�������� �˻�
	@Override
	public List<NoticeModel> noticeSearch0(String search) {
		return sqlSessionTemplate.selectList("notice.noticeSearch0", "%"+search+"%"); 
	}
	
	//�������� �˻�
	@Override
	public List<NoticeModel> noticeSearch1(String search) {
		return sqlSessionTemplate.selectList("notice.noticeSearch1", "%"+search+"%"); 
	}
	
	//�ۼ��ڷ� �˻�
	@Override
	public List<NoticeModel> noticeSearch2(String search) {
		return sqlSessionTemplate.selectList("notice.noticeSearch2", "%"+search+"%"); 
	}

	//�ۼ���
	@Override
	public int noticeModify(NoticeModel noticeModel) {
		return sqlSessionTemplate.update("notice.noticeModify",noticeModel); 
	}

	//�ۻ���
	@Override
	public int noticeDelete(int no) {
		return sqlSessionTemplate.update("notice.noticeDelete",no); 
	}
}