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
public class VentaDTO {
    private int idventa;
    private int numerocaptura;
    private long ruc;
    private int idespecie;
    private int idmercado;
    private float cantidadvendida;

    public VentaDTO() {
    }

    public VentaDTO(int idventa, int numerocaptura, long ruc, int idespecie, int idmercado, float cantidadvendida) {
        this.idventa = idventa;
        this.numerocaptura = numerocaptura;
        this.ruc = ruc;
        this.idespecie = idespecie;
        this.idmercado = idmercado;
        this.cantidadvendida = cantidadvendida;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
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

    public int getIdmercado() {
        return idmercado;
    }

    public void setIdmercado(int idmercado) {
        this.idmercado = idmercado;
    }

    public float getCantidadvendida() {
        return cantidadvendida;
    }

    public void setCantidadvendida(float cantidadvendida) {
        this.cantidadvendida = cantidadvendida;
    }

    @Override
    public String toString() {
        return "Venta{" + "idventa=" + idventa + ", numerocaptura=" + numerocaptura + ", ruc=" + ruc + ", idespecie=" + idespecie + ", idmercado=" + idmercado + ", cantidadvendida=" + cantidadvendida + '}';
    }

    
}
