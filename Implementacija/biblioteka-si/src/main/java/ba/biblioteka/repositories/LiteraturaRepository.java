package ba.biblioteka.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import ba.biblioteka.models.Literatura;

public interface LiteraturaRepository extends Repository<Literatura, Integer> {
	long count();
	boolean exists(Integer primaryKey);
	public List<Literatura> findAll();	
	
	@Query("select l from Literatura l where l.kategorija.id = :id")
	public List<Literatura> findAllLiteratureForCategory(@Param("id") Integer id);
	
	/*@Query("select l from Literatura l where l.unajmio_clan.id = :id")
	public List<Literatura> findAllZaduzenjabyId(@Param("id") Integer id);
	*/
	
}
