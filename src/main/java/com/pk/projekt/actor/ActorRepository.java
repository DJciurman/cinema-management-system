package com.pk.projekt.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

  @Query("SELECT a FROM Actor a ORDER BY a.lastName ASC")
  List<Actor> findAllActorsLastNameASC();

  @Query("SELECT a FROM Actor a WHERE a.id = ?1")
  Actor findActorById(int id);
}
