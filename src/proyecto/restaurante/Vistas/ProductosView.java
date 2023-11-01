/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Vistas;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import proyecto.restaurante.Control.Conexion;
import proyecto.restaurante.Control.DetallePedidoData;
import proyecto.restaurante.Control.MesaData;
import proyecto.restaurante.Control.MeseroData;
import proyecto.restaurante.Control.PedidoData;
import proyecto.restaurante.Control.ProductoData;
import proyecto.restaurante.Entidades.DetallePedido;
import proyecto.restaurante.Entidades.Mesa;
import proyecto.restaurante.Entidades.Mesero;
import proyecto.restaurante.Entidades.Pedido;
import proyecto.restaurante.Entidades.Producto;

/**
 *
 * @author Emito
 */
public final class ProductosView extends javax.swing.JInternalFrame {

    List<Producto> listaProducto = new ArrayList();
    List<DetallePedido> listaProductoCantidad = new ArrayList();
    
    private Connection con = null;
    
    private Mesero mesero = new Mesero();
    private MeseroData meseroData = new MeseroData();
    
    private Mesa mesa = new Mesa();
    private MesaData mesaData = new MesaData();
    
        
    private Producto producto = new Producto();
    private ProductoData productoData = new ProductoData();
    
    private Pedido pedido = new Pedido();
    private PedidoData pedidoData = new PedidoData();
    
    private DetallePedidoData detallePedidoData = new DetallePedidoData();
    private DetallePedido detallePedido = new DetallePedido();
    
