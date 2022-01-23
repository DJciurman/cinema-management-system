package com.pk.projekt.orderSnack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderSnackRepository extends JpaRepository<OrderSnack, Integer> {

  @Query("SELECT os FROM OrderSnack os")
  List<OrderSnack> findAllOrderSnack();
}
