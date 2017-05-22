package ba.biblioteka.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	public void addNewCategory(String nazivKategorije, String potkategorije, String opis){
		this.kategorijaRepository.addNewCategory(nazivKategorije, potkategorije, opis);
	}
	
	public void deleteCategory(Integer id) {
		this.kategorijaRepository.deleteCategory(id);
	}
	
	
	public List<Literatura> findAllLiteratureByCategory(Integer id){
		return literaturaRepository.findAllLiteratureForCategory(id);
	}
	
	public List<Literatura> findAllLiterature(){
		return literaturaRepository.findAll();
	}
	
	public void addNewLiterature(String autor, 
								String naziv,
								String izdavac,
								Date godina, 
								Integer brojStrana,
								String komentar,
								boolean mPreuzimanja,
								Date datumUnosa,
								Integer kategorijaId){
		this.literaturaRepository.addNewLiterature(autor, naziv, izdavac, godina, brojStrana, komentar, mPreuzimanja, datumUnosa, kategorijaId);
	}
	
	public void deleteLiterature(Integer id) {
		this.literaturaRepository.deleteLiterature(id);
	}
	
	public List<Literatura> searchLiterature(String query) {
		return this.literaturaRepository.searchLiterature(query);
	}
}
