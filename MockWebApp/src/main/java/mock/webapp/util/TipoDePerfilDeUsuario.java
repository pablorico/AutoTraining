package mock.webapp.util;

public enum TipoDePerfilDeUsuario {
    USUARIO("USUARIO"),
    SUPERVISOR("SUPERVISOR"),
    ADMIN("ADMIN");
     
    String tipoDePerfilDeUsuario;
     
    private TipoDePerfilDeUsuario(String tipoDePerfilDeUsuario){
        this.tipoDePerfilDeUsuario = tipoDePerfilDeUsuario;
    }
     
    public String getTipoDePerfilDeUsuario(){
        return tipoDePerfilDeUsuario;
    }
     
}