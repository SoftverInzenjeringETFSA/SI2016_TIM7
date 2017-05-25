package ba.biblioteka.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


import ba.biblioteka.security.JWTLoginFilter;
import ba.biblioteka.security.JWTAuthenticationFilter;
import ba.biblioteka.services.OsobaPosebniDetaljiService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private OsobaPosebniDetaljiService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http.csrf().disable().authorizeRequests()
		    	.antMatchers(HttpMethod.POST, "/login").permitAll()
		        .antMatchers(HttpMethod.POST, "/register").permitAll()
				.antMatchers("/administracija/**").hasRole("ADMIN")
				.antMatchers("/administracija/administratori/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/administracija/administratori/brisi").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/administracija/administratori/dodaj").hasRole("ADMIN")
				.antMatchers("/administracija/moderatori/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/administracija/moderatori/brisi").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/administracija/moderatori/dodaj").hasRole("ADMIN")
				.antMatchers("/administracija/clanovi/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/administracija/clanovi/brisi").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/administracija/osoba/dodaj").hasRole("ADMIN")
				.antMatchers("/administracija/osoba/**").hasRole("ADMIN")
				.antMatchers("/clan/**").hasRole("CLAN")
				.antMatchers("/clan/literatura/**").hasRole("CLAN")
				.antMatchers("/clan/pretraga/**").hasRole("CLAN")				
				.antMatchers(HttpMethod.POST, "/clan/brisi").hasAnyRole("ADMIN", "MOD")
				.antMatchers("/moderator/**").hasRole("MOD")
				.antMatchers("/moderator/clanovi").hasRole("MOD")
				.antMatchers("/moderator/kategorije/**").hasRole("MOD")
				.antMatchers(HttpMethod.POST, "/moderator/kategorije/dodaj").hasRole("MOD")
				.antMatchers("/moderator/literatura").hasRole("MOD")
				.antMatchers(HttpMethod.POST, "/moderator/literatura/dodaj").hasRole("MOD")
				.antMatchers(HttpMethod.POST, "/administracija/clanovi/dodaj").hasRole("MOD")
				.antMatchers("/moderator/literatura/kategorija/**").hasRole("MOD")
		        .anyRequest().authenticated()
		        .and()
		        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
		                UsernamePasswordAuthenticationFilter.class)
		        // And filter other requests to check the presence of JWT in header
		        .addFilterBefore(new JWTAuthenticationFilter(),
		                UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}