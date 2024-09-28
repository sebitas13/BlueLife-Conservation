/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLayer;

import ServiceLayer.EstadoService;
import dto.EstadoDTO;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class EstadoController {
     private EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    public String agregarEstado(EstadoDTO estado) {
        return estadoService.agregarEstado(estado);
    }

    public String modificarEstado(EstadoDTO estado) {
        return estadoService.modificarEstado(estado);
    }

    public String eliminarEstado(int idEstado) {
        return estadoService.eliminarEstado(idEstado);
    }

    public EstadoDTO buscarEstado(int idEstado) {
        return estadoService.buscarEstado(idEstado);
    }

    public void listarEstado(JTable tabla) {
        estadoService.listarEstado(tabla);
    }
}
