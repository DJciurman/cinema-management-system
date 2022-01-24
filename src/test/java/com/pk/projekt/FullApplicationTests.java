package com.pk.projekt;

import com.pk.projekt.actor.Actor;
import com.pk.projekt.actor.ActorRepository;
import com.pk.projekt.cinema.Cinema;
import com.pk.projekt.cinema.CinemaRepository;
import com.pk.projekt.comment.Comment;
import com.pk.projekt.comment.CommentRepository;
import com.pk.projekt.director.Director;
import com.pk.projekt.director.DirectorRepository;
import com.pk.projekt.employee.Employee;
import com.pk.projekt.employee.EmployeeRepository;
import com.pk.projekt.genre.Genre;
import com.pk.projekt.genre.GenreRepository;
import com.pk.projekt.movie.Movie;
import com.pk.projekt.movie.MovieRepository;
import com.pk.projekt.order.Order;
import com.pk.projekt.order.OrderRepository;
import com.pk.projekt.orderSnack.OrderSnack;
import com.pk.projekt.orderSnack.OrderSnackRepository;
import com.pk.projekt.payment.Payment;
import com.pk.projekt.payment.PaymentRepository;
import com.pk.projekt.reservation.Reservation;
import com.pk.projekt.reservation.ReservationRepository;
import com.pk.projekt.seance.Seance;
import com.pk.projekt.seance.SeanceRepository;
import com.pk.projekt.seat.Seat;
import com.pk.projekt.seat.SeatRepository;
import com.pk.projekt.snack.Snack;
import com.pk.projekt.snack.SnackRepository;
import com.pk.projekt.studio.Studio;
import com.pk.projekt.studio.StudioRepository;
import com.pk.projekt.user.User;
import com.pk.projekt.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;
import java.sql.Time;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class FullApplicationTests {

  @Autowired
  private ActorRepository repoActor;

  @Autowired
  private DirectorRepository repoDirector;

  @Autowired
  private StudioRepository repoStudio;

  @Autowired
  private GenreRepository repoGenre;

  @Autowired
  private MovieRepository repoMovie;

  @Autowired
  private CommentRepository repoComment;

  @Autowired
  private SnackRepository repoSnack;

  @Autowired
  private CinemaRepository repoCinema;

  @Autowired
  private SeanceRepository repoSeance;

  @Autowired
  private EmployeeRepository repoEmployee;

  @Autowired
  private UserRepository repoUser;

  @Autowired
  private SeatRepository repoSeat;

  @Autowired
  private PaymentRepository repoPayment;

  @Autowired
  private ReservationRepository repoReservation;

  @Autowired
  private OrderRepository repoOrder;

  @Autowired
  private OrderSnackRepository repoOrderSnack;

  @Test
  public void testApplicationDatabase() {
    Actor actor = new Actor();

    actor.setFirstName("Grant");
    actor.setLastName("Gustin");
    repoActor.save(actor);

    User user = new User();
    user.setPassword("admin");
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String encodedPassword = encoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
    user.setName("admin");
    user.setFirstName("Jan");
    user.setLastName("Niezbędny");
    user.setEmail("politechnika@pk.pl");
    user.setPhoneNumber(639672549);
    repoUser.save(user);

    Director director = new Director();

    director.setFirstName("Andreas");
    director.setLastName("Muschietti");
    repoDirector.save(director);

    Studio studio = new Studio();

    studio.setName("DC Comics");
    repoStudio.save(studio);

    Genre genre = new Genre();

    genre.setName("Film");
    repoGenre.save(genre);

    genre = new Genre();

    genre.setName("Serial");
    repoGenre.save(genre);

    Movie movie = new Movie();

    movie.setName("The Flash");
    movie.setDescription("Najszybszy człowiek na ziemi");
    movie.setDirector(director);
    movie.setStudio(studio);
    movie.getActor().add(actor);
    movie.getGenre().add(genre);
    movie.setYear(2005);
    repoMovie.save(movie);

    Comment comment = new Comment();

    comment.setDescription("Ciekawa fabuła");
    comment.setMark(5);
    comment.setMovie(movie);
    comment.setUser(user);
    repoComment.save(comment);

    Snack snack = new Snack();

    snack.setName("Naczosy");
    snack.setDescription("Kukurydziane trójkąty");
    snack.setPrice(12.00F);
    snack.setAmount(100);
    repoSnack.save(snack);

    Cinema cinema = new Cinema();

    cinema.setAddress("Warszawska 274");
    cinema.setCity("Kraków");
    cinema.setRoomNumber(10);
    cinema.getSnack().add(snack);
    repoCinema.save(cinema);

    Seance seance = new Seance();

    seance.setMovie(movie);
    seance.setCinema(cinema);
    seance.setDate(Date.valueOf("2022-02-15"));
    seance.setTime(Time.valueOf("11:11:11"));
    seance.setRoomNumber(1);
    repoSeance.save(seance);

    Employee employee = new Employee();

    employee.setFirstName("Mateusz");
    employee.setLastName("Ciura");
    employee.setPhoneNumber(836598463);
    employee.setCinema(cinema);
    repoEmployee.save(employee);


    Reservation reservation = new Reservation();

    reservation.setDescription("Opis rezerwacji");
    reservation.setSeance(seance);
    reservation.setUser(user);
    repoReservation.save(reservation);

    Payment payment = new Payment();

    payment.setType("Przelew");
    payment.setState("Płatność została otrzymana");
    repoPayment.save(payment);

    Seat seat = new Seat();
    seat.setRow(1);
    seat.setColumn(1);
    repoSeat.save(seat);

    Order order = new Order();

    order.setDescription("Zamówienie z jedzeniem");
    order.setSeance(seance);
    order.setPayment(payment);
    order.setUser(user);
    order.getSeat().add(seat);
    repoOrder.save(order);

    OrderSnack orderSnack = new OrderSnack();

    orderSnack.setOrder(order);
    orderSnack.setSnack(snack);
    orderSnack.setAmount(10);

    repoOrderSnack.save(orderSnack);


  }
}
