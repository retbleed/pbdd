import Connector.MYSQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class CategoriaOm extends Categoria{

    public CategoriaOm(int idCategoria, String nombreCategoria) {
        super(idCategoria, nombreCategoria);
    }

    public static ArrayList<CategoriaOm> listaCategoriasOm() {
        ArrayList<CategoriaOm> lista = new ArrayList<CategoriaOm>();
        Connection con = MYSQLConnection.connect();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String consulta = "SELECT * FROM categoriaOm";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                lista.add(new CategoriaOm(
                        rs.getInt("idCategoria"),
                        rs.getString("nombreCategoria")
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

    /*public static String[] arregloCategorias(CategoriaOm co) {
        String[] arreglo = new String[2];
        arreglo[0] = String.valueOf(co.getIdCategoria());
        arreglo[1] = String.valueOf(co.getNombreCategoria());
        return  arreglo;
    }*/
}
