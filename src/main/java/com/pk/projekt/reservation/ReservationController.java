package com.pk.projekt.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {

  @GetMapping//("/reservation/{movieId}")
  private String loadPage(Model model){
    return "reservation";
  }
}
