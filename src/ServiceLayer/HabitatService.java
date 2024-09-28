/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccessLayer.HabitatDAO;
import dto.HabitatDTO;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class HabitatService {
    private HabitatDAO habitatDAO;

    public HabitatService(HabitatDAO habitatDAO) {
        this.habitatDAO = habitatDAO;
    }

    public String agregarHabitat(HabitatDTO habitat) {
        return habitatDAO.agregarHabitat(habitat);
    }

    public String modificarHabitat(HabitatDTO habitat) {
        return habitatDAO.modificarHabitat(habitat);
    }

    public String eliminarHabitat(int idhabitat) {
        return habitatDAO.eliminarHabitat(idhabitat);
    }

    public void listarHabitat(JTable tabla) {
        habitatDAO.listarHabitat(tabla);
    }

    public HabitatDTO buscarHabitat(int idhabitat) {
        return habitatDAO.buscarHabitat(idhabitat);
    }
}
