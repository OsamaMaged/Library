/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.books;

/**
 *
 * @author Ashrakat
 */
public class book {
    String id;
    String name;
    String description;
    String authorID;
    String authorName;
    String typeID;
    String typeName;
    String stock;

    public book(String id, String name, String description, String authorID, String typeID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.authorID = authorID;
        this.typeID = typeID;
    }

    public book(String id, String name, String description, String authorID, String typeID, String stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.authorID = authorID;
        this.typeID = typeID;
        this.stock = stock;
    }

    

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthorID() {
        return authorID;
    }

    public String getTypeID() {
        return typeID;
    }

    public String getStock() {
        return stock;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getTypeName() {
        return typeName;
    }
    
    
    
    
    
}
