package ba.biblioteka.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.biblioteka.models.ClanBiblioteke;
import ba.biblioteka.repositories.ClanoviRepository;

@Service
public class ClanoviService {
	
	@Autowired
	ClanoviRepository clanoviRepository;
	
	public List<ClanBiblioteke> getAll() {
		return this.clanoviRepository.findAll();
	}
}
