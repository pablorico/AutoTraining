package net.redirectme.per.calificador.services;

import java.sql.Date;

import net.redirectme.per.calificador.entities.Calificacion;

public interface CalificacionService {
    
	Iterable<Calificacion> listCalificacionesByRango(Date desde, Date hasta);
	Iterable<Calificacion> listCalificacionesAll();
	
    Calificacion addExcelente();
    Calificacion addBueno();
    Calificacion addRegular();
    Calificacion addMalo();

}