package proyecto.restaurante.Vistas;

import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import proyecto.restaurante.Control.*;
import proyecto.restaurante.Entidades.*;


public class IngresosView extends javax.swing.JInternalFrame {
    private static Mesero mesero;
    private static PedidoData pedidoData;
    private static MeseroData meseroData;
    DefaultTableModel modelo=new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    public IngresosView() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        estilos();
        jcbFechas.setEnabled(false);
        jcbMesas.setEnabled(false);
        jcbMeseros.setEnabled(false);
        pedidoData = new PedidoData();
        meseroData = new MeseroData();
        
        armarCabecera();
        cargarTabla();
        sumarTotal();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpFondo = new javax.swing.JPanel();
        jlTituloIngresos = new javax.swing.JLabel();
        jlFecha = new javax.swing.JLabel();
        jlMesa = new javax.swing.JLabel();
        jlMesero = new javax.swing.JLabel();
        jlDetalles1 = new javax.swing.JLabel();
        jcbFechas = new javax.swing.JComboBox<>();
        jcbMesas = new javax.swing.JComboBox<>();
        jcbMeseros = new javax.swing.JComboBox<>();
        jlDetalles = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaDetalles = new javax.swing.JTable();
        jbListarTodo = new javax.swing.JButton();
        jlTotal = new javax.swing.JLabel();
        jtTotal = new javax.swing.JTextField();
        jlFondoTrasparente1 = new javax.swing.JLabel();
        jlCerrar = new javax.swing.JLabel();
        jlFondoImage = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        setPreferredSize(new java.awt.Dimension(540, 590));

        jpFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlTituloIngresos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlTituloIngresos.setForeground(new java.awt.Color(255, 255, 255));
        jlTituloIngresos.setText("Administración de Ingresos");
        jpFondo.add(jlTituloIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 40));

        jlFecha.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlFecha.setForeground(new java.awt.Color(255, 255, 255));
        jlFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFecha.setText("Fecha");
        jpFondo.add(jlFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

        jlMesa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlMesa.setForeground(new java.awt.Color(255, 255, 255));
        jlMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMesa.setText("Mesa:");
        jpFondo.add(jlMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        jlMesero.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlMesero.setForeground(new java.awt.Color(255, 255, 255));
        jlMesero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMesero.setText("Mesero:");
        jpFondo.add(jlMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));

        jlDetalles1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlDetalles1.setForeground(new java.awt.Color(255, 255, 255));
        jlDetalles1.setText("Consulte pedidos");
        jpFondo.add(jlDetalles1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

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
        jpFondo.add(jcbFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 180, -1));

        jpFondo.add(jcbMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 180, -1));

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
        jpFondo.add(jcbMeseros, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 180, -1));

        jlDetalles.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlDetalles.setForeground(new java.awt.Color(255, 255, 255));
        jlDetalles.setText("Detalles:");
        jpFondo.add(jlDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jtListaDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtListaDetalles);

        jpFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 230, 490, 270));

        jbListarTodo.setText("Listar Todo");
        jbListarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarTodoActionPerformed(evt);
            }
        });
        jpFondo.add(jbListarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, -1));

        jlTotal.setBackground(new java.awt.Color(255, 255, 255));
        jlTotal.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlTotal.setForeground(new java.awt.Color(255, 255, 255));
        jlTotal.setText("Total:");
        jpFondo.add(jlTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 50, 30));
        jpFondo.add(jtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, 130, -1));

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
    if (!jcbMeseros.isEnabled() && !jcbFechas.isEnabled()) {
        borrarFila();
        jcbMeseros.setEnabled(true);
        cargarComboMeseros();
    } else if (!jcbMeseros.isEnabled() && jcbFechas.isEnabled()) {
        borrarFila();
        System.out.println("entra?");
        jcbFechas.removeAllItems();
        jcbFechas.setEnabled(false);
        jcbMeseros.setEnabled(true);
        jcbMeseros.removeAllItems();
        cargarComboMeseros();
    }


