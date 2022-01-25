package com.pk.projekt.seance;

import com.pk.projekt.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface SeanceRepository extends JpaRepository<Seance, Integer> {

  @Query("SELECT s FROM Seance s ORDER BY s.time DESC")
  List<Seance> findAllSeancesTimeDESC();

  @Query("SELECT s FROM Seance s WHERE s.id = ?1")
  Seance findSeanceById(int id);

  @Query("SELECT s FROM Seance s WHERE s.movie = ?1 ORDER BY s.date ASC")
  Set<Seance> findAsc(Movie movie);
}
