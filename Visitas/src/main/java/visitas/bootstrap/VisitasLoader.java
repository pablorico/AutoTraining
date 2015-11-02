package visitas.bootstrap;

import java.sql.Date;


import javax.transaction.Transactional;

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
import visitas.repositories.SiervoRepository;
import visitas.repositories.VisitaRepository;

@Component
public class VisitasLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private IglesiaRepository iglesiaRepository;

	@Autowired
	private MinisterioRepository ministerioRepository;

	@Autowired
	private VisitaRepository visitaRepository;
	
	@Autowired
	private SiervoRepository siervoRepository;
	
	@Autowired
	private FamiliaRepository familiaRepository;
	
	private Logger log = Logger.getLogger(VisitasLoader.class);

	public void setIglesiaRepository(IglesiaRepository iglesiaRepository) {
		this.iglesiaRepository = iglesiaRepository;
	}

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {

		log.info("Creando Ministerios ...");
		_createMinisterios();
		log.info("Creando Iglesias ...");
		Iglesia saavedra = _createIglesia();
		log.info("Creando Familias ...");
		_createFamilias(saavedra);
		log.info("Creando Siervos ...");
		_createSiervos(saavedra);
		log.info("Creando Visitas ...");
		_createVisita(saavedra);
		log.info("Todo Creado!");
	}
	
	private void _createMinisterios() {
		Ministerio m = new Ministerio();
		m.setMinisterio("Pastor");
		ministerioRepository.save(m);
		m = new Ministerio();
		m.setMinisterio("Diacono");
		ministerioRepository.save(m);
	}
	
	private Iglesia _createIglesia() {
		Iglesia i = new Iglesia();
		i.setIglesia("Saavedra");
		iglesiaRepository.save(i);
		return i;
	}
	
	private void _createFamilias(Iglesia iglesia) {

		Familia f;
		Individuo i;
		f = new Familia();
		f.setIglesia(iglesia);
		f.setFamilia("Rico");
		
		i = new Individuo();
		i.setApellido("Rico");
		i.setNombre("Pablo");
		i.setDocumento(10);
		i.setFamilia(f);

		f.getIndividuos().add(i);
		
		i = new Individuo();
		i.setApellido("Stronati");
		i.setNombre("Mariela");
		i.setDocumento(250);
		i.setFamilia(f);
		
		f.getIndividuos().add(i);
		
		i = new Individuo();
		i.setApellido("Rico");
		i.setNombre("Fiore");
		i.setDocumento(220);
		i.setFamilia(f);
		
		f.getIndividuos().add(i);
		
		iglesia.getFamilias().add(f);
		
		
		familiaRepository.save(f);

		f = new Familia();
		f.setIglesia(iglesia);
		f.setFamilia("Gregorio");
		
		i = new Individuo();
		i.setApellido("Gregorio");
		i.setNombre("Gaston");
		i.setDocumento(20);
		i.setFamilia(f);

		f.getIndividuos().add(i);
		
		i = new Individuo();
		i.setApellido("Gregorio");
		i.setNombre("Marta");
		i.setDocumento(340);
		i.setFamilia(f);

		f.getIndividuos().add(i);
		
		iglesia.getFamilias().add(f);
		
		
		familiaRepository.save(f);

		//iglesiaRepository.save(iglesia);
		
		
	}
	
	private void _createSiervos(Iglesia iglesia) {
		Siervo s = new Siervo();
		s.setIglesia(iglesia);
		iglesia.getSiervos().add(s);
		s.setMinisterio(ministerioRepository.findOne(1));
		s.setIndividuo(_getIndividuo(iglesia,"Rico","Pablo"));
		s.getIndividuo().setSiervo(s);
		siervoRepository.save(s);
		s = new Siervo();
		s.setIglesia(iglesia);
		iglesia.getSiervos().add(s);
		s.setMinisterio(ministerioRepository.findOne(2));
		s.setIndividuo(_getIndividuo(iglesia,"Gregorio","Gaston"));
		s.getIndividuo().setSiervo(s);
		siervoRepository.save(s);
		
		
		
		
	}
	
	private Individuo _getIndividuo (Iglesia iglesia, String apellido, String nombre) {
		Individuo r=null;
		for(Familia f:iglesia.getFamilias()) {
			if(f.getFamilia().equals(apellido)) {
				for (Individuo i: f.getIndividuos()) {
					if(i.getNombre().equals(nombre)) {
						return (i);
					}
				}
			}
		}
		return r;
	}
	
	private void _createVisita(Iglesia iglesia) {
		Visita v=new Visita();
		v.setIglesia(iglesia);
		v.setFamilia(familiaRepository.findOne(1));
		Enviado e;
		e = new Enviado();
		e.setVisita(v);
		e.setSiervo(siervoRepository.findOne(1));
		v.setaCargo(e);
		v.getColaboradores().add(e);
		e = new Enviado();
		e.setVisita(v);
		e.setSiervo(siervoRepository.findOne(2));
		v.getColaboradores().add(e);
		v.setFecha(new Date(System.currentTimeMillis()));
		visitaRepository.save(v);
	}
	

	public void setMinisterioRepository(MinisterioRepository ministerioRepository) {
		this.ministerioRepository = ministerioRepository;
	}

	public void setVisitaRepository(VisitaRepository visitaRepository) {
		this.visitaRepository = visitaRepository;
	}

	public void setSiervoRepository(SiervoRepository siervoRepository) {
		this.siervoRepository = siervoRepository;
	}

	public void setFamiliaRepository(FamiliaRepository familiaRepository) {
		this.familiaRepository = familiaRepository;
	}
}