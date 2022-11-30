import Connector.MYSQLConnection;

import java.sql.*;
import java.util.ArrayList;

public class Cliente {
    public int idCliente;
    public String nomCliente;
    public String correoCliente;
    public String fNacCliente;
    public int edadCliente;
    public String celularCliente;
    public String invCliente;
    private int nipCliente;
    public String fechaCliente;
    public String tarjetaCliente;

    public Cliente(int idCliente, String nomCliente, String correoCliente, String fNacCliente, int edadCliente, String celularCliente, String invCliente, int nipCliente, String fechaCliente, String tarjetaCliente) {
        this.idCliente = idCliente;
        this.nomCliente = nomCliente;
        this.correoCliente = correoCliente;
        this.fNacCliente = fNacCliente;
        this.edadCliente = edadCliente;
        this.celularCliente = celularCliente;
        this.invCliente = invCliente;
        this.nipCliente = nipCliente;
        this.fechaCliente = fechaCliente;
        this.tarjetaCliente = tarjetaCliente;
    }

    public static ArrayList<Cliente> listaCliente() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Connection con = MYSQLConnection.connect();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String consulta = "SELECT * FROM clientes";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                clientes.add(new Cliente(
                        rs.getInt("ID_Cliente"),
                        rs.getString("nom_Cliente"),
                        rs.getString("correo_Cliente"),
                        rs.getString("fNac_Cliente"),
                        rs.getInt("edad_Cliente"),
                        rs.getString("celular_Cliente"),
                        rs.getString("inv_Cliente"),
                        rs.getInt("nip_Cliente"),
                        rs.getString("fecha_Registro"),
                        rs.getString("tarjeta_Cliente")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
                st.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return clientes;
    }

    public static void insertarCliente(String nomCliente, String correoCliente, String fNacCliente, int edadCliente, String celularCliente, String invCliente, int nipCliente, String fechaCliente, String tarjetaCliente) {
        Connection con = MYSQLConnection.connect();
        CallableStatement cst = null;
        try {
            cst = con.prepareCall("{call spInsertarClientes(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cst.setString(1, nomCliente);
            cst.setString(2, correoCliente);
            cst.setString(3, fNacCliente);
            cst.setInt(4, edadCliente);
            cst.setString(5, celularCliente);
            cst.setString(6, invCliente);
            cst.setInt(7, nipCliente);
            cst.setString(8, fechaCliente);
            cst.setString(9, tarjetaCliente);
            cst.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
                cst.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void eliminarCliente(int idCliente) {
        Connection con = MYSQLConnection.connect();
        CallableStatement cst = null;
        try {
            cst = con.prepareCall("{call spEliminarClientes(?)}");
            cst.setInt(1, idCliente);
            cst.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
                cst.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public String getfNacCliente() {
        return fNacCliente;
    }

    public int getEdadCliente() {
        return edadCliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public String getInvCliente() {
        return invCliente;
    }

    public int getNipCliente() {
        return nipCliente;
    }

    public String getFechaCliente() {
        return fechaCliente;
    }

    public String getTarjetaCliente() {
        return tarjetaCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nomCliente='" + nomCliente + '\'' +
                ", correoCliente='" + correoCliente + '\'' +
                ", fNacCliente='" + fNacCliente + '\'' +
                ", edadCliente=" + edadCliente +
                ", celularCliente='" + celularCliente + '\'' +
                ", invCliente='" + invCliente + '\'' +
                ", nipCliente=" + nipCliente +
                ", fechaCliente='" + fechaCliente + '\'' +
                ", tarjetaCliente='" + tarjetaCliente + '\'' +
                '}';
    }
}