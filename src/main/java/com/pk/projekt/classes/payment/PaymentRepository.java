package com.pk.projekt.classes.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

  @Query("SELECT p FROM Payment p ORDER BY p.id ASC")
  List<Payment> findAllPaymentsIdASC();

  @Query("SELECT p FROM Payment p WHERE p.id = ?1")
  Payment findPaymentById(int id);
}
