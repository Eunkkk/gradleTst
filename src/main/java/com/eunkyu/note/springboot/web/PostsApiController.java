/*
    Web Layer
    - 흔히 사용되는 컨트롤러(@Controller)와 jsp등의 뷰 템플릿 영역
    - 이외에도 필터, 인터셉터 등 외부 요청과 응답에 대한 전반적인 영역 담당
 */
package com.eunkyu.note.springboot.web;

import com.eunkyu.note.springboot.service.posts.PostsService;
import com.eunkyu.note.springboot.web.dto.PostsResponseDto;
import com.eunkyu.note.springboot.web.dto.PostsSaveRequestDto;
import com.eunkyu.note.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor    //(lombok anno)final이나 @NonNull인 필드값만 파라미터로 받는 생성자를 추가
@RestController             //Spring에서 컨트롤러 중 View로 응답하지 않는 컨트롤러, 반환 결과를 JSON형태로 반환
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) { //RequestBody는 요청이 온 데이터(JSON 등)을 class에 매핑
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
