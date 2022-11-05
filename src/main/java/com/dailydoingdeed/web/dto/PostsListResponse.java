package com.dailydoingdeed.web.dto;

import com.dailydoingdeed.domain.posts.Posts;
<<<<<<< HEAD
import com.dailydoingdeed.domain.user.User;
=======
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponse {
    private Long id;
    private String title;
<<<<<<< HEAD
    private User author;
=======
    private String author;
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
    private LocalDateTime modifiedDate;

    public PostsListResponse(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