//        if(!jcbMeseros.isEnabled()){
//            jcbMeseros.setEnabled(true);
//            cargarComboMeseros();
//            if(jcbFechas.isEnabled()){
//                jcbFechas.removeAllItems();
//                jcbFechas.setEnabled(false);
//            }
//        }else{
//            if (jcbFechas.isEnabled()){
//                
//                jcbFechas.setEnabled(false);
//            }
//        }
//        System.out.println("Hola");
//        if (jcbFechas.isEnabled()){
//            //borrarFila();
//            System.out.println("cb fecha activo");
//            //jcbFechas.removeAllItems();
//            //jcbFechas.setEnabled(false);
//        }


//        if (!jcbMeseros.isEnabled() & !jcbFechas.isEnabled()){
//            borrarFila();
//            jcbMeseros.setEnabled(true);
//            cargarComboMeseros();
//        } else {
//            if (!jcbMeseros.isEnabled() & jcbFechas.isEnabled()){
//                System.out.println("Entra aca?");
//                borrarFila();
//                jcbFechas.removeAllItems();
//                jcbFechas.setEnabled(false);
//                jcbMeseros.setEnabled(true);
//                cargarComboMeseros();
//                
//            }
//        }
//ULTIMO
//        if (!jcbMeseros.isEnabled()){
//            jcbMeseros.setEnabled(true);
//            cargarComboMeseros();
//            borrarFila();
//                mesero=(Mesero)jcbMeseros.getSelectedItem();
//                cargarTabla(mesero);
//                sumarTotal();
//            jcbFechas.removeAllItems();
//            jcbFechas.setEnabled(false);
//            
//            
//            
//        }
        
        
        
    }//GEN-LAST:event_jcbMeserosMouseClicked

    private void jbListarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarTodoActionPerformed
        System.out.println("Entra");
        
        jcbMeseros.setEnabled(false);
        System.out.println("desactiva meseros");
        jcbMeseros.removeAllItems();
        System.out.println("Remueve meseros");
        
        jcbFechas.setEnabled(false);
        System.out.println("desactiva fechas");
        jcbFechas.removeAllItems();
        System.out.println("remueve fechas");
        borrarFila();
        System.out.println("borra lista");
        cargarTabla();
        System.out.println("CargaTabla");
        sumarTotal();
        System.out.println("suma");
    }//GEN-LAST:event_jbListarTodoActionPerformed

    private void jcbMeserosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMeserosActionPerformed
        if (jcbMeseros.isEnabled() && !jcbFechas.isEnabled()) {
        borrarFila();
        Mesero mesero = (Mesero) jcbMeseros.getSelectedItem();
        cargarTabla(mesero);
        sumarTotal();
    } else {
        jcbMeseros.setEnabled(false); // Desactivar el JComboBox de meseros
        jcbFechas.setEnabled(true); // Activar el JComboBox de fechas
        jcbFechas.removeAllItems(); // Vaciar el JComboBox de fechas
        cargarComboFechas(); // Cargar las fechas en el JComboBox
    }

