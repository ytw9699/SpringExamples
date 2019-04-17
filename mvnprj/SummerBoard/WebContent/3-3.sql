	5. DB 설계
	create table JMBoard_Member(--회원가입
		idx number primary key, --회원번호
		userId varchar2(20) not null, 
		userPw varchar2(20) not null, 
		userName varchar2(50) not null, 
		joinDate date not null
	)
	create sequence MEMBERSEQ;--회원번호 집어넣을떼쓸 시퀀스
	
	create table jmboard(--게시판 테이블,ref,res가없어서 답변형 게시판 아니다
		idx number primary key, --게시판 글번호
		writer varchar2(50) not null, --작성자
		subject varchar2(100) not null, --제목
		content varchar2(4000) not null, --글내용
		hitcount number default '0', --조회수
		recommendcount number default '0',--추천수 
		writeDate date not null, --작성날짜
		writerId varchar2(20) not null, --작성자 아이디
		fileName varchar2(50), --파일이름 업로드
		push number default 0 --푸시 알림y,n
	)
	create sequence BOARDLISTSEQ;----게시판 글번호 시퀀스
	
	create table jmboard_comment(--댓글관련
		idx number primary key, --글번호
		writer varchar2(50) not null, 
		content varchar2(4000) not null, 
		writeDate date not null, 
		linkedArticleNum number not null,--원본게시물의 글번호 연결 idx number primary key,
		writerId varchar2(20) not null
	)
	create sequence BOARDCOMMENTSEQ;----댓글 글번호 시퀀스

	create table alarm(
		idx number primary key,--알람번호
		showhide varchar2(20) default 'N' ,-- 알람 읽음 유무
		kind varchar2(20), --알람종류
		id varchar2(50), --알람대상아이디
		productnumber number,--상품글번호
		ordernumber number--주문글번호
	)
	
	create sequence ALARMSEQ; --알람번호 시퀀스
