package ba.biblioteka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ba.biblioteka.db.dbActions;
import ba.biblioteka.models.Osoba;

import ba.biblioteka.repositories.OsobaRepository;

@RestController
@CrossOrigin
@RequestMapping(path="/osoba")
public class OsobaController {
/*
	@Autowired
	private OsobaRepository roleRepository;
	
	@CrossOrigin
	@GetMapping(path="/get")
	public @ResponseBody Osoba getById(@RequestParam("id") Integer id) {
		return roleRepository.findById(id);
	}
	
	*/
	
	
	
	
}
