package com.mycompany.ui;

import com.mycompany.dao.UserDAO;
import com.mycompany.model.Users;
import com.mycompany.network.Client;
import com.mycompany.network.Server;
import com.mycompany.until.Encode;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class LoginForm extends javax.swing.JFrame {

    private String userLog, roleUserLog;
    private UserDAO userDAO;
    private int PORT;
    
    public LoginForm() {
        userDAO = new UserDAO();
        PORT = 4000;
        initComponents();
        setupKeyEvents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginLabel = new javax.swing.JLabel();
        emailUserLabel = new javax.swing.JLabel();
        emailUserField = new javax.swing.JTextField();
        passwordUserLabel = new javax.swing.JLabel();
        passwordUserField = new javax.swing.JPasswordField();
        hidePassToggle = new javax.swing.JToggleButton();
        loginButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        regisButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login account");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginLabel.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        loginLabel.setText("LOGIN");
        getContentPane().add(loginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 24, -1, -1));

        emailUserLabel.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        emailUserLabel.setText("Email ");
        getContentPane().add(emailUserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 59, 50, -1));

        emailUserField.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        getContentPane().add(emailUserField, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 84, 250, -1));

        passwordUserLabel.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        passwordUserLabel.setText("Password");
        getContentPane().add(passwordUserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 114, 77, -1));

        passwordUserField.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        getContentPane().add(passwordUserField, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 139, 250, -1));

        hidePassToggle.setText("Show");
        hidePassToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hidePassToggleActionPerformed(evt);
            }
        });
        getContentPane().add(hidePassToggle, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 140, -1, -1));

        loginButton.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 175, 250, 35));

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        jLabel1.setText("Do not have account? Create a new account.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 216, 250, -1));

        regisButton.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        regisButton.setText("Sign up");
        regisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regisButtonActionPerformed(evt);
            }
        });
        getContentPane().add(regisButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 238, 250, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\BG_Login.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 0, 660, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setupKeyEvents() {
        passwordUserField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });

        loginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });
    }
    
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        login();
    }//GEN-LAST:event_loginButtonActionPerformed

    private void login() {
        String email = emailUserField.getText();
        String password = String.valueOf(passwordUserField.getPassword());

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Email", "Try again", JOptionPane.ERROR_MESSAGE);
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Password", "Try again", JOptionPane.ERROR_MESSAGE);
        } else {
            password = Encode.toSHA1(password);
            Users user = userDAO.getAuthenticatedUser(email, password);
            if (user != null) {
                System.out.println("Login successful");
                userLog = user.firstName + " " + user.lastName;
                roleUserLog = user.roleUser;
                dispose();
                if (roleUserLog.equalsIgnoreCase("admin")) {
                    try {
                        int startPort = 4000; 
                        int maxAttempts = 10; 
                        int port = startPort;
                        boolean serverStarted = false;
                        while (!serverStarted && port < startPort + maxAttempts) {
                            try {
                                Server server = Server.getServerInstance(port);
                                server.start();
                                System.out.println("Server started on port " + port);
                                PORT = port; 
                                serverStarted = true;
                            } catch (IOException e) {
                                System.err.println("Port " + port + " is already in use. Trying next port.");
                                port++;
                            }
                        }
                        if (!serverStarted) {
                            JOptionPane.showMessageDialog(this, "Could not start server on any available ports.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        Server server = Server.getServerInstance(PORT);
                        server.start();
                        new InformationSystem(userLog, roleUserLog, server).setVisible(true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (roleUserLog.equalsIgnoreCase("user")) {
                    new InformationSystemForUser(userLog, roleUserLog, email).setVisible(true);
                    try {
                        Socket socket = new Socket("localhost", PORT);
                        Client client = new Client(socket);
                        client.start(userLog);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (roleUserLog.equalsIgnoreCase("master")) {
                    try {
                        Server server = Server.getServerInstance(PORT);
                        server.start();
                        new userManagementForMaster(userLog, roleUserLog, server).setVisible(true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Email or Password Invalid", "Try again", JOptionPane.ERROR_MESSAGE);
            }
        }
    }                            
    
    private void hidePassToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hidePassToggleActionPerformed
        togglePasswordVisibility();
    }//GEN-LAST:event_hidePassToggleActionPerformed

    private void regisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regisButtonActionPerformed
        dispose();
        new SignInForm().setVisible(true);
    }//GEN-LAST:event_regisButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        }); 
    }
    
    private void togglePasswordVisibility(){
        if (hidePassToggle.isSelected()){
            passwordUserField.setEchoChar((char) 0);
            hidePassToggle.setText("Hide");
        } else {
            passwordUserField.setEchoChar('*');
            hidePassToggle.setText("Show");
        }
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailUserField;
    private javax.swing.JLabel emailUserLabel;
    private javax.swing.JToggleButton hidePassToggle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPasswordField passwordUserField;
    private javax.swing.JLabel passwordUserLabel;
    private javax.swing.JButton regisButton;
    // End of variables declaration//GEN-END:variables
}
