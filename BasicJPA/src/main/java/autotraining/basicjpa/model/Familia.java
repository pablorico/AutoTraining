package autotraining.basicjpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import javax.persistence.OneToMany;


@Entity
public class Familia {
	@Id
	@Column(name="FAMILIA_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer familiaId=null;

	@Version
	private Integer version;
	
	private String familia;
	
	@OneToMany(mappedBy="familia", cascade=CascadeType.ALL)
	private List<Individuo> individuos = new ArrayList<Individuo>();
	

	public void setFamilia(String familia) {
		this.familia=familia;
	}
	
	public String getFamilia() {
		return familia;
	}
	

	public List<Individuo> getIndividuos() {
		return individuos;
	}

	public Integer getFamiliaId() {
		return familiaId;
	}

	public void setFamiliaId(Integer id) {
		this.familiaId = id;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((familia == null) ? 0 : familia.hashCode());
		result = prime * result + ((familiaId == null) ? 0 : familiaId.hashCode());
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
		if (familiaId == null) {
			if (other.familiaId != null)
				return false;
		} else if (!familiaId.equals(other.familiaId))
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

}
