package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter//클래스 내 모든 필드의 Getter 메소드를 자동생성
@NoArgsConstructor//기본 생성자 자동추가 public Posts( ) {}와 같은 효과
@Entity//실제 테이블과 매칭될 Entity 클래스
public class Posts extends BaseTimeEntity {

    @Id//해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK 의 생성 규칙//auto_incremen
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder//해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {//생성자나 빌더 나 생성 시점에 값을 채워주는 역할은 똑같
        //하지만 빌더 를 사용하게 되면 어느 필드에 어떤 값을 채워야할지 명확하게 인지할 수 있다.
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
    /*Entity 클래스에서는 절대 Setter 메소드를 만들지 않고 해당 필드의 값 변경이 필요하면 명확히
    그 목적과 의도를 나타낼 수 있는 메소드를 추가한다.*/
}
