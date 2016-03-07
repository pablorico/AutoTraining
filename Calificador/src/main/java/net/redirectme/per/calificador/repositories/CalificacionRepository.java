package net.redirectme.per.calificador.repositories;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import net.redirectme.per.calificador.entities.Calificacion;


public interface CalificacionRepository extends CrudRepository<Calificacion, Integer>{
	Calificacion findByFecha(Date d);
	Iterable<Calificacion> findByFechaBetween(Date desde, Date hasta);
	//Iterable<Calificacion> findAll();
}
