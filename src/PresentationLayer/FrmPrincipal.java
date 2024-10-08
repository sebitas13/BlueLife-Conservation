/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

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

/**
 *
 * @author USUARIO
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FramePrincipal
     */
    
    private CapturaController capturaController;
    private CategoriaController categoriaController;
    private EmpresaController empresaController;
    private EspecieController especieController;
    private EstadoController estadoController;
    private ExplotacionController explotacionController;
    private HabitatController habitatController;
     private MercadoController mercadoController;
     private TipoMercadoController tipoMercadoController;
     private VentaController ventaController;
    
    public FrmPrincipal() {
        initComponents();
        
        this.capturaController = ControllerManager.getCapturaController();
        this.categoriaController = ControllerManager.getCategoriaController();
        this.empresaController =  ControllerManager.getEmpresaController();
        this.especieController = ControllerManager.getEspecieController();
        this.estadoController = ControllerManager.getEstadoController();
        this.explotacionController = ControllerManager.getExplotacionController();
        this.habitatController = ControllerManager.getHabitatController();
        this.mercadoController = ControllerManager.getMercadoController();
        this.tipoMercadoController = ControllerManager.getTipoMercadoController();
        this.ventaController = ControllerManager.getVentaController();
    }
    
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        cboRegistros = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 102, 102));
        jLabel1.setFont(new java.awt.Font("Tekton Pro", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Sistema de Gestión de Captura de Especies Marítimas");

        btnIngresar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(0, 102, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        cboRegistros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboRegistros.setForeground(new java.awt.Color(0, 102, 255));
        cboRegistros.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gestion Pesquera", "Captura", "Venta", "Categoria", "Empresa", "Especie", "Estado", "Explotacion", "Habitat", "Mercado", "Tipo de Mercado" }));
        cboRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRegistrosActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/goal-14.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if( this.cboRegistros.getSelectedIndex() == 0){
            FrmGestionPesquera gp = new FrmGestionPesquera(capturaController, especieController, 
                    explotacionController, categoriaController, estadoController, habitatController);
            gp.setVisible(true);
            gp.setLocationRelativeTo(null);
            this.dispose();
        }
        if( this.cboRegistros.getSelectedIndex() == 1){
            FrmCaptura ca = new FrmCaptura(capturaController);
            ca.setVisible(true);
            ca.setLocationRelativeTo(null);
            this.dispose();
        }
        
        if( this.cboRegistros.getSelectedIndex() == 2){
            FrmVenta ve = new FrmVenta(ventaController);
            ve.setVisible(true);
            ve.setLocationRelativeTo(null);
            this.dispose();
        }
        if( this.cboRegistros.getSelectedIndex() == 3){
            FrmCategoria ca = new FrmCategoria(categoriaController);
            ca.setVisible(true);
            ca.setLocationRelativeTo(null);
            this.dispose();
        }
        if( this.cboRegistros.getSelectedIndex() == 4){
            FrmEmpresa em = new FrmEmpresa(empresaController);
            em.setVisible(true);
            em.setLocationRelativeTo(null);
            this.dispose();
        }
         if( this.cboRegistros.getSelectedIndex() == 5){
            FrmEspecie es = new FrmEspecie(especieController);
            es.setVisible(true);
            es.setLocationRelativeTo(null);
            this.dispose();
        }
        if( this.cboRegistros.getSelectedIndex() == 6){
            FrmEstado esta = new FrmEstado(estadoController);
            esta.setVisible(true);
            esta.setLocationRelativeTo(null);
            this.dispose();
        }
        if( this.cboRegistros.getSelectedIndex() == 7){
            FrmExplotacion expl = new FrmExplotacion(explotacionController);
            expl.setVisible(true);
            expl.setLocationRelativeTo(null);
            this.dispose();
        }
        if( this.cboRegistros.getSelectedIndex() == 8){
            FrmHabitat ha = new FrmHabitat(habitatController);
            ha.setVisible(true);
            ha.setLocationRelativeTo(null);
            this.dispose();
        }
        if( this.cboRegistros.getSelectedIndex() == 9){
            FrmMercado mer = new FrmMercado(mercadoController);
            mer.setVisible(true);
            mer.setLocationRelativeTo(null);
            this.dispose();
        }
        if( this.cboRegistros.getSelectedIndex() == 10){
            FrmTipoMercado ti = new FrmTipoMercado(tipoMercadoController);
            ti.setVisible(true);
            ti.setLocationRelativeTo(null);
            this.dispose();
        }

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void cboRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboRegistrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboRegistrosActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JComboBox cboRegistros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
