package UserInterface;

import javax.swing.*;

import Business.CoordenadaBL;
import Framework.APP;
import Framework.AppException;
import Utility.Utility;

import java.awt.event.*;

public class InformacionGUI extends JFrame implements ActionListener {

    JPanel eaPanel = new JPanel();

    JLabel eaEtqCedula = new JLabel();
    JLabel eaEtqNombre = new JLabel();
    JLabel eaEtqCapacidadBelica = new JLabel();
    JLabel eaEtqCoordenadaTotal = new JLabel();
    JLabel eaEtqCoordenadaSec = new JLabel();

    CoordenadaBL eaCoordenadaBL = new CoordenadaBL();

    private int eaCapacidadBelica;
    private String eaCoordenasSec;

    int[] eaLstOrdenada;


    public InformacionGUI() {

        setTitle("INFORMACION");
        setSize(400,200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);

        eaPanel.setLayout(null);

        
        try {
            eaLstOrdenada = Utility.eaGetLstIntOrdenada(eaCoordenadaBL.eaGetAllCapacidadBelica());
        } catch (AppException e) {
            e.printStackTrace();
        }
        
        eaCapacidadBelica = Utility.eaGetSumaLstInt(eaLstOrdenada);
        eaCoordenasSec = Utility.eaGetLstString(eaLstOrdenada);
        
        eaEtqNombre.setText("Developer-Nombre: " + APP.EA_GLOBAL.EA_NOMBRE_COMPLETO);
        eaEtqCedula.setText("Developer-Cedula: "+ APP.EA_GLOBAL.EA_CEDULA);
        eaEtqCapacidadBelica.setText("Capacidad-Belica: " + Integer.toString(eaCapacidadBelica));
        eaEtqCoordenadaTotal.setText("Coordenada-Total: " + Integer.toString(eaLstOrdenada.length));
        eaEtqCoordenadaSec.setText("Coordenadas-SecCarga: " + eaCoordenasSec);

        eaEtqNombre.setBounds(20,20,300,20);
        eaEtqCedula.setBounds(20,40,200,20);
        eaEtqCapacidadBelica.setBounds(20,60,300,20);
        eaEtqCoordenadaTotal.setBounds(20,80,300,20);
        eaEtqCoordenadaSec.setBounds(20,100,300,20);

        add(eaPanel);

        eaPanel.add(eaEtqNombre);
        eaPanel.add(eaEtqCedula);
        eaPanel.add(eaEtqCapacidadBelica);
        eaPanel.add(eaEtqCoordenadaTotal);
        eaPanel.add(eaEtqCoordenadaSec);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
