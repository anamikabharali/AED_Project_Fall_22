/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ResidentialHall.Tenant;

import userinterface.ResidentialHall.Tenant.TenantWorkAreaJPanel;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.FelonyOrganization;
import Business.Organization.MisconductOrganization;
import Business.Organization.Organization;
import Business.Organization.TheftOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.Complaints_Suggestions_Request;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author srivaishnaviaekkati
 */
public class TenantComplaintJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DinerComplaintJPanel
     */
    public String message1 = null;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    Network network;
    public TenantComplaintJPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise,Network network) {
        initComponents();
        this.network=network;
         this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        
        populateComboBox();
    }
 Complaints_Suggestions_Request request = new Complaints_Suggestions_Request();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        messageJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox();
        sendComplaint = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(76, 89, 115));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Message");
        add(jLabel1);
        jLabel1.setBounds(220, 210, 50, 18);

        messageJTextField.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        messageJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageJTextFieldActionPerformed(evt);
            }
        });
        add(messageJTextField);
        messageJTextField.setBounds(320, 200, 210, 24);

        jLabel3.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Department");
        add(jLabel3);
        jLabel3.setBounds(200, 270, 73, 18);

        combo.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(combo);
        combo.setBounds(320, 270, 210, 24);

        sendComplaint.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        sendComplaint.setText("Send Complaint");
        sendComplaint.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sendComplaint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendComplaintActionPerformed(evt);
            }
        });
        add(sendComplaint);
        sendComplaint.setBounds(520, 430, 102, 22);

        backJButton.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        backJButton.setText("Back");
        backJButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton);
        backJButton.setBounds(120, 430, 34, 22);

        jLabel2.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tenant Complaints");
        add(jLabel2);
        jLabel2.setBounds(260, 60, 280, 30);
    }// </editor-fold>//GEN-END:initComponents
  private void populateComboBox() {
        
        combo.removeAllItems();
        combo.addItem(Organization.Type.Felony);
        combo.addItem(Organization.Type.Misconduct);
        combo.addItem(Organization.Type.Theft);
       
    }
    private void sendComplaintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendComplaintActionPerformed

        String message = message1;
        System.out.println("sendComplaintActionPerformed 'messageJTextField' " + message);
        System.out.println("sendComplaintActionPerformed 'messageJTextField' " + messageJTextField.getText());
        
    if(message != null)
    {       
                request.setMessage(message);

        request.setSender(userAccount);
        request.setStatus("Sent");

        Organization org = null;
        Organization.Type sel = (Organization.Type) combo.getSelectedItem();
        if(sel.equals(Organization.Type.Felony))
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
                org.getStatusQueue().getStatusRequestList().add(request);
                userAccount.getStatusQueue().getStatusRequestList().add(request);
            }
            JOptionPane.showMessageDialog(null,"Your Felony complaint has been sent");

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
                } }
            }
            if (org!=null){
                org.getStatusQueue().getStatusRequestList().add(request);
                userAccount.getStatusQueue().getStatusRequestList().add(request);
            }
            JOptionPane.showMessageDialog(null,"Your Misconduct complaint has been sent");


        }
        else if(sel.equals(Organization.Type.Theft))
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
                org.getStatusQueue().getStatusRequestList().add(request);
                userAccount.getStatusQueue().getStatusRequestList().add(request);
            }
        JOptionPane.showMessageDialog(null,"Your Theft complaint has been sent");

        }
        
            System.out.println("Inside if block of sendComplaintActionPerformed and is not Empty");

                }
        else
        {
            System.out.println("Inside else block of sendComplaintActionPerformed ");
            JOptionPane.showMessageDialog(null,"Message field is empty");
        }
    }//GEN-LAST:event_sendComplaintActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        TenantWorkAreaJPanel dwjp = (TenantWorkAreaJPanel) component;
        dwjp.populateRequestTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_backJButtonActionPerformed

    private void messageJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageJTextFieldActionPerformed
        // TODO add your handling code here:
        if(messageJTextField.getText()!=""){
        message1 = messageJTextField.getText();
        System.out.println("sendComplaintActionPerformed 'messageJTextField' " + message1);
        }
        else JOptionPane.showMessageDialog(null,"Message field is empty");
        
        
        
    }//GEN-LAST:event_messageJTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JButton sendComplaint;
    // End of variables declaration//GEN-END:variables
}
