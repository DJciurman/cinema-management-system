package com.pk.projekt.cinema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

  @Query("SELECT c FROM Cinema c ORDER BY c.city ASC")
  Set<Cinema> findAllCinemasCityASC();

  @Query("SELECT c FROM Cinema c WHERE c.id = ?1")
  Cinema findCinemaById(int id);
}
