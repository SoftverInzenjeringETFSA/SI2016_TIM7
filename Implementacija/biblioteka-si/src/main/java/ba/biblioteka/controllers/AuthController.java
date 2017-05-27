package ba.biblioteka.controllers;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ba.biblioteka.db.dbActions;
import ba.biblioteka.dto.LoginDataRequest;
import ba.biblioteka.dto.LoginDataResponse;
import ba.biblioteka.models.Osoba;
import ba.biblioteka.repositories.OsobaRepository;
import ba.biblioteka.services.AuthService;
import ba.biblioteka.services.JwtService;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {
	 
	    @Autowired
		private AuthService _authService;

	    
	    
		@RequestMapping(path="", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity<LoginDataResponse> login(@RequestBody LoginDataRequest request) {
	 
				try {
	    		 
	        	Osoba user = _authService.checkLoginData(request.getKorisnicko_ime(), request.getSifra());
	        	
	        	if (user != null) {

	        		    String token=null;
	        			token = JwtService.issueToken(false,false);	        		
		                 return ResponseEntity
		            		      .status(HttpStatus.OK)
		                           .body(new LoginDataResponse(user, token));
	        	}
	        	else {
	        		throw new ServiceException("");
	        	}
	           
	    	}
	    	catch (ServiceException e) {
	    		return ResponseEntity
	    				.status(HttpStatus.BAD_REQUEST)
	                    .body(new LoginDataResponse("Neispravno korisnicko ime ili sifra."));
	    	}
	    }
}
