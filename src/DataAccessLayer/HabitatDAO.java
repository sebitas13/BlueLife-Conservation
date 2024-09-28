/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Connection.Conexion;
import dto.HabitatDTO;
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
public class HabitatDAO {
    private String mensaje = "";

    public String agregarHabitat(HabitatDTO hab) {
        String sql = "INSERT INTO HABITAT VALUES(HABITAT_SEQ.NEXTVAL, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, hab.getNombre());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) {
            mensaje = "NO SE PUDO GUARDAR CORRECTAMENTE: " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarHabitat(HabitatDTO hab) {
        String sql = "UPDATE HABITAT SET NOMBRE = ? WHERE IDHABITAT = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, hab.getNombre());
            pst.setInt(2, hab.getIdhabitat());
            mensaje = "ACTUALIZADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) {
            mensaje = "NO SE PUDO MODIFICAR: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarHabitat(int idhabitat) {
        String sql = "DELETE FROM HABITAT WHERE IDHABITAT = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idhabitat);
            mensaje = "ELIMINADO CORRECTAMENTE";
            pst.execute();

        } catch (SQLException e) {
            mensaje = "NO SE PUDO ELIMINAR: " + e.getMessage();
        }
        return mensaje;
    }

    public void listarHabitat(JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"Id Habitat", "Nombre"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM HABITAT ORDER BY IDHABITAT";

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

    public HabitatDTO buscarHabitat(int idhabitat) {
        HabitatDTO ha = new HabitatDTO();
        String sql = "SELECT * FROM HABITAT WHERE IDHABITAT = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idhabitat);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ha.setIdhabitat(rs.getInt(1));
                ha.setNombre(rs.getString(2));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONSULTA " + e.getMessage());
        }
        return ha;
    }
}
