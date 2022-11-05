package com.dailydoingdeed.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPosts_IdOrderByModifiedDateDesc(Long id);
}
