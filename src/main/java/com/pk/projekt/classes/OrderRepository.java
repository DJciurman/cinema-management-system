package com.pk.projekt.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

  @Query("SELECT o FROM Order o ORDER BY o.seance.date ASC")
  List<Order> findAllOrdersSeanceNameASC();
}
