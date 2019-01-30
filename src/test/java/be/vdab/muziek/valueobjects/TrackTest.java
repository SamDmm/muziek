package be.vdab.muziek.valueobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import be.vdab.muziek.valueobjects.Track;

public class TrackTest {
	private Track track1;
	private Track nogEensTrack1;
	private Track track2;
	private Track track3;
	@Before
	public void before() {
		track1 = new Track("test", BigDecimal.ONE);
		nogEensTrack1 = new Track("test", BigDecimal.ONE);
		track2 = new Track("test2", BigDecimal.ONE);
		track3 = new Track("test", BigDecimal.TEN);
	}
	@Test
	public void tracksMetDezelfdeNaamEnDezelfdeTijdZijnHetzelfde() {
		assertEquals(track1, nogEensTrack1);
	}
	@Test
	public void tracksMetVerschillendeNaamEnDezelfdeTijdZijnVerschillend() {
		assertNotEquals(track1, track2);
	}
	@Test
	public void tracksMetDezelfdeNaamEnVerschillendeTijdZijnVerschillend() {
		assertNotEquals(track1, track3);
	}
	

}
