/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Connection.Conexion;
import dto.EspecieDTO;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.stream.Stream;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class EspecieDAO {

    private String mensaje = "";

    public String agregarEspecie(EspecieDTO esp) {

        String sql = "INSERT INTO ESPECIE VALUES(ESPECIE_SEQ.NEXTVAL,?,?,?)";
        try (Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, esp.getIdcategoria());
            pst.setInt(2, esp.getIdhabitat());
            pst.setString(3, esp.getNombre());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) {
            mensaje = "NO SE PUDO GUARDAR CORRECTAMENTE: " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarEspecie(EspecieDTO esp) {

        String sql = "UPDATE ESPECIE SET IDCATEGORIA = ?, IDHABITAT = ?, NOMBRE = ?"
                + "WHERE IDESPECIE = ?";
        try (Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setLong(1, esp.getIdcategoria());
            pst.setInt(2, esp.getIdhabitat());
            pst.setString(3, esp.getNombre());
            pst.setInt(4, esp.getIdespecie());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) {
            mensaje = "NO SE PUDO MODIFICAR: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarEspecie(int idespecie) {

        String sql = "DELETE FROM ESPECIE WHERE IDESPECIE = ?";
        try (Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idespecie);
            mensaje = "ELIMINADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) {
            mensaje = "NO SE PUDO ELIMINAR: " + e.getMessage();
        }
        return mensaje;
    }

    public void listarEspecie(JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"Id Especie", "Id Categoria", "Id Habitat", "Nombre"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM ESPECIE ORDER BY IDESPECIE";

        String[] filas = new String[4];

        try (Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 4; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }

    }

    public EspecieDTO buscarEspecie(int idespecie) {
        EspecieDTO es = new EspecieDTO();
        String sql = "SELECT * FROM ESPECIE WHERE IDESPECIE = ?";

        try (Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idespecie);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                es.setIdespecie(rs.getInt(1));
                es.setIdcategoria(rs.getInt(2));
                es.setIdhabitat(rs.getInt(3));
                es.setNombre(rs.getString(4));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONSULTA " + e.getMessage());

        }
        return es;
    }

    public void verificarDisponibilidad(String nombreespecie) throws SQLException {
        PreparedStatement s;
        try (Connection con = Conexion.getConnection();) {
            s = con.prepareStatement("begin dbms_output.enable(); end;");
            s.execute();
            s = con.prepareStatement("begin verificarDisponibilidad(?); end;");
            s.setString(1, nombreespecie);
            s.execute();
            try (CallableStatement call = con.prepareCall(
                    "declare "
                    + "  num integer := 1000;"
                    + "begin "
                    + "  dbms_output.get_lines(?, num);"
                    + "end;"
            )) {
                call.registerOutParameter(1, Types.ARRAY,
                        "DBMSOUTPUT_LINESARRAY");
                call.execute();

                Array array = null;
                try {
                    array = call.getArray(1);
                    Stream.of((Object[]) array.getArray())
                            .forEach(x -> JOptionPane.showMessageDialog(null, x));
                } finally {
                    if (array != null) {
                        array.free();
                    }
                }
            } finally {
                s.executeUpdate("begin dbms_output.disable(); end;");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void listarIDHabitat(JComboBox id_especies) {

        String sql = "SELECT IDHABITAT||'-'||NOMBRE as ID_HABITAT_NOMBRE FROM HABITAT ORDER BY IDHABITAT";

        try (Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 1; i++) {
                    id_especies.addItem(rs.getString(i + 1));
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar id_especies");
        }

    }

    public void listarIDCategoria(JComboBox id_especies) {

        String sql = "SELECT IDCATEGORIA||'-'||NOMBRE as ID_CATEGORIA_NOMBRE FROM CATEGORIA ORDER BY IDCATEGORIA";

        try (Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 1; i++) {
                    id_especies.addItem(rs.getString(i + 1));

                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar id_categorias");
        }

    }

}
