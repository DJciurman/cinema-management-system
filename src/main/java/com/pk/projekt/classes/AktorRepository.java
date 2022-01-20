package com.pk.projekt.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AktorRepository extends JpaRepository<Aktor, Integer> {

  @Query("SELECT a FROM Aktor a ORDER BY a.nazwisko ASC")
  List<Aktor> findAllAktorNazwiskoASC();

  @Query("SELECT a FROM Aktor a WHERE a.id = ?1")
  Aktor findAktorById(int id);
}
