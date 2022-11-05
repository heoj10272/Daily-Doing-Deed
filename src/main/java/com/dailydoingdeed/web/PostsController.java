package com.dailydoingdeed.web;

<<<<<<< HEAD
import com.dailydoingdeed.domain.posts.Posts;
import com.dailydoingdeed.global.response.common.ListResponseData;
import com.dailydoingdeed.global.response.common.SingleResponseData;
import com.dailydoingdeed.service.CommentService;
=======
import com.dailydoingdeed.global.response.common.ListResponseData;
import com.dailydoingdeed.global.response.common.SingleResponseData;
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
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
<<<<<<< HEAD
    private final CommentService commentService;

    @PostMapping
    public SingleResponseData<Long> save(@RequestBody PostsSaveRequest request){
        return SingleResponseData.of(postsService.save(request.toEntity ()));
    }

    @PatchMapping("/{id}")
    public SingleResponseData<Long> update(@PathVariable Long id, @RequestBody PostsUpdateRequest request){
        return SingleResponseData.of(postsService.update(id, request.getTitle (), request.getContent ()));
=======

    @PostMapping
    public SingleResponseData<Long> save(@RequestBody PostsSaveRequest requestDto){
        return SingleResponseData.of(postsService.save(requestDto));
    }

    @PatchMapping("/{id}")
    public SingleResponseData<Long> update(@PathVariable Long id, @RequestBody PostsUpdateRequest requestDto){
        return SingleResponseData.of(postsService.update(id, requestDto));
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
    }

    @DeleteMapping("/{id}")
    public SingleResponseData<Long> delete(@PathVariable Long id) {
        postsService.delete(id);
        return SingleResponseData.of(id);
    }

    @GetMapping("/{id}")
    public SingleResponseData<PostsResponse> findById(@PathVariable Long id){
<<<<<<< HEAD
        PostsResponse postsResponse = new PostsResponse (postsService.findById(id), commentService.findAllDesc(id));
        return SingleResponseData.of(postsResponse);
=======
        return SingleResponseData.of(postsService.findById(id));
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
    }

    @GetMapping("/all")
    public ListResponseData<PostsListResponse> all(){
        return ListResponseData.of(postsService.findAllDesc());
    }
}
