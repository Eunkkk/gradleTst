/*
    Dto(Data Transfer Object)란
    - 계층 간에 데이터 교환을 위한 객체
    - 예를 들어 뷰 템플릿 엔진에서 사용될 객체나 Repository Layer에서 결과로 넘겨준 객체
    - Entity클래스와 Contoller에서 쓸 Dto는 분리해서 사용하여야 함

 */
package com.eunkyu.note.springboot.web.dto;

import com.eunkyu.note.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter             //(lombok anno) getter 메소드 자동으로 생성
@NoArgsConstructor  //(lombok anno) 기본 생성자를 자동으로 추가
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }



}
