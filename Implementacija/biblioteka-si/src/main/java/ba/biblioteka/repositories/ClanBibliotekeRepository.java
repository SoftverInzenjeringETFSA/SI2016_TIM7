package ba.biblioteka.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ba.biblioteka.models.ClanBiblioteke;

public interface ClanBibliotekeRepository extends Repository<ClanBiblioteke, Integer> {
	long count();
	boolean exists(Integer primaryKey);
	public List<ClanBiblioteke> findAll();
	ClanBiblioteke findOne(Integer id);
	
	@Transactional
	@Modifying
	@Query("delete from ClanBiblioteke where id = :id")
	public void deleteMember(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query(value="insert into clanbiblioteke (broj_clanske_karte, datum_rodjenja, adresa, mjesto_stanovanja, broj_telefona, ustanova, email, id_osobe) "
				+ "select :broj_clanske_karte as broj_clanske_karte, "
				+ ":datum_rodjenja as datum_rodjenja,"
				+ ":adresa as adresa,"
				+ ":mjesto_stanovanja as mjesto_stanovanja,"
				+ ":broj_telefona as broj_telefona,"
				+ ":ustanova as ustanova,"
				+ ":email as email,"
				+ "id as id_osobe "
				+ "from osoba "
				+ "where id = :id_osobe", nativeQuery = true)
	public void addNewMember(@Param("broj_clanske_karte") String brojClanskeKarte, 
							 @Param("datum_rodjenja") Date datumRodjenja,
							 @Param("adresa") String adresa,
							 @Param("mjesto_stanovanja") String mjestoStanovanja,
							 @Param("broj_telefona") String brojTelefona,
							 @Param("ustanova") String ustanova,
							 @Param("email") String email,
							 @Param("id_osobe") Integer id_osobe);
	
}
