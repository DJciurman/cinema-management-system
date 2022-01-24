package com.pk.projekt.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

  @Query("SELECT c FROM Comment c ORDER BY c.mark DESC")
  List<Comment> findAllCommentsMarkDESC();

  @Query("SELECT c FROM Comment c WHERE c.id = ?1")
  Comment findCommentById(int id);

  //TODO: Stworzyć query do szukania komentarzy po id filmu
  @Query("")
  Comment findCommentsByMovieId(Integer id);
}
