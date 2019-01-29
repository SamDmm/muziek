package be.vdab.muziek.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.muziek.repositories.AlbumRepository;

@Controller
@RequestMapping("albums")
class AlbumController {
	private final AlbumRepository albumRepository;
	private static final String ALBUM_VIEW = "album";
	AlbumController(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
	}
	@GetMapping("{id}")
	ModelAndView album(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView(ALBUM_VIEW);
		albumRepository.read(id).ifPresent(album -> modelAndView.addObject(album));
		return modelAndView;
	}
}
