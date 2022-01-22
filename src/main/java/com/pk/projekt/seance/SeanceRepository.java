package com.pk.projekt.seance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance, Integer> {

  @Query("SELECT s FROM Seance s ORDER BY s.time DESC")
  List<Seance> findAllSeancesTimeDESC();

  @Query("SELECT s FROM Seance s WHERE s.id = ?1")
  Seance findSeanceById(int id);
}
