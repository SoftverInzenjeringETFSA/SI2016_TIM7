package ba.biblioteka.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ba.biblioteka.models.Administrator;
import ba.biblioteka.models.ClanBiblioteke;

public interface AdministratorRepository extends Repository<Administrator, Integer> {
	long count();
	boolean exists(Integer primaryKey);
	List<Administrator> findAll();
	Administrator findOne(Integer id);
	
	@Transactional
	@Modifying
	@Query("delete from Administrator where id = :id")
	public void deleteAdmin(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query(value="insert into administrator (sigurnosni_id, id_osobe) select :sigurnosniId as sigurnosni_id,"
			+ "id as id_osobe "
				+ "from osoba "
				+ "where id = :id_osobe", nativeQuery = true)
	public void addNewAdmin(@Param("id_osobe") Integer id_osobe, 
			@Param("sigurnosniId") Integer sigurnosniId);
}