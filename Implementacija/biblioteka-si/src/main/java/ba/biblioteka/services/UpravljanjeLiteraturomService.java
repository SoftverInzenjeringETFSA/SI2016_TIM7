package ba.biblioteka.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.biblioteka.models.Kategorija;
import ba.biblioteka.models.Literatura;
import ba.biblioteka.repositories.KategorijaRepository;
import ba.biblioteka.repositories.LiteraturaRepository;


@Service
public class UpravljanjeLiteraturomService {
	@Autowired
	KategorijaRepository kategorijaRepository;
	@Autowired
	LiteraturaRepository literaturaRepository;
	
	public List<Kategorija> findAllCategories(){
		return this.kategorijaRepository.findAll();
	}
	
	public List<Literatura> findAllLiteratureByCategory(Integer id){
		return literaturaRepository.findAllLiteratureForCategory(id);
	}
	
	public List<Literatura> findAllLiterature(){
		return literaturaRepository.findAll();
	}
}
