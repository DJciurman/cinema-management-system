package com.pk.projekt.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {

  @Query("SELECT f FROM Film f ORDER BY f.nazwa ASC")
  List<Film> findAllFilmNazwaASC();

  @Query("SELECT f FROM Film f WHERE f.id = ?1")
  Film findFilmById(int id);
}
