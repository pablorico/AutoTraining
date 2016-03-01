package net.redirectme.per;

import net.redirectme.per.calificador.configuration.RepositoryConfiguration;
import net.redirectme.per.calificador.entities.Calificacion;
import net.redirectme.per.calificador.repositories.CalificacionRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class CalificacionRepositoryTest {

    private CalificacionRepository calificacionRepository;

    @Autowired
    public void setCalificacionRepository(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    @Test
    public void testSaveCalificacion(){
        //setup calificacion
        Calificacion calificacion = new Calificacion();
        calificacion.setExcelente(1);
        
        //save product, verify has ID value after save
        assertNull(calificacion.getId()); //null before save
        calificacionRepository.save(calificacion);
        assertNotNull(calificacion.getId()); //not null after save

        //fetch from DB
        Calificacion fetchedCalificacion = calificacionRepository.findOne(calificacion.getId());

        //should not be null
        assertNotNull(fetchedCalificacion);

        //should equal
        assertEquals(calificacion.getId(), fetchedCalificacion.getId());
        assertEquals(calificacion.getFecha(), fetchedCalificacion.getFecha());

        //update description and save
        fetchedCalificacion.setExcelente(-1);
        fetchedCalificacion.setBueno(1);
        calificacionRepository.save(fetchedCalificacion);

        //get from DB, should be updated
        Calificacion fetchedUpdatedCalificacion = calificacionRepository.findOne(fetchedCalificacion.getId());
        assertEquals(fetchedCalificacion.getBueno(), fetchedUpdatedCalificacion.getBueno());

        //verify count of products in DB
        long calificacionCount = calificacionRepository.count();
        assertEquals(calificacionCount, 1);

        //get all products, list should only have one
        Iterable<Calificacion> calificaciones = calificacionRepository.findAll();

        int count = 0;

        for(@SuppressWarnings("unused") Calificacion c : calificaciones){
            count++;
        }

        assertEquals(count, 1);
    }
}