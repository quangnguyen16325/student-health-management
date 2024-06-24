package com.mycompany.ui;


import com.mycompany.dao.StudentDAO;
import com.mycompany.model.Student;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quang
 */
public class InformationSystemForUser extends javax.swing.JFrame {

    private String userName, roleUser;
    private StudentDAO studentDAO;
    
    public InformationSystemForUser(String userName, String role) {
        initComponents();
        studentDAO = new StudentDAO();
        show_table();
        this.userName = userName;
        this.roleUser = role;
        userLoginLabel.setText(userName);
        roleLabel.setText(roleUser);
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateCurrentTimeLabel(currentTimeLabel);
            }
        }, 0, 1000);
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
        cancelButton = new javax.swing.JButton();
        currentTimeLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        userLoginLabel = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        detailsButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 90, 830, 367));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("STUDENT INFORMATION SYSTEM");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 12, -1, -1));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel2.setText("Student Code:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 49, -1, -1));
        getContentPane().add(searchStudentCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 48, 150, -1));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel4.setText("Full Name:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 49, -1, -1));
        getContentPane().add(searchFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 48, 200, -1));

        findButton.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        findButton.setText("Find");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });
        getContentPane().add(findButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 47, 90, -1));

        cancelButton.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(869, 47, 90, -1));

        currentTimeLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        currentTimeLabel.setText("CurrentTime");
        getContentPane().add(currentTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 250, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\user.png")); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 150, 110));

        userLoginLabel.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        userLoginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLoginLabel.setText("...");
        jPanel1.add(userLoginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 113, 138, -1));

        roleLabel.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        roleLabel.setForeground(new java.awt.Color(255, 51, 0));
        roleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roleLabel.setText("...");
        jPanel1.add(roleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 144, 138, -1));

        logOutButton.setBackground(new java.awt.Color(204, 204, 204));
        logOutButton.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        logOutButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\logout.png")); // NOI18N
        logOutButton.setText("Log out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 433, 138, 35));

        detailsButton.setBackground(new java.awt.Color(255, 255, 0));
        detailsButton.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        detailsButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\resume.png")); // NOI18N
        detailsButton.setText("SEE DETAILS");
        detailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(detailsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 213, 137, 35));

        updateButton.setBackground(new java.awt.Color(51, 204, 255));
        updateButton.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\graph.png")); // NOI18N
        updateButton.setText("STATISTICS");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel1.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 296, 137, 35));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\BG_Statistics.png")); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 22)); // NOI18N
        jLabel8.setText("Vietnam - Korea University of Information and Communication Technology");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 463, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\quang\\Documents\\NetBeansProjects\\DA_QLSKSV\\src\\main\\java\\images\\BG_Statistics.png")); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void detailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsButtonActionPerformed
       int selectedRow = studentInfoTable.getSelectedRow();
       
       if (selectedRow != -1) {
           String studentCode = studentInfoTable.getValueAt(selectedRow, 0).toString();
           new DetailsStudentForUser(studentCode).setVisible(true);
       } else {
           JOptionPane.showMessageDialog(this, "Please select a row for See Details.");
       }
    }//GEN-LAST:event_detailsButtonActionPerformed

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        show_table();
    }//GEN-LAST:event_findButtonActionPerformed

    private void studentInfoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentInfoTableMouseClicked

    }//GEN-LAST:event_studentInfoTableMouseClicked

    private void updateCurrentTimeLabel(JLabel currentTimeLabel) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentTime = timeFormat.format(new Date());
        currentTimeLabel.setText("Current Time: " + currentTime);
    }
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        searchStudentCode.setText("");
        searchFullName.setText("");
        show_table();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        dispose();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        new statisticsForm().setVisible(true);
    }//GEN-LAST:event_updateButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel currentTimeLabel;
    private javax.swing.JButton detailsButton;
    private javax.swing.JButton findButton;
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
    private javax.swing.JLabel roleLabel;
    private javax.swing.JTextField searchFullName;
    private javax.swing.JTextField searchStudentCode;
    private javax.swing.JTable studentInfoTable;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel userLoginLabel;
    // End of variables declaration//GEN-END:variables
}
