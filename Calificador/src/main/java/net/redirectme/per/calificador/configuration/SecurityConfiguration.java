package net.redirectme.per.calificador.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
    @Qualifier("usuarioDetailsService")
    UserDetailsService usuarioDetailsService;
     
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioDetailsService);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
        .antMatchers("/", "/home","/cambiarClave").permitAll()
        .antMatchers("/usuarios").access("hasRole('ADMIN')")
        .antMatchers("/calificaciones","/calificacionesXLS").access("hasRole('SUPERVISOR')")
        .antMatchers("/calificar").access("hasRole('OPERADOR')")
        .and().formLogin().loginPage("/login")
        .and().csrf()
        .and().exceptionHandling().accessDeniedPage("/acceso_invalido");
    }
/* NO SECURITY
    @Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers("/").permitAll()
		.and().authorizeRequests().antMatchers("/console/**").permitAll();
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
*/
}