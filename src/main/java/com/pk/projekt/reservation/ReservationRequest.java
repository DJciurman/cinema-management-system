package com.pk.projekt.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservationRequest {
  String transactionType;
  String seance;
  String seats;
  String price;
  String creditCard;
  //trzeba podać nazwy wszystkich przekąsek
  String Naczosy;
}
