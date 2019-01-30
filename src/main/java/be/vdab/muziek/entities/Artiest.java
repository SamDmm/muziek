package be.vdab.muziek.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artiesten")
public class Artiest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;
	
	public Artiest(String naam) {
		this.naam = naam;
	}
	protected Artiest() {
	}
	
	public long getId() {
		return id;
	}
	public String getNaam() {
		return naam;
	}	
}
