package org.bwbc;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.bwbc.beans.Film;
import org.bwbc.repositories.FilmRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class FilmRepositoryTest {
	
	@Autowired
	private FilmRepository filmRepository;
	
	
	@Test
	public void testExtraireFilmsParGenre() {
		List<Film> films = filmRepository.findFilmsParGenre("Horror");
		assertEquals(17, films.size());
	}
	
	@Test
	public void testExtraireFilmsCommunsPourActeurs() {
		List<Film> films = filmRepository.findFilmsAvecPlusieursActeurs("Leonardo DiCaprio", "Marion Cotillard");
		assertEquals(1, films.size());
		assertEquals("Inception", films.get(0).getNom());
	}
}
