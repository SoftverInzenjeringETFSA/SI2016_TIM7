package ba.biblioteka.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ba.biblioteka.models.Kategorija;

public interface KategorijaRepository extends Repository<Kategorija, Integer> {
	long count();
	boolean exists(Integer primaryKey);
	public List<Kategorija> findAll();
	
	@Transactional
	@Modifying
	@Query("delete from Kategorija where id = :id")
	public void deleteCategory(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query(value="insert into kategorija (naziv_kategorije, potkategorija, opis) values (:nazivKategorije, :potkategorije, :opis)", nativeQuery = true)
	public void addNewCategory(@Param("nazivKategorije") String nazivKategorije, @Param("potkategorije") String potkategorije, @Param("opis") String opis);
}
