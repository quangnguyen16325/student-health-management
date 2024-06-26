package com.mycompany.ui;

import com.mycompany.dao.UserDAO;
import com.mycompany.model.Users;
import com.mycompany.network.Server;
import com.mycompany.until.Encode;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class userManagementForMaster extends javax.swing.JFrame {

    public String firstName, lastName, email, password, roleUser, userName, oldEmail, roleUserLog, userNameLog;
    private String passwordClick;
    private UserDAO userDAO;
    private Timer timer;
    private int countRequestUser;
    private Server server;
    
    public userManagementForMaster(String userName, String role, Server server) {
        initComponents();
        userDAO = new UserDAO();
        show_table();
        this.userNameLog = userName;
        this.roleUserLog = role;
        this.server = server;
        userLoginLabel.setText(userName);
        roleLabel.setText(roleUser);
        updateRequestCount(); 
        scheduleRequestCountUpdate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        userLoginLabel = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        userRequestCount = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        roleField = new javax.swing.JComboBox<>();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        nextPageButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User management");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\master.png")); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 6, 89, -1));

        userLoginLabel.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        userLoginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLoginLabel.setText("...");
        getContentPane().add(userLoginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 6, 120, -1));

        roleLabel.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        roleLabel.setForeground(new java.awt.Color(255, 51, 0));
        roleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roleLabel.setText("...");
        getContentPane().add(roleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 31, 120, -1));

        jLabel1.setFont(new java.awt.Font("Perpetua", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USER MANAGEMENT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 6, -1, 50));

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "Email", "Password", "Role"
            }
        ));
        usersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(usersTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 593, 390));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\master.png")); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 6, 89, -1));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel2.setText("First Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 80, -1, -1));

        firstNameField.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        getContentPane().add(firstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 101, 270, -1));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel3.setText("Last Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 135, -1, -1));

        jButton1.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\information.png")); // NOI18N
        jButton1.setText("REQUESTS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 140, 30));

        userRequestCount.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        userRequestCount.setText("Users request: ");
        getContentPane().add(userRequestCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 110, -1));

        lastNameField.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        getContentPane().add(lastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 156, 270, -1));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel4.setText("Email");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 190, 58, -1));

        emailField.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        getContentPane().add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 211, 270, -1));

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel5.setText("Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 245, 58, -1));

        passwordField.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 266, 270, -1));

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel8.setText("Role");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 298, 47, -1));

        roleField.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        roleField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USER", "ADMIN" }));
        roleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleFieldActionPerformed(evt);
            }
        });
        getContentPane().add(roleField, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 294, 192, -1));

        updateButton.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\changes.png")); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 120, -1));

        deleteButton.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\delete-user.png")); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 120, -1));

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel9.setText("Name :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 9, -1, -1));

        jLabel10.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel10.setText("Role :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 34, 37, -1));

        addButton.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\add-user.png")); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 120, -1));

        clearButton.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        clearButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Downloads\\broom.png")); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 120, -1));

        logoutButton.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        logoutButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\logout.png")); // NOI18N
        logoutButton.setText("LOG OUT");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, -1, 40));

        nextPageButton.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        nextPageButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\send.png")); // NOI18N
        nextPageButton.setText("STUDENT INFORMATION");
        nextPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPageButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nextPageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 220, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\BG_Statistics.png")); // NOI18N
        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleFieldActionPerformed

    private void scheduleRequestCountUpdate() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                updateRequestCount(); 
            }
        }, 0, 10000); 
    }

    private void updateRequestCount() {
        countRequestUser = userDAO.countUsersInRequestTable();
        userRequestCount.setText("Users request: " + countRequestUser);
    }
    
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        firstName = firstNameField.getText();
        lastName = lastNameField.getText();
        email = emailField.getText();
        password = passwordField.getText();
        roleUser = roleField.getSelectedItem().toString();
        
        if (lastName.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter Last Name.");
        } else if (email.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter Email.");
        } else if (password.equals("")) {
             JOptionPane.showMessageDialog(null, "Please enter Password.");
        } else {
            try {
                updateUsers();
                show_table();
            } catch (SQLException ex) {
                Logger.getLogger(userManagementForMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_updateButtonActionPerformed
    
    private void updateUsers() throws SQLException {
        Users user = new Users();
        user.setFirstName(firstNameField.getText());
        user.setLastName(lastNameField.getText());
        user.setEmail(emailField.getText());
        if (passwordField.getText().equals(passwordClick)){
            user.setPassword(passwordField.getText());
        } else {
            user.setPassword(Encode.toSHA1(passwordField.getText()));
        }
        user.setRoleUser(roleField.getSelectedItem().toString());
        if (lastName.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter Last Name.");
        } else if (email.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter Email.");
        } else if (password.equals("")) {
             JOptionPane.showMessageDialog(null, "Please enter Password.");
        } else {
            userDAO.updateUsers(user, oldEmail);
            oldEmail = emailField.getText();
        }
    }
    
    private void usersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTableMouseClicked
        int selectedRow = usersTable.getSelectedRow();
        if (selectedRow != -1) {
            String firstNameClick = getValueAt(selectedRow, 0);
            String lastNameClick = getValueAt(selectedRow, 1);
            String emailClick = getValueAt(selectedRow, 2);
            passwordClick = getValueAt(selectedRow, 3);
            String roleUserClick = getValueAt(selectedRow, 4);
            
            if (roleUserClick == null){
                roleUserClick = "USER";
            }
            
            firstNameField.setText(firstNameClick);
            lastNameField.setText(lastNameClick);
            emailField.setText(emailClick);
            passwordField.setText(passwordClick);
            roleField.setSelectedItem(roleUserClick);
            oldEmail = emailField.getText();
        }
    }//GEN-LAST:event_usersTableMouseClicked
    
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        roleField.setSelectedItem("USER");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        firstName = firstNameField.getText();
        lastName = lastNameField.getText();
        email = emailField.getText();
        password = passwordField.getText();
        roleUser = roleField.getSelectedItem().toString();
        
        if (lastName.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter Last Name.");
        } else if (email.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter Email.");
        } else if (password.equals("")) {
             JOptionPane.showMessageDialog(null, "Please enter Password.");
        }else if (userDAO.isEmailAlreadyExist(email)) {
            JOptionPane.showMessageDialog(this, "Email is already registered", "Try again", JOptionPane.ERROR_MESSAGE);
        } else {
            userDAO.addUserToDatabase(firstName, lastName, email, password);
            show_table();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.dispose();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedRow = usersTable.getSelectedRow();
       
        if (selectedRow != -1) {
           email = usersTable.getValueAt(selectedRow, 2).toString();
           int result = JOptionPane.showConfirmDialog(
                null, 
                "Do you want to continue deleting?",
                "Confirm",  
                JOptionPane.YES_NO_OPTION);  

            if (result == JOptionPane.YES_OPTION) {
                try {
                    userDAO.deleteFromTable("users", email);
                }catch (SQLException ex) {
                    Logger.getLogger(userManagementForMaster.class.getName()).log(Level.SEVERE, null, ex);
                }
                firstNameField.setText("");
                lastNameField.setText("");
                emailField.setText("");
                passwordField.setText("");
                roleField.setSelectedItem("USER");
                show_table();
            } else if (result == JOptionPane.NO_OPTION) {
    //            this.dispose();
            }
        } else {
           JOptionPane.showMessageDialog(this, "Please select a row for Delete.");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void nextPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPageButtonActionPerformed
        this.dispose();
        new InformationSystem(userNameLog, roleUserLog, server).setVisible(true);
    }//GEN-LAST:event_nextPageButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new requestProcess(server).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    private String getValueAt(int row, int column) {
        Object value = usersTable.getValueAt(row, column);
        return (value != null) ? value.toString() : null;
    }

    private void show_table(){
        
        List<Users> users;
        users = userDAO.getAllUsers();
        DefaultTableModel DFT = (DefaultTableModel) usersTable.getModel();
            
        DFT.setRowCount(0);

        for (Users user : users){
            Vector<Object> row = new Vector<>();
            row.add(user.getFirstName());
            row.add(user.getLastName());
            row.add(user.getEmail());
            row.add(user.getPassword());
            row.add(user.getRoleUser());
            DFT.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton nextPageButton;
    private javax.swing.JTextField passwordField;
    private javax.swing.JComboBox<String> roleField;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel userLoginLabel;
    private javax.swing.JLabel userRequestCount;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
