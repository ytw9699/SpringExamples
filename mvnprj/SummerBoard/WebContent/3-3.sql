	5. DB ����
	create table JMBoard_Member(--ȸ������
		idx number primary key, --ȸ����ȣ
		userId varchar2(20) not null, 
		userPw varchar2(20) not null, 
		userName varchar2(50) not null, 
		joinDate date not null
	)
	create sequence MEMBERSEQ;--ȸ����ȣ ����������� ������
	
	create table jmboard(--�Խ��� ���̺�,ref,res����� �亯�� �Խ��� �ƴϴ�
		idx number primary key, --�Խ��� �۹�ȣ
		writer varchar2(50) not null, --�ۼ���
		subject varchar2(100) not null, --����
		content varchar2(4000) not null, --�۳���
		hitcount number default '0', --��ȸ��
		recommendcount number default '0',--��õ�� 
		writeDate date not null, --�ۼ���¥
		writerId varchar2(20) not null, --�ۼ��� ���̵�
		fileName varchar2(50), --�����̸� ���ε�
		push number default 0 --Ǫ�� �˸�y,n
	)
	create sequence BOARDLISTSEQ;----�Խ��� �۹�ȣ ������
	
	create table jmboard_comment(--��۰���
		idx number primary key, --�۹�ȣ
		writer varchar2(50) not null, 
		content varchar2(4000) not null, 
		writeDate date not null, 
		linkedArticleNum number not null,--�����Խù��� �۹�ȣ ���� idx number primary key,
		writerId varchar2(20) not null
	)
	create sequence BOARDCOMMENTSEQ;----��� �۹�ȣ ������

	create table alarm(
		idx number primary key,--�˶���ȣ
		showhide varchar2(20) default 'N' ,-- �˶� ���� ����
		kind varchar2(20), --�˶�����
		id varchar2(50), --�˶������̵�
		productnumber number,--��ǰ�۹�ȣ
		ordernumber number--�ֹ��۹�ȣ
	)
	
	create sequence ALARMSEQ; --�˶���ȣ ������
