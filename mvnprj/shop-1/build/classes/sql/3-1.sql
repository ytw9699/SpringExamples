CREATE TABLE ITEM(
	ITEM_ID NUMBER,
	ITEM_NAME VARCHAR2(20),
	PRICE NUMBER,
	DESCRIPTION VARCHAR2(100),
	PICTURE_URL VARCHAR2(20),
	CONSTRAINT ITEM_ID_PK PRIMARY KEY (ITEM_ID)--ITEM_ID를 ITEM_ID_PK아이디로 PRIMARYKEY로  제약하기
);

CREATE SEQUENCE ITEM_ID_SEQ;

DELETE FROM ITEM;

drop table item purge;

INSERT INTO ITEM(ITEM_ID) VALUES(2); --한개만 값 넣기 
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'레몬',50,'레몬에 포함된 구연산은 피로회복에 좋습니다. 비타민 C도 풍부합니다.','lemon.jpg');
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'오렌지',100,'비타민 C가 풍부합니다. 생과일 주스로 마시면 좋습니다.','orange.jpg');
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'키위',200,'비타민 C가 매우 풍부합니다. 다이어트나 미용에 좋습니다.','kiui.jpg');
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'포도',300,'폴리페놀을 다량 함유하고 있어 항산화 작용을 합니다.' ,'budou.jpg');
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'딸기',800,'비타민 C나 플라보노이드를 다량 함유하고 있습니다.','ichigo.jpg');
INSERT INTO ITEM VALUES(ITEM_ID_SEQ.NEXTVAL,'귤',1000,'시네피린을 함유하고 있어 감기 예방에 좋다고 합니다.','mikan.jpg');

https://blog.naver.com/heartflow89/220984804599

1. NOT NULL : NULL을 허용하지 않는다. 즉, 필수적으로 입력해야 할 칼럼에 설정한다. 가장 많이 사용되는 제약 조건이다.
 2. UNIQUE : 중복된 값을 허용하지 않는다. 즉, 유일한 데이터를 갖는다.(NULL은 허용) UNIQUE는 많이 사용되지는 않는다.
 3. PRIMARY KEY(기본 키) :  NULL을 허용하지 않고 중복된 데이터를 허용하지 않는다.(NOT NULL + UNIQUE가 PRIMARY KEY 이다.) 따라서 데이터의 특정 조건을 검색하거나 수정 등의 작업을 할 때 기본 키로 구분한다.(ID, 주민등록 번호, 회원 번호, 글 번호 등이 기본 키에 해당된다.) 주로 테이블에 1개의 기본 키를 갖는다.
 4. FOREIGN KEY(외래 키) : 참조하는 테이블 칼럼의 데이터만을 허용한다. 참조하는 테이블은 PRIMARY KEY나 UNIQUE로 지정된 칼럼만을 FOREIGN KEY로 지정할 수 있다. 예를 들어 참조하는 테이블의 특정 컬럼의 데이터가 10, 20, 30으로 되어있다면 자식 테이블의 FOREIGN KEY로 설정한 컬럼은 10, 20, 30의 데이터만을 허용한다.
 5. CHECK : 데이터의 값의 범위나 조건을 설정하여 조건에 해당되는 데이터만 허용한다.
 6. DEFAULT : 아무런 데이터를 입력하지 않았을 경우 지정한 데이터가 자동으로 입력된다.
[출처] [Oracle/오라클] 제약조건 종류 / 설정 / 추가 - primary key, not null, foreign key, unique 등|작성자 JOKER

