package ba.biblioteka.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ba.biblioteka.models.Osoba;

public interface OsobaRepository extends CrudRepository<Osoba, Integer> {
	long count();
	boolean exists(Integer primaryKey);
	public List<Osoba> findAll();
	
	@Transactional
	@Modifying
	@Query("delete from Osoba where id = :id")
	public void deleteMod(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query(value="insert into osoba (korisnicko_ime, ime, prezime, sifra, tip) "
				+"values (:korisnicko_ime, :ime, :prezime, :sifra, :tip)", nativeQuery = true)
	public void addNewOsoba(@Param("korisnicko_ime") String korisnickoIme, 
						  @Param("ime") String ime, 
						  @Param("prezime") String prezime, 
						@Param("sifra") String sifra,
						@Param("tip") String tip);
	
	
	@Query("select o from Osoba o where korisnicko_ime=? and sifra=?")
	public Osoba findByUsernameAndPassword(String korisnicko_ime, String sifra);
	
	
	@Query("select o from Osoba o where o.korisnicko_ime=?")
	public Osoba findByKorisnickoIme(String korisnicko_ime);

}