package autotraining.basicjpa.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import autotraining.basicjpa.model.Familia;
import autotraining.basicjpa.model.Individuo;
import autotraining.basicjpa.repositories.FamiliaRepository;

 
@Component
public class FamiliaLoader implements ApplicationListener<ContextRefreshedEvent> {
 
    private FamiliaRepository familiaRepository;
 
    private Logger log = Logger.getLogger(FamiliaLoader.class);
 
    @Autowired
    public void setFamiliaRepository(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }
 
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
 
    	Individuo individuo;
        Familia rico = new Familia();
        rico.setFamilia("Rico");
        individuo = new Individuo();
        individuo.setApellido("Rico");
        individuo.setNombre("Pablo Eduardo");
        individuo.setDocumento(21749446);
        rico.getIndividuos().add(individuo);
        individuo = new Individuo();
        individuo.setApellido("Stronati");
        individuo.setNombre("Mariela Andrea");
        individuo.setDocumento(23471642);
        rico.getIndividuos().add(individuo);
        familiaRepository.save(rico);
        
        log.info("Saved Familia - id: " + rico.getId());
 
        Familia carrasco = new Familia();
        carrasco.setFamilia("Carrasco");
        individuo = new Individuo();
        individuo.setApellido("Carrasco");
        individuo.setNombre("Jorge");
        individuo.setDocumento(20729226);
        carrasco.getIndividuos().add(individuo);
        individuo = new Individuo();
        individuo.setApellido("Stronati");
        individuo.setNombre("Alejandra Cynthia");
        individuo.setDocumento(25332642);
        carrasco.getIndividuos().add(individuo);
        familiaRepository.save(carrasco);
        
        log.info("Saved Familia - id: " + carrasco.getId());
    }
}