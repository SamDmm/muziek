package be.vdab.muziek.repositories;

import java.util.List;
import java.util.Optional;

import be.vdab.muziek.entities.Album;

public interface AlbumRepository {
	List<Album> findAll();
	Optional<Album> read(long id);
}
