package com.pk.projekt.movie;

import com.pk.projekt.comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class MovieController {

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private CommentRepository commentRepository;

  @GetMapping("/movie/{id}")
  private String loadPage(Model model, @PathVariable String id){
    Movie movie = movieRepository.findMovieById(Integer.parseInt(id));
    model.addAttribute("movie", movie);

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
