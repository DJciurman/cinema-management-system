package com.pk.projekt.classes.cinema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

  @Query("SELECT c FROM Cinema c ORDER BY c.city ASC")
  List<Cinema> findAllCinemasCityASC();

  @Query("SELECT c FROM Cinema c WHERE c.id = ?1")
  Cinema findCinemaById(int id);
}
