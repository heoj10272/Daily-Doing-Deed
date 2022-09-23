package com.dailydoingdeed.web;

import com.dailydoingdeed.global.response.common.ListResponseData;
import com.dailydoingdeed.global.response.common.SingleResponseData;
import com.dailydoingdeed.posts.PostsService;
import com.dailydoingdeed.web.dto.PostsListResponseDto;
import com.dailydoingdeed.web.dto.PostsResponseDto;
import com.dailydoingdeed.web.dto.PostsSaveRequestDto;
import com.dailydoingdeed.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
// @RequestMapping("/posts") -- 해당 어노테이션 추가시 아래 Mapping에서 "/posts" 생략
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts") // @PostMapping("/posts")
    public SingleResponseData<Long> save(@RequestBody PostsSaveRequestDto requestDto){
        return SingleResponseData.of(postsService.save(requestDto));
    }

    @PutMapping("/api/v1/posts/{id}") // @PatchMapping("/posts/{id}")
    public SingleResponseData<Long> update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return SingleResponseData.of(postsService.update(id, requestDto));
    }

    @DeleteMapping("/api/v1/posts/{id}") // @DeleteMapping("/posts/{id}")
    public SingleResponseData<Long> delete(@PathVariable Long id) {
        postsService.delete(id);
        return SingleResponseData.of(id);
    }

    @GetMapping("/api/v1/posts/{id}") // @GetMapping("/posts/{id}")
    public SingleResponseData<PostsResponseDto> findById(@PathVariable Long id){
        return SingleResponseData.of(postsService.findById(id));
    }

    // 모든 리스트 가져오기 api (테스트 작성)
    @GetMapping("/api/v1/posts/all") // @GetMapping("/posts/all")
    public ListResponseData<PostsListResponseDto> all(){
        return ListResponseData.of(postsService.findAllDesc());
    }
}
