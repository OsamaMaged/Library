/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.users;

/**
 *
 * @author Ashrakat
 */
public class user {
    String id;
    String name;
    String email;
    String password;
    String userTypeID;
    String userTypeName;

    public user(String id, String name, String email, String password, String userTypeID) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userTypeID = userTypeID;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserTypeID() {
        return userTypeID;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }
    
    
    
}
