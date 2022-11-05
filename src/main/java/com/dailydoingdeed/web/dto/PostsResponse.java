package com.dailydoingdeed.web.dto;

<<<<<<< HEAD
import com.dailydoingdeed.domain.comment.Comment;
import com.dailydoingdeed.domain.posts.Posts;
import com.dailydoingdeed.domain.user.User;
import lombok.Getter;

import java.util.List;

=======
import com.dailydoingdeed.domain.posts.Posts;
import lombok.Getter;

>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
@Getter
public class PostsResponse {

    private Long id;
    private String title;
    private String content;
<<<<<<< HEAD
    private User author;
    private List<Comment> commentList;

    public PostsResponse(Posts entity, List<Comment> commentList){
=======
    private String author;

    public PostsResponse(Posts entity){
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
<<<<<<< HEAD
        this.commentList = commentList;
=======
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
    }
}
