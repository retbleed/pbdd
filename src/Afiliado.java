import Connector.MYSQLConnection;

import java.sql.*;
import java.util.ArrayList;

public class Afiliado {
    public int idAfiliado;
    public String nomAfiliado;
    public String correoAfiliado;
    public String fNacAfiliado;
    public int edadAfiliado;
    public String celularAfiliado;
    public String invAfiliado;
    private int nipAfiliado;
    public String fechaAfilaicion;
    public String tarjetaAfiliado;

    public Afiliado(int idAfiliado, String nomAfiliado, String correoAfiliado, String fNacAfiliado, int edadAfiliado, String celularAfiliado, String invAfiliado, int nipAfiliado, String fechaAfilaicion, String tarjetaAfiliado) {
        this.idAfiliado = idAfiliado;
        this.nomAfiliado = nomAfiliado;
        this.correoAfiliado = correoAfiliado;
        this.fNacAfiliado = fNacAfiliado;
        this.edadAfiliado = edadAfiliado;
        this.celularAfiliado = celularAfiliado;
        this.invAfiliado = invAfiliado;
        this.nipAfiliado = nipAfiliado;
        this.fechaAfilaicion = fechaAfilaicion;
        this.tarjetaAfiliado = tarjetaAfiliado;
    }

    public static ArrayList<Afiliado> listaAfiliados() {
        ArrayList<Afiliado> afiliados = new ArrayList<Afiliado>();
        Connection con = MYSQLConnection.connect();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String consulta = "SELECT * FROM afiliados";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                afiliados.add(new Afiliado(
                        rs.getInt("ID_Afiliado"),
                        rs.getString("nom_Afiliado"),
                        rs.getString("correo_Afiliado"),
                        rs.getString("fNac_Afiliado"),
                        rs.getInt("edad_Afiliado"),
                        rs.getString("celular_Afiliado"),
                        rs.getString("inv_Afiliado"),
                        rs.getInt("nip_Afiliado"),
                        rs.getString("fecha_Afiliación"),
                        rs.getString("tarjeta_Afiliado")
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
        return afiliados;
    }

    public static void insetarAfiliado(String nomAfiliado, String correoAfiliado, String fNacAfiliado, int edadAfiliado, String celularAfiliado, String invAfiliado, int nipAfiliado, String fechaAfilaicion, String tarjetaAfiliado) {
        Connection con = MYSQLConnection.connect();
        CallableStatement cst = null;
        try {
            cst = con.prepareCall("{call spInsertarAfiliado(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cst.setString(1, nomAfiliado);
            cst.setString(2, correoAfiliado);
            cst.setString(3, fNacAfiliado);
            cst.setInt(4, edadAfiliado);
            cst.setString(5, celularAfiliado);
            cst.setString(6, invAfiliado);
            cst.setInt(7, nipAfiliado);
            cst.setString(8, fechaAfilaicion);
            cst.setString(9, tarjetaAfiliado);
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

    public static void eliminarAfiliado(int idAfiliado) {
        Connection con = MYSQLConnection.connect();
        CallableStatement cst = null;
        try {
            cst = con.prepareCall("{call spEliminaraAfiliado(?)}");
            cst.setInt(1, idAfiliado);
            cst.execute();
        }catch (SQLException ex) {
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

    public static void actualizarDatosNombresyCorreos(String nombreTabla, String nombreColumna, String datoNuevo, int id) {
        Connection con = MYSQLConnection.connect();
        CallableStatement cst = null;
        try {
            cst = con.prepareCall("{call spActualizarDatosNombresyCorreos(?, ?, ?, ?)}");
            cst.setString(1, nombreTabla);
            cst.setString(2, nombreColumna);
            cst.setString(3, datoNuevo);
            cst.setInt(4, id);
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

    public static void actualizarFechas(String nombreTabla, String nombreColumna, String datoNuevo, int id) {
        Connection con = MYSQLConnection.connect();
        CallableStatement cst = null;
        try {
            cst = con.prepareCall("{call spActualizarFechas(?, ?, ?, ?)}");
            cst.setString(1, nombreTabla);
            cst.setString(2, nombreColumna);
            cst.setString(3, datoNuevo);
            cst.setInt(4, id);
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

    public static void actualizarEdad(String nombreTabla, String nombreColumna, String datoNuevo, int id) {
        Connection con = MYSQLConnection.connect();
        CallableStatement cst = null;
        try {
            cst = con.prepareCall("{call spActualizarEdades(?, ?, ?, ?)}");
            cst.setString(1, nombreTabla);
            cst.setString(2, nombreColumna);
            cst.setString(3, datoNuevo);
            cst.setInt(4, id);
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

    public static String[] arregloAfiliados(Afiliado a) {
        String[] arreglo = new String[10];
        arreglo[0] = String.valueOf(a.getIdAfiliado());
        arreglo[1] = a.getNomAfiliado();
        arreglo[2] = a.getCorreoAfiliado();
        arreglo[3] = a.getfNacAfiliado();
        arreglo[4] = String.valueOf(a.getEdadAfiliado());
        arreglo[5] = a.getCelularAfiliado();
        arreglo[6] = a.getInvAfiliado();
        arreglo[7] = String.valueOf(a.getNipAfiliado());
        arreglo[8] = a.getFechaAfilaicion();
        arreglo[9] = a.getTarjetaAfiliado();
        return arreglo;
    }

    public static void actualizarNumCelular(String nombreTabla, String nombreColumna, String datoNuevo, int id) {
        Connection con = MYSQLConnection.connect();
        CallableStatement cst = null;
        try {
            cst = con.prepareCall("{call spActualizarNumCelular(?, ?, ?, ?)}");
            cst.setString(1, nombreTabla);
            cst.setString(2, nombreColumna);
            cst.setString(3, datoNuevo);
            cst.setInt(4, id);
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

    public static Afiliado busquedaXID(int id) {
        Afiliado a = null;
        Connection con = MYSQLConnection.connect();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String consulta = "SELECT * FROM Afiliados WHERE " + id + " = ID_Afiliado LIMIT 1";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                a = new Afiliado(
                        rs.getInt("ID_Afiliado"),
                        rs.getString("nom_Afiliado"),
                        rs.getString("correo_Afiliado"),
                        rs.getString("fNac_Afiliado"),
                        rs.getInt("edad_Afiliado"),
                        rs.getString("celular_Afiliado"),
                        rs.getString("inv_Afiliado"),
                        rs.getInt("nip_Afiliado"),
                        rs.getString("fecha_Afiliación"),
                        rs.getString("tarjeta_Afiliado")
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
        return a;
    }

    public static void actualizarNipTarjeta(String nombreTabla, String nombreColumna, String datoNuevo, int id) {
        Connection con = MYSQLConnection.connect();
        CallableStatement cst = null;
        try {
            cst = con.prepareCall("{call spActualizarTargetaNip(?, ?, ?, ?)}");
            cst.setString(1, nombreTabla);
            cst.setString(2, nombreColumna);
            cst.setString(3, datoNuevo);
            cst.setInt(4, id);
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

    public int getIdAfiliado() {
        return idAfiliado;
    }

    public String getNomAfiliado() {
        return nomAfiliado;
    }

    public String getCorreoAfiliado() {
        return correoAfiliado;
    }

    public String getfNacAfiliado() {
        return fNacAfiliado;
    }

    public int getEdadAfiliado() {
        return edadAfiliado;
    }

    public String getCelularAfiliado() {
        return celularAfiliado;
    }

    public String getInvAfiliado() {
        return invAfiliado;
    }

    public int getNipAfiliado() {
        return nipAfiliado;
    }

    public String getFechaAfilaicion() {
        return fechaAfilaicion;
    }

    public String getTarjetaAfiliado() {
        return tarjetaAfiliado;
    }

    @Override
    public String toString() {
        return "Afiliado{" +
                "idAfiliado=" + idAfiliado +
                ", nomAfiliado='" + nomAfiliado + '\'' +
                ", correoAfiliado='" + correoAfiliado + '\'' +
                ", fNacAfiliado='" + fNacAfiliado + '\'' +
                ", edadAfiliado=" + edadAfiliado +
                ", celularAfiliado='" + celularAfiliado + '\'' +
                ", invAfiliado='" + invAfiliado + '\'' +
                ", nipAfiliado=" + nipAfiliado +
                ", fechaAfilaicion='" + fechaAfilaicion + '\'' +
                ", tarjetaAfiliado='" + tarjetaAfiliado + '\'' +
                '}';
    }
}