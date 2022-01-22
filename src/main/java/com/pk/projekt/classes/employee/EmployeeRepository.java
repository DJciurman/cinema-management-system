package com.pk.projekt.classes.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

  @Query("SELECT e FROM Employee e ORDER BY e.lastName ASC")
  List<Employee> findAllEmployeesLastNameASC();
}
