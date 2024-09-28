/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLayer;

import ServiceLayer.VentaService;
import dto.VentaDTO;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class VentaController {
    private VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    public String agregarVenta(VentaDTO ven) {
        return ventaService.agregarVenta(ven);
    }

    public String modificarVenta(VentaDTO ven) {
        return ventaService.modificarVenta(ven);
    }

    public String eliminarVenta(int idventa) {
        return ventaService.eliminarVenta(idventa);
    }

    public void listarVenta(JTable tabla) {
        ventaService.listarVenta(tabla);
    }

    public VentaDTO buscarVenta(int idVenta) {
        return ventaService.buscarVenta(idVenta);
    }
    
     public VentaDTO buscarVentaPorNumeroCaptura(int numerocaptura) {
        return ventaService.buscarVentaPorNumeroCaptura(numerocaptura);
    }
}
