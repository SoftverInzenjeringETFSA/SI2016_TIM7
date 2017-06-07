package ba.biblioteka.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import ba.biblioteka.models.Administrator;
import ba.biblioteka.models.ClanBiblioteke;
import ba.biblioteka.models.Moderator;
import ba.biblioteka.models.Osoba;
import ba.biblioteka.repositories.AdministratorRepository;
import ba.biblioteka.repositories.ClanBibliotekeRepository;
import ba.biblioteka.repositories.ModeratorRepository;
import ba.biblioteka.repositories.OsobaRepository;

@Service
public class AdministracijaService {
	
	@Autowired
	AdministratorRepository adminRepository;
	@Autowired
	ModeratorRepository moderatorRepository;
	@Autowired
	ClanBibliotekeRepository clanRepository;
	@Autowired
	OsobaRepository osobaRepository;
	
	
	public List<Administrator> findAllAdmins() {
		return this.adminRepository.findAll();
	}
	
	public void deleteAdmin(Integer id){
		this.adminRepository.deleteAdmin(id);
	}
	
	public void addNewAdmin(Integer idOsobe, Integer sigurnosniId){
		this.adminRepository.addNewAdmin(idOsobe, sigurnosniId);
	}
	
	public Administrator findAdminById(Integer idOsobe){
		return this.adminRepository.findAdminById(idOsobe);
	}
	
	public List<Moderator> findAllMods() {
		return this.moderatorRepository.findAll();
	}
	
	public void deleteMod(Integer id){
		this.moderatorRepository.deleteMod(id);
	}
	
	public Moderator findModById(Integer idOsobe){
		return this.moderatorRepository.findModById(idOsobe);
	}
	
	public void addNewMod(Integer korisnickoIme, Integer sigurnosniId, String adresa, String grad, String email){
		this.moderatorRepository.addNewMod(korisnickoIme, sigurnosniId, adresa, grad, email);
	}
	
	public void addNewOsoba(String korisnickoIme, String ime, String prezime, String sifra, String tip){
		this.osobaRepository.addNewOsoba(korisnickoIme, ime, prezime, sifra, tip);
	}
	
	public List<ClanBiblioteke> findAllMembers() {
		return this.clanRepository.findAll();
	}
	
	public List<Osoba> findAllOsobe() {
		return this.osobaRepository.findAll();
	}
	
	public Osoba findOsobaByUsername(String username){
		return this.osobaRepository.findByKorisnickoIme(username);
	}
	
	public void deleteMember(Integer id){
		this.clanRepository.deleteMember(id);
	}
	
	public void addNewMember(String brojClanskeKarte, 
							 Date datumRodjenja, 
							 String adresa, 
							 String mjestoStanovanja,
							 String brojTelefona, 
							 String ustanova,
							 String email,
							 Integer korisnickoIme){
		this.clanRepository.addNewMember(brojClanskeKarte, datumRodjenja, adresa, mjestoStanovanja, brojTelefona, ustanova, email, korisnickoIme);
	}
	
	public ClanBiblioteke findMemberById(Integer id){
		return this.clanRepository.findById(id);
	}
	
	public ClanBiblioteke findById(Integer id){
		return this.clanRepository.findOne(id);
	}
}
