package com.pk.projekt.seance;

import com.pk.projekt.cinema.Cinema;
import com.pk.projekt.movie.Movie;
import com.pk.projekt.order.Order;
import com.pk.projekt.reservation.Reservation;
import com.pk.projekt.seat.Seat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "seans")
public class Seance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length = 11, name = "id")
  private int id;

  @ManyToOne
  @JoinColumn(name = "film_id", nullable = false)
  private Movie movie;

  @ManyToOne
  @JoinColumn(name = "kino_id", nullable = false)
  private Cinema cinema;

  @Column(name = "data")
  private Date date;

  @Column(length = 7, name = "godzina")
  private Time time;

  @Column(length = 11, name = "nr_sali")
  private int roomNumber;

  @Column(length = 11, name = "cena")
  private int price;

  @OneToMany(mappedBy = "seance", targetEntity = Order.class, cascade = CascadeType.ALL)
  private Set<Order> order;

  @OneToMany(mappedBy = "seance", targetEntity = Reservation.class, cascade = CascadeType.ALL)
  private Set<Reservation> reservation;

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public void setCinema(Cinema cinema) {
    this.cinema = cinema;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setTime(Time time) {
    this.time = time;
  }

  public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
  }

  public int getId() {
    return id;
  }

  public Movie getMovie() {
    return movie;
  }

  public Cinema getCinema() {
    return cinema;
  }

  public Date getDate() {
    return date;
  }

  public Time getTime() {
    return time;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public ArrayList<Integer> getSeats(){
    ArrayList<Integer> seats = new ArrayList<>();
    for(Order oneOrder : this.order){
      for(Seat seat : oneOrder.getSeat()){
        seats.add(seat.getRow());
      }
    }
    for(Reservation reservation : this.reservation){
      for(Seat seat : reservation.getSeat()){
        seats .add(seat.getRow());
      }
    }
    return seats;
  }
}
