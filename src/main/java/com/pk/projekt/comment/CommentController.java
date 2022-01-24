package com.pk.projekt.comment;

import com.pk.projekt.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CommentController {

  @Autowired
  private CommentRepository commentRepository;

  @PostMapping("/comment")
  private ResponseEntity postComment(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody CommentRequest commentRequest){
    Comment comment = new Comment();
    comment.setMark(Integer.parseInt(commentRequest.mark));
    comment.setDescription(commentRequest.comment);
    try {
      commentRepository.save(comment);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to post comment");
    }
    return ResponseEntity.status(HttpStatus.CREATED).body("Comment posted");
  }

}
