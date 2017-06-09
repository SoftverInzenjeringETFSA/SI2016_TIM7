package ba.biblioteka.dto;

import ba.biblioteka.models.Osoba;

public class LoginDataResponse {
 
    private Osoba korisnik;
	
	private String errorMessage;

	private String token;
	
	public LoginDataResponse() {
		
	}
	
	public LoginDataResponse(String errorMessage) {
		this.setErrorMessage(errorMessage);
	}
	
	public LoginDataResponse(Osoba korisnik, String token) {
		this.setKorisnik(korisnik);
		this.setToken(token);
	}

	public Osoba getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Osoba korisnik) {
		this.korisnik = korisnik;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
