package be.vdab.muziek.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

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
	
	public Album(Artiest artiest, String naam) {
		this.artiest = artiest;
		this.naam = naam;
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
}