    private int idPedidoSelec = -1;
    private int DNIMesero;
    private int codigoMesa;
    private int idGuardado;
    private Mesero meseroActual;
    private Mesa mesaActual;
    private Pedido pedidoActual;
    
    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int f, int c){
                return false;
        }
    };
    
    public ProductosView(){}
    
    public ProductosView(int dni, int idMesa, int idPedido) {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        estilos();     
        meseroActual=meseroData.buscarMeseroPorDNI(dni);
        mesaActual = mesaData.obtenerMesa(idMesa);
        pedidoActual = pedidoData.buscarPedido(idPedido);
        armarCabecera();
        borrarFilas();
        jtNumeroMesa.setText(String.valueOf(idMesa));
        jcbProductos.setEnabled(false);
        jtCantidad.setEnabled(false);
        jbAgregar.setEnabled(false);
        jlIdPedido.setText(String.valueOf(idPedido));
        jtTotal.setText(String.valueOf(pedidoActual.getImporte()));
        cargarTablaInicial();
        sumarTotal();
        
        
    }
    private void estilos(){
        Fondo.setBackground(new Color(35,34,36,210));
        jpNuevoPedido.setBackground(new Color(35,34,36,160));
        jpSeleccionar.setBackground(new Color(35,34,36,160));
        jpSeccionConfirmar.setBackground(new Color(35,34,36,251));
    }
    
        
    public void cargarComboBoxProductos(){
        for (Producto productos: productoData.listarProductos()){
            jcbProductos.addItem(productos);
        }
    }
   
    
    private void armarCabecera(){ 
        modelo.addColumn("Detalle Nº");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Producto");
        modelo.addColumn("Precio");
        modelo.addColumn("Total");
        jtPedidos.setModel(modelo);

    }
    
     private void borrarFilas(){
        int f = jtPedidos.getRowCount()-1;
        for(;f >= 0; f--){
            modelo.removeRow(f);
        }
    }
     
     private void cargarTablaInicial(){
        
        try{
        List<DetallePedido> ListaDeDetalles = detallePedidoData.BuscarProductosConPedidos(pedidoActual.getIdPedido());
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
        
     }
     
    private void cargarProductoEnTabla(){
        Producto productoSeleccionado = (Producto) jcbProductos.getSelectedItem();
        try{
        int cantidad = Integer.parseInt(jtCantidad.getText());
        List<DetallePedido> ListaDeDetalles = detallePedidoData.BuscarProductosConPedidos(pedidoActual.getIdPedido());
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
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        Fondo = new javax.swing.JPanel();
        Cerrar = new javax.swing.JLabel();
        jlIdMesa = new javax.swing.JLabel();
        jtNumeroMesa = new javax.swing.JLabel();
        jpNuevoPedido = new javax.swing.JPanel();
        jlTituloAgregar = new javax.swing.JLabel();
        jpSeccionConfirmar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcbProductos = new javax.swing.JComboBox<>();
        jbAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtCantidad = new javax.swing.JTextField();
        jpSeleccionar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPedidos = new javax.swing.JTable();
        jlIdPedido = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtTotal = new javax.swing.JTextField();
        jbConfirmar = new javax.swing.JButton();
        jbEliminarProducto = new javax.swing.JButton();
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
        Fondo.add(jtNumeroMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 30, 20));

        jlTituloAgregar.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jlTituloAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jlTituloAgregar.setText("Seleccione productos:");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Agregar producto:");

        jcbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbProductosMouseClicked(evt);
            }
        });

        jbAgregar.setBackground(new java.awt.Color(153, 153, 0));
        jbAgregar.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jbAgregar.setForeground(new java.awt.Color(51, 51, 51));
        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad: ");

        jtCantidad.setBackground(new java.awt.Color(245, 233, 144));
        jtCantidad.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N

        javax.swing.GroupLayout jpSeccionConfirmarLayout = new javax.swing.GroupLayout(jpSeccionConfirmar);
        jpSeccionConfirmar.setLayout(jpSeccionConfirmarLayout);
        jpSeccionConfirmarLayout.setHorizontalGroup(
            jpSeccionConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSeccionConfirmarLayout.createSequentialGroup()
                .addGroup(jpSeccionConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSeccionConfirmarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jpSeccionConfirmarLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jpSeccionConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jbAgregar)
                .addGap(22, 22, 22))
        );
        jpSeccionConfirmarLayout.setVerticalGroup(
            jpSeccionConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSeccionConfirmarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSeccionConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpSeccionConfirmarLayout.createSequentialGroup()
                        .addGroup(jpSeccionConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpSeccionConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpNuevoPedidoLayout = new javax.swing.GroupLayout(jpNuevoPedido);
        jpNuevoPedido.setLayout(jpNuevoPedidoLayout);
        jpNuevoPedidoLayout.setHorizontalGroup(
            jpNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNuevoPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpNuevoPedidoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jpSeccionConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlTituloAgregar))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jpNuevoPedidoLayout.setVerticalGroup(
            jpNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNuevoPedidoLayout.createSequentialGroup()
                .addComponent(jlTituloAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpSeccionConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        Fondo.add(jpNuevoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 470, 130));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pedido Numero:");

        jtPedidos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
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

        jbConfirmar.setBackground(new java.awt.Color(153, 153, 0));
        jbConfirmar.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jbConfirmar.setText("Confirmar Pedido");
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        jbEliminarProducto.setBackground(new java.awt.Color(153, 153, 0));
        jbEliminarProducto.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jbEliminarProducto.setForeground(new java.awt.Color(51, 51, 51));
        jbEliminarProducto.setText("Eliminar Producto");
        jbEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpSeleccionarLayout = new javax.swing.GroupLayout(jpSeleccionar);
        jpSeleccionar.setLayout(jpSeleccionarLayout);
        jpSeleccionarLayout.setHorizontalGroup(
            jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSeleccionarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpSeleccionarLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(368, 368, 368))
                    .addComponent(jbConfirmar, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpSeleccionarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpSeleccionarLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminarProducto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpSeleccionarLayout.setVerticalGroup(
            jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSeleccionarLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlIdPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jbEliminarProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbConfirmar))
                .addGap(22, 22, 22))
        );

        Fondo.add(jpSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 470, 370));

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
        PrincipalView.cargaMesasView(meseroActual.getDni(),mesaActual.getIdMesa());
        //this.dispose();
    }//GEN-LAST:event_CerrarMouseClicked

    private void CerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseEntered
        // TODO add your handling code here:
        Cerrar.setForeground(Color.gray);
    }//GEN-LAST:event_CerrarMouseEntered

    private void CerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseExited
        // TODO add your handling code here:
        Cerrar.setForeground(Color.white);
    }//GEN-LAST:event_CerrarMouseExited

    private void jcbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbProductosMouseClicked
        if(!jcbProductos.isEnabled()){
            jcbProductos.setEnabled(true);
            jtCantidad.setText("1");
            jtCantidad.setEnabled(true);
            jbAgregar.setEnabled(true);
            cargarComboBoxProductos();
        }
    }//GEN-LAST:event_jcbProductosMouseClicked

    private void sumarTotal(){
        int f= modelo.getRowCount()-1;
        double total=0;
        for(;f>=0;f--){
            double valor = Double.parseDouble((String.valueOf(modelo.getValueAt(f, 4))));
            total+=valor;
        }
        total = Math.round(total * 100.0) / 100.0;
        jtTotal.setText(String.valueOf(total));
        pedidoData.ActualizarPrecio(pedidoActual.getIdPedido(), total);
    }
    
    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        Producto productoSeleccionado = (Producto) jcbProductos.getSelectedItem();
        int cantidad = Integer.parseInt(jtCantidad.getText()); 
        try{
        
        if(productoSeleccionado != null){
            DetallePedido detalle = new DetallePedido(productoSeleccionado.getIdProducto(), cantidad, pedidoActual.getIdPedido());
            detallePedidoData.cargarProductosBD(detalle);
            borrarFilas();
            cargarProductoEnTabla();
            sumarTotal();
            jcbProductos.setEnabled(false);
            jcbProductos.removeAllItems();
            jtCantidad.setText("");
            jtCantidad.setEnabled(false);
            jbAgregar.setEnabled(false);
            
            
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione un producto");
        }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Ingrese un numero para cantidad: "+ e.getMessage());
            jtCantidad.setText("");
            jtCantidad.requestFocus();
        }
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        PrincipalView.cargaMesasView(meseroActual.getDni(),mesaActual.getIdMesa());
    }//GEN-LAST:event_jbConfirmarActionPerformed

    private void jbEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarProductoActionPerformed
        int fila=jtPedidos.getSelectedRow();
        if(fila!=-1){
            int idDetallePedido=Integer.parseInt(String.valueOf(jtPedidos.getValueAt(fila,0)));
            detallePedidoData.EliminarDetalle(idDetallePedido);
            borrarFilas();
            cargarTablaInicial();
            sumarTotal();
            }else{
                JOptionPane.showMessageDialog(null, "Debe Seleccionar una Fila.");
        }
    }//GEN-LAST:event_jbEliminarProductoActionPerformed
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel FondoImagen;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbEliminarProducto;
    private javax.swing.JComboBox<Producto> jcbProductos;
    private javax.swing.JLabel jlIdMesa;
    private javax.swing.JLabel jlIdPedido;
    private javax.swing.JLabel jlTituloAgregar;
    private javax.swing.JPanel jpNuevoPedido;
    private javax.swing.JPanel jpSeccionConfirmar;
    private javax.swing.JPanel jpSeleccionar;
    private javax.swing.JTextField jtCantidad;
    private javax.swing.JLabel jtNumeroMesa;
    private javax.swing.JTable jtPedidos;
    private javax.swing.JTextField jtTotal;
    // End of variables declaration//GEN-END:variables
}
