	1.-----------------------------------------------------
	
	create table users (--게시판 테이블
	
		id varchar(10) primary key,
		name varchar(20) not null,
		password varchar(10) not null
	);
	
	create sequence seq_dk_board;
	DROP TABLE DK_BOARD PURGE;
	