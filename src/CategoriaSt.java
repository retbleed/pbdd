import Connector.MYSQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoriaSt extends Categoria {

    public CategoriaSt(int idCategoria, String nombreCategoria) {
        super(idCategoria, nombreCategoria);
    }

    public static ArrayList<CategoriaSt> listaCategoriasSt() {
        ArrayList<CategoriaSt> lista = new ArrayList<CategoriaSt>();
        Connection con = MYSQLConnection.connect();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String consulta = "SELECT * FROM categoriaSt";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                lista.add(new CategoriaSt(
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
}
