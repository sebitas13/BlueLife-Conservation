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
public class TipoMercadoDTO {
     private int idtipomercado;
    private String tipo;

    public TipoMercadoDTO() {
    }

    public TipoMercadoDTO(int idtipomercado, String tipo) {
        this.idtipomercado = idtipomercado;
        this.tipo = tipo;
    }

    public int getIdtipomercado() {
        return idtipomercado;
    }

    public void setIdtipomercado(int idtipomercado) {
        this.idtipomercado = idtipomercado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TipoMercado{" + "idtipomercado=" + idtipomercado + ", tipo=" + tipo + '}';
    }
    
}
