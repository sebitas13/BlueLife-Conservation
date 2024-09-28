/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Connection.Conexion;
import dto.EmpresaDTO;
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
public class EmpresaDAO {
    private String mensaje="";
    
    public String agregarEmpresa(EmpresaDTO emp){
       
        String sql = "INSERT INTO EMPRESA VALUES(?,?)"; 
        try(Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)){
           
            pst.setLong(1, emp.getRuc());
            pst.setString(2, emp.getRazonsocial());
            mensaje= "GUARDADO CORRECTAMENTE";
            pst.execute();
        
        }catch(SQLException e){ 
            mensaje="NO SE PUDO GUARDAR CORRECTAMENTE: "+e.getMessage();
        } 
        return mensaje;
    }
    
    public String modificarEmpresa(EmpresaDTO emp){
        
        String sql = "UPDATE EMPRESA SET RAZONSOCIAL = ?"
                + "WHERE RUC = ?"; 
        try(Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)){
            
            pst.setString(1, emp.getRazonsocial());
            pst.setLong(2, emp.getRuc());
            mensaje= "ACTUALIZADO CORRECTAMENTE";
            pst.execute();
           

        }catch(SQLException e){ 
            mensaje="NO SE PUDO MODIFICAR: "+e.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarEmpresa(long ruc){
       
        String sql = "DELETE FROM EMPRESA WHERE RUC = ?"; 
        try(Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)){
           
            pst.setLong(1, ruc);
            mensaje= "ELIMINADO CORRECTAMENTE";
            pst.execute();
          

        }catch(SQLException e){ 
            mensaje="NO SE PUDO ELIMINAR: "+e.getMessage();
        }
        return mensaje;
    }
    
    public void listarEmpresa(JTable tabla){
        DefaultTableModel model;
        String [] columnas = {"RUC","Razon Social"};
        model = new DefaultTableModel(null, columnas);
                
        String sql = "SELECT * FROM EMPRESA ORDER BY RUC";
        
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
    
    public EmpresaDTO buscarEmpresa(long ruc){
        EmpresaDTO  em = new EmpresaDTO ();
        String sql = "SELECT * FROM EMPRESA WHERE RUC = ?";
        
        try(Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setLong(1, ruc);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                em.setRuc(rs.getLong(1));
                em.setRazonsocial(rs.getString(2));
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "ERROR EN LA CONSULTA "+ e.getMessage());
            
        }
        return em;
    } 
}
