package com.pk.projekt.reservation;

import com.pk.projekt.movie.Movie;
import com.pk.projekt.movie.MovieRepository;
import com.pk.projekt.order.Order;
import com.pk.projekt.order.OrderRepository;
import com.pk.projekt.orderSnack.OrderSnack;
import com.pk.projekt.payment.Payment;
import com.pk.projekt.seance.SeanceRepository;
import com.pk.projekt.seat.Seat;
import com.pk.projekt.security.CustomUserDetails;
import com.pk.projekt.snack.Snack;
import com.pk.projekt.snack.SnackRepository;
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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Controller
public class ReservationController {

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private SeanceRepository seanceRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private SnackRepository snackRepository;

  @Autowired
  private ReservationRepository reservationRepository;

  @Autowired
  private OrderRepository orderRepository;


  @GetMapping("/reservation/{movieId}")
  private String loadPage(@PathVariable String movieId, Model model){
    Movie movie = movieRepository.findMovieById(Integer.parseInt(movieId));
    model.addAttribute("movie", movie);

    return "reservation";
  }

  @PostMapping("/reservation/{movieId}")
  private ResponseEntity newReservation(@PathVariable String movieId, Model model, ReservationRequest reservationRequest, @AuthenticationPrincipal CustomUserDetails userDetails){

    String[] seats = reservationRequest.seats.split(",");
    Set<Seat> reservedSeats = new HashSet<>();
    for(String seat : seats){
      reservedSeats.add(new Seat(Integer.parseInt(seat)));
    }



    if(Objects.equals(reservationRequest.transactionType, "Rezerwacja")){
      Reservation reservation = new Reservation();
      reservation.setSeance(seanceRepository.findSeanceById(Integer.parseInt(reservationRequest.seance)));
      reservation.setUser(userRepository.findUserByName(userDetails.getUsername()));
      reservation.getSeat().addAll(reservedSeats);
      reservation.setDescription("");
      try {
        reservationRepository.save(reservation);
      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create reservation" + reservationRequest.toString());
      }
    }
    else{
      Order order = new Order();
      order.setSeance(seanceRepository.findSeanceById(Integer.parseInt(reservationRequest.seance)));
      order.setSeat(reservedSeats);
      order.setUser(userRepository.findUserByName(userDetails.getUsername()));
      order.setTotal(Integer.parseInt(reservationRequest.price));
      order.setDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

      Set<OrderSnack> orderSnackSet = new HashSet<>();
      OrderSnack orderSnack = new OrderSnack();
      orderSnack.setOrder(order);
      orderSnack.setSnack(snackRepository.findSnackByName("Naczosy"));
      orderSnack.setAmount(Integer.parseInt(reservationRequest.Naczosy));
      orderSnackSet.add(orderSnack);
      order.setOrderSnack(orderSnackSet);
      Payment payment = new Payment();
      payment.setState("Nowa");
      payment.setType("Karta kredytowa");
      payment.setOrder(order);
      order.setPayment(payment);
      try{
        orderRepository.save(order);
      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create order");
      }
    }

    return ResponseEntity.status(HttpStatus.CREATED).body("Reservation created");
  }
}
