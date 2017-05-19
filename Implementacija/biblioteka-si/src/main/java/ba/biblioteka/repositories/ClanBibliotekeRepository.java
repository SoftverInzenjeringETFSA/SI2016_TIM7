package ba.biblioteka.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import ba.biblioteka.models.Administrator;
import ba.biblioteka.models.ClanBiblioteke;
import ba.biblioteka.models.Moderator;

public interface ClanBibliotekeRepository extends Repository<ClanBiblioteke, Integer> {
	long count();
	boolean exists(Integer primaryKey);
	public List<ClanBiblioteke> findAll();
	ClanBiblioteke findOne(Integer id);
}
