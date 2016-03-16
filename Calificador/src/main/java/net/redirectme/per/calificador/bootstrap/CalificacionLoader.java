package net.redirectme.per.calificador.bootstrap;

import net.redirectme.per.calificador.entities.Calificacion;
import net.redirectme.per.calificador.repositories.CalificacionRepository;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CalificacionLoader implements ApplicationListener<ContextRefreshedEvent> {

    private CalificacionRepository calificacionRepository;

    private Logger log = Logger.getLogger(CalificacionLoader.class);

    @Autowired
    public void setCalificacionRepository(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Calificacion c1 = new Calificacion();
        c1.setTurno("Dia");
        c1.setExcelente(1);
        c1.setBueno(4);
        c1.setFecha(Date.valueOf("2016-02-25"));
        calificacionRepository.save(c1);
        log.info("Saved 25-feb-2016 - id: " + c1.getId());

        Calificacion c2 = new Calificacion();
        c2.setTurno("Noche");
        c2.setExcelente(10);
        c2.setMalo(3);
        c2.setFecha(Date.valueOf("2016-02-25"));
        calificacionRepository.save(c2);
        log.info("Saved 25/Noche-feb-2016 - id: " + c2.getId());
        
        Calificacion c3 = new Calificacion();
        c3.setTurno("Noche");
        c3.setBueno(6);
        c3.setMalo(2);
        c3.setFecha(Date.valueOf("2016-02-28"));
        calificacionRepository.save(c3);
        log.info("Saved 28-feb-2016 - id: " + c3.getId());
        
        
    }
}