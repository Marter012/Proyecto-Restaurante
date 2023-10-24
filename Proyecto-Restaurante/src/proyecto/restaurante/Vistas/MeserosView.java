/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Vistas;

import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import proyecto.restaurante.Control.MesaData;
import proyecto.restaurante.Control.MeseroData;
import proyecto.restaurante.Control.PedidoData;
import proyecto.restaurante.Control.ReservaData;
import proyecto.restaurante.Entidades.Mesa;
import proyecto.restaurante.Entidades.Mesero;
import proyecto.restaurante.Entidades.Pedido;
import proyecto.restaurante.Entidades.Reserva;

/**
 *
 * @author Emito
 */
public class MeserosView extends javax.swing.JInternalFrame {
    Mesa mesa = new Mesa();
    MesaData mesaData = new MesaData();
    Mesero mesero = new Mesero();
    MeseroData meseroData = new MeseroData();
    Pedido pedido = new Pedido();
    PedidoData pedidoData = new PedidoData();
    ReservaData reservaData = new ReservaData();
    private int DNIMesero; 
        
    private DefaultTableModel modelo = new DefaultTableModel(){
        public boolean isCellEditable(int f, int c){
                return false;
        }
    };
    /**
     * Creates new form CargaMeserosView
     * @param hola
     */
    public MeserosView(int DNI) {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        estilos();   
        armarCabecera();
        cargarComboBox();
        borrarFilas();
        DNIMesero = DNI;
        cargarTablaLibre();
        jrbMesasLibres.setSelected(true);
    }
    
    private void estilos(){
        Fondo.setBackground(new Color(35,34,36,210));
        TransparenciaAsignar.setBackground(new Color(35,34,36,190));
        TransparenciaListado.setBackground(new Color(35,34,36,190));
        jbLiberar.setEnabled(false);
        jbDarBaja.setEnabled(false);
                
    }
    public void cargarComboBox(){
        mesaData = new MesaData();
        
        for (Mesa mesas: mesaData.obtenerMesasLibres()){
            jcbMesas.addItem(mesas);
        }
    }
    private void armarCabecera(){       
        
        modelo.addColumn("Mesa");
        modelo.addColumn("Capacidad");
        modelo.addColumn("Nombre");
        modelo.addColumn("Pedidos");        
        jtListas.setModel(modelo);

    }
    private void borrarFilas(){
        int f = jtListas.getRowCount()-1;
        for(;f >= 0; f--){
            modelo.removeRow(f);
        }
    }
        
    private void activarTablaLibre(){
        jrbMesasLibres.setSelected(true);
        borrarFilas();
        if(jrbMesasLibres.isSelected()){
            jrbMesasOcupadas.setSelected(false);
            jrbMesasReservadas.setSelected(false);
        }
        cargarTablaLibre();
        jbDarBaja.setEnabled(false);
        jbLiberar.setEnabled(false);
    }
    
    private void activarTablaOcupadas(){
        jrbMesasOcupadas.setSelected(true);
        borrarFilas();
        if(jrbMesasOcupadas.isSelected()){
            jrbMesasLibres.setSelected(false);
            jrbMesasReservadas.setSelected(false);
        }
        cargarTablaOcupada();
        jbDarBaja.setEnabled(false);
        jbLiberar.setEnabled(true);
    }
    
