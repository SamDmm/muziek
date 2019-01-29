package be.vdab.muziek.repositories;

import java.util.List;

import be.vdab.muziek.entities.Album;

public interface AlbumRepository {
	List<Album> findAll();
}
