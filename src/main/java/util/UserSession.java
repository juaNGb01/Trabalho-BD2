/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import model.Usuario;

/**
 *
 * @author juanb
 */
public class UserSession {
    
    private static Usuario userLogged; 
    
    public static void setuserLogged(Usuario user){
        userLogged = user; 
    
    }

    public static Usuario getUserLogged() {
        return userLogged;
    }
    
    
    public static void userLogout(){
        userLogged = null; 
    }
    
    
    
    
}
