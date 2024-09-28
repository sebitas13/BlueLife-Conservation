/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccessLayer.EmpresaDAO;
import dto.EmpresaDTO;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class EmpresaService {
    private final EmpresaDAO empresaDAO;

    public EmpresaService(EmpresaDAO empresaDAO) {
        this.empresaDAO = empresaDAO;
    }

    public String agregarEmpresa(EmpresaDTO empresa) {
        if (empresa == null || empresa.getRuc() <= 0 || empresa.getRazonsocial() == null || empresa.getRazonsocial().isEmpty()) {
            return "Datos de la empresa inválidos";
        }
        return empresaDAO.agregarEmpresa(empresa);
    }

    public String modificarEmpresa(EmpresaDTO empresa) {
        if (empresa == null || empresa.getRuc() <= 0 || empresa.getRazonsocial() == null || empresa.getRazonsocial().isEmpty()) {
            return "Datos de la empresa inválidos";
        }
        return empresaDAO.modificarEmpresa(empresa);
    }

    public String eliminarEmpresa(long ruc) {
        if (ruc <= 0) {
            return "RUC inválido";
        }
        return empresaDAO.eliminarEmpresa(ruc);
    }

    public void listarEmpresas(JTable tabla) {
        empresaDAO.listarEmpresa(tabla);
    }

    public EmpresaDTO buscarEmpresa(long ruc) {
        if (ruc <= 0) {
            return null;
        }
        return empresaDAO.buscarEmpresa(ruc);
    }
}
