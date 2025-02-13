/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author juanb
 */
public class Usuario {
    private Integer id; 
    private String name; 
    private String password; 
    
    public Usuario(){}; 

    public Usuario(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    
     public Usuario(Integer id, String name) {
        this.id = id;
        this.name = name;
}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
}
