import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


import javax.swing.*;

public class Window extends JFrame{

    // NO MOVER POR NADA EN EL MUNDO ESTO, LO MUEVES, TE HAGO UN KFC
    private JPanel userScreen;
    private JTextField userNameInput, userMailInput, userPasswordInput, userInputBalance;
    private JButton acceptButton, returnButton, setNewBalance, drawBalance;
    private JLabel serverOutput, textA, textB, textC, textD, textE, textF, textG, textH, textI;
    private Style exam;

    static final int height = 768;
    static final int width = 1368;

    //CONSTRUCTOR
    public Window(){

        this.setVisible(true); //Para hacer visible la ventana, luego corres el programa y no pasa nada, entonces abre 300 veces el programa.
        this.setSize(width, height); //Para modificar el ancho y alto de la ventana, se mueven con las var de la linea 21.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Para que se cierre completamente.
        this.setLayout(null); //No queremos ningun layout predeterminado.
        this.setLocation(0,0); //Para ubicar la ventana en algun lugar de la pantalla.
        this.setTitle("DBM [REV. 1]");

        userScreen = new JPanel();
        userScreen.setBounds(0,0,width, height);
        userScreen.setBackground(Color.WHITE);
        userScreen.setLayout(null);
        this.add(userScreen);

        LoginScreen();
    }

    public void LoginScreen(){
        userScreen.removeAll();

        textA = new JLabel("SYO - DataBase Manager");
        textA.setBounds(width/2 - 200 + 50,10,400,30);
        textA.setFont(new Font("Roboto", Font.PLAIN, 24));
        textA.setForeground(new Color(253, 184, 52));
        userScreen.add(textA);

        exam = new Style();
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);

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