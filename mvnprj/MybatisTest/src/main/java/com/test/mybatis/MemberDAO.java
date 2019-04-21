package com.test.mybatis;

import java.util.ArrayList;

public interface MemberDAO {//인터페이스 만드는게 중요: 어떤 db작업을 할것인지 한눈에 명확히 보임

	public ArrayList<Member> getMembers();//리스트 리턴
	public void insertMember(Member member);//자바빈 받아서 입력하는것
	public void deleteMember(String name);//삭제
	public Member selectOne(String name);//한줄가져오기
	public void updateMember(Member member);//이름받아서 수정
}