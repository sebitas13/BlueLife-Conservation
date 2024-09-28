/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLayer;

import ServiceLayer.EmpresaService;
import dto.EmpresaDTO;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class EmpresaController {
     private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    // Método para agregar una empresa
    public String agregarEmpresa(EmpresaDTO empresa) {
        return empresaService.agregarEmpresa(empresa);
    }

    // Método para modificar una empresa
    public String modificarEmpresa(EmpresaDTO empresa) {
        return empresaService.modificarEmpresa(empresa);
    }

    // Método para eliminar una empresa por su RUC
    public String eliminarEmpresa(long ruc) {
        return empresaService.eliminarEmpresa(ruc);
    }

    // Método para listar las empresas en un JTable
    public void listarEmpresas(JTable tabla) {
        empresaService.listarEmpresas(tabla);
    }

    // Método para buscar una empresa por su RUC
    public EmpresaDTO buscarEmpresa(long ruc) {
        return empresaService.buscarEmpresa(ruc);
    }
}
