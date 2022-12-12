/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ResidentialHall.Supervisor;

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
public class SupervisorEmergencyRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DinerEmergencyRequestJPanel
     */
    public String message1 = null;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount; 
    private Network network;
    public SupervisorEmergencyRequestJPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise,Network network) {
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
        locationTF = new javax.swing.JTextField();
        sendEmerBtn = new javax.swing.JButton();
        comboEmerType = new javax.swing.JComboBox();
        backJBtn = new javax.swing.JButton();
        jLSupEmerReq = new javax.swing.JLabel();

        setBackground(new java.awt.Color(76, 89, 115));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Emergency Type");
        add(jLabel1);
        jLabel1.setBounds(170, 300, 101, 18);

        locationlbl.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        locationlbl.setForeground(new java.awt.Color(255, 255, 255));
        locationlbl.setText("Location");
        add(locationlbl);
        locationlbl.setBounds(220, 380, 53, 18);

        locationTF.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        locationTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationTFActionPerformed(evt);
            }
        });
        add(locationTF);
        locationTF.setBounds(320, 370, 220, 24);

        sendEmerBtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        sendEmerBtn.setText("Send Emergency");
        sendEmerBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sendEmerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendEmerBtnActionPerformed(evt);
            }
        });
        add(sendEmerBtn);
        sendEmerBtn.setBounds(465, 500, 150, 22);

        comboEmerType.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        comboEmerType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(comboEmerType);
        comboEmerType.setBounds(320, 300, 220, 24);

        backJBtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        backJBtn.setText("Back");
        backJBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJBtnActionPerformed(evt);
            }
        });
        add(backJBtn);
        backJBtn.setBounds(90, 510, 80, 22);

        jLSupEmerReq.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLSupEmerReq.setForeground(new java.awt.Color(255, 255, 255));
        jLSupEmerReq.setText("Supervisor Emergency Request");
        add(jLSupEmerReq);
        jLSupEmerReq.setBounds(210, 120, 340, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void sendEmerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendEmerBtnActionPerformed
        // TODO add your handling code here:
        
         String location = locationTF.getText();
        erequest.setLocation(location);
        erequest.setEmergencytype((Organization.Type) comboEmerType.getSelectedItem());
        erequest.setEmail(userAccount.getEmail());
         Organization org = null;
         Organization.Type sel = (Organization.Type) comboEmerType.getSelectedItem();
      if(location.isEmpty())
      {
        System.out.println("Inside else block of sendComplaintActionPerformed ");
            JOptionPane.showMessageDialog(null,"Location field is empty");     
    }
        
        else
        {
            
            
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
        
            
        }
    }//GEN-LAST:event_sendEmerBtnActionPerformed

    private void backJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJBtnActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SupervisorWorkAreaJPanel fwajp = (SupervisorWorkAreaJPanel) component;
        
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJBtnActionPerformed

    private void locationTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationTFActionPerformed
        // TODO add your handling code here:
        
        if(locationTF.getText()!=""){
        message1 = locationTF.getText();
        System.out.println("sendComplaintActionPerformed 'messageJTextField' " + message1);
        }
        else JOptionPane.showMessageDialog(null,"Location field is empty");
        
        
    }//GEN-LAST:event_locationTFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJBtn;
    private javax.swing.JComboBox comboEmerType;
    private javax.swing.JLabel jLSupEmerReq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField locationTF;
    private javax.swing.JLabel locationlbl;
    private javax.swing.JButton sendEmerBtn;
    // End of variables declaration//GEN-END:variables

    private void populateComboBox() {
         comboEmerType.removeAllItems();
        comboEmerType.addItem(Organization.Type.Theft);
        comboEmerType.addItem(Organization.Type.Felony);
        comboEmerType.addItem(Organization.Type.Misconduct);
    }
}
