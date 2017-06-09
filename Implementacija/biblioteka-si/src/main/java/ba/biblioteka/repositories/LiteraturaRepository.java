package ba.biblioteka.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import ba.biblioteka.models.ClanBiblioteke;
import ba.biblioteka.models.Literatura;

public interface LiteraturaRepository extends PagingAndSortingRepository<Literatura, Integer> {
	long count();
	boolean exists(Integer primaryKey);
	public List<Literatura> findAll();	
	Literatura findOne(Integer id);
	
	@Query("select l from Literatura l where l.kategorija.id = :id")
	public List<Literatura> findAllLiteratureForCategory(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query("delete from Literatura where id = :id")
	public void deleteLiterature(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query(value="insert into literatura (autor_literature, naziv_literature, izdavac, godina_izdavanja, broj_strana, komentar, mogucnost_preuzimanja, datum_unosa, kategorija) "
			+ "values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)", nativeQuery = true)
	public void addNewLiterature(String autor, 
			String naziv,
			String izdavac,
			Integer godina, 
			Integer brojStrana,
			String komentar,
			boolean mPreuzimanja,
			Date datumUnosa,
			Integer kategorijaId);
	
	@Query(value = "select * from literatura where naziv_literature like %:query%", nativeQuery = true)
	public List<Literatura> searchLiterature(@Param("query") String query);


	@Query("select l from Literatura l where id=?")
	public Literatura findById(Integer id);
	
	@Query("select l from Literatura l where naziv_literature=?")
	public ArrayList<Literatura> findByNaziv_literature(String id);
	
	@Query("select l from Literatura l where l.naziv_literature=?")
	public Literatura findByName(String nazivLiterature);

}

