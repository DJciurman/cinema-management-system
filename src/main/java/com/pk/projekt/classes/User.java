package com.pk.projekt.classes;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "uzytkownik")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, unique = true, length = 255, name = "nazwa")
  private String name;

  @Column(nullable = false, length = 255, name = "haslo")
  private String password;

  @Column(nullable = false, length = 255, name = "imie")
  private String firstName;

  @Column(nullable = false, length = 255, name = "nazwisko")
  private String lastName;

  @Column(nullable = false, length = 255, name = "email")
  private String email;

  @Column(nullable = false, length = 11, name = "telefon")
  private int phoneNumber;

  @OneToMany(mappedBy = "user", targetEntity = Order.class, cascade = CascadeType.ALL)
  private Set<Order> order;

  @OneToMany(mappedBy = "user", targetEntity = Reservation.class, cascade = CascadeType.ALL)
  private Set<Reservation> reservation;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Set<Order> getOrder() {
    return order;
  }

  public Set<Reservation> getReservation() {
    return reservation;
  }

}
