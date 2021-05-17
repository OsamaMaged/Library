package library;

import java.sql.*;

public class Database_connection {

    static Connection con = null;

    public static Connection connect() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String password = "root";
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to DB");
            return con;
        } catch (Exception e) {
            System.out.println("Error connecting to DB");
            return null;
        }

    }

}
