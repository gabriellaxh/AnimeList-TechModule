package animelist.controller;

import animelist.entity.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import animelist.bindingModel.AnimeBindingModel;
import animelist.repository.AnimeRepository;

import java.util.List;

@Controller
public class AnimeController {

	private final AnimeRepository animeRepository;

	@Autowired
	public AnimeController(AnimeRepository animeRepository) {
		this.animeRepository = animeRepository;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Anime> animes = this.animeRepository.findAll();

		model.addAttribute("view", "anime/index");
		model.addAttribute("animes", animes);

		return "base-layout";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("view", "anime/create");

		return "base-layout";
	}

	@PostMapping("/create")
	public String createProcess(Model model, AnimeBindingModel animeBindingModel) {
		Anime animeEntity = new Anime(
				animeBindingModel.getId(),
				animeBindingModel.getRating(),
				animeBindingModel.getName(),
				animeBindingModel.getDescription(),
				animeBindingModel.getWatched()
		);
		this.animeRepository.saveAndFlush(animeEntity);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		Anime animeEntity = this.animeRepository.findOne(id);

		model.addAttribute("view", "anime/delete");
		model.addAttribute("anime", animeEntity);

		return "base-layout";
	}

	@PostMapping("/delete/{id}")
	public String deleteProcess(Model model, @PathVariable int id, AnimeBindingModel animeBindingModel) {
		Anime animeEntity = this.animeRepository.findOne(id);

		this.animeRepository.delete(animeEntity);

		return "redirect:/";
	}
}
