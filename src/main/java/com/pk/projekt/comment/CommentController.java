package com.pk.projekt.comment;

import com.pk.projekt.movie.MovieRepository;
import com.pk.projekt.security.CustomUserDetails;
import com.pk.projekt.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/comment")
  private ResponseEntity postComment(CommentRequest commentRequest, @AuthenticationPrincipal CustomUserDetails userDetails){
    Comment comment = new Comment();
    comment.setMark(commentRequest.mark);
    comment.setDescription(commentRequest.comment);
    comment.setMovie(movieRepository.findMovieById(commentRequest.movieId));
    comment.setUser(userRepository.findUserByName(userDetails.getUsername()));
    try {
      commentRepository.save(comment);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to post comment");
    }
    return ResponseEntity.status(HttpStatus.CREATED).body("Comment posted");
  }

}
