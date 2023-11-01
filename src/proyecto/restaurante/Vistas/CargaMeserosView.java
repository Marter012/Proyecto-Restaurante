/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Vistas;

import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import proyecto.restaurante.Control.MeseroData;
import proyecto.restaurante.Entidades.Mesero;

/**
 *
 * @author Emito
 */
public class CargaMeserosView extends javax.swing.JInternalFrame {
    private Mesero m;
    private final MeseroData meseroData;
    
    public CargaMeserosView() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        estilos();
        ActivarCargaUsuarios();
        DesactivarComboBox();
        meseroData = new MeseroData();
          
          
        
    }
    private void estilos(){
        Fondo.setBackground(new Color(35,34,36,210));
        TransparenciaCargar.setBackground(new Color(35,34,36,160));
        TransparenciaModificar.setBackground(new Color(35,34,36,160));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        Cerrar = new javax.swing.JLabel();
        jlSubtituloModificar = new javax.swing.JLabel();
        jlTipoUsuario = new javax.swing.JLabel();
        jcbCategoria = new javax.swing.JComboBox<>();
        jlListaUsuarios = new javax.swing.JLabel();
        jcbUsuarios = new javax.swing.JComboBox<>();
        TransparenciaCargar = new javax.swing.JLabel();
        jlSubtituloCargar = new javax.swing.JLabel();
        jlIdMesero = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jlApellido = new javax.swing.JLabel();
        jtApellido = new javax.swing.JTextField();
        jlDni = new javax.swing.JLabel();
        jtDni = new javax.swing.JTextField();
        jlEstado = new javax.swing.JLabel();
        jrbActivo = new javax.swing.JRadioButton();
        jrbInactivo = new javax.swing.JRadioButton();
        jlAcceso = new javax.swing.JLabel();
        jrbEncargado = new javax.swing.JRadioButton();
        jrbMesero = new javax.swing.JRadioButton();
        jlContraseña = new javax.swing.JLabel();
        jtPassword = new javax.swing.JPasswordField();
        jcMostrarContraseña = new javax.swing.JCheckBox();
        jbCrearMesero = new javax.swing.JButton();
        jbActualizarMesero = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        TransparenciaModificar = new javax.swing.JLabel();
        FondoImagen = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        setPreferredSize(new java.awt.Dimension(540, 590));

        Fondo.setBackground(new java.awt.Color(0, 0, 0));
        Fondo.setPreferredSize(new java.awt.Dimension(540, 590));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlTitulo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlTitulo.setText("Carga y modificacion de Usuarios");
        Fondo.add(jlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

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

        jlSubtituloModificar.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jlSubtituloModificar.setForeground(new java.awt.Color(255, 255, 255));
        jlSubtituloModificar.setText("Seleccione Usuario a Modificar");
        Fondo.add(jlSubtituloModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jlTipoUsuario.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlTipoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jlTipoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTipoUsuario.setText("Tipo de Usuario");
        Fondo.add(jlTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 120, 30));

        jcbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbCategoriaMouseClicked(evt);
            }
        });
        jcbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCategoriaActionPerformed(evt);
            }
        });
        Fondo.add(jcbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 120, -1));

        jlListaUsuarios.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlListaUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        jlListaUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlListaUsuarios.setText("Lista de Usuarios:");
        Fondo.add(jlListaUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 270, 30));

        jcbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbUsuariosMouseClicked(evt);
            }
        });
        jcbUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbUsuariosActionPerformed(evt);
            }
        });
        Fondo.add(jcbUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 270, -1));

        TransparenciaCargar.setOpaque(true);
        Fondo.add(TransparenciaCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 46, 500, 140));

        jlSubtituloCargar.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jlSubtituloCargar.setForeground(new java.awt.Color(255, 255, 255));
        jlSubtituloCargar.setText("Complete los Datos para un nuevo Usuario");
        Fondo.add(jlSubtituloCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));
        Fondo.add(jlIdMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 20, 30));

        jlNombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlNombre.setForeground(new java.awt.Color(255, 255, 255));
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNombre.setText("Nombre:");
        Fondo.add(jlNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 130, 30));

        jtNombre.setBackground(new java.awt.Color(245, 233, 144));
        jtNombre.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        Fondo.add(jtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 320, -1));

        jlApellido.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlApellido.setForeground(new java.awt.Color(255, 255, 255));
        jlApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlApellido.setText("Apellido:");
        Fondo.add(jlApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 130, 30));

        jtApellido.setBackground(new java.awt.Color(245, 233, 144));
        Fondo.add(jtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 320, -1));

        jlDni.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlDni.setForeground(new java.awt.Color(255, 255, 255));
        jlDni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDni.setText("Dni:");
        Fondo.add(jlDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 130, 30));

        jtDni.setBackground(new java.awt.Color(245, 233, 144));
        Fondo.add(jtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 320, -1));

        jlEstado.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlEstado.setForeground(new java.awt.Color(255, 255, 255));
        jlEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlEstado.setText("Estado:");
        Fondo.add(jlEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 130, 30));

        jrbActivo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jrbActivo.setForeground(new java.awt.Color(255, 255, 255));
        jrbActivo.setText("Activo");
        jrbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbActivoActionPerformed(evt);
            }
        });
        Fondo.add(jrbActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 120, -1));

        jrbInactivo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jrbInactivo.setForeground(new java.awt.Color(255, 255, 255));
        jrbInactivo.setText("Inactivo");
        jrbInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbInactivoActionPerformed(evt);
            }
        });
        Fondo.add(jrbInactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 120, -1));

        jlAcceso.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlAcceso.setForeground(new java.awt.Color(255, 255, 255));
        jlAcceso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAcceso.setText("Acceso:");
        Fondo.add(jlAcceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 130, 30));

        jrbEncargado.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jrbEncargado.setForeground(new java.awt.Color(255, 255, 255));
        jrbEncargado.setText("Encargado");
        jrbEncargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEncargadoActionPerformed(evt);
            }
        });
        Fondo.add(jrbEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 120, -1));

        jrbMesero.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jrbMesero.setForeground(new java.awt.Color(255, 255, 255));
        jrbMesero.setText("Mesero");
        jrbMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMeseroActionPerformed(evt);
            }
        });
        Fondo.add(jrbMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 120, -1));

        jlContraseña.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jlContraseña.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlContraseña.setText("Contraseña:");
        Fondo.add(jlContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 130, 30));

        jtPassword.setBackground(new java.awt.Color(245, 233, 144));
        Fondo.add(jtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 320, -1));

        jcMostrarContraseña.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jcMostrarContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jcMostrarContraseña.setText("Mostrar Contraseña");
        jcMostrarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcMostrarContraseñaActionPerformed(evt);
            }
        });
        Fondo.add(jcMostrarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, -1, 20));

        jbCrearMesero.setBackground(new java.awt.Color(153, 153, 0));
        jbCrearMesero.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jbCrearMesero.setForeground(new java.awt.Color(51, 51, 51));
        jbCrearMesero.setText("Cargar Mesero");
        jbCrearMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearMeseroActionPerformed(evt);
            }
        });
        Fondo.add(jbCrearMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 140, -1));

        jbActualizarMesero.setBackground(new java.awt.Color(153, 153, 0));
        jbActualizarMesero.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jbActualizarMesero.setForeground(new java.awt.Color(51, 51, 51));
        jbActualizarMesero.setText("Actualizar Mesero");
        jbActualizarMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarMeseroActionPerformed(evt);
            }
        });
        Fondo.add(jbActualizarMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, -1, -1));

        Limpiar.setBackground(new java.awt.Color(153, 153, 0));
        Limpiar.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        Limpiar.setForeground(new java.awt.Color(51, 51, 51));
        Limpiar.setText("Limpiar Pantalla");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });
        Fondo.add(Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, 130, -1));

        TransparenciaModificar.setOpaque(true);
        Fondo.add(TransparenciaModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 500, 360));

        FondoImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/restaurante/resources/imagenes/FondoInternalFrames.jpg"))); // NOI18N
        FondoImagen.setLabelFor(Fondo);
        Fondo.add(FondoImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 590));

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

    private void jbActualizarMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarMeseroActionPerformed
        String tipoUsuario;
        int posicion;
        Mesero meseroSeleccionado;
        try {
            m = new Mesero();
            m.setIdMesero(Integer.parseInt(jlIdMesero.getText()));
            if (jtNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Complete el campo Nombre");
                jtNombre.requestFocus();
            }else{
                if (ComprobarCaracteres(jtNombre.getText())){
                   JOptionPane.showMessageDialog(null,"Ingrese letras para Nombre");
                    jtNombre.setText("");
                    jtNombre.requestFocus(); 
                }else{
                    m.setNombre(jtNombre.getText());

                    if (jtApellido.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Complete el campo Apellido");
                        jtApellido.requestFocus();
                    }else{
                        if (ComprobarCaracteres(jtApellido.getText())){
                            JOptionPane.showMessageDialog(null,"Ingrese letras para Apellido");
                            jtApellido.setText("");
                            jtApellido.requestFocus();
                        }else{
                            m.setApellido(jtApellido.getText());
                            if (jtDni.getText().length()!=8){
                                JOptionPane.showMessageDialog(null,"Ingrese un Dni de 8 Digitos.");
                                jtDni.requestFocus();
                            }else{
                                m.setDni(Integer.parseInt(jtDni.getText()));

                                    if (jrbEncargado.isSelected()){
                                        m.setAcceso(1);
                                        tipoUsuario="Encargados";
                                    }else{
                                        m.setAcceso(2);
                                        tipoUsuario="Meseros";
                                    }

                                    if (jrbActivo.isSelected()){
                                        m.setEstado(true);
                                    }else{
                                        m.setEstado(false);
                                        tipoUsuario="Inactivos";
                                    }

                                if(jtPassword.getText().isEmpty()){
                                    JOptionPane.showMessageDialog(null,"Complete el campo Contraseña");
                                    jtPassword.requestFocus();
                                }else{
                                    m.setPassword(jtPassword.getText());
                                    meseroData.modificarMesero(m);
                                    meseroSeleccionado = meseroData.buscarMeseroPorDNI(m.getDni());
                                    jcbCategoria.setEnabled(true);
                                    jcbCategoria.removeAllItems();
                                    CargarCategorias();
                                    jcbUsuarios.setEnabled(true);
                                    jcbCategoria.setSelectedItem(tipoUsuario);
                                    jcbUsuarios.removeAllItems();
                                    switch(tipoUsuario){
                                        case "Encargados":
                                            CargarComboEncargadosEnUsuario();
                                            posicion = BuscarPosicionEncargado(meseroSeleccionado);
                                            jcbUsuarios.setSelectedIndex(posicion);
                                            break;

                                        case "Meseros":
                                            CargarComboMeserosEnUsuario();
                                            posicion = BuscarPosicionMesero(meseroSeleccionado);
                                            jcbUsuarios.setSelectedIndex(posicion);
                                            break;

                                        case "Inactivos":
                                            CargarComboInactivosEnUsuario();
                                            posicion = BuscarPosicionInactivo(meseroSeleccionado);
                                            jcbUsuarios.setSelectedIndex(posicion);
                                            break;

                                    }
                                }
                            }
                        }    
                    }    
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"Complete con numeros el campo Dni.");
            jtDni.setText("");
            jtDni.requestFocus();
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(this,"Verifique los datos ingresados");
        }
    }//GEN-LAST:event_jbActualizarMeseroActionPerformed

    private void jrbInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbInactivoActionPerformed
        // TODO add your handling code here:
        if (jrbInactivo.isSelected()){
            jrbActivo.setSelected(false);
        }else{
            jrbActivo.setSelected(true);
        }
    }//GEN-LAST:event_jrbInactivoActionPerformed

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

    private void jbCrearMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearMeseroActionPerformed
        String tipoUsuario;
        int posicion;
        Mesero meseroSeleccionado;
        try {
            m = new Mesero();
            if (jtNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Complete el campo Nombre");
                jtNombre.requestFocus();
            }else{
                if (ComprobarCaracteres(jtNombre.getText())){
                   JOptionPane.showMessageDialog(null,"Ingrese letras para Nombre");
                    jtNombre.setText("");
                    jtNombre.requestFocus(); 
                }else{
                    m.setNombre(jtNombre.getText());

                    if (jtApellido.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Complete el campo Apellido");
                        jtApellido.requestFocus();
                    }else{
                        if (ComprobarCaracteres(jtApellido.getText())){
                            JOptionPane.showMessageDialog(null,"Ingrese letras para Apellido");
                            jtApellido.setText("");
                            jtApellido.requestFocus();
                        }else{
                            m.setApellido(jtApellido.getText());
                            if (jtDni.getText().length()!=8){
                                JOptionPane.showMessageDialog(null,"Ingrese un Dni de 8 Digitos.");
                                jtDni.requestFocus();
                            }else{
                                m.setDni(Integer.parseInt(jtDni.getText()));

                                    if (jrbEncargado.isSelected()){
                                        m.setAcceso(1);
                                        tipoUsuario="Encargados";
                                    }else{
                                        m.setAcceso(2);
                                        tipoUsuario="Meseros";
                                    }

                                    if (jrbActivo.isSelected()){
                                        m.setEstado(true);
                                    }else{
                                        m.setEstado(false);
                                        tipoUsuario="Inactivos";
                                    }

                                if(jtPassword.getText().isEmpty()){
                                    JOptionPane.showMessageDialog(null,"Complete el campo Contraseña");
                                    jtPassword.requestFocus();
                                }else{
                                    m.setPassword(jtPassword.getText());
                                    meseroData.agregarMesero(m);
                                    meseroSeleccionado = meseroData.buscarMeseroPorDNI(m.getDni());
                                    jcbCategoria.setEnabled(true);
                                    CargarCategorias();
                                    jcbUsuarios.setEnabled(true);
                                    jcbCategoria.setSelectedItem(tipoUsuario);
                                    jcbUsuarios.removeAllItems();
                                    switch(tipoUsuario){
                                        case "Encargados":
                                            CargarComboEncargadosEnUsuario();
                                            posicion = BuscarPosicionEncargado(meseroSeleccionado);
                                            jcbUsuarios.setSelectedIndex(posicion);
                                            break;

                                        case "Meseros":
                                            CargarComboMeserosEnUsuario();
                                            posicion = BuscarPosicionMesero(meseroSeleccionado);
                                            jcbUsuarios.setSelectedIndex(posicion);
                                            break;

                                        case "Inactivos":
                                            CargarComboInactivosEnUsuario();
                                            posicion = BuscarPosicionInactivo(meseroSeleccionado);
                                            jcbUsuarios.setSelectedIndex(posicion);
                                            break;

                                    }
                                }
                            }
                        }    
                    }    
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"Complete con numeros el campo Dni.");
            jtDni.setText("");
            jtDni.requestFocus();
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(this,"Verifique los datos ingresados");
        }
    }//GEN-LAST:event_jbCrearMeseroActionPerformed

    private void jrbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbActivoActionPerformed
        // TODO add your handling code here:
        if (jrbActivo.isSelected()){
            jrbInactivo.setSelected(false);
        }else{
            jrbInactivo.setSelected(true);
        }
    }//GEN-LAST:event_jrbActivoActionPerformed

    private void jrbEncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEncargadoActionPerformed
        // TODO add your handling code here:
        if (jrbEncargado.isSelected()){
            jrbMesero.setSelected(false);
        }else{
            jrbMesero.setSelected(true);
        }
    }//GEN-LAST:event_jrbEncargadoActionPerformed

    private void jrbMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMeseroActionPerformed
        // TODO add your handling code here:
        if (jrbMesero.isSelected()){
            jrbEncargado.setSelected(false);
        }else{
            jrbEncargado.setSelected(true);
        }
    }//GEN-LAST:event_jrbMeseroActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        LimpiarPantallaUsuario();
    }//GEN-LAST:event_LimpiarActionPerformed

    private void jcbCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbCategoriaMouseClicked

                if (!jcbCategoria.isEnabled()){
                    ActivarComboBox();
                    CargarCategorias();
                    //Cambiar por mesero en Usuario
                    //CargarComboEncargadosEnUsuario();
                    if (jcbUsuarios.getItemCount()!=0){
                        m = new Mesero();
                        m = (Mesero) jcbUsuarios.getSelectedItem();
                        CargarDatosMesero(m);
                        ActivarActualizarUsuarios();
                    }else{
                      LimpiarCampos();
                      ActivarCargaUsuarios();
                      DesactivarComboBox();
                    }
                }
        
    }//GEN-LAST:event_jcbCategoriaMouseClicked

    private void jcbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCategoriaActionPerformed
        String categoriaSeleccionada = String.valueOf( jcbCategoria.getSelectedItem());
        switch (categoriaSeleccionada){
            case "Meseros":
                jcbUsuarios.removeAllItems();
                jcbUsuarios.setEnabled(true);
                CargarComboMeserosEnUsuario();
                if (jcbUsuarios.getItemCount()==0){
                    JOptionPane.showMessageDialog(null,"Lista Vacia");
                    LimpiarCamposUsuario();
                    jcbUsuarios.setEnabled(false);
                    
                }
                break;
                
            case "Encargados":
                jcbUsuarios.removeAllItems();
                jcbUsuarios.setEnabled(true);
                CargarComboEncargadosEnUsuario();
                if (jcbUsuarios.getItemCount()==0){
                    JOptionPane.showMessageDialog(null,"Lista Vacia");
                    LimpiarCamposUsuario();
                    jcbUsuarios.setEnabled(false);
                }
                break;
                
            case "Inactivos":
                jcbUsuarios.removeAllItems();
                jcbUsuarios.setEnabled(true);
                CargarComboInactivosEnUsuario();
                if (jcbUsuarios.getItemCount()==0){
                    JOptionPane.showMessageDialog(null,"Lista Vacia");
                    LimpiarCamposUsuario();
                    jcbUsuarios.setEnabled(false);
                }
                break;
                
        }
    }//GEN-LAST:event_jcbCategoriaActionPerformed

    private void jcbUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbUsuariosActionPerformed
        if (jcbUsuarios.getItemCount()!=0){
            m = new Mesero();
            m = (Mesero)jcbUsuarios.getSelectedItem();
            CargarDatosMesero(m);
            jbActualizarMesero.setEnabled(true);
        }else{
            jbCrearMesero.setEnabled(false);
            jbActualizarMesero.setEnabled(false);
        }
    }//GEN-LAST:event_jcbUsuariosActionPerformed

    private void jcMostrarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcMostrarContraseñaActionPerformed
        if (jcMostrarContraseña.isSelected()){
            jtPassword.setEchoChar((char)0);
        }else{
            jtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jcMostrarContraseñaActionPerformed

    private void jcbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbUsuariosMouseClicked
        if (!jcbCategoria.isEnabled()){
            JOptionPane.showMessageDialog(null, "Seleccione tipo de usuario");
        }
    }//GEN-LAST:event_jcbUsuariosMouseClicked
    
    private void CargarDatosMesero(Mesero meseroSeleccionado){
            if (meseroSeleccionado!=null){
                jlIdMesero.setText(String.valueOf(m.getIdMesero()));
                jtNombre.setText(m.getNombre());
                jtApellido.setText(m.getApellido());
                jtDni.setText(String.valueOf(m.getDni()));
                if (m.isEstado()){
                    jrbActivo.setSelected(true);
                    jrbInactivo.setSelected(false);
                }else{
                    jrbActivo.setSelected(false);
                    jrbInactivo.setSelected(true);
                }
                if (m.getAcceso()==1){
                    jrbEncargado.setSelected(true);
                    jrbMesero.setSelected(false);
                }else{
                    jrbEncargado.setSelected(false);
                    jrbMesero.setSelected(true);
                }
                jtPassword.setText(m.getPassword());
                jtPassword.setText(m.getPassword());

            }else{
                JOptionPane.showMessageDialog(null, "Debe Seleccionar un Mesero");
                LimpiarCamposUsuario();
                ActivarCargaUsuarios();
            }
        
    }
    
    private boolean ComprobarCaracteres(String e){
        boolean validado=false;
        for (int i =0; i<e.length();i++){
            char c = e.charAt(i);
            if (!Character.isLetter(c) && !Character.isWhitespace(c)){
                validado=  true;
                break;
            }
        }
        return validado;
    }
    
    private void CargarCategorias(){
        jcbCategoria.addItem("Encargados");
        jcbCategoria.addItem("Meseros");
        jcbCategoria.addItem("Inactivos");
    }
    
    private void DesactivarComboBox(){
          jcbCategoria.setEnabled(false);
          jcbUsuarios.setEnabled(false);
    }
    
    private void ActivarComboBox(){
          jcbCategoria.setEnabled(true);
          jcbUsuarios.setEnabled(true);
    }
    
    private void CargarComboMeserosEnUsuario(){
        meseroData.ListarMeseros().forEach((me) -> {
            //jcbMesero.setRenderer(new CustomRenderer());
            jcbUsuarios.addItem(me);
        });
    }
    
    private void CargarComboEncargadosEnUsuario(){
        meseroData.ListarEncargados().forEach((me) -> {
            //jcbEncargado.setRenderer(new CustomRenderer());
            jcbUsuarios.addItem(me);
        });
    }
    
    private void CargarComboInactivosEnUsuario(){
        meseroData.ListarInactivos().forEach((me) -> {
            //jcbEncargado.setRenderer(new CustomRenderer());
            jcbUsuarios.addItem(me);
        });  
    }
    
    private void ActivarCargaUsuarios(){
        jbCrearMesero.setEnabled(true);
        jbActualizarMesero.setEnabled(false);
    }
    
    private void ActivarActualizarUsuarios(){
        jbCrearMesero.setEnabled(false);
        jbActualizarMesero.setEnabled(true);
    }
    
    private void LimpiarCamposUsuario(){
        jlIdMesero.setText("");
        jtNombre.setText("");
        jtApellido.setText("");
        jtDni.setText("");
        jrbActivo.setSelected(false);
        jrbActivo.setEnabled(true);
        jrbInactivo.setSelected(false);
        jrbInactivo.setEnabled(true);
        jrbEncargado.setSelected(false);
        jrbEncargado.setEnabled(true);
        jrbMesero.setSelected(false);
        jrbMesero.setEnabled(true);
        jtPassword.setText("");
    }
    
    private void LimpiarCampos(){
        jlIdMesero.setText("");
        jtNombre.setText("");
        jtApellido.setText("");
        jtDni.setText("");
        jrbActivo.setSelected(false);
        jrbInactivo.setSelected(false);
        jrbEncargado.setSelected(false);
        jrbMesero.setSelected(false);
        jtPassword.setText("");
    }
    
    private void LimpiarPantallaUsuario(){
        jcbCategoria.removeAllItems();
        jcbUsuarios.removeAllItems();
        DesactivarComboBox();
        LimpiarCamposUsuario();
        ActivarCargaUsuarios();  
    }
    
    private int BuscarPosicionMesero(Mesero meseroSeleccionado){
        int posicion =-1;
        List<Mesero> listaMeseros = meseroData.ListarMeseros();
            for (Mesero mesero:listaMeseros){
                if (mesero.getDni()==meseroSeleccionado.getDni()){
                    posicion = listaMeseros.indexOf(mesero);
                }
            }
        return posicion;
    }
    
    private int BuscarPosicionEncargado(Mesero encargadoSeleccionado){
        int posicion =-1;
        List<Mesero> listaEncargados = meseroData.ListarEncargados();
            for (Mesero mesero:listaEncargados){
                if (mesero.getDni()==encargadoSeleccionado.getDni()){
                    posicion = listaEncargados.indexOf(mesero);
                }
            }
        return posicion;
    }
    
    private int BuscarPosicionInactivo(Mesero inactivoSeleccionado){
        int posicion =-1;
        List<Mesero> listaInactivos = meseroData.ListarInactivos();
            for (Mesero mesero:listaInactivos){
                if (mesero.getDni()==inactivoSeleccionado.getDni()){
                    posicion = listaInactivos.indexOf(mesero);
                }
            }
        return posicion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel FondoImagen;
    private javax.swing.JButton Limpiar;
    private javax.swing.JLabel TransparenciaCargar;
    private javax.swing.JLabel TransparenciaModificar;
    private javax.swing.JButton jbActualizarMesero;
    private javax.swing.JButton jbCrearMesero;
    private javax.swing.JCheckBox jcMostrarContraseña;
    private javax.swing.JComboBox<String> jcbCategoria;
    private javax.swing.JComboBox<Mesero> jcbUsuarios;
    private javax.swing.JLabel jlAcceso;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlContraseña;
    private javax.swing.JLabel jlDni;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlIdMesero;
    private javax.swing.JLabel jlListaUsuarios;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlSubtituloCargar;
    private javax.swing.JLabel jlSubtituloModificar;
    private javax.swing.JLabel jlTipoUsuario;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JRadioButton jrbActivo;
    private javax.swing.JRadioButton jrbEncargado;
    private javax.swing.JRadioButton jrbInactivo;
    private javax.swing.JRadioButton jrbMesero;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JPasswordField jtPassword;
    // End of variables declaration//GEN-END:variables
}
