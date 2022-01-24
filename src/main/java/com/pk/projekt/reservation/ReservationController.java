package com.pk.projekt.reservation;

import com.pk.projekt.movie.Movie;
import com.pk.projekt.movie.MovieRepository;
import com.pk.projekt.order.Order;
import com.pk.projekt.seance.SeanceRepository;
import com.pk.projekt.seat.Seat;
import com.pk.projekt.security.CustomUserDetails;
import com.pk.projekt.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ReservationController {

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private SeanceRepository seanceRepository;

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/reservation/{movieId}")
  private String loadPage(@PathVariable String movieId, Model model){
    Movie movie = movieRepository.findMovieById(Integer.parseInt(movieId));
    model.addAttribute("movie", movie);
    return "reservation";
  }

  @PostMapping("/reservation/{movieId}")
  private ResponseEntity newReservation(@PathVariable String movieId, Model model, @RequestBody ReservationRequest reservationRequest, @AuthenticationPrincipal CustomUserDetails userDetails){

    String[] seats = reservationRequest.seats.split(",");
    Set<Seat> reservedSeats = new HashSet<>();
    for(String seat : seats){
      reservedSeats.add(new Seat(Integer.parseInt(seat)));
    }

    if(reservationRequest.transactionType == "Rezerwacja"){
      Reservation reservation = new Reservation();
      reservation.setSeance(seanceRepository.findSeanceById(Integer.parseInt(reservationRequest.seance)));
      reservation.setUser(userRepository.findUserByName(userDetails.getUsername()));
    }
    else{
      Order order = new Order();
      order.setSeance(seanceRepository.findSeanceById(Integer.parseInt(reservationRequest.seance)));
      order.setSeat(reservedSeats);
      order.setUser(userRepository.findUserByName(userDetails.getUsername()));
    }


    return ResponseEntity.status(HttpStatus.CREATED).body("Reservation created");
  }
}
