package us.dreisbach.repositories;

import org.springframework.data.repository.CrudRepository;

import us.dreisbach.entities.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {

}
