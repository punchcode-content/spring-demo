package us.dreisbach.repositories;

import org.springframework.data.repository.CrudRepository;

import us.dreisbach.entities.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
