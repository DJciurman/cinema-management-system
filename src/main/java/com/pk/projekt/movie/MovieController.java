package com.pk.projekt.movie;

import com.pk.projekt.comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MovieController {

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private CommentRepository commentRepository;

  @GetMapping("/movie/{id}")
  private String loadPage(Model model, @PathVariable String id){
    model.addAttribute("movie", movieRepository.findMovieById(Integer.parseInt(id)));
    model.addAttribute("comments", commentRepository.findCommentsByMovieId(Integer.parseInt(id)));
    return "single-movie";
  }
}
