/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLayer;

import ServiceLayer.ExplotacionService;
import dto.ExplotacionDTO;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class ExplotacionController {
     private final ExplotacionService explotacionService;

    public ExplotacionController(ExplotacionService explotacionService) {
        this.explotacionService = explotacionService;
    }

    public String agregarExplotacion(ExplotacionDTO explotacionDTO) {
        return explotacionService.agregarExplotacion(explotacionDTO);
    }

    public String modificarExplotacion(ExplotacionDTO explotacionDTO) {
        return explotacionService.modificarExplotacion(explotacionDTO);
    }

    public String eliminarExplotacion(int idEspecie) {
        return explotacionService.eliminarExplotacion(idEspecie);
    }

    public ExplotacionDTO buscarExplotacion(int idEspecie) {
        return explotacionService.buscarExplotacion(idEspecie);
    }

    public void listarExplotacion(JTable tabla) {
        explotacionService.listarExplotacion(tabla);
    }
}
