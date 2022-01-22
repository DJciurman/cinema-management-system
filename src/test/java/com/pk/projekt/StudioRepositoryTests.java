package com.pk.projekt;

import com.pk.projekt.studio.Studio;
import com.pk.projekt.studio.StudioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class StudioRepositoryTests {

  @Autowired
  private StudioRepository repoStudio;

  @Test
  public void testAddStudio() {
    Studio studio = new Studio();

    studio.setName("DC Comics");

    repoStudio.save(studio);
  }
}
