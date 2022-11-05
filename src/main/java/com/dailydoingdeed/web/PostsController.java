package com.dailydoingdeed.web;

import com.dailydoingdeed.domain.posts.Posts;
import com.dailydoingdeed.global.response.common.ListResponseData;
import com.dailydoingdeed.global.response.common.SingleResponseData;
import com.dailydoingdeed.service.CommentService;
import com.dailydoingdeed.service.PostsService;
import com.dailydoingdeed.web.dto.PostsListResponse;
import com.dailydoingdeed.web.dto.PostsResponse;
import com.dailydoingdeed.web.dto.PostsSaveRequest;
import com.dailydoingdeed.web.dto.PostsUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostsController {

    private final PostsService postsService;
    private final CommentService commentService;

    @PostMapping
    public SingleResponseData<Long> save(@RequestBody PostsSaveRequest request){
        return SingleResponseData.of(postsService.save(request.toEntity ()));
    }

    @PatchMapping("/{id}")
    public SingleResponseData<Long> update(@PathVariable Long id, @RequestBody PostsUpdateRequest request){
        return SingleResponseData.of(postsService.update(id, request.getTitle (), request.getContent ()));
    }

    @DeleteMapping("/{id}")
    public SingleResponseData<Long> delete(@PathVariable Long id) {
        postsService.delete(id);
        return SingleResponseData.of(id);
    }

    @GetMapping("/{id}")
    public SingleResponseData<PostsResponse> findById(@PathVariable Long id){
        PostsResponse postsResponse = new PostsResponse (postsService.findById(id), commentService.findAllDesc(id));
        return SingleResponseData.of(postsResponse);
    }

    @GetMapping("/all")
    public ListResponseData<PostsListResponse> all(){
        return ListResponseData.of(postsService.findAllDesc());
    }
}
