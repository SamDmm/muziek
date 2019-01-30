package be.vdab.muziek.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.muziek.repositories.AlbumRepository;

@Controller
@RequestMapping("/")
class IndexController {
	private static final String INDEX_VIEW = "index";
	private final AlbumRepository albumService;
	IndexController(AlbumRepository albumService) {
		this.albumService = albumService;
	}
	@GetMapping
	ModelAndView startPagina() {
		return new ModelAndView(INDEX_VIEW, "albums", albumService.findAll());
	}
}
