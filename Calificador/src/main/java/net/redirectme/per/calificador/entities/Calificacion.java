package net.redirectme.per.calificador.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private Timestamp fecha;
    private int excelente;
    private int bueno;
    private int regular;
    private int malo;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
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