package Business.Entities;

import Business.CoordenadaBL;
import Framework.AppConfiguration;

public class Coordenada implements ICoordenada {
    private int eaCapacidadBelica;
    private String eaGeolocalizacion;
    private String eaDetalleArsenal;
    private String eaFechaIngreso;

    private static final int EA_TK_ERROR = -1;
    private static final int EA_TK_FIN = -2;

    private static final char[] EA_ALFA = {'a', 'b', 'c', 'd', 't'};

    private Coordenada eaCoordenadaMayor;
    private Coordenada eaCoordenadaMenor;

    public Coordenada(int eaCapacidadBelica, String eaGeolocalizacion, String eaDetalleArsenal, String eaFechaIngreso) {
        this.eaCapacidadBelica = eaCapacidadBelica;
        this.eaGeolocalizacion = eaGeolocalizacion;
        this.eaDetalleArsenal = eaDetalleArsenal;
        this.eaFechaIngreso = eaFechaIngreso;
    }

    public void eaSetCapacidadBelica(int eaCapacidadBelica) {
        this.eaCapacidadBelica = eaCapacidadBelica;
    }

    public void eaSetGeolocalizacion(String eaGeolocalizacion) {
        this.eaGeolocalizacion = eaGeolocalizacion;
    }

    public void eaSetDetalleArsenal(String eaDetalleArsenal) {
        this.eaDetalleArsenal = eaDetalleArsenal;
    }

    public void eaSetFechaIngreso(String eaFechaIngreso) {
        this.eaFechaIngreso = eaFechaIngreso;
    }
    
       
    public Coordenada eaGetCoordenadaMayor() {
        return eaCoordenadaMayor;
    }

    public void eaSetCoordenadaMayor(Coordenada eaCoordenadaMayor) {
        this.eaCoordenadaMayor = eaCoordenadaMayor;
    }

    public void eaSetCoordenadaMenor(Coordenada eaCoordenadaMenor) {
        this.eaCoordenadaMenor = eaCoordenadaMenor;
    }


    public Coordenada eaGetCoordenadaMenor() {
        return eaCoordenadaMenor;
    }

    public int eaGetCapacidadBelica() {
        return eaCapacidadBelica;
    }

    public String eaGetGeolocalizacion() {
        return eaGeolocalizacion;
    }

    public String eaGetDetalleArsenal() {
        return eaDetalleArsenal;
    }

    public String eaGetFechaIngreso() {
        return eaFechaIngreso;
    }

    @Override
    public boolean eaValidarCoordenada() {            
        int eaQ = 0;
        int eaL = 0;
        int[][] eaMt = eaGetMatrizTransicion();

        for (char eaC : (eaDetalleArsenal + " ").toCharArray()) {
            eaL = eaGetIndexAlfabeto(eaC);
            eaQ = eaMt[eaQ][eaL];

            if (eaQ == EA_TK_ERROR) break;
        }

        return eaQ == EA_TK_FIN;
    } 

    private static int[][] eaGetMatrizTransicion() {
        int[][] eaMt = new int[5][6];
        eaMt [0][0] = 1;                eaMt [0][1] = EA_TK_ERROR;          eaMt [0][2] = EA_TK_ERROR;          
        eaMt [1][0] = EA_TK_ERROR;      eaMt [1][1] = 1;                    eaMt [1][2] = 2;                
        eaMt [2][0] = EA_TK_ERROR;      eaMt [2][1] = EA_TK_ERROR;          eaMt [2][2] = 2;                
        eaMt [3][0] = EA_TK_ERROR;      eaMt [3][1] = EA_TK_ERROR;          eaMt [3][2] = EA_TK_ERROR;                
        eaMt [4][0] = EA_TK_ERROR;      eaMt [4][1] = EA_TK_ERROR;          eaMt [4][2] = EA_TK_ERROR;
        
        eaMt [0][3] = EA_TK_ERROR;      eaMt [0][4] = EA_TK_ERROR;          eaMt [0][5] = EA_TK_ERROR;
        eaMt [1][3] = EA_TK_ERROR;      eaMt [1][4] = EA_TK_ERROR;          eaMt [1][5] = EA_TK_ERROR;    
        eaMt [2][3] = 3;                eaMt [2][4] = EA_TK_ERROR;          eaMt [2][5] = EA_TK_ERROR;    
        eaMt [3][3] = EA_TK_ERROR;      eaMt [3][4] = 4;                    eaMt [3][5] = EA_TK_ERROR;    
        eaMt [4][3] = EA_TK_ERROR;      eaMt [4][4] = EA_TK_ERROR;          eaMt [4][5] = EA_TK_FIN;

        return eaMt;
    }

    private static int eaGetIndexAlfabeto(char eaCaracter) {
        for (int i = 0; i < EA_ALFA.length; i++)
            if(eaCaracter == EA_ALFA[i])
                return i;
        return 5;
    }

    public static void main(String[] args) throws Exception {
        AppConfiguration.eaLoad("src/config.properties");
        CoordenadaBL c = new CoordenadaBL();

        for (Coordenada coo : c.eaGetAllCoordenada()) {
            System.out.println(coo.eaValidarCoordenada());
        }
    }
}
