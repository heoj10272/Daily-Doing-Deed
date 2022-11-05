package com.dailydoingdeed.domain.posts;

import com.dailydoingdeed.domain.BaseTimeEntity;
<<<<<<< HEAD
import com.dailydoingdeed.domain.user.User;
=======
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
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
<<<<<<< HEAD

=======
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
    @Column(length = 500, nullable = false)
    private String title;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
<<<<<<< HEAD

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
=======
    
    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
>>>>>>> 08cbddddd6c2e2d6fdbbdcdc509a5d29ccbbf320
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
