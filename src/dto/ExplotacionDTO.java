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
public class ExplotacionDTO {
    private int idespecie;
    private int idestado;
    private int cantidadacumulada;

    public ExplotacionDTO() {
    }

    public ExplotacionDTO(int idespecie, int idestado, int cantidadacumulada) {
        this.idespecie = idespecie;
        this.idestado = idestado;
        this.cantidadacumulada = cantidadacumulada;
    }

    public int getIdespecie() {
        return idespecie;
    }

    public void setIdespecie(int idespecie) {
        this.idespecie = idespecie;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public int getCantidadacumulada() {
        return cantidadacumulada;
    }

    public void setCantidadacumulada(int cantidadacumulada) {
        this.cantidadacumulada = cantidadacumulada;
    }

    @Override
    public String toString() {
        return "Explotacion{" + "idespecie=" + idespecie + ", idestado=" + idestado + ", cantidadacumulada=" + cantidadacumulada + '}';
    }

}
