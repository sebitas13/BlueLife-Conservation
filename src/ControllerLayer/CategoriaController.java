/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLayer;

import ServiceLayer.CategoriaService;
import dto.CategoriaDTO;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public String agregarCategoria(CategoriaDTO cat) {
        return categoriaService.agregarCategoria(cat);
    }

    public String modificarCategoria(CategoriaDTO cat) {
        return categoriaService.modificarCategoria(cat);
    }

    public String eliminarCategoria(int idcategoria) {
        return categoriaService.eliminarCategoria(idcategoria);
    }

    public void listarCategoria(JTable tabla) {
        categoriaService.listarCategoria(tabla);
    }

    public CategoriaDTO buscarCategoria(int idcategoria) {
        return categoriaService.buscarCategoria(idcategoria);
    }
}
