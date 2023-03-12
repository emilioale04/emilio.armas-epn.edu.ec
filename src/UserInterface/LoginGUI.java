package UserInterface;

import javax.swing.*;

import Business.UsuarioBL;
import Framework.AppException;
import Framework.Login;

import java.awt.event.*;

public class LoginGUI extends JFrame implements ActionListener {

    JPanel eaPanel = new JPanel();
    JLabel eaLabelUsuario = new JLabel();
    JTextField eaFieldUsuario = new JTextField();
    JLabel eaLabelClave = new JLabel();
    JPasswordField eaFieldClave = new JPasswordField();
    JButton eaBtnLogin = new JButton();
    UsuarioBL eaUsuarioBL = new UsuarioBL();
    Login eaLogin = new Login();

    CoordenadaGUI eaCoordenadaGUI = new CoordenadaGUI();

    private String eaUsuario;
    private String eaClave;

    private int eaIntentos;

    private boolean eaLogueoValido = false;

    public LoginGUI() {
        eaUsuario = "";
        eaClave = "";
        eaIntentos = 3;
        setTitle("LOGIN");
        setSize(300,200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        eaPanel.setLayout(null);

        eaLabelUsuario.setText("Usuario");
        eaLabelUsuario.setBounds(20, 20, 80, 25);
        
        eaFieldUsuario.setBounds(90, 20, 170, 25);
        
        eaLabelClave.setText("Clave");
        eaLabelClave.setBounds(20, 60, 80, 25);
        
        eaFieldClave.setBounds(90, 60, 170, 25);

        eaBtnLogin.setText("Login");
        eaBtnLogin.setBounds(110, 110, 70, 25);

        add(eaPanel);
        
        eaPanel.add(eaLabelUsuario);
        eaPanel.add(eaFieldUsuario);
        eaPanel.add(eaLabelClave);
        eaPanel.add(eaFieldClave);
        eaPanel.add(eaBtnLogin);

        eaBtnLogin.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        eaUsuario = eaFieldUsuario.getText();
        eaClave = String.valueOf(eaFieldClave.getPassword());
        try {
            eaLogueoValido = eaLogin.eaValidarCredenciales(eaUsuario, eaClave); 
        } catch (AppException e1) {
            e1.printStackTrace();
        }
        
        if(eaLogueoValido) {
            JOptionPane.showMessageDialog(null,"Ingreso Valido...!");
            this.dispose();
            eaCoordenadaGUI.setVisible(true);
            eaCoordenadaGUI.eaLlenarTabla();
        } else {
            eaIntentos--;
            JOptionPane.showMessageDialog(null,"Usuario o clave incorrectos\n" + "Intentos restantes: " + eaIntentos,null,JOptionPane.ERROR_MESSAGE);
        }

        if(eaIntentos == 0) System.exit(1);
    }
}
