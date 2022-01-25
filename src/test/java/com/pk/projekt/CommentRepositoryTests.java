package com.pk.projekt;

import com.pk.projekt.movie.Movie;
import com.pk.projekt.movie.MovieRepository;
import com.pk.projekt.comment.Comment;
import com.pk.projekt.comment.CommentRepository;
import com.pk.projekt.user.UserRepository;
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

  @Autowired
  private UserRepository repoUser;

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
    comment.setUser(repoUser.findUserById(1));

    repoComment.save(comment);

  }

}
