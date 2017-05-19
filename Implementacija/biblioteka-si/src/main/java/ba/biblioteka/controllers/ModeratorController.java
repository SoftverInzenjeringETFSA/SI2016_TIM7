package ba.biblioteka.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping("/literatura")
	public List<Literatura> findAllLiterature() {
		return this.literaturaService.findAllLiterature();
	}
	
	@RequestMapping("/kategorije")
	public List<Kategorija> findAllCategories(){
		return this.literaturaService.findAllCategories();
	}
}
