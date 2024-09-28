/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Connection.Conexion;
import dto.EstadoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class EstadoDAO {
   private String mensaje="";
    
    public String agregarEstado(EstadoDTO est){
       
        String sql = "INSERT INTO CAPTURA VALUES(?,?)"; 
        try(Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)){
            
            pst.setInt(1, est.getIdestado());
            pst.setString(2, est.getNombre());
            mensaje= "GUARDADO CORRECTAMENTE";
            pst.execute();
       ;

        }catch(SQLException e){ 
            mensaje="NO SE PUDO GUARDAR CORRECTAMENTE: "+e.getMessage();
        } 
        return mensaje;
    }
    
    public String modificarEstado(EstadoDTO est){
        
        String sql = "UPDATE ESTADO SET NOMBRE = ?"
                + "WHERE IDESTADO = ?"; 
        try(Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)){
            
            pst.setString(1, est.getNombre());
            pst.setInt(2, est.getIdestado());
            mensaje= "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
          

        }catch(SQLException e){ 
            mensaje="NO SE PUDO MODIFICAR: "+e.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarEstado(int idestado){
        
        String sql = "DELETE FROM ESTADO WHERE IDESTADO = ?"; 
        try(Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)){
          
            pst.setInt(1, idestado);
            mensaje= "ELIMINADO CORRECTAMENTE";
            pst.execute();
      

        }catch(SQLException e){ 
            mensaje="NO SE PUDO ELIMINAR: "+e.getMessage();
        }
        return mensaje;
    }
    
    public void listarEstado( JTable tabla){
        DefaultTableModel model;
        String [] columnas = {"Id Estado","Nombre"};
        model = new DefaultTableModel(null, columnas);
                
        String sql = "SELECT * FROM ESTADO ORDER BY IDESTADO";
        
        String [] filas = new String[2];
 
        
        try(Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)){
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                for(int i = 0; i < 2; i++){
                    filas[i] = rs.getString(i+1);
                }
                model.addRow(filas);
            }
        tabla.setModel(model);    
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }
        
    }
    
    public EstadoDTO buscarEstado( int idestado){
        EstadoDTO esta = new EstadoDTO();
        String sql = "SELECT * FROM ESTADO WHERE IDESTADO = ?";
       
        try (Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)){
         
            pst.setInt(1, idestado);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                esta.setIdestado(rs.getInt(1));
                esta.setNombre(rs.getString(2));
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "ERROR EN LA CONSULTA "+ e.getMessage());
            
        }
        return esta;
    } 
}
