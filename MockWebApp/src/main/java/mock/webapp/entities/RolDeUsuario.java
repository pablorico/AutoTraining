package mock.webapp.entities;

import javax.persistence.*;
import mock.webapp.util.*;

 
@Entity
public class RolDeUsuario {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id; 
 
    @Version
    private Integer version;
    
 

	@Column(length=15, nullable=false)
    private String tipo = TipoDeRolDeUsuario.USUARIO.getTipoDeRolDeUsuario();
    
    @ManyToOne
    private Usuario usuario;
     
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    
    public Integer getVersion() {
 		return version;
 	}

 	public void setVersion(Integer version) {
 		this.version = version;
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
        if (!(obj instanceof RolDeUsuario))
            return false;
        RolDeUsuario other = (RolDeUsuario) obj;
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
        return "Rol de Usuario [id=" + id + ",  tipo=" + tipo  + "][UsuarioID="+usuario.getId()+"]";
    }

    public String getRolFormateado() {
        return "["+tipo+"]";
    }

    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
     
 
}