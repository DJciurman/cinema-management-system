package com.pk.projekt;

import com.pk.projekt.classes.Movie;
import com.pk.projekt.classes.MovieRepository;
import com.pk.projekt.classes.Comment;
import com.pk.projekt.classes.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CommentRepositoryTests {

  @Autowired
  private CommentRepository repoComment;

  @Autowired
  private MovieRepository repoMovie;

  @Test
  public void testAddComment() {

    Comment comment = new Comment();

    comment.setDescription("Ciekawa fabuła");
    comment.setMark(5);

    Movie movie = repoMovie.findMovieById(1);

    comment.setMovie(movie);

    repoComment.save(comment);

  }

  @Test
  public void testModifyComment() {

    Comment comment = repoComment.findCommentById(1);
    comment.setMark(5);

    repoComment.save(comment);

  }
}
