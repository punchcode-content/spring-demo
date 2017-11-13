package us.dreisbach.repositories;

import org.springframework.data.repository.CrudRepository;

import us.dreisbach.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
