/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ResidentialHall.AdminRole;

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
 * @author srivaishnaviaekkati
 */
public class ResidentialHallManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ResidentialHallManageUserAccountJPanel
     */
    private JPanel container;
    private Enterprise enterprise;
Network net;
    public ResidentialHallManageUserAccountJPanel(JPanel container, Enterprise enterprise,Network net) {
        initComponents();
        this.enterprise = enterprise;
        this.container = container;
        this.net=net;
        popOrganizationComboBox();
       // employeeJComboBox.removeAllItems();
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
    
    public void populateEmployeeComboBox(Organization organization){
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
    
    private void populateRoleComboBox(Organization organization){
       try {
            
            roleJComboBox.removeAllItems();
            if (organization.getSupportedRole() != null) {
                
                for (Role role : organization.getSupportedRole()) {
                    roleJComboBox.addItem(role);
                }
            } else {
                  JOptionPane.showMessageDialog(null,"No Organization Available");
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

        createUserJButton = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        passwordJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        employeeJComboBox = new javax.swing.JComboBox();
        backjButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        emailtxtfield = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 153, 153));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));

        createUserJButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        createUserJButton.setText("Create");
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });

        nameJTextField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("User Name");

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
        if (userJTable.getColumnModel().getColumnCount() > 0) {
            userJTable.getColumnModel().getColumn(0).setResizable(false);
            userJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Password");

        passwordJTextField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        passwordJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordJTextFieldFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Employee");

        employeeJComboBox.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        employeeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        backjButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Organization");

        organizationJComboBox.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Role");

        roleJComboBox.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        roleJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Email ID");

        emailtxtfield.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        emailtxtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtxtfieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 204, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(289, 289, 289))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(backjButton1)
                                .addGap(225, 225, 225))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(84, 84, 84)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailtxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(createUserJButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(emailtxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(34, 34, 34)
                        .addComponent(createUserJButton)
                        .addGap(0, 67, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
         
            String email = emailtxtfield.getText();
            String userName = nameJTextField.getText();
            String password = passwordJTextField.getText();
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
                                 emailtxtfield.setText("");
                                return;
                            
                            }
                           

                            organization.getUserAccountDirectory().createUserAccount(userName, password,email ,employee, role);
                            JOptionPane.showMessageDialog(null, "Account created succesfull");
                            nameJTextField.setText("");
                            passwordJTextField.setText("");
                            popData();
                       } else {
                            JOptionPane.showMessageDialog(null, "Please enter unique username", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                        else{
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

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void passwordJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordJTextFieldFocusLost
        // TODO add your handling code here:
       
        
        
    }//GEN-LAST:event_passwordJTextFieldFocusLost

    private void emailtxtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtxtfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtxtfieldActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JTable userJTable;
    // End of variables declaration//GEN-END:variables
}
