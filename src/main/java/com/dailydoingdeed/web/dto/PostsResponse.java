package com.dailydoingdeed.web.dto;

import com.dailydoingdeed.domain.comment.Comment;
import com.dailydoingdeed.domain.posts.Posts;
import com.dailydoingdeed.domain.user.User;
import lombok.Getter;

import java.util.List;

@Getter
public class PostsResponse {

    private Long id;
    private String title;
    private String content;
    private User author;
    private List<Comment> commentList;

    public PostsResponse(Posts entity, List<Comment> commentList){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.commentList = commentList;
    }
}
