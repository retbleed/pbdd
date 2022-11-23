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
    private JTextField userNameInput, userPasswordInput, userInputNewBalance1, userInputNewBalance2, userInputNewBalance3,
            userInputNewBalance4, userInputNewBalance5, userInputNewBalance6, userInputNewBalance7, userInputNewBalance8,
            userInputNewBalance9, userInputNewBalance10;
    private JButton acceptButton, returnButton, logoutButton, addButton, removeButton, searchButton, modifyButton, clientButton, providerButton, productButton;
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

        textA = new JLabel("DataBase Manager");
        textA.setBounds(25,10,400,30);
        textA.setFont(new Font("Monospace", Font.PLAIN, 24));
        textA.setForeground(new Color(253, 184, 52));
        userScreen.add(textA);

        textB = new JLabel("Nombre de Usuario");
        textB.setBounds(25,470,400,30);
        userScreen.add(textB);

        userNameInput = new JTextField();
        userNameInput.setBounds(20,500,200,24);
        userScreen.add(userNameInput);

        textC = new JLabel("Contraseña");
        textC.setBounds(25,520,400,30);
        userScreen.add(textC);

        userPasswordInput = new JTextField();
        userPasswordInput.setBounds(20,550,200,24);
        userScreen.add(userPasswordInput);

        acceptButton = new JButton("Ingresar");
        acceptButton.setBounds(20,575,200,24);

        //FALTA HACER LA VERIFICACION DE ADMINISTRADOR!!!
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // TODO Auto-generated method stub
                    mainScreen();
                }
            }
        );
        userScreen.add(acceptButton);

        exam = new Style(1);
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);
        this.repaint();
    }

    public void mainScreen(){
        userScreen.removeAll();

        String userName = "Alexander";

        textA = new JLabel(userName);
        textA.setBounds(25,10,400,30);
        textA.setFont(new Font("Monospace", Font.PLAIN, 24));
        textA.setForeground(new Color(253, 184, 52));
        userScreen.add(textA);

        for (int i = 0; i < 10; i++){
            textC = new JLabel("PROBANDO: " + (i * 13));
            textC.setBounds(35,115 + (i * 13),700,30);
            userScreen.add(textC);
        }

        //  addButton removeButton searchButton modifyButton

        addButton = new JButton("Añadir");
        addButton.setBounds(1055, 105, 255,30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        userScreen.add(addButton);

        removeButton = new JButton("Eliminar");
        removeButton.setBounds(1055, 140, 255,30);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        userScreen.add(removeButton);

        searchButton = new JButton("Buscar");
        searchButton.setBounds(1055, 175, 255,30);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        userScreen.add(searchButton);

        modifyButton = new JButton("Modificar");
        modifyButton.setBounds(1055, 210, 255,30);
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        userScreen.add(modifyButton);

        clientButton = new JButton("Cliente");
        clientButton.setBounds(1055, 310, 255, 75);
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        userScreen.add(clientButton);

        providerButton = new JButton("Provedor");
        providerButton.setBounds(1055, 395, 255, 75);
        providerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userScreen.remove(textC);
                repaint();
            }
        });
        userScreen.add(providerButton);

        productButton = new JButton("Producto");
        productButton.setBounds(1055, 480, 255, 75);
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        userScreen.add(productButton);

        //SOLO ES PA SALIRSE!
        logoutButton = new JButton("Cerrar Sesion");
        logoutButton.setBounds(1080,15,200,24);
        logoutButton.addActionListener(new ActionListener() {
                                           @Override
                                           public void actionPerformed(ActionEvent event) {
                                               // TODO Auto-generated method stub
                                               LoginScreen();
                                           }
                                       }
        );
        userScreen.add(logoutButton);

        exam = new Style(2); //CAMBIAR COLORES SEGUN SEYTU o OMNILIFE
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);

        this.repaint();
    }
}