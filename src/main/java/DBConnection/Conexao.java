/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *
 * @author juanb
 */
public class Conexao {
    
  private static Connection conn; 
  //private static Boolean status = false; 

  
    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        Conexao.conn = conn;
    }

//    public Boolean getStatus() {
//        return status;
//    }
//
//    public void setStatus(Boolean status) {
//        this.status = status;
//    }
    
    
  
  public Connection getConnection(String user, String senha) {
     
    //caso não tenha conexao conecta
    if(conn == null){

        try{
            String url = "jdbc:postgresql://localhost:5432/trabalhoFinal"; 
            conn =  DriverManager.getConnection(url, user, senha);     
            System.out.println("Conexão realizada com sucesso!"); 
            //status = true; 
            
        }catch(SQLException ex){
            throw new DbException("Erro ao conectar: " + ex.getSQLState()); 
            
        } 
       
    }
      
    return conn;
   
  }    
}
