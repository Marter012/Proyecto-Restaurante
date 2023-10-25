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
import proyecto.restaurante.Control.MesaData;
import proyecto.restaurante.Control.MeseroData;
import proyecto.restaurante.Control.PedidoData;
import proyecto.restaurante.Control.ProductoData;
import proyecto.restaurante.Entidades.Mesa;
import proyecto.restaurante.Entidades.Mesero;
import proyecto.restaurante.Entidades.Pedido;
import proyecto.restaurante.Entidades.Producto;

/**
 *
 * @author Emito
 */
public class ProductosView extends javax.swing.JInternalFrame {

    List<Producto> listaProducto = new ArrayList();
    private Connection con = null;
    private Mesero mesero;
    private MeseroData meseroData;
    private int DNIMesero;
    private int codigoMesa;
    private MesaData mesaData;
    private Mesa mesa;
    private ProductoData productoData;    
    private Producto producto;
    private Pedido pedido;
    private PedidoData pedidoData;

    
    private DefaultTableModel modelo = new DefaultTableModel(){
        public boolean isCellEditable(int f, int c){
                return false;
        }
    };
    /**
     * Creates new form CargaMeserosView
     * @param DNI
     * @param idMesa
     */
    
    public ProductosView(){}
    
    public ProductosView(int DNI, int idMesa) {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        estilos();     
        DNIMesero = DNI;
        codigoMesa = idMesa;
        armarCabecera();
        borrarFilas();
        jtNumeroMesa.setText(String.valueOf(codigoMesa));
        jcbProductos.setEnabled(false);
        jcbTotalProductos.setEnabled(false);
    }
    private void estilos(){
        Fondo.setBackground(new Color(35,34,36,210));
        jpNuevoPedido.setBackground(new Color(35,34,36,160));
        jpSeleccionar.setBackground(new Color(35,34,36,160));
    }
    
    public void cargarComboBoxProductos(){
        producto = new Producto();
        productoData = new ProductoData();
        for (Producto productos: productoData.listarProductos()){
            System.out.println(productos);
            jcbProductos.addItem(productos);
        }
    }
    
    public void cargarComboBoxProductosTotales(){
        jcbTotalProductos.removeAllItems();
        producto = new Producto();
        productoData = new ProductoData();
        for (Producto productos: listaProducto){
            jcbTotalProductos.addItem(productos);
        }
    }
    
    private void armarCabecera(){ 
        modelo.addColumn("Codigo");
        modelo.addColumn("Producto");
        modelo.addColumn("Mesa");
        modelo.addColumn("Importe"); 
        modelo.addColumn("Hora");
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
        mesa = new Mesa();
        mesero = meseroData.buscarMeseroPorDNI(DNIMesero);        
        List<Pedido> listaPedidos = new ArrayList();  
        
        
        if(!listaPedidos.isEmpty()){
            for (Pedido pedidos:listaPedidos){
                modelo.addRow(new Object[]{
                pedidos.getIdPedido(),
                pedidos.getMesa(),                
                pedidos.getImporte(),                
                pedidos.getHoraPedido(),
                });
            }
        }        
    }
    
