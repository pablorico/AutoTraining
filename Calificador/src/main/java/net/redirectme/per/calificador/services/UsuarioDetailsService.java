package net.redirectme.per.calificador.services;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.redirectme.per.calificador.entities.PerfilDeUsuario;
import net.redirectme.per.calificador.entities.Usuario;
 
@Service("usuarioDetailsService")
public class UsuarioDetailsService implements UserDetailsService{
 
    @Autowired
    private UsuarioService usuarioService;
     
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String usuarioId)
            throws UsernameNotFoundException {
    	System.out.println("Usuario solicitado: "+usuarioId);
    	Usuario u = usuarioService.getUsuarioByUsuario(usuarioId);
        System.out.println("Usuario : "+u);
        if(u==null){
            System.out.println("Usuario inexistente");
            throw new UsernameNotFoundException("Usuario inexistente");
        }
            return new org.springframework.security.core.userdetails.User(u.getUsuarioId(), u.getPassword(), 
                 true, true, true, true, getGrantedAuthorities(u));
    }
 
     
    private List<GrantedAuthority> getGrantedAuthorities(Usuario u){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for(PerfilDeUsuario perfilDeUsuario : u.getPerfilesDeUsuario()){
            System.out.println("PerfilDeUsuario : "+perfilDeUsuario);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+perfilDeUsuario.getTipo()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }

     
}