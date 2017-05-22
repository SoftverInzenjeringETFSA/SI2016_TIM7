package ba.biblioteka.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ba.biblioteka.models.Moderator;

public interface ModeratorRepository extends Repository<Moderator, Integer> {
	long count();
	boolean exists(Integer primaryKey);
	public List<Moderator> findAll();
	
	@Transactional
	@Modifying
	@Query("delete from Moderator where id = :id")
	public void deleteMod(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query(value="insert into moderator (sigurnosni_id, adresa, grad, email, id_osobe) "
				+ "select :sigurnosniId as sigurnosni_id, "
				+ ":adresa as adresa, "
				+ ":grad as grad, "
				+ ":email as email, "
				+ "id as id_osobe "
				+ "from osoba "
				+ "where korisnicko_ime = :korisnickoIme", nativeQuery = true)
	public void addNewMod(@Param("korisnickoIme") String korisnickoIme, 
						  @Param("sigurnosniId") Integer sigurnosniId,
						  @Param("adresa") String adresa, 
						  @Param("grad") String grad, 
						  @Param("email") String email);
}