package net.redirectme.per.calificador.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		//httpSecurity.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated()
				// .authorizeRequests().antMatchers("/console/**").permitAll()//
		//		.and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
		httpSecurity.authorizeRequests().antMatchers("/").permitAll()
		.and().authorizeRequests().antMatchers("/console/**").permitAll();
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

}