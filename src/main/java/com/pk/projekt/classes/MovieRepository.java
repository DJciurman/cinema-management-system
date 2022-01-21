package com.pk.projekt.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

  @Query("SELECT m FROM Movie m ORDER BY m.name ASC")
  List<Movie> findAllMoviesNameASC();

  @Query("SELECT m FROM Movie m WHERE m.id = ?1")
  Movie findMovieById(int id);
}
