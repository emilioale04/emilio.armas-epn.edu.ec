package Business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Business.Entities.Usuario;
import Data.UsuarioDAC;
import Framework.AppException;

public class UsuarioBL {
    
    public String eaGetClavebyUsuario(String eaUsuario) throws AppException{
        try {
            UsuarioDAC eaUsuarioDAC = new UsuarioDAC();
            ResultSet eaRs = eaUsuarioDAC.eaGetClaveByUsuario(eaUsuario);
            String eaClave = new String(eaRs.getString("EA_CLAVE"));
            return eaClave;
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass());
        }
    }

    public List<Usuario> eaGetAllUsuario() throws AppException{
        try {
            UsuarioDAC eaUsuarioDAC = new UsuarioDAC();
            ResultSet eaRs = eaUsuarioDAC.eaGetAllUsuario();
            List<Usuario> eaLstUsuario = new ArrayList<Usuario>();

            while(eaRs.next()) {
                Usuario eaU = new Usuario(eaRs.getString("EA_USUARIO"), eaRs.getString("EA_CLAVE"));
                eaLstUsuario.add(eaU);
            }
            return eaLstUsuario;
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass());
        }
    } 
}
