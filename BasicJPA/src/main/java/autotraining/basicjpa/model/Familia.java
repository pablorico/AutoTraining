package autotraining.basicjpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Familia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Version
	private Integer version;
	
	private String familia;
	
	public void setFamilia(String familia) {
		this.familia=familia;
	}
	
	public String getFamilia() {
		return familia;
	}
}
