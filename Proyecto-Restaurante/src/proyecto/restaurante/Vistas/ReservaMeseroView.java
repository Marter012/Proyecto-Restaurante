/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Vistas;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import proyecto.restaurante.Control.MesaData;
import proyecto.restaurante.Control.ReservaData;
import proyecto.restaurante.Entidades.Mesa;
import proyecto.restaurante.Entidades.Reserva;


/**
 *
 * @author Emito
 */
public class ReservaMeseroView extends javax.swing.JInternalFrame {
    private Reserva r;
    private Mesa mesa;
    private MesaData mesaData;
    private ReservaData reservaData; 
    private final int DNIMesero;
    
    private DefaultTableModel modelo = new DefaultTableModel(){
        public boolean isCellEditable(int f, int c){
                return false;
        }
    };
    
    public ReservaMeseroView(int DNI) {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        estilos();
        DNIMesero = DNI;
        armarCabecera();
        jcbFechas.setEnabled(false);
    }
    
    
    public void estilos(){
        TransparenciaCargar.setBackground(new Color(35,34,36,190));
        TransparenciaModificar.setBackground(new Color(35,34,36,190));
    }
    
    private void borrarFilas(){
        int f = jtReservas.getRowCount()-1;
        for(;f >= 0; f--){
            modelo.removeRow(f);
        }
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
        jLabel3 = new javax.swing.JLabel();
        jcbFechas = new javax.swing.JComboBox<>();
        Cerrar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtReservas = new javax.swing.JTable();
        jbCancelarReserva = new javax.swing.JToggleButton();
        TransparenciaCargar = new javax.swing.JLabel();
        TransparenciaModificar = new javax.swing.JLabel();
        jlIdMesero = new javax.swing.JLabel();
        FondoImagen = new javax.swing.JLabel();

        Fondo.setBackground(new java.awt.Color(0, 0, 0));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fechas con reservas");
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

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
        Fondo.add(jcbFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 270, -1));

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

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Carga y modificacion de Reservas");
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Seleccione Fecha");
        Fondo.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 190, 30));

        jtReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtReservas);

        Fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, 270));

        jbCancelarReserva.setText("Cancelar Reserva");
        jbCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarReservaActionPerformed(evt);
            }
        });
        Fondo.add(jbCancelarReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 510, -1, -1));

        TransparenciaCargar.setOpaque(true);
        Fondo.add(TransparenciaCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 46, 500, 140));

        TransparenciaModificar.setOpaque(true);
        Fondo.add(TransparenciaModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 500, 360));
        Fondo.add(jlIdMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 20, 30));

        FondoImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/restaurante/resources/imagenes/FondoInternalFrames.jpg"))); // NOI18N
        Fondo.add(FondoImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 550, 590));

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

    private void CerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseExited
        // TODO add your handling code here:
        Cerrar.setForeground(Color.white);
    }//GEN-LAST:event_CerrarMouseExited

    private void CerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseEntered
        // TODO add your handling code here:
        Cerrar.setForeground(Color.gray);
    }//GEN-LAST:event_CerrarMouseEntered

    private void jcbFechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbFechasMouseClicked
        if (!jcbFechas.isEnabled()){
            jcbFechas.setEnabled(true);
            cargarCombo();
        }
    }//GEN-LAST:event_jcbFechasMouseClicked

    private void jcbFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFechasActionPerformed
        completarTabla();
        
    }//GEN-LAST:event_jcbFechasActionPerformed

    private void jbCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarReservaActionPerformed
        mesa = new Mesa();
        mesaData = new MesaData();
        reservaData = new ReservaData();
        int Fila = jtReservas.getSelectedRow();
        if(Fila != -1){
            mesa = new Mesa();
            int idMesa = Integer.parseInt(String.valueOf(jtReservas.getValueAt(Fila,6)));
            System.out.println(Fila);
            int DNICliente = Integer.parseInt(String.valueOf(jtReservas.getValueAt(Fila,2)));
            mesa = mesaData.obtenerMesa(idMesa);
            reservaData.eliminarReserva(DNICliente);
            mesaData.liberarMesa(mesa);
            cargarCombo();
            completarTabla();
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione una mesa.");
        } 
        
        
    }//GEN-LAST:event_jbCancelarReservaActionPerformed

    private void armarCabecera(){       
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Dni");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Estado");
        modelo.addColumn("Mesa");
        jtReservas.setModel(modelo);

    }
    
    private void cargarCombo(){
        reservaData = new ReservaData();
        for (LocalDate fecha:reservaData.listarSoloFecha()){
            jcbFechas.addItem(fecha);
        }
    }
    
    private void completarTabla(){
        borrarFilas();
        LocalDate dataFecha = (LocalDate)jcbFechas.getSelectedItem();
       reservaData =  new ReservaData();
       for (Reserva reservas:reservaData.listarReservasPorFecha(dataFecha)){
             modelo.addRow(new Object[]{
               reservas.getIdReserva(),
               reservas.getNombreCliente(),
               reservas.getDni(),
               reservas.getFecha(),
               reservas.getHora(),
               reservas.isEstado(),
               reservas.getMesa().getIdMesa(),
               
            });
       }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel FondoImagen;
    private javax.swing.JLabel TransparenciaCargar;
    private javax.swing.JLabel TransparenciaModificar;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jbCancelarReserva;
    private javax.swing.JComboBox<LocalDate> jcbFechas;
    private javax.swing.JLabel jlIdMesero;
    private javax.swing.JTable jtReservas;
    // End of variables declaration//GEN-END:variables
}
