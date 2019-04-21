package com.test.mybatis;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository//�ڵ���ĵ ��ü����
public class MemberDAOService implements MemberDAO {
	@Autowired//�ڵ� ����
	private SqlSession sqlSession;//SqlSessionTemplateŬ������ SqlSession�� �����ؼ� ����Ŷ� ���������� //di����
	@Override
	public ArrayList<Member> getMembers() {//�������̵�
		ArrayList<Member> result = new ArrayList<Member>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		//�����̵ɼ��ִ� �������̽��� MemberMapper.class��� ����
		//getMembers()�� �޼ҵ��� mapper.xml�� id�� �����ؾ��Ѵ�.
		//queryForList,�̷��� �Ⱦ��Ե�
		result = memberMapper.getMembers();//<select id="getMembers">  >> SELECT * FROM tab_mybatis�̰� ����
		return result;
	}
		/*@Override
		public List<BoardModel> getBoardList(int startArticleNum, int endArticleNum) {//����Ʈ
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