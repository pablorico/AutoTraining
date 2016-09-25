package mock.webapp;

import mock.webapp.entities.*;
import mock.webapp.repositories.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MockWebRepositoryTest {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Test
    public void testSaveUsuario(){
        //setup data
        Usuario usuario = new Usuario();
        usuario.setNombre("Pablo");
        usuario.setApellido("Rico");
        usuario.setPassword("pass");
        usuario.setUsuarioId("PER");
        
        RolDeUsuario perfil = new RolDeUsuario();
        perfil.setTipo("ADMIN");
        
        usuario.addRolDeUsuario(perfil);
        
        //save data, verify has ID value after save
        assertNull(usuario.getId()); //null before save
        usuarioRepository.save(usuario);
        assertNotNull(usuario.getId()); //not null after save

        //fetch from DB
        Usuario fetchedUsuario = usuarioRepository.findOne(usuario.getId());

        //should not be null
        assertNotNull(fetchedUsuario);

        //should equal
        assertEquals(usuario.getId(), fetchedUsuario.getId());
        assertEquals(usuario.getApellido(), fetchedUsuario.getApellido());
        
        //get all products, list should only have one
        Iterable<Usuario> usuarios = usuarioRepository.findAll();

        int count = 0;

        for(@SuppressWarnings("unused") Usuario c : usuarios){
            count++;
        }
        
        System.out.println("C="+count);

        assertEquals(count, 4);
    }
}