package ba.biblioteka.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ba.biblioteka.models.Administrator;
import ba.biblioteka.models.ClanBiblioteke;
import ba.biblioteka.models.Kategorija;
import ba.biblioteka.models.Literatura;
import ba.biblioteka.models.Moderator;
import ba.biblioteka.services.AdministracijaService;
import ba.biblioteka.services.UpravljanjeLiteraturomService;

@CrossOrigin
@RestController
@RequestMapping(path="/administracija")
public class AdministratorController {
	
	@Autowired 
	private AdministracijaService administracijaService;
	@Autowired
	private UpravljanjeLiteraturomService literaturaService;
	
	@RequestMapping("/administratori")
	public List<Administrator> findAllAdmins() {
		return this.administracijaService.findAllAdmins();
	}
	
	@RequestMapping("/moderatori")
	public List<Moderator> findAllMods() {
		return this.administracijaService.findAllMods();
	}
	
	@RequestMapping("/clanovi")
	public List<ClanBiblioteke> findAllMembers() {
		return this.administracijaService.findAllMembers();
	}
	
	@RequestMapping("/kategorije")
	public List<Kategorija> findAllCategories(){
		return this.literaturaService.findAllCategories();
	}
	
	@RequestMapping(value = "literatura/kategorija/{id}", method = RequestMethod.GET)
	public List<Literatura> findCategoryById(@PathVariable("id") Integer id) {
		return this.literaturaService.findAllLiteratureByCategory(id);
	}
	
	@RequestMapping(value = "/clan/{id}", method = RequestMethod.GET)
	public ClanBiblioteke findMemberById(@PathVariable("id") Integer id) {
		return this.administracijaService.findById(id);
	}
}
