package visitas.test;

import static org.junit.Assert.assertNotNull;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import visitas.VisitasApplication;
import visitas.bootstrap.VisitasLoader;
import visitas.model.Enviado;
import visitas.model.Familia;
import visitas.model.Iglesia;
import visitas.model.Individuo;
import visitas.model.Visita;
import visitas.repositories.IglesiaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VisitasApplication.class)
@WebAppConfiguration
public class VisitasTests {

	@Autowired
	private IglesiaRepository iglesiaRepository;

	private Logger log = Logger.getLogger(VisitasLoader.class);

	public void setIglesiaRepository(IglesiaRepository iglesiaRepository) {
		this.iglesiaRepository = iglesiaRepository;
	}

	@Test
	@Transactional
	public void testRetrieveTree() {
		for (Iglesia i : iglesiaRepository.findAll()) {
			assertNotNull(i);

			log.info("Iglesia " + i.getId() + "-" + i.getIglesia());
			Iterator<Familia> sf = i.getFamilias().iterator();

			while (sf.hasNext()) {
				Familia f = sf.next();
				log.info("Familia " + f.getId() + "-" + f.getFamilia());
				for (Individuo j : f.getIndividuos()) {
					log.info("   " + j.getApellido() + ", " + j.getNombre() + " DNI: " + j.getDocumento());
					if (j.getSiervo() != null) {
						log.info("    Siervo: " + j.getSiervo().getMinisterio().getMinisterio());
					}
				}
				for (Visita v: f.getVisitas()) {
					log.info(v.getFecha()+":"+" Enviado "+v.getaCargo().getSiervo().getMinisterio().getMinisterio()+" "+v.getaCargo().getSiervo().getIndividuo().getApellido());
					for(Enviado e:v.getColaboradores()) {
						log.info("  "+e.getSiervo().getMinisterio().getMinisterio()+" "+e.getSiervo().getIndividuo().getApellido());
					}
				}
			}

			
		}
	}

}
