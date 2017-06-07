package ba.biblioteka.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ba.biblioteka.models.Administrator;
import ba.biblioteka.models.ClanBiblioteke;
import ba.biblioteka.models.Kategorija;
import ba.biblioteka.models.Literatura;
import ba.biblioteka.models.Moderator;
import ba.biblioteka.models.Osoba;
import ba.biblioteka.services.AdministracijaService;
import ba.biblioteka.services.UpravljanjeLiteraturomService;

@CrossOrigin
@RestController
@RequestMapping(path="/administracija")
public class AdministratorController {
	
	@Autowired 
	private AdministracijaService administracijaService;
	//@Autowired
	//private UpravljanjeLiteraturomService literaturaService;
	
	@RequestMapping("/administratori")
	public List<Administrator> findAllAdmins() {
		return this.administracijaService.findAllAdmins();
	}
	
	@RequestMapping(value = "/administratori/brisi", method = RequestMethod.POST)
	public void deleteAdmin(@RequestParam("id") Integer id) {
		this.administracijaService.deleteAdmin(id);
	}
	
	@RequestMapping(value = "/administratori/dodaj", method = RequestMethod.POST)
	public void addNewAdmin(@RequestParam("korisnicko-ime") Integer idOsobe, 
			@RequestParam("sigurnosniId") Integer sigurnosniId) {
		//TODO: Add more validation
		if(idOsobe != null && sigurnosniId != null)
			this.administracijaService.addNewAdmin(idOsobe, sigurnosniId);
	}
	
	@RequestMapping("/moderatori")
	public List<Moderator> findAllMods() {
		return this.administracijaService.findAllMods();
	}
	
	@RequestMapping(value = "/moderatori/brisi", method = RequestMethod.POST)
	public void deleteMod(@RequestParam("id") Integer id) {
		this.administracijaService.deleteMod(id);
	}
	
	@RequestMapping(value = "/moderatori/dodaj", method = RequestMethod.POST)
	public void addNewMod(@RequestParam("korisnicko-ime") Integer idOsobe, 
						  @RequestParam("sigurnosniId") Integer sigurnosniId,
						  @RequestParam("adresa") String adresa,
						  @RequestParam("grad") String grad,
						  @RequestParam("email") String email) {
		
		//TODO: Add more validation
		if(idOsobe != null && sigurnosniId != null && adresa != null && grad != null && email != null)
			this.administracijaService.addNewMod(idOsobe, sigurnosniId, adresa, grad, email);
	}
	
	@RequestMapping("/clanovi")
	public List<ClanBiblioteke> findAllMembers() {
		return this.administracijaService.findAllMembers();
	}
	
	@RequestMapping(value = "/clanovi/brisi", method = RequestMethod.POST)
	public void deleteMember(@RequestParam("id") Integer id) {
		this.administracijaService.deleteMember(id);
	}
	
	@RequestMapping(value = "/clanovi/dodaj", method = RequestMethod.POST)
	@ResponseBody
	public void addNewMember(@RequestParam("broj_clanske_karte") String brojClanskeKarte, 
			@RequestParam("datum_rodjenja") String datumRodjenja,
			@RequestParam("adresa") String adresa,
			@RequestParam("mjesto_stanovanja") String mjestoStanovanja,
			@RequestParam("broj_telefona") String brojTelefona,
			@RequestParam("ustanova") String ustanova,
			@RequestParam("email") String email,
			@RequestParam("korisnicko_ime") Integer idOsobe, 
			HttpServletRequest request, 
			HttpServletResponse response)
			throws ParseException{
		
		if(brojClanskeKarte != null && datumRodjenja != null && adresa != null && mjestoStanovanja != null && brojTelefona != null && ustanova != null && email != null && idOsobe != null){
			ClanBiblioteke clan = this.administracijaService.findMemberById(idOsobe);
			
			if(clan == null){
				DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
				this.administracijaService.addNewMember(brojClanskeKarte, df.parse(datumRodjenja), adresa, mjestoStanovanja, brojTelefona, ustanova, email, idOsobe);
			
				response.setStatus(HttpServletResponse.SC_OK);
				return;
			}
		}
		
		response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
	}
	
	
	@RequestMapping(value = "/clan/{id}", method = RequestMethod.GET)
	public ClanBiblioteke findMemberById(@PathVariable("id") Integer id) {
		return this.administracijaService.findMemberById(id);
	}
	
	@RequestMapping(value = "/osoba/dodaj", method = RequestMethod.POST)
	@ResponseBody
	public void addNewOsoba(@RequestParam("korisnicko_ime") String korisnicko_ime, 
						  @RequestParam("ime") String ime,
						  @RequestParam("prezime") String prezime,
						  @RequestParam("sifra") String sifra,
						  @RequestParam("tip") String tip, HttpServletRequest request, HttpServletResponse response){
		
		if(korisnicko_ime != null && ime != null && prezime != null && sifra != null && tip != null){
			Osoba o = this.administracijaService.findOsobaByUsername(korisnicko_ime);
			
			if(o == null){
				this.administracijaService.addNewOsoba(korisnicko_ime, ime, prezime, sifra, tip);
				response.setStatus(HttpServletResponse.SC_OK);
				return;
			}
		}
		
		response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
	}
	
	@RequestMapping("/osoba")
	public List<Osoba> findAllOsobe() {
		return this.administracijaService.findAllOsobe();
	}
	
}
