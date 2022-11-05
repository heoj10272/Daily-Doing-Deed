package com.dailydoingdeed.service;

import com.dailydoingdeed.domain.posts.Posts;
import com.dailydoingdeed.domain.posts.PostsRepository;
<<<<<<< HEAD
import com.dailydoingdeed.domain.user.User;
=======
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
import com.dailydoingdeed.global.response.error.exception.EntityNotFoundException;
import com.dailydoingdeed.web.dto.PostsListResponse;
import com.dailydoingdeed.web.dto.PostsResponse;
import com.dailydoingdeed.web.dto.PostsSaveRequest;
import com.dailydoingdeed.web.dto.PostsUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
<<<<<<< HEAD

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(Posts posts) {
        return postsRepository.save(posts).getId ();
    }

    @Transactional
    public Long update(Long id, String title, String content) {
        postsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시글이 없습니다. id=" + id))
                .update(title, content);
=======
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequest requestDto) {

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequest requestDto) {
        postsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시글이 없습니다. id=" + id))
                .update(requestDto.getTitle(), requestDto.getContent());
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    @Transactional(readOnly = true)
<<<<<<< HEAD
    public Posts findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return entity;
=======
    public PostsResponse findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponse(entity);
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
    }

    @Transactional(readOnly = true)
    public List<PostsListResponse> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponse::new)
                .collect(Collectors.toList());
    }

}
