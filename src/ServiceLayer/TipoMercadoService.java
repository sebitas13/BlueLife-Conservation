/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccessLayer.TipoMercadoDAO;
import dto.TipoMercadoDTO;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class TipoMercadoService {
    private TipoMercadoDAO tipoMercadoDAO;

    public TipoMercadoService(TipoMercadoDAO tipoMercadoDAO) {
        this.tipoMercadoDAO = tipoMercadoDAO;
    }

    public String agregarTipoMercado(TipoMercadoDTO tip) {
        return tipoMercadoDAO.agregarTipoMercado(tip);
    }

    public String modificarTipoMercado(TipoMercadoDTO tip) {
        return tipoMercadoDAO.modificarTipoMercado(tip);
    }

    public String eliminarTipoMercado(int idtipomercado) {
        return tipoMercadoDAO.eliminarTipoMercado(idtipomercado);
    }

    public void listarTipoMercado(JTable tabla) {
        tipoMercadoDAO.listarTipoMercado(tabla);
    }

    public TipoMercadoDTO buscarTipoMercado(int idtipomercado) {
        return tipoMercadoDAO.buscarTipoMercado(idtipomercado);
    }
}
