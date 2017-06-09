package ba.biblioteka.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ba.biblioteka.db.dbActions;
import ba.biblioteka.dto.LoginDataResponse;
import ba.biblioteka.models.Osoba;
import ba.biblioteka.repositories.OsobaRepository;


@Service
public class AuthService {
	

	private static Osoba _user = new Osoba();
	 
	public Osoba checkLoginData(String username, String password){
		try {
			dbActions db = new dbActions();
	        db.connectToDB();
	        
	        _user = db.searchUserForLogin(username, password);
	        
	         db.close();
	         if(_user != null)
			   return _user;
	         else
	        	 return null;
	        	 
		 }
		catch (Exception e)
			 {
				 return null;
			 }
    }

}
