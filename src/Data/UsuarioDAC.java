package Data;

import java.sql.ResultSet;
import java.sql.SQLException;

import Framework.AppConfiguration;
import Framework.AppException;

public class UsuarioDAC extends SQLiteDataHelper{

    public UsuarioDAC() {
        super(AppConfiguration.eaGetDBPathConnection());
    }

    public ResultSet eaGetAllUsuario() throws AppException{
        try {
            String eaSql = "SELECT * FROM EA_USUARIO";
            return getResultSet(eaSql);
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "eaGetAllUsuario()");
        }
    }

    public ResultSet eaGetClaveByUsuario(String eaUsuario) throws AppException{
        try {
            String eaSql = "SELECT EA_CLAVE FROM EA_USUARIO WHERE EA_USUARIO = '" + eaUsuario + "'";
            return getResultSet(eaSql);
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "eaGetClaveByUsuario()");
        }
    }
}
