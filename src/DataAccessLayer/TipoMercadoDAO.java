/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

/**
 *
 * @author USUARIO
 */
import Connection.Conexion;
import dto.TipoMercadoDTO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class TipoMercadoDAO {
    private String mensaje = "";

    public String agregarTipoMercado(TipoMercadoDTO tip) {
        String sql = "INSERT INTO TIPOMERCADO VALUES(?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, tip.getIdtipomercado());
            pst.setString(2, tip.getTipo());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) {
            mensaje = "NO SE PUDO GUARDAR CORRECTAMENTE: " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarTipoMercado(TipoMercadoDTO tip) {
        String sql = "UPDATE TIPOMERCADO SET TIPO = ? WHERE IDTIPOMERCADO = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, tip.getTipo());
            pst.setInt(2, tip.getIdtipomercado());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) {
            mensaje = "NO SE PUDO MODIFICAR: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarTipoMercado(int idtipomercado) {
        String sql = "DELETE FROM TIPOMERCADO WHERE IDTIPOMERCADO = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idtipomercado);
            mensaje = "ELIMINADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) {
            mensaje = "NO SE PUDO ELIMINAR: " + e.getMessage();
        }
        return mensaje;
    }

    public void listarTipoMercado(JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"Id Tipo de Mercado", "Tipo de Mercado"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT * FROM TIPOMERCADO ORDER BY IDTIPOMERCADO";
        String[] filas = new String[2];

        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                for (int i = 0; i < 2; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }
    }

    public TipoMercadoDTO buscarTipoMercado(int idtipomercado) {
        TipoMercadoDTO ti = new TipoMercadoDTO();
        String sql = "SELECT * FROM TIPOMERCADO WHERE IDTIPOMERCADO = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idtipomercado);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ti.setIdtipomercado(rs.getInt(1));
                ti.setTipo(rs.getString(2));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONSULTA " + e.getMessage());
        }
        return ti;
    }
}
