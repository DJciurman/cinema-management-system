package com.pk.projekt.movie;

import com.pk.projekt.comment.CommentRepository;
import com.pk.projekt.genre.GenreRepository;
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

import java.util.List;
import java.util.Random;
import java.util.Set;

@Controller
public class MovieController {

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private GenreRepository genreRepository;

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
  private String loadMainPage(Model model) {
    Set<Movie> movies = genreRepository.findAllMovies();
    Set<Movie> series = genreRepository.findAllSeries();
    List<Movie> results = movieRepository.findBestMovie(movies);
    Movie movie = results.get(0);
    model.addAttribute("movie", movie);
    movie = results.get(1);
    model.addAttribute("movie2", movie);
    results = movieRepository.findBestMovie(series);
    movie = results.get(0);
    model.addAttribute("tvSeries", movie);
    movie = results.get(1);
    model.addAttribute("tvSeries2", movie);
    return "main-page";
  }
}
