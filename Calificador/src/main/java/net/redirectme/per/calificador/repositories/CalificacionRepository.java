package net.redirectme.per.calificador.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import net.redirectme.per.calificador.entities.Calificacion;

public interface CalificacionRepository extends CrudRepository<Calificacion, Integer>{
	List<Calificacion> findByFechaBetween(Date desde, Date hasta);
}
