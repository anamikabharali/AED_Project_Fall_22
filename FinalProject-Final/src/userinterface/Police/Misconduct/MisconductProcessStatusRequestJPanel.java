/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Police.Misconduct;

import Business.WorkQueue.Complaints_Suggestions_Request;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author srivaishnaviaekkati
 */
public class MisconductProcessStatusRequestJPanel extends javax.swing.JPanel {
    public String message1 = null; 
    JPanel userProcessContainer;
    Complaints_Suggestions_Request request;
    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    public MisconductProcessStatusRequestJPanel(JPanel userProcessContainer, Complaints_Suggestions_Request request) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        submitJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        resultJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(76, 89, 115));
        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(750, 750));
        setLayout(null);

        submitJButton.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        submitJButton.setText("Submit Response");
        submitJButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton);
        submitJButton.setBounds(460, 380, 140, 30);

        jLabel1.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Response");
        add(jLabel1);
        jLabel1.setBounds(200, 250, 90, 30);

        resultJTextField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        resultJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultJTextFieldActionPerformed(evt);
            }
        });
        add(resultJTextField);
        resultJTextField.setBounds(280, 250, 240, 30);

        backJButton.setFont(new java.awt.Font("Optima", 0, 14)); // NOI18N
        backJButton.setText("Back");
        backJButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton);
        backJButton.setBounds(160, 378, 100, 22);

        jLabel3.setFont(new java.awt.Font("Optima", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Misconduct Process Status Request");
        add(jLabel3);
        jLabel3.setBounds(180, 100, 400, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        MisconductWorkAreaJPanel dwjp = (MisconductWorkAreaJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        String message = message1;
       
        if(message1!=null)
        {
            message1 = resultJTextField.getText();
            System.out.println("submitJButtonActionPerformed 'messageJTextField' " + message1);
            request.setResponse(message1);
            request.setStatus("Completed");
            JOptionPane.showMessageDialog(null,"Your response has been sent!");
        }
        else JOptionPane.showMessageDialog(null,"Response field is empty");
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void resultJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultJTextFieldActionPerformed
        // TODO add your handling code here:
        
        if(message1!=null)
        {
            request.setResponse(message1);
            request.setStatus("Completed");
            JOptionPane.showMessageDialog(null,"Your response has been sent!");
        }
        else
        {
           JOptionPane.showMessageDialog(null,"Text Field is Empty!");
        }
        
    }//GEN-LAST:event_resultJTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField resultJTextField;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}