package ba.biblioteka.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.security.core.GrantedAuthority;

import ba.biblioteka.db.dbActions;
import ba.biblioteka.models.Osoba;
import ba.biblioteka.repositories.OsobaRepository;
import ba.biblioteka.services.izuzetak.ServiceException;

@Service
public class OsobaService {

    @Autowired
    public static OsobaRepository repository;
	
    
    public Iterable<ba.biblioteka.models.Osoba> findAllUsers() {
        return repository.findAll();
    }
    
    
    public Boolean addUsers(ba.biblioteka.models.Osoba k) throws ServiceException {
    	
    	if(repository.findByKorisnickoIme(k.getKorisnicko_ime()) != null) {
            throw new ServiceException("Korisnik sa datim korisnicko_ime-om vec postoji!");
        }
    	  
    	ba.biblioteka.models.Osoba kreiranKorisnik = repository.save(k);

        return kreiranKorisnik != null;
	}
    
    public static boolean storeUser(String Osoba){
    
    	StringBuilder jsonString = new StringBuilder();
    	jsonString.append(Osoba);
    	JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject(jsonString.toString());
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
    	try {
			String korisnicko_ime = jsonObj.getString("korisnicko_ime");
			String sifra = jsonObj.getString("sifra");
			dbActions db = new dbActions();
	        try {
				db.connectToDB();
				db.storeUser(korisnicko_ime, sifra);
		        db.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        
			 
		} catch (JSONException e) {
			e.printStackTrace();
		}
    	
    	return true;
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(ba.biblioteka.models.Osoba korisnik) {
		
		return null;
	}


	
}
