package com.pk.projekt.classes;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "kino")
public class Cinema {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @Column(nullable = false, length = 255, name = "adres")
  private String address;

  @Column(nullable = false, length = 255, name = "miasto")
  private String city;

  @Column(nullable = false, length = 11, name = "ilosc_sal")
  private int roomNumber;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinTable(name = "przekaska_kino",
  joinColumns = {
          @JoinColumn(name = "kino_id", referencedColumnName = "id", nullable = false, updatable = false)},
          inverseJoinColumns = {
          @JoinColumn(name = "przekaska_id", referencedColumnName = "id", nullable = false, updatable = false)})
  private Set<Snack> snack = new HashSet<>();

  @OneToMany(mappedBy = "cinema", targetEntity = Seance.class, cascade = CascadeType.ALL)
  private Set<Seance> seance;

  @OneToMany(mappedBy = "cinema", targetEntity = Employee.class, cascade = CascadeType.ALL)
  private Set<Employee> employee;

  public int getId() {
    return id;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
  }

  public String getAddress() {
    return address;
  }

  public String getCity() {
    return city;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  public Set<Snack> getSnack() {
    return snack;
  }

  public Set<Seance> getSeance() {
    return seance;
  }

  public Set<Employee> getEmployee() {
    return employee;
  }

}
