package com.mycompany.ui;

import com.mycompany.dao.UserDAO;
import com.mycompany.model.Users;
import com.mycompany.network.Server;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class requestProcess extends javax.swing.JFrame {
    
    private UserDAO userDAO;
    private Server server;

    public requestProcess(Server server) {
        userDAO = new UserDAO();
        this.server = server;
        initComponents();
        show_table();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableRequest = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        header = new javax.swing.JLabel();
        brg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Requests Processing");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "First name", "Last Name", "Email", "Role", "Accept"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableRequest);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 600, 290));

        jButton1.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        jButton1.setText("COMFIRM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 130, -1));

        header.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        header.setText("REQUESTS FROM USERS");
        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 580, -1));

        brg.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\BG_Statistics.png")); // NOI18N
        getContentPane().add(brg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableRequest.getModel();
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Boolean accepted = (Boolean) model.getValueAt(i, 4);
            if (accepted) {
                String firstName = (String) model.getValueAt(i, 0);
                String lastName = (String) model.getValueAt(i, 1);
                String email = (String) model.getValueAt(i, 2);
                String role = (String) model.getValueAt(i, 3);

                userDAO.updateRoleInDatabase(email, "ADMIN");
                userDAO.deleteUserRequest(email);
                server.broadcastMessage("Updated to ADMIN successfully, please logout and login again!");

                model.removeRow(i);
                rowCount--;
                i--;
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
  
    private void show_table() {
        List<Users> users;
        users = userDAO.getAllUserRequest();
        DefaultTableModel DFT = (DefaultTableModel) tableRequest.getModel();
            
        DFT.setRowCount(0);

        for (Users user : users){
            Vector<Object> row = new Vector<>();
            row.add(user.getFirstName());
            row.add(user.getLastName());
            row.add(user.getEmail());
            row.add(user.getRoleUser());
            DFT.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brg;
    private javax.swing.JLabel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRequest;
    // End of variables declaration//GEN-END:variables
}
