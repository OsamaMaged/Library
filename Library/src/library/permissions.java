/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Ashrakat
 */
public class permissions {

    Connection c;
    ResultSet rs = null;
    Statement st = null;

    public permissions() {
        c = Database_connection.connect();
    }

    public boolean isPermitted(String userType, String pageName) {
        
        try {
            String sql = "Select id from page where physical_name='" + pageName + "'";
            st = c.createStatement();
            rs = st.executeQuery(sql);
            String pageId="";
            while (rs.next()) {
              pageId   = rs.getString("id");
               
            }
            
            //if there is a relation between this user type and page then the user is permitted to access this page
            sql = "Select id from usertype_page where usertype_id='" + userType + "' AND page_id='" + pageId + "'";
            rs = st.executeQuery(sql);
            if (!rs.isBeforeFirst()) {
                System.out.println("no permissions found");
                return false;
            }
            //user has permission to access page
            return true;

        } catch (Exception e) {
            System.out.println("Not able to fetch permission");

        }

        return false;
    }
}
