package proyecto.restaurante.Vistas;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import proyecto.restaurante.Control.*;
import proyecto.restaurante.Entidades.*;


public class IngresosView1 extends javax.swing.JInternalFrame {
    private  Mesero mesero;
    private  PedidoData pedidoData;
    private ActionListener[] listenersFechas;
    private ActionListener[] listenersMeseros;
    private Mesero meseroSeleccionado;
    private LocalDate fechaSeleccionada;
    private Actividad actividadSeleccionada;
    DefaultTableModel modelo=new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    public IngresosView1() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        estilos();
        pedidoData = new PedidoData();
        //listenersFechas = jcbFechas.getActionListeners();
        jcbFechas.setEnabled(false);
        //listenersMeseros = jcbMeseros.getActionListeners();
        jcbMeseros.setEnabled(false);
        
        jcbActividad.setEnabled(false);
        armarCabecera();
        cargarTabla(LocalDate.now());
        sumarTotal();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpFondo = new javax.swing.JPanel();
        jlTituloIngresos = new javax.swing.JLabel();
        jlFecha = new javax.swing.JLabel();
        jlMesero = new javax.swing.JLabel();
        jlDetalles1 = new javax.swing.JLabel();
        jcbFechas = new javax.swing.JComboBox<>();
        jcbMeseros = new javax.swing.JComboBox<>();
        jlDetalles = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaDetalles = new javax.swing.JTable();
        jbVerDetalle = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jbListarTodo = new javax.swing.JButton();
        jlTotal = new javax.swing.JLabel();
        jtTotal = new javax.swing.JTextField();
        jlActividad = new javax.swing.JLabel();
        jcbActividad = new javax.swing.JComboBox<>();
        jlFondoTrasparente1 = new javax.swing.JLabel();
        jlCerrar = new javax.swing.JLabel();
        jlFondoImage = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        setPreferredSize(new java.awt.Dimension(540, 590));

        jpFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlTituloIngresos.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jlTituloIngresos.setForeground(new java.awt.Color(255, 255, 255));
        jlTituloIngresos.setText("Administración de Ingresos");
        jpFondo.add(jlTituloIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 40));

        jlFecha.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlFecha.setForeground(new java.awt.Color(255, 255, 255));
        jlFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFecha.setText("Seleccione la Fecha:");
        jpFondo.add(jlFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        jlMesero.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlMesero.setForeground(new java.awt.Color(255, 255, 255));
        jlMesero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMesero.setText("Seleccione el Mesero:");
        jpFondo.add(jlMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jlDetalles1.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jlDetalles1.setForeground(new java.awt.Color(255, 255, 255));
        jlDetalles1.setText("Consulte pedidos");
        jpFondo.add(jlDetalles1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jcbFechas.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jcbFechas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbFechasMouseClicked(evt);
            }
        });
        jcbFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFechasActionPerformed(evt);
            }
        });
        jpFondo.add(jcbFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 260, -1));

        jcbMeseros.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jcbMeseros.setOpaque(false);
        jcbMeseros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbMeserosMouseClicked(evt);
            }
        });
        jcbMeseros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMeserosActionPerformed(evt);
            }
        });
        jpFondo.add(jcbMeseros, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 260, -1));

        jlDetalles.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jlDetalles.setForeground(new java.awt.Color(255, 255, 255));
        jlDetalles.setText("Detalles:");
        jpFondo.add(jlDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jtListaDetalles.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jtListaDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtListaDetalles);

        jpFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 230, 490, 270));

        jbVerDetalle.setBackground(new java.awt.Color(153, 153, 0));
        jbVerDetalle.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jbVerDetalle.setForeground(new java.awt.Color(51, 51, 51));
        jbVerDetalle.setText("Ver Detalle");
        jbVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerDetalleActionPerformed(evt);
            }
        });
        jpFondo.add(jbVerDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, -1, -1));

        jbBorrar.setBackground(new java.awt.Color(153, 153, 0));
        jbBorrar.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jbBorrar.setForeground(new java.awt.Color(51, 51, 51));
        jbBorrar.setText("Borrar");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });
        jpFondo.add(jbBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, -1, -1));

        jbListarTodo.setBackground(new java.awt.Color(153, 153, 0));
        jbListarTodo.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jbListarTodo.setForeground(new java.awt.Color(51, 51, 51));
        jbListarTodo.setText("Listar Todo");
        jbListarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarTodoActionPerformed(evt);
            }
        });
        jpFondo.add(jbListarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, -1));

        jlTotal.setBackground(new java.awt.Color(255, 255, 255));
        jlTotal.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlTotal.setForeground(new java.awt.Color(255, 255, 255));
        jlTotal.setText("Total:");
        jpFondo.add(jlTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, 40, 30));

        jtTotal.setBackground(new java.awt.Color(245, 233, 144));
        jtTotal.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jtTotal.setForeground(new java.awt.Color(51, 51, 51));
        jpFondo.add(jtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 130, -1));

        jlActividad.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlActividad.setForeground(new java.awt.Color(255, 255, 255));
        jlActividad.setText("Estado:");
        jpFondo.add(jlActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        jcbActividad.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jcbActividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbActividadMouseClicked(evt);
            }
        });
        jcbActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbActividadActionPerformed(evt);
            }
        });
        jpFondo.add(jcbActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 150, -1));

        jlFondoTrasparente1.setOpaque(true);
        jpFondo.add(jlFondoTrasparente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 50, 510, 510));

        jlCerrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlCerrar.setForeground(new java.awt.Color(255, 255, 255));
        jlCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCerrar.setText("Exit");
        jlCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCerrarMouseClicked(evt);
            }
        });
        jpFondo.add(jlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 50, 30));

        jlFondoImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFondoImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/restaurante/resources/imagenes/FondoInternalFrames.jpg"))); // NOI18N
        jpFondo.add(jlFondoImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_jlCerrarMouseClicked

    private void jcbMeserosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbMeserosMouseClicked
        try{
            //desactivarListenersFechas();
            jcbActividad.setEnabled(false);
            jcbActividad.removeAllItems();

            if (!jcbMeseros.isEnabled() && !jcbFechas.isEnabled()) {
                borrarFila();
                jcbMeseros.setEnabled(true);
                cargarComboMeseros();
                //activarListenersMeseros();

            } else if (!jcbMeseros.isEnabled() && jcbFechas.isEnabled()) {
                borrarFila();
                jcbFechas.removeAllItems();
                jcbFechas.setEnabled(false);
                jcbMeseros.setEnabled(true);
                jcbMeseros.removeAllItems();
                cargarComboMeseros();
                //activarListenersMeseros();

            }
        }catch(NumberFormatException | NullPointerException e){}
    }//GEN-LAST:event_jcbMeserosMouseClicked

    private void jbListarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarTodoActionPerformed
        //desactivarListenersMeseros();
        //desactivarListenersFechas();
        jcbActividad.removeAllItems();
        jcbActividad.setEnabled(false);
        jcbMeseros.removeAllItems();
        jcbMeseros.setEnabled(false);
        jcbFechas.removeAllItems();
        jcbFechas.setEnabled(false);
        borrarFila();
        cargarTabla(LocalDate.now());
        sumarTotal();
    }//GEN-LAST:event_jbListarTodoActionPerformed

    private void jcbMeserosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMeserosActionPerformed
        try{    
            if (jcbMeseros.isEnabled() && !jcbFechas.isEnabled()) {
                borrarFila();
                Mesero mesero = (Mesero) jcbMeseros.getSelectedItem();
                if (mesero!=null){
                    cargarTabla(mesero);
                    sumarTotal();
                }else{
                    jcbFechas.setEnabled(false);
                    jcbFechas.removeAllItems();
                }
            } else {
                jcbMeseros.setEnabled(false); // Desactivar el JComboBox de meseros
                jcbFechas.setEnabled(true); // Activar el JComboBox de fechas
                jcbFechas.removeAllItems(); // Vaciar el JComboBox de fechas
                cargarComboFechas(); // Cargar las fechas en el JComboBox
            }
        }catch(NumberFormatException | NullPointerException e){}
    }//GEN-LAST:event_jcbMeserosActionPerformed

    private void jcbFechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbFechasMouseClicked
        
        try{
            jcbActividad.setEnabled(false);
            jcbActividad.removeAllItems();
        if (!jcbFechas.isEnabled() && !jcbMeseros.isEnabled() && !jcbActividad.isEnabled()) {
            
            jcbFechas.setEnabled(true);
                
            cargarComboFechas();
            //activarListenersFechas();
                DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma);
                
                if (fechaSeleccionada!=null){
                    borrarFila();
                    cargarTabla(fechaSeleccionada);
                    sumarTotal();
                }
        } else if (jcbMeseros.isEnabled()&& !jcbActividad.isEnabled() && !jcbFechas.isEnabled() ) {
            
            jcbFechas.setEnabled(true);
            meseroSeleccionado =(Mesero) jcbMeseros.getSelectedItem();
            cargarComboFechas(meseroSeleccionado);
            //activarListenersFechas();
                DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma);
                
                borrarFila();
                if (meseroSeleccionado!=null && fechaSeleccionada != null){
                cargarTabla(meseroSeleccionado,fechaSeleccionada);
                sumarTotal();
                jcbMeseros.setEnabled(false);


                }
        }else if (jcbMeseros.isEnabled() && jcbActividad.isEnabled() && !jcbFechas.isEnabled()){
            
                meseroSeleccionado =(Mesero) jcbMeseros.getSelectedItem();
                
                    jcbFechas.setEnabled(true);
                    cargarComboFechas();    
                
                    DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                    fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma);
                    jcbActividad.removeAllItems();
                    jcbActividad.setEnabled(false);
                    if (meseroSeleccionado!= null && fechaSeleccionada!=null){
                        cargarTabla(meseroSeleccionado, fechaSeleccionada);
                        sumarTotal();
                    }
            }
        }catch(NumberFormatException | NullPointerException e){}
    }//GEN-LAST:event_jcbFechasMouseClicked

    private void jcbFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFechasActionPerformed
        try{    
            borrarFila();
            
            if (!jcbMeseros.isEnabled() && jcbMeseros.getItemCount() == 0 && !jcbActividad.isEnabled()) {
                jcbFechas.setEnabled(true);
                DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma);
                if (fechaSeleccionada!=null){
                    borrarFila();
                    cargarTabla(fechaSeleccionada);
                    sumarTotal();
                }
                
            } else if (!jcbMeseros.isEnabled() && jcbMeseros.getItemCount() > 0 && !jcbActividad.isEnabled()) {
                meseroSeleccionado = (Mesero) jcbMeseros.getSelectedItem();
                if (meseroSeleccionado!=null){
                    jcbFechas.setEnabled(true);
                    if (jcbFechas.getItemCount()==0){
                    cargarComboFechas(meseroSeleccionado);
                    }
                    borrarFila();
                    DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                    fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma);
                    if (fechaSeleccionada!=null){
                    cargarTabla(meseroSeleccionado, fechaSeleccionada);
                    sumarTotal();
                    }
                    
                }
            }else if (jcbMeseros.isEnabled() && jcbActividad.isEnabled()){
            
                meseroSeleccionado =(Mesero) jcbMeseros.getSelectedItem();
                
                    jcbFechas.setEnabled(true);
                    cargarComboFechas();    
                
                    DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                    fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma);
                    jcbActividad.removeAllItems();
                    jcbActividad.setEnabled(false);
                    if (meseroSeleccionado!= null && fechaSeleccionada!=null){
                        cargarTabla(meseroSeleccionado, fechaSeleccionada);
                        sumarTotal();
                    }
            }        
        }catch(NumberFormatException | NullPointerException e){}    
    }//GEN-LAST:event_jcbFechasActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        //desactivarListenersMeseros();
        //desactivarListenersFechas();
        jcbActividad.removeAllItems();
        jcbActividad.setEnabled(false);
        borrarFila();
        jcbFechas.removeAllItems();
        jcbMeseros.removeAllItems();
        jcbFechas.setEnabled(false);
        jcbMeseros.setEnabled(false);
    }//GEN-LAST:event_jbBorrarActionPerformed

    private void jcbActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbActividadMouseClicked
        try{
            if (!jcbMeseros.isEnabled() & jcbMeseros.getItemCount()>0 & jcbFechas.isEnabled()){
                if (!jcbActividad.isEnabled()){
                    jcbActividad.setEnabled(true);
                    cargarComboActividad();
                    meseroSeleccionado=(Mesero)jcbMeseros.getSelectedItem();
                    DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                    fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma);
                }    
            }else if(!jcbMeseros.isEnabled() & jcbMeseros.getItemCount()==0 & jcbFechas.isEnabled()){
                        if (!jcbActividad.isEnabled()){
                            jcbActividad.setEnabled(true);
                            cargarComboActividad();
                            DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                            fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma);
                        }    
            }else if (!jcbMeseros.isEnabled() & !jcbFechas.isEnabled()){
                        if (!jcbActividad.isEnabled()){
                            jcbActividad.setEnabled(true);
                            cargarComboActividad();
                            actividadSeleccionada = (Actividad)jcbActividad.getSelectedItem();
                        }
            }else if (jcbMeseros.isEnabled()){
                        if (!jcbActividad.isEnabled()){
                            jcbActividad.setEnabled(true);
                            cargarComboActividad();
                            actividadSeleccionada = (Actividad)jcbActividad.getSelectedItem();
                        }
            } 
        }catch(NumberFormatException | NullPointerException e){}    
    }//GEN-LAST:event_jcbActividadMouseClicked

    private void jcbActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbActividadActionPerformed
        try{
            if (!jcbMeseros.isEnabled() & jcbMeseros.getItemCount()>0 & jcbFechas.isEnabled() & jcbActividad.isEnabled()){
                    actividadSeleccionada = (Actividad) jcbActividad.getSelectedItem();
                    meseroSeleccionado=(Mesero)jcbMeseros.getSelectedItem();
                    DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                    fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma);
                    borrarFila();
                    if (meseroSeleccionado!=null && fechaSeleccionada !=null && actividadSeleccionada!=null){
                    cargarTabla(meseroSeleccionado,fechaSeleccionada,actividadSeleccionada);
                    sumarTotal();
                    }
            }else if(!jcbMeseros.isEnabled() & jcbMeseros.getItemCount()==0 & jcbFechas.isEnabled()){
                        actividadSeleccionada = (Actividad) jcbActividad.getSelectedItem();
                        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                        fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma);
                        borrarFila();
                        if (fechaSeleccionada !=null && actividadSeleccionada!=null){
                        cargarTabla(fechaSeleccionada, actividadSeleccionada);
                        sumarTotal();
                        }
            }else if (!jcbMeseros.isEnabled() & !jcbFechas.isEnabled()){
                        actividadSeleccionada = (Actividad) jcbActividad.getSelectedItem();
                        borrarFila();
                        if (actividadSeleccionada!=null){
                        cargarTabla(actividadSeleccionada);
                        sumarTotal();
                        }
                    } else if (jcbMeseros.isEnabled()){
                        meseroSeleccionado = (Mesero) jcbMeseros.getSelectedItem();
                        borrarFila();
                        if (meseroSeleccionado!= null && actividadSeleccionada!=null){
                        actividadSeleccionada = (Actividad) jcbActividad.getSelectedItem();
                        cargarTabla(meseroSeleccionado, actividadSeleccionada );
                        sumarTotal();
                        }
                    }
        }catch(NumberFormatException | NullPointerException e){}   
    }//GEN-LAST:event_jcbActividadActionPerformed

    private void jbVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerDetalleActionPerformed
        int filaSeleccionada=jtListaDetalles.getSelectedRow();
        if(filaSeleccionada!=-1){
            int idPedido=Integer.parseInt(String.valueOf(jtListaDetalles.getValueAt(filaSeleccionada,0)));
            PrincipalView.detallePedidosView(idPedido);
            }else{
                JOptionPane.showMessageDialog(null, "Debe Seleccionar una Fila.");
        }
    }//GEN-LAST:event_jbVerDetalleActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbListarTodo;
    private javax.swing.JButton jbVerDetalle;
    private javax.swing.JComboBox<Actividad> jcbActividad;
    private javax.swing.JComboBox<String> jcbFechas;
    private javax.swing.JComboBox<Mesero> jcbMeseros;
    private javax.swing.JLabel jlActividad;
    private javax.swing.JLabel jlCerrar;
    private javax.swing.JLabel jlDetalles;
    private javax.swing.JLabel jlDetalles1;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlFondoImage;
    private javax.swing.JLabel jlFondoTrasparente1;
    private javax.swing.JLabel jlMesero;
    private javax.swing.JLabel jlTituloIngresos;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JPanel jpFondo;
    private javax.swing.JTable jtListaDetalles;
    private javax.swing.JTextField jtTotal;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera(){
        modelo.addColumn("Pedido");
        modelo.addColumn("Mesero");
        modelo.addColumn("Mesa");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Importe");
        modelo.addColumn("Estado");
        jtListaDetalles.setModel(modelo);
    }
    
    private void sumarTotal(){
        int f= modelo.getRowCount()-1;
        double total=0;
        for(;f>=0;f--){
            double valor = Double.parseDouble((String.valueOf(modelo.getValueAt(f, 5))));
            total+=valor;
        }
        total = Math.round(total * 100.0) / 100.0;
        jtTotal.setText(String.valueOf(total));
    }
    
        private void estilos(){
        jlFondoTrasparente1.setBackground(new Color(35,34,36,160));
        
    }
    
    private void cargarTabla(Mesero mesero){
        ArrayList<Pedido> listaPedidosPorMesero = pedidoData.obtenerPedidosPorMesero(mesero.getIdMesero());
        if (!listaPedidosPorMesero.isEmpty()){
            for(Pedido pedidos:pedidoData.obtenerPedidosPorMesero(mesero.getIdMesero())){
                DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                String fechaConFormato = pedidos.getFechaPedido().format(forma);
                    modelo.addRow(new Object[]{
                        pedidos.getIdPedido(),
                        pedidos.getMesero().getIdMesero(),
                        pedidos.getMesa().getIdMesa(),
                        fechaConFormato,
                        pedidos.getHoraPedido(),
                        pedidos.getImporte(),
                        pedidos.getActividad()
                    });
            }
        }else{
            JOptionPane.showMessageDialog(null,"El mesero Seleccionado no tiene Pedidos");
        }
        acomodarTabla();
    }
    
    private void cargarComboFechas(Mesero mesero){
        List<LocalDate> listaFechas = pedidoData.FechasConPedidos(mesero);
        if (!listaFechas.isEmpty()){
            for (LocalDate fecha:listaFechas){
                DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                String fechaConFormato = fecha.format(forma);
                jcbFechas.addItem(fechaConFormato);
            }
        }else{
            JOptionPane.showMessageDialog(null,"No Tiene fechas con pedidos.");
            jcbFechas.setEnabled(false);
            jcbFechas.removeAllItems();
        }    
    }
    
    private void cargarComboFechas(){
        jcbFechas.removeAllItems();
        List<LocalDate> listaFechas = pedidoData.FechasConPedidos();
        if (!listaFechas.isEmpty()){
            for (LocalDate fecha:listaFechas){
                DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                String fechaConFormato = fecha.format(forma);
                jcbFechas.addItem(fechaConFormato);
            }
        }else{
            JOptionPane.showMessageDialog(null,"No Tiene fechas con pedidos.");
        }    
    }
    
    private void cargarTabla(Mesero mesero, LocalDate fecha){
        List<Pedido> listaPedidos = new ArrayList();
        listaPedidos = pedidoData.Pedidos(mesero, fecha);
        for (Pedido pedidos:listaPedidos){
            DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
            String fechaConFormato = pedidos.getFechaPedido().format(forma);
            modelo.addRow(new Object[]{
                pedidos.getIdPedido(),
                    pedidos.getMesero().getIdMesero(),
                    pedidos.getMesa().getIdMesa(),
                    fechaConFormato,
                    pedidos.getHoraPedido(),
                    pedidos.getImporte(),
                    pedidos.getActividad() 
            });
        }
        acomodarTabla();
    }
    
    private void cargarTabla(Mesero mesero, LocalDate fecha, Actividad actividad){
        List<Pedido> listaPedidos = new ArrayList();
        listaPedidos = pedidoData.Pedidos(mesero, fecha, actividad);
        if (!listaPedidos.isEmpty()){
            for (Pedido pedidos:listaPedidos){
                DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                String fechaConFormato = pedidos.getFechaPedido().format(forma);
                modelo.addRow(new Object[]{
                    pedidos.getIdPedido(),
                        pedidos.getMesero().getIdMesero(),
                        pedidos.getMesa().getIdMesa(),
                        fechaConFormato,
                        pedidos.getHoraPedido(),
                        pedidos.getImporte(),
                        pedidos.getActividad() 
                });
            }
        }else{
            DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
            String fechaConFormato = fecha.format(forma);
            JOptionPane.showMessageDialog(null, mesero.getNombre() + " no tiene ninguna mesa "+ actividad + " en la fecha "+ fechaConFormato);
        }    
        acomodarTabla();
    }
    
    private void cargarTabla(Mesero mesero, Actividad actividad){
        List<Pedido> listaPedidos = new ArrayList();
        listaPedidos = pedidoData.Pedidos(mesero, actividad);
        if (!listaPedidos.isEmpty()){
            for (Pedido pedidos:listaPedidos){
                DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                String fechaConFormato = pedidos.getFechaPedido().format(forma);
                modelo.addRow(new Object[]{
                    pedidos.getIdPedido(),
                        pedidos.getMesero().getIdMesero(),
                        pedidos.getMesa().getIdMesa(),
                        fechaConFormato,
                        pedidos.getHoraPedido(),
                        pedidos.getImporte(),
                        pedidos.getActividad() 
                });
            }
        }else{
            if (jcbActividad.isEnabled()){
            JOptionPane.showMessageDialog(null, mesero.getNombre() + " no tiene ninguna mesa "+ actividad);
            }
        }    
        acomodarTabla();
    }
    
    private void cargarTabla(LocalDate fecha, Actividad actividad){
        List<Pedido> listaPedidos = new ArrayList();
        listaPedidos = pedidoData.Pedidos(fecha, actividad);
        
        if (!listaPedidos.isEmpty()){
            for (Pedido pedidos:listaPedidos){
                DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                String fechaConFormato = pedidos.getFechaPedido().format(forma);
                modelo.addRow(new Object[]{
                    pedidos.getIdPedido(),
                        pedidos.getMesero().getIdMesero(),
                        pedidos.getMesa().getIdMesa(),
                        fechaConFormato,
                        pedidos.getHoraPedido(),
                        pedidos.getImporte(),
                        pedidos.getActividad() 
                });
            }
            
        }else{
            DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
            String fechaConFormato = fecha.format(forma);
            JOptionPane.showMessageDialog(null, mesero.getNombre() + " no tiene ninguna mesa "+ actividad + " en la fecha "+ fechaConFormato);
        }    
        acomodarTabla();
    }
    
        private void cargarTabla(Actividad actividad){
        List<Pedido> listaPedidos = new ArrayList();
        listaPedidos = pedidoData.Pedidos(actividad);
        if (!listaPedidos.isEmpty()){
            for (Pedido pedidos:listaPedidos){
                DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                String fechaConFormato = pedidos.getFechaPedido().format(forma);
                modelo.addRow(new Object[]{
                    pedidos.getIdPedido(),
                        pedidos.getMesero().getIdMesero(),
                        pedidos.getMesa().getIdMesa(),
                        fechaConFormato,
                        pedidos.getHoraPedido(),
                        pedidos.getImporte(),
                        pedidos.getActividad() 
                });
            }
        }else{
            JOptionPane.showMessageDialog(null, "no hay ningun pedido con estado: "+actividad);
        }    
        acomodarTabla();
    }
    
    private void cargarTabla(LocalDate fecha){
        List<Pedido> listaPedidos = pedidoData.listarTodosLosPedidos();
        if (!listaPedidos.isEmpty()){
            for (Pedido pedidos:listaPedidos){
                if (pedidos.getFechaPedido().isEqual(fecha)){
                    DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                    String fechaConFormato = pedidos.getFechaPedido().format(forma);
                    modelo.addRow(new Object[]{
                            pedidos.getIdPedido(),
                            pedidos.getMesero().getIdMesero(),
                            pedidos.getMesa().getIdMesa(),
                            fechaConFormato,
                            pedidos.getHoraPedido(),
                            pedidos.getImporte(),
                            pedidos.getActividad() 
                    });
                }    
            }
        acomodarTabla();
        }else{
            JOptionPane.showMessageDialog(null,"La lista esta Vacia.");
        }
    }

    private void cargarTabla(){
        
        List<Pedido> listaPedidos = new ArrayList();
                listaPedidos = pedidoData.listarTodosLosPedidos();
        for(Pedido pedidos:listaPedidos){
            DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
            String fechaConFormato = pedidos.getFechaPedido().format(forma);
            modelo.addRow(new Object[]{
                pedidos.getIdPedido(),
                    pedidos.getMesero().getIdMesero(),
                    pedidos.getMesa().getIdMesa(),
                    fechaConFormato,
                    pedidos.getHoraPedido(),
                    pedidos.getImporte(),
                    pedidos.getActividad() 
            });
        }
        acomodarTabla();
    }
    
    private void cargarComboMeseros(){
        jcbMeseros.removeAllItems();
        for(Mesero m:pedidoData.ListarMeserosConPedidos()){
            jcbMeseros.addItem(m);
        }
    }
    
    private void cargarComboActividad(){
        jcbActividad.addItem(Actividad.COBRADA);
        jcbActividad.addItem(Actividad.INICIADA);
        jcbActividad.addItem(Actividad.CANCELADA);
        jcbActividad.addItem(Actividad.FACTURADA);
    }
    
    private void acomodarTabla(){
        jtListaDetalles.getColumnModel().getColumn(0).setPreferredWidth(40); // Ajustar el ancho de la segunda columna
        jtListaDetalles.getColumnModel().getColumn(1).setPreferredWidth(40);
        jtListaDetalles.getColumnModel().getColumn(2).setPreferredWidth(30);
        jtListaDetalles.getColumnModel().getColumn(3).setPreferredWidth(60);
        jtListaDetalles.getColumnModel().getColumn(4).setPreferredWidth(60);
        jtListaDetalles.getColumnModel().getColumn(5).setPreferredWidth(60);
    }
    
     private void borrarFila(){
        int f=jtListaDetalles.getRowCount()-1;
        for(;f>=0;f--){
            modelo.removeRow(f);
        }
    }
     
     private void activarListenersMeseros(){
         for (ActionListener listener : listenersMeseros) {
             jcbMeseros.addActionListener(listener);
            }
     }
     
     private void desactivarListenersMeseros(){
         for (ActionListener listener : listenersMeseros) {
             jcbMeseros.removeActionListener(listener);
            }
     }
     
     private void activarListenersFechas(){
         for (ActionListener listener : listenersFechas) {
             jcbFechas.addActionListener(listener);
            }
     }
     
     private void desactivarListenersFechas(){
         for (ActionListener listener : listenersFechas) {
             jcbFechas.removeActionListener(listener);
            }
     }
}
