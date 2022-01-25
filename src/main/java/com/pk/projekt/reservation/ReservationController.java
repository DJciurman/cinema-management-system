package com.pk.projekt.reservation;

import com.pk.projekt.movie.Movie;
import com.pk.projekt.movie.MovieRepository;
import com.pk.projekt.order.Order;
import com.pk.projekt.order.OrderRepository;
import com.pk.projekt.orderSnack.OrderSnack;
import com.pk.projekt.orderSnack.OrderSnackRepository;
import com.pk.projekt.payment.Payment;
import com.pk.projekt.payment.PaymentRepository;
import com.pk.projekt.seance.SeanceRepository;
import com.pk.projekt.seat.Seat;
import com.pk.projekt.seat.SeatRepository;
import com.pk.projekt.security.CustomUserDetails;
import com.pk.projekt.snack.SnackRepository;
import com.pk.projekt.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ReservationController {

  @Autowired private MovieRepository movieRepository;

  @Autowired private SeanceRepository seanceRepository;

  @Autowired private UserRepository userRepository;

  @Autowired private SnackRepository snackRepository;

  @Autowired private ReservationRepository reservationRepository;

  @Autowired private OrderRepository orderRepository;

  @Autowired private PaymentRepository paymentRepository;

  @Autowired private OrderSnackRepository orderSnackRepository;

  @Autowired private SeatRepository seatRepository;

  @GetMapping("/reservation/{movieId}")
  private String loadPage(@PathVariable String movieId, Model model) {
    Movie movie = movieRepository.findMovieById(Integer.parseInt(movieId));
    model.addAttribute("movie", movie);

    return "reservation";
  }

  @PostMapping("/reservation/{movieId}")
  private ResponseEntity newReservation(
      @PathVariable String movieId,
      Model model,
      ReservationRequest reservationRequest,
      @AuthenticationPrincipal CustomUserDetails userDetails) {

    String[] seats = reservationRequest.seats.split(",");
    Set<Seat> reservedSeats = new HashSet<>();
    for (String seat : seats) {
      reservedSeats.add(seatRepository.findSeatById(Integer.parseInt(seat)));
    }



    if (Objects.equals(reservationRequest.transactionType, "Rezerwacja")) {
      Reservation reservation = new Reservation();
      reservation.setSeance(
          seanceRepository.findSeanceById(Integer.parseInt(reservationRequest.seance)));
      reservation.setUser(userRepository.findUserByName(userDetails.getUsername()));
      reservation.getSeat().addAll(reservedSeats);
      reservation.setDescription("");
      try {
        reservationRepository.save(reservation);
      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Failed to create reservation" + reservationRequest.toString());
      }
    } else {
      Payment payment = new Payment();
      payment.setState("Nowa");
      payment.setType("Karta kredytowa + kwota: " + reservationRequest.price);
      try {
        paymentRepository.save(payment);
      } catch (Exception e) {

      }

      Order order = new Order();
      order.setDescription("Zamowienie");
      order.setSeance(seanceRepository.findSeanceById(Integer.parseInt(reservationRequest.seance)));
      order.setSeat(reservedSeats);
      order.setUser(userRepository.findUserByName(userDetails.getUsername()));
      order.setTotal(Integer.parseInt(reservationRequest.price));
      Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
      order.setDate(date);
      order.setPayment(payment);

      try {
        orderRepository.save(order);
      } catch (Exception e) {

      }

      //      Set<OrderSnack> orderSnackSet = new HashSet<>();
      OrderSnack orderSnack = new OrderSnack();
      orderSnack.setOrder(order);
      orderSnack.setSnack(snackRepository.findSnackByName("Naczosy"));
      orderSnack.setAmount(Integer.parseInt(reservationRequest.Naczosy));
      try {
        orderSnackRepository.save(orderSnack);
      } catch (Exception e) {

      }
      //      orderSnackSet.add(orderSnack);
      //      order.setOrderSnack(orderSnackSet);
      //      try{
      ////        orderRepository.save(order);
      //      } catch (Exception e) {
      //        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create order");
      //      }
      //    }


    }
    return ResponseEntity.status(HttpStatus.CREATED).body("Reservation created");
  }
}