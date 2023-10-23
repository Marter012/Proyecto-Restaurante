/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Vistas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import proyecto.restaurante.Control.MesaData;
import proyecto.restaurante.Control.MeseroData;
import proyecto.restaurante.Control.PedidoData;
import proyecto.restaurante.Entidades.Mesa;
import proyecto.restaurante.Entidades.Mesero;
import proyecto.restaurante.Entidades.Pedido;

/**
 *
 * @author Emito
 */
public class PedidosView extends javax.swing.JInternalFrame {

    PedidoData pedidoData = new PedidoData();
    private Mesero mesero;
    private MeseroData meseroData;
    private int DNIMesero;
    private MesaData mesaData;
    
    private DefaultTableModel modelo = new DefaultTableModel(){
        public boolean isCellEditable(int f, int c){
                return false;
        }
    };
    /**
     * Creates new form CargaMeserosView
     * @param DNI
     */
    public PedidosView(int DNI) {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        estilos();
        DNIMesero = DNI;     
        System.out.println(DNIMesero);
        armarCabecera();
        borrarFilas();
        jcbMesas.setEnabled(false);
    }
    private void estilos(){
        Fondo.setBackground(new Color(35,34,36,210));
        jpMesas.setBackground(new Color(35,34,36,160));
        jpPedidos.setBackground(new Color(35,34,36,160));
    }
    
    public void cargarComboBox(){
        mesaData = new MesaData();
        meseroData = new MeseroData();
        mesero = new Mesero();
        mesero = meseroData.buscarMeseroPorDNI(41521048);
        
        
        for (Mesa mesas: mesaData.verificacionMesaOcupada(mesero.getIdMesero())){
            jcbMesas.addItem(mesas);
        }
    }
    
    private void armarCabecera(){       
        
        modelo.addColumn("Mesa");
        modelo.addColumn("Pedido");
        modelo.addColumn("Importe");        
        jtPedidos.setModel(modelo);

    }
    
     private void borrarFilas(){
        int f = jtPedidos.getRowCount()-1;
        for(;f >= 0; f--){
            modelo.removeRow(f);
        }
    }
     
    private void cargarTabla(){
        borrarFilas();
        pedidoData = new PedidoData();
        meseroData = new MeseroData();
        mesero = new Mesero();
        mesero = meseroData.buscarMeseroPorDNI(DNIMesero);        
        List<Pedido> listaPedidos = new ArrayList();  
        
        Mesa mesaSeleccionada = (Mesa)jcbMesas.getSelectedItem();
        listaPedidos = pedidoData.listarPedidosPorMesa(mesaSeleccionada.getIdMesa(), mesero.getIdMesero());
        for (Pedido pedidos:listaPedidos){
            modelo.addRow(new Object[]{
            pedidos.getMesa(),
            pedidos.getIdPedido(),
            pedidos.getImporte()
            });
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
        Cerrar = new javax.swing.JLabel();
        jpMesas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbMesas = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jtHora = new javax.swing.JTextField();
        jpPedidos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtPedidos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        FondoImagen = new javax.swing.JLabel();

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

        jpMesas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("adasdadadadasdasdadadasdasdasdasd");
        jpMesas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 11, 346, 24));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seleccione mesa :");
        jpMesas.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 53, -1, 27));

        jcbMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbMesasMouseClicked(evt);
            }
        });
        jcbMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMesasActionPerformed(evt);
            }
        });
        jpMesas.add(jcbMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 56, 221, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Hora de ingreso :");
        jpMesas.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));
        jpMesas.add(jtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 210, 30));

        Fondo.add(jpMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 500, 130));

        jpPedidos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtPedidos);

        jpPedidos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 480, 330));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pedidos por mesa");
        jpPedidos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, -1, -1));

        jButton1.setText("Ver detalle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jpPedidos.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 19, -1, -1));

        Fondo.add(jpPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 500, 410));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcbMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbMesasMouseClicked
        if(!jcbMesas.isEnabled()){
            jcbMesas.setEnabled(true);
            cargarComboBox();
            cargarTabla();
        }else{
            cargarTabla();
        }
    }//GEN-LAST:event_jcbMesasMouseClicked

    private void jcbMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMesasActionPerformed
        
    }//GEN-LAST:event_jcbMesasActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel FondoImagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<Mesa> jcbMesas;
    private javax.swing.JPanel jpMesas;
    private javax.swing.JPanel jpPedidos;
    private javax.swing.JTextField jtHora;
    private javax.swing.JTable jtPedidos;
    // End of variables declaration//GEN-END:variables
}
