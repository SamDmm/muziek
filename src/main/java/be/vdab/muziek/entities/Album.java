package be.vdab.muziek.entities;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import be.vdab.muziek.valueObjects.Track;

@Entity
@Table (name = "albums")
@NamedEntityGraph(name = Album.MET_ARTIEST, attributeNodes = @NamedAttributeNode("artiest"))
public class Album {
	public static final String MET_ARTIEST = "Album.metArtiest";
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "artiestId")
	private Artiest artiest;
	private String naam;
	@ElementCollection
	@CollectionTable(name = "tracks", joinColumns = @JoinColumn(name = "albumid"))
	@OrderBy("naam")
	private Set<Track> tracks;
	
	public Album(Artiest artiest, String naam) {
		this.artiest = artiest;
		this.naam = naam;
		this.tracks = new LinkedHashSet<>();
	}
	protected Album() {
	}
	
	public long getId() {
		return id;
	}
	public Artiest getArtiest() {
		return artiest;
	}
	public String getNaam() {
		return naam;
	}
	public Set<Track> getTracks() {
		return Collections.unmodifiableSet(tracks);
	}
}
