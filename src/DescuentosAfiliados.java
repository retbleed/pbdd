import Connector.MYSQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DescuentosAfiliados {
    public int idDescuento;
    public String tipoDescuento;
    public int ventasRequeridas;

    public DescuentosAfiliados(int idDescuento, String tipoDescuento, int ventasRequeridas) {
        this.idDescuento = idDescuento;
        this.tipoDescuento = tipoDescuento;
        this.ventasRequeridas = ventasRequeridas;
    }

    public static ArrayList<DescuentosAfiliados> listaDescuentos() {
        ArrayList<DescuentosAfiliados> lista = new ArrayList<DescuentosAfiliados>();
        Connection con = MYSQLConnection.connect();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String consulta = "SELECT * FROM descuentoAfiliados";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                lista.add(new DescuentosAfiliados(
                        rs.getInt("idDescuento"),
                        rs.getString("tipoDescuento"),
                        rs.getInt("ventasRequeridas")
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
        return lista;
    }

    public static String[] arregloDescuento(DescuentosAfiliados da) {
        String[] arreglo = new String[3];
        arreglo[0] = String.valueOf(da.getIdDescuento());
        arreglo[1] = da.getTipoDescuento();
        arreglo[2] = String.valueOf(da.getVentasRequeridas());
        return  arreglo;
    }

    public int getIdDescuento() {
        return idDescuento;
    }

    public String getTipoDescuento() {
        return tipoDescuento;
    }

    public int getVentasRequeridas() {
        return ventasRequeridas;
    }
}
