/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author USUARIO
 */
public class CapturaDTO {
    private int numerocaptura;
    private long ruc;
    private int idespecie;
    private Date fecha;
    private float cantidadporcaptura;

    public CapturaDTO() {
    }

    public CapturaDTO(int numerocaptura, long ruc, int idespecie, Date fecha, float cantidadporcaptura) {
        this.numerocaptura = numerocaptura;
        this.ruc = ruc;
        this.idespecie = idespecie;
        this.fecha = fecha;
        this.cantidadporcaptura = cantidadporcaptura;
    }

    public int getNumerocaptura() {
        return numerocaptura;
    }

    public void setNumerocaptura(int numerocaptura) {
        this.numerocaptura = numerocaptura;
    }

    public long getRuc() {
        return ruc;
    }

    public void setRuc(long ruc) {
        this.ruc = ruc;
    }

    public int getIdespecie() {
        return idespecie;
    }

    public void setIdespecie(int idespecie) {
        this.idespecie = idespecie;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getCantidadporcaptura() {
        return cantidadporcaptura;
    }

    public void setCantidadporcaptura(float cantidadporcaptura) {
        this.cantidadporcaptura = cantidadporcaptura;
    }

    @Override
    public String toString() {
        return "Captura{" + "numerocaptura=" + numerocaptura + ", ruc=" + ruc + ", idespecie=" + idespecie + ", fecha=" + fecha + ", cantidadporcaptura=" + cantidadporcaptura + '}';
    }  
}
