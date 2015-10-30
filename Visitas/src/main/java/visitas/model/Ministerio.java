package visitas.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Ministerio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Version
	private Integer version;
	
	private String ministerio;
	
	public Ministerio() {}
	
	@OneToMany(mappedBy="ministerio",cascade=CascadeType.ALL)
	private Set<Siervo> siervos = new HashSet<Siervo>();
	
	public void setMinisterio(String ministerio) {
		this.ministerio=ministerio;
	}
	
	public String getMinisterio() {
		return ministerio;
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

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ministerio == null) ? 0 : ministerio.hashCode());
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
		Ministerio other = (Ministerio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ministerio == null) {
			if (other.ministerio != null)
				return false;
		} else if (!ministerio.equals(other.ministerio))
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
