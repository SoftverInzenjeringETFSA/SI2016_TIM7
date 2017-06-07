package ba.biblioteka.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ba.biblioteka.models.ClanBiblioteke;
import ba.biblioteka.models.Kategorija;
import ba.biblioteka.models.Literatura;
import ba.biblioteka.services.AdministracijaService;
import ba.biblioteka.services.UpravljanjeLiteraturomService;

@CrossOrigin
@RestController
@RequestMapping(path="/moderator")
public class ModeratorController {
	@Autowired 
	private AdministracijaService administracijaService;
	@Autowired
	private UpravljanjeLiteraturomService literaturaService;
	
	
	@RequestMapping("/clanovi")
	public List<ClanBiblioteke> findAllMembers() {
		return this.administracijaService.findAllMembers();
	}
	
	@RequestMapping("/kategorije")
	public List<Kategorija> findAllCategories(){
		return this.literaturaService.findAllCategories();
	}
	
	@RequestMapping(value = "/kategorije/dodaj", method = RequestMethod.POST)
	public void addNewCategory(@RequestParam("naziv-kategorije") String nazivKategorije, 
			@RequestParam("potkategorije") String potkategorije,
			@RequestParam("opis-kategorije") String opis) {
		
		this.literaturaService.addNewCategory(nazivKategorije, potkategorije, opis);
	}
	
	@RequestMapping("/literatura")
	public List<Literatura> findAllLiterature() {
		return this.literaturaService.findAllLiterature();
	}
	
	@RequestMapping(value = "/literatura/dodaj", method = RequestMethod.POST)
	public void addNewLiterature(@RequestParam("autor-literature") String autor, 
			@RequestParam("naziv-literature") String naziv,
			@RequestParam("izdavac") String izdavac,
			@RequestParam("godina-izdavanja") Integer godina, 
			@RequestParam("broj-strana") Integer brojStrana,
			@RequestParam("komentar") String komentar,
			@RequestParam("mogucnost-preuzimanja") boolean mPreuzimanja,
			@RequestParam("datum-unosa") String datumUnosa,
			@RequestParam("kategorija") Integer kategorijaId) throws ParseException 
	{
		
		DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
		this.literaturaService.addNewLiterature(autor, naziv, izdavac, godina, brojStrana, komentar, mPreuzimanja, df.parse(datumUnosa), kategorijaId);
	}
	
	/*
	@RequestMapping(value = "literatura/update", method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody Literatura literatura, @RequestParam(name="id")int id) {
	return ResponseEntity.status(HttpStatus.OK).body(literaturaService.updateLiteratura(literatura, id));
    }*/
	
	@RequestMapping(value = "/clanovi/dodaj", method = RequestMethod.POST)
	public void addNewMember(@RequestParam("broj_clanske_karte") String brojClanskeKarte, 
			@RequestParam("datum_rodjenja") String datumRodjenja,
			@RequestParam("adresa") String adresa,
			@RequestParam("mjesto_stanovanja") String mjestoStanovanja,
			@RequestParam("broj_telefona") String brojTelefona,
			@RequestParam("ustanova") String ustanova,
			@RequestParam("email") String email,
			@RequestParam("korisnicko-ime") Integer idOsobe)
			throws ParseException{
		
		DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
		this.administracijaService.addNewMember(brojClanskeKarte, df.parse(datumRodjenja), adresa, mjestoStanovanja, brojTelefona, ustanova, email, idOsobe);
	}
	
	@RequestMapping(value = "/osoba/dodaj", method = RequestMethod.POST)
	public void addNewOsoba(@RequestParam("korisnicko-ime") String korisnicko_ime, 
						  @RequestParam("ime") String ime,
						  @RequestParam("prezime") String prezime,
						  @RequestParam("sifra") String sifra,
						  @RequestParam("tip") String tip){
		
		//TODO: Add more validation
		//if(korisnickoIme != null && sigurnosniId != null && adresa != null && grad != null && email != null)
			this.administracijaService.addNewOsoba(korisnicko_ime, ime, prezime, sifra, tip);
	}
	
	@RequestMapping(value = "literatura/kategorija/{id}", method = RequestMethod.GET)
	public List<Literatura> findAllLiteratureByCategory(@PathVariable("id") Integer id) {
		return this.literaturaService.findAllLiteratureByCategory(id);
	}
	
	@RequestMapping(value = "literatura/update/{id}", method = RequestMethod.POST)
	public ResponseEntity update(@RequestBody Literatura literatura, @RequestParam(name="id")int id) {
		return ResponseEntity.status(HttpStatus.OK).body(literaturaService.updateLiteratura(literatura, id));
		}
	
	@RequestMapping(value = "/clanovi/brisi", method = RequestMethod.POST)
	public void deleteMember(@RequestParam("id") Integer id) {
		this.administracijaService.deleteMember(id);
	}
	
}
