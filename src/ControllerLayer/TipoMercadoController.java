/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLayer;

import ServiceLayer.TipoMercadoService;
import dto.TipoMercadoDTO;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class TipoMercadoController {
    private TipoMercadoService tipoMercadoService;

    public TipoMercadoController(TipoMercadoService tipoMercadoService) {
        this.tipoMercadoService = tipoMercadoService;
    }

    public String agregarTipoMercado(TipoMercadoDTO tip) {
        return tipoMercadoService.agregarTipoMercado(tip);
    }

    public String modificarTipoMercado(TipoMercadoDTO tip) {
        return tipoMercadoService.modificarTipoMercado(tip);
    }

    public String eliminarTipoMercado(int idtipomercado) {
        return tipoMercadoService.eliminarTipoMercado(idtipomercado);
    }

    public void listarTipoMercado(JTable tabla) {
        tipoMercadoService.listarTipoMercado(tabla);
    }

    public TipoMercadoDTO buscarTipoMercado(int idtipomercado) {
        return tipoMercadoService.buscarTipoMercado(idtipomercado);
    }
}
