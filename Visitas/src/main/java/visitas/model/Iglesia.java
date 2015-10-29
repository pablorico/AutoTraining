package visitas.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import javax.persistence.OneToMany;


@Entity
public class Iglesia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Version
	private Integer version;
	
	private String iglesia;
	
	@OneToMany(mappedBy="iglesia",cascade=CascadeType.ALL)
	private Set<Familia> familias = new HashSet<Familia>();
	
	@OneToMany(mappedBy="iglesia",cascade=CascadeType.ALL)
	private Set<Siervo> siervos = new HashSet<Siervo>();
	
	public Iglesia() {}
	
	public void setIglesia(String iglesia) {
		this.iglesia=iglesia;
	}
	
	public String getIglesia() {
		return iglesia;
	}
	

	public Set<Familia> getFamilias() {
		return familias;
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

	public void setFamilias(Set<Familia> familias) {
		this.familias = familias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((iglesia == null) ? 0 : iglesia.hashCode());
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
		Iglesia other = (Iglesia) obj;
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
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	public Set<Siervo> getSiervos() {
		return siervos;
	}

	public void setSiervos(Set<Siervo> siervos) {
		this.siervos = siervos;
	}
	
	
}
