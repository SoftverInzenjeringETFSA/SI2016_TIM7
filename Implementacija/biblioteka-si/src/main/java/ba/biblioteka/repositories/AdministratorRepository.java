package ba.biblioteka.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import ba.biblioteka.models.Administrator;

public interface AdministratorRepository extends Repository<Administrator, Integer> {
	long count();
	boolean exists(Integer primaryKey);
	public List<Administrator> findAll();	
}