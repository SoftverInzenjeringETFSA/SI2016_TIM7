package ba.biblioteka.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import ba.biblioteka.models.Moderator;

public interface ModeratorRepository extends Repository<Moderator, Integer> {
	long count();
	boolean exists(Integer primaryKey);
	public List<Moderator> findAll();	
}