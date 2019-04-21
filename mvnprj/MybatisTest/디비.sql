1. 이렇게 만들던가
create table tab_mybatis(
	name varchar2(10) primary key,
	email varchar2(100),
	phone varchar2(11)
);


2. 번호를 줘서 기준을 잡아 만들던가
create table tab_mybatis(
	idx number primary key,
	name varchar2(10) primary key,
	email varchar2(100),
	phone varchar2(11)
);  

create sequence idxseq;--회원번호 집어넣을떼쓸 시퀀스

