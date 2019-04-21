package com.test.mybatis;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository//자동스캔 객체생성
public class MemberDAOService implements MemberDAO {
	@Autowired//자동 주입
	private SqlSession sqlSession;//SqlSessionTemplate클래스는 SqlSession을 구현해서 만든거랑 다형성개념 //di설정
	@Override
	public ArrayList<Member> getMembers() {//오버라이드
		ArrayList<Member> result = new ArrayList<Member>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		//맵핑이될수있는 인터페이스는 MemberMapper.class라고 연결
		//getMembers()의 메소드명과 mapper.xml과 id는 동일해야한다.
		//queryForList,이런거 안쓰게됨
		result = memberMapper.getMembers();//<select id="getMembers">  >> SELECT * FROM tab_mybatis이게 동작
		return result;
	}
		/*@Override
		public List<BoardModel> getBoardList(int startArticleNum, int endArticleNum) {//리스트
			valueMap.put("startArticleNum", startArticleNum);
			valueMap.put("endArticleNum", endArticleNum);
			return sqlMapClientTemplate.queryForList("board.getBoardList", valueMap);
		}*/
	@Override
	public void insertMember(Member member) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.insertMember(member);
	}
	@Override
	public void deleteMember(String name) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.deleteMember(name);
	}
	@Override
	public Member selectOne(String name) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		return memberMapper.selectOne(name);
	}
	@Override
	public void updateMember(Member member) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.updateMember(member);
	}
}