package org.zerock.ex2.entity;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import javax.persistence.*;

@Entity// 해당 클래스가 엔티티를 위한 클래스임을 표시
//해당 클래스의 인스턴스들이 JPA로 관리되는 엔티티 객체라는 것을 의미
// 마치 데이터베이스의 테이블과 같은 구조로 작성, 옵션에 따라서 자동으로 테이블을 생성
//클래스의 멤버 변수에 따라서 자동으로 칼럼들도 생성
@Table(name = "tbl_memo")//테이블 이름, 관계형 데이터베이스에 생성되는 테이블과 관련된 설정
@Data //@Builder를 이용해서 객체를 생성할수 있게 처리
@Builder //Builder 이용하기 위해서는 @AIIArgsConstructor와 @NoArgsConstructor를 항상 같이 처리해야 컴파일 에러가 발생하지않는다.
@AllArgsConstructor
@NoArgsConstructor
public class Memo {

    @Id//mno를 PK설정 : @Entity가 붙은 클래스는 Primary Key(이하 PK)에 해당하는 특정 필드를 @Id로 지정해야만 한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GeneratedValue는 시퀀스의 역할,키 생성 전략 IDENTITY = 사용하는 데이터베이스가 키 생성을 결정 MYSQL, MariaDB의 경우 auto increment 방식을 이용
    private Long mno;//MEMO의 번호 
    @Column(length = 200, nullable = false)
    private String memoText;
}

/*create table tbl_memo (

    mno bigint not null auto_increment,
    memo_text varchar(200) not null,
    primary key (mno)

) engine=InnoDB*/
