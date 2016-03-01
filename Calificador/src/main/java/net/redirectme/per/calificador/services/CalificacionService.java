package net.redirectme.per.calificador.services;

import java.sql.Date;

import net.redirectme.per.calificador.entities.Calificacion;

public interface CalificacionService {
    
	Iterable<Calificacion> listAllCalificaciones();

	Iterable<Calificacion> listCalificacionesByRango(Date desde, Date hasta);
	
    Calificacion addExcelente();
    Calificacion addBueno();
    Calificacion addRegular();
    Calificacion addMalo();

}