/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Connection.Conexion;
import dto.ExplotacionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class ExplotacionDAO {
     private String mensaje = "";

    public String agregarExplotacion(ExplotacionDTO exp) {
        String sql = "INSERT INTO EXPLOTACION VALUES(?,?,?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, exp.getIdespecie());
            pst.setInt(2, exp.getIdestado());
            pst.setInt(3, exp.getCantidadacumulada());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) {
            mensaje = "NO SE PUDO GUARDAR CORRECTAMENTE: " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarExplotacion(ExplotacionDTO exp) {
        String sql = "UPDATE EXPLOTACION SET IDESTADO = ?, CANTIDADACUMULADA = ? WHERE IDESPECIE = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, exp.getIdestado());
            pst.setInt(2, exp.getCantidadacumulada());
            pst.setInt(3, exp.getIdespecie());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) {
            mensaje = "NO SE PUDO MODIFICAR: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarExplotacion(int idespecie) {
        String sql = "DELETE FROM EXPLOTACION WHERE IDESPECIE = ?";
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

    public void listarExplotacion(JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"Id Especie", "Id Estado", "Cantidad Explotada Actualmente"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM EXPLOTACION ORDER BY IDESPECIE";
        String[] filas = new String[3];

        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                for (int i = 0; i < 3; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }
    }

    public ExplotacionDTO buscarExplotacion(int idespecie) {
        ExplotacionDTO ex = new ExplotacionDTO();
        String sql = "SELECT * FROM EXPLOTACION WHERE IDESPECIE = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idespecie);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ex.setIdespecie(rs.getInt(1));
                ex.setIdestado(rs.getInt(2));
                ex.setCantidadacumulada(rs.getInt(3));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONSULTA " + e.getMessage());
        }
        return ex;
    }
}
