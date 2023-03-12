package Business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Business.Entities.Coordenada;
import Data.CoordenadaDAC;
import Framework.AppException;

public class CoordenadaBL {

    public List<Coordenada> eaGetAllCoordenada() throws AppException{
        try {
            CoordenadaDAC eaCoordenadaDAC = new CoordenadaDAC();  
            List<Coordenada> eaLstCoordenada = new ArrayList<Coordenada>();
            ResultSet eaRs = eaCoordenadaDAC.eaGetAllCoordenada();
            while(eaRs.next())    {
                Coordenada eaC = new Coordenada(eaRs.getInt("EA_CAPACIDAD_BELICA"), eaRs.getString("EA_GEOLOCALIZACION"), eaRs.getString("EA_TIPO_ARSENAL"), eaRs.getString("EA_FECHA_INGRESO"));
                eaLstCoordenada.add(eaC);
            }
            return eaLstCoordenada;
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass());
        }
    }

    public int[] eaGetAllCapacidadBelica() throws AppException{
        
        int[] eaLstCapacidadBelica = new int[10];
        int i = 0;

        try {
            CoordenadaDAC eaCoordenadaDAC = new CoordenadaDAC();  
            ResultSet eaRs = eaCoordenadaDAC.eaGetAllCapacidadBelica();
            while(eaRs.next()) {
                eaLstCapacidadBelica[i++] = eaRs.getInt("EA_CAPACIDAD_BELICA");
            }
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass());
        }

        return eaLstCapacidadBelica;
    }
}
