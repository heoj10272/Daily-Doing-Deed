package com.dailydoingdeed.web.dto;

import com.dailydoingdeed.domain.posts.Posts;
import com.dailydoingdeed.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostsSaveRequest {
    private String title;
    private String content;
    private User author;

    @Builder
    public PostsSaveRequest(String title, String content, User author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
