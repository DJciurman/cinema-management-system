package com.pk.projekt.user;

import com.pk.projekt.actor.ActorRepository;
import com.pk.projekt.cinema.Cinema;
import com.pk.projekt.cinema.CinemaRepository;
import com.pk.projekt.director.DirectorRepository;
import com.pk.projekt.genre.GenreRepository;
import com.pk.projekt.movie.Movie;
import com.pk.projekt.movie.MovieRepository;
import com.pk.projekt.studio.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@Controller
public class LoginController {

  @Autowired
  private UserRepository repoUser;

  @Autowired
  private MovieRepository repoMovie;

  @Autowired
  private ActorRepository repoActor;

  @Autowired
  private DirectorRepository repoDirector;

  @Autowired
  private GenreRepository repoGenre;

  @Autowired
  private StudioRepository repoStudio;

  @Autowired
  private CinemaRepository repoCinema;


  @GetMapping("/login")
  private String loadPage(Model model) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      String name = SecurityContextHolder.getContext().getAuthentication().getName();
      User user = repoUser.findUserByName(name);
      model.addAttribute("user", user);
      return "logout";
    }
    model.addAttribute("user", new User());
    return "login";
  }

  @PostMapping("/manageData")
  private String manageDataProcess(Model model, User user, HttpServletRequest request, HttpServletResponse response,@RequestParam("operation") String operation, @RequestParam("password") String password) {
    if (operation.equals("edit")) {
      String name = SecurityContextHolder.getContext().getAuthentication().getName();
      User logged = repoUser.findUserByName(name);
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      if (encoder.matches(password, logged.getPassword()))
      {
        logged.setEmail(user.getEmail());
        logged.setFirstName(user.getFirstName());
        logged.setLastName(user.getLastName());
        logged.setPhoneNumber(user.getPhoneNumber());

        try {
          repoUser.save(logged);
        } catch (Exception e) {

        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        new SecurityContextLogoutHandler().logout(request, response, auth);
        model.addAttribute("user", new User());
        model.addAttribute("error", "huehue");
        return "login";
      }
    }
    String name = SecurityContextHolder.getContext().getAuthentication().getName();
    user = repoUser.findUserByName(name);
    model.addAttribute("user", user);
    return "logout";
  }

  @PostMapping("/register")
  private String processRegister(User user, Model model, @RequestParam("phone") int phone) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String encodedPassword = encoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
    String error = "huehue";
    user.setPhoneNumber(phone);
    try {
      repoUser.save(user);
    } catch (Exception e) {
      error = "errorRegister";
    }
    model.addAttribute("error", error);
    model.addAttribute("user", new User());
    return "login";
  }

  @GetMapping("/search")
  private String viewAllFilms(@RequestParam("search") String search, Model model) {

    Set<Movie> movies = repoGenre.findMoviesByGenresPattern(search);
    movies.addAll(repoActor.findMoviesByActorsPattern(search));
    movies.addAll(repoMovie.findMoviesByPattern(search));

    movies = repoMovie.findMoviesASC(movies);

    model.addAttribute("movies", movies);

    return "movies-list";
  }

  @GetMapping("/cinemas")
  private String viewCinemas(Model model) {
    Set<Cinema> cinemas = repoCinema.findAllCinemasCityASC();
    model.addAttribute("cinemas", cinemas);
    return "cinemas-list";
  }

}
