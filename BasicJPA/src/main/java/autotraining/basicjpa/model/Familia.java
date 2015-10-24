package autotraining.basicjpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import javax.persistence.OneToMany;


@Entity
public class Familia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id=null;

	@Version
	private Integer version;
	
	private String familia;
	
	@OneToMany(mappedBy="familia",cascade=CascadeType.ALL)
	private List<Individuo> individuos = new ArrayList<Individuo>();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((familia == null) ? 0 : familia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((individuos == null) ? 0 : individuos.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		Familia other = (Familia) obj;
		if (familia == null) {
			if (other.familia != null)
				return false;
		} else if (!familia.equals(other.familia))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (individuos == null) {
			if (other.individuos != null)
				return false;
		} else if (!individuos.equals(other.individuos))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	public void setFamilia(String familia) {
		this.familia=familia;
	}
	
	public String getFamilia() {
		return familia;
	}
	

	public List<Individuo> getIndividuos() {
		return individuos;
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

	public void setIndividuos(List<Individuo> individuos) {
		this.individuos = individuos;
	}
	
}
