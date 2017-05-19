package ba.biblioteka.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import ba.biblioteka.models.Kategorija;

public interface KategorijaRepository extends Repository<Kategorija, Integer> {
	long count();
	boolean exists(Integer primaryKey);
	public List<Kategorija> findAll();	
}
