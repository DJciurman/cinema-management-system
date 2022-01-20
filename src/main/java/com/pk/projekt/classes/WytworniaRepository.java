package com.pk.projekt.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WytworniaRepository extends JpaRepository<Wytwornia, Integer> {

  @Query("SELECT w FROM Wytwornia w ORDER BY w.nazwa ASC")
  List<Wytwornia> findAllWytworniaNazwaASC();

  @Query("SELECT w FROM Wytwornia w WHERE w.id = ?1")
  Wytwornia findWytworniaById(int id);
}
