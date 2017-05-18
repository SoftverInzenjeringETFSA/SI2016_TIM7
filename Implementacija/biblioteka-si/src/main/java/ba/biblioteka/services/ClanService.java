package ba.biblioteka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.biblioteka.repositories.ClanBibliotekeRepository;

@Service
public class ClanService {
	@Autowired
	ClanBibliotekeRepository clanRepository;
	
	
}
