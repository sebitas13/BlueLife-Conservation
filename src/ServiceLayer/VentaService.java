/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccessLayer.VentaDAO;
import dto.VentaDTO;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class VentaService {
    private VentaDAO ventaDAO;

    public VentaService(VentaDAO ventaDAO) {
        this.ventaDAO = ventaDAO;
    }

    public String agregarVenta(VentaDTO ven) {
        return ventaDAO.agregarVenta(ven);
    }

    public String modificarVenta(VentaDTO ven) {
        return ventaDAO.modificarVenta(ven);
    }

    public String eliminarVenta(int idventa) {
        return ventaDAO.eliminarVenta(idventa);
    }

    public void listarVenta(JTable tabla) {
        ventaDAO.listarVenta(tabla);
    }

    public VentaDTO buscarVenta(int idVenta) {
        return ventaDAO.buscarVenta(idVenta);
    }
    
     public VentaDTO buscarVentaPorNumeroCaptura(int numerocaptura) {
        return ventaDAO.buscarVentaPorNumeroCaptura(numerocaptura);
    }
}
