package org.zerock.ex2.entity;

import lombok.*;

import javax.persistence.*;

@Entity// 해당 클래스가 엔티티를 위한 클래스임을 표시. 한개 이상의 테이블 생성
//해당 클래스의 인스터스들이 JAP로 관리되는 엔티티 객체라는 것을 의미
// 마치 데이터베이스의 테이블과 같은 구조로 작성
@Table(name = "tbl_memo")//관계형 데이터베이스에 생성되는 테이블과 관련된 설정
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {

    @Id//pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;
    /*GeneratedValue는 PK를 자동으로 생성하고자 할때 사용 오라클이면 별도의 번호를 위한 별도의 테이블을 생성하고,
    MariaDB이면 auto increment를 기본으로 사용해서 새로운 레코드가 기록될때마다 다른 번호를 가질수 있도록 처리
    키 생성 전략 IDENTITY = 사용하는 데이터베이스가 키 생성을 결정 MariaDB의 경우 auto increment 방식을 이용*/
    private String memoText;
}
