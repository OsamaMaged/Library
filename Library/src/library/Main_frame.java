/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import library.books.book_management;
import library.users.users_management;
import library.transactions.transaction_management;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import library.books.book;
import library.books.view_all_books;
import library.transactions.Transaction;
import library.transactions.user_transaction_history;

/**
 *
 * @author Ashrakat
 */
public class Main_frame extends javax.swing.JFrame {

    public static Connection c;
    Statement st;
    ResultSet rs = null;

    public Main_frame() {
        initComponents();
        applyPermissions();
        try {
            //connection to database
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");

            //create statement 
            Statement myStmt = c.createStatement();
            System.out.println("table Created Successfully");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public Main_frame(Connection conn, Statement st) {
        conn = this.c;
        st = this.st;

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
        manageBooksBtn = new javax.swing.JButton();
        manageUserBtn = new javax.swing.JButton();
        manageTransactionsBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        viewAllBooksBtn = new javax.swing.JButton();
        viewTransactionsHistoryBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("Public Library System");

        manageBooksBtn.setText("Manage books");
        manageBooksBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageBooksBtnActionPerformed(evt);
            }
        });

        manageUserBtn.setText("Manage users");
        manageUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUserBtnActionPerformed(evt);
            }
        });

        manageTransactionsBtn.setText("Manage transactions");
        manageTransactionsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageTransactionsBtnActionPerformed(evt);
            }
        });

        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        viewAllBooksBtn.setText("View All Books");
        viewAllBooksBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllBooksBtnActionPerformed(evt);
            }
        });

        viewTransactionsHistoryBtn.setText("View Transaction History");
        viewTransactionsHistoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTransactionsHistoryBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(manageTransactionsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(manageUserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageBooksBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewAllBooksBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(viewTransactionsHistoryBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoutBtn)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoutBtn)
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(manageUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(manageBooksBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(manageTransactionsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewAllBooksBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewTransactionsHistoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void manageUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUserBtnActionPerformed
        users_management m = new users_management();
        m.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_manageUserBtnActionPerformed

    private void manageBooksBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageBooksBtnActionPerformed
        book_management b = new book_management();
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageBooksBtnActionPerformed

    private void manageTransactionsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageTransactionsBtnActionPerformed
        new transaction_management().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageTransactionsBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void viewAllBooksBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllBooksBtnActionPerformed
        try {
            ArrayList<book> books = new ArrayList<>();
            String sql = "SELECT * from book";
            st = c.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                books.add(new book(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getString("author"), rs.getString("type")));
            }

            for (int i = 0; i < books.size(); i++) {
                book book = books.get(i);
                sql = "Select name from author_name where id='" + book.getAuthorID() + "'";
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    book.setAuthorName(rs.getString("name"));
                }

                sql = "Select type from booktype where id='" + book.getTypeID() + "'";
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    book.setTypeName(rs.getString("type"));
                }
            }

            view_all_books viewAllBooks = new view_all_books();
            viewAllBooks.fillBookTable(books);
            viewAllBooks.setVisible(true);
            this.dispose();

        } catch (Exception e) {
            System.out.println("Failed to fetch all books");
        }
    }//GEN-LAST:event_viewAllBooksBtnActionPerformed

    private void viewTransactionsHistoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTransactionsHistoryBtnActionPerformed

        try {
            ArrayList<Transaction> transactions = new ArrayList<>();
            String sql = "SELECT * from transaction where user_id = '" + user_type.getUserID() + "'";
            st = c.createStatement();
            rs = st.executeQuery(sql);
            //get all transaction of the current user and aff them to an array
            while (rs.next()) {
                transactions.add(new Transaction(rs.getString("id"), rs.getString("date"), rs.getString("user_id"), rs.getString("transactiondetails_id")));
            }

            //get book name from transaction details to show in transaction history table
            for (int i = 0; i < transactions.size(); i++) {
                Transaction transaction = transactions.get(i);               
                sql = "Select due_date from transactiondetails where id='" + transaction.getTransactionDetailsID() + "'";
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    transaction.setReturnDate(rs.getString("due_date"));
                }

                sql = "Select book_id from transactiondetails where id='" + transaction.getTransactionDetailsID() + "'";
                rs = st.executeQuery(sql);
                String bookId = null;
                while (rs.next()) {
                    bookId = rs.getString("book_id");
                    transaction.setBookId(bookId);
                }

                sql = "Select name from book where id='" + bookId + "'";
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    transaction.setBookName(rs.getString("name"));
                }
            }

            user_transaction_history userTransactionHistory = new user_transaction_history();
            userTransactionHistory.fillTransactinHistoryTable(transactions);
            userTransactionHistory.setVisible(true);
            this.dispose();

        } catch (Exception e) {
            System.out.println("Failed to fetch transaction history");
        }
    }//GEN-LAST:event_viewTransactionsHistoryBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Main_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton manageBooksBtn;
    private javax.swing.JButton manageTransactionsBtn;
    private javax.swing.JButton manageUserBtn;
    private javax.swing.JButton viewAllBooksBtn;
    private javax.swing.JButton viewTransactionsHistoryBtn;
    // End of variables declaration//GEN-END:variables

    //manage buttons to appear to users with the right permissions
    private void applyPermissions() {
//        user_type.setUserType("0");
        System.out.println(user_type.getUserType());
        if (!new permissions().isPermitted(user_type.getUserType(), "users_management.java")) {
            manageUserBtn.setVisible(false);
        }
        if (!new permissions().isPermitted(user_type.getUserType(), "book_management.java")) {
            manageBooksBtn.setVisible(false);

        }
        if (!new permissions().isPermitted(user_type.getUserType(), "transaction_management.java")) {
            manageTransactionsBtn.setVisible(false);
        }

        if (!new permissions().isPermitted(user_type.getUserType(), "user_transaction_history.java")) {
            viewTransactionsHistoryBtn.setVisible(false);
        }

        if (!new permissions().isPermitted(user_type.getUserType(), "view_all_books.java")) {
            viewAllBooksBtn.setVisible(false);
        }

    }
}
