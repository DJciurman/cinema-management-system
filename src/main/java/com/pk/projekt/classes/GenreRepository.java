package com.pk.projekt.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

  @Query("SELECT g FROM Genre g ORDER BY g.name ASC")
  List<Genre> findAllGenresNameASC();

  @Query("SELECT g FROM Genre g WHERE g.id = ?1")
  Genre findGenreById(int id);
}
