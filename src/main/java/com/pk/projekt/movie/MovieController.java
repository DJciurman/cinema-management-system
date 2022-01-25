package com.pk.projekt.movie;

import com.pk.projekt.comment.CommentRepository;
import com.pk.projekt.comment.DeleteCommentRequest;
import com.pk.projekt.security.CustomUserDetails;
import com.pk.projekt.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class MovieController {

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/movie/{id}")
  private String loadPage(Model model, @PathVariable String id, @AuthenticationPrincipal CustomUserDetails userDetails){
    Movie movie = movieRepository.findMovieById(Integer.parseInt(id));
    model.addAttribute("movie", movie);
    try{
      model.addAttribute("user", userRepository.findUserByName(userDetails.getUsername()));
    } catch(Exception e){

    }

    try{
      model.addAttribute("comments", commentRepository.findCommentsByMovieId(Integer.parseInt(id)));
    }catch(NullPointerException e){

    }
    return "single-movie";
  }

  @GetMapping("/")
  private String loadMainPage(Model model){
    Random rand = new Random();
    model.addAttribute("movie", movieRepository.findMovieById(7));
    model.addAttribute("tvSeries", movieRepository.findMovieById(1));
    return "main-page";
  }

}
