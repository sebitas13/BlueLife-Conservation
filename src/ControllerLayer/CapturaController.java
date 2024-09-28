/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLayer;

import ServiceLayer.CapturaService;
import dto.CapturaDTO;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class CapturaController {

    private final CapturaService capturaService;

    public CapturaController(CapturaService capturaService) {
        this.capturaService = capturaService;
    }

    public String agregarCaptura(long ruc, int idEspecie, java.util.Date fecha, float cantidad) {

      

        CapturaDTO captura = new CapturaDTO();
        captura.setRuc(ruc);
        captura.setIdespecie(idEspecie);
        captura.setFecha(fecha);
        captura.setCantidadporcaptura(cantidad);

        String mensaje = capturaService.agregarCaptura(captura);
        return mensaje;
    }

    public String modificarCaptura(int numeroCaptura, long ruc, int idEspecie, java.util.Date fecha, float cantidad) {


        CapturaDTO captura = new CapturaDTO();
        captura.setNumerocaptura(numeroCaptura);
        captura.setRuc(ruc);
        captura.setIdespecie(idEspecie);
        captura.setFecha(fecha);
        captura.setCantidadporcaptura(cantidad);

        String mensaje = capturaService.modificarCaptura(captura);
        return mensaje;
    }

    public String eliminarCaptura(int numeroCaptura) {

        if (numeroCaptura <= 0) {
            return "El número de captura es inválido.";
        }
        String mensaje = capturaService.eliminarCaptura(numeroCaptura);
        return mensaje;
    }

    public void listarCapturas(JTable tabla) {

        capturaService.listarCaptura(tabla);
    }
    
    public void listarCapturas(JTable tabla,int idespecie) {
        
        capturaService.listarCaptura(tabla,idespecie);
    }

    public CapturaDTO buscarCaptura(int numeroCaptura) {
        if (numeroCaptura <= 0) {
            return null; 
        }
        return capturaService.buscarCaptura(numeroCaptura);
    }

    public void llenarComboBoxEspecies(JComboBox comboBox) {
        capturaService.llenarComboBoxEspecies(comboBox);
    }

    public void llenarComboBoxRUC(JComboBox comboBox) {
        capturaService.llenarComboBoxRUC(comboBox);
    }

}
