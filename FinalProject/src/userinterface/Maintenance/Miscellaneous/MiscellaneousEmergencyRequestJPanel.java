/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Maintenance.Miscellaneous;

import userinterface.Maintenance.Miscellaneous.*;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.FelonyOrganization;
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
 * @author srivaishnaviaekkati
 */
public class MiscellaneousEmergencyRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DinerEmergencyRequestJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount; 
    private Network network;
    public MiscellaneousEmergencyRequestJPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise,Network network) {
        initComponents();
        this.network=network;
       this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
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

        jLabel1 = new javax.swing.JLabel();
        locationlbl = new javax.swing.JLabel();
        locationtxtfield = new javax.swing.JTextField();
        sendemergecy = new javax.swing.JButton();
        combo = new javax.swing.JComboBox();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Emergency Type");

        locationlbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        locationlbl.setText("Location");

        locationtxtfield.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        sendemergecy.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        sendemergecy.setText("Send Emergency");
        sendemergecy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendemergecyActionPerformed(evt);
            }
        });

        combo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        backJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(locationlbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(locationtxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(213, 213, 213))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(backJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(sendemergecy)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(locationlbl)
                        .addGap(131, 131, 131))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(locationtxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(sendemergecy)
                .addGap(116, 116, 116)
                .addComponent(backJButton)
                .addGap(129, 129, 129))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendemergecyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendemergecyActionPerformed
        // TODO add your handling code here:
        
         String location = locationtxtfield.getText();
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
                  }
        }
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
            } }
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
        
    }//GEN-LAST:event_sendemergecyActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        MiscellaneousWorkAreaJPanel fwajp = (MiscellaneousWorkAreaJPanel) component;
        
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel locationlbl;
    private javax.swing.JTextField locationtxtfield;
    private javax.swing.JButton sendemergecy;
    // End of variables declaration//GEN-END:variables

    private void populateComboBox() {
         combo.removeAllItems();
        combo.addItem(Organization.Type.Theft);
        combo.addItem(Organization.Type.Felony);
        combo.addItem(Organization.Type.Misconduct);
    }
}
