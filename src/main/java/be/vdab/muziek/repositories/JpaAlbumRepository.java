package be.vdab.muziek.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import be.vdab.muziek.entities.Album;

@Repository
class JpaAlbumRepository implements AlbumRepository {
	private final EntityManager manager;
	
	JpaAlbumRepository(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Album> findAll() {
		return manager.createQuery("select a from Album a order by a.naam", Album.class).getResultList();
	}

}
