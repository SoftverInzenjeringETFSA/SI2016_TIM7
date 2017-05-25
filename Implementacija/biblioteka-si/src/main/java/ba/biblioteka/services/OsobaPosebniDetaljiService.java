package ba.biblioteka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import ba.biblioteka.models.Osoba;
import ba.biblioteka.repositories.AdministratorRepository;
import ba.biblioteka.repositories.ClanBibliotekeRepository;
import ba.biblioteka.repositories.ModeratorRepository;
import ba.biblioteka.repositories.OsobaRepository;

@Service
public class OsobaPosebniDetaljiService implements UserDetailsService {
    static Logger logger = Logger.getLogger(OsobaPosebniDetaljiService.class.getName());

    @Autowired
    private OsobaRepository osobaRepository;
    
    @Autowired
    private AdministratorRepository adminRepository;
    @Autowired
    private ModeratorRepository moderatorRepository;
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Osoba user = osobaRepository.findByUsername(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }

        logger.info(user.getKorisnicko_ime() + " " + user.getSifra() + " " + getGrantedAuthorities(user)
                + "/" + getRole(user.getId()));

        return new User(user.getKorisnicko_ime(), user.getSifra(), getGrantedAuthorities(user));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(Osoba user) {

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        
        if (getRole(user.getId()) != null) {
            grantedAuthorities.add(new SimpleGrantedAuthority(getRole(user.getId())));
        }
        
        return grantedAuthorities;
    }
    
    
    public String getRole(Integer id) {
    	if(adminRepository.findOne(id) != null)
    		return "ROLE_ADMIN";
    	else if(moderatorRepository.findOne(id) != null)
    		return "ROLE_MOD";
    	
    	return "ROLE_CLAN";
    }
    
    public String getKorisnikTypeByUserName(String username){
    	Osoba o = osobaRepository.findByUsername(username);
    	
    	return getRole(o.getId());
    }
    
    public Osoba getKorisnikByUserName(String username){
    	return osobaRepository.findByUsername(username);
    }
}
