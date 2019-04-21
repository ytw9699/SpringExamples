package com.test.mybatis;

import java.util.ArrayList;

import com.test.mybatis.Member;

public interface MemberMapper {//MemberDAO와 똑같은데 이걸만들어준 이유는
	//마이바티스 (MemberMapper.xml)설정할때 id에 다가 전부 이 메소드 이름을 집어넣을거 
	//MemberMapper.xml과 맵핑되는 메소드들//메소드호출해서 디비단작업할거
	ArrayList<Member> getMembers();//<select id="getMembers" 와 동일
	void insertMember(Member member);
	void deleteMember(String name);
	Member selectOne(String name);
	void updateMember(Member member);
}
/*package com.test.mybatis;

import java.util.ArrayList;

public interface MemberDAO {//인터페이스 만드는게 중요: 어떤 db작업을 할것인지 한눈에 명확히 보임

	public ArrayList<Member> getMembers();//리스트 리턴
	public void insertMember(Member member);//자바빈 받아서 입력하는것
	public void updateMember(Member member);//이름받아서 수정
	public void deleteMember(String name);//삭제
	public Member selectOne(String name);//한줄가져오기
}*/