import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.lang.*;

public class Window extends JFrame{

    // NO MOVER POR NADA EN EL MUNDO ESTO, LO MUEVES, TE HAGO UN KFC
    private JPanel userScreen;
    private JTextField userNameInput, userPasswordInput, userInputNewBalance;
    private JButton acceptButton, logoutButton, clientButton, providerButton, productButton, cat1Button, cat2Button, cat3Button, cat4Button;
    private JRadioButton addButton, removeButton, searchButton, modifyButton, plus1Button, plus2Button, plus3Button, plus4Button;
    private JLabel serverOutput, textA, textB, textC, textD, textE, textF, textG, textH, textI;

    private boolean optionA = false, optionB = false, optionC = false, optionD = false;
    private JTable inventoryTable;

    private Style exam;
    static final int height = 1024;
    static final int width = 1440;

    private int selector;

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

        String userName = "Administrador";

        clientButton = new JButton("Cliente");
        clientButton.setBounds(19, 92, 117,29);
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaCliente();
            }
        });
        userScreen.add(clientButton);

        providerButton = new JButton("Provedor");
        providerButton.setBounds(19, 134, 117,29);
        providerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAfiliado();
            }
        });
        userScreen.add(providerButton);

        productButton = new JButton("Producto");
        productButton.setBounds(19, 176, 117,29);
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaProducto();
            }
        });
        userScreen.add(productButton);

        cat1Button = new JButton("ESCRIBIR");
        cat1Button.setBounds(19, 218, 117,29);
        cat1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat1();
            }
        });
        userScreen.add(cat1Button);

        cat2Button = new JButton("ESCRIBIR");
        cat2Button.setBounds(19, 260, 117,29);
        cat2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat2();
            }
        });
        userScreen.add(cat2Button);

        cat3Button = new JButton("ESCRIBIR");
        cat3Button.setBounds(19, 302, 117,29);
        cat3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat3();
            }
        });
        userScreen.add(cat3Button);

        cat4Button = new JButton("ESCRIBIR");
        cat4Button.setBounds(19, 344, 117,29);
        cat4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat4();
            }
        });
        userScreen.add(cat4Button);

        //SOLO ES PA SALIRSE!
        logoutButton = new JButton("Cerrar Sesion");
        logoutButton.setBounds(1258,28,117,23);
        logoutButton.addActionListener(new ActionListener() {
                                           @Override
                                           public void actionPerformed(ActionEvent event) {
                                               // TODO Auto-generated method stub
                                               LoginScreen();
                                           }
                                       }
        );
        userScreen.add(logoutButton);

        userInputNewBalance = new JTextField();
        userInputNewBalance.setBounds(284,843,884,29);
        userScreen.add(userInputNewBalance);

        exam = new Style(2); //CAMBIAR COLORES SEGUN SEYTU o OMNILIFE
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);

        this.repaint();
    }


    public void ventanaCliente(){
        userScreen.removeAll();
        String[] cnClient = {"ID Cliente", "Nombre del Cliente", "Correo del Cliente", "Fecha de Nacimiento", "Edad del Cliente", "Celular del Cliente", "Invitado del Cliente", "Nip Cliente", "Fecha del Cliente", "Tarjeta del Cliente"};
        Object[][] dataB = (Object[][]) createMatrixListClient(); //Modificar
        inventoryTable = new JTable(dataB,cnClient);
        inventoryTable.setBounds(284, 229, 1027, 556);
        userScreen.add(inventoryTable);
        selector = 1;

        String userName = "Administrador";

        textA = new JLabel(userName);
        textA.setBounds(29,29,400,30);
        textA.setForeground(new Color(253, 184, 52));
        userScreen.add(textA);

        // FALTAN
        clientButton = new JButton("Cliente");
        clientButton.setBounds(19, 92, 117,29);
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaCliente();
            }
        });
        userScreen.add(clientButton);

        providerButton = new JButton("Provedor");
        providerButton.setBounds(19, 134, 117,29);
        providerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAfiliado();
            }
        });
        userScreen.add(providerButton);

        productButton = new JButton("Producto");
        productButton.setBounds(19, 176, 117,29);
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaProducto();
            }
        });
        userScreen.add(productButton);

        cat1Button = new JButton("Categoria ST");
        cat1Button.setBounds(19, 218, 117,29);
        cat1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat1();
            }
        });
        userScreen.add(cat1Button);

        cat2Button = new JButton("Categoria OM");
        cat2Button.setBounds(19, 260, 117,29);
        cat2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat2();
            }
        });
        userScreen.add(cat2Button);

        cat3Button = new JButton("Categoria Clientes");
        cat3Button.setBounds(19, 302, 117,29);
        cat3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat3();
            }
        });
        userScreen.add(cat3Button);

        cat4Button = new JButton("Descuento Afiliados");
        cat4Button.setBounds(19, 344, 117,29);
        cat4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat4();
            }
        });
        userScreen.add(cat4Button);

        //SOLO ES PA SALIRSE!
        logoutButton = new JButton("Cerrar Sesion");
        logoutButton.setBounds(1258,28,117,23);
        logoutButton.addActionListener(new ActionListener() {
                                           @Override
                                           public void actionPerformed(ActionEvent event) {
                                               // TODO Auto-generated method stub
                                               LoginScreen();
                                           }
                                       }
        );
        userScreen.add(logoutButton);

        userInputNewBalance = new JTextField();
        userInputNewBalance.setBounds(284,843,884,29);
        userScreen.add(userInputNewBalance);

        ButtonGroup group = new ButtonGroup();
        group.add(addButton); group.add(removeButton); group.add(searchButton); group.add(modifyButton);

        acceptButton = new JButton("Ejecutar");
        acceptButton.setBounds(1194,843,117,29);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");

                        ventanaCliente();
                    }
                }

                if (removeButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }

                if (searchButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }

                if (modifyButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }
            }
        });
        userScreen.add(acceptButton);


        exam = new Style(2); //CAMBIAR COLORES SEGUN SEYTU o OMNILIFE
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);

        this.repaint();
    }

    public void ventanaAfiliado(){
        userScreen.removeAll();
        String[] cnAfiliado = {"ID Afiliado", "Nombre del Afiliado", "Correo del Afiliado", "Fecha de Nacimiento", "Edad del Afiliado", "Celular del Afiliado", "Invitado del Afiliado", "Nip Afiliado", "Fecha del Afiliado", "Tarjeta del Afiliado"};
        Object[][] dataC = (Object[][]) createMatrixListAfiliado(); //Modificar
        inventoryTable = new JTable(dataC, cnAfiliado);
        inventoryTable.setBounds(284, 229, 1027, 556);
        userScreen.add(inventoryTable);
        selector = 2;

        String userName = "Administrador";

        textA = new JLabel(userName);
        textA.setBounds(29,29,400,30);
        textA.setForeground(new Color(253, 184, 52));
        userScreen.add(textA);

        // FALTAN
        addButton = new JRadioButton("Añadir");
        addButton.setBounds(765, 799, 117,29);
        addButton.setSelected(true);
        userScreen.add(addButton);

        removeButton = new JRadioButton("Eliminar");
        removeButton.setBounds(908, 799, 117,29);
        userScreen.add(removeButton);

        searchButton = new JRadioButton("Buscar");
        searchButton.setBounds(1051, 799, 117,29);
        userScreen.add(searchButton);

        modifyButton = new JRadioButton("Modificar");
        modifyButton.setBounds(1194, 799, 117,29);
        userScreen.add(modifyButton);

        clientButton = new JButton("Cliente");
        clientButton.setBounds(19, 92, 117,29);
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaCliente();
            }
        });
        userScreen.add(clientButton);

        providerButton = new JButton("Provedor");
        providerButton.setBounds(19, 134, 117,29);
        providerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAfiliado();
            }
        });
        userScreen.add(providerButton);

        productButton = new JButton("Producto");
        productButton.setBounds(19, 176, 117,29);
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaProducto();
            }
        });
        userScreen.add(productButton);

        cat1Button = new JButton("Categoria ST");
        cat1Button.setBounds(19, 218, 117,29);
        cat1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat1();
            }
        });
        userScreen.add(cat1Button);

        cat2Button = new JButton("Categoria OM");
        cat2Button.setBounds(19, 260, 117,29);
        cat2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat2();
            }
        });
        userScreen.add(cat2Button);

        cat3Button = new JButton("Categoria Clientes");
        cat3Button.setBounds(19, 302, 117,29);
        cat3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat3();
            }
        });
        userScreen.add(cat3Button);

        cat4Button = new JButton("Descuento Afiliados");
        cat4Button.setBounds(19, 344, 117,29);
        cat4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat4();
            }
        });
        userScreen.add(cat4Button);

        //SOLO ES PA SALIRSE!
        logoutButton = new JButton("Cerrar Sesion");
        logoutButton.setBounds(1258,28,117,23);
        logoutButton.addActionListener(new ActionListener() {
                                           @Override
                                           public void actionPerformed(ActionEvent event) {
                                               // TODO Auto-generated method stub
                                               LoginScreen();
                                           }
                                       }
        );
        userScreen.add(logoutButton);

        userInputNewBalance = new JTextField();
        userInputNewBalance.setBounds(284,843,884,29);
        userScreen.add(userInputNewBalance);

        ButtonGroup group = new ButtonGroup();
        group.add(addButton); group.add(removeButton); group.add(searchButton); group.add(modifyButton);

        acceptButton = new JButton("Ejecutar");
        acceptButton.setBounds(1194,843,117,29);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");

                        ventanaCliente();
                    }
                }

                if (removeButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }

                if (searchButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }

                if (modifyButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }
            }
        });
        userScreen.add(acceptButton);


        exam = new Style(2); //CAMBIAR COLORES SEGUN SEYTU o OMNILIFE
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);


        this.repaint();
    }

    public void ventanaProducto(){
        userScreen.removeAll();
        String[] cnInventory = {"ID Producto", "Nombre del Producto", "Descripcion", "Presentacion", "Precio", "Contenido", "Stock", "Marca"};
        Object[][] dataA = (Object[][]) createMatrixListInventory();
        inventoryTable = new JTable(dataA,cnInventory);
        inventoryTable.setBounds(284, 229, 1027, 556);
        userScreen.add(inventoryTable);
        selector = 3;

        String userName = "Administrador";

        textA = new JLabel(userName);
        textA.setBounds(29,29,400,30);
        textA.setForeground(new Color(253, 184, 52));
        userScreen.add(textA);

        // FALTAN
        addButton = new JRadioButton("Añadir");
        addButton.setBounds(765, 799, 117,29);
        addButton.setSelected(true);
        userScreen.add(addButton);

        removeButton = new JRadioButton("Eliminar");
        removeButton.setBounds(908, 799, 117,29);
        userScreen.add(removeButton);

        searchButton = new JRadioButton("Buscar");
        searchButton.setBounds(1051, 799, 117,29);
        userScreen.add(searchButton);

        modifyButton = new JRadioButton("Modificar");
        modifyButton.setBounds(1194, 799, 117,29);
        userScreen.add(modifyButton);

        clientButton = new JButton("Cliente");
        clientButton.setBounds(19, 92, 117,29);
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaCliente();
            }
        });
        userScreen.add(clientButton);

        providerButton = new JButton("Provedor");
        providerButton.setBounds(19, 134, 117,29);
        providerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAfiliado();
            }
        });
        userScreen.add(providerButton);

        productButton = new JButton("Producto");
        productButton.setBounds(19, 176, 117,29);
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaProducto();
            }
        });
        userScreen.add(productButton);

        cat1Button = new JButton("Categoria ST");
        cat1Button.setBounds(19, 218, 117,29);
        cat1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat1();
            }
        });
        userScreen.add(cat1Button);

        cat2Button = new JButton("Categoria OM");
        cat2Button.setBounds(19, 260, 117,29);
        cat2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat2();
            }
        });
        userScreen.add(cat2Button);

        cat3Button = new JButton("Categoria Clientes");
        cat3Button.setBounds(19, 302, 117,29);
        cat3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat3();
            }
        });
        userScreen.add(cat3Button);

        cat4Button = new JButton("Descuento Afiliados");
        cat4Button.setBounds(19, 344, 117,29);
        cat4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat4();
            }
        });
        userScreen.add(cat4Button);

        //SOLO ES PA SALIRSE!
        logoutButton = new JButton("Cerrar Sesion");
        logoutButton.setBounds(1258,28,117,23);
        logoutButton.addActionListener(new ActionListener() {
                                           @Override
                                           public void actionPerformed(ActionEvent event) {
                                               // TODO Auto-generated method stub
                                               LoginScreen();
                                           }
                                       }
        );
        userScreen.add(logoutButton);

        userInputNewBalance = new JTextField();
        userInputNewBalance.setBounds(284,843,884,29);
        userScreen.add(userInputNewBalance);

        ButtonGroup group = new ButtonGroup();
        group.add(addButton); group.add(removeButton); group.add(searchButton); group.add(modifyButton);

        acceptButton = new JButton("Ejecutar");
        acceptButton.setBounds(1194,843,117,29);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");

                        ventanaCliente();
                    }
                }

                if (removeButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }

                if (searchButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }

                if (modifyButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }
            }
        });
        userScreen.add(acceptButton);


        exam = new Style(2); //CAMBIAR COLORES SEGUN SEYTU o OMNILIFE
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);

        this.repaint();
    }

    public void ventanaCat1(){
        userScreen.removeAll();
        String[] cnClient = {"ID Cliente", "Nombre del Cliente", "Correo del Cliente", "Fecha de Nacimiento", "Edad del Cliente", "Celular del Cliente", "Invitado del Cliente", "Nip Cliente", "Fecha del Cliente", "Tarjeta del Cliente"};
        Object[][] dataB = (Object[][]) createMatrixListClient(); //Modificar
        inventoryTable = new JTable(dataB,cnClient);
        inventoryTable.setBounds(284, 229, 1027, 556);
        userScreen.add(inventoryTable);
        selector = 1;

        String userName = "Administrador";

        textA = new JLabel(userName);
        textA.setBounds(29,29,400,30);
        textA.setForeground(new Color(253, 184, 52));
        userScreen.add(textA);

        // FALTAN
        clientButton = new JButton("Cliente");
        clientButton.setBounds(19, 92, 117,29);
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaCliente();
            }
        });
        userScreen.add(clientButton);

        providerButton = new JButton("Provedor");
        providerButton.setBounds(19, 134, 117,29);
        providerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAfiliado();
            }
        });
        userScreen.add(providerButton);

        productButton = new JButton("Producto");
        productButton.setBounds(19, 176, 117,29);
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaProducto();
            }
        });
        userScreen.add(productButton);

        cat1Button = new JButton("Categoria ST");
        cat1Button.setBounds(19, 218, 117,29);
        cat1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat1();
            }
        });
        userScreen.add(cat1Button);

        cat2Button = new JButton("Categoria OM");
        cat2Button.setBounds(19, 260, 117,29);
        cat2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat2();
            }
        });
        userScreen.add(cat2Button);

        cat3Button = new JButton("Categoria Clientes");
        cat3Button.setBounds(19, 302, 117,29);
        cat3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat3();
            }
        });
        userScreen.add(cat3Button);

        cat4Button = new JButton("Descuento Afiliados");
        cat4Button.setBounds(19, 344, 117,29);
        cat4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat4();
            }
        });
        userScreen.add(cat4Button);

        //SOLO ES PA SALIRSE!
        logoutButton = new JButton("Cerrar Sesion");
        logoutButton.setBounds(1258,28,117,23);
        logoutButton.addActionListener(new ActionListener() {
                                           @Override
                                           public void actionPerformed(ActionEvent event) {
                                               // TODO Auto-generated method stub
                                               LoginScreen();
                                           }
                                       }
        );
        userScreen.add(logoutButton);

        userInputNewBalance = new JTextField();
        userInputNewBalance.setBounds(284,843,884,29);
        userScreen.add(userInputNewBalance);

        ButtonGroup group = new ButtonGroup();
        group.add(addButton); group.add(removeButton); group.add(searchButton); group.add(modifyButton);

        acceptButton = new JButton("Ejecutar");
        acceptButton.setBounds(1194,843,117,29);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");

                        ventanaCliente();
                    }
                }

                if (removeButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }

                if (searchButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }

                if (modifyButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }
            }
        });
        userScreen.add(acceptButton);


        exam = new Style(2); //CAMBIAR COLORES SEGUN SEYTU o OMNILIFE
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);

        this.repaint();
    }

    public void ventanaCat2(){
        userScreen.removeAll();
        String[] cnClient = {"ID Cliente", "Nombre del Cliente", "Correo del Cliente", "Fecha de Nacimiento", "Edad del Cliente", "Celular del Cliente", "Invitado del Cliente", "Nip Cliente", "Fecha del Cliente", "Tarjeta del Cliente"};
        Object[][] dataB = (Object[][]) createMatrixListClient(); //Modificar
        inventoryTable = new JTable(dataB,cnClient);
        inventoryTable.setBounds(284, 229, 1027, 556);
        userScreen.add(inventoryTable);
        selector = 1;

        String userName = "Administrador";

        textA = new JLabel(userName);
        textA.setBounds(29,29,400,30);
        textA.setForeground(new Color(253, 184, 52));
        userScreen.add(textA);

        // FALTAN
        clientButton = new JButton("Cliente");
        clientButton.setBounds(19, 92, 117,29);
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaCliente();
            }
        });
        userScreen.add(clientButton);

        providerButton = new JButton("Provedor");
        providerButton.setBounds(19, 134, 117,29);
        providerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAfiliado();
            }
        });
        userScreen.add(providerButton);

        productButton = new JButton("Producto");
        productButton.setBounds(19, 176, 117,29);
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaProducto();
            }
        });
        userScreen.add(productButton);

        cat1Button = new JButton("Categoria ST");
        cat1Button.setBounds(19, 218, 117,29);
        cat1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat1();
            }
        });
        userScreen.add(cat1Button);

        cat2Button = new JButton("Categoria OM");
        cat2Button.setBounds(19, 260, 117,29);
        cat2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat2();
            }
        });
        userScreen.add(cat2Button);

        cat3Button = new JButton("Categoria Clientes");
        cat3Button.setBounds(19, 302, 117,29);
        cat3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat3();
            }
        });
        userScreen.add(cat3Button);

        cat4Button = new JButton("Descuento Afiliados");
        cat4Button.setBounds(19, 344, 117,29);
        cat4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat4();
            }
        });
        userScreen.add(cat4Button);

        //SOLO ES PA SALIRSE!
        logoutButton = new JButton("Cerrar Sesion");
        logoutButton.setBounds(1258,28,117,23);
        logoutButton.addActionListener(new ActionListener() {
                                           @Override
                                           public void actionPerformed(ActionEvent event) {
                                               // TODO Auto-generated method stub
                                               LoginScreen();
                                           }
                                       }
        );
        userScreen.add(logoutButton);

        userInputNewBalance = new JTextField();
        userInputNewBalance.setBounds(284,843,884,29);
        userScreen.add(userInputNewBalance);

        ButtonGroup group = new ButtonGroup();
        group.add(addButton); group.add(removeButton); group.add(searchButton); group.add(modifyButton);

        acceptButton = new JButton("Ejecutar");
        acceptButton.setBounds(1194,843,117,29);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");

                        ventanaCliente();
                    }
                }

                if (removeButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }

                if (searchButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }

                if (modifyButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }
            }
        });
        userScreen.add(acceptButton);


        exam = new Style(2); //CAMBIAR COLORES SEGUN SEYTU o OMNILIFE
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);

        this.repaint();
    }

    public void ventanaCat3(){
        userScreen.removeAll();
        String[] cnClient = {"ID Cliente", "Nombre del Cliente", "Correo del Cliente", "Fecha de Nacimiento", "Edad del Cliente", "Celular del Cliente", "Invitado del Cliente", "Nip Cliente", "Fecha del Cliente", "Tarjeta del Cliente"};
        Object[][] dataB = (Object[][]) createMatrixListClient(); //Modificar
        inventoryTable = new JTable(dataB,cnClient);
        inventoryTable.setBounds(284, 229, 1027, 556);
        userScreen.add(inventoryTable);
        selector = 1;

        String userName = "Administrador";

        textA = new JLabel(userName);
        textA.setBounds(29,29,400,30);
        textA.setForeground(new Color(253, 184, 52));
        userScreen.add(textA);

        // FALTAN
        clientButton = new JButton("Cliente");
        clientButton.setBounds(19, 92, 117,29);
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaCliente();
            }
        });
        userScreen.add(clientButton);

        providerButton = new JButton("Provedor");
        providerButton.setBounds(19, 134, 117,29);
        providerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAfiliado();
            }
        });
        userScreen.add(providerButton);

        productButton = new JButton("Producto");
        productButton.setBounds(19, 176, 117,29);
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaProducto();
            }
        });
        userScreen.add(productButton);

        cat1Button = new JButton("Categoria ST");
        cat1Button.setBounds(19, 218, 117,29);
        cat1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat1();
            }
        });
        userScreen.add(cat1Button);

        cat2Button = new JButton("Categoria OM");
        cat2Button.setBounds(19, 260, 117,29);
        cat2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat2();
            }
        });
        userScreen.add(cat2Button);

        cat3Button = new JButton("Categoria Clientes");
        cat3Button.setBounds(19, 302, 117,29);
        cat3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat3();
            }
        });
        userScreen.add(cat3Button);

        cat4Button = new JButton("Descuento Afiliados");
        cat4Button.setBounds(19, 344, 117,29);
        cat4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat4();
            }
        });
        userScreen.add(cat4Button);

        //SOLO ES PA SALIRSE!
        logoutButton = new JButton("Cerrar Sesion");
        logoutButton.setBounds(1258,28,117,23);
        logoutButton.addActionListener(new ActionListener() {
                                           @Override
                                           public void actionPerformed(ActionEvent event) {
                                               // TODO Auto-generated method stub
                                               LoginScreen();
                                           }
                                       }
        );
        userScreen.add(logoutButton);

        userInputNewBalance = new JTextField();
        userInputNewBalance.setBounds(284,843,884,29);
        userScreen.add(userInputNewBalance);

        ButtonGroup group = new ButtonGroup();
        group.add(addButton); group.add(removeButton); group.add(searchButton); group.add(modifyButton);

        acceptButton = new JButton("Ejecutar");
        acceptButton.setBounds(1194,843,117,29);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");

                        ventanaCliente();
                    }
                }

                if (removeButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }

                if (searchButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }

                if (modifyButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }
            }
        });
        userScreen.add(acceptButton);


        exam = new Style(2); //CAMBIAR COLORES SEGUN SEYTU o OMNILIFE
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);

        this.repaint();
    }

    public void ventanaCat4(){
        userScreen.removeAll();
        String[] cnClient = {"ID Cliente", "Nombre del Cliente", "Correo del Cliente", "Fecha de Nacimiento", "Edad del Cliente", "Celular del Cliente", "Invitado del Cliente", "Nip Cliente", "Fecha del Cliente", "Tarjeta del Cliente"};
        Object[][] dataB = (Object[][]) createMatrixListClient(); //Modificar
        inventoryTable = new JTable(dataB,cnClient);
        inventoryTable.setBounds(284, 229, 1027, 556);
        userScreen.add(inventoryTable);
        selector = 1;

        String userName = "Administrador";

        textA = new JLabel(userName);
        textA.setBounds(29,29,400,30);
        textA.setForeground(new Color(253, 184, 52));
        userScreen.add(textA);

        // FALTAN
        clientButton = new JButton("Cliente");
        clientButton.setBounds(19, 92, 117,29);
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaCliente();
            }
        });
        userScreen.add(clientButton);

        providerButton = new JButton("Provedor");
        providerButton.setBounds(19, 134, 117,29);
        providerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAfiliado();
            }
        });
        userScreen.add(providerButton);

        productButton = new JButton("Producto");
        productButton.setBounds(19, 176, 117,29);
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaProducto();
            }
        });
        userScreen.add(productButton);

        cat1Button = new JButton("ESCRIBIR");
        cat1Button.setBounds(19, 218, 117,29);
        cat1Button = new JButton("Categoria ST");
        cat1Button.setBounds(19, 218, 117,29);
        cat1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat1();
            }
        });
        userScreen.add(cat1Button);

        cat2Button = new JButton("Categoria OM");
        cat2Button.setBounds(19, 260, 117,29);
        cat2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat2();
            }
        });
        userScreen.add(cat2Button);

        cat3Button = new JButton("Categoria Clientes");
        cat3Button.setBounds(19, 302, 117,29);
        cat3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat3();
            }
        });
        userScreen.add(cat3Button);

        cat4Button = new JButton("Descuento Afiliados");
        cat4Button.setBounds(19, 344, 117,29);
        cat4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FALTA
                ventanaCat4();
            }
        });
        userScreen.add(cat4Button);

        //SOLO ES PA SALIRSE!
        logoutButton = new JButton("Cerrar Sesion");
        logoutButton.setBounds(1258,28,117,23);
        logoutButton.addActionListener(new ActionListener() {
                                           @Override
                                           public void actionPerformed(ActionEvent event) {
                                               // TODO Auto-generated method stub
                                               LoginScreen();
                                           }
                                       }
        );
        userScreen.add(logoutButton);

        userInputNewBalance = new JTextField();
        userInputNewBalance.setBounds(284,843,884,29);
        userScreen.add(userInputNewBalance);

        ButtonGroup group = new ButtonGroup();
        group.add(addButton); group.add(removeButton); group.add(searchButton); group.add(modifyButton);

        acceptButton = new JButton("Ejecutar");
        acceptButton.setBounds(1194,843,117,29);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");

                        ventanaCliente();
                    }
                }

                if (removeButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }

                if (searchButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }

                if (modifyButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        String[] xcdS = userInputNewBalance.getText().split("-");
                    }
                }
            }
        });
        userScreen.add(acceptButton);


        exam = new Style(2); //CAMBIAR COLORES SEGUN SEYTU o OMNILIFE
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);

        this.repaint();
    }



    public Object createMatrixListInventory(){
        ArrayList<InventarioSyO> inventory = InventarioSyO.listaInventario();
        Object[][] data = new Object[25][8];
        int i = 0;
        if (inventory.size() == 0) {
            for (int k = 0; k < 25; k++) {
                for (int j = 0; j < 8; j++) {
                    data[k][j] = "";
                }
            }
            return data;
        }
        for (InventarioSyO item: inventory) {
            String[] itemProduct = InventarioSyO.arregloInventario(item);
            for (int k = 0; k < 8; k++) {
                data[i][k] = itemProduct[k];
            }
            i++;
        }
        return data;
    }

    public Object createMatrixListClient(){
        ArrayList<Cliente> clients = Cliente.listaCliente();
        Object[][] data = new Object[25][10];
        int i = 0;
        if (clients.size() == 0) {
            for (int k = 0; k < 25; k++) {
                for (int j = 0; j < 10; j++) {
                    data[k][j] = "";
                }
            }
            return data;
        }
        for (Cliente c : clients) {
            String[] itemProduct = Cliente.arregloClientes(c);
            for (int k = 0; k < 10; k++) {
                data[i][k] = itemProduct[k];
            }
            i++;
        }
        return data;
    }

    public Object createMatrixListAfiliado() {
        ArrayList<Afiliado> afiliados = Afiliado.listaAfiliados();
        Object[][] data = new Object[25][10];
        int i = 0;
        if (afiliados.size() == 0) {
            for (int k = 0; k < 25; k++) {
                for (int j = 0; j < 10; j++) {
                    data[k][j] = "";
                }
            }
            return data;
        }
        for (Afiliado a : afiliados) {
            String[] itemProduct = Afiliado.arregloAfiliados(a);
            for (int k = 0; k < 10; k++) {
                data[i][k] = itemProduct[k];
            }
            i++;
        }
        return data;
    }

    public Object createMatrixCategoryOm() {
        ArrayList<CategoriaOm> categories = CategoriaOm.listaCategoriasOm();
        Object[][] data = new Object[25][2];
        int i = 0;
        if (categories.size() == 0) {
            for (int k = 0; k < 25; k++) {
                for (int j = 0; j < 2; j++) {
                    data[k][j] = "";
                }
            }
            return data;
        }
        for (CategoriaOm co : categories) {
            String[] itemProduct = CategoriaOm.arregloCategorias(co);
            for (int k = 0; k < 2; k++) {
                data[i][k] = itemProduct[k];
            }
            i++;
        }
        return data;
    }

    public Object createMatrixCategorySt() {
        ArrayList<CategoriaSt> categories = CategoriaSt.listaCategoriasSt();
        Object[][] data = new Object[25][2];
        int i = 0;
        if (categories.size() == 0) {
            for (int k = 0; k < 25; k++) {
                for (int j = 0; j < 2; j++) {
                    data[k][j] = "";
                }
            }
            return data;
        }
        for (CategoriaSt co : categories) {
            String[] itemProduct = CategoriaSt.arregloCategorias(co);
            for (int k = 0; k < 2; k++) {
                data[i][k] = itemProduct[k];
            }
            i++;
        }
        return data;
    }

    public Object createMatrixCategoryClient() {
        ArrayList<CategoriaCliente> categories = CategoriaCliente.listaCategoriasClientes();
        Object[][] data = new Object[25][3];
        int i = 0;
        if (categories.size() == 0) {
            for (int k = 0; k < 25; k++) {
                for (int j = 0; j < 3; j++) {
                    data[k][j] = "";
                }
            }
            return data;
        }
        for (CategoriaCliente co : categories) {
            String[] itemProduct = CategoriaCliente.arregloCategorias(co);
            for (int k = 0; k < 3; k++) {
                data[i][k] = itemProduct[k];
            }
            i++;
        }
        return data;
    }

    public Object createMatrixDescuentos() {
        ArrayList<DescuentosAfiliados> descuentos = DescuentosAfiliados.listaDescuentos();
        Object[][] data = new Object[25][3];
        int i = 0;
        if (descuentos.size() == 0) {
            for (int k = 0; k < 25; k++) {
                for (int j = 0; j < 3; j++) {
                    data[k][j] = "";
                }
            }
            return data;
        }
        for (DescuentosAfiliados da : descuentos) {
            String[] itemProduct = DescuentosAfiliados.arregloDescuento(da);
            for (int k = 0; k < 3; k++) {
                data[i][k] = itemProduct[k];
            }
            i++;
        }
        return data;
    }
}