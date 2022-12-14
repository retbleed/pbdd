import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.lang.*;

public class Window extends JFrame{
    private final JPanel userScreen;
    JTextField userNameInput, userPasswordInput, userInputNewBalance;
    JButton acceptButton, logoutButton, clientButton, providerButton, productButton, cat1Button, cat2Button, cat3Button, cat4Button;
    JRadioButton addButton, removeButton, searchButton, modifyButton, plus1Button, plus2Button, plus3Button;
    JLabel serverOutput, textA, textB, textC, textD, textE;
    private boolean optionA = false, optionB = false, optionC = false, optionD = false;
    private JTable inventoryTable;
    private Style exam;
    static final int height = 1024;
    static final int width = 1440;

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

        textC = new JLabel("Contrase??a");
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

        String userName = "Administrador";

        textA = new JLabel(userName);
        textA.setBounds(29,29,400,30);
        textA.setForeground(new Color(253, 184, 52));
        userScreen.add(textA);

        textD =  new JLabel();
        textD.setBounds(284,887,1027,27);
        userScreen.add(textA);

        // FALTAN

        addButton = new JRadioButton("Insertar Cliente");
        addButton.setBounds(336, 799, 117,29);
        addButton.setSelected(true);
        userScreen.add(addButton);

        removeButton = new JRadioButton("Eliminar Cliente");
        removeButton.setBounds(479, 799, 117,29);
        userScreen.add(removeButton);

        searchButton = new JRadioButton("Buscar");
        searchButton.setBounds(622, 799, 117,29);
        userScreen.add(searchButton);

        modifyButton = new JRadioButton("Actualizar Datos");
        modifyButton.setBounds(765, 799, 117,29);
        userScreen.add(modifyButton);

        plus1Button = new JRadioButton("Actualizar Fechas");
        plus1Button.setBounds(908, 799, 117,29);
        userScreen.add(plus1Button);

        plus2Button = new JRadioButton("Actualizar Celular");
        plus2Button.setBounds(1051, 799, 117,29);
        userScreen.add(plus2Button);

        plus3Button = new JRadioButton("Actualizar NIP");
        plus2Button.setBounds(1194, 799, 117,29);
        userScreen.add(plus2Button);

        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////

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

        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////

        userInputNewBalance = new JTextField();
        userInputNewBalance.setBounds(284,843,884,29);
        userScreen.add(userInputNewBalance);

        ButtonGroup group = new ButtonGroup();
        group.add(addButton); group.add(removeButton); group.add(searchButton); group.add(modifyButton); group.add(plus1Button); group.add(plus2Button); group.add(plus3Button);

