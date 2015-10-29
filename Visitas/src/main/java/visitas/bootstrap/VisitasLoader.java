package visitas.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import visitas.model.Familia;
import visitas.model.Iglesia;
import visitas.model.Individuo;
import visitas.model.Siervo;
import visitas.repositories.FamiliaRepository;
import visitas.repositories.IglesiaRepository;

 
@Component
public class VisitasLoader implements ApplicationListener<ContextRefreshedEvent> {
    
	@Autowired
    private FamiliaRepository familiaRepository;
 
	@Autowired
	private IglesiaRepository iglesiaRepository;
	
    private Logger log = Logger.getLogger(VisitasLoader.class);
 

    public void setFamiliaRepository(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }
 
    public void setIglesiaRepository(IglesiaRepository iglesiaRepository) {
        this.iglesiaRepository = iglesiaRepository;
    }
 
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
 
    	Iglesia saavedra = new Iglesia();
    	saavedra.setIglesia("Saavedra");
    	iglesiaRepository.save(saavedra);
    	
    	Iglesia bosch = new Iglesia();
    	bosch.setIglesia("Villa Bosch");
    	iglesiaRepository.save(bosch);
    	
    	
    	Individuo individuo;
        Siervo siervo;
    	
    	Familia rico = new Familia();
        rico.setFamilia("Rico");
        rico.setIglesia(saavedra);
              
        individuo = new Individuo();
        
        
        individuo.setApellido("Rico");
        individuo.setNombre("Pablo Eduardo");
        individuo.setDocumento(21749446);
        individuo.setFamilia(rico);
      
        
     
        rico.getIndividuos().add(individuo);
        
        siervo = new Siervo();
        siervo.setIndividuo(individuo);
        individuo.setSiervo(siervo);
        
        individuo = new Individuo();
        individuo.setApellido("Stronati");
        individuo.setNombre("Mariela Andrea");
        individuo.setDocumento(23471642);
        individuo.setFamilia(rico);

        rico.getIndividuos().add(individuo);
        
        familiaRepository.save(rico);
        
        
        log.info("Saved Familia - id: " + rico.getId());
 
        Familia carrasco = new Familia();
        carrasco.setFamilia("Carrasco");
        carrasco.setIglesia(bosch);
        
        individuo = new Individuo();
        individuo.setApellido("Carrasco");
        individuo.setNombre("Jorge");
        individuo.setDocumento(20729226);
        individuo.setFamilia(carrasco);
        carrasco.getIndividuos().add(individuo);
        
        siervo = new Siervo();
        siervo.setIndividuo(individuo);
        individuo.setSiervo(siervo);
        
        individuo = new Individuo();
        individuo.setApellido("Stronati");
        individuo.setNombre("Alejandra Cynthia");
        individuo.setDocumento(25332642);
        individuo.setFamilia(carrasco);
        carrasco.getIndividuos().add(individuo);
        individuo = new Individuo();
        individuo.setApellido("Carrasco");
        individuo.setNombre("Valentina");
        individuo.setDocumento(45332642);
        individuo.setFamilia(carrasco);
        carrasco.getIndividuos().add(individuo);
        
        familiaRepository.save(carrasco);
        
        log.info("Saved Familia - id: " + carrasco.getId());
    }
}