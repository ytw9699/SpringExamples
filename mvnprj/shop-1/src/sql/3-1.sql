CREATE TABLE ITEM(
	ITEM_ID NUMBER,
	ITEM_NAME VARCHAR2(20),
	PRICE NUMBER,
	DESCRIPTION VARCHAR2(100),
	PICTURE_URL VARCHAR2(20),
	CONSTRAINT ITEM_ID_PK PRIMARY KEY (ITEM_ID)--ITEM_ID�� ITEM_ID_PK���̵�� PRIMARYKEY��  �����ϱ�
);

CREATE SEQUENCE ITEM_ID_SEQ;

DELETE FROM ITEM;

drop table item purge;

INSERT INTO ITEM(ITEM_ID) VALUES(2); --�Ѱ��� �� �ֱ� 
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'����',50,'���� ���Ե� �������� �Ƿ�ȸ���� �����ϴ�. ��Ÿ�� C�� ǳ���մϴ�.','lemon.jpg');
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'������',100,'��Ÿ�� C�� ǳ���մϴ�. ������ �ֽ��� ���ø� �����ϴ�.','orange.jpg');
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'Ű��',200,'��Ÿ�� C�� �ſ� ǳ���մϴ�. ���̾�Ʈ�� �̿뿡 �����ϴ�.','kiui.jpg');
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'����',300,'��������� �ٷ� �����ϰ� �־� �׻�ȭ �ۿ��� �մϴ�.' ,'budou.jpg');
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'����',800,'��Ÿ�� C�� �ö󺸳��̵带 �ٷ� �����ϰ� �ֽ��ϴ�.','ichigo.jpg');
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'��',1000,'�ó��Ǹ��� �����ϰ� �־� ���� ���濡 ���ٰ� �մϴ�.','mikan.jpg');

https://blog.naver.com/heartflow89/220984804599

1. NOT NULL : NULL�� ������� �ʴ´�. ��, �ʼ������� �Է��ؾ� �� Į���� �����Ѵ�. ���� ���� ���Ǵ� ���� �����̴�.
 2. UNIQUE : �ߺ��� ���� ������� �ʴ´�. ��, ������ �����͸� ���´�.(NULL�� ���) UNIQUE�� ���� �������� �ʴ´�.
 3. PRIMARY KEY(�⺻ Ű) :  NULL�� ������� �ʰ� �ߺ��� �����͸� ������� �ʴ´�.(NOT NULL + UNIQUE�� PRIMARY KEY �̴�.) ���� �������� Ư�� ������ �˻��ϰų� ���� ���� �۾��� �� �� �⺻ Ű�� �����Ѵ�.(ID, �ֹε�� ��ȣ, ȸ�� ��ȣ, �� ��ȣ ���� �⺻ Ű�� �ش�ȴ�.) �ַ� ���̺� 1���� �⺻ Ű�� ���´�.
 4. FOREIGN KEY(�ܷ� Ű) : �����ϴ� ���̺� Į���� �����͸��� ����Ѵ�. �����ϴ� ���̺��� PRIMARY KEY�� UNIQUE�� ������ Į������ FOREIGN KEY�� ������ �� �ִ�. ���� ��� �����ϴ� ���̺��� Ư�� �÷��� �����Ͱ� 10, 20, 30���� �Ǿ��ִٸ� �ڽ� ���̺��� FOREIGN KEY�� ������ �÷��� 10, 20, 30�� �����͸��� ����Ѵ�.
 5. CHECK : �������� ���� ������ ������ �����Ͽ� ���ǿ� �ش�Ǵ� �����͸� ����Ѵ�.
 6. DEFAULT : �ƹ��� �����͸� �Է����� �ʾ��� ��� ������ �����Ͱ� �ڵ����� �Էµȴ�.
[��ó] [Oracle/����Ŭ] �������� ���� / ���� / �߰� - primary key, not null, foreign key, unique ��|�ۼ��� JOKER

