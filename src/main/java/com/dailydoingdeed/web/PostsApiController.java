package com.dailydoingdeed.web;

import com.dailydoingdeed.global.response.common.ListResponseData;
import com.dailydoingdeed.global.response.common.SingleResponseData;
import com.dailydoingdeed.service.PostsService;
import com.dailydoingdeed.web.dto.PostsListResponseDto;
import com.dailydoingdeed.web.dto.PostsResponseDto;
import com.dailydoingdeed.web.dto.PostsSaveRequestDto;
import com.dailydoingdeed.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping
    public SingleResponseData<Long> save(@RequestBody PostsSaveRequestDto requestDto){
        return SingleResponseData.of(postsService.save(requestDto));
    }

    @PatchMapping("/{id}")
    public SingleResponseData<Long> update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return SingleResponseData.of(postsService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public SingleResponseData<Long> delete(@PathVariable Long id) {
        postsService.delete(id);
        return SingleResponseData.of(id);
    }

    @GetMapping("/{id}")
    public SingleResponseData<PostsResponseDto> findById(@PathVariable Long id){
        return SingleResponseData.of(postsService.findById(id));
    }

    @GetMapping("/all")
    public ListResponseData<PostsListResponseDto> all(){
        return ListResponseData.of(postsService.findAllDesc());
    }
}
