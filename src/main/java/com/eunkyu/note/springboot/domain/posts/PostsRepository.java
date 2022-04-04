/*
    Repository Layer
    -MyBatis 등에서 Dao로 불리는 DB Layer 접근자
    -Jpa에선 Repository로 부르며 인터페이스로 생성
    -생성 후 JpaRepository<Entity클래스, PK타입>을 상속
 */
package com.eunkyu.note.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
