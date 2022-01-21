package com.pk.projekt.classes;

import javax.persistence.*;

@Entity
@Table(name = "pracownik")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 255, name = "imie")
  private String firstName;

  @Column(nullable = false, length = 255, name = "nazwisko")
  private String lastName;

  @Column(nullable = false, length = 11, name = "telefon")
  private int phoneNumber;

  @Column(length = 11, name = "idManagera")
  private int managerId;

  @ManyToOne
  @JoinColumn(name = "kino_id", nullable = false)
  private Cinema cinema;

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setManagerId(int managerId) {
    this.managerId = managerId;
  }

  public void setCinema(Cinema cinema) {
    this.cinema = cinema;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getPhoneNumber() {
    return phoneNumber;
  }

  public int getManagerId() {
    return managerId;
  }

  public Cinema getCinema() {
    return cinema;
  }
}