    public void cargarProductosBD(Producto productos, Pedido pedidos, int cantidad){
        String sql = "INSERT INTO `detallepedidos`(`idProducto`, `idPedido`, `Cantidad`) VALUES (?,?,?)";                
        PreparedStatement ps;
        con = Conexion.getConexion();
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,productos.getIdProducto());
            ps.setInt(2,pedidos.getIdPedido());
            ps.setInt(3,cantidad);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
                        
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al asignar producto "+ex.getMessage());
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
        jlIdMesa = new javax.swing.JLabel();
        jtNumeroMesa = new javax.swing.JLabel();
        jpNuevoPedido = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbProductos = new javax.swing.JComboBox<>();
        jbConfirmar = new javax.swing.JButton();
        jbAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jcbTotalProductos = new javax.swing.JComboBox<>();
        jbEliminar = new javax.swing.JButton();
        jpSeleccionar = new javax.swing.JPanel();
        jcbPedido = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPedidos = new javax.swing.JTable();
        FondoImagen = new javax.swing.JLabel();

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CerrarMouseExited(evt);
            }
        });
        Fondo.add(Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 50, 30));

        jlIdMesa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlIdMesa.setForeground(new java.awt.Color(255, 255, 255));
        jlIdMesa.setText("MESA NUMERO");
        Fondo.add(jlIdMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, -1));

        jtNumeroMesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Fondo.add(jtNumeroMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 50, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nuevo Pedido");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Agregar producto:");

        jcbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbProductosMouseClicked(evt);
            }
        });

        jbConfirmar.setText("Confirmar");
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total de productos");

        jcbTotalProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbTotalProductosMouseClicked(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpNuevoPedidoLayout = new javax.swing.GroupLayout(jpNuevoPedido);
        jpNuevoPedido.setLayout(jpNuevoPedidoLayout);
        jpNuevoPedidoLayout.setHorizontalGroup(
            jpNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNuevoPedidoLayout.createSequentialGroup()
                .addGroup(jpNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpNuevoPedidoLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(jpNuevoPedidoLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jpNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpNuevoPedidoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(26, 26, 26)
                                .addComponent(jcbTotalProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbEliminar))
                            .addGroup(jpNuevoPedidoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addGroup(jpNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbConfirmar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpNuevoPedidoLayout.createSequentialGroup()
                                        .addComponent(jcbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbAgregar)))))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jpNuevoPedidoLayout.setVerticalGroup(
            jpNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNuevoPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(jpNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jpNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTotalProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminar))
                .addGap(18, 18, 18)
                .addComponent(jbConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Fondo.add(jpNuevoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 470, 150));

        jcbPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Seleccione el pedido :");

        jtPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtPedidos);

        javax.swing.GroupLayout jpSeleccionarLayout = new javax.swing.GroupLayout(jpSeleccionar);
        jpSeleccionar.setLayout(jpSeleccionarLayout);
        jpSeleccionarLayout.setHorizontalGroup(
            jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSeleccionarLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcbPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(jpSeleccionarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpSeleccionarLayout.setVerticalGroup(
            jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSeleccionarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addContainerGap())
        );

        Fondo.add(jpSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 470, 380));

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

    private void jcbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbProductosMouseClicked
        if(!jcbProductos.isEnabled()){
            jcbProductos.setEnabled(true);
            cargarComboBoxProductos();
        }
    }//GEN-LAST:event_jcbProductosMouseClicked

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        Producto productoSeleccionado = (Producto) jcbProductos.getSelectedItem();
        if(productoSeleccionado != null){
            listaProducto.add(productoSeleccionado);
            cargarComboBoxProductosTotales();
            jcbTotalProductos.setEnabled(true);
        }else{
        JOptionPane.showMessageDialog(null,"Seleccione un producto");
        }
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jcbTotalProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbTotalProductosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTotalProductosMouseClicked

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        Producto productoSeleccionado = (Producto) jcbTotalProductos.getSelectedItem();
        if(productoSeleccionado != null){
            listaProducto.remove(productoSeleccionado);
            cargarComboBoxProductosTotales();
        }else{
        JOptionPane.showMessageDialog(null,"Seleccione un producto");
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        mesa = new Mesa();
        pedidoData = new PedidoData();
        mesero = new Mesero();
        meseroData = new MeseroData();
        mesaData = new MesaData(); 
        
        if(!listaProducto.isEmpty()){
            double ImporteTotal = 0;
            mesero = meseroData.buscarMeseroPorDNI(DNIMesero);
            mesa = mesaData.obtenerMesa(codigoMesa);
            for(Producto productos : listaProducto){
                ImporteTotal = ImporteTotal + productos.getPrecio();
            }
            pedido = new Pedido(mesa,mesero,LocalDate.now(),LocalTime.now(),ImporteTotal,true);        
            pedidoData.guardarPedido(pedido);
        for(Producto productos : listaProducto){
            cargarProductosBD(productos,pedido,3);
        }
        }else{
            JOptionPane.showMessageDialog(null,"Agrege productos.");
        }
    }//GEN-LAST:event_jbConfirmarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel FondoImagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JComboBox<String> jcbPedido;
    private javax.swing.JComboBox<Producto> jcbProductos;
    private javax.swing.JComboBox<Producto> jcbTotalProductos;
    private javax.swing.JLabel jlIdMesa;
    private javax.swing.JPanel jpNuevoPedido;
    private javax.swing.JPanel jpSeleccionar;
    private javax.swing.JLabel jtNumeroMesa;
    private javax.swing.JTable jtPedidos;
    // End of variables declaration//GEN-END:variables
}
