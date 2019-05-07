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


alter table tbl_board add constraint pk_board 
primary key (bno);

insert into tbl_board(bno, title, content, writer)
values (seq_board.nextval, '테스트 제목','테스트 내용','user00');

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