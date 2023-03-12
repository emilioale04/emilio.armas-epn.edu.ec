package UserInterface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;

import Business.CoordenadaBL;
import Business.Entities.Coordenada;
import Framework.AppException;
import UserInterface.CustomUI.CustomTableModel;

import java.awt.event.*;

public class CoordenadaGUI extends JFrame implements ActionListener{
    
    static JPanel eaPanel = new JPanel();
    static JProgressBar eaProgressBar = new JProgressBar();
    static JTable eaTablaCoordenadas = new JTable();
    JLabel eaLabelLeyendo = new JLabel();
    JButton eaBtnSiguiente = new JButton();
    JButton eaBtnLlenar = new JButton();

    CustomTableModel eaModeloTabla = new CustomTableModel();

    InformacionGUI eaInformacionGUI = new InformacionGUI();
    

    public CoordenadaGUI() {
        eaInicializar();
    }

    private void eaInicializar() {
        setTitle("COORDENADAS");
        setSize(470,450);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        
        eaPanel.setLayout(null);
        
        eaLabelLeyendo.setText("[+] Leyendo Coordenadas...");
        eaLabelLeyendo.setBounds(20, 20, 200, 25);
        
        eaPanel.add(eaLabelLeyendo);
        
        eaProgressBar.setValue(0);
        eaProgressBar.setStringPainted(true);
        eaProgressBar.setBounds(20, 50, 200, 25);

        
        eaTablaCoordenadas.setBounds(20, 100, 400, 200);
        eaTablaCoordenadas.setModel(eaModeloTabla);
        
        eaModeloTabla.addColumn("Capacidad Belica");
        eaModeloTabla.addColumn("Geolocalizacion");
        eaModeloTabla.addColumn("Tipo Arsenal");

        eaBtnSiguiente.setText("Siguiente");
        eaBtnSiguiente.setBounds(170, 320, 100, 25);
        
        add(eaPanel);
                
        eaPanel.add(eaProgressBar);
        eaPanel.add(eaTablaCoordenadas);
        eaPanel.add(eaBtnSiguiente);
    }

    public void eaLlenarTabla() {
        try {
            CoordenadaBL eaCoordenadaBL = new CoordenadaBL();

            for (Coordenada eaC : eaCoordenadaBL.eaGetAllCoordenada()) {
                eaProgressBar();
                Object[] eaFila = new Object[3];
                eaFila[0] = eaC.eaGetCapacidadBelica();
                eaFila[1] = eaC.eaGetGeolocalizacion();
                eaFila[2] = eaC.eaGetDetalleArsenal();
                eaModeloTabla.addRow(eaFila);
            }

        } catch (AppException b) {
            b.printStackTrace();
        }
        eaBtnSiguiente.addActionListener(this);
    }

    public static void eaProgressBar() {
        eaProgressBar.setValue(0);
        try {
            for (int i = 1; i <= 100; i++) {
                eaProgressBar.setValue(i);
                Thread.sleep(5);
                eaPanel.updateUI();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        eaInformacionGUI.setVisible(true);
    }
}
