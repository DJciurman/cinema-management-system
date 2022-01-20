package com.pk.projekt.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RezyserRepository extends JpaRepository<Rezyser, Integer> {

  @Query("SELECT r FROM Rezyser r ORDER BY r.nazwisko ASC")
  List<Rezyser> findAllRezyserNazwiskoASC();

  @Query("SELECT r FROM Rezyser r WHERE r.id = ?1")
  Rezyser findRezyserById(int id);
}
