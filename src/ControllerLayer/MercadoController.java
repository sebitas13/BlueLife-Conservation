/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLayer;

import ServiceLayer.MercadoService;
import dto.MercadoDTO;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class MercadoController {
    private final MercadoService mercadoService;

    public MercadoController(MercadoService mercadoService) {
        this.mercadoService = mercadoService;
    }

    public String agregarMercado(MercadoDTO mercado) {
        return mercadoService.agregarMercado(mercado);
    }

    public String modificarMercado(MercadoDTO mercado) {
        return mercadoService.modificarMercado(mercado);
    }

    public String eliminarMercado(int idMercado) {
        return mercadoService.eliminarMercado(idMercado);
    }

    public void listarMercado(JTable tabla) {
        mercadoService.listarMercado(tabla);
    }

    public MercadoDTO buscarMercado(int idMercado) {
        return mercadoService.buscarMercado(idMercado);
    }
}
