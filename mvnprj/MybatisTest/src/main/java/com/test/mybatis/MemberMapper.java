package com.test.mybatis;

import java.util.ArrayList;

import com.test.mybatis.Member;

public interface MemberMapper {//MemberDAO�� �Ȱ����� �̰ɸ������ ������
	//���̹�Ƽ�� (MemberMapper.xml)�����Ҷ� id�� �ٰ� ���� �� �޼ҵ� �̸��� ��������� 
	//MemberMapper.xml�� ���εǴ� �޼ҵ��//�޼ҵ�ȣ���ؼ� �����۾��Ұ�
	ArrayList<Member> getMembers();//<select id="getMembers" �� ����
	void insertMember(Member member);
	void deleteMember(String name);
	Member selectOne(String name);
	void updateMember(Member member);
}
/*package com.test.mybatis;

import java.util.ArrayList;

public interface MemberDAO {//�������̽� ����°� �߿�: � db�۾��� �Ұ����� �Ѵ��� ��Ȯ�� ����

	public ArrayList<Member> getMembers();//����Ʈ ����
	public void insertMember(Member member);//�ڹٺ� �޾Ƽ� �Է��ϴ°�
	public void updateMember(Member member);//�̸��޾Ƽ� ����
	public void deleteMember(String name);//����
	public Member selectOne(String name);//���ٰ�������
}*/