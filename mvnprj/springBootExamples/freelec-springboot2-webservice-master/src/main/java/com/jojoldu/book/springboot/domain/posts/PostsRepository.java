package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
//JpaRepository는 MyBatis 등에서 Dao라고 불 리는 DB Layer 접근자이다.
//JPA에 선 Repository라고 부르며 인터페이스로 생성한다
// JpaReposirory<Enrity 클래스, PK 타입>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
