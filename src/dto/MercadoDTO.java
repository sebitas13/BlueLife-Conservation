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
public class MercadoDTO {
    private int mercado;
    private int tipomercado;
    private String nombremercado;

    public MercadoDTO() {
    }

    public MercadoDTO(int mercado, int tipomercado, String nombremercado) {
        this.mercado = mercado;
        this.tipomercado = tipomercado;
        this.nombremercado = nombremercado;
    }

    public int getMercado() {
        return mercado;
    }

    public void setMercado(int mercado) {
        this.mercado = mercado;
    }

    public int getTipomercado() {
        return tipomercado;
    }

    public void setTipomercado(int tipomercado) {
        this.tipomercado = tipomercado;
    }

    public String getNombremercado() {
        return nombremercado;
    }

    public void setNombremercado(String nombremercado) {
        this.nombremercado = nombremercado;
    }

    @Override
    public String toString() {
        return "Mercado{" + "mercado=" + mercado + ", tipomercado=" + tipomercado + ", nombremercado=" + nombremercado + '}';
    }
}
