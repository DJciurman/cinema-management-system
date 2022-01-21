package com.pk.projekt.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SnackRepository extends JpaRepository<Snack, Integer> {

  @Query("SELECT s FROM Snack s ORDER BY s.name ASC")
  List<Snack> findAllSnacksNameASC();

  @Query("SELECT s FROM Snack s WHERE s.id = ?1")
  Snack findSnackById(int id);
}
