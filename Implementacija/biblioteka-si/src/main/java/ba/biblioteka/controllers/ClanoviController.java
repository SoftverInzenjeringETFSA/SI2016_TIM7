package ba.biblioteka.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.biblioteka.models.ClanBiblioteke;
import ba.biblioteka.services.ClanoviService;

@RestController
@RequestMapping(path="/clanovi")

public class ClanoviController {
	@Autowired
	private ClanoviService clanoviService;
	
	@RequestMapping(value="/all")
	public List<ClanBiblioteke> getAllMembers() {
		return clanoviService.getAll();
	}
}
