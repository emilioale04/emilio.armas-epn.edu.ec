package Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfiguration {

    private static Properties eaConfig = null;

    public static boolean eaLoad(String eaPathConfigFile){
        try{
            if (eaConfig == null)   
                eaConfig = new Properties();
            InputStream eaConfigInput = new FileInputStream(eaPathConfigFile);
            eaConfig.load(eaConfigInput);

            System.out.println(">> (ok) AppConfiguration.eaLoad()");
            return true;
        }  
        catch (IOException e) {
            System.out.println(">> (error) AppConfiguration.eaLoad() "+ e.getMessage());
        }
        return false;
    }

    public static String eaGetDBName(){
        if (eaConfig != null)  
            return eaConfig.getProperty(APP.EA_GLOBAL.EA_DB_NAME);  
        else
            System.out.println(">> (issue) AppConfiguration.eaGetDBName(), llamar primero a AppConfiguration.eaLoad() y agregar EA_DB_NAME en CONFIG.PROPERTIES");
        return "";
    }
    public static String eaGetDBPathConnection(){

        if (eaConfig != null && eaConfig.containsKey(APP.EA_GLOBAL.EA_DB_PATH)){
            String eaDbName  = eaGetDBName();
            String eaDbPath  = eaConfig.getProperty(APP.EA_GLOBAL.EA_DB_PATH); 
            eaDbPath =  "jdbc:sqlite:" + eaDbPath.replace('/', '\\') + "\\\\" + eaDbName;
            return eaDbPath;  
        }
        else
            System.out.println(">> (issue) AppConfiguration.eaGetDBPathConnection(), llamar primero a AppConfiguration.eaLoad() y agregar EA_DB_PATH en CONFIG.PROPERTIES");
        return "";
    }
}
