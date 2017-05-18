package ba.biblioteka.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ClanController {
	@RequestMapping(path="/clanbibliotekes")
	public String hello() {
		return "Hello world";
	}
}
