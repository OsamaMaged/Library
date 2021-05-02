/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.*;

/**
 *
 * @author osama
 */
public class Library {
    static Connection myConn;

    public Library(Connection conn) {
        conn = this.myConn;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
   //connection to database
    myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
   
   //create statement 
    Statement myStmt = myConn.createStatement();
   
   //execute sql query
   ResultSet myRs = myStmt.executeQuery("select * from book");
   
   //results set
   while (myRs.next()) {
    System.out.println(myRs.getString("id")+ " , "+myRs.getString("name"));
   }
  }
  catch (Exception exc) {
   exc.printStackTrace();
  }
    Main_frame m = new Main_frame();
    m.show();
    }
  
    
}
