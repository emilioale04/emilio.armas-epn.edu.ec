package Data;

import java.sql.ResultSet;
import java.sql.SQLException;

import Framework.AppConfiguration;
import Framework.AppException;

public class CoordenadaDAC extends SQLiteDataHelper {

    public CoordenadaDAC() {
        super(AppConfiguration.eaGetDBPathConnection());
    }

    public ResultSet eaGetAllCoordenada() throws AppException{
        try {
            String eaSql = "SELECT * FROM EA_COORDENADA";
            return getResultSet(eaSql);
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "eaGetAllCoordenada()");
        }
    }

    public ResultSet eaGetAllCapacidadBelica() throws AppException{
        try {
            String eaSql = "SELECT EA_CAPACIDAD_BELICA FROM EA_COORDENADA";
            return getResultSet(eaSql);
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "eaGetAllCapacidadBelica()");
        }
    }
}
