package com.example.firstproject.repository;

import com.example.firstproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "select * from comment where article_id = :articleId", nativeQuery = true)
    List<Comment> findByArticleId(@Param("articleId") Long articleId);

    List<Comment> findByNickname(String nickname);
    @Query(value = "SELECT * FROM comment WHERE locate(:nickname, nickname) > 0", nativeQuery = true)
    List<Comment> findByNicknamePart(@Param("nickname") String nickname);
}
