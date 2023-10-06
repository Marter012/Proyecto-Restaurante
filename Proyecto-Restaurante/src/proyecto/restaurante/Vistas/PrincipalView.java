/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.restaurante.Vistas;

import java.awt.Color;

/**
 *
 * @author Emito
 */
public class PrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalView
     */
    public PrincipalView() {
        initComponents();
        this.setLocationRelativeTo(null);
        estilos();
        
    }
    public void estilos (){
        FondoTransparente.setBackground(new Color(35,34,36,210));
        EscritorioFrames.setBackground(new Color(0,0,0,0));
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        escritorio = new javax.swing.JDesktopPane();
        MenuLateral = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        LabelMeseros = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        FondoTransparente = new javax.swing.JLabel();
        EscritorioFrames = new javax.swing.JDesktopPane();
        Contenedor = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        escritorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuLateral.setBackground(new java.awt.Color(9, 9, 9));
        MenuLateral.setOpaque(false);
        MenuLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin");
        MenuLateral.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 50));

        jSeparator1.setBackground(new java.awt.Color(189, 193, 96));
        jSeparator1.setForeground(new java.awt.Color(189, 193, 96));
        MenuLateral.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 48, 240, 10));

        jButton1.setBackground(new java.awt.Color(153, 153, 0));
        jButton1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Meseros");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        MenuLateral.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 170, 50));

        jButton2.setBackground(new java.awt.Color(153, 153, 0));
        jButton2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Mesas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        MenuLateral.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 171, 50));

        jButton3.setBackground(new java.awt.Color(153, 153, 0));
        jButton3.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Ingresos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        MenuLateral.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 171, 50));

        jButton4.setBackground(new java.awt.Color(153, 153, 0));
        jButton4.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("Productos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        MenuLateral.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 171, 50));

        jSeparator2.setBackground(new java.awt.Color(189, 193, 96));
        jSeparator2.setForeground(new java.awt.Color(189, 193, 96));
        MenuLateral.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 240, 10));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Meseros");
        MenuLateral.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 240, 50));

        jSeparator3.setBackground(new java.awt.Color(189, 193, 96));
        jSeparator3.setForeground(new java.awt.Color(189, 193, 96));
        MenuLateral.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 240, -1));

        jButton5.setBackground(new java.awt.Color(153, 153, 0));
        jButton5.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setText("Pedidos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        MenuLateral.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 169, 50));

        jSeparator5.setBackground(new java.awt.Color(189, 193, 96));
        jSeparator5.setForeground(new java.awt.Color(189, 193, 96));
        MenuLateral.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 10));

        LabelMeseros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelMeseros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/restaurante/resources/imagenes/meseroIcon.png"))); // NOI18N
        MenuLateral.add(LabelMeseros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 60, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/restaurante/resources/imagenes/mesaIcon.png"))); // NOI18N
        MenuLateral.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 60, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/restaurante/resources/imagenes/productoIcon.png"))); // NOI18N
        MenuLateral.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 60, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/restaurante/resources/imagenes/ingresosIcon.png"))); // NOI18N
        MenuLateral.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 60, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/restaurante/resources/imagenes/pedidoIcon.png"))); // NOI18N
        MenuLateral.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 430, 60, -1));

        FondoTransparente.setOpaque(true);
        MenuLateral.add(FondoTransparente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 600));

        escritorio.add(MenuLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 600));

        EscritorioFrames.setOpaque(false);
        EscritorioFrames.setLayout(new java.awt.GridLayout());
        escritorio.add(EscritorioFrames, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 5, 540, 590));

        Contenedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/restaurante/resources/imagenes/FondoInicioConLogo.jpg"))); // NOI18N
        escritorio.add(Contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EscritorioFrames.removeAll();
        EscritorioFrames.repaint();
        CargaMeserosView cmv = new CargaMeserosView();
        cmv.setVisible(true);
        EscritorioFrames.add(cmv);
        EscritorioFrames.moveToFront(cmv);
        
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contenedor;
    private javax.swing.JDesktopPane EscritorioFrames;
    private javax.swing.JLabel FondoTransparente;
    private javax.swing.JLabel LabelMeseros;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
