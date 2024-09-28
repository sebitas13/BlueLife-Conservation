/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLayer;

import ServiceLayer.HabitatService;
import dto.HabitatDTO;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class HabitatController {
    private HabitatService habitatService;

    public HabitatController(HabitatService habitatService) {
        this.habitatService = habitatService;
    }

    public String agregarHabitat(HabitatDTO habitat) {
        return habitatService.agregarHabitat(habitat);
    }

    public String modificarHabitat(HabitatDTO habitat) {
        return habitatService.modificarHabitat(habitat);
    }

    public String eliminarHabitat(int idhabitat) {
        return habitatService.eliminarHabitat(idhabitat);
    }

    public void listarHabitat(JTable tabla) {
        habitatService.listarHabitat(tabla);
    }

    public HabitatDTO buscarHabitat(int idhabitat) {
        return habitatService.buscarHabitat(idhabitat);
    }
}
