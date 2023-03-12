package Business.Entities;

public class Coordenada implements ICoordenada {
    private int eaCapacidadBelica;
    private String eaGeolocalizacion;
    private String eaDetalleArsenal;
    private String eaFechaIngreso;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eaValidarCoordenada'");
    } 
}
