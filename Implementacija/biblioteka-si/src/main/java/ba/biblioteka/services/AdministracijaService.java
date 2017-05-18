package ba.biblioteka.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.biblioteka.models.Administrator;
import ba.biblioteka.models.ClanBiblioteke;
import ba.biblioteka.models.Moderator;
import ba.biblioteka.repositories.AdministratorRepository;
import ba.biblioteka.repositories.ClanBibliotekeRepository;
import ba.biblioteka.repositories.ModeratorRepository;

@Service
public class AdministracijaService {
	
	@Autowired
	AdministratorRepository adminRepository;
	@Autowired
	ModeratorRepository moderatorRepository;
	@Autowired
	ClanBibliotekeRepository clanRepository;
	
	
	public List<Administrator> findAllAdmins() {
		return this.adminRepository.findAll();
	}
	
	public List<Moderator> findAllMods() {
		return this.moderatorRepository.findAll();
	}
	
	public List<ClanBiblioteke> findAllMembers() {
		return this.clanRepository.findAll();
	}
}
