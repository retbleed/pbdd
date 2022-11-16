import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


import javax.swing.*;

public class Window extends JFrame{

    private JPanel userScreen;
    private JTextField userNameInput, userMailInput, userPasswordInput, userInputBalance;
    private JButton acceptButton, returnButton, setNewBalance, drawBalance;
    private JLabel serverOutput, textA, textB, textC;

    //CONSTRUCTOR
    public Window(){

        this.setVisible(true); //Para hacer visible la ventana, luego corres el programa y no pasa nada, entonces abre 300 veces el programa.
        this.setSize(600, 600); //Para modificar el ancho y alto de la ventana, se mueven con las var de la linea 21.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Para que se cierre completamente.
        this.setLayout(null); //No queremos ningun layout predeterminado.
        this.setLocation(0,0); //Para ubicar la ventana en algun lugar de la pantalla.
        this.setTitle("PROYECTO BASE DE DATOS");

        userScreen = new JPanel();
        userScreen.setBounds(0,0,600, 600);
        userScreen.setBackground(Color.WHITE);
        userScreen.setLayout(null);
        this.add(userScreen);

        LoginScreen();
    }

    public void LoginScreen(){
        userScreen.removeAll();

        this.repaint();
    }

    public void SignUpScreen (){
        userScreen.removeAll();

        this.repaint();
    }

    public void mainScreen(){
        userScreen.removeAll();

        this.repaint();
    }

    public void inventoryScreen(){
        userScreen.removeAll();

        this.repaint();
    }

    public void sellScreen(){
        userScreen.removeAll();

        this.repaint();
    }
}