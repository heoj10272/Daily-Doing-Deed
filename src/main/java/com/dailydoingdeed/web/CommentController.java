package com.dailydoingdeed.web;

import com.dailydoingdeed.global.response.common.SingleResponseData;
import com.dailydoingdeed.service.CommentService;
import com.dailydoingdeed.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public SingleResponseData<Long> save(@RequestBody CommentSaveRequest request){
        return SingleResponseData.of(commentService.save(request.toEntity ()));
    }

    @PatchMapping("/{id}")
    public SingleResponseData<Long> update(@PathVariable Long id, @RequestBody CommentUpdateRequest request){
        return SingleResponseData.of(commentService.update(id, request.getReply ()));
    }

    @DeleteMapping("/{id}")
    public SingleResponseData<Long> delete(@PathVariable Long id) {
        commentService.delete(id);
        return SingleResponseData.of(id);
    }
}
