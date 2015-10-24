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
 
    	Individuo individuo1, individuo2,individuo3, individuo4 ;
        Familia rico = new Familia();
        rico.setFamilia("Rico");
        familiaRepository.save(rico);
        individuo1 = new Individuo();
        individuo1.setApellido("Rico");
        individuo1.setNombre("Pablo Eduardo");
        individuo1.setDocumento(21749446);
        individuo1.setFamilia(rico);
        rico.getIndividuos().add(individuo1);
        individuo2 = new Individuo();
        individuo2.setApellido("Stronati");
        individuo2.setNombre("Mariela Andrea");
        individuo2.setDocumento(23471642);
        individuo2.setFamilia(rico);
        rico.getIndividuos().add(individuo2);
        familiaRepository.save(rico);
        
        log.info("Saved Familia - id: " + rico.getFamiliaId());
 
        Familia carrasco = new Familia();
        carrasco.setFamilia("Carrasco");
        familiaRepository.save(carrasco);
        individuo3 = new Individuo();
        individuo3.setApellido("Carrasco");
        individuo3.setNombre("Jorge");
        individuo3.setDocumento(20729226);
        individuo3.setFamilia(carrasco);
        carrasco.getIndividuos().add(individuo3);
        individuo4 = new Individuo();
        individuo4.setApellido("Stronati");
        individuo4.setNombre("Alejandra Cynthia");
        individuo4.setDocumento(25332642);
        individuo4.setFamilia(carrasco);
        carrasco.getIndividuos().add(individuo4);
        familiaRepository.save(carrasco);
        
        log.info("Saved Familia - id: " + carrasco.getFamiliaId());
    }
}