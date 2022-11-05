package com.dailydoingdeed.domain.posts;

import com.dailydoingdeed.domain.BaseTimeEntity;
import com.dailydoingdeed.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column
    private Long readCnt;

    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    @Builder
    public Posts(String title, String content, User author){
        this.title = title;
        this.content = content;
        this.author = author;
        this.readCnt = 0L;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
