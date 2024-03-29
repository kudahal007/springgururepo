package guru.springframework.Spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import guru.springframework.Spring5webapp.repositories.BookRepository;

@Controller
public class BookController {

	private BookRepository bookRepository;
	
	public BookController(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}

	@RequestMapping(value="/books", method=RequestMethod.GET)
	public String getBooks(Model model) {
		
        
		model.addAttribute("books", bookRepository.findAll());		
		return "books";
	}
	@RequestMapping("/")
	public String getIndex() {
		return "index";
	}
	
}
