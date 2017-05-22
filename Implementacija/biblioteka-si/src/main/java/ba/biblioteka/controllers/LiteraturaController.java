package ba.biblioteka.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ba.biblioteka.models.Literatura;
import ba.biblioteka.services.UpravljanjeLiteraturomService;

@CrossOrigin
@RestController
@RequestMapping(path="/literatura")
public class LiteraturaController {
	@Autowired
	private UpravljanjeLiteraturomService literaturaService;
	
	@RequestMapping(value = "/brisi", method = RequestMethod.POST)
	public void deleteLiterature(@RequestParam("id") Integer id) {
		this.literaturaService.deleteLiterature(id);
	}
}
