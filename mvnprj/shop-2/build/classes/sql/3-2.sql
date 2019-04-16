CREATE TABLE ITEM(
	ITEM_ID NUMBER,
	ITEM_NAME VARCHAR2(20),
	PRICE NUMBER,
	DESCRIPTION VARCHAR2(100),
	PICTURE_URL VARCHAR2(20),
	CONSTRAINT ITEM_ID_PK PRIMARY KEY (ITEM_ID)
);

CREATE SEQUENCE ITEM_ID_SEQ;

DELETE FROM ITEM;

INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'����',50,'���� ���Ե� �������� �Ƿ�ȸ���� �����ϴ�. ��Ÿ�� C�� ǳ���մϴ�.','lemon.jpg');
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'������',100,'��Ÿ�� C�� ǳ���մϴ�. ������ �ֽ��� ���ø� �����ϴ�.','orange.jpg');
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'Ű��',200,'��Ÿ�� C�� �ſ� ǳ���մϴ�. ���̾�Ʈ�� �̿뿡 �����ϴ�.','kiui.jpg');
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'����',300,'��������� �ٷ� �����ϰ� �־� �׻�ȭ �ۿ��� �մϴ�.' ,'budou.jpg');
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'����',800,'��Ÿ�� C�� �ö󺸳��̵带 �ٷ� �����ϰ� �ֽ��ϴ�.','ichigo.jpg');
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'��',1000,'�ó��Ǹ��� �����ϰ� �־� ���� ���濡 ���ٰ� �մϴ�.','mikan.jpg');