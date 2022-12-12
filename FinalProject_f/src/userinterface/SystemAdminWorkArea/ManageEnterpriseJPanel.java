/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author srivaishnaviaekkati
 */
public class ManageEnterpriseJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;

    /**
     * Creates new form ManageEnterpriseJPanel
     */
    public ManageEnterpriseJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;

        populateTable();
        populateComboBox();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) enterpriseJTable.getModel();

        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                Object[] row = new Object[3];
                row[0] = enterprise;
                row[1] = network.getName();
                row[2] = enterprise.getEnterpriseType().getValue();

                model.addRow(row);
            }
        }
    }

    private void populateComboBox() {
        networkJCB.removeAllItems();
        enterpriseTypeJCB.removeAllItems();

        for (Network network : system.getNetworkList()) {
            networkJCB.addItem(network);
        }

        for (Enterprise.EnterpriseType type : Enterprise.EnterpriseType.values()) {
            enterpriseTypeJCB.addItem(type);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        enterpriseJTable = new javax.swing.JTable();
        jLNetwork = new javax.swing.JLabel();
        networkJCB = new javax.swing.JComboBox();
        jLName = new javax.swing.JLabel();
        nameJTF = new javax.swing.JTextField();
        jLEntType = new javax.swing.JLabel();
        enterpriseTypeJCB = new javax.swing.JComboBox();
        submitJB = new javax.swing.JButton();
        backJB = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jLMngEnterprise = new javax.swing.JLabel();

        setBackground(new java.awt.Color(76, 89, 115));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));
        setLayout(null);

        enterpriseJTable.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        enterpriseJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Enterprise Name", "Network", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(enterpriseJTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 120, 660, 95);

        jLNetwork.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLNetwork.setForeground(new java.awt.Color(255, 255, 255));
        jLNetwork.setText("Network");
        add(jLNetwork);
        jLNetwork.setBounds(232, 310, 60, 18);

        networkJCB.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        networkJCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(networkJCB);
        networkJCB.setBounds(330, 310, 136, 24);

        jLName.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLName.setForeground(new java.awt.Color(255, 255, 255));
        jLName.setText("Name");
        add(jLName);
        jLName.setBounds(245, 410, 40, 18);

        nameJTF.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        add(nameJTF);
        nameJTF.setBounds(330, 410, 136, 24);

        jLEntType.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLEntType.setForeground(new java.awt.Color(255, 255, 255));
        jLEntType.setText("Enterprise Type");
        add(jLEntType);
        jLEntType.setBounds(187, 360, 100, 18);

        enterpriseTypeJCB.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        enterpriseTypeJCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        enterpriseTypeJCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseTypeJCBActionPerformed(evt);
            }
        });
        add(enterpriseTypeJCB);
        enterpriseTypeJCB.setBounds(330, 360, 136, 24);

        submitJB.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        submitJB.setText("Add");
        submitJB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submitJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJBActionPerformed(evt);
            }
        });
        add(submitJB);
        submitJB.setBounds(560, 510, 90, 22);

        backJB.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        backJB.setText("<< Back");
        backJB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJBActionPerformed(evt);
            }
        });
        add(backJB);
        backJB.setBounds(70, 510, 100, 22);

        btndelete.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        btndelete.setText("Delete Enterprise");
        btndelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        add(btndelete);
        btndelete.setBounds(478, 240, 150, 22);

        jLMngEnterprise.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLMngEnterprise.setForeground(new java.awt.Color(255, 255, 255));
        jLMngEnterprise.setText("Manage Enterprise ");
        add(jLMngEnterprise);
        jLMngEnterprise.setBounds(255, 52, 200, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void submitJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJBActionPerformed
       if (!nameJTF.getText().equals("")) {
        Network network = (Network) networkJCB.getSelectedItem();
        Enterprise.EnterpriseType type = (Enterprise.EnterpriseType) enterpriseTypeJCB.getSelectedItem();

        if (network == null || type == null) {
            JOptionPane.showMessageDialog(null, "Invalid Input!");
            return;
        }

        String name = nameJTF.getText();
       
      
           
        Enterprise enterprise = network.getEnterpriseDirectory().createAndAddEnterprise(name, type);
        JOptionPane.showMessageDialog(null, "Enterprise created successfully");
        populateTable();
        nameJTF.setText("");
       }
       else {
            JOptionPane.showMessageDialog(null, "Enter a name for Enterprise", "Warning", JOptionPane.WARNING_MESSAGE);
        }
       
       

    }//GEN-LAST:event_submitJBActionPerformed

    private void backJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJBActionPerformed
        userProcessContainer.remove(this);
         Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        sysAdminwjp.populateTree();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJBActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        
        
           int selectedRow = enterpriseJTable.getSelectedRow();
        if (selectedRow >= 0) {

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to delete the details", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {

                Enterprise p = (Enterprise) enterpriseJTable.getValueAt(selectedRow, 0);

                for (Network network : system.getNetworkList()) {
                    for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {

                        if (p == enterprise) {
                            network.getEnterpriseDirectory().getEnterpriseList().remove(p);
                            
                            break;
                        }

                    }
                }

                JOptionPane.showMessageDialog(null, "You have successfully deleted the account");
                populateTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Row from table ", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void enterpriseTypeJCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseTypeJCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterpriseTypeJCBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJB;
    private javax.swing.JButton btndelete;
    private javax.swing.JTable enterpriseJTable;
    private javax.swing.JComboBox enterpriseTypeJCB;
    private javax.swing.JLabel jLEntType;
    private javax.swing.JLabel jLMngEnterprise;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLNetwork;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTF;
    private javax.swing.JComboBox networkJCB;
    private javax.swing.JButton submitJB;
    // End of variables declaration//GEN-END:variables
}
