/*
    domain model
    -
 */

package com.eunkyu.note.springboot.domain.posts;

import com.eunkyu.note.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter             //(lombok anno) getter 메소드를 자동으로 추가
@NoArgsConstructor  //(lombok anno)기본 생성자를 자동으로 추가
@Entity             //(jpa anno)실제 DB의 테이블과 매칭될 클래스임을 명시
public class Posts extends BaseTimeEntity {
    @Id //해당 테이블의 PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙 auto_increment
    private Long id;

    @Column(length = 500, nullable = false)     //테이블의 컬럼을 나타냄 굳이 선언하지 않아도 컬럼이 됨.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder        //생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
