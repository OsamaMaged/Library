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
    String userName;
    String transactionDetailsID;
    String bookId;
    String bookName;
    String returnDate;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getUserName() {
        return userName;
    }

    public String getReturnDate() {
        return returnDate;
    }
    
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

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    


}
