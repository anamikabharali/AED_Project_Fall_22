/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Police.felony;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.FelonyOrganization;
import Business.Organization.CanteenOrganization;

import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.Complaints_Suggestions_Request;
import Business.WorkQueue.EmergencyRequest;
import Business.WorkQueue.StatusRequest;
import java.awt.CardLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import utility.Validate;
import utility.ValidateMail;

/**
 *
 * @author srivaishnaviaekkati
 */
public class FelonyWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private FelonyOrganization crimeOrganization;
    private Enterprise enterprise;
    private Network network;
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public FelonyWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization,Enterprise enterprise ,EcoSystem business,Network network) {
        initComponents();
        this.network=network;
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.crimeOrganization = (FelonyOrganization)organization;
        this.enterprise=enterprise;
        populateTable();
        populateEmergencyTable();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)workRequesttbl.getModel();
        
        model.setRowCount(0);
        
        for(StatusRequest request : crimeOrganization.getStatusQueue().getStatusRequestList()){
             if(request instanceof Complaints_Suggestions_Request)
            {
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            
            model.addRow(row);
        }}
    }
 public void populateEmergencyTable()
    {
    
            DefaultTableModel model = (DefaultTableModel)emergencytbl.getModel();
        
        model.setRowCount(0);
        
        for(StatusRequest request : crimeOrganization.getStatusQueue().getStatusRequestList())
        {
            if (request instanceof EmergencyRequest) {
                        EmergencyRequest s = (EmergencyRequest) request;
                        Object[] row = new Object[1];
                        row[0] = s;
                        
                         model.addRow(row);
        
        }
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
        workRequesttbl = new javax.swing.JTable();
        assignbtn = new javax.swing.JButton();
        btnprocess = new javax.swing.JButton();
        refreshbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        emergencytbl = new javax.swing.JTable();
        senteambtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(76, 89, 115));
        setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));
        setPreferredSize(new java.awt.Dimension(750, 750));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequesttbl.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        workRequesttbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequesttbl);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 560, 160));

        assignbtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        assignbtn.setText("Assign to me");
        assignbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        assignbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignbtnActionPerformed(evt);
            }
        });
        add(assignbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 120, -1));

        btnprocess.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        btnprocess.setText("Process");
        btnprocess.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnprocess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocessActionPerformed(evt);
            }
        });
        add(btnprocess, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 80, -1));

        refreshbtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        refreshbtn.setText("Refresh");
        refreshbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        refreshbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshbtnActionPerformed(evt);
            }
        });
        add(refreshbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 90, -1));

        jLabel1.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Felony Organization Panel");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        emergencytbl.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        emergencytbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Location"
            }
        ));
        jScrollPane2.setViewportView(emergencytbl);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 550, 130));

        senteambtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        senteambtn.setText("Send Team");
        senteambtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        senteambtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senteambtnActionPerformed(evt);
            }
        });
        add(senteambtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, -1, -1));

        jLabel2.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Emergency:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 90, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void assignbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignbtnActionPerformed

        int selectedRow = workRequesttbl.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        StatusRequest request = (StatusRequest)workRequesttbl.getValueAt(selectedRow, 0);
        if(request.getReceiver()!=null)
        {
            JOptionPane.showMessageDialog(null,"Request has been assigned already ");
        }
        else
        {
        
       
         if(request.getStatus()=="Completed")
        {
           JOptionPane.showMessageDialog(null,"Request has been completed already");
        }
         else
             request.setReceiver(userAccount);
          request.setStatus("Pending");
        
        }
        populateTable();
        
    }//GEN-LAST:event_assignbtnActionPerformed

    private void btnprocessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocessActionPerformed
        
        int selectedRow = workRequesttbl.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        Complaints_Suggestions_Request request = (Complaints_Suggestions_Request)workRequesttbl.getValueAt(selectedRow, 0);
          if(request.getStatus()=="Completed")
          {    
               JOptionPane.showMessageDialog(null,"Request has been completed already");  
              
          
          }
           else if(request.getStatus()=="Sent")
          {
                   JOptionPane.showMessageDialog(null,"Request has to be assigned first");  
          }
          else
          {
              
        request.setStatus("Processing");
        
        FelonyProcessStatusRequestJPanel processWorkRequestJPanel = new FelonyProcessStatusRequestJPanel(userProcessContainer, request);
        userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
          }
        
    }//GEN-LAST:event_btnprocessActionPerformed

    private void refreshbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshbtnActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshbtnActionPerformed

    private void senteambtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senteambtnActionPerformed
        // TODO add your handling code here:

        int selectedRow = emergencytbl.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        EmergencyRequest request = (EmergencyRequest)emergencytbl.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        
            ValidateMail valMail = new ValidateMail();
              valMail.sendAttachment();
           
            JOptionPane.showMessageDialog(this,"Mail has been sent");
        
    }//GEN-LAST:event_senteambtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignbtn;
    private javax.swing.JButton btnprocess;
    private javax.swing.JTable emergencytbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refreshbtn;
    private javax.swing.JButton senteambtn;
    private javax.swing.JTable workRequesttbl;
    // End of variables declaration//GEN-END:variables
}
