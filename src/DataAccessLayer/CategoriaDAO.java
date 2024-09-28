/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Connection.Conexion;
import dto.CategoriaDTO;
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
public class CategoriaDAO {
    private String mensaje="";
    
    public String agregarCategoria(CategoriaDTO cat){
       
        String sql = "INSERT INTO CATEGORIA VALUES(CATEGORIA_SEQ.NEXTVAL,?)"; 
        try(Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)){
           
            pst.setString(1, cat.getNombre());
            pst.execute();
            mensaje= "GUARDADO CORRECTAMENTE";
           
        }catch(SQLException e){ 
            mensaje="NO SE PUDO GUARDAR CORRECTAMENTE: "+e.getMessage();
        } 
        return mensaje;
    }
    
    public String modificarCategoria(CategoriaDTO cat){
        
        String sql = "UPDATE CATEGORIA SET NOMBRE = ?"
                + "WHERE IDCATEGORIA = ?"; 
        try(Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)){
           
            pst.setString(1, cat.getNombre());
            pst.setInt(2, cat.getIdcategoria());
            mensaje= "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
            pst.close();

        }catch(SQLException e){ 
            mensaje="NO SE PUDO MODIFICAR: "+e.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarCategoria( int idcategoria){
        
        String sql = "DELETE FROM CATEGORIA WHERE IDCATEGORIA = ?"; 
        try(Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)){
           
            pst.setInt(1, idcategoria);
            mensaje= "ELIMINADO CORRECTAMENTE";
            pst.execute();
            pst.close();

        }catch(SQLException e){ 
            mensaje="NO SE PUDO ELIMINAR: "+e.getMessage();
        }
        return mensaje;
    }
    
    public void listarCategoria(JTable tabla){
        DefaultTableModel model;
        String [] columnas = {"Id Categoria","Categoria"};
        model = new DefaultTableModel(null, columnas);
                
        String sql = "SELECT * FROM CATEGORIA ORDER BY IDCATEGORIA";
        
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
    
    public CategoriaDTO buscarCategoria(int idcategoria){
        CategoriaDTO ca = new CategoriaDTO();
        String sql = "SELECT * FROM CATEGORIA WHERE IDCATEGORIA = ?";
     
        try(Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
           
            pst.setInt(1, idcategoria);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                ca.setIdcategoria(rs.getInt(1));
                ca.setNombre(rs.getString(2));
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "ERROR EN LA CONSULTA "+ e.getMessage());
            
        }
        return ca;
    } 
}
