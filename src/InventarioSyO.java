import Connector.MYSQLConnection;

import java.sql.*;
import java.util.ArrayList;

public class InventarioSyO {
    public int idProducto;
    public String nomProducto;
    public String descripcion;
    public String presentacion;
    public Float precio;
    public String contenido;
    public int stock;
    public String marca;

    public InventarioSyO(int idProducto, String nomProducto, String descripcion, String presentacion, Float precio, String contenido, int stock, String marca) {
        this.idProducto = idProducto;
        this.nomProducto = nomProducto;
        this.descripcion = descripcion;
        this.presentacion = presentacion;
        this.precio = precio;
        this.contenido = contenido;
        this.stock = stock;
        this.marca = marca;
    }

    public static ArrayList<InventarioSyO> listaInventario() {
        ArrayList<InventarioSyO> inventario = new ArrayList<InventarioSyO>();
        Connection con = MYSQLConnection.connect();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String consulta = "SELECT * FROM inventarioSyO";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                inventario.add(new InventarioSyO(
                        rs.getInt("idProducto"),
                        rs.getString("nomProducto"),
                        rs.getString("descripcion"),
                        rs.getString("presentacion"),
                        rs.getFloat("precio"),
                        rs.getString("contenido"),
                        rs.getInt("stock"),
                        rs.getString("marca")
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
        return inventario;
    }

    public static void insertarProducto(String nomProducto, String descripcion, String presentacion, float precio, String contenido, int stock, String marca) {
        Connection con = MYSQLConnection.connect();
        CallableStatement cst = null;
        try {
            cst = con.prepareCall("{call spInsertarProducto(?, ?, ?, ?, ?, ?, ?)}");
            //String consulta = "call spInsertarProducto(" + nomProducto + ", " + descripcion + ", " + presentacion + ", " + precio + ", " + contenido + ", " + stock + ", " + marca + ")";
            cst.setString(1, nomProducto);
            cst.setString(2, descripcion);
            cst.setString(3, presentacion);
            cst.setFloat(4, precio);
            cst.setString(5, contenido);
            cst.setInt(6, stock);
            cst.setString(7, marca);
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

    public static InventarioSyO busquedaXID(int id) {
        InventarioSyO item = null;
        Connection con = MYSQLConnection.connect();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String consulta = "SELECT * FROM inventarioSyO WHERE idProducto = " + id + " LIMIT 1";
            rs = st.executeQuery(consulta);
            if (rs.next()) {
                item = new InventarioSyO(
                        rs.getInt("idProducto"),
                        rs.getString("nomProducto"),
                        rs.getString("descripcion"),
                        rs.getString("presentacion"),
                        rs.getFloat("precio"),
                        rs.getString("contenido"),
                        rs.getInt("stock"),
                        rs.getString("marca")
                );
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
        return item;
    }

    public static void eliminarProductos(int id) {
        Connection con = MYSQLConnection.connect();
        CallableStatement cst = null;
        try {
            cst = con.prepareCall("{call spEliminarProducto(?)}");
            cst.setInt(1, id);
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

    public static String actualizarInventario(String nombreColumna, String datoNuevo, int idProducto) {
        String resultado = "";
        Connection con = MYSQLConnection.connect();
        CallableStatement cst = null;
        try {
            cst = con.prepareCall("{call spActualizarDatosInventario(?, ?, ?)}");
            cst.setString(1, nombreColumna);
            cst.setString(2, datoNuevo);
            cst.setInt(3, idProducto);
            cst.execute();
            resultado = "DATOS ACTUALIZADOS";
        } catch (SQLException ex) {
            resultado = "ERROR";
            ex.printStackTrace();
        } finally {
            try {
                con.close();
                cst.close();
            } catch (SQLException ex) {
                resultado = "ERROR";
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    public static void actualizarStock(float stockNuevo, int idProducto) {
        Connection con = MYSQLConnection.connect();
        CallableStatement cst = null;
        try {
            cst = con.prepareCall("{call spActualizarStocks(?, ?)}");
            cst.setFloat(1, stockNuevo);
            cst.setInt(2, idProducto);
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

    public static void actualizarPrecio(float precioNuevo, int idProducto) {
        Connection con = MYSQLConnection.connect();
        CallableStatement cst = null;
        try {
            cst = con.prepareCall("{call spActualizarPrecios(?, ?)}");
            cst.setFloat(1, precioNuevo);
            cst.setInt(2, idProducto);
            cst.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                con.close();
                cst.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String[] arregloInventario(InventarioSyO item) {
        String[] arreglo = new String[8];
        arreglo[0] = String.valueOf(item.getIdProducto());
        arreglo[1] = item.getNomProducto();
        arreglo[2] = item.getDescripcion();
        arreglo[3] = item.getPresentacion();
        arreglo[4] = String.valueOf(item.getPrecio());
        arreglo[5] = item.getContenido();
        arreglo[6] = String.valueOf(item.getStock());
        arreglo[7] = item.getMarca();
        return  arreglo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public Float getPrecio() {
        return precio;
    }

    public String getContenido() {
        return contenido;
    }

    public int getStock() {
        return stock;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "InventarioSyO{" +
                "idProducto=" + idProducto +
                ", nomProducto='" + nomProducto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", presentacion='" + presentacion + '\'' +
                ", precio=" + precio +
                ", contenido='" + contenido + '\'' +
                ", stock=" + stock +
                ", marca='" + marca + '\'' +
                '}';
    }
}