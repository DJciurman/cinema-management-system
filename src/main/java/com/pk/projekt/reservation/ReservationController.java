package com.pk.projekt.reservation;

import com.pk.projekt.movie.Movie;
import com.pk.projekt.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ReservationController {

  @Autowired
  private MovieRepository movieRepository;

  @GetMapping("/reservation/{movieId}")
  private String loadPage(@PathVariable String movieId, Model model){
    Movie movie = movieRepository.findMovieById(Integer.parseInt(movieId));
    model.addAttribute("movie", movie);
    return "reservation";
  }

  @PostMapping("/reservation/{movieId}")
  private ResponseEntity newReservation(@PathVariable String movieId, Model model, ReservationRequest reservationRequest ){
    return ResponseEntity.status(HttpStatus.CREATED).body("Reservation created");
  }
}
