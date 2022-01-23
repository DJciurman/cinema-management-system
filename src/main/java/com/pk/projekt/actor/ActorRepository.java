package com.pk.projekt.actor;

import com.pk.projekt.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

  @Query("SELECT a FROM Actor a ORDER BY a.lastName ASC")
  List<Actor> findAllActorsLastNameASC();

  @Query("SELECT a FROM Actor a WHERE a.id = ?1")
  Actor findActorById(int id);

  @Query("SELECT a FROM Actor a WHERE a.firstName LIKE %?1% OR a.lastName LIKE %?1%")
  Set<Actor> findActorsByPattern(String pattern);

  @Query("SELECT a.movie FROM Actor a WHERE a.firstName LIKE %?1% OR a.lastName LIKE %?1%")
  Set<Movie> findMoviesByActorsPattern(String pattern);
}
