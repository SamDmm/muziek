package be.vdab.muziek.web;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.vdab.muziek.entities.Album;
import be.vdab.muziek.services.AlbumService;

@Controller
@RequestMapping("albums")
class AlbumController {
	private final AlbumService albumService;
	private static final String ALBUM_VIEW = "album";
	private static final String REDIRECT_ALBUM_NIET_GEVONDEN = "redirect:/"; 
	AlbumController(AlbumService albumService) {
		this.albumService = albumService;
	}
	@GetMapping("{id}")
	ModelAndView album(@PathVariable long id, RedirectAttributes redirectAttributes) {
		Optional<Album> albumOptional = albumService.read(id);
		if (albumOptional.isPresent()) {
			return new ModelAndView(ALBUM_VIEW).addObject(albumOptional.get());
		}
		redirectAttributes.addAttribute("fout", "album niet gevonden");
		return new ModelAndView(REDIRECT_ALBUM_NIET_GEVONDEN);
	}
}
