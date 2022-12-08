/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.ResidentialHall.Tenant;
import userinterface.ResidentialHall.Miscellaneous.MiscellaneousWorkAreaJPanel;
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
 * @author anamikabharali
 */

public class TenantComplaintJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DinerComplaintJPanel
     */
    
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

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox();
        backJButton = new javax.swing.JButton();
        sendComplaint = new javax.swing.JButton();
        messageJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(76, 89, 115));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("COMPLAINT REGISTRATION");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("/Users/anamikabharali/Downloads/imageedit_1_4791170951.jpg")); // NOI18N
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, -110, 1060, 290));

        combo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 320, -1));

        backJButton.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        backJButton.setText("<<  Back  ");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        sendComplaint.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        sendComplaint.setText("Send Complaint");
        sendComplaint.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sendComplaint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendComplaintActionPerformed(evt);
            }
        });
        add(sendComplaint, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, -1, -1));

        messageJTextField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        add(messageJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 320, -1));

        jLabel1.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Message :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, -1));

        jLabel5.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Department :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void populateComboBox() {
        
        combo.removeAllItems();
        combo.addItem(Organization.Type.Felony);
        combo.addItem(Organization.Type.Misconduct);
        combo.addItem(Organization.Type.Theft);
       
    }
    
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        MiscellaneousWorkAreaJPanel dwjp = (MiscellaneousWorkAreaJPanel) component;
        dwjp.populateRequestTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_backJButtonActionPerformed

    private void sendComplaintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendComplaintActionPerformed

        String message = messageJTextField.getText();
           if(message!=null)
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

        }
            JOptionPane.showMessageDialog(null,"Your complaint has been sent");
           }
             else
         {
           JOptionPane.showMessageDialog(null,"Message field is empty");
         }
    }//GEN-LAST:event_sendComplaintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JButton sendComplaint;
    // End of variables declaration//GEN-END:variables
}
