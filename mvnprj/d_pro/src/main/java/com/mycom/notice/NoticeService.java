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
	
	//글목록
	@Override
	public List<NoticeModel> noticeList() {
		return sqlSessionTemplate.selectList("notice.noticeList"); 
	}

	//글쓰기
	@Override
	public int noticeWrite(NoticeModel noticeModel) {
		return sqlSessionTemplate.insert("notice.noticeWrite", noticeModel);
	}
	
	//글 하나 불러오기
	@Override
	public NoticeModel noticeView(int no) {
		return sqlSessionTemplate.selectOne("notice.noticeView",no); 
	}
	
	//조회수 증가
	@Override
	public int noticeUpdateReadcount(int no) {
		return sqlSessionTemplate.update("notice.noticeUpdateReadcount",no); 
	}

	//제목으로 검색
	@Override
	public List<NoticeModel> noticeSearch0(String search) {
		return sqlSessionTemplate.selectList("notice.noticeSearch0", "%"+search+"%"); 
	}
	
	//내용으로 검색
	@Override
	public List<NoticeModel> noticeSearch1(String search) {
		return sqlSessionTemplate.selectList("notice.noticeSearch1", "%"+search+"%"); 
	}
	
	//작성자로 검색
	@Override
	public List<NoticeModel> noticeSearch2(String search) {
		return sqlSessionTemplate.selectList("notice.noticeSearch2", "%"+search+"%"); 
	}

	//글수정
	@Override
	public int noticeModify(NoticeModel noticeModel) {
		return sqlSessionTemplate.update("notice.noticeModify",noticeModel); 
	}

	//글삭제
	@Override
	public int noticeDelete(int no) {
		return sqlSessionTemplate.update("notice.noticeDelete",no); 
	}
}