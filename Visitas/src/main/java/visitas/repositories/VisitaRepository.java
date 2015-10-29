package visitas.repositories;
import org.springframework.data.repository.CrudRepository;

import visitas.model.Visita;

public interface VisitaRepository extends CrudRepository<Visita, Integer>{
}
