/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Vistas;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import proyecto.restaurante.Control.MeseroData;
import proyecto.restaurante.Entidades.Mesero;

/**
 *
 * @author Emito
 */
public class CargaMeserosView extends javax.swing.JInternalFrame {

    /**
     * Creates new form CargaMeserosView
     */
    public CargaMeserosView() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        estilos();
        //CargarComboMeseros();
        jcbMesero.setEnabled(false);
        //CargarComboEncargados();
        jcbEncargado.setEnabled(false);
        jrbInactivo.setSelected(false);
        jrbMesero.setSelected(false);
        
    }
    private void estilos(){
        Fondo.setBackground(new Color(35,34,36,210));
        TransparenciaCargar.setBackground(new Color(35,34,36,160));
        TransparenciaModificar.setBackground(new Color(35,34,36,160));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jbActualizarMesero = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jcbEncargado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jcbMesero = new javax.swing.JComboBox<>();
        Cerrar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtPassword = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jtDni = new javax.swing.JTextField();
        jrbMesero = new javax.swing.JRadioButton();
        jrbEncargado = new javax.swing.JRadioButton();
        jrbActivo = new javax.swing.JRadioButton();
        jrbInactivo = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jbCrearMesero = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Limpiar = new javax.swing.JButton();
        TransparenciaCargar = new javax.swing.JLabel();
        TransparenciaModificar = new javax.swing.JLabel();
        FondoImagen = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        setPreferredSize(new java.awt.Dimension(540, 590));
        setSize(new java.awt.Dimension(540, 590));

        Fondo.setBackground(new java.awt.Color(0, 0, 0));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbActualizarMesero.setText("Actualizar Mesero");
        jbActualizarMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarMeseroActionPerformed(evt);
            }
        });
        Fondo.add(jbActualizarMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Contraseña:");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 130, 30));

        jcbEncargado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbEncargadoMouseClicked(evt);
            }
        });
        jcbEncargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEncargadoActionPerformed(evt);
            }
        });
        Fondo.add(jcbEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 270, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seleccione Mesero a Modificar.");
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jcbMesero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbMeseroMouseClicked(evt);
            }
        });
        jcbMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMeseroActionPerformed(evt);
            }
        });
        Fondo.add(jcbMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 270, -1));

        Cerrar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Cerrar.setForeground(new java.awt.Color(255, 255, 255));
        Cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cerrar.setText("Exit");
        Cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CerrarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CerrarMouseEntered(evt);
            }
        });
        Fondo.add(Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 50, 30));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Seleccione Encargado");
        Fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 190, 30));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nombre:");
        Fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 130, 30));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Apellido:");
        Fondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 130, 30));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Dni:");
        Fondo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 130, 30));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Estado:");
        Fondo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 130, 30));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Acceso:");
        Fondo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 130, 30));
        Fondo.add(jtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 320, -1));
        Fondo.add(jtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 320, -1));
        Fondo.add(jtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 320, -1));
        Fondo.add(jtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 320, -1));

        jrbMesero.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jrbMesero.setForeground(new java.awt.Color(255, 255, 255));
        jrbMesero.setText("Mesero");
        jrbMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMeseroActionPerformed(evt);
            }
        });
        Fondo.add(jrbMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 120, -1));

        jrbEncargado.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jrbEncargado.setForeground(new java.awt.Color(255, 255, 255));
        jrbEncargado.setText("Encargado");
        jrbEncargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEncargadoActionPerformed(evt);
            }
        });
        Fondo.add(jrbEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 120, -1));

        jrbActivo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jrbActivo.setForeground(new java.awt.Color(255, 255, 255));
        jrbActivo.setText("Activo");
        jrbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbActivoActionPerformed(evt);
            }
        });
        Fondo.add(jrbActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 120, -1));

        jrbInactivo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jrbInactivo.setForeground(new java.awt.Color(255, 255, 255));
        jrbInactivo.setText("Inactivo");
        jrbInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbInactivoActionPerformed(evt);
            }
        });
        Fondo.add(jrbInactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 120, -1));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Seleccione Mesero");
        Fondo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 190, 30));

        jbCrearMesero.setText("Cargar Mesero");
        jbCrearMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearMeseroActionPerformed(evt);
            }
        });
        Fondo.add(jbCrearMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 140, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Carga y modificacion de Meseros");
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Complete los Datos para un nuevo Mesero");
        Fondo.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        Limpiar.setText("Limpiar Pantalla");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });
        Fondo.add(Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 130, -1));

        TransparenciaCargar.setOpaque(true);
        Fondo.add(TransparenciaCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 46, 500, 110));

        TransparenciaModificar.setOpaque(true);
        Fondo.add(TransparenciaModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 166, 500, 360));

        FondoImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/restaurante/resources/imagenes/FondoInternalFrames.jpg"))); // NOI18N
        FondoImagen.setLabelFor(Fondo);
        Fondo.add(FondoImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 540, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbActualizarMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarMeseroActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbActualizarMeseroActionPerformed

    private void jcbMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMeseroActionPerformed
        if (jcbMesero.getItemCount()==0){
            
        }else{
        Mesero m = new Mesero();
        m = (Mesero)jcbMesero.getSelectedItem();
        if (m!=null){
            jtNombre.setText(m.getNombre());
            jtApellido.setText(m.getApellido());
            jtDni.setText(String.valueOf(m.getDni()));
            if (m.isEstado()){
                jrbActivo.setSelected(true);
                jrbInactivo.setSelected(false);
            }else{
                jrbActivo.setSelected(false);
                jrbInactivo.setSelected(true);
            }
            if (m.getAcceso()==1){
                jrbEncargado.setSelected(true);
                jrbMesero.setSelected(false);
            }else{
                jrbEncargado.setSelected(false);
                jrbMesero.setSelected(true);
            }
            jtPassword.setText(m.getPassword());
            
        }else{
            JOptionPane.showMessageDialog(null, "Debe Seleccionar un Mesero");
        }
        }
    }//GEN-LAST:event_jcbMeseroActionPerformed

    private void jrbInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbInactivoActionPerformed
        // TODO add your handling code here:
        if (jrbInactivo.isSelected()){
            jrbActivo.setSelected(false);
        }else{
            jrbActivo.setSelected(false);
        }
    }//GEN-LAST:event_jrbInactivoActionPerformed

    private void CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_CerrarMouseClicked

    private void CerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseEntered
        // TODO add your handling code here:
        Cerrar.setForeground(Color.gray);
    }//GEN-LAST:event_CerrarMouseEntered

    private void CerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseExited
        // TODO add your handling code here:
        Cerrar.setForeground(Color.white);
    }//GEN-LAST:event_CerrarMouseExited

    private void jbCrearMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearMeseroActionPerformed

        
        MeseroData mesd = new MeseroData();
        Mesero m = new Mesero();
        m.setNombre(jtNombre.getText());
        m.setApellido(jtApellido.getText());
        m.setDni(Integer.parseInt(jtDni.getText()));
        if (jrbActivo.isSelected()){
            m.setEstado(true);
        }else{
            m.setEstado(false);
        }
        if (jrbEncargado.isSelected()){
            m.setAcceso(1);
        }else{
            m.setAcceso(2);
        }
        m.setPassword(jtPassword.getText());
        mesd.agregarMesero(m);
    }//GEN-LAST:event_jbCrearMeseroActionPerformed

    private void jcbMeseroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbMeseroMouseClicked
        
        if (!jcbMesero.isEnabled()){
        jcbMesero.setEnabled(true);
        jcbEncargado.setEnabled(false);
        jcbEncargado.removeAllItems();
         jtNombre.setText("");
        jtApellido.setText("");
        jtDni.setText("");
        jrbActivo.setSelected(false);
        jrbInactivo.setSelected(false);
        jrbEncargado.setSelected(false);
        jrbMesero.setSelected(false);
        jtPassword.setText("");
        jbCrearMesero.setEnabled(false);
        jcbMesero.removeAllItems();
        CargarComboMeseros();
        }
    }//GEN-LAST:event_jcbMeseroMouseClicked

    private void jrbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbActivoActionPerformed
        // TODO add your handling code here:
        if (jrbActivo.isSelected()){
            jrbInactivo.setSelected(false);
        }else{
            jrbInactivo.setSelected(true);
        }
    }//GEN-LAST:event_jrbActivoActionPerformed

    private void jrbEncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEncargadoActionPerformed
        // TODO add your handling code here:
        if (jrbEncargado.isSelected()){
            jrbMesero.setSelected(false);
        }else{
            jrbMesero.setSelected(true);
        }
    }//GEN-LAST:event_jrbEncargadoActionPerformed

    private void jrbMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMeseroActionPerformed
        // TODO add your handling code here:
        if (jrbMesero.isSelected()){
            jrbEncargado.setSelected(false);
        }else{
            jrbEncargado.setSelected(true);
        }
    }//GEN-LAST:event_jrbMeseroActionPerformed

    private void jcbEncargadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbEncargadoMouseClicked
        // TODO add your handling code here:
        if (!jcbEncargado.isEnabled()){
        jcbEncargado.setEnabled(true);
        jcbMesero.setEnabled(false);
        jcbMesero.removeAllItems();
         jtNombre.setText("");
        jtApellido.setText("");
        jtDni.setText("");
        jrbActivo.setSelected(false);
        jrbInactivo.setSelected(false);
        jrbEncargado.setSelected(false);
        jrbMesero.setSelected(false);
        jtPassword.setText("");
        jbCrearMesero.setEnabled(false);
        jcbEncargado.removeAllItems();
        CargarComboEncargados();
        }
    }//GEN-LAST:event_jcbEncargadoMouseClicked

    private void jcbEncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEncargadoActionPerformed
        // TODO add your handling code here:
        if (jcbEncargado.getItemCount()==0){
        }else{
        Mesero m = new Mesero();
        m = (Mesero)jcbEncargado.getSelectedItem();
        if (m!=null){
            jtNombre.setText(m.getNombre());
            jtApellido.setText(m.getApellido());
            jtDni.setText(String.valueOf(m.getDni()));
            if (m.isEstado()){
                jrbActivo.setSelected(true);
                jrbInactivo.setSelected(false);
            }else{
                jrbActivo.setSelected(false);
                jrbInactivo.setSelected(true);
            }
            if (m.getAcceso()==1){
                jrbEncargado.setSelected(true);
                jrbMesero.setSelected(false);
            }else{
                jrbEncargado.setSelected(false);
                jrbMesero.setSelected(true);
            }
            jtPassword.setText(m.getPassword());
            
        }else{
            JOptionPane.showMessageDialog(null, "Debe Seleccionar un Mesero");
        }
        }
    }//GEN-LAST:event_jcbEncargadoActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LimpiarActionPerformed
    private void CargarComboMeseros(){
        MeseroData mesd = new MeseroData();
        
        for (Mesero me: mesd.ListarMeseros()){
        jcbMesero.addItem(me);
        }
        
    }
    
    private void CargarComboEncargados(){
        MeseroData mesd = new MeseroData();
        
        for (Mesero me: mesd.ListarEncargados()){
        jcbEncargado.addItem(me);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel FondoImagen;
    private javax.swing.JButton Limpiar;
    private javax.swing.JLabel TransparenciaCargar;
    private javax.swing.JLabel TransparenciaModificar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbActualizarMesero;
    private javax.swing.JButton jbCrearMesero;
    private javax.swing.JComboBox<Mesero> jcbEncargado;
    private javax.swing.JComboBox<Mesero> jcbMesero;
    private javax.swing.JRadioButton jrbActivo;
    private javax.swing.JRadioButton jrbEncargado;
    private javax.swing.JRadioButton jrbInactivo;
    private javax.swing.JRadioButton jrbMesero;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtPassword;
    // End of variables declaration//GEN-END:variables
}
