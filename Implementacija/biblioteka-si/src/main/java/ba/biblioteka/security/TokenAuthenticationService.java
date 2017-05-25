package ba.biblioteka.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.io.IOException;

import static java.util.Collections.emptyList;

import ba.biblioteka.repositories.AdministratorRepository;
import ba.biblioteka.repositories.ClanBibliotekeRepository;
import ba.biblioteka.repositories.ModeratorRepository;
import ba.biblioteka.repositories.OsobaRepository;
import ba.biblioteka.services.OsobaPosebniDetaljiService;
import ba.biblioteka.models.Osoba;

class TokenAuthenticationService {

    private static OsobaRepository osobaRepository;
    private static OsobaPosebniDetaljiService osobaDetaljiService;
    
    
    static final long EXPIRATIONTIME = 864_000_000; // 10 days
    static final String SECRET = "ThisIsASecret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";
    static final String HEADER_CORS = "Access-Control-Allow-Origin";
    static final String RS_ORIGIN = "http://localhost:4200";

    static void addAuthentication(HttpServletResponse res, String username, ServletContext servletContext) throws IOException {
    	OsobaPosebniDetaljiService os = WebApplicationContextUtils.getWebApplicationContext(servletContext).getBean(OsobaPosebniDetaljiService.class);
    	String role = os.getKorisnikTypeByUserName(username);
    	String k = os.getKorisnikByUserName(username).getId().toString();
    	
    	
    	String JWT = Jwts.builder()
                .claim("userid", k)
                .claim("role", role)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
        res.addHeader(HEADER_CORS, RS_ORIGIN);

        res.getWriter().write("{ \"token\" : \"" + JWT + "\" }");
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        osobaRepository = webApplicationContext.getBean(OsobaRepository.class);

        String token = request.getHeader(HEADER_STRING);
        
        if (token != null) {
            String userReq = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .get("username").toString();

            Osoba user = osobaRepository.findByUsername(userReq);
            Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

            if (user != null) {
                grantedAuthorities.add(new SimpleGrantedAuthority(osobaDetaljiService.getRole(user.getId())));
            }

            return userReq != null ?
                    new UsernamePasswordAuthenticationToken(userReq, null, grantedAuthorities) :
                    null;
        }
        return null;
    }    
}