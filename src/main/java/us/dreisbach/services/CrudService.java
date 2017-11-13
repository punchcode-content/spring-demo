package us.dreisbach.services;

import java.util.List;

public interface CrudService<T> {
	List<?> listAll();

	T getById(Integer id);

	T saveOrUpdate(T entity);

	void delete(Integer id);
}
