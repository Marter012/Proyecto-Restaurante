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
import proyecto.restaurante.Control.ReservaData;
import proyecto.restaurante.Entidades.DetallePedido;
import proyecto.restaurante.Entidades.Estado;
import proyecto.restaurante.Entidades.Mesa;
import proyecto.restaurante.Entidades.Mesero;
import proyecto.restaurante.Entidades.Pedido;
import proyecto.restaurante.Entidades.Producto;
import proyecto.restaurante.Entidades.Reserva;

/**
 *
 * @author Emito
 */
public class MeserosView extends javax.swing.JInternalFrame {
    private Connection con = null;
    private MesaData mesaData;
    private MeseroData meseroData;
    private PedidoData pedidoData;
    private DetallePedidoData detallePedidoData;
    private Mesero meseroActual;
    private Mesa mesaActual;
    private DetallePedido detallePedido;
    private List<Pedido> listaPedidosPorMesero;
        
    private DefaultTableModel modelo = new DefaultTableModel(){
        public boolean isCellEditable(int f, int c){
                return false;
        }
    };

    public MeserosView(int dni) {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        estilos();   
        armarCabecera();
        borrarFilas();
        desactivarBotonesPedidos();
        //cargarTablaLibre();
        mesaData = new MesaData();
        meseroData = new MeseroData();
        pedidoData = new PedidoData();
        ReservaData reservaData = new ReservaData();
        detallePedido = new DetallePedido();
        meseroActual= meseroData.buscarMeseroPorDNI(dni);
        jbAtenderMesa.setEnabled(false);
        detallePedidoData = new DetallePedidoData();
        activarBotones();
        cargarTodosLosPedidos(meseroActual);
    }
    
    public MeserosView(int dni, int idMesa){
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        estilos();   
        armarCabecera();
        borrarFilas();
        //cargarTablaLibre();
        mesaData = new MesaData();
        meseroData = new MeseroData();
        pedidoData = new PedidoData();
        ReservaData reservaData = new ReservaData();
        detallePedido = new DetallePedido();
        meseroActual= meseroData.buscarMeseroPorDNI(dni);
        mesaActual=mesaData.obtenerMesa(idMesa);
        jbAtenderMesa.setEnabled(false);
        cargarComboMesaActual(mesaActual,meseroActual);
        detallePedidoData = new DetallePedidoData();
        
    }
    
    private void estilos(){
        Fondo.setBackground(new Color(35,34,36,210));
        TransparenciaListado.setBackground(new Color(35,34,36,240));
        jcbMesasLibres.setEnabled(false);
        jcbMesasConPedidos.setEnabled(false);
                        
    }
    private void armarCabecera(){       
        
        modelo.addColumn("Nº Pedido");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Importe"); 
        jtPedidos.setModel(modelo);

    }
    private void borrarFilas(){
        int f = jtPedidos.getRowCount()-1;
        for(;f >= 0; f--){
            modelo.removeRow(f);
        }
    }
        
    private void CargarComboMesasLibres(){
        List<Mesa> ListaDeMesasLibres = mesaData.ListarMesasPorEstado("LIBRE");
            for(Mesa mesas : ListaDeMesasLibres){
                jcbMesasLibres.addItem(mesas);
            }
        
    }
    
