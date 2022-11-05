package com.dailydoingdeed.web.dto;

import com.dailydoingdeed.domain.comment.Comment;
import com.dailydoingdeed.domain.posts.Posts;
import com.dailydoingdeed.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentSaveRequest {
    private String reply;
    private User user;
    private Posts posts;

    @Builder
    public CommentSaveRequest(String reply, User user, Posts posts){
        this.reply = reply;
        this.user = user;
        this.posts = posts;
    }

    public Comment toEntity(){
        return Comment.builder()
                .reply(reply)
                .user(user)
                .posts(posts)
                .build();
    }
}
