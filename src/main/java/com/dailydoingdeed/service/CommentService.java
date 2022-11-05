package com.dailydoingdeed.service;

import com.dailydoingdeed.domain.comment.Comment;
import com.dailydoingdeed.domain.comment.CommentRepository;
import com.dailydoingdeed.global.response.error.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public Long save(Comment comment) {
        return commentRepository.save(comment).getId();
    }

    @Transactional
    public Long update(Long id, String reply) {
        commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException ("해당 댓글이 없습니다. id=" + id))
                .update(reply);

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Comment entity = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));

        commentRepository.delete(entity);
    }

    @Transactional(readOnly = true)
    public Comment findById(Long id) {
        Comment entity = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Comment> findAllDesc(Long id) {
        return commentRepository.findAllByPosts_IdOrderByModifiedDateDesc (id);
    }
}