        acceptButton = new JButton("Ejecutar");
        acceptButton.setBounds(1194,843,117,29);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] xcdS = userInputNewBalance.getText().split("_");
                if (addButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 9){
                            Cliente.insertarCliente(xcdS[0],xcdS[1],xcdS[2],Integer.parseInt(xcdS[3]),xcdS[4], xcdS[5], Integer.parseInt(xcdS[6]), xcdS[7], xcdS[8]);
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }

                    }
                }

                if (removeButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 1){
                            Cliente.eliminarCliente(Integer.parseInt(xcdS[0]));
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }

                if (searchButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 1){
                            Cliente.busquedaXID(Integer.parseInt(xcdS[0]));
                            textD.setForeground(new Color(137, 234, 17));
                            textD.setText(String.valueOf(Cliente.busquedaXID(Integer.parseInt(xcdS[0]))));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                            userInputNewBalance.setText("No funca");
                        }
                    }
                }

                if (modifyButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 4){
                            Cliente.actualizarDatosNombresyCorreos(xcdS[0],xcdS[1], xcdS[2], Integer.parseInt(xcdS[3]));
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }

                if (plus1Button.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 4){
                            Cliente.actualizarFechas(xcdS[0],xcdS[1], xcdS[2], Integer.parseInt(xcdS[3]));
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }

                if (plus2Button.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 4){
                            Cliente.actualizarNumCelular(xcdS[0],xcdS[1], xcdS[2], Integer.parseInt(xcdS[3]));
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }

                if (plus3Button.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 4){
                            Cliente.actualizarNipTarjeta(xcdS[0],xcdS[1], xcdS[2], Integer.parseInt(xcdS[3]));
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }
            }
        });
        userScreen.add(acceptButton);

        exam = new Style(2); //CAMBIAR COLORES SEGUN SEYTU o OMNILIFE
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);

        textE = new JLabel("[Ingresar Cliente] NomCliente_Correo_FechaNacimiento_Edad_Celular_inv_NIP_FechaRegistro_TarjetaCliente\n" +
                "[Eliminar Cliente] idCliente\n" +
                "[Buscar Cliente] nombreTablaID\n" +
                "[Actualizar Datos] nombreTabla_nombreColumna_datoNuevo_id\n" +
                "[Actualizar Fechas] nombreTabla_nombreColumna_fechaNueva_id\n" +
                "[Actualizar Num Tel] nombreTabla_nombreColumna_nuevoNumero_id\n" +
                "[Actualizar NIP] nombreTabla_nombreColumna_nuevoNIP_id \n");
        textE.setBounds(284,877,884,29);
        userScreen.add(textE);

        this.repaint();
    }

    public void ventanaAfiliado(){
        userScreen.removeAll();
        String[] cnAfiliado = {"ID Afiliado", "Nombre del Afiliado", "Correo del Afiliado", "Fecha de Nacimiento", "Edad del Afiliado", "Celular del Afiliado", "Invitado del Afiliado", "Nip Afiliado", "Fecha del Afiliado", "Tarjeta del Afiliado"};
        Object[][] dataC = (Object[][]) createMatrixListAfiliado(); //Modificar
        inventoryTable = new JTable(dataC, cnAfiliado);
        inventoryTable.setBounds(284, 229, 1027, 556);
        userScreen.add(inventoryTable);

        String userName = "Administrador";

        textA = new JLabel(userName);
        textA.setBounds(29,29,400,30);
        textA.setForeground(new Color(253, 184, 52));
        userScreen.add(textA);

        textD =  new JLabel();
        textD.setBounds(284,887,1027,27);
        userScreen.add(textA);

        // FALTAN

        addButton = new JRadioButton("Insertar Afiliado");
        addButton.setBounds(336, 799, 117,29);
        addButton.setSelected(true);
        userScreen.add(addButton);

        removeButton = new JRadioButton("Eliminar Afiliado");
        removeButton.setBounds(479, 799, 117,29);
        userScreen.add(removeButton);

        searchButton = new JRadioButton("Buscar");
        searchButton.setBounds(622, 799, 117,29);
        userScreen.add(searchButton);

        modifyButton = new JRadioButton("Actualizar Datos");
        modifyButton.setBounds(765, 799, 117,29);
        userScreen.add(modifyButton);

        plus1Button = new JRadioButton("Actualizar Fechas");
        plus1Button.setBounds(908, 799, 117,29);
        userScreen.add(plus1Button);

        plus2Button = new JRadioButton("Actualizar Celular");
        plus2Button.setBounds(1051, 799, 117,29);
        userScreen.add(plus2Button);

        plus3Button = new JRadioButton("Actualizar NIP");
        plus2Button.setBounds(1194, 799, 117,29);
        userScreen.add(plus2Button);

        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////

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

        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////

        userInputNewBalance = new JTextField();
        userInputNewBalance.setBounds(284,843,884,29);
        userScreen.add(userInputNewBalance);

        ButtonGroup group = new ButtonGroup();
        group.add(addButton); group.add(removeButton); group.add(searchButton); group.add(modifyButton); group.add(plus1Button); group.add(plus2Button); group.add(plus3Button);

        acceptButton = new JButton("Ejecutar");
        acceptButton.setBounds(1194,843,117,29);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] xcdS = userInputNewBalance.getText().split("_");
                if (addButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 9){
                            Afiliado.insetarAfiliado(xcdS[0],xcdS[1],xcdS[2],Integer.parseInt(xcdS[3]),xcdS[4], xcdS[5], Integer.parseInt(xcdS[6]), xcdS[7], xcdS[8]);
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }

                if (removeButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 1){
                            Afiliado.eliminarAfiliado(Integer.parseInt(xcdS[0]));
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }

                if (searchButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 1){
                            Afiliado.busquedaXID(Integer.parseInt(xcdS[0]));
                            textD.setForeground(new Color(137, 234, 17));
                            textD.setText(String.valueOf(Afiliado.busquedaXID(Integer.parseInt(xcdS[0]))));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }

                if (modifyButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 4){
                            Afiliado.actualizarDatosNombresyCorreos(xcdS[0],xcdS[1], xcdS[2], Integer.parseInt(xcdS[3]));
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }

                if (plus1Button.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 4){
                            Afiliado.actualizarFechas(xcdS[0],xcdS[1], xcdS[2], Integer.parseInt(xcdS[3]));
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else {
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }

                if (plus2Button.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 4){
                            Afiliado.actualizarNumCelular(xcdS[0],xcdS[1], xcdS[2], Integer.parseInt(xcdS[3]));
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }

                if (plus3Button.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 4){
                            Afiliado.actualizarNipTarjeta(xcdS[0],xcdS[1], xcdS[2], Integer.parseInt(xcdS[3]));
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }
            }
        });
        userScreen.add(acceptButton);

        exam = new Style(2); //CAMBIAR COLORES SEGUN SEYTU o OMNILIFE
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);

        textE = new JLabel("[Ingresar Afiliado] NomAfiliado_Correo_FechaNacimiento_Edad_Celular_inv_NIP_FechaRegistro_TarjetaAfiliado \n" +
                "[Eliminar Afiliado] idAfiliado\n" +
                "[Buscar Afiliado] nombreTablaID\n" +
                "[Actualizar Datos] nombreTabla_nombreColumna_datoNuevo_id\n" +
                "[Actualizar Fechas] nombreTabla_nombreColumna_fechaNueva_id\n" +
                "[Actualizar Num Tel] nombreTabla_nombreColumna_nuevoNumero_id\n" +
                "[Actualizar NIP] nombreTabla_nombreColumna_nuevoNIP_id \n");
        textE.setBounds(284,877,884,29);
        userScreen.add(textE);

        this.repaint();
    }

    public void ventanaProducto(){
        userScreen.removeAll();
        String[] cnInventory = {"ID Producto", "Nombre del Producto", "Descripcion", "Presentacion", "Precio", "Contenido", "Stock", "Marca"};
        Object[][] dataA = (Object[][]) createMatrixListInventory();
        inventoryTable = new JTable(dataA,cnInventory);
        inventoryTable.setBounds(284, 229, 1027, 556);
        userScreen.add(inventoryTable);

        String userName = "Administrador";

        textA = new JLabel(userName);
        textA.setBounds(29,29,400,30);
        textA.setForeground(new Color(253, 184, 52));
        userScreen.add(textA);

        textD =  new JLabel();
        textD.setBounds(284,887,1027,27);
        userScreen.add(textA);

        // FALTAN

        addButton = new JRadioButton("Insertar Producto");
        addButton.setBounds(336, 799, 117,29);
        addButton.setSelected(true);
        userScreen.add(addButton);

        removeButton = new JRadioButton("Eliminar Producto");
        removeButton.setBounds(479, 799, 117,29);
        userScreen.add(removeButton);

        searchButton = new JRadioButton("Buscar");
        searchButton.setBounds(622, 799, 117,29);
        userScreen.add(searchButton);

        modifyButton = new JRadioButton("Actualizar Inventario");
        modifyButton.setBounds(765, 799, 117,29);
        userScreen.add(modifyButton);

        plus1Button = new JRadioButton("Actualizar Stock");
        plus1Button.setBounds(908, 799, 117,29);
        userScreen.add(plus1Button);

        plus2Button = new JRadioButton("Actualizar Precio");
        plus2Button.setBounds(1051, 799, 117,29);
        userScreen.add(plus2Button);

        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////

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

        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////

        userInputNewBalance = new JTextField();
        userInputNewBalance.setBounds(284,843,884,29);
        userScreen.add(userInputNewBalance);

        ButtonGroup group = new ButtonGroup();
        group.add(addButton); group.add(removeButton); group.add(searchButton); group.add(modifyButton); group.add(plus1Button); group.add(plus2Button);

        acceptButton = new JButton("Ejecutar");
        acceptButton.setBounds(1194,843,117,29);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] xcdS = userInputNewBalance.getText().split("_");
                if (addButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 7){
                            InventarioSyO.insertarProducto(xcdS[0],xcdS[1],xcdS[2],Integer.parseInt(xcdS[3]),xcdS[4], Integer.parseInt(xcdS[5]), xcdS[6]);
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }

                if (removeButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 1){
                            InventarioSyO.eliminarProductos(Integer.parseInt(xcdS[0]));
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }

                if (searchButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 1){
                            InventarioSyO.busquedaXID(Integer.parseInt(xcdS[0]));
                            textD.setForeground(new Color(137, 234, 17));
                            textD.setText(String.valueOf(InventarioSyO.busquedaXID(Integer.parseInt(xcdS[0]))));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }

                if (modifyButton.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 4){
                            InventarioSyO.actualizarInventario(xcdS[0],xcdS[1], Integer.parseInt(xcdS[2]));
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }

                if (plus1Button.isSelected()){
                    if(userInputNewBalance.getText().equals("")){
                        textD.setForeground(new Color(253, 52, 59));
                        textD.setText("No hay nada que procesar.");
                    }else{
                        if(xcdS.length == 2){
                            InventarioSyO.actualizarStock(Integer.parseInt(xcdS[0]),Integer.parseInt(xcdS[1]));
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }

                if (plus2Button.isSelected()){
                    if(userInputNewBalance.getText().equals("")){

                    }else{
                        if(xcdS.length == 2){
                            InventarioSyO.actualizarPrecio(Integer.parseInt(xcdS[0]),Integer.parseInt(xcdS[1]));
                            textD.setForeground(new Color(137, 234, 17));
                            ventanaCliente();
                        }else{
                            textD.setForeground(new Color(253, 52, 59));
                            textD.setText("Ingresa correctamente una sentencia por favor!");
                        }
                    }
                }
            }
        });
        userScreen.add(acceptButton);

        exam = new Style(2); //CAMBIAR COLORES SEGUN SEYTU o OMNILIFE
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);

        textE = new JLabel("[Ingresar Producto] NomProducto_Descripcion_Presentacion_Precio_Contenido_Stock_Marca\n" +
                "[Eliminar Producto] idProducto\n" +
                "[Buscar Producto] nombreTablaID\n" +
                "[Actualizar Inventario] nombreColumna_datoNuevo_id\n" +
                "[Actualizar Stock] nuevoStock_idProducto\n" +
                "[Actualizar precio] precioNuevo_idPrecio\n" +
                "[Actualizar NIP] nombreTabla_nombreColumna_nuevoNIP_id \n");
        textE.setBounds(284,877,884,29);
        userScreen.add(textE);


        this.repaint();
    }

    public void ventanaCat1(){
        userScreen.removeAll();
        // TIENES QUE CAMBIAR ESTO
        String[] cnClient = {"ID_Categoria", "Nombre_Categoria"};
        Object[][] dataB = (Object[][]) createMatrixCategorySt(); //Modificar
        inventoryTable = new JTable(dataB,cnClient);
        inventoryTable.setBounds(284, 229, 1027, 556);
        userScreen.add(inventoryTable);

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
                                       });
        userScreen.add(logoutButton);

        exam = new Style(2); //CAMBIAR COLORES SEGUN SEYTU o OMNILIFE
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);

        this.repaint();
    }

    public void ventanaCat2(){
        userScreen.removeAll();
        // TIENES QUE CAMBIAR ESTO
        String[] cnClient = {"ID_Categoria", "Nombre_Categoria"};
        Object[][] dataB = (Object[][]) createMatrixCategoryOm(); //Modificar
        inventoryTable = new JTable(dataB,cnClient);
        inventoryTable.setBounds(284, 229, 1027, 556);
        userScreen.add(inventoryTable);

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
        });
        userScreen.add(logoutButton);

        exam = new Style(2); //CAMBIAR COLORES SEGUN SEYTU o OMNILIFE
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);

        this.repaint();
    }

    public void ventanaCat3(){
        userScreen.removeAll();
        // TIENES QUE CAMBIAR ESTO
        String[] cnClient = {"ID_Categoria", "Nombre_Categoria", "Compras_Requeridas"};
        Object[][] dataB = (Object[][]) createMatrixCategoryClient(); //Modificar
        inventoryTable = new JTable(dataB,cnClient);
        inventoryTable.setBounds(284, 229, 1027, 556);
        userScreen.add(inventoryTable);

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
        });
        userScreen.add(logoutButton);

        exam = new Style(2); //CAMBIAR COLORES SEGUN SEYTU o OMNILIFE
        exam.setBounds(0,0, width, height);
        userScreen.add(exam);

        this.repaint();
    }

    public void ventanaCat4(){
        userScreen.removeAll();
        // TIENES QUE CAMBIAR ESTO
        String[] cnClient = {"ID_Descuento", "Tipo_Descuento", "Ventas_Requeridas"};
        Object[][] dataB = (Object[][]) createMatrixDescuentos(); //Modificar
        inventoryTable = new JTable(dataB,cnClient);
        inventoryTable.setBounds(284, 229, 1027, 556);
        userScreen.add(inventoryTable);

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
        });
        userScreen.add(logoutButton);

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