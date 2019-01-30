package be.vdab.muziek.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.muziek.entities.Album;
import be.vdab.muziek.valueobjects.Track;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JpaAlbumRepository.class)
@Sql("/insertArtiest.sql")
@Sql("/insertAlbum.sql")
@Sql("/insertTracks.sql")
public class JpaAlbumRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	private static final String ALBUMS = "albums";
	@Autowired
	private JpaAlbumRepository repository;
	@Autowired
	private EntityManager manager;
	private final long idVanTestAlbum() {
		return super.jdbcTemplate.queryForObject("select id from albums where naam='test';", Long.class);
	}
	@Test
	public void findAll() {
		List<Album> albums = repository.findAll();
		manager.clear();
		assertEquals(super.countRowsInTable(ALBUMS), albums.size());
		String vorigeNaam = "";
		for (Album album : albums) {
			assertTrue(vorigeNaam.compareToIgnoreCase(album.getNaam()) <= 0);
			vorigeNaam = album.getNaam();
			System.out.println(album.getNaam() + " : " + album.getArtiest().getNaam());
		}
	}
	@Test
	public void read() {
		Album album = repository.read(idVanTestAlbum()).get();
		assertEquals("test", album.getNaam());
		assertEquals("test", album.getArtiest().getNaam());
		assertEquals(0, BigDecimal.valueOf(11).compareTo(album.getTijd()));
	}
	@Test
	public void tracksLezen() {
		Album album = repository.read(idVanTestAlbum()).get();
		assertEquals(2, album.getTracks().size());
		assertTrue(album.getTracks().contains(new Track("test", BigDecimal.ONE)));
	}

}
