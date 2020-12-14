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
	public void testExtraireFilmsTriesParNom() {
		List<Film> films = filmRepository.findFilmsTriesParNom();
		assertEquals(414, films.size());
		assertEquals("100 Streets", films.get(0).getNom());
	}
	
	@Test
	public void testExtraireFilmsTriesParAnnee() {
		List<Film> films = filmRepository.findFilmsTriesParAnnee();
		assertEquals(414, films.size());
		assertEquals("La légende de Bagger Vance", films.get(0).getNom());
		assertEquals(new Integer(2000), films.get(0).getAnnee());
	}
	
	@Test
	public void testExtraireFilmsParGenre() {
		List<Film> films = filmRepository.findFilmsParGenre("Horror");
		assertEquals(17, films.size());
	}
	
	@Test
	public void testExtraireFilmsParRealisateurEtAnnees() {
		List<Film> films = filmRepository.findFilmsParRealisateurEtAnneesTriesParAnnee("Ridley Scott", 2000, 2020);
		assertEquals(5, films.size());
		assertEquals("American Gangster", films.get(0).getNom());
		assertEquals("Cartel", films.get(1).getNom());
		assertEquals("Exodus: Gods and Kings", films.get(2).getNom());
		assertEquals("Alien: Covenant", films.get(3).getNom());
		assertEquals("Alien: Covenant - Prologue: The Crossing", films.get(4).getNom());
	}
	
	@Test
	public void testExtraireFilmsParNbGenres() {
		List<Film> films = filmRepository.findFilmsParNbGenres(8);
		assertEquals(2, films.size());
		assertEquals("Jonah Hex: Behind the Scenes ~ B-Roll 2", films.get(0).getNom());
	}
	
	@Test
	public void testExtraireFilmsCommunsPourActeurs() {
		List<Film> films = filmRepository.findFilmsAvecPlusieursActeurs("Leonardo DiCaprio", "Marion Cotillard");
		assertEquals(1, films.size());
		assertEquals("Inception", films.get(0).getNom());
	}
}
