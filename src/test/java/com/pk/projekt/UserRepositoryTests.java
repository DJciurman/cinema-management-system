package com.pk.projekt;

import com.pk.projekt.user.User;
import com.pk.projekt.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

  @Autowired
  private UserRepository repoUser;

  @Test
  public void testAddUser() {
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



  }
}
