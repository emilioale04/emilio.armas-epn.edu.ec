package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Framework.AppException;

public abstract class SQLiteDataHelper {
    private static String eaDBPathConnection = null;
    private static Connection eaConn = null;

    public SQLiteDataHelper(String  eaDbPathConnection){
        if (!eaDbPathConnection.isEmpty())
            SQLiteDataHelper.eaDBPathConnection = eaDbPathConnection;
    }

    /**
     * getDBConnection, obtiene el cadena de coneccion a la base de datos
     * @return
     */
    protected String eaGetDBConnection() {
        return eaDBPathConnection;
    }

    /**
     * <b>connSQLITE</b>, permite crear una sola instancia-Singeton para la conexion a la base de datos
     * @return retorna coneccion a la base de datos definida en el contructor
     * @throws SQLException
     */
    protected static Connection eaGetConnection() throws SQLException{
        if(eaConn == null)
            eaConn = DriverManager.getConnection(eaDBPathConnection);
        return eaConn;
    }

    protected static ResultSet getResultSet(String sql) throws SQLException, AppException     
    {
        Connection eaConn = null;
        Statement  eaStmt = null;
        ResultSet  eaRs   = null;
        try {
            eaConn = eaGetConnection();
            eaStmt = eaConn.createStatement();
            eaRs   = eaStmt.executeQuery(sql); 
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new AppException("Failed to connect to database");
        }
        return eaRs;
    }
}

     