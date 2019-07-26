package guru.springframework.Spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.Spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
