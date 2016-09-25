package mock.webapp.util;

public enum TipoDeRolDeUsuario {
    USUARIO("USUARIO"),
    SUPERVISOR("SUPERVISOR"),
    ADMIN("ADMIN");
     
    String tipoDeRolDeUsuario;
     
    private TipoDeRolDeUsuario(String tipoDeRolDeUsuario){
        this.tipoDeRolDeUsuario = tipoDeRolDeUsuario;
    }
     
    public String getTipoDeRolDeUsuario(){
        return tipoDeRolDeUsuario;
    }
     
}