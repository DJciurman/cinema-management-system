package com.pk.projekt.seat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

  @Query("SELECT s FROM Seat s ORDER BY s.row ASC")
  List<Seat> findAllSeatsRowASC();

  @Query("SELECT s FROM Seat s WHERE s.row = ?1 AND s.column = ?2")
  Seat findSeatByRowAndColumn(int row, int column);

  @Query("SELECT s FROM Seat s WHERE s.id = ?1")
  Seat findSeatById(int id);
}
