package com.pk.projekt.studio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudioRepository extends JpaRepository<Studio, Integer> {

  @Query("SELECT s FROM Studio s ORDER BY s.name ASC")
  List<Studio> findAllStudiosNameASC();

  @Query("SELECT s FROM Studio s WHERE s.id = ?1")
  Studio findStudioById(int id);
}
