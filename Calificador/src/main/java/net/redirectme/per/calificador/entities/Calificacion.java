package net.redirectme.per.calificador.entities;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import net.redirectme.per.calificador.Turno;


@Entity
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    @Column(unique=true)
    private Date fecha=new Date(System.currentTimeMillis());

    private String turno=Turno.getTurno(System.currentTimeMillis());
    private Integer excelente=new Integer(0);
    private Integer bueno=new Integer(0);
    private Integer regular=new Integer(0);
    private Integer malo=new Integer(0);
    
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getExcelente() {
		return excelente;
	}
	public void setExcelente(Integer excelente) {
		this.excelente = excelente;
	}
	public Integer getBueno() {
		return bueno;
	}
	public void setBueno(Integer bueno) {
		this.bueno = bueno;
	}
	public Integer getRegular() {
		return regular;
	}
	public void setRegular(Integer regular) {
		this.regular = regular;
	}
	
	public Integer getMalo() {
		return malo;
	}
	
	public void setMalo(Integer malo) {
		this.malo = malo;
	}
	
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	public String getTurno() {
		return turno;
	}
}