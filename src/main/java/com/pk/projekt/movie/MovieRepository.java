package com.pk.projekt.movie;

import com.pk.projekt.actor.Actor;
import com.pk.projekt.genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

  @Query("SELECT m FROM Movie m ORDER BY m.name ASC")
  List<Movie> findAllMoviesNameASC();

  @Query("SELECT m FROM Movie m WHERE m.id = ?1")
  Movie findMovieById(int id);

  @Query("SELECT m FROM Movie m WHERE m.name LIKE %?1% OR m.studio.name LIKE %?1% OR m.director.firstName LIKE %?1% OR m.director.lastName LIKE %?1%")
  Set<Movie> findMoviesByPattern(String pattern);

  @Query("SELECT m FROM Movie m WHERE m IN ?1 ORDER BY m.name ASC")
  Set<Movie> findMoviesASC(Set<Movie> movies);

  @Query("SELECT count(m) FROM Movie m")
  Integer countMovie();

  @Query("SELECT m FROM Movie m WHERE m IN ?1 ORDER BY m.mark DESC")
  List<Movie> findBestMovie(Set<Movie> movies);
}
