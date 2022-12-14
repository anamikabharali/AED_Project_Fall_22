/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ResidentialHall.AdminRole;

import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author srivaishnaviaekkati
 */
public class ResidentialHallManageOrganizationJPanel extends javax.swing.JPanel {

    private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ResidentialHallManageOrganizationJPanel(JPanel userProcessContainer,OrganizationDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        
        populateTable();
        populateCombo();
    }
    
    private void populateCombo(){
        organizationcbox.removeAllItems();         
        organizationcbox.addItem(Type.Tenant);
        organizationcbox.addItem(Type.Supervisor);
      
    }

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) organizationtbl.getModel();
        
        model.setRowCount(0);
        
        for (Organization organization : directory.getOrganizationList()){
            Object[] row = new Object[1];
         
            row[0] = organization.getName();
            
            model.addRow(row);
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
        organizationtbl = new javax.swing.JTable();
        addbtn = new javax.swing.JButton();
        organizationcbox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        backbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(76, 89, 115));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));
        setLayout(null);

        organizationtbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        organizationtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationtbl);
        if (organizationtbl.getColumnModel().getColumnCount() > 0) {
            organizationtbl.getColumnModel().getColumn(0).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 180, 660, 150);

        addbtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        addbtn.setText("Add Organization");
        addbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });
        add(addbtn);
        addbtn.setBounds(424, 450, 140, 22);

        organizationcbox.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        organizationcbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationcbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationcboxActionPerformed(evt);
            }
        });
        add(organizationcbox);
        organizationcbox.setBounds(340, 360, 220, 24);

        jLabel1.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Organization Type ");
        add(jLabel1);
        jLabel1.setBounds(178, 360, 130, 18);

        backbtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        backbtn.setText("<< Back");
        backbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        add(backbtn);
        backbtn.setBounds(140, 450, 90, 22);

        jLabel2.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Residential Hall Manage Organization");
        add(jLabel2);
        jLabel2.setBounds(160, 80, 410, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
         
        Type type = (Type) organizationcbox.getSelectedItem();
       
        directory.createOrganization(type);
        JOptionPane.showMessageDialog(null,"Organization added");
       
        
        
            
        populateTable();
    }//GEN-LAST:event_addbtnActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backbtnActionPerformed

    private void organizationcboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationcboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationcboxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JButton backbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox organizationcbox;
    private javax.swing.JTable organizationtbl;
    // End of variables declaration//GEN-END:variables
}
