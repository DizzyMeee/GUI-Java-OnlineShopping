/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineshop;

import javax.swing.*;
import java.sql.*;

public class Interface_LoginAdmin extends javax.swing.JFrame {
    Connection conn;
    
    public Interface_LoginAdmin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_title2 = new javax.swing.JTextField();
        txt_titleEmail = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_titlePass = new javax.swing.JTextField();
        jpass_pass = new javax.swing.JPasswordField();
        bt_signIn = new javax.swing.JButton();
        bt_customer = new javax.swing.JButton();
        txt_title1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(238, 216, 234));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_title2.setEditable(false);
        txt_title2.setFont(new java.awt.Font("CaslonCP", 0, 36)); // NOI18N
        txt_title2.setText("Admin");
        txt_title2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_title2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_title2ActionPerformed(evt);
            }
        });
        jPanel1.add(txt_title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        txt_titleEmail.setEditable(false);
        txt_titleEmail.setFont(new java.awt.Font("Orator Std", 0, 16)); // NOI18N
        txt_titleEmail.setForeground(new java.awt.Color(51, 51, 51));
        txt_titleEmail.setText(" E M A I L");
        txt_titleEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_titleEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_titleEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txt_titleEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 110, 40));

        txt_email.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 230, 50));

        txt_titlePass.setEditable(false);
        txt_titlePass.setFont(new java.awt.Font("Orator Std", 0, 16)); // NOI18N
        txt_titlePass.setForeground(new java.awt.Color(51, 51, 51));
        txt_titlePass.setText(" P A S S W O R D");
        txt_titlePass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_titlePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 180, 40));

        jpass_pass.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(jpass_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 230, 50));

        bt_signIn.setText("SIGN IN");
        bt_signIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_signInActionPerformed(evt);
            }
        });
        jPanel1.add(bt_signIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, -1, -1));

        bt_customer.setText("I am a customer");
        bt_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_customerActionPerformed(evt);
            }
        });
        jPanel1.add(bt_customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, -1, -1));

        txt_title1.setEditable(false);
        txt_title1.setFont(new java.awt.Font("CaslonCP", 0, 36)); // NOI18N
        txt_title1.setText("WELCOME");
        txt_title1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_title1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_title1ActionPerformed(evt);
            }
        });
        jPanel1.add(txt_title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_title2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_title2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_title2ActionPerformed

    private void txt_titleEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_titleEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_titleEmailActionPerformed

    private void bt_signInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_signInActionPerformed
        String query = "SELECT * FROM ADMIN WHERE EMAIL_ADM =? AND PASS_ADM =?";
        
        String email = txt_email.getText();
        String pass = String.valueOf(jpass_pass.getPassword());
        
        try{
            conn = new ConnectionSQL().getConSQL();
            PreparedStatement ps;
            ps = conn.prepareStatement(query);
            ResultSet rs;
            
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "SUCCESS");
                ManageProduct mp = new ManageProduct();
                mp.setVisible(true);
                mp.setSize(780,650);
                mp.setLocationRelativeTo(null);
                mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Wrong Email or Wrong Password");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_bt_signInActionPerformed

    private void txt_title1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_title1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_title1ActionPerformed

    private void bt_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_customerActionPerformed
       Interface_LoginCustomer ilc = new Interface_LoginCustomer();
       ilc.setVisible(true);
       ilc.pack();
       ilc.setLocationRelativeTo(null);
       ilc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.dispose();
    }//GEN-LAST:event_bt_customerActionPerformed

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
            java.util.logging.Logger.getLogger(Interface_LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface_LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface_LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface_LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface_LoginAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_customer;
    private javax.swing.JButton bt_signIn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jpass_pass;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_title1;
    private javax.swing.JTextField txt_title2;
    private javax.swing.JTextField txt_titleEmail;
    private javax.swing.JTextField txt_titlePass;
    // End of variables declaration//GEN-END:variables
}