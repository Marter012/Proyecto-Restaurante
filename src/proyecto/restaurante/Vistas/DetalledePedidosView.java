/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Vistas;

import java.awt.Color;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import proyecto.restaurante.Control.Conexion;
import proyecto.restaurante.Control.DetallePedidoData;
import proyecto.restaurante.Control.PedidoData;
import proyecto.restaurante.Control.ProductoData;
import proyecto.restaurante.Entidades.DetallePedido;
import proyecto.restaurante.Entidades.Mesa;
import proyecto.restaurante.Entidades.Mesero;
import proyecto.restaurante.Entidades.Pedido;
import proyecto.restaurante.Entidades.Producto;


public final class DetalledePedidosView extends javax.swing.JInternalFrame {

    List<Producto> listaProducto = new ArrayList();
    List<DetallePedido> listaProductoCantidad = new ArrayList();
    
    private Connection con = null;
        
    private Producto producto = new Producto();
    private ProductoData productoData = new ProductoData();
    
    private Pedido pedido = new Pedido();
    private PedidoData pedidoData = new PedidoData();
    
    private DetallePedidoData detallePedidoData = new DetallePedidoData();
    private DetallePedido detallePedido = new DetallePedido();
    private List<DetallePedido> detallePedidos;
    
    private Mesero meseroActual;
    private Mesa mesaActual;
    private Pedido pedidoActual;
    private Mesa mesaAtendida;
    private Pedido pedidoSeleccionado;
    
    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int f, int c){
                return false;
        }
    };
    
    public DetalledePedidosView(){}
    
    public DetalledePedidosView(int idPedido) {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        estilos();
        jlIdPedido.setText(String.valueOf(idPedido));
        pedidoSeleccionado=pedidoData.buscarPedido(idPedido);
        mesaAtendida = pedidoSeleccionado.getMesa();
        jtNumeroMesa.setText(String.valueOf(mesaAtendida.getIdMesa()));
        armarCabecera();
        cargarTablaInicial();
        sumarTotal();
        jtTotal.setEnabled(false);
        
        
    }
    private void estilos(){
        Fondo.setBackground(new Color(35,34,36,210));
        jpSeleccionar.setBackground(new Color(35,34,36,160));
    }
   
    private void acomodarTabla(){
        jtPedidos.getColumnModel().getColumn(0).setPreferredWidth(35); // Ajustar el ancho de la segunda columna
        jtPedidos.getColumnModel().getColumn(1).setPreferredWidth(35);
        jtPedidos.getColumnModel().getColumn(3).setPreferredWidth(40);
        jtPedidos.getColumnModel().getColumn(4).setPreferredWidth(40);
    }
    
    private void armarCabecera(){ 
        modelo.addColumn("Detalle Nº");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Producto");
        modelo.addColumn("Precio");
        modelo.addColumn("Total");
        jtPedidos.setModel(modelo);

    }
     
     private void cargarTablaInicial(){
        
        try{
        List<DetallePedido> ListaDeDetalles = detallePedidoData.BuscarProductosConPedidos(pedidoSeleccionado.getIdPedido());
        for(DetallePedido detalles:ListaDeDetalles){
            Producto producto = productoData.buscarProducto(detalles.getIdProducto());
            double total = detalles.getCantidad()*producto.getPrecio();
            modelo.addRow(new Object[]{
                    detalles.getIdDetallePedido(),
                    detalles.getCantidad(),
                    producto.getNombre(),
                    producto.getPrecio(),
                    total
                    
                });
                
        }
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingrese numero para cantidad");
        }
        acomodarTabla();
     }
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        Fondo = new javax.swing.JPanel();
        Cerrar = new javax.swing.JLabel();
        jlIdMesa = new javax.swing.JLabel();
        jtNumeroMesa = new javax.swing.JLabel();
        jpSeleccionar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPedidos = new javax.swing.JTable();
        jlIdPedido = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtTotal = new javax.swing.JTextField();
        Titulo2 = new javax.swing.JLabel();
        FondoImagen = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        setPreferredSize(new java.awt.Dimension(540, 590));

        Fondo.setBackground(new java.awt.Color(0, 0, 0));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cerrar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        Cerrar.setForeground(new java.awt.Color(255, 255, 255));
        Cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cerrar.setText("Volver");
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

        jlIdMesa.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jlIdMesa.setForeground(new java.awt.Color(255, 255, 255));
        jlIdMesa.setText("Mesa Numero:");
        Fondo.add(jlIdMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 140, -1));

        jtNumeroMesa.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jtNumeroMesa.setForeground(new java.awt.Color(255, 255, 255));
        Fondo.add(jtNumeroMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 30, 20));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pedido Numero:");

        jtPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtPedidos);

        jlIdPedido.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlIdPedido.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Importe Total:");

        jtTotal.setBackground(new java.awt.Color(245, 233, 144));
        jtTotal.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jtTotal.setForeground(new java.awt.Color(51, 51, 51));

        Titulo2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        Titulo2.setForeground(new java.awt.Color(255, 255, 255));
        Titulo2.setText("Detalle de Pedidos.");

        javax.swing.GroupLayout jpSeleccionarLayout = new javax.swing.GroupLayout(jpSeleccionar);
        jpSeleccionar.setLayout(jpSeleccionarLayout);
        jpSeleccionarLayout.setHorizontalGroup(
            jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSeleccionarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpSeleccionarLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpSeleccionarLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Titulo2))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jpSeleccionarLayout.setVerticalGroup(
            jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSeleccionarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo2)
                .addGap(38, 38, 38)
                .addGroup(jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jlIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );

        Fondo.add(jpSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 470, 540));

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

    private void sumarTotal(){
        int f= modelo.getRowCount()-1;
        double total=0;
        for(;f>=0;f--){
            double valor = Double.parseDouble((String.valueOf(modelo.getValueAt(f, 4))));
            total+=valor;
        }
        jtTotal.setText(String.valueOf(total));
    }
        
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel FondoImagen;
    private javax.swing.JLabel Titulo2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlIdMesa;
    private javax.swing.JLabel jlIdPedido;
    private javax.swing.JPanel jpSeleccionar;
    private javax.swing.JLabel jtNumeroMesa;
    private javax.swing.JTable jtPedidos;
    private javax.swing.JTextField jtTotal;
    // End of variables declaration//GEN-END:variables
}
