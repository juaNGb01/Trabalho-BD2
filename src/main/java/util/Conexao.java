package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection conn;
    private static final String URL = "jdbc:postgresql://localhost:5432/trabalhoFinal";

    private Conexao() {
        // Construtor privado para evitar instanciação externa
    }

    public static Connection getConn(String user, String senha) {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, user, senha);
                System.out.println("Conexão realizada com sucesso!");
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao conectar: " + ex.getSQLState(), ex);
            }
        }
        return conn;
    }
    
    public static Connection getConn(){
        return conn;
    }
    
    
    public static void closeConn(){
        try{
            if(conn != null || !conn.isClosed()){
                conn.close();                
            }    
        }catch(SQLException ex){
            System.out.println("Erro ao fechar conexão: " + ex.getMessage()); 
        }
    }
    
 
}
