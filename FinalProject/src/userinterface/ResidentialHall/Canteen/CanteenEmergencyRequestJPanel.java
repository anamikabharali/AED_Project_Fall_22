/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.ResidentialHall.Canteen;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.FelonyOrganization;
import Business.Organization.CanteenOrganization;
import Business.Organization.SupervisorOrganization;
import Business.Organization.MisconductOrganization;
import Business.Organization.Organization;
import Business.Organization.TheftOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EmergencyRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author anamikabharali
 */

public class CanteenEmergencyRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CanteenEmergencyRequestJPanel
     */
    
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount; 
    private Network network;
    public CanteenEmergencyRequestJPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise,Network network) {
        initComponents();
       this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.network=network;
     populateComboBox();
    }

    EmergencyRequest  erequest = new EmergencyRequest();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        locationfiield = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        combo = new javax.swing.JComboBox();
        sendemergency = new javax.swing.JButton();
        locationlbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(76, 89, 115));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        locationfiield.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        add(locationfiield, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 240, -1));

        backJButton.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        backJButton.setText("<< Back ");
        backJButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 120, -1));

        combo.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 290, -1));

        sendemergency.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        sendemergency.setText("Send Emergency");
        sendemergency.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sendemergency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendemergencyActionPerformed(evt);
            }
        });
        add(sendemergency, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 150, 30));

        locationlbl.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        locationlbl.setForeground(new java.awt.Color(255, 255, 255));
        locationlbl.setText("Location :");
        add(locationlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, -1));

        jLabel1.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Emergency Type :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));

        jLabel9.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CANTEEN EMERGENCY REQUESTS");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("/Users/anamikabharali/Downloads/imageedit_13_4677416373.jpg")); // NOI18N
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel3.setPreferredSize(new java.awt.Dimension(790, 550));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, -30, 880, 260));
    }// </editor-fold>//GEN-END:initComponents

    private void populateComboBox() {
        
         combo.removeAllItems();
        combo.addItem(Organization.Type.Theft);
        combo.addItem(Organization.Type.Felony);
        combo.addItem(Organization.Type.Misconduct);
       
    }
    
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CanteenWorkAreaJPanel dwajp = (CanteenWorkAreaJPanel) component;
        dwajp.populateRequestTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_backJButtonActionPerformed

    private void sendemergencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendemergencyActionPerformed
        // TODO add your handling code here:

        String location = locationfiield.getText();
        erequest.setLocation(location);
        erequest.setEmergencytype((Organization.Type) combo.getSelectedItem());
        erequest.setEmail(userAccount.getEmail());
         Organization org = null;
         Organization.Type sel = (Organization.Type) combo.getSelectedItem();
        if(sel.equals(Organization.Type.Theft))
        {   
         for (Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList())
            {
                  for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList())
                  {
            if (organization instanceof TheftOrganization){
                org = organization;
                break;
            } 
        }}
        if (org!=null){
            org.getStatusQueue().getStatusRequestList().add(erequest);
            userAccount.getStatusQueue().getStatusRequestList().add(erequest);
        }
        }
          else if(sel.equals(Organization.Type.Felony))
        {
        
         for (Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList())
            {
                  for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList())
                  {
            if (organization instanceof FelonyOrganization){
                org = organization;
                break;
            } 
                  }
        }
        if (org!=null){
            org.getStatusQueue().getStatusRequestList().add(erequest);
            userAccount.getStatusQueue().getStatusRequestList().add(erequest);
        }
        }
        
          else if(sel.equals(Organization.Type.Misconduct))
        {
        
        for (Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList())
            {
                  for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList())
                  {
            if (organization instanceof MisconductOrganization){
                org = organization;
                break;
            } 
                  }
        }
        if (org!=null){
            org.getStatusQueue().getStatusRequestList().add(erequest);
            userAccount.getStatusQueue().getStatusRequestList().add(erequest);
        }
        }
        
         JOptionPane.showMessageDialog(null,"Your emergency request has been sent! An officer will notify you shortly");
        
    }//GEN-LAST:event_sendemergencyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField locationfiield;
    private javax.swing.JLabel locationlbl;
    private javax.swing.JButton sendemergency;
    // End of variables declaration//GEN-END:variables
}
