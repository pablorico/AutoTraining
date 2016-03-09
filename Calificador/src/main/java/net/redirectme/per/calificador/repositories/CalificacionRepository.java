package net.redirectme.per.calificador.repositories;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import net.redirectme.per.calificador.entities.Calificacion;


public interface CalificacionRepository extends CrudRepository<Calificacion, Integer>{
	Calificacion findByFechaAndTurno(Date d, String t);
	Iterable<Calificacion> findByFechaBetween(Date desde, Date hasta);
	//Iterable<Calificacion> findAll();
}
