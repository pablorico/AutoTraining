package net.redirectme.per.calificador.entities;

import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

 
@Entity
public class Usuario {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
 
    @Version
    private Integer version;
    
    @Column(unique=true, nullable=false)
    private String usuarioId;
     
    @Column(nullable=false)
    private String password;
         
    @Column(nullable=false)
    private String nombre;
 
    @Column(nullable=false)
    private String apellido;
 
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USUARIO_PERFIL_DE_USUARIO", 
             joinColumns = { @JoinColumn(name = "USUARIO_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "PERFIL_DE_USUARIO_ID") })
    private Set<PerfilDeUsuario> perfilesDeUsuario = new HashSet<PerfilDeUsuario>();
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getUsuarioId() {
        return usuarioId;
    }
 
    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getApellido() {
        return apellido;
    }
 
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
 
    public Set<PerfilDeUsuario> getPerfilesDeUsuario() {
        return perfilesDeUsuario;
    }
 
    public void setPerfilesDeUsuario(Set<PerfilDeUsuario> perfilesDeUsuario) {
        this.perfilesDeUsuario = perfilesDeUsuario;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((usuarioId == null) ? 0 : usuarioId.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Usuario))
            return false;
        Usuario other = (Usuario) obj;
        if (id != other.id)
            return false;
        if (usuarioId == null) {
            if (other.usuarioId != null)
                return false;
        } else if (!usuarioId.equals(other.usuarioId))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", usuarioId=" + usuarioId + ", password=" + password
                + ", nombre=" + nombre + ", apellido=" + apellido
                + ", perfilesDeUsuario=" + perfilesDeUsuario +"]";
    }

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
    
}

