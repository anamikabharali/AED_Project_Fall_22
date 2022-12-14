/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Facilities.Canteen;

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
public class CanteenComplaintJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CanteenComplaintJPanel
     */
     public String message1 = null;
     private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    Network network;
    public CanteenComplaintJPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise,Network network ) {
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
        messagetxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        combodept = new javax.swing.JComboBox();
        sendCompbtn = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(76, 89, 115));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Message");
        add(jLabel1);
        jLabel1.setBounds(190, 240, 90, 30);

        messagetxt.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        messagetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messagetxtActionPerformed(evt);
            }
        });
        add(messagetxt);
        messagetxt.setBounds(280, 240, 220, 24);

        jLabel3.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Department");
        add(jLabel3);
        jLabel3.setBounds(170, 310, 100, 20);

        combodept.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        combodept.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(combodept);
        combodept.setBounds(280, 300, 220, 24);

        sendCompbtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        sendCompbtn.setText("Send Complaint");
        sendCompbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sendCompbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendCompbtnActionPerformed(evt);
            }
        });
        add(sendCompbtn);
        sendCompbtn.setBounds(460, 470, 150, 22);

        backbtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        backbtn.setText("Back");
        backbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        add(backbtn);
        backbtn.setBounds(120, 470, 100, 22);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Canteen Complaint");
        add(jLabel2);
        jLabel2.setBounds(252, 100, 260, 29);
    }// </editor-fold>//GEN-END:initComponents
  private void populateComboBox() {
        
         combodept.removeAllItems();
        combodept.addItem(Organization.Type.Felony);
        combodept.addItem(Organization.Type.Misconduct);
        combodept.addItem(Organization.Type.Theft);
       
    }
    private void sendCompbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendCompbtnActionPerformed
       
        String message = message1;
        System.out.println("sendComplaintActionPerformed 'messageJTextField' " + message);
        System.out.println("sendComplaintActionPerformed 'messageJTextField' " + messagetxt.getText());
        
    if(message != null)
    {       
                request.setMessage(message);

        request.setSender(userAccount);
        request.setStatus("Sent");

        Organization org = null;
        Organization.Type sel = (Organization.Type) combodept.getSelectedItem();
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
    }//GEN-LAST:event_sendCompbtnActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CanteenWorkAreaJPanel dwjp = (CanteenWorkAreaJPanel) component;
        dwjp.populateRequestTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_backbtnActionPerformed

    private void messagetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messagetxtActionPerformed
        // TODO add your handling code here:
        
        if(messagetxt.getText()!=""){
        message1 = messagetxt.getText();
        System.out.println("sendComplaintActionPerformed 'messageJTextField' " + message1);
        }
        else JOptionPane.showMessageDialog(null,"Message field is empty");
        
    }//GEN-LAST:event_messagetxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JComboBox combodept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField messagetxt;
    private javax.swing.JButton sendCompbtn;
    // End of variables declaration//GEN-END:variables
}
