/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccessLayer.CategoriaDAO;
import dto.CategoriaDTO;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class CategoriaService {
    private final CategoriaDAO categoriaDAO;

    public CategoriaService(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    public String agregarCategoria(CategoriaDTO cat) {
        // Aquí puedes agregar lógica adicional si es necesario
        return categoriaDAO.agregarCategoria(cat);
    }

    public String modificarCategoria(CategoriaDTO cat) {
        // Aquí puedes agregar lógica adicional si es necesario
        return categoriaDAO.modificarCategoria(cat);
    }

    public String eliminarCategoria(int idcategoria) {
        // Aquí puedes agregar lógica adicional si es necesario
        return categoriaDAO.eliminarCategoria(idcategoria);
    }

    public void listarCategoria(JTable tabla) {
        // Aquí puedes agregar lógica adicional si es necesario
        categoriaDAO.listarCategoria(tabla);
    }

    public CategoriaDTO buscarCategoria(int idcategoria) {
        // Aquí puedes agregar lógica adicional si es necesario
        return categoriaDAO.buscarCategoria(idcategoria);
    }
}
