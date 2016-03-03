package net.redirectme.per.calificador.services;

import net.redirectme.per.calificador.CalificacionPorFecha;
import net.redirectme.per.calificador.entities.Calificacion;
import net.redirectme.per.calificador.repositories.CalificacionRepository;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalificacionServiceImpl implements CalificacionService {
	private CalificacionRepository calificacionRepository;

	@Autowired
	public void setCalificacionRepository(CalificacionRepository calificacionRepository) {
		this.calificacionRepository = calificacionRepository;
	}

	@Override
	public Iterable<Calificacion> listAllCalificaciones() {
		return calificacionRepository.findAll();
	}

	@Override
	public Iterable<Calificacion> listCalificacionesByRango(Date desde, Date hasta) {
		return calificacionRepository.findByFechaBetween(desde, hasta);
	}
	
	@Override
	public Calificacion addExcelente() {
		Calificacion calificacion = new Calificacion();
		calificacion.setExcelente(1);
		return calificacionRepository.save(calificacion);
	}
	
	@Override
	public Calificacion addBueno() {
		Calificacion calificacion = new Calificacion();
		calificacion.setBueno(1);
		return calificacionRepository.save(calificacion);
	}
	
	@Override
	public Calificacion addRegular() {
		Calificacion calificacion = new Calificacion();
		calificacion.setRegular(1);
		return calificacionRepository.save(calificacion);
	}
	
	@Override
	public Calificacion addMalo() {
		Calificacion calificacion = new Calificacion();
		calificacion.setMalo(1);
		return calificacionRepository.save(calificacion);
	}

}