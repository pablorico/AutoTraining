package visitas.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;



@Entity
public class Enviado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Version
	private Integer version;

	@ManyToOne
	private Visita visita;

	@ManyToOne
	private Siervo siervo;

	public Enviado() {
	}

	public Siervo getSiervo() {
		return siervo;
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

	public void setSiervo(Siervo siervo) {
		this.siervo = siervo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((siervo == null) ? 0 : siervo.hashCode());
		result = prime * result + ((visita == null) ? 0 : visita.hashCode());
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
		Enviado other = (Enviado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (siervo == null) {
			if (other.siervo != null)
				return false;
		} else if (!siervo.equals(other.siervo))
			return false;
		if (visita == null) {
			if (other.visita != null)
				return false;
		} else if (!visita.equals(other.visita))
			return false;
		return true;
	}

	public Visita getVisita() {
		return visita;
	}

	public void setVisita(Visita visita) {
		this.visita = visita;
	}


}
