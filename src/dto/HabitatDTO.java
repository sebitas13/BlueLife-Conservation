/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author USUARIO
 */
public class HabitatDTO {
     private int idhabitat;
    private String nombre;

    public HabitatDTO() {
    }

    public HabitatDTO(int idhabitat, String nombre) {
        this.idhabitat = idhabitat;
        this.nombre = nombre;
    }

    public int getIdhabitat() {
        return idhabitat;
    }

    public void setIdhabitat(int idhabitat) {
        this.idhabitat = idhabitat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Habitat{" + "idhabitat=" + idhabitat + ", nombre=" + nombre + '}';
    }
    
}
