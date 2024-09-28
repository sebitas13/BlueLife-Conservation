/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccessLayer.MercadoDAO;
import dto.MercadoDTO;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class MercadoService {
    private final MercadoDAO mercadoDAO;

    public MercadoService(MercadoDAO mercadoDAO) {
        this.mercadoDAO = mercadoDAO;
    }

    public String agregarMercado(MercadoDTO mercado) {
        return mercadoDAO.agregarMercado(mercado);
    }

    public String modificarMercado(MercadoDTO mercado) {
        return mercadoDAO.modificarMercado(mercado);
    }

    public String eliminarMercado(int idMercado) {
        return mercadoDAO.eliminarMercado(idMercado);
    }

    public void listarMercado(JTable tabla) {
        mercadoDAO.listarMercado(tabla);
    }

    public MercadoDTO buscarMercado(int idMercado) {
        return mercadoDAO.buscarMercado(idMercado);
    }
}
