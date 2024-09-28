/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccessLayer.EspecieDAO;
import dto.EspecieDTO;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class EspecieService {
     private final EspecieDAO especieDAO;

    public EspecieService(EspecieDAO especieDAO) {
        this.especieDAO = especieDAO;
    }

    public String agregarEspecie(EspecieDTO especie) {
        return especieDAO.agregarEspecie(especie);
    }

    public String modificarEspecie(EspecieDTO especie) {
        return especieDAO.modificarEspecie(especie);
    }

    public String eliminarEspecie(int idEspecie) {
        return especieDAO.eliminarEspecie(idEspecie);
    }

    public void listarEspecie(JTable tabla) {
        especieDAO.listarEspecie(tabla);
    }

    public EspecieDTO buscarEspecie(int idEspecie) {
        return especieDAO.buscarEspecie(idEspecie);
    }

    public void verificarDisponibilidad(String nombreEspecie) throws SQLException {
        especieDAO.verificarDisponibilidad(nombreEspecie);
    }

    public void listarIDHabitat(JComboBox comboBox) {
        especieDAO.listarIDHabitat(comboBox);
    }

    public void listarIDCategoria(JComboBox comboBox) {
        especieDAO.listarIDCategoria(comboBox);
    }
}
