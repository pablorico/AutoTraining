package net.redirectme.per.calificador;

import java.sql.Date;

public class CalificacionPorFecha {
    private Date fecha;
    private int excelente;
    private int bueno;
    private int regular;
    private int malo;
    
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getExcelente() {
		return excelente;
	}
	public void setExcelente(int excelente) {
		this.excelente = excelente;
	}
	public int getBueno() {
		return bueno;
	}
	public void setBueno(int bueno) {
		this.bueno = bueno;
	}
	public int getRegular() {
		return regular;
	}
	public void setRegular(int regular) {
		this.regular = regular;
	}
	public int getMalo() {
		return malo;
	}
	
	public void setMalo(int malo) {
		this.malo = malo;
	}
}