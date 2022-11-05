package com.dailydoingdeed.web.dto;

import com.dailydoingdeed.domain.posts.Posts;
<<<<<<< HEAD
import com.dailydoingdeed.domain.user.User;
=======
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostsSaveRequest {
    private String title;
    private String content;
<<<<<<< HEAD
    private User author;

    @Builder
    public PostsSaveRequest(String title, String content, User author){
=======
    private String author;

    @Builder
    public PostsSaveRequest(String title, String content, String author){
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
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
