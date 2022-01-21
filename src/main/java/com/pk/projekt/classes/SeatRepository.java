package com.pk.projekt.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

  @Query("SELECT s FROM Seat s ORDER BY s.row ASC")
  List<Seat> findAllSeatsRowASC();

  @Query("SELECT s FROM Seat s WHERE s.row = ?1 AND s.column = ?2")
  Seat findSeatByRowAndColumn(int row, int column);
}
