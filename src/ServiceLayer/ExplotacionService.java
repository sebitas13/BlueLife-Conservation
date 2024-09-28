/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccessLayer.ExplotacionDAO;
import dto.ExplotacionDTO;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class ExplotacionService {
     private final ExplotacionDAO explotacionDAO;

    public ExplotacionService(ExplotacionDAO explotacionDAO) {
        this.explotacionDAO = explotacionDAO;
    }

    public String agregarExplotacion(ExplotacionDTO explotacionDTO) {
        return explotacionDAO.agregarExplotacion(explotacionDTO);
    }

    public String modificarExplotacion(ExplotacionDTO explotacionDTO) {
        return explotacionDAO.modificarExplotacion(explotacionDTO);
    }

    public String eliminarExplotacion(int idEspecie) {
        return explotacionDAO.eliminarExplotacion(idEspecie);
    }

    public ExplotacionDTO buscarExplotacion(int idEspecie) {
        return explotacionDAO.buscarExplotacion(idEspecie);
    }

    public void listarExplotacion(JTable tabla) {
        explotacionDAO.listarExplotacion(tabla);
    }
}
