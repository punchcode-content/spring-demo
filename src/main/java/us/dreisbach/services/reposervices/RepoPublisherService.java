package us.dreisbach.services.reposervices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.dreisbach.entities.Publisher;
import us.dreisbach.repositories.PublisherRepository;
import us.dreisbach.services.PublisherService;

@Service
public class RepoPublisherService implements PublisherService {
	private PublisherRepository repo;

	@Autowired
	public void setPublisherRepository(PublisherRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<?> listAll() {
		List<Publisher> publishers = new ArrayList<>();
		repo.findAll().forEach((Publisher p) -> publishers.add(p));
		return publishers;
	}

	@Override
	public Publisher getById(Integer id) {
		return repo.findOne(id);
	}

	@Override
	public Publisher saveOrUpdate(Publisher entity) {
		return repo.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repo.delete(id);
	}
}
