package com.pk.projekt.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RodzajRepository extends JpaRepository<Rodzaj, Integer> {

  @Query("SELECT r FROM Rodzaj r ORDER BY r.nazwa ASC")
  List<Rodzaj> findAllRodzajNazwaASC();

  @Query("SELECT r FROM Rodzaj r WHERE r.id = ?1")
  Rodzaj findRodzajById(int id);
}
