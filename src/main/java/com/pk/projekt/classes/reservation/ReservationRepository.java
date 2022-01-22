package com.pk.projekt.classes.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

  @Query("SELECT r FROM Reservation r ORDER BY r.seance.date ASC")
  List<Reservation> findAllReservationsSeanceDateASC();
}
