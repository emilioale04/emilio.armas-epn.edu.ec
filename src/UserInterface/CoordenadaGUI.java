package UserInterface;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.plaf.metal.MetalBorders.ScrollPaneBorder;
import javax.swing.table.DefaultTableModel;

import Business.CoordenadaBL;
import Business.Entities.Coordenada;
import Framework.AppConfiguration;
import Framework.AppException;

import java.awt.event.*;

public class CoordenadaGUI extends JFrame implements ActionListener{
    
    JPanel eaPanel = new JPanel();
    static JProgressBar eaProgressBar = new JProgressBar();
    static JTable eaTablaCoordenadas = new JTable();
    JLabel eaLabelLeyendo = new JLabel();

    DefaultTableModel eaModeloTabla = new DefaultTableModel();
    

    public CoordenadaGUI() {
        setTitle("COORDENADAS");
        setSize(500,400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
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
        
        add(eaPanel);
        
        eaPanel.add(eaProgressBar);
        eaPanel.add(eaTablaCoordenadas);

        try {
            eaCargarCoordenadas();
        } catch (AppException e) {
            e.printStackTrace();
        }
    }

    private static void eaProgressBar() {
        eaProgressBar.setValue(0);
        try {
            for (int i = 1; i <= 100; i++) {
                eaProgressBar.setValue(i);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eaLlenarTabla() {
        eaTablaCoordenadas = new JTable(null, new String[]{"Capacidad Belica, Geolocalizacion, Tipo de Arsenal"});
    }

    private void eaCargarCoordenadas() throws AppException {
        CoordenadaBL eaCoordenadaBL = new CoordenadaBL();

        for (Coordenada eaC : eaCoordenadaBL.eaGetAllCoordenada()) {
            eaProgressBar();
            Object[] eaFila = new Object[3];
            eaFila[0] = eaC.eaGetCapacidadBelica();
            eaFila[1] = eaC.eaGetGeolocalizacion();
            eaFila[2] = eaC.eaGetDetalleArsenal();
            eaModeloTabla.addRow(eaFila);
        }
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public static void main(String[] args) {
        AppConfiguration.eaLoad("src/config.properties");
        new CoordenadaGUI();
    }
    
}
