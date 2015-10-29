package visitas.bootstrap;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import visitas.model.Enviado;
import visitas.model.Familia;
import visitas.model.Iglesia;
import visitas.model.Individuo;
import visitas.model.Ministerio;
import visitas.model.Siervo;
import visitas.model.Visita;
import visitas.repositories.FamiliaRepository;
import visitas.repositories.IglesiaRepository;
import visitas.repositories.MinisterioRepository;

@Component
public class VisitasLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private FamiliaRepository familiaRepository;

	@Autowired
	private IglesiaRepository iglesiaRepository;

	@Autowired
	private MinisterioRepository ministerioRepository;

	private Logger log = Logger.getLogger(VisitasLoader.class);

	public void setFamiliaRepository(FamiliaRepository familiaRepository) {
		this.familiaRepository = familiaRepository;
	}

	public void setIglesiaRepository(IglesiaRepository iglesiaRepository) {
		this.iglesiaRepository = iglesiaRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Iglesia saavedra;
		Ministerio pastor, diacono;
		Individuo pablo, mariela, lucila, giuliana, fiorella, gaston;
		Familia rico, gregorio;
		Siervo pastorPablo,diaconoGregorio;
		Visita visita;
		Enviado ePastor, eDiacono;
		
		saavedra=new Iglesia();
		pastor=new Ministerio();
		diacono=new Ministerio();
		pablo=new Individuo();
		mariela=new Individuo();
		lucila=new Individuo();
		giuliana=new Individuo();
		fiorella=new Individuo();
		gaston=new Individuo();
		rico=new Familia();
		gregorio=new Familia();
		pastorPablo=new Siervo();
		diaconoGregorio=new Siervo();
		visita= new Visita();
		ePastor=new Enviado();
		eDiacono=new Enviado();
		
		
		saavedra.setIglesia("Saavedra");
		
		rico.setFamilia("Rico");
		gregorio.setFamilia("Gregorio");
		
		saavedra.getFamilias().add(rico);
		saavedra.getFamilias().add(gregorio);
		saavedra.getSiervos().add(pastorPablo);
		saavedra.getSiervos().add(diaconoGregorio);
		rico.setIglesia(saavedra);
		gregorio.setIglesia(saavedra);
		pastor.setMinisterio("Pastor");
		diacono.setMinisterio("Diacono");
		pastorPablo.setIglesia(saavedra);
		pastorPablo.setMinisterio(pastor);
		diaconoGregorio.setMinisterio(diacono);
		diaconoGregorio.setIglesia(saavedra);
		/*
		
		
		ministerioRepository.save(pastor);
		pastor.getSiervos().add(pastorPablo);
		ministerioRepository.save(d);
		diacono.getSiervos().add(diaconoGregorio);
		
		
		pablo.setFamilia(rico);
		pablo.setSiervo(pastorPablo);
		pablo.setApellido("Rico");
		pablo.setNombre("Pablo Eduardo");
		pablo.setDocumento(21749446);
		
		mariela.setFamilia(rico);
		mariela.setApellido("Stronati");
		mariela.setNombre("Mariela Andrea");
		mariela.setDocumento(23471642);
		
		lucila.setFamilia(rico);
		lucila.setApellido("Rico");
		lucila.setNombre("Lucila");
		lucila.setDocumento(43471642);
		
		giuliana.setFamilia(rico);
		giuliana.setApellido("Rico");
		giuliana.setNombre("Giuli");
		giuliana.setDocumento(53471642);
		
		fiorella.setFamilia(rico);
		fiorella.setApellido("Rico");
		fiorella.setNombre("Fiore");
		fiorella.setDocumento(63471642);
				
		gaston.setFamilia(gregorio);
		gaston.setSiervo(diaconoGregorio);
		gaston.setApellido("Gregorio");
		gaston.setNombre("Gaston");
		gaston.setDocumento(33471642);
		
				
		pastorPablo.setIndividuo(pablo);
		pastorPablo.setMinisterio(pastor);
		diaconoGregorio.setIndividuo(gaston);
		diaconoGregorio.setMinisterio(diacono);
		
		ePastor.setSiervo(pastorPablo);
		eDiacono.setSiervo(diaconoGregorio);
		
		visita.setaCargo(ePastor);
		visita.getColaboradores().add(ePastor);
		visita.getColaboradores().add(eDiacono);
		visita.setFamilia(rico);
		visita.setFecha(new Date(System.currentTimeMillis()));
		visita.setIglesia(saavedra);
		
		
		
		
		
		
		
		*/
		// familiaRepository.save(rico);
		iglesiaRepository.save(saavedra);
		
		/*
		 * 
		 * log.info("Saved Familia - id: " + rico.getId()); Iglesia bosch = new
		 * Iglesia(); bosch.setIglesia("Villa Bosch");
		 * //iglesiaRepository.save(bosch);
		 * 
		 * Familia carrasco = new Familia(); carrasco.setFamilia("Carrasco");
		 * carrasco.setIglesia(bosch);
		 * 
		 * individuo = new Individuo(); individuo.setApellido("Carrasco");
		 * individuo.setNombre("Jorge"); individuo.setDocumento(20729226);
		 * individuo.setFamilia(carrasco);
		 * carrasco.getIndividuos().add(individuo);
		 * 
		 * siervo = new Siervo(); siervo.setIndividuo(individuo);
		 * individuo.setSiervo(siervo);
		 * 
		 * individuo = new Individuo(); individuo.setApellido("Stronati");
		 * individuo.setNombre("Alejandra Cynthia");
		 * individuo.setDocumento(25332642); individuo.setFamilia(carrasco);
		 * carrasco.getIndividuos().add(individuo); individuo = new Individuo();
		 * individuo.setApellido("Carrasco"); individuo.setNombre("Valentina");
		 * individuo.setDocumento(45332642); individuo.setFamilia(carrasco);
		 * carrasco.getIndividuos().add(individuo);
		 * 
		 * familiaRepository.save(carrasco);
		 * 
		 * log.info("Saved Familia - id: " + carrasco.getId());
		 */
	}

	public void setMinisterioRepository(MinisterioRepository ministerioRepository) {
		this.ministerioRepository = ministerioRepository;
	}
}