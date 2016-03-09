package net.redirectme.per.calificador;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Turno {
	public static String getTurno(long t) {
		Integer hora = new Integer(new SimpleDateFormat("HH").format(new Date(t)));
		return (hora < 17 ? "Dia" : "Noche");
	}
}
