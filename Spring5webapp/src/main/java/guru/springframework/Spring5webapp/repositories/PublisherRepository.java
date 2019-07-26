package guru.springframework.Spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.Spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
