/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollosostenible;

import ControllerLayer.CapturaController;
import ControllerLayer.CategoriaController;
import ControllerLayer.ControllerManager;
import ControllerLayer.EmpresaController;
import ControllerLayer.EspecieController;
import ControllerLayer.EstadoController;
import ControllerLayer.ExplotacionController;
import ControllerLayer.HabitatController;
import ControllerLayer.MercadoController;
import ControllerLayer.TipoMercadoController;
import ControllerLayer.VentaController;
import DataAccessLayer.CapturaDAO;
import DataAccessLayer.CategoriaDAO;
import DataAccessLayer.EmpresaDAO;
import DataAccessLayer.EspecieDAO;
import DataAccessLayer.EstadoDAO;
import DataAccessLayer.ExplotacionDAO;
import DataAccessLayer.HabitatDAO;
import DataAccessLayer.MercadoDAO;
import DataAccessLayer.TipoMercadoDAO;
import DataAccessLayer.VentaDAO;
import PresentationLayer.FrmPrincipal;
import ServiceLayer.CapturaService;
import ServiceLayer.CategoriaService;
import ServiceLayer.EmpresaService;
import ServiceLayer.EspecieService;
import ServiceLayer.EstadoService;
import ServiceLayer.ExplotacionService;
import ServiceLayer.HabitatService;
import ServiceLayer.MercadoService;
import ServiceLayer.TipoMercadoService;
import ServiceLayer.VentaService;

/**
 *
 * @author USUARIO
 */
public class DesarrolloSostenible {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        CapturaDAO capturaDAO = new CapturaDAO();
        CapturaService capturaService = new CapturaService(capturaDAO);
        CapturaController capturaController = new CapturaController(capturaService);

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        CategoriaService categoriaService = new CategoriaService(categoriaDAO);
        CategoriaController categoriaController = new CategoriaController(categoriaService);

        EmpresaDAO empresaDAO = new EmpresaDAO();
        EmpresaService empresaService = new EmpresaService(empresaDAO);
        EmpresaController empresaController = new EmpresaController(empresaService);

        EspecieDAO especieDAO = new EspecieDAO();
        EspecieService especieService = new EspecieService(especieDAO);
        EspecieController especieController = new EspecieController(especieService);

        EstadoDAO estadoDAO = new EstadoDAO();
        EstadoService estadoService = new EstadoService(estadoDAO);
        EstadoController estadoController = new EstadoController(estadoService);

        ExplotacionDAO explotacionDAO = new ExplotacionDAO();
        ExplotacionService explotacionService = new ExplotacionService(explotacionDAO);
        ExplotacionController explotacionController = new ExplotacionController(explotacionService);

        HabitatDAO habitatDAO = new HabitatDAO();
        HabitatService habitatService = new HabitatService(habitatDAO);
        HabitatController habitatController = new HabitatController(habitatService);
        
        MercadoDAO mercadoDAO = new MercadoDAO();
        MercadoService mercadoService = new MercadoService(mercadoDAO);
        MercadoController mercadoController = new MercadoController(mercadoService);
        
        
        TipoMercadoDAO tipoMercadoDAO = new TipoMercadoDAO();
        TipoMercadoService tipoMercadoService = new TipoMercadoService(tipoMercadoDAO);
        TipoMercadoController tipoMercadoController = new TipoMercadoController(tipoMercadoService);
        
        
        VentaDAO ventaDAO = new VentaDAO();
        VentaService ventaService = new VentaService(ventaDAO);
        VentaController ventaController = new VentaController(ventaService);



        ControllerManager.setCapturaController(capturaController);
        ControllerManager.setCategoriaController(categoriaController);
        ControllerManager.setEmpresaController(empresaController);
        ControllerManager.setEspecieController(especieController);
        ControllerManager.setEstadoController(estadoController);
        ControllerManager.setExplotacionController(explotacionController);
        ControllerManager.setHabitatController(habitatController);
        ControllerManager.setMercadoController(mercadoController);
        ControllerManager.setTipoMercadoController(tipoMercadoController);
        ControllerManager.setVentaController(ventaController);

        FrmPrincipal fp = new FrmPrincipal();

        fp.setLocationRelativeTo(null);  // Centrar la ventana
        fp.setVisible(true);  // Mostrar la ventana

    }

}
