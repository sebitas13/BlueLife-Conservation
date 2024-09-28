/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Connection.Conexion;
import dto.VentaDTO;
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
public class VentaDAO {
    private String mensaje = "";

    public String agregarVenta(VentaDTO ven) {
        String sql = "INSERT INTO VENTA VALUES(VENTA_SEQ.NEXTVAL,?,?,?,?,?)"; 
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, ven.getNumerocaptura());
            pst.setLong(2, ven.getRuc());
            pst.setInt(3, ven.getIdespecie());
            pst.setInt(4, ven.getIdmercado());
            pst.setFloat(5, ven.getCantidadvendida());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) { 
            mensaje = "NO SE PUDO GUARDAR CORRECTAMENTE: " + e.getMessage();
        } 
        return mensaje;
    }

    public String modificarVenta(VentaDTO ven) {
        String sql = "UPDATE VENTA SET NUMEROCAPTURA = ?, RUC = ?, IDESPECIE = ?, IDMERCADO = ?, CANTIDADVENDIDA = ? WHERE IDVENTA = ?"; 
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, ven.getNumerocaptura());
            pst.setLong(2, ven.getRuc());
            pst.setInt(3, ven.getIdespecie());
            pst.setInt(4, ven.getIdmercado());
            pst.setFloat(5, ven.getCantidadvendida());
            pst.setInt(6, ven.getIdventa());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) { 
            mensaje = "NO SE PUDO MODIFICAR: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarVenta(int idventa) {
        String sql = "DELETE FROM VENTA WHERE IDVENTA = ?"; 
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idventa);
            mensaje = "ELIMINADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) { 
            mensaje = "NO SE PUDO ELIMINAR: " + e.getMessage();
        }
        return mensaje;
    }

    public void listarVenta(JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"Id Venta", "Num Captura", "RUC", "Id Especie", "Id Mercado", "Cantidad Vendida"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM VENTA ORDER BY IDVENTA";
        String[] filas = new String[6];

        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }
    }

    public VentaDTO buscarVentaPorNumeroCaptura(int numerocaptura) {
        VentaDTO ve = new VentaDTO();
        String sql = "SELECT * FROM VENTA WHERE NUMEROCAPTURA = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, numerocaptura);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ve.setIdventa(rs.getInt(1));
                ve.setNumerocaptura(rs.getInt(2));
                ve.setRuc(rs.getLong(3));
                ve.setIdespecie(rs.getInt(4));
                ve.setIdmercado(rs.getInt(5));
            ve.setCantidadvendida(rs.getFloat(6)); // Asegúrate de que el tipo coincida
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONSULTA " + e.getMessage());
        }
        return ve;
    } 
    
    public VentaDTO buscarVenta(int idVenta) {
        VentaDTO ve = new VentaDTO();
        String sql = "SELECT * FROM VENTA WHERE IDVENTA = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idVenta);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ve.setIdventa(rs.getInt(1));
                ve.setNumerocaptura(rs.getInt(2));
                ve.setRuc(rs.getLong(3));
                ve.setIdespecie(rs.getInt(4));
                ve.setIdmercado(rs.getInt(5));
            ve.setCantidadvendida(rs.getFloat(6)); // Asegúrate de que el tipo coincida
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONSULTA " + e.getMessage());
        }
        return ve;
    } 
}

