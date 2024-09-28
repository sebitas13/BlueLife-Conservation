/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccessLayer.EstadoDAO;
import dto.EstadoDTO;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class EstadoService {
      private EstadoDAO estadoDAO;

    public EstadoService(EstadoDAO estadoDAO) {
        this.estadoDAO = estadoDAO;
    }

    public String agregarEstado(EstadoDTO estado) {
        return estadoDAO.agregarEstado(estado);
    }

    public String modificarEstado(EstadoDTO estado) {
        return estadoDAO.modificarEstado(estado);
    }

    public String eliminarEstado(int idEstado) {
        return estadoDAO.eliminarEstado(idEstado);
    }

    public EstadoDTO buscarEstado(int idEstado) {
        return estadoDAO.buscarEstado(idEstado);
    }

    public void listarEstado(JTable tabla) {
        estadoDAO.listarEstado(tabla);
    }
}
