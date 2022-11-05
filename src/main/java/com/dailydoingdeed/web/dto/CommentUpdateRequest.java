package com.dailydoingdeed.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentUpdateRequest {
    private String reply;

    @Builder
    public CommentUpdateRequest(String reply){
        this.reply = reply;
    }
}
