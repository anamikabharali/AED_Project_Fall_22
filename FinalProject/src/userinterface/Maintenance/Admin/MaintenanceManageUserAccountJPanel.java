/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.Maintenance.Admin;

import userinterface.Maintenance.Admin.*;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Employee.EmployeeDirectory;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import utility.Validate;

/**
 *
 * @author anamikabharali
 */
public class MaintenanceManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PoliceManageUserAccountJPanel
     */
    
    private JPanel container;
    private Enterprise enterprise;
    Network net;
    
    public MaintenanceManageUserAccountJPanel(JPanel container, Enterprise enterprise,Network net) {
        initComponents();
        
        this.enterprise = enterprise;
        this.container = container;
        this.net=net;
        
        popOrganizationComboBox();
        popData();
        
    }
    
    public void popOrganizationComboBox() {
        try {
            
            organizationJComboBox.removeAllItems();
            if (enterprise.getOrganizationDirectory() == null) {
                enterprise.setOrganizationDirectory(new OrganizationDirectory());
            }
            if (enterprise.getOrganizationDirectory().getOrganizationList().size() > 0) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    organizationJComboBox.addItem(organization);
                }
            } else {
                JOptionPane.showMessageDialog(null,"NO Organization is Available");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Sorry for convenience! Please try again later");
        }
    }
    
     public void populateEmployeeComboBox(Organization organization) {
        try {
            
            employeeJComboBox.removeAllItems();
            if (organization.getEmployeeDirectory() == null) {
                organization.setEmployeeDirectory(new EmployeeDirectory());
            }
            if (organization.getEmployeeDirectory().getEmployeeList().size() > 0) {
               
                for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
                    employeeJComboBox.addItem(employee);
                }

            } else {
                JOptionPane.showMessageDialog(null,"NO Employee is present for this Organization");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Sorry for convenience! Please try again later");
        }
    }
    
     private void populateRoleComboBox(Organization e) {
        try {
            
            roleJComboBox.removeAllItems();
            if (e.getSupportedRole() != null) {
               
                for (Role role : e.getSupportedRole()) {
                    roleJComboBox.addItem(role);
                }
            } else {
                JOptionPane.showMessageDialog(null,"NO Roles are Available in this organization");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Sorry for convenience! Please try again later");
        }
    }
    

    public void popData() {

          try {
            
            DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

            model.setRowCount(0);
            if (enterprise.getOrganizationDirectory() == null) {
                enterprise.setOrganizationDirectory(new OrganizationDirectory());
            }
            if (enterprise.getOrganizationDirectory().getOrganizationList().size() > 0) {
                
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if(organization.getUserAccountDirectory()== null){
                        organization.setUserAccountDirectory(new UserAccountDirectory());
                    }
                    for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                        Object row[] = new Object[2];
                        row[0] = ua;
                        row[1] = ua.getRole();
                        ((DefaultTableModel) userJTable.getModel()).addRow(row);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null,"NO Organization is Available");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Sorry for convenience! Please try again later");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        emailtxtfield = new javax.swing.JTextField();
        passwordJTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        employeeJComboBox = new javax.swing.JComboBox();
        backjButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        createUserJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        nameJTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(76, 89, 115));
        setToolTipText("");
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("POLICE USER ACCOUNT MANAGEMENT");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Role");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        jLabel2.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, -1));

        roleJComboBox.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        roleJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roleJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleJComboBoxActionPerformed(evt);
            }
        });
        add(roleJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 170, -1));

        userJTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 508, 138));

        jLabel6.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email id");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, -1, -1));

        jLabel3.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, -1, -1));

        emailtxtfield.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        emailtxtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtxtfieldActionPerformed(evt);
            }
        });
        add(emailtxtfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, 200, -1));

        passwordJTextField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        passwordJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordJTextFieldFocusLost(evt);
            }
        });
        add(passwordJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 200, -1));

        jLabel5.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Employee");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        employeeJComboBox.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        employeeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(employeeJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 170, -1));

        backjButton1.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });
        add(backjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 521, 112, -1));

        jLabel7.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Organization");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        createUserJButton.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        createUserJButton.setText("Create");
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });
        add(createUserJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 477, -1, -1));

        organizationJComboBox.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 170, -1));

        nameJTextField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 200, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("/Users/anamikabharali/Downloads/imageedit_5_4363260202.jpg")); // NOI18N
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 120));
    }// </editor-fold>//GEN-END:initComponents

    private void emailtxtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtxtfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtxtfieldActionPerformed

    private void passwordJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordJTextFieldFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_passwordJTextFieldFocusLost

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
        
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed

        String email = emailtxtfield.getText();
        String userName = nameJTextField.getText();
        String password = String.valueOf(passwordJTextField.getText());
        if (employeeJComboBox.getSelectedItem() != null) {
            if (!((userName.equals("")))) {
                if (!(password.equals(""))) {
                    if(!email.equals("")){
                        if (EcoSystem.checkIfUsernameIsUnique(userName,net)) {

                            Organization organization = (Organization) organizationJComboBox.getSelectedItem();
                            Employee employee = (Employee) employeeJComboBox.getSelectedItem();
                            Role role = (Role) roleJComboBox.getSelectedItem();
                            if (!Validate.validatePassword(password)) {
                                JOptionPane.showMessageDialog(null, "Password should Contain \n"
                                    + "       - At least one digit\n"
                                    + "       - At least one lower case letter\n"
                                    + "       - At least one upper case letter\n"
                                    + "       - At least one special character(!@#$%^&+=~|?)\n"
                                    + "       - no whitespace allowed in the entire string\n"
                                    + "       - at least eight characters");
                                passwordJTextField.setText("");
                                return;
                            }
                            if(!Validate.validateEmail(email))
                            {
                                JOptionPane.showMessageDialog(null,"Enter valid email id ");

                            }

                            organization.getUserAccountDirectory().createUserAccount(userName, password,email ,employee, role);
                            JOptionPane.showMessageDialog(null, "Account created succesfull");
                            nameJTextField.setText("");
                            passwordJTextField.setText("");
                            emailtxtfield.setText("");
                            popData();
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter unique username", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Enter value for email", "Warning", JOptionPane.WARNING_MESSAGE);
                    }}
                    else {
                        JOptionPane.showMessageDialog(null, "Enter value for password", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Enter value for username", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No Employee available", "Warning", JOptionPane.WARNING_MESSAGE);
            }

    }//GEN-LAST:event_createUserJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void roleJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleJComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JTextField emailtxtfield;
    private javax.swing.JComboBox employeeJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JTable userJTable;
    // End of variables declaration//GEN-END:variables
}
