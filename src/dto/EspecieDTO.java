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
public class EspecieDTO {
    private int idespecie;
    private int idcategoria;
    private int idhabitat;
    private String nombre;

    public EspecieDTO() {
    }

    public EspecieDTO(int idespecie, int idcategoria, int idhabitat, String nombre) {
        this.idespecie = idespecie;
        this.idcategoria = idcategoria;
        this.idhabitat = idhabitat;
        this.nombre = nombre;
    }

    public int getIdespecie() {
        return idespecie;
    }

    public void setIdespecie(int idespecie) {
        this.idespecie = idespecie;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
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
        return "Especie{" + "idespecie=" + idespecie + ", idcategoria=" + idcategoria + ", idhabitat=" + idhabitat + ", nombre=" + nombre + '}';
    }
    
}