//        if (jcbFechas.isEnabled()){
//            jcbFechas.removeAllItems();
//            jcbFechas.setEnabled(false);
//            borrarFila();
//            mesero=(Mesero)jcbMeseros.getSelectedItem();
//            if (mesero!=null){
//                cargarTabla(mesero);
//                sumarTotal();
//                jcbFechas.removeAllItems();
//                jcbFechas.setEnabled(false);
//                if (jtListaDetalles.getRowCount()==0){
//                    JOptionPane.showMessageDialog(null, "El Mesero no tiene pedidos.");
//                }
//            }
//        }
//        if (jcbMeseros.isEnabled()&jcbFechas.isEnabled()){
//            borrarFila();
//            DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
//            LocalDate fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(),forma);
//            mesero=(Mesero)jcbMeseros.getSelectedItem();
//            cargarTabla(mesero,fechaSeleccionada);
//            sumarTotal();
//        }else{
//            if (jcbMeseros.isEnabled() & !jcbFechas.isEnabled())
//                borrarFila();
//                mesero=(Mesero)jcbMeseros.getSelectedItem();
//                System.out.println("Aca se Rompe");
//                cargarTabla(mesero);
//                sumarTotal();
//        }
//ULTIMO
//            if (jcbMeseros.isEnabled() & !jcbFechas.isEnabled()){
//                jcbFechas.removeAllItems();
//                jcbFechas.setEnabled(false);
//                borrarFila();
//                mesero=(Mesero)jcbMeseros.getSelectedItem();
//                cargarTabla(mesero);
//                sumarTotal();
//            }
                
    }//GEN-LAST:event_jcbMeserosActionPerformed

    private void jcbFechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbFechasMouseClicked
        if (!jcbFechas.isEnabled() && !jcbMeseros.isEnabled()) {
        jcbFechas.setEnabled(true);
        cargarComboFechas();
        cargarTabla();
    } else if (jcbMeseros.isEnabled() && !jcbFechas.isEnabled()) {
        jcbFechas.setEnabled(true);
        cargarComboFechas();
        borrarFila();
        Mesero mesero = (Mesero) jcbMeseros.getSelectedItem();
        cargarTabla(mesero);
        jcbMeseros.setEnabled(false);
    

//ULTIMO
//        if (jcbMeseros.isEnabled()){
//            if (!jcbFechas.isEnabled()){
//                jcbFechas.setEnabled(true);
//                cargarComboFechas((Mesero)jcbMeseros.getSelectedItem());           
//            }
//        }else{
//            if (!jcbFechas.isEnabled()){
//                jcbFechas.setEnabled(true);
//                cargarComboFechas();
//                if (jcbFechas.getItemCount()==0){
//                    JOptionPane.showMessageDialog(null,"Todavia no hay pedidos.");
//                    jcbFechas.setEnabled(false);
                }
//                else{
//                    borrarFila();
//                    DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
//                    LocalDate fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma );
//                    //System.out.println(fechaSeleccionada);
//                    //cargarTabla(fechaSeleccionada);
//                }
//            }
//        }
    }//GEN-LAST:event_jcbFechasMouseClicked

    private void jcbFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFechasActionPerformed
            if (!jcbMeseros.isEnabled() && jcbMeseros.getItemCount() == 0) {
                jcbFechas.setEnabled(true);
                cargarComboFechas();
                borrarFila();
                DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                LocalDate fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma);
                cargarTabla(fechaSeleccionada);
                sumarTotal();
            } else if (!jcbMeseros.isEnabled() && jcbMeseros.getItemCount() > 0) {
                Mesero meseroSeleccionado = (Mesero) jcbMeseros.getSelectedItem();
                jcbFechas.setEnabled(true);
                cargarComboFechas(meseroSeleccionado);
                borrarFila();
                DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                LocalDate fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma);
                cargarTabla(meseroSeleccionado, fechaSeleccionada);
            }

//        if (jcbMeseros.isEnabled() && jcbFechas.isEnabled()) {
//        borrarFila();
//        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
//        LocalDate fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma);
//        Mesero mesero = (Mesero) jcbMeseros.getSelectedItem();
//        cargarTabla(mesero, fechaSeleccionada);
//        sumarTotal();
//    } else if (jcbFechas.isEnabled()) {
//        borrarFila();
//        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
//        LocalDate fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma);
//        cargarTabla(fechaSeleccionada);
//        sumarTotal();
//    }

//ULTIMO
//        if (!jcbFechas.isEnabled() && !jcbMeseros.isEnabled()) {
//        jcbFechas.setEnabled(true);
//        cargarComboFechas();
//        cargarTabla();
//    } else if (jcbMeseros.isEnabled() && !jcbFechas.isEnabled()) {
//        jcbFechas.setEnabled(true);
//        cargarComboFechas();
//        borrarFila();
//        Mesero mesero = (Mesero) jcbMeseros.getSelectedItem();
//        cargarTabla(mesero);
//        jcbMeseros.setEnabled(false);
//    }

