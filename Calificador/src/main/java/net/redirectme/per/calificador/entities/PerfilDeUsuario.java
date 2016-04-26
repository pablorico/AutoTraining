package net.redirectme.per.calificador.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

 
@Entity
public class PerfilDeUsuario {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id; 
 
    @Column(length=15, unique=true, nullable=false)
    private String tipo = TipoDePerfilDeUsuario.OPERADOR.getTipoDePerfilDeUsuario();
    
    private int usuarioId;
     
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getTipo() {
        return tipo;
    }
 
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
 
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof PerfilDeUsuario))
            return false;
        PerfilDeUsuario other = (PerfilDeUsuario) obj;
        if (id != other.id)
            return false;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "UserProfile [id=" + id + ",  tipo=" + tipo  + "]";
    }

    public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
     
 
}