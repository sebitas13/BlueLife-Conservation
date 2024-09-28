/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Connection.Conexion;
import dto.CapturaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class CapturaDAO {

    private String mensaje = "";

    public CapturaDAO() {

    }

    public String agregarCaptura(CapturaDTO cap) {

        String sql = "INSERT INTO CAPTURA VALUES(CAPTURA_SEQ.NEXTVAL,?,?,?,?)";
        try (Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setLong(1, cap.getRuc());
            pst.setInt(2, cap.getIdespecie());
            pst.setDate(3, new java.sql.Date(cap.getFecha().getTime()));
            pst.setFloat(4, cap.getCantidadporcaptura());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) {
            mensaje = "NO SE PUDO GUARDAR CORRECTAMENTE: " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarCaptura(CapturaDTO cap) {

        String sql = "UPDATE CAPTURA SET RUC = ?, IDESPECIE = ?, FECHA = ?, CANTIDADPORCAPTURA = ?"
                + "WHERE NUMEROCAPTURA = ?";
        try (Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setLong(1, cap.getRuc());
            pst.setInt(2, cap.getIdespecie());
            pst.setDate(3, new java.sql.Date(cap.getFecha().getTime()));
            pst.setFloat(4, cap.getCantidadporcaptura());
            pst.setInt(5, cap.getNumerocaptura());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) {
            mensaje = "NO SE PUDO MODIFICAR: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarCaptura(int numerocaptura) {

        String sql = "DELETE FROM CAPTURA WHERE NUMEROCAPTURA = ?";

        try (Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, numerocaptura);
            mensaje = "ELIMINADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) {
            mensaje = "NO SE PUDO ELIMINAR: " + e.getMessage();
        }
        return mensaje;
    }

    public void listarCaptura(JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"Num Captura", "RUC", "Id Especie", "Fecha", "Cantidad Capturada"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM CAPTURA ORDER BY NUMEROCAPTURA";

        String[] filas = new String[5];
      
        try (Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < 5; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }

    }

    public void listarCaptura(JTable tabla, int idespecie){
        DefaultTableModel model;
        String[] columnas = {"Num Captura", "RUC", "Id Especie", "Fecha", "Cantidad Capturada"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM CAPTURA WHERE IDESPECIE = ?";

        try (Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql);) {
       
            pst.setInt(1, idespecie);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String[] filas = new String[5];
                    for (int i = 0; i < 5; i++) {
                        filas[i] = rs.getString(i + 1);
                        System.out.println(filas[i]); // Depuración
                    }
                    model.addRow(filas);
                }
            }
            tabla.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla: " + e.getMessage());
        }

    }

    public CapturaDTO buscarCaptura(int numerocaptura) {
        CapturaDTO c = new CapturaDTO();
        String sql = "SELECT * FROM CAPTURA WHERE NUMEROCAPTURA = ?";

        try (Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, numerocaptura);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                c.setNumerocaptura(rs.getInt(1));
                c.setRuc(rs.getLong(2));
                c.setIdespecie(rs.getInt(3));
                c.setFecha(rs.getDate(4));
                c.setCantidadporcaptura(rs.getFloat(5));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONSULTA " + e.getMessage());

        }

        return c;
    }

    public void listarEspecie(JComboBox id_especies) {

        String sql = "SELECT IDESPECIE||'-'||NOMBRE as ID_ESPECIE_NOMBRE FROM ESPECIE ORDER BY IDESPECIE";

        try (Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            if (con == null || con.isClosed()) {
                throw new SQLException("La conexión no está abierta o es nula");
            }

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                for (int i = 0; i < 1; i++) {
                    id_especies.addItem(rs.getString(i + 1));

                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se puede mostrar id_categorias : " + ex.getMessage());
        }

    }

    public void listarRUC(JComboBox id_ruc) {

        String sql = "SELECT RUC||'-'||RAZONSOCIAL as ID_RUC_NOMBRE FROM EMPRESA ORDER BY RUC";

        try (Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                for (int i = 0; i < 1; i++) {
                    id_ruc.addItem(rs.getString(i + 1));

                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar id_RUC");
        }

    }
}
