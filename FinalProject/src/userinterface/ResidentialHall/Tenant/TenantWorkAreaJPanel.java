/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ResidentialHall.Tenant;

import userinterface.ResidentialHall.Tenant.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.TenantOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.Complaints_Suggestions_Request;
import Business.WorkQueue.StatusRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author srivaishnaviaekkati
 */
public class TenantWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private TenantOrganization facultyOrganization;
    private Enterprise enterprise;
    private Network network;
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public TenantWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem business,Network network) {
        initComponents();
        this.enterprise=enterprise;
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.facultyOrganization = (TenantOrganization)organization;
        this.network=network;
       
        populateRequestTable();
    }
    
   
     public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable1.getModel();
        
        model.setRowCount(0);
        for (StatusRequest request : userAccount.getStatusQueue().getStatusRequestList()){
            if (request instanceof Complaints_Suggestions_Request){
            Object[] row = new Object[4];
            row[0] = request.getMessage();
           
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            String result = ((Complaints_Suggestions_Request) request).getResponse();
            row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
        }
    }}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable1 = new javax.swing.JTable();
        addcomplaintbtn = new javax.swing.JButton();
        emergencybtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        workRequestJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Response"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(workRequestJTable1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 480, 90));

        addcomplaintbtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        addcomplaintbtn.setText("Add Complaint");
        addcomplaintbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcomplaintbtnActionPerformed(evt);
            }
        });
        add(addcomplaintbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));

        emergencybtn.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        emergencybtn.setForeground(new java.awt.Color(255, 0, 0));
        emergencybtn.setText("Emergency!!");
        emergencybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emergencybtnActionPerformed(evt);
            }
        });
        add(emergencybtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 190, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Tenant Org Panel");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addcomplaintbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcomplaintbtnActionPerformed
        // TODO add your handling code here:
        
         CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("FacultyComplaintJPanel", new TenantComplaintJPanel(userProcessContainer, userAccount, enterprise,network));
        layout.next(userProcessContainer);
        
         
        
    }//GEN-LAST:event_addcomplaintbtnActionPerformed

    private void emergencybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emergencybtnActionPerformed
        // TODO add your handling code here:
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("FacultyemergencyrequestJpanel", new TenantEmergencyRequestJPanel(userProcessContainer, userAccount, enterprise,network));
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_emergencybtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addcomplaintbtn;
    private javax.swing.JButton emergencybtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable workRequestJTable1;
    // End of variables declaration//GEN-END:variables
}
