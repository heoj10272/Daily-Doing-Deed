package com.dailydoingdeed.posts;

import com.dailydoingdeed.domain.posts.Posts;
import com.dailydoingdeed.domain.posts.PostsRepository;
import com.dailydoingdeed.global.response.error.exception.EntityNotFoundException;
import com.dailydoingdeed.web.dto.PostsListResponseDto;
import com.dailydoingdeed.web.dto.PostsResponseDto;
import com.dailydoingdeed.web.dto.PostsSaveRequestDto;
import com.dailydoingdeed.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        postsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시글이 없습니다. id=" + id))
                .update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

}
