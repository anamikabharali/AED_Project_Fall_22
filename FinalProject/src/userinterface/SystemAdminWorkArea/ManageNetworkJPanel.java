/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Network.Network;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author srivaishnaviaekkati
 */
public class ManageNetworkJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;

    /**
     *
     * Creates new form ManageNetworkJPanel
     */
    public ManageNetworkJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.system = system;

        populateNetworkTable();
    }

    private void populateNetworkTable() {
        DefaultTableModel model = (DefaultTableModel) tableNetwork.getModel();

        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            Object[] row = new Object[1];
            row[0] = network.getName();
            model.addRow(row);
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
        tableNetwork = new javax.swing.JTable();
        nameLabel = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        mngNetworkTxt = new javax.swing.JLabel();

        setBackground(new java.awt.Color(76, 89, 115));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));
        setLayout(null);

        tableNetwork.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tableNetwork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableNetwork);
        if (tableNetwork.getColumnModel().getColumnCount() > 0) {
            tableNetwork.getColumnModel().getColumn(0).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(50, 150, 640, 160);

        nameLabel.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setText("Name");
        add(nameLabel);
        nameLabel.setBounds(225, 360, 50, 20);

        btnSubmit.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit);
        btnSubmit.setBounds(580, 500, 47, 22);
        add(txtName);
        txtName.setBounds(300, 360, 210, 23);

        btnBack.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(90, 490, 54, 22);

        mngNetworkTxt.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        mngNetworkTxt.setForeground(new java.awt.Color(255, 255, 255));
        mngNetworkTxt.setText("Manage Network ");
        add(mngNetworkTxt);
        mngNetworkTxt.setBounds(270, 80, 188, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        String name = txtName.getText();int cou=0;
        for(Network network : system.getNetworkList())
        {
            if(network.getName() == null ? name == null : network.getName().equals(name))
            cou=1;
        }
        if(cou==0)
        {
        Network network1 = system.createAndAddNetwork();
        network1.setName(name);

        populateNetworkTable();
        txtName.setText("");
        }
        else
        {
        
        JOptionPane.showMessageDialog(null,"Network already exits");
        }
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
         Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mngNetworkTxt;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTable tableNetwork;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
