create sequence seq_board;

create table tbl_board (
  bno number(10,0),
  title varchar2(200) not null,
  content varchar2(2000) not null,
  writer varchar2(50) not null,
  regdate date default sysdate, 
  updatedate date default sysdate
);

DROP TABLE tbl_board PURGE;

alter table tbl_board add constraint pk_board primary key (bno);

insert into tbl_board(bno, title, content, writer)
values (seq_board.nextval, '테스트 제목','테스트 내용','user00');

select * from tbl_board order by bno desc;

--재귀 복사를 통해서 2배씩 증가시킴
insert into tbl_board(bno, title, content, writer)
(select seq_board.nextval, title, content, writer from tbl_board);

select count(*) from tbl_board

--tbl_board 테이블에 pk_board 인덱스를 역순으로 이용해 줄 것
select /*+ INDEX_DESC(tbl_board pk_board) */ * from tbl_board where bno > 0

select * /*+ INDEX_DESC(tbl_board pk_board) */ from tbl_board where bno > 0

select * from tbl_board where bno = 26746;

select rownum rn, bno, title from tbl_board

select /* INDEX_ASC(tbl_board pk_board) */ rownum rn, bno, title, content from tbl_board where rownum <=10

select bno, title, content from ( 
select /*+ INDEX_DESC(tbl_board pk_board) */ rownum rn, bno, title, content from tbl_board where rownum <= 20 
) where rn >10;

alter table tbl_board add (replycnt number default 0 );

update tbl_board set replycny = (select count(rno) from tbl_reply where tbl_reply.bno = tbl_board.bno);

create table tbl_reply (
rno number(10,0),
bno number(10,0) not null,
reply varchar2(1000) not null,
replyer varchar2(50) not null,
replyDate date default sysdate,
updateDate date default sysdate
);

create sequence seq_reply;

alter table tbl_reply add constraint pk_reply primary key (rno);

alter table tbl_reply add constraint fk_reply_board

foreign key (bno) references tbl_board (bno);

insert into tbl_reply(rno,bno,reply,replyer) values (seq_reply.nextval,221, 'test', 'test')
-----------------------------------------------------------------------------------------------
create table tbl_attach(
uuid varchar2(100) not null,
uploadPath varchar2(200) not null,-- 실제 파일이 업로드된 경로
fileName varchar2(100) not null, --파일 이름을 의미
fileType char(1) default 'I', --이미지 파일 여부를판단
bno number(10,0) -- 해당 게시물 번호를 저장
);

alter table tbl_attach add constraint pk_attach primary key (uuid);
alter table tbl_attach add constraint fk_board_attach foreign key (bno) references tbl_board(bno);

insert into tbl_attach(uuid, uploadPath, fileName, bno)
values ('11', '테스트 제목','테스트 내용',3);

-----------------------------------------------------------------------------------------------