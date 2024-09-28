/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLayer;

import ServiceLayer.EspecieService;
import dto.EspecieDTO;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class EspecieController {
       private final EspecieService especieService;

    public EspecieController(EspecieService especieService) {
        this.especieService = especieService;
    }

    // Ahora este método recibe el DTO directamente
    public String agregarEspecie(EspecieDTO especie) {
        return especieService.agregarEspecie(especie);
    }

    public String modificarEspecie(EspecieDTO especie) {
        return especieService.modificarEspecie(especie);
    }

    public String eliminarEspecie(int idEspecie) {
        return especieService.eliminarEspecie(idEspecie);
    }

    public void listarEspecies(JTable tabla) {
        especieService.listarEspecie(tabla);
    }

    public EspecieDTO buscarEspecie(int idEspecie) {
        return especieService.buscarEspecie(idEspecie);
    }

    public void verificarDisponibilidad(String nombreEspecie) throws SQLException {
        especieService.verificarDisponibilidad(nombreEspecie);
    }

    public void llenarComboBoxHabitat(JComboBox comboBox) {
        especieService.listarIDHabitat(comboBox);
    }

    public void llenarComboBoxCategoria(JComboBox comboBox) {
        especieService.listarIDCategoria(comboBox);
    }
}
