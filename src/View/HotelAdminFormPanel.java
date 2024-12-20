/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import javax.swing.JPanel;

import Model.Room;
import Model.User;
import Utility.DatabaseConnector;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danie
 */
public class HotelAdminFormPanel extends javax.swing.JPanel {
    JPanel bottomJPanel;
    private ArrayList<User> users;
    private User selectedUser;
    private User currUser;
    
    /**
     * Creates new form LoginFormPanel
     */
    public HotelAdminFormPanel(JPanel bottomJPanel) {
        this.bottomJPanel = bottomJPanel;
        initComponents();
        populateAdminTable();
    }
    
    public void populateAdminTable() { 
        this.users = DatabaseConnector.get_all_Agency_stuff();
        
        DefaultTableModel model = (DefaultTableModel) this.HotelAdminStaffTable.getModel();
        model.setRowCount(0);
        for(User r : this.users) { 
            Object [] rows = new Object[7];
            rows[0] = r.get_user_id();
            rows[1] = r.get_username();
            rows[2] = r.get_phone_num();
            rows[3] = r.get_role();
            model.addRow(rows);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HotelAdminStaffTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        useridTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        phoneNumberTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rowComboBox = new javax.swing.JComboBox<>();
        userNameTextField = new javax.swing.JTextField();

        jButton4.setText("jButton4");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel3.setText("Action");

        HotelAdminStaffTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "USER_ID", "NAME", "PHONE_NUMBER", "ROLE"
            }
        ));
        jScrollPane1.setViewportView(HotelAdminStaffTable);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel4.setText("Hotel Admin");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel5.setText("Staff");

        jLabel10.setText("UserID");

        jLabel11.setText("PassWord");

        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("PhoneNumber");

        jButton1.setText("Add Staff");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update Staff");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Edit Staff");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Remove Staff");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel12.setText("Username");

        jButton6.setText("Refresh");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Deselect All");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel2.setText("Role");

        rowComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "HotelStaff", "AgencyStaff", "AgencyAdmin", "HotelAdmin", " " }));
        rowComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rowComboBoxActionPerformed(evt);
            }
        });

        userNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(179, 179, 179)
                        .addComponent(jButton6))
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(105, 105, 105)
                        .addComponent(jButton7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(39, 39, 39)
                                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(57, 57, 57)
                                    .addComponent(useridTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addGap(39, 39, 39)
                                            .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel2))
                                            .addGap(18, 18, 18)
                                            .addComponent(phoneNumberTextField)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(89, 89, 89)
                                        .addComponent(rowComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jButton7))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(useridTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(phoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(rowComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton1)
                            .addComponent(jButton5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        User u = new User();
        u.set_username(this.userNameTextField.getText());
        u.set_password(this.passwordTextField.getText());
        u.set_phone_num(this.phoneNumberTextField.getText());
        u.set_role(this.rowComboBox.getSelectedItem().toString());
        DatabaseConnector.add_agency_staff(u);
        populateAdminTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = this.HotelAdminStaffTable.getSelectedRow();
        this.selectedUser = this.users.get(selectedRowIndex);
        this.currUser = this.selectedUser;
        
        this.useridTextField.setText(String.valueOf(this.currUser.get_user_id()));
        this.userNameTextField.setText(this.currUser.get_username());
        this.userNameTextField.setEnabled(false);
        this.passwordTextField.setText(this.currUser.get_password());
        this.phoneNumberTextField.setText(this.currUser.get_phone_num());
        String role = this.currUser.get_role(); 
        this.rowComboBox.setSelectedItem(role);
        
        this.useridTextField.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = this.HotelAdminStaffTable.getSelectedRow();
        this.selectedUser = this.users.get(selectedRowIndex);
        this.currUser = this.selectedUser;
        
        this.currUser.set_password(this.passwordTextField.getText());
        this.currUser.set_phone_num(this.phoneNumberTextField.getText());
        this.currUser.set_role(this.rowComboBox.getSelectedItem().toString());
        DatabaseConnector.update_agency_staff(this.currUser);
        populateAdminTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = this.HotelAdminStaffTable.getSelectedRow();
        this.selectedUser = this.users.get(selectedRowIndex);
        this.currUser = this.selectedUser;
        DatabaseConnector.remove_agency_staff(this.currUser);
        populateAdminTable();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        populateAdminTable();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.useridTextField.setText("");
        this.userNameTextField.setText("");
        this.passwordTextField.setText("");
        this.userNameTextField.setText("");
        this.phoneNumberTextField.setText("");
        this.userNameTextField.setEnabled(true);
        this.passwordTextField.setEnabled(true);
        this.useridTextField.setEnabled(true);
        this.phoneNumberTextField.setEnabled(true);
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void rowComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rowComboBoxActionPerformed

    private void userNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable HotelAdminStaffTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JComboBox<String> rowComboBox;
    private javax.swing.JTextField userNameTextField;
    private javax.swing.JTextField useridTextField;
    // End of variables declaration//GEN-END:variables
}
