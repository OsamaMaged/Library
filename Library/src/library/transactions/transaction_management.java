/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.transactions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import library.Database_connection;
import library.Main_frame;

/**
 *
 * @author Ashrakat
 */
public class transaction_management extends javax.swing.JFrame {

    Connection c;
    ResultSet rs = null;
    Statement st = null;
    Transaction transaction;
    ArrayList<Transaction> transactions = new ArrayList<>();

    /**
     * Creates new form transaction_management
     */
    public transaction_management() {
        initComponents();
        c = Database_connection.connect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        searchTransaction = new javax.swing.JTextField();
        searchTransactionBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("Transaction Management");

        jButton1.setText("Add transaction");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Search by User Name");

        searchTransaction.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        searchTransaction.setToolTipText("Enter book name");

        searchTransactionBtn.setText("Search transaction");
        searchTransactionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTransactionBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchTransactionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backButton)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchTransactionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addTransaction t = new addTransaction();
        t.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        new Main_frame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void searchTransactionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTransactionBtnActionPerformed
        String userName = searchTransaction.getText();

        //Check that input values are of valid format
        if (userName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a user name",
                    "Transaction", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ////////////////////////////////////////////////

        try {
            //get all transactions having the searched user id
            st = c.createStatement();
            String sql = "Select id from user where lower(name) like '%" + userName + "%'";
            rs = st.executeQuery(sql);
            ArrayList<String> userIDs = new ArrayList<>();

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(this, "No results found",
                        "Transaction", JOptionPane.ERROR_MESSAGE);
                searchTransaction.setText("");
                return;
            }

            while (rs.next()) {
                userIDs.add(rs.getString("id"));
            }

            //iterate over all fetched users and get their transactions
            for (int i = 0; i < userIDs.size(); i++) {
                sql = "SELECT * FROM transaction where user_id = '" + userIDs.get(i) + "'";
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    transaction = new Transaction(rs.getString("id"), rs.getString("date"), rs.getString("user_id"), rs.getString("transactiondetails_id"));
                    getForeignData(transaction);
                    transactions.add(transaction);
                }

            }

            //Show results in a new table window
            searchTransactionResults sTR = new searchTransactionResults();
            sTR.getResultFromUserName(transactions);
            sTR.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            System.out.println("failure");
        }

    }//GEN-LAST:event_searchTransactionBtnActionPerformed

    public void getForeignData(Transaction t) {
        try {
            String sql = "SELECT name from user where id='" + t.getUserId() + "'";
            rs = st.executeQuery(sql);
            rs.next();
            t.setUserName(rs.getString("name"));
            rs.close();

            sql = "Select due_date from transactiondetails where id='" + t.getTransactionDetailsID() + "'";
            rs = st.executeQuery(sql);
            rs.next();
            t.setReturnDate(rs.getString("due_date"));
            
        } catch (Exception e) {
            System.out.println("failed to add user name or due date");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(transaction_management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaction_management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaction_management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaction_management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaction_management().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField searchTransaction;
    private javax.swing.JButton searchTransactionBtn;
    // End of variables declaration//GEN-END:variables
}
