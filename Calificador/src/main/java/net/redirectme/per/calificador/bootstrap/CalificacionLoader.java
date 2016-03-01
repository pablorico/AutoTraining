package net.redirectme.per.calificador.bootstrap;

import net.redirectme.per.calificador.entities.Calificacion;
import net.redirectme.per.calificador.repositories.CalificacionRepository;
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

        Calificacion excelente1 = new Calificacion();
        excelente1.setExcelente(1);
        calificacionRepository.save(excelente1);
        
        log.info("Saved Excelente - id: " + excelente1.getId());

        Calificacion excelente2 = new Calificacion();
        excelente2.setExcelente(1);
        calificacionRepository.save(excelente2);
        
        log.info("Saved Excelente - id: " + excelente2.getId());

        Calificacion bueno = new Calificacion();
        bueno.setBueno(1);
        calificacionRepository.save(bueno);
        
        log.info("Saved Bueno - id: " + bueno.getId());

        Calificacion malo = new Calificacion();
        malo.setMalo(1);
        calificacionRepository.save(malo);
        
        log.info("Saved Malo - id: " + malo.getId());

    }
}