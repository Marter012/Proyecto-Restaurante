/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Vistas;

import java.awt.Color;
import javax.swing.JOptionPane;
import proyecto.restaurante.Control.MeseroData;

/**
 *
 * @author Emito
 */
public class LoginMesero extends javax.swing.JFrame {

    /**
     * Creates new form LoginMesero
     */
    public LoginMesero() {
        initComponents();
        this.setLocationRelativeTo(null);
        estilos();
    }
    public void estilos (){
        FondoTransparente.setBackground(new Color(35,34,36,210));
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        background = new javax.swing.JPanel();
        Cerrar = new javax.swing.JLabel();
        LogoMesero = new javax.swing.JLabel();
        loginMesero = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        Usuario = new javax.swing.JLabel();
        jtUsuario = new javax.swing.JTextField();
        jbIngresar = new javax.swing.JButton();
        jtPassword = new javax.swing.JPasswordField();
        FondoTransparente = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        background.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cerrar.setBackground(new java.awt.Color(255, 255, 255));
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
        background.add(Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 40, 30));

        LogoMesero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoMesero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/restaurante/resources/imagenes/usuario.png"))); // NOI18N
        background.add(LogoMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 500, 200));

        loginMesero.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        loginMesero.setForeground(new java.awt.Color(255, 255, 255));
        loginMesero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginMesero.setText("Login");
        background.add(loginMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 100, 500, -1));

        Password.setFont(new java.awt.Font("Roboto", 1, 17)); // NOI18N
        Password.setForeground(new java.awt.Color(255, 255, 255));
        Password.setText("Password:");
        background.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, -1, -1));

        Usuario.setFont(new java.awt.Font("Roboto", 1, 17)); // NOI18N
        Usuario.setForeground(new java.awt.Color(255, 255, 255));
        Usuario.setText("Usuario:");
        background.add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 90, -1));

        jtUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        jtUsuario.setText("Ingrese Dni");
        jtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtUsuarioMousePressed(evt);
            }
        });
        jtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtUsuarioActionPerformed(evt);
            }
        });
        background.add(jtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 240, -1));

        jbIngresar.setBackground(new java.awt.Color(153, 153, 0));
        jbIngresar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jbIngresar.setForeground(new java.awt.Color(0, 0, 0));
        jbIngresar.setText("Ingresar");
        jbIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIngresarActionPerformed(evt);
            }
        });
        background.add(jbIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 150, -1));

        jtPassword.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtPassword.setForeground(new java.awt.Color(153, 153, 153));
        jtPassword.setText("********");
        jtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtPasswordMousePressed(evt);
            }
        });
        background.add(jtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 240, -1));

        FondoTransparente.setOpaque(true);
        background.add(FondoTransparente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 350, 460));

        Fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/restaurante/resources/imagenes/fondoLogin.jpg"))); // NOI18N
        Fondo.setMaximumSize(new java.awt.Dimension(400, 500));
        Fondo.setMinimumSize(new java.awt.Dimension(400, 500));
        background.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtUsuarioActionPerformed

    private void jtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUsuarioMousePressed
        if (jtUsuario.getText().equalsIgnoreCase("Ingrese Dni")){
        jtUsuario.setText("");
        jtUsuario.setForeground(Color.black);
        }
        if(String.valueOf(jtPassword.getPassword()).isEmpty()){
        jtPassword.setText("********");
        jtPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_jtUsuarioMousePressed

    private void jtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPasswordMousePressed
        if (String.valueOf(jtPassword.getPassword()).equals("********")){
        jtPassword.setText("");
        jtPassword.setForeground(Color.black);
        }
        if (jtUsuario.getText().isEmpty()){
        jtUsuario.setText("Ingrese Dni");
        jtUsuario.setForeground(Color.gray);
        }
    }//GEN-LAST:event_jtPasswordMousePressed

    private void jbIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIngresarActionPerformed
        MeseroData md = new MeseroData();
        int dni;
        String ps;
        try{
            dni=Integer.parseInt(jtUsuario.getText());
            ps=String.valueOf(jtPassword.getPassword());
                if(md.loginMesero(dni, ps)){
                    
                    this.setVisible(false);
                    PrincipalView pv = new PrincipalView();
                    pv.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"No ingresa");
                    jtUsuario.setText("Ingrese Dni");
                    jtUsuario.setForeground(Color.gray);
                    jtPassword.setText("********");
                    jtPassword.setForeground(Color.gray);
                }
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingrese numero de dni"+e);
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Complete todos los campos "+e);
        }
    }//GEN-LAST:event_jbIngresarActionPerformed

    private void CerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseEntered
        // TODO add your handling code here:
        Cerrar.setForeground(Color.gray);
    }//GEN-LAST:event_CerrarMouseEntered

    private void CerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseExited
        // TODO add your handling code here:
        Cerrar.setForeground(Color.white);
    }//GEN-LAST:event_CerrarMouseExited

    private void CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_CerrarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginMesero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginMesero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginMesero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginMesero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginMesero().setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel FondoTransparente;
    private javax.swing.JLabel LogoMesero;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel Usuario;
    private javax.swing.JPanel background;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jbIngresar;
    private javax.swing.JPasswordField jtPassword;
    public javax.swing.JTextField jtUsuario;
    private javax.swing.JLabel loginMesero;
    // End of variables declaration//GEN-END:variables
}
