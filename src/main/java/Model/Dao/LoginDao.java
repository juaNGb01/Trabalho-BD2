/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import DBConnection.Conexao;
import DBConnection.DbException;
import View.HomePageScreen;
import java.awt.CardLayout;
import java.sql.Connection;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author juanb
 */
public class LoginDao {
    
    Connection conn = null; 
    
    public LoginDao(){}
    
    public Boolean ValidarLogin(String user, char[] senha){
        
        Boolean status = false; 
        
        try{
            String stringPassWord = new String(senha);
            Conexao connection =  new Conexao(); 
            
            conn = connection.getConnection(user, stringPassWord); 
            Arrays.fill(senha, '\0'); 
        
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
