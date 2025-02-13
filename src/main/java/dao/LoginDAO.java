/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import util.Conexao;
import util.DbException;
import View.HomePageScreen;
import java.awt.CardLayout;
import java.sql.Connection;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author juanb
 */
public class LoginDAO {
    
    Connection conn = null; 
    
    public LoginDAO(){}
    
    public Boolean ValidarLogin(String user, String senha){
        
        Boolean status = false; 
        
        try{
            
            conn = Conexao.getConn(user, senha); 
        
            if(conn != null){
              status = true; 
            }

        }catch(DbException ex){
            if (ex.getMessage().contains("28P01")) { // Código SQL para erro de autenticação
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", "Erro de Login", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return status; 
    }  
   
    
    
}
