package be.vdab.muziek.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.muziek.entities.Album;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JpaAlbumRepository.class)
public class JpaAlbumRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	JpaAlbumRepository repository;
	@Test
	public void findAll() {
		List<Album> albums = repository.findAll();
		assertEquals(super.countRowsInTable("albums"), albums.size());
		String vorigeNaam = "";
		for (Album album : albums) {
			assertTrue(vorigeNaam.compareToIgnoreCase(album.getNaam()) <= 0);
			vorigeNaam = album.getNaam();
		}
	}

}
