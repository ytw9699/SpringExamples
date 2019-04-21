 CREATE TABLE TB_BOARD(
    IDX NUMBER PRIMARY KEY,
    PARENT_IDX NUMBER,
    TITLE VARCHAR2(100) NOT NULL,
    CONTENTS VARCHAR2(4000) NOT NULL,
    HIT_CNT NUMBER NOT NULL,
    DEL_GB VARCHAR2(1) DEFAULT 'N' NOT NULL,--삭제에 대한 y아니면 n, 눈에보이고 안보이고 ,실제로 삭제는 안시킴
    CREA_DTM DATE DEFAULT SYSDATE NOT NULL,
    CREA_ID VARCHAR2(30) NOT NULL
);
  --답변형 게시판
COMMENT ON TABLE TB_BOARD IS '게시판';
COMMENT ON COLUMN TB_BOARD.IDX IS '인덱스';
COMMENT ON COLUMN TB_BOARD.PARENT_IDX IS '부모글 인덱스';
COMMENT ON COLUMN TB_BOARD.TITLE IS '제목';
COMMENT ON COLUMN TB_BOARD.CONTENTS IS '내용';
COMMENT ON COLUMN TB_BOARD.HIT_CNT IS '조회수';
COMMENT ON COLUMN TB_BOARD.DEL_GB IS '삭제구분';
COMMENT ON COLUMN TB_BOARD.CREA_DTM IS '생성일자';
COMMENT ON COLUMN TB_BOARD.CREA_ID IS '생성자 ID';

CREATE SEQUENCE SEQ_TB_BOARD_IDX
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
--NOMAXVALUE,NOCACHE는 설정안한다는거

INSERT INTO TB_BOARD(IDX,TITLE,CONTENTS,HIT_CNT,DEL_GB,CREA_DTM,CREA_ID)
VALUES(SEQ_TB_BOARD_IDX.NEXTVAL,'제목','내용',0,'N',SYSDATE,'Admin');


create table TB_FILE--업로드 파일정보 
(
IDX NUMBER,
BOARD_IDX NUMBER NOT NULL,--게시판의 글번호
ORIGINAL_FILE_NAME VARCHAR2(260 BYTE) NOT NULL,
STORED_FILE_NAME VARCHAR2(36 BYTE) NOT NULL,
FILE_SIZE NUMBER,
CREA_DTM DATE DEFAULT SYSDATE NOT NULL,--날짜
CREA_ID VARCHAR2(30 BYTE) NOT NULL,--아이디
DEL_GB VARCHAR2(1 BYTE) DEFAULT 'N' NOT NULL,--삭제여부
PRIMARY KEY (IDX)--프라이머리키를 idx에준다
);

CREATE SEQUENCE SEQ_TB_FILE_IDX
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;
