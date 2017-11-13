package us.dreisbach.repositories;

import org.springframework.data.repository.CrudRepository;

import us.dreisbach.entities.Title;

public interface TitleRepository extends CrudRepository<Title, Integer> {

}
