

package userinterface.ResidentialHall.AdminRole;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author  srivaishnaviaekkati
 */
public class ResidentialHallAdminWorkAreaJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    Network network;
    Enterprise enterprise;
    /** Creates new form AdminWorkAreaJPanel */
    public ResidentialHallAdminWorkAreaJPanel(JPanel userProcessContainer, Enterprise enterprise,Network network) {
        initComponents();
        this.network=network;
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        valueLabel.setText(enterprise.getName());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userJButton = new javax.swing.JButton();
        manageEmployeeJButton = new javax.swing.JButton();
        manageOrganizationJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("Admin Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        userJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        userJButton.setText("Manage User");
        userJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButtonActionPerformed(evt);
            }
        });
        add(userJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, 150, 50));

        manageEmployeeJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        manageEmployeeJButton.setText("Manage Employee");
        manageEmployeeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButtonActionPerformed(evt);
            }
        });
        add(manageEmployeeJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 150, 60));

        manageOrganizationJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        manageOrganizationJButton.setText("Manage Organization");
        manageOrganizationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButtonActionPerformed(evt);
            }
        });
        add(manageOrganizationJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, 60));

        enterpriseLabel.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 120, 30));

        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void userJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButtonActionPerformed
        // TODO add your handling code here:
        ResidentialHallManageUserAccountJPanel muajp = new ResidentialHallManageUserAccountJPanel(userProcessContainer, enterprise,network);
        userProcessContainer.add("ManageUserAccountJPanel", muajp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_userJButtonActionPerformed

    private void manageEmployeeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButtonActionPerformed

        ResidentialHallManageEmployeeJPanel manageEmployeeJPanel = new ResidentialHallManageEmployeeJPanel(userProcessContainer, enterprise.getOrganizationDirectory());
        userProcessContainer.add("manageEmployeeJPanel", manageEmployeeJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_manageEmployeeJButtonActionPerformed

    private void manageOrganizationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButtonActionPerformed

        ResidentialHallManageOrganizationJPanel manageOrganizationJPanel = new ResidentialHallManageOrganizationJPanel(userProcessContainer, enterprise.getOrganizationDirectory());
        userProcessContainer.add("manageOrganizationJPanel", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganizationJButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageEmployeeJButton;
    private javax.swing.JButton manageOrganizationJButton;
    private javax.swing.JButton userJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
    
}