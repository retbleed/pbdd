import Connector.MYSQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoriaCliente extends Categoria {

    public int comprasRequeridas;

    public CategoriaCliente(int idCategoria, String nombreCategoria, int comprasRequeridas) {
        super(idCategoria, nombreCategoria);
        this.comprasRequeridas = comprasRequeridas;
    }

    public static ArrayList<CategoriaCliente> listaCategoriasClientes() {
        ArrayList<CategoriaCliente> lista = new ArrayList<CategoriaCliente>();
        Connection con = MYSQLConnection.connect();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String consulta = "SELECT * FROM categoriaClientes";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                lista.add(new CategoriaCliente(
                        rs.getInt("idCategoria"),
                        rs.getString("nombreCategoria"),
                        rs.getInt("comprasRequeridas")
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

    public static String[] arregloCategorias(CategoriaCliente cc) {
        String[] arreglo = new String[3];
        arreglo[0] = String.valueOf(cc.getIdCategoria());
        arreglo[1] = cc.getNombreCategoria();
        arreglo[2] = String.valueOf(cc.getComprasRequeridas());
        return arreglo;
    }

    public int getComprasRequeridas() {
        return comprasRequeridas;
    }

    @Override
    public String toString() {
        return "CategoriaCliente{" +
                "comprasRequeridas=" + comprasRequeridas +
                ", idCategoria=" + idCategoria +
                ", nombreCategoria='" + nombreCategoria + '\'' +
                '}';
    }
}
