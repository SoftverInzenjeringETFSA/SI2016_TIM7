package ba.biblioteka.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.biblioteka.models.ClanBiblioteke;
import ba.biblioteka.models.Literatura;
import ba.biblioteka.services.UpravljanjeLiteraturomService;

@CrossOrigin
@RestController
@RequestMapping(path="/clan")
public class ClanController {
	
	@Autowired
	private UpravljanjeLiteraturomService literaturaService;
	
	@RequestMapping("/literatura")
	public List<Literatura> findAllLiterature() {
		return this.literaturaService.findAllLiterature();
	}
}
