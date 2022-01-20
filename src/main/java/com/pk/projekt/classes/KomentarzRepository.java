package com.pk.projekt.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KomentarzRepository extends JpaRepository<Komentarz, Integer> {

  @Query("SELECT k FROM Komentarz k ORDER BY k.ocena DESC")
  List<Komentarz> findAllKomentarzDESC();

  @Query("SELECT k FROM Komentarz k WHERE k.id = ?1")
  Komentarz findKomentarzById(int id);
}
