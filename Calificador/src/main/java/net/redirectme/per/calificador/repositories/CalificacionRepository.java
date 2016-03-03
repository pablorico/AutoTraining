package net.redirectme.per.calificador.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import net.redirectme.per.calificador.CalificacionPorFecha;
import net.redirectme.per.calificador.entities.Calificacion;


public interface CalificacionRepository extends CrudRepository<Calificacion, Integer>{
	
	@Query(value="select c.sum(excelente) as excelente, c.sum(bueno) as bueno, c.sum(regular) as regular, c.sum(malo) as malo from CALIFICACION c where c.fecha between ?1 and ?2",nativeQuery=true)
	List<Calificacion> findByFechaBetween(Date desde, Date hasta);
	
}
