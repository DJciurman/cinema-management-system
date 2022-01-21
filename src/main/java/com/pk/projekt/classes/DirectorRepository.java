package com.pk.projekt.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director, Integer> {

  @Query("SELECT d FROM Director d ORDER BY d.lastName ASC")
  List<Director> findAllDirectorsLastNameASC();

  @Query("SELECT d FROM Director d WHERE d.id = ?1")
  Director findDirectorById(int id);
}
