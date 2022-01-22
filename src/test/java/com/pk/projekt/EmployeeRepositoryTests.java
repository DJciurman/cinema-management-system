package com.pk.projekt;

import com.pk.projekt.classes.cinema.Cinema;
import com.pk.projekt.classes.cinema.CinemaRepository;
import com.pk.projekt.classes.employee.Employee;
import com.pk.projekt.classes.employee.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class EmployeeRepositoryTests {

  @Autowired
  private EmployeeRepository repoEmployee;

  @Autowired
  private CinemaRepository repoCinema;

  @Test
  public void testAddEmployee() {
    Employee employee = new Employee();

    employee.setFirstName("Mateusz");
    employee.setLastName("Ciura");
    employee.setPhoneNumber(836598463);

    Cinema cinema = repoCinema.findCinemaById(1);

    employee.setCinema(cinema);

    repoEmployee.save(employee);

  }
}
