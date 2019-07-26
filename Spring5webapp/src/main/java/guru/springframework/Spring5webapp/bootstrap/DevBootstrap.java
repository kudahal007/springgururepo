package guru.springframework.Spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.Spring5webapp.model.Author;
import guru.springframework.Spring5webapp.model.Book;
import guru.springframework.Spring5webapp.model.Publisher;
import guru.springframework.Spring5webapp.repositories.AuthorRepository;
import guru.springframework.Spring5webapp.repositories.BookRepository;
import guru.springframework.Spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	private void initData() {
		Publisher publisher = new Publisher();
		publisher.setName("Harper Collins");
		publisherRepository.save(publisher);
		
		//Eric
		Author eric = new Author("Eric","Evans");
		Book ddd = new Book("Domain Driven Design","1234",publisher);
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		//Rod
		Author rod = new Author("Rod","Johnson");
		Book noEJB = new Book("J2EE Development without EJB","23444",publisher);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
	}

}