    private void activarTablaReserva(){
        jrbMesasReservadas.setSelected(true);
        borrarFilas();
        if(jrbMesasReservadas.isSelected()){
            jrbMesasLibres.setSelected(false);
            jrbMesasOcupadas.setSelected(false);
            
        }
        cargarTablaReserva();
        jbDarBaja.setEnabled(true);
        jbLiberar.setEnabled(false);    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Fondo = new javax.swing.JPanel();
        Cerrar = new javax.swing.JLabel();
        TransparenciaAsignar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbMesas = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jbAsignar = new javax.swing.JButton();
        TransparenciaListado = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jrbMesasLibres = new javax.swing.JRadioButton();
        jrbMesasOcupadas = new javax.swing.JRadioButton();
        jrbMesasReservadas = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListas = new javax.swing.JTable();
        jbLiberar = new javax.swing.JButton();
        jbDarBaja = new javax.swing.JButton();
        FondoImagen = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        setPreferredSize(new java.awt.Dimension(540, 590));

        Fondo.setBackground(new java.awt.Color(0, 0, 0));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        TransparenciaAsignar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seleccionar Mesa");
        TransparenciaAsignar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 66, -1, 20));

        jcbMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMesasActionPerformed(evt);
            }
        });
        TransparenciaAsignar.add(jcbMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 66, 213, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Asignar Mesas");
        TransparenciaAsignar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 11, -1, -1));

        jbAsignar.setText("Asignar");
        jbAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAsignarActionPerformed(evt);
            }
        });
        TransparenciaAsignar.add(jbAsignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));

        Fondo.add(TransparenciaAsignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 460, 150));

        TransparenciaListado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jrbMesasLibres.setBackground(new java.awt.Color(255, 255, 255));
        jrbMesasLibres.setText("Mesas libres");
        jrbMesasLibres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMesasLibresActionPerformed(evt);
            }
        });

        jrbMesasOcupadas.setBackground(new java.awt.Color(255, 255, 255));
        jrbMesasOcupadas.setText("Mesas Ocupadas");
        jrbMesasOcupadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMesasOcupadasActionPerformed(evt);
            }
        });

        jrbMesasReservadas.setBackground(new java.awt.Color(255, 255, 255));
        jrbMesasReservadas.setText("Mesas Reservadas");
        jrbMesasReservadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMesasReservadasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jrbMesasLibres)
                .addGap(71, 71, 71)
                .addComponent(jrbMesasOcupadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jrbMesasReservadas)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMesasLibres)
                    .addComponent(jrbMesasOcupadas)
                    .addComponent(jrbMesasReservadas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TransparenciaListado.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jtListas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtListas);

        TransparenciaListado.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 54, 440, 250));

        jbLiberar.setText("Liberar Mesa");
        jbLiberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLiberarActionPerformed(evt);
            }
        });
        TransparenciaListado.add(jbLiberar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));

        jbDarBaja.setText("Dar de baja Reserva");
        jbDarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDarBajaActionPerformed(evt);
            }
        });
        TransparenciaListado.add(jbDarBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, -1, -1));

        Fondo.add(TransparenciaListado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 460, 360));

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

    private void jbAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAsignarActionPerformed
        mesa = (Mesa) jcbMesas.getSelectedItem();
        mesaData.ocuparMesa(mesa);        
        mesero = meseroData.buscarMeseroPorDNI(DNIMesero);  
        pedido = new Pedido(mesa,mesero,LocalDate.now(),LocalTime.now(),250,true);
        pedidoData.guardarPedido(pedido);
        cargarComboBox();
        activarTablaOcupadas();
        
    }//GEN-LAST:event_jbAsignarActionPerformed

    private void jcbMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMesasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbMesasActionPerformed

    private void jrbMesasLibresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMesasLibresActionPerformed
       activarTablaLibre();
    }//GEN-LAST:event_jrbMesasLibresActionPerformed

    private void jrbMesasOcupadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMesasOcupadasActionPerformed
       activarTablaOcupadas();
    }//GEN-LAST:event_jrbMesasOcupadasActionPerformed

    private void jrbMesasReservadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMesasReservadasActionPerformed
        activarTablaReserva();
    }//GEN-LAST:event_jrbMesasReservadasActionPerformed

    private void jbDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarBajaActionPerformed
        int Fila = jtListas.getSelectedRow();
        if(Fila != -1){
            mesa = new Mesa();
            int idMesa = Integer.parseInt(String.valueOf(jtListas.getValueAt(Fila,0)));
            mesa = mesaData.obtenerMesa(idMesa);
            mesaData.liberarMesa(mesa);
            reservaData.eliminarReserva(Fila);
            activarTablaLibre();
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione una mesa.");
        }     
    }//GEN-LAST:event_jbDarBajaActionPerformed

    private void jbLiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLiberarActionPerformed
        int Fila = jtListas.getSelectedRow();
        if(Fila != -1){
            mesa = new Mesa();
            int idMesa = Integer.parseInt(String.valueOf(jtListas.getValueAt(Fila,0)));
            mesa = mesaData.obtenerMesa(idMesa);
            mesaData.liberarMesa(mesa);
            activarTablaLibre();
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione una mesa.");
        }        
    }//GEN-LAST:event_jbLiberarActionPerformed
   
    
    private void cargarTablaLibre(){
        List<Mesa> listaMesas = new ArrayList();
        listaMesas = mesaData.ListarMesasPorEstado("LIBRE");
        for (Mesa mesas:listaMesas){
            modelo.addRow(new Object[]{
            mesas.getIdMesa(),
            mesas.getCapacidad(),
            });
        }
    }
    
    private void cargarTablaOcupada(){
        List<Pedido> listaMesas = new ArrayList();
        mesaData = new MesaData();
        mesero = meseroData.buscarMeseroPorDNI(DNIMesero);
        listaMesas = pedidoData.obtenerMesasOcupadasPorMesero(mesero.getIdMesero());
        for (Pedido pedidos :listaMesas){
            modelo.addRow(new Object[]{
            pedidos.getMesa().getIdMesa(),
            pedidos.getMesa().getCapacidad()
            });
        }
    }
    
    private void cargarTablaReserva(){
        List<Reserva> listaReserva = new ArrayList();
        listaReserva = reservaData.listarReservasPorFecha(LocalDate.now());
        for (Reserva reserva : listaReserva){
            modelo.addRow(new Object[]{
            reserva.getMesa().getIdMesa(),
            reserva.getMesa().getCapacidad()
            });
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel FondoImagen;
    private javax.swing.JPanel TransparenciaAsignar;
    private javax.swing.JPanel TransparenciaListado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbAsignar;
    private javax.swing.JButton jbDarBaja;
    private javax.swing.JButton jbLiberar;
    private javax.swing.JComboBox<Mesa> jcbMesas;
    private javax.swing.JRadioButton jrbMesasLibres;
    private javax.swing.JRadioButton jrbMesasOcupadas;
    private javax.swing.JRadioButton jrbMesasReservadas;
    private javax.swing.JTable jtListas;
    // End of variables declaration//GEN-END:variables
}