////        borrarFila();
////        LocalDate fechaSeleccionada = (LocalDate) jcbFechas.getSelectedItem();
////        mesero=(Mesero)jcbMeseros.getSelectedItem();
////        if (mesero!=null){
////            cargarTabla(mesero,fechaSeleccionada);
////            sumarTotal();
////        }
//
//
//        borrarFila();
//        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
//        LocalDate fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma );
//        mesero=(Mesero)jcbMeseros.getSelectedItem();
//        if (mesero!=null){
//            cargarTabla(mesero,fechaSeleccionada);
//            sumarTotal();
//        }

//        if (jcbMeseros.isEnabled()){
//            borrarFila();
//            DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
//            LocalDate fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(), forma );
//            mesero=(Mesero)jcbMeseros.getSelectedItem();
//            if (mesero!=null){
//                cargarTabla(mesero,fechaSeleccionada);
//                sumarTotal();
//            }
//        }else{
//            borrarFila();
//            DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
//            LocalDate fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(),forma);
//            cargarTabla(fechaSeleccionada);
//            sumarTotal();
//        }
        //PROBAR ESTE.
          //ULTIMO  
//        if (jcbMeseros.isEnabled() & jcbFechas.isEnabled()){
//            jcbMeseros.setEnabled(false);
//            borrarFila();
//            DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
//            LocalDate fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(),forma);
//            mesero=(Mesero)jcbMeseros.getSelectedItem();
//            cargarTabla(mesero,fechaSeleccionada);
//            sumarTotal();
//            jcbFechas.removeAllItems();
//            jcbFechas.setEnabled(false);
//            
//        }else{
//            if (jcbFechas.isEnabled())
//                borrarFila();
//                DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
//                LocalDate fechaSeleccionada = LocalDate.parse(jcbFechas.getSelectedItem().toString(),forma);
//                cargarTabla(fechaSeleccionada);
//                sumarTotal();
//        }
        
    }//GEN-LAST:event_jcbFechasActionPerformed

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
        List<LocalDate> listaFechas = pedidoData.FechasConPedidos();
        if (!listaFechas.isEmpty()){
            for (LocalDate fecha:listaFechas){
                DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yy");
                String fechaConFormato = fecha.format(forma);
                jcbFechas.addItem(fechaConFormato);
                //jcbFechas.addItem((LocalDate.parse(fechaConFormato,forma)));
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
    
    private void cargarTabla(LocalDate fechaSeleccionada){
        List<Pedido> listaPedidos = pedidoData.listarTodosLosPedidos();
        if (!listaPedidos.isEmpty()){
            for (Pedido pedidos:listaPedidos){
                if (pedidos.getFechaPedido().isEqual(fechaSeleccionada)){
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
        for(Mesero m:meseroData.ListarMeseros()){
            jcbMeseros.addItem(m);
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbListarTodo;
    private javax.swing.JComboBox<String> jcbFechas;
    private javax.swing.JComboBox<Mesa> jcbMesas;
    private javax.swing.JComboBox<Mesero> jcbMeseros;
    private javax.swing.JLabel jlCerrar;
    private javax.swing.JLabel jlDetalles;
    private javax.swing.JLabel jlDetalles1;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlFondoImage;
    private javax.swing.JLabel jlFondoTrasparente1;
    private javax.swing.JLabel jlMesa;
    private javax.swing.JLabel jlMesero;
    private javax.swing.JLabel jlTituloIngresos;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JPanel jpFondo;
    private javax.swing.JTable jtListaDetalles;
    private javax.swing.JTextField jtTotal;
    // End of variables declaration//GEN-END:variables

    private void borrarFila(){
        int f=jtListaDetalles.getRowCount()-1;
        for(;f>=0;f--){
            modelo.removeRow(f);
        }
    }
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
    
    private void acomodarTabla(){
        jtListaDetalles.getColumnModel().getColumn(0).setPreferredWidth(40); // Ajustar el ancho de la segunda columna
        jtListaDetalles.getColumnModel().getColumn(1).setPreferredWidth(40);
        jtListaDetalles.getColumnModel().getColumn(2).setPreferredWidth(30);
        jtListaDetalles.getColumnModel().getColumn(3).setPreferredWidth(60);
        jtListaDetalles.getColumnModel().getColumn(4).setPreferredWidth(60);
    }
}