    private Pedido IniciarPedido(Mesero mesero, Mesa mesa){
        Pedido pedidoInicial = new Pedido();
        pedidoInicial.setMesa(mesa);
        pedidoInicial.setMesero(mesero);
        pedidoInicial.setFechaPedido(LocalDate.now());
        pedidoInicial.setHoraPedido(LocalTime.now());
        pedidoInicial.setImporte(0);
        pedidoInicial.setEstado(true);
        pedidoData.guardarPedido(pedidoInicial);
        return pedidoInicial;
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Fondo = new javax.swing.JPanel();
        Cerrar = new javax.swing.JLabel();
        TransparenciaListado = new javax.swing.JPanel();
        jcbMesasLibres = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbMesasConPedidos = new javax.swing.JComboBox<>();
        jbAtenderMesa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtPedidos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jbAgregarProductos = new javax.swing.JButton();
        jbCancelarPedido = new javax.swing.JButton();
        jbCobrarPedido = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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

        TransparenciaListado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcbMesasLibres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbMesasLibresMouseClicked(evt);
            }
        });
        TransparenciaListado.add(jcbMesasLibres, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 160, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seleccione la Opcion que desea Realizar:");
        TransparenciaListado.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mesa nueva");
        TransparenciaListado.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 20));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mesas con pedidos");
        TransparenciaListado.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jcbMesasConPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbMesasConPedidosMouseClicked(evt);
            }
        });
        jcbMesasConPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMesasConPedidosActionPerformed(evt);
            }
        });
        TransparenciaListado.add(jcbMesasConPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 160, -1));

        jbAtenderMesa.setBackground(new java.awt.Color(153, 153, 0));
        jbAtenderMesa.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jbAtenderMesa.setForeground(new java.awt.Color(51, 51, 51));
        jbAtenderMesa.setText("Atender Mesa");
        jbAtenderMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtenderMesaActionPerformed(evt);
            }
        });
        TransparenciaListado.add(jbAtenderMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, 30));

        jtPedidos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jtPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtPedidos);

        TransparenciaListado.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 430, 300));
        TransparenciaListado.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 460, -1));

        jbAgregarProductos.setBackground(new java.awt.Color(153, 153, 0));
        jbAgregarProductos.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jbAgregarProductos.setForeground(new java.awt.Color(51, 51, 51));
        jbAgregarProductos.setText("Ver Productos");
        jbAgregarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarProductosActionPerformed(evt);
            }
        });
        TransparenciaListado.add(jbAgregarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jbCancelarPedido.setBackground(new java.awt.Color(153, 153, 0));
        jbCancelarPedido.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jbCancelarPedido.setForeground(new java.awt.Color(51, 51, 51));
        jbCancelarPedido.setText("Cancelar Pedido");
        jbCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarPedidoActionPerformed(evt);
            }
        });
        TransparenciaListado.add(jbCancelarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, -1, -1));

        jbCobrarPedido.setBackground(new java.awt.Color(153, 153, 0));
        jbCobrarPedido.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jbCobrarPedido.setForeground(new java.awt.Color(51, 51, 51));
        jbCobrarPedido.setText("Cobrar Pedido");
        jbCobrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCobrarPedidoActionPerformed(evt);
            }
        });
        TransparenciaListado.add(jbCobrarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, -1, -1));

        Fondo.add(TransparenciaListado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 460, 520));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccion de Mesas");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

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

    private void jcbMesasLibresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbMesasLibresMouseClicked
        if (!jcbMesasLibres.isEnabled()){
            jcbMesasLibres.setEnabled(true);
            CargarComboMesasLibres();
            jcbMesasConPedidos.setEnabled(false);
            jcbMesasConPedidos.removeAllItems();
            desactivarBotonesPedidos();
            borrarFilas();
        }
    }//GEN-LAST:event_jcbMesasLibresMouseClicked

    private void jbAtenderMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtenderMesaActionPerformed
        Mesa mesaActual =  (Mesa) jcbMesasLibres.getSelectedItem();
        Pedido pedidoInicial = IniciarPedido(meseroActual, mesaActual);
        jcbMesasLibres.removeAllItems();
        jcbMesasLibres.setEnabled(false);
        mesaData.ocuparMesa(mesaActual);
        PrincipalView.cargaProductosView(meseroActual.getDni(), mesaActual.getIdMesa(),pedidoInicial.getIdPedido());    
    }//GEN-LAST:event_jbAtenderMesaActionPerformed

    private void jcbMesasConPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMesasConPedidosActionPerformed
        if (jcbMesasConPedidos.isEnabled()){
        Mesa mesaSeleccionada = (Mesa) jcbMesasConPedidos.getSelectedItem();
        listaPedidosPorMesero = pedidoData.listarPedidosPorMesa(mesaSeleccionada.getIdMesa(), meseroActual.getIdMesero());
        borrarFilas();
        for (Pedido pedido : listaPedidosPorMesero){
            modelo.addRow(new Object[]{
            pedido.getIdPedido(),
            pedido.getFechaPedido(),
            pedido.getHoraPedido(),
            pedido.getImporte()
            });
        }
        }
    }//GEN-LAST:event_jcbMesasConPedidosActionPerformed

    private void cargarTodosLosPedidos(Mesero m){
        listaPedidosPorMesero = pedidoData.obtenerPedidosPorMesero(m.getIdMesero());
        if (listaPedidosPorMesero.isEmpty()){
            JOptionPane.showMessageDialog(null,"Actualmente no tiene pedidos");
            desactivarBotones();
        }else{
            borrarFilas();
            for (Pedido pedido : listaPedidosPorMesero){
                if (pedido.isEstado()){
                    modelo.addRow(new Object[]{
                    pedido.getIdPedido(),
                    pedido.getFechaPedido(),
                    pedido.getHoraPedido(),
                    pedido.getImporte()
                    });
                }    
            }
        }
    }    
    
    private void jcbMesasConPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbMesasConPedidosMouseClicked
        if (!jcbMesasConPedidos.isEnabled()){
                jcbMesasConPedidos.setEnabled(true);
                cargarMesasConPedidos(meseroActual);
                if (jcbMesasConPedidos.getItemCount()!=0){
                    activarBotonesPedidos();
                    jcbMesasLibres.setEnabled(false);
                    jcbMesasLibres.removeAllItems();
                }else{
                    //JOptionPane.showMessageDialog(null,"Actualmente no esta atendiendo Mesas.");
                    jcbMesasLibres.removeAllItems();
                    jcbMesasLibres.setEnabled(false);
                    jbAtenderMesa.setEnabled(false);
                }
        }
    }//GEN-LAST:event_jcbMesasConPedidosMouseClicked

    private void jbAgregarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarProductosActionPerformed
        Mesa mesaSeleccionada;
        if (jcbMesasConPedidos.isEnabled()){
            int fila=jtPedidos.getSelectedRow();
            mesaSeleccionada = (Mesa) jcbMesasConPedidos.getSelectedItem();
            if(fila!=-1){
                Pedido pedido = new Pedido();
                int idPedido=Integer.parseInt(String.valueOf(jtPedidos.getValueAt(fila,0)));
                pedido = pedidoData.buscarPedido(idPedido);
                PrincipalView.cargaProductosView(meseroActual.getDni(), mesaSeleccionada.getIdMesa(), pedido.getIdPedido());
            }else{
                JOptionPane.showMessageDialog(this,"Debe seleccionar un pedido");
            }
        }else{
            int fila=jtPedidos.getSelectedRow();
            
            if(fila!=-1){
                Pedido pedido = new Pedido();
                int idPedido=Integer.parseInt(String.valueOf(jtPedidos.getValueAt(fila,0)));
                pedido = pedidoData.buscarPedido(idPedido);
                Mesa liberarMesa=pedidoData.obtenerMesa(idPedido);
                PrincipalView.cargaProductosView(meseroActual.getDni(), liberarMesa.getIdMesa(), pedido.getIdPedido());
            }else{
                JOptionPane.showMessageDialog(this,"Debe seleccionar un pedido");
            }
        }
    }//GEN-LAST:event_jbAgregarProductosActionPerformed

    private void jbCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarPedidoActionPerformed
        Mesa liberarMesa;
        if (jcbMesasConPedidos.isEnabled()){
            liberarMesa = (Mesa) jcbMesasConPedidos.getSelectedItem();
        int fila=jtPedidos.getSelectedRow();
            if(fila!=-1){   
                int idPedido=Integer.parseInt(String.valueOf(jtPedidos.getValueAt(fila,0)));
                pedidoData.CancelarPedido(idPedido);
                //detallePedidoData.EliminarDetallePedido(idPedido);
                mesaData.liberarMesa(liberarMesa);
                borrarFilas();
                jcbMesasConPedidos.setEnabled(false);
                jcbMesasConPedidos.removeAllItems();
                }else{
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar una Fila.");
            }
        }else{
            int fila=jtPedidos.getSelectedRow();
            if(fila!=-1){   
                int idPedido=Integer.parseInt(String.valueOf(jtPedidos.getValueAt(fila,0)));
                pedidoData.CancelarPedido(idPedido);
                liberarMesa=pedidoData.obtenerMesa(idPedido);
                //detallePedidoData.EliminarDetallePedido(idPedido);
                mesaData.liberarMesa(liberarMesa);
                borrarFilas();
                jcbMesasConPedidos.setEnabled(false);
                jcbMesasConPedidos.removeAllItems();
                }else{
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar una Fila.");
            }
        }
    }//GEN-LAST:event_jbCancelarPedidoActionPerformed

    private void jbCobrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCobrarPedidoActionPerformed
        Mesa liberarMesa;
        if (jcbMesasConPedidos.isEnabled()){
            liberarMesa = (Mesa) jcbMesasConPedidos.getSelectedItem();
            int fila=jtPedidos.getSelectedRow();
            if(fila!=-1){
                int idPedido=Integer.parseInt(String.valueOf(jtPedidos.getValueAt(fila,0)));
                pedidoData.CobrarPedido(idPedido);
                //detallePedidoData.EliminarDetallePedido(idPedido);
                mesaData.liberarMesa(liberarMesa);
                borrarFilas();
                jcbMesasConPedidos.setEnabled(false);
                jcbMesasConPedidos.removeAllItems();

                }else{
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar una Fila.");
            }
        }else{
            int fila=jtPedidos.getSelectedRow();
            if(fila!=-1){
                int idPedido=Integer.parseInt(String.valueOf(jtPedidos.getValueAt(fila,0)));
                pedidoData.CobrarPedido(idPedido);
                liberarMesa=pedidoData.obtenerMesa(idPedido);
                //detallePedidoData.EliminarDetallePedido(idPedido);
                mesaData.liberarMesa(liberarMesa);
                borrarFilas();
                jcbMesasConPedidos.setEnabled(false);
                jcbMesasConPedidos.removeAllItems();

                }else{
                    JOptionPane.showMessageDialog(null, "Debe Seleccionar una Fila.");
            }
        }
    }//GEN-LAST:event_jbCobrarPedidoActionPerformed
          
    private void cargarMesasConPedidos(Mesero m){
        List<Mesa> mesasActivasPorMesero = new ArrayList();
        listaPedidosPorMesero = pedidoData.obtenerMesasOcupadasPorMesero(m.getIdMesero());
        for (Pedido pedido:listaPedidosPorMesero){
            Mesa mesa = pedido.getMesa();
            mesasActivasPorMesero.add(mesa);           
        }
        if (!mesasActivasPorMesero.isEmpty()){
            for (Mesa mesa: mesasActivasPorMesero){
                jcbMesasConPedidos.addItem(mesa);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Actualmente no esta atendiendo ninguna mesa.");
            jcbMesasConPedidos.setEnabled(false);
        }    
    }
    
    private void cargarComboMesaActual(Mesa m, Mesero mesero){
        List<Mesa> mesasActivasPorMesero = new ArrayList();
        listaPedidosPorMesero = pedidoData.obtenerMesasOcupadasPorMesero(mesero.getIdMesero());
        int posicionMesaActual=-1;
        for (Pedido pedido:listaPedidosPorMesero){
            Mesa mesa = pedido.getMesa();
            mesasActivasPorMesero.add(mesa);           
        }
        if (!mesasActivasPorMesero.isEmpty()){
            for (Mesa mesa: mesasActivasPorMesero){
                jcbMesasConPedidos.addItem(mesa);
                jcbMesasConPedidos.setEnabled(true);
            }
            for (Mesa mesa:mesasActivasPorMesero){
                        if(mesa.getIdMesa()==m.getIdMesa()){
                            posicionMesaActual = mesasActivasPorMesero.indexOf(mesa);
                        }
                    }
            jcbMesasConPedidos.setSelectedIndex(posicionMesaActual);
        } else {
            JOptionPane.showMessageDialog(null, "Actualmente no esta atendiendo ninguna mesa.");
            jcbMesasConPedidos.setEnabled(false);
        }
    }
    
    private void desactivarBotonesPedidos(){
        jbAtenderMesa.setEnabled(true);
        jbAgregarProductos.setEnabled(false);
        jbCancelarPedido.setEnabled(false);
        jbCobrarPedido.setEnabled(false);
    }
    
    private void activarBotonesPedidos(){
        jbAtenderMesa.setEnabled(false);
        jbAgregarProductos.setEnabled(true);
        jbCancelarPedido.setEnabled(true);
        jbCobrarPedido.setEnabled(true);
    }
    
    private void activarBotones(){
        jbAgregarProductos.setEnabled(true);
        jbCancelarPedido.setEnabled(true);
        jbCobrarPedido.setEnabled(true);
    }
    
    private void desactivarBotones(){
        jbAgregarProductos.setEnabled(false);
        jbCancelarPedido.setEnabled(false);
        jbCobrarPedido.setEnabled(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel FondoImagen;
    private javax.swing.JPanel TransparenciaListado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbAgregarProductos;
    private javax.swing.JButton jbAtenderMesa;
    private javax.swing.JButton jbCancelarPedido;
    private javax.swing.JButton jbCobrarPedido;
    private javax.swing.JComboBox<Mesa> jcbMesasConPedidos;
    private javax.swing.JComboBox<Mesa> jcbMesasLibres;
    private javax.swing.JTable jtPedidos;
    // End of variables declaration//GEN-END:variables
}
