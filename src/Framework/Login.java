package Framework;

import Business.UsuarioBL;
import Business.Entities.Usuario;
import Utility.MD5;

public class Login {
    UsuarioBL eaUsuarioBL = new UsuarioBL();

    public boolean eaValidarCredenciales(String eaUsuario, String eaClave) throws AppException{
        boolean eaIngresoValido = false;
        
        for (Usuario eaU : eaUsuarioBL.eaGetAllUsuario()) {
            if(eaU.eaGetNombreUsuario().equals(eaUsuario) &&
                eaU.eaGetClave().equals(MD5.eaGetMD5(eaClave)))
                eaIngresoValido = true;
        }
        return eaIngresoValido;
    }
}
