package com.test.mybatis;

import java.util.ArrayList;

public interface MemberDAO {//�������̽� ����°� �߿�: � db�۾��� �Ұ����� �Ѵ��� ��Ȯ�� ����

	public ArrayList<Member> getMembers();//����Ʈ ����
	public void insertMember(Member member);//�ڹٺ� �޾Ƽ� �Է��ϴ°�
	public void deleteMember(String name);//����
	public Member selectOne(String name);//���ٰ�������
	public void updateMember(Member member);//�̸��޾Ƽ� ����
}