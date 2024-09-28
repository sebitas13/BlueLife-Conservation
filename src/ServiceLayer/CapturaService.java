/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccessLayer.CapturaDAO;
import dto.CapturaDTO;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class CapturaService {
    private final CapturaDAO capturaDAO;
    
    public CapturaService(CapturaDAO capturaDAO) {
        this.capturaDAO = capturaDAO;
    }
    
    public String agregarCaptura(CapturaDTO captura) {
        // Aquí puedes agregar lógica adicional como validaciones antes de agregar
        if (captura == null) {
        return "El objeto CapturaDTO es nulo";
        }
        if (captura.getRuc() <= 0) {
            return "El RUC es inválido";
        }
        if (captura.getIdespecie() <= 0) {
            return "El ID de especie es inválido";
        }
        if (captura.getFecha() == null) {
            return "La fecha no puede ser nula";
        }
        if (captura.getCantidadporcaptura() <= 0) {
            return "La cantidad por captura debe ser mayor a cero";
        }
        
        return capturaDAO.agregarCaptura(captura);
    }

    public String modificarCaptura(CapturaDTO captura) {
        // Aquí también puedes agregar validaciones, o lógica adicional

        if (captura == null) {
            return "El objeto CapturaDTO es nulo";
        }
        if (captura.getNumerocaptura() <= 0) {
            return "El número de captura es inválido";
        }
        if (captura.getRuc() <= 0) {
            return "El RUC es inválido";
        }
        if (captura.getIdespecie() <= 0) {
            return "El ID de especie es inválido";
        }
        if (captura.getFecha() == null) {
            return "La fecha no puede ser nula";
        }
        
        
        return capturaDAO.modificarCaptura(captura);
    }

    public String eliminarCaptura(int numerocaptura) {
        // Validación simple antes de eliminar
        if (numerocaptura <= 0) {
            return "Número de captura inválido";
        }
        return capturaDAO.eliminarCaptura(numerocaptura);
    }

    public CapturaDTO buscarCaptura(int numerocaptura) {
        // Lógica adicional antes de buscar
        if (numerocaptura <= 0) {
            throw new IllegalArgumentException("Número de captura inválido");
        }
        return capturaDAO.buscarCaptura(numerocaptura);
    }

  
    
    public void listarCaptura(JTable tabla) {
        
        capturaDAO.listarCaptura(tabla);
        
    }
    
    public void listarCaptura(JTable tabla, int idEspecie) {
        
        capturaDAO.listarCaptura(tabla, idEspecie);
    }

    public void listarTodasLasCapturas(JTable tabla) {
        capturaDAO.listarCaptura(tabla);
    }

    public void llenarComboBoxEspecies(JComboBox comboBox) {
        capturaDAO.listarEspecie(comboBox);
    }

    public void llenarComboBoxRUC(JComboBox comboBox) {
        capturaDAO.listarRUC(comboBox);
    }

}
