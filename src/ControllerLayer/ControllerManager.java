/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerLayer;

/**
 *
 * @author USUARIO
 */
public class ControllerManager {

    private static CapturaController capturaController;
    private static CategoriaController categoriaController;
    private static EmpresaController empresaController;
    private static EspecieController especieController;
    private static EstadoController estadoController;
    private static ExplotacionController explotacionController;
    private static HabitatController habitatController;
    private static MercadoController mercadoController;
    private static TipoMercadoController tipoMercadoController;
      private static VentaController ventaController;


    // Métodos para inyectar controladores
    public static void setCapturaController(CapturaController controller) {
        capturaController = controller;
    }

    public static void setCategoriaController(CategoriaController controller) {
        categoriaController = controller;
    }

    public static void setEmpresaController(EmpresaController controller) {
        empresaController = controller;
    }

    public static void setEspecieController(EspecieController controller) {
        especieController = controller;
    }

    public static void setEstadoController(EstadoController controller) {
        estadoController = controller;
    }

    public static void setExplotacionController(ExplotacionController controller) { // Nuevo método
        explotacionController = controller;
    }

    public static void setHabitatController(HabitatController controller) {
        habitatController = controller;
        
    }
    
     public static void setMercadoController(MercadoController controller) {
        mercadoController = controller;
    }
     
     public static void setTipoMercadoController(TipoMercadoController controller) {
        tipoMercadoController = controller;
    }
     
     public static void setVentaController(VentaController controller) {
        ventaController = controller;
    }


    // Métodos para obtener controladores
    public static CapturaController getCapturaController() {
        return capturaController;
    }

    public static CategoriaController getCategoriaController() {
        return categoriaController;
    }

    public static EmpresaController getEmpresaController() {
        return empresaController;
    }

    public static EspecieController getEspecieController() {
        return especieController;
    }

    public static EstadoController getEstadoController() {
        return estadoController;
    }

    public static ExplotacionController getExplotacionController() { // Nuevo método
        return explotacionController;
    }

    public static HabitatController getHabitatController() {
        return habitatController;
    }
    
    public static MercadoController getMercadoController() {
        return mercadoController;
    }
    
    public static TipoMercadoController getTipoMercadoController() {
        return tipoMercadoController;
    }
    
    public static VentaController getVentaController() {
        return ventaController;
    }
}
