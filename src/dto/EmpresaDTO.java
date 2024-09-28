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
public class EmpresaDTO {
     private long ruc;
    private String razonsocial;

    public EmpresaDTO() {
    }

    public EmpresaDTO(int ruc, String razonsocial) {
        this.ruc = ruc;
        this.razonsocial = razonsocial;
    }

    public long getRuc() {
        return ruc;
    }

    public void setRuc(long ruc) {
        this.ruc = ruc;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    @Override
    public String toString() {
        return "Empresa{" + "ruc=" + ruc + ", razonsocial=" + razonsocial + '}';
    }
}
