package visitas.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Visita {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Version
	private Integer version;

	private Date fecha;

	@ManyToOne
	private Familia familia;

	@OneToOne
	private Enviado aCargo;
	
	@OneToMany(mappedBy = "visita", cascade = CascadeType.ALL)
	private Set<Enviado> colaboradores = new HashSet<Enviado>();
	
	@ManyToOne
	private Iglesia iglesia;

	


	public Visita() {
	}

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

	public Iglesia getIglesia() {
		return iglesia;
	}

	public void setIglesia(Iglesia iglesia) {
		this.iglesia = iglesia;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Enviado getaCargo() {
		return aCargo;
	}

	public void setaCargo(Enviado aCargo) {
		this.aCargo = aCargo;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public Set<Enviado> getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(Set<Enviado> colaboradores) {
		this.colaboradores = colaboradores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((familia == null) ? 0 : familia.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((iglesia == null) ? 0 : iglesia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visita other = (Visita) obj;
		if (familia == null) {
			if (other.familia != null)
				return false;
		} else if (!familia.equals(other.familia))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (iglesia == null) {
			if (other.iglesia != null)
				return false;
		} else if (!iglesia.equals(other.iglesia))
			return false;
		return true;
	}

}
