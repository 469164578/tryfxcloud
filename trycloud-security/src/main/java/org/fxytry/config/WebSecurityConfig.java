package org.fxytry.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.passwordEncoder(new BCryptPasswordEncoder())
			.withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("USER","ADMIN")
			.and()
			.withUser("fxy").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().anyRequest().fullyAuthenticated();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	
	
	

}
