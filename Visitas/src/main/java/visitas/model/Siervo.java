package visitas.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;



@Entity
public class Siervo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Version
	private Integer version;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "INDIVIDUO_ID")
	private Individuo individuo;

	@ManyToOne
	@JoinColumn(name="MINISTERIO_ID")
	private Ministerio ministerio;

	@ManyToOne
	private Iglesia iglesia;

	@OneToMany(mappedBy = "siervo", cascade = CascadeType.ALL)
	private Set<Enviado> envios = new HashSet<Enviado>();

	public Siervo() {
	}

	public Individuo getIndividuo() {
		return individuo;
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

	public void setIndividuo(Individuo individuo) {
		this.individuo = individuo;
	}

	public Ministerio getMinisterio() {
		return ministerio;
	}

	public void setMinisterio(Ministerio ministerio) {
		this.ministerio = ministerio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((individuo == null) ? 0 : individuo.hashCode());
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
		Siervo other = (Siervo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (individuo == null) {
			if (other.individuo != null)
				return false;
		} else if (!individuo.equals(other.individuo))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	public Iglesia getIglesia() {
		return iglesia;
	}

	public void setIglesia(Iglesia iglesia) {
		this.iglesia = iglesia;
	}

	public Set<Enviado> getEnvios() {
		return envios;
	}

	public void setEnvios(Set<Enviado> envios) {
		this.envios = envios;
	}

}
