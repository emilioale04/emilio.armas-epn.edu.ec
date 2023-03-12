package UserInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.event.*;

public class CoordenadaGUI extends JFrame implements ActionListener{
    
    JPanel eaPanel = new JPanel();
    JProgressBar eaProgressBar = new JProgressBar();
    

    public CoordenadaGUI() {
        setTitle("COORDENADAS");
        setSize(300,500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
