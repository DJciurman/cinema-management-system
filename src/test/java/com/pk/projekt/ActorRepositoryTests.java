package com.pk.projekt;


import com.pk.projekt.classes.actor.Actor;
import com.pk.projekt.classes.actor.ActorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ActorRepositoryTests {

  @Autowired
  private ActorRepository repoActor;

  @Test
  public void testAddActor() {
    Actor actor = new Actor();

    actor.setFirstName("Grant");
    actor.setLastName("Gustin");

    repoActor.save(actor);
  }
}
