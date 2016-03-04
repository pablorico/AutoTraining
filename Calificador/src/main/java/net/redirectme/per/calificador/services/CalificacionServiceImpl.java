package net.redirectme.per.calificador.services;

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
	public Iterable<Calificacion> listCalificacionesByRango(Date desde, Date hasta) {
		return calificacionRepository.findByFechaBetween(desde, hasta);
	}

	@Override
	public Calificacion addExcelente() {
		Calificacion c = calificacionRepository.findByFecha(new Date(System.currentTimeMillis()));

		if (c == null)
			c = new Calificacion();

		c.setExcelente(new Integer(c.getExcelente().intValue() + 1));
		return calificacionRepository.save(c);
	}

	@Override
	public Calificacion addBueno() {
		Calificacion c = calificacionRepository.findByFecha(new Date(System.currentTimeMillis()));

		if (c == null)
			c = new Calificacion();

		c.setBueno(new Integer(c.getBueno().intValue() + 1));
		return calificacionRepository.save(c);
	}

	@Override
	public Calificacion addRegular() {
		Calificacion c = calificacionRepository.findByFecha(new Date(System.currentTimeMillis()));

		if (c == null)
			c = new Calificacion();

		c.setRegular(new Integer(c.getRegular().intValue() + 1));
		return calificacionRepository.save(c);
	}

	@Override
	public Calificacion addMalo() {
		Calificacion c = calificacionRepository.findByFecha(new Date(System.currentTimeMillis()));

		if (c == null)
			c = new Calificacion();

		c.setMalo(new Integer(c.getMalo().intValue() + 1));
		return calificacionRepository.save(c);
	}

}