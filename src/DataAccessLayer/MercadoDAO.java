/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Connection.Conexion;
import dto.MercadoDTO;
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
public class MercadoDAO {
    private String mensaje = "";

    public String agregarMercado(MercadoDTO mer) {
        String sql = "INSERT INTO MERCADO VALUES(?,?,?)"; 
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
             
            pst.setLong(1, mer.getMercado());
            pst.setInt(2, mer.getTipomercado());
            pst.setString(3, mer.getNombremercado());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
        } catch (SQLException e) { 
            mensaje = "NO SE PUDO GUARDAR CORRECTAMENTE: " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarMercado(MercadoDTO mer) {
        String sql = "UPDATE MERCADO SET IDTIPOMERCADO = ?, NOMBREMERCADO = ? WHERE IDMERCADO = ?"; 
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
             
            pst.setInt(1, mer.getTipomercado());
            pst.setString(2, mer.getNombremercado());
            pst.setInt(3, mer.getMercado());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
        } catch (SQLException e) { 
            mensaje = "NO SE PUDO MODIFICAR: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarMercado(int mercado) {
        String sql = "DELETE FROM MERCADO WHERE IDMERCADO = ?"; 
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
             
            pst.setInt(1, mercado);
            mensaje = "ELIMINADO CORRECTAMENTE";
            pst.execute();
        } catch (SQLException e) { 
            mensaje = "NO SE PUDO ELIMINAR: " + e.getMessage();
        }
        return mensaje;
    }

    public void listarMercado(JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"Id Mercado", "Id Tipo de Mercado", "Nombre"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT * FROM MERCADO ORDER BY IDMERCADO";

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

    public MercadoDTO buscarMercado(int mercado) {
        MercadoDTO me = new MercadoDTO();
        String sql = "SELECT * FROM MERCADO WHERE IDMERCADO = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
             
            pst.setInt(1, mercado);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                me.setMercado(rs.getInt(1));
                me.setTipomercado(rs.getInt(2));
                me.setNombremercado(rs.getString(3));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONSULTA " + e.getMessage());
        }
        return me;
    }
}

