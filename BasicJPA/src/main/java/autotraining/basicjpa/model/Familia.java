package autotraining.basicjpa.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.OneToMany;


@Entity
public class Familia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Version
	private Integer version;
	
	private String familia;
	
	@OneToMany
	private Set<Individuo> individuos;
	
	public void setFamilia(String familia) {
		this.familia=familia;
	}
	
	public String getFamilia() {
		return familia;
	}
	

	public Set<Individuo> getIndividuos() {
		return individuos;
	}
	
}
