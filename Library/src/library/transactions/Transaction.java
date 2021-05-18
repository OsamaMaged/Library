/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.transactions;

/**
 *
 * @author Ashrakat
 */
public class Transaction {
      String id;
    String date;
    String userId;
    String transactionDetailsID;

    public Transaction(String id, String date, String userId, String transactionDetailsID) {
        this.id = id;
        this.date = date;
        this.userId = userId;
        this.transactionDetailsID = transactionDetailsID;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getUserId() {
        return userId;
    }

    public String getTransactionDetailsID() {
        return transactionDetailsID;
    }

    
}
