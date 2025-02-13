/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.UserDAO;
import javax.swing.JOptionPane;
import model.Usuario;


/**
 *
 * @author juanb
 */
public class LoginService {
    
    private UserDAO userDao = new UserDAO(); 
    
    public boolean login(String user, String password){
        
        userDao.autenticar(user, password); 
        
        return true;
        
    }
    
    
    
    
}
