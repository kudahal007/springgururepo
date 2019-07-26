package guru.springframework.Spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.springframework.Spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {
	
	private AuthorRepository authorRepository;
	
	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping(value="/authors", method=RequestMethod.GET)
	public String getAuthor(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		return "authors";
	}

}
