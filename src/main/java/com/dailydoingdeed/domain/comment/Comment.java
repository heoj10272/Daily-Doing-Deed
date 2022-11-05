package com.dailydoingdeed.domain.comment;

import com.dailydoingdeed.domain.BaseTimeEntity;
import com.dailydoingdeed.domain.posts.Posts;
import com.dailydoingdeed.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String reply;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Posts posts;

    @Builder
    public Comment(String reply, User user, Posts posts){
        this.reply = reply;
        this.user = user;
        this.posts = posts;
    }

    public void update(String reply){
        this.reply = reply;
    }
}
