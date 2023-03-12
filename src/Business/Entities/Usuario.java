package Business.Entities;

public class Usuario {
    private String eaNombreUsuario;
    private String eaClave;

    public Usuario(String eaNombreUsuario, String eaClave) {
        this.eaNombreUsuario = eaNombreUsuario;
        this.eaClave = eaClave;
    }

    public String eaGetNombreUsuario() {
        return eaNombreUsuario;
    }

    public void eaSetNombreUsuario(String eaNombreUsuario) {
        this.eaNombreUsuario = eaNombreUsuario;
    }

    public String eaGetClave() {
        return eaClave;
    }

    public void eaSetClave(String eaClave) {
        this.eaClave = eaClave;
    }

    
    
}
