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
    
    private DetallePedido detallePedido = new DetallePedido();
    
    private int idPedidoSelec = -1;
    private int DNIMesero;
    private int codigoMesa;
    private int idGuardado;
    
    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int f, int c){
                return false;
        }
    };
    /**
     * Creates new form CargaMeserosView
     */
    
    public ProductosView(){}
    
    public ProductosView(int DNI, int idMesa, int idPedidoImport) {
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
        idPedidoSelec = idPedidoImport;
        idGuardado = idPedidoSelec;
        jtCantidad.setEnabled(false);
        cargarTabla(false);
        cargarComboBoxPedidos();
        buscarComboBoxPedido(idGuardado);
        
    }
    private void estilos(){
        Fondo.setBackground(new Color(35,34,36,210));
        jpNuevoPedido.setBackground(new Color(35,34,36,160));
        jpSeleccionar.setBackground(new Color(35,34,36,160));
        jpSeccionConfirmar.setBackground(new Color(35,35,36,180));
    }
    
        
    public void cargarComboBoxProductos(){
        for (Producto productos: productoData.listarProductos()){
            jcbProductos.addItem(productos);
        }
    }
    
    public void cargarComboBoxProductosTotales(){
        jcbTotalProductos.removeAllItems();
        int corte2 = 0;
        for (DetallePedido productos: listaProductoCantidad){
            String pedidoSelec = productos.toString();
            for(int i = 0; i <= 1 ; i++){
                String selecSplit = String.join(",", pedidoSelec);
                String[] corte = selecSplit.split(" ");
                producto = productoData.buscarProducto(Integer.parseInt(corte[0]));
                corte2 = Integer.parseInt(corte[1]);
            }
            jcbTotalProductos.addItem( producto.getIdProducto() + " - " +producto.getNombre() + ", " + corte2 + " Un");
        }
    }
    
    public void cargarComboBoxPedidos(){
        mesa = mesaData.obtenerMesa(codigoMesa);
        mesero = meseroData.buscarMeseroPorDNI(DNIMesero);
        for (Pedido pedidos: pedidoData.listarPedidosPorMesa(mesa.getIdMesa(), mesero.getIdMesero())){
            jcbPedido.addItem(pedidos.getIdPedido());
        }        
    }
    
    public void buscarComboBoxPedido(int id){
        int position = -1;
        for(int i = 0 ; i < jcbPedido.getItemCount(); i++){
            if(jcbPedido.getItemAt(i).equals(id)){
                position = i;
                break;
            }
        }
        System.out.println(id);
        if(position != -1){
            jcbPedido.setSelectedIndex(position);
        }else{
            JOptionPane.showMessageDialog(null,"No se encontro el id Pedido.");
        }
    }
    
    private void armarCabecera(){ 
        modelo.addColumn("Codigo");
        modelo.addColumn("Hora");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio Unitario"); 
        modelo.addColumn("Total");
        jtPedidos.setModel(modelo);

    }
    
     private void borrarFilas(){
        int f = jtPedidos.getRowCount()-1;
        for(;f >= 0; f--){
            modelo.removeRow(f);
        }
    }
     
    private void cargarTabla(boolean valid){
        borrarFilas();
        List<DetallePedido> listaProductos = new ArrayList(); 
        if(valid){
            idPedidoSelec = (int)jcbPedido.getSelectedItem();  
        }        
        listaProductos = productoData.listarProductosPorId(idPedidoSelec);
        if(!listaProductos.isEmpty()){
                for (DetallePedido productos:listaProductos){
                    modelo.addRow(new Object[]{
                        productos.getIdProducto(),
                        pedidoData.buscarPedido(productos.getIdPedido()).getHoraPedido(),
                        productoData.buscarProducto(productos.getIdProducto()).getNombre(),
                        productos.getCantidad(),
                        productoData.buscarProducto(productos.getIdProducto()).getPrecio(),
                        productos.getCantidad()*productoData.buscarProducto(productos.getIdProducto()).getPrecio()
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
        jbConfirmar = new javax.swing.JButton();
        jpSeccionConfirmar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcbProductos = new javax.swing.JComboBox<>();
        jbAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtCantidad = new javax.swing.JTextField();
        jbEliminar = new javax.swing.JButton();
        jcbTotalProductos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jpSeleccionar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPedidos = new javax.swing.JTable();
        jcbPedido = new javax.swing.JComboBox<>();
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

        jtNumeroMesa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jtNumeroMesa.setForeground(new java.awt.Color(255, 255, 255));
        Fondo.add(jtNumeroMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 50, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nuevo Pedido");

        jbConfirmar.setText("Confirmar");
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Agregar producto:");

        jcbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbProductosMouseClicked(evt);
            }
        });

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad: ");

        jtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCantidadActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jcbTotalProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbTotalProductosMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total de productos");

        javax.swing.GroupLayout jpSeccionConfirmarLayout = new javax.swing.GroupLayout(jpSeccionConfirmar);
        jpSeccionConfirmar.setLayout(jpSeccionConfirmarLayout);
        jpSeccionConfirmarLayout.setHorizontalGroup(
            jpSeccionConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSeccionConfirmarLayout.createSequentialGroup()
                .addGroup(jpSeccionConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpSeccionConfirmarLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jcbTotalProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbEliminar))
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
                        .addComponent(jbAgregar)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jpSeccionConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTotalProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminar)))
        );

        javax.swing.GroupLayout jpNuevoPedidoLayout = new javax.swing.GroupLayout(jpNuevoPedido);
        jpNuevoPedido.setLayout(jpNuevoPedidoLayout);
        jpNuevoPedidoLayout.setHorizontalGroup(
            jpNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNuevoPedidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
            .addGroup(jpNuevoPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpNuevoPedidoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jpSeccionConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jpNuevoPedidoLayout.setVerticalGroup(
            jpNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNuevoPedidoLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpSeccionConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Fondo.add(jpNuevoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 470, 180));

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

        jcbPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbPedidoMouseClicked(evt);
            }
        });
        jcbPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpSeleccionarLayout = new javax.swing.GroupLayout(jpSeleccionar);
        jpSeleccionar.setLayout(jpSeleccionarLayout);
        jpSeleccionarLayout.setHorizontalGroup(
            jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSeleccionarLayout.createSequentialGroup()
                .addGroup(jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSeleccionarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpSeleccionarLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpSeleccionarLayout.setVerticalGroup(
            jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSeleccionarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jpSeleccionarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcbPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
        );

        Fondo.add(jpSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 470, 360));

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
            jtCantidad.setText("1");
            jtCantidad.setEnabled(true);
            cargarComboBoxProductos();
        }
    }//GEN-LAST:event_jcbProductosMouseClicked

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        Producto productoSeleccionado = (Producto) jcbProductos.getSelectedItem();
        if(productoSeleccionado != null){
            listaProducto.add(productoSeleccionado);
            int Cantidad =  Integer.parseInt(jtCantidad.getText());            
            for(Producto productos : listaProducto){
                detallePedido = new DetallePedido(productos.getIdProducto(),Cantidad);
                listaProductoCantidad.add(detallePedido);
            }
            listaProducto.clear();
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
        String productoSeleccionado = (String) jcbTotalProductos.getSelectedItem();
        if(productoSeleccionado != null){
            listaProductoCantidad.remove(jcbTotalProductos.getSelectedIndex());
            cargarComboBoxProductosTotales();
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione un producto");
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        double ImporteTotal = 0;
        
        mesero = meseroData.buscarMeseroPorDNI(DNIMesero);
        mesa = mesaData.obtenerMesa(codigoMesa);

        pedido = new Pedido(mesa,mesero,LocalDate.now(),LocalTime.now(),ImporteTotal,true);        
        pedidoData.guardarPedido(pedido);
            
        if(!listaProductoCantidad.isEmpty()){            
            for(DetallePedido pedidos : listaProductoCantidad){
                producto = productoData.buscarProducto(pedidos.getIdProducto());
                ImporteTotal = ImporteTotal + (producto.getPrecio()*pedidos.getCantidad());
                producto = productoData.buscarProducto(pedidos.getIdProducto());
                cargarProductosBD(producto,pedido,pedidos.getCantidad());  
            }
            listaProductoCantidad.clear();
            jtCantidad.setText("");
            jtCantidad.setEnabled(false);
            jcbProductos.setEnabled(false);
            jcbProductos.removeAllItems();
            jcbTotalProductos.setEnabled(false);
            jcbTotalProductos.removeAllItems();
            cargarTabla(false);
            cargarComboBoxPedidos();
            buscarComboBoxPedido(pedido.getIdPedido());
            idPedidoSelec = pedido.getIdPedido();
        }else{
            JOptionPane.showMessageDialog(null,"Agrege productos.");
        }
        
        jcbTotalProductos.setEnabled(false);
        
    }//GEN-LAST:event_jbConfirmarActionPerformed

    private void jcbPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbPedidoMouseClicked
        if(!jcbPedido.isEnabled()){
            jcbPedido.setEnabled(true);
            cargarComboBoxPedidos();
        }
    }//GEN-LAST:event_jcbPedidoMouseClicked

    private void jcbPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPedidoActionPerformed
        cargarTabla(true);
    }//GEN-LAST:event_jcbPedidoActionPerformed

    private void jtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCantidadActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel FondoImagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JComboBox<Integer> jcbPedido;
    private javax.swing.JComboBox<Producto> jcbProductos;
    private javax.swing.JComboBox<String> jcbTotalProductos;
    private javax.swing.JLabel jlIdMesa;
    private javax.swing.JPanel jpNuevoPedido;
    private javax.swing.JPanel jpSeccionConfirmar;
    private javax.swing.JPanel jpSeleccionar;
    private javax.swing.JTextField jtCantidad;
    private javax.swing.JLabel jtNumeroMesa;
    private javax.swing.JTable jtPedidos;
    // End of variables declaration//GEN-END:variables
}
