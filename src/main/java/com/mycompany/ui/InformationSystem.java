package com.mycompany.ui;


import com.mycompany.dao.StudentDAO;
import com.mycompany.model.Student;
import com.mycompany.network.Server;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author quang
 */
public class InformationSystem extends javax.swing.JFrame {
    
    private String userName, roleUser;
    private StudentDAO studentDAO;
    private Server server;
    
    public InformationSystem(String userName, String role, Server server) {
        initComponents();
        studentDAO = new StudentDAO();
        show_table();
        this.userName = userName;
        this.roleUser = role;
        userLoginLabel.setText(userName);
        roleLabel.setText(roleUser);
        studentInfoTable.getTableHeader().setDefaultRenderer(new HeaderRenderer(studentInfoTable));

        if (role.equalsIgnoreCase("MASTER")) {
            enableMasterFeatures();
        } else {
            disableNonMasterFeatures();
        }

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateCurrentTimeLabel(currentTimeLabel);
            }
        }, 0, 1000);
    }
    
    private void enableMasterFeatures() {
        previousPageButton.setEnabled(true);
    }
    
    private void disableNonMasterFeatures() {
        previousPageButton.setEnabled(false);
        previousPageButton.setVisible(false);
    }
    
    private void show_table(){
        String searchStudentCodeText = searchStudentCode.getText().trim();
        String searchFullNameText = searchFullName.getText().trim();

        List<Student> students;
        if (!searchStudentCodeText.isEmpty() || !searchFullNameText.isEmpty()) {
            students = studentDAO.searchStudents(searchStudentCodeText, searchFullNameText);
        } else {
            students = studentDAO.getAllStudents();
        }

        DefaultTableModel DFT = (DefaultTableModel) studentInfoTable.getModel();
        DFT.setRowCount(0);

        for (Student student : students) {
            Vector<Object> row = new Vector<>();
            row.add(student.getStudentCode());
            row.add(student.getFullName());
            row.add(student.getBirth());
            row.add(student.getGender());
            row.add(student.getCCCD());
            DFT.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        studentInfoTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchStudentCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        searchFullName = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();
        currentTimeLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        userLoginLabel = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        detailsButton = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        statisticsButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        previousPageButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Information System");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentInfoTable.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        studentInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Code", "Full Name", "Birth", "Gender", "CCCD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentInfoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentInfoTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentInfoTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 93, 851, 367));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("STUDENT INFORMATION SYSTEM");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 15, -1, -1));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel2.setText("Student Code:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 58, -1, -1));
        getContentPane().add(searchStudentCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 57, 150, -1));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel4.setText("Full Name:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 58, -1, -1));
        getContentPane().add(searchFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(557, 57, 200, -1));

        findButton.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        findButton.setText("Find");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });
        getContentPane().add(findButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(786, 56, 90, -1));

        currentTimeLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        currentTimeLabel.setText("CurrentTime");
        getContentPane().add(currentTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 250, -1));

        cancelButton.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(894, 56, 90, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\user.png")); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 100));

        userLoginLabel.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        userLoginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLoginLabel.setText("...");
        jPanel1.add(userLoginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 160, -1));

        roleLabel.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        roleLabel.setForeground(new java.awt.Color(255, 65, 8));
        roleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roleLabel.setText("...");
        jPanel1.add(roleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 160, -1));

        detailsButton.setBackground(new java.awt.Color(255, 255, 0));
        detailsButton.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        detailsButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\resume.png")); // NOI18N
        detailsButton.setText("SEE DETAILS");
        detailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(detailsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 169, -1, 35));

        insertButton.setBackground(new java.awt.Color(0, 255, 51));
        insertButton.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        insertButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\icons8-student-registration-30.png")); // NOI18N
        insertButton.setText("ADD");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });
        jPanel1.add(insertButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 222, 142, 35));

        deleteButton.setBackground(new java.awt.Color(255, 51, 51));
        deleteButton.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\social-media.png")); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.setBorder(null);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 275, 142, 35));

        statisticsButton.setBackground(new java.awt.Color(51, 204, 255));
        statisticsButton.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        statisticsButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\graph.png")); // NOI18N
        statisticsButton.setText("STATISTICS");
        statisticsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(statisticsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 328, 142, 34));

        logOutButton.setBackground(new java.awt.Color(204, 204, 204));
        logOutButton.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        logOutButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\logout.png")); // NOI18N
        logOutButton.setText("Log out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 455, 142, 35));

        refreshButton.setBackground(new java.awt.Color(204, 255, 255));
        refreshButton.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\refresh-page-option.png")); // NOI18N
        refreshButton.setText("REFRESH");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        jPanel1.add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 380, 142, 35));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\BG_Statistics.png")); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 510));

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 22)); // NOI18N
        jLabel8.setText("Vietnam - Korea University of Information and Communication Technology");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 466, -1, -1));

        previousPageButton.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        previousPageButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\previous.png")); // NOI18N
        previousPageButton.setText("MANAGEMENT USERS");
        previousPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousPageButtonActionPerformed(evt);
            }
        });
        getContentPane().add(previousPageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 180, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\BG_Statistics.png")); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        new AddStudent().setVisible(true);
    }//GEN-LAST:event_insertButtonActionPerformed
   
    private void detailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsButtonActionPerformed
       int selectedRow = studentInfoTable.getSelectedRow();
       
       if (selectedRow != -1) {
           String studentCode = studentInfoTable.getValueAt(selectedRow, 0).toString();
           new DetailsStudent(studentCode).setVisible(true);
           System.out.println(studentCode);
       } else {
           JOptionPane.showMessageDialog(this, "Please select a row for See Details.");
       }
       
    }//GEN-LAST:event_detailsButtonActionPerformed

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        show_table();
    }//GEN-LAST:event_findButtonActionPerformed

    private void studentInfoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentInfoTableMouseClicked
    
    }//GEN-LAST:event_studentInfoTableMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        searchStudentCode.setText("");
        searchFullName.setText("");
        show_table();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        dispose();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        searchStudentCode.setText("");
        searchFullName.setText("");
        show_table();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed

        int selectedRow = studentInfoTable.getSelectedRow();
        if (selectedRow != -1) {
            String studentCode = studentInfoTable.getValueAt(selectedRow, 0).toString();
            int result = JOptionPane.showConfirmDialog(null, "Do you want to continue deleting?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                boolean success = studentDAO.deleteStudent(studentCode);
                if (success) {
                    JOptionPane.showMessageDialog(this, "Delete Successfully.");
                    show_table();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete student.");
                }
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void previousPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousPageButtonActionPerformed
        this.dispose();
        new userManagementForMaster(userName, roleUser, server).setVisible(true);
    }//GEN-LAST:event_previousPageButtonActionPerformed

    private void statisticsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticsButtonActionPerformed
        new statisticsForm().setVisible(true);
    }//GEN-LAST:event_statisticsButtonActionPerformed
  
    private void updateCurrentTimeLabel(JLabel currentTimeLabel) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentTime = timeFormat.format(new Date());
        currentTimeLabel.setText("Current Time: " + currentTime);
    }
    
    public class HeaderRenderer implements TableCellRenderer {
    DefaultTableCellRenderer renderer;

    public HeaderRenderer(JTable table) {
        renderer = (DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER); // Căn giữa tiêu đề
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel header = (JLabel) renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        header.setBackground(Color.BLUE); // Thay đổi màu nền của tiêu đề
        return header;
    }
    
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel currentTimeLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton detailsButton;
    private javax.swing.JButton findButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton previousPageButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JTextField searchFullName;
    private javax.swing.JTextField searchStudentCode;
    private javax.swing.JButton statisticsButton;
    private javax.swing.JTable studentInfoTable;
    private javax.swing.JLabel userLoginLabel;
    // End of variables declaration//GEN-END:variables
}
