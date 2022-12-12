/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ResidentialHall.Supervisor;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.SupervisorOrganization;
import Business.Organization.Organization;
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
public class SupervisorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private SupervisorOrganization facultyOrganization;
    private Enterprise enterprise;
    private Network network;
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public SupervisorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem business,Network network) {
        initComponents();
        this.enterprise=enterprise;
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.facultyOrganization = (SupervisorOrganization)organization;
        this.network=network;
       
        populateRequestTable();
    }
    
   
     public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJT.getModel();
        
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
        workRequestJT = new javax.swing.JTable();
        addcomplaintBtn = new javax.swing.JButton();
        emergencybtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(76, 89, 115));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));
        setLayout(null);

        workRequestJT.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        workRequestJT.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(workRequestJT);

        add(jScrollPane2);
        jScrollPane2.setBounds(60, 220, 610, 240);

        addcomplaintBtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        addcomplaintBtn.setText("Add Complaint");
        addcomplaintBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addcomplaintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcomplaintBtnActionPerformed(evt);
            }
        });
        add(addcomplaintBtn);
        addcomplaintBtn.setBounds(300, 150, 150, 22);

        emergencybtn.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        emergencybtn.setForeground(new java.awt.Color(255, 0, 0));
        emergencybtn.setText("Emergency!!");
        emergencybtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        emergencybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emergencybtnActionPerformed(evt);
            }
        });
        add(emergencybtn);
        emergencybtn.setBounds(290, 510, 190, 22);

        jLabel1.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Supervisor Organisation Panel");
        add(jLabel1);
        jLabel1.setBounds(210, 70, 340, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void addcomplaintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcomplaintBtnActionPerformed
        // TODO add your handling code here:
        
         CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("FacultyComplaintJPanel", new SupervisorComplaintJPanel(userProcessContainer, userAccount, enterprise,network));
        layout.next(userProcessContainer);
        
         
        
    }//GEN-LAST:event_addcomplaintBtnActionPerformed

    private void emergencybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emergencybtnActionPerformed
        // TODO add your handling code here:
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("FacultyemergencyrequestJpanel", new SupervisorEmergencyRequestJPanel(userProcessContainer, userAccount, enterprise,network));
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_emergencybtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addcomplaintBtn;
    private javax.swing.JButton emergencybtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable workRequestJT;
    // End of variables declaration//GEN-END:variables
}
