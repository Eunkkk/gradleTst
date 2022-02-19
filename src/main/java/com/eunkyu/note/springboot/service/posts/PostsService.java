/*
    Service Layer란
    - @Service에 사용되는 영역
    - 일반적으로 Controller와 Dao의 중간 영역에서 사용됨
    - @Transactional이 사용되어야 하는 영역
 */
package com.eunkyu.note.springboot.service.posts;

import com.eunkyu.note.springboot.domain.posts.Posts;
import com.eunkyu.note.springboot.domain.posts.PostsRepository;
import com.eunkyu.note.springboot.web.dto.PostsResponseDto;
import com.eunkyu.note.springboot.web.dto.PostsSaveRequestDto;
import com.eunkyu.note.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor        //final이나 @NonNull인 필드 값만 파라미터로 받는 생성자 추가
@Service                        //비즈니스 로직을 수행하는 클래스라는 것을 나타냄
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
