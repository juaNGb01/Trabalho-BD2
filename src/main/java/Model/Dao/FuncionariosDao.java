/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import DBConnection.Conexao;
import Model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanb
 */
public class FuncionariosDao {
    
    
    //Método Listar todos os funcionarios
    public void ListarFuncionarios(DefaultTableModel table){
        
        Connection conn = Conexao.getConn(); 
        
        Statement stmt = null; 
        
        table.setRowCount(0);
        
        try{
            String sql =  "select * from tb_funcionarios order by fun_codigo"; 
            stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery(sql); 
            
            while(rs.next()){
                
                Integer codigo = rs.getInt("fun_codigo"); 
                String id = String.valueOf(codigo);
                
                String nome = rs.getString("fun_nome"); 
                String cpf = rs.getString("fun_cpf"); 
                String senha = rs.getString("fun_senha"); 
                String funcao = rs.getString("fun_funcao"); 
                

                //Adiciona os dados na tabela
                String[] row = {id,nome,cpf, senha, funcao};
                table.addRow(row);
 
            }
                    
                    
        }catch(SQLException ex){
            System.out.println("Erro ao buscar funcionarios" + ex.getMessage()); 
        }
       
      
    }
    
    //Método buscar Funcionário por Nome 
    public void BuscarPorNome(String nome, DefaultTableModel table){
    
        Connection conn = Conexao.getConn(); 
        
        PreparedStatement stmt = null; 
        
        if(conn == null){
            System.out.println("erro na con"); 
        }
        
        
        
        try{
            String sql =  "select * from tb_funcionarios where fun_nome = ? "; 
            stmt = conn.prepareStatement(sql); 
            //add o nome que deseja ser buscado na query
            stmt.setString(1, nome);
            
            if(stmt == null){
                 System.out.println("erro na stmt");
            }
            ResultSet rs = stmt.executeQuery(); 
          
            if(!rs.isBeforeFirst()){
                System.out.println("nenhum funcionario encontrado - deu pau na stmt");
            }
            
            while(rs.next()){
                
                Integer id = rs.getInt("fun_codigo"); 
                String codigo = String.valueOf(id);
                
                String nomeFun = rs.getString("fun_nome"); 
                String cpf = rs.getString("fun_cpf"); 
                String senha = rs.getString("fun_senha"); 
                String funcao = rs.getString("fun_funcao");
                
                String[] row = {codigo,nomeFun,cpf, senha, funcao};
                table.addRow(row);
                
                System.out.println("Chegou até aqui");
 
            }
                    
                    
        }catch(SQLException ex){
            System.out.println("Erro ao buscar funcionario: " + ex.getMessage()); 
            ex.printStackTrace();
        }
       
    } 
    
    
    //Método buscar Funcionário por Nome 
    public void BuscarPorId(Integer idInput, DefaultTableModel table){
    
        Connection conn = Conexao.getConn(); 
        
        PreparedStatement stmt = null; 
        
        try{
            String sql =  "select * from tb_funcionarios where fun_codigo = ? "; 
            stmt = conn.prepareStatement(sql); 
            
            //add o nome que deseja ser buscado na query
            stmt.setInt(1, idInput);
            ResultSet rs = stmt.executeQuery(); 
            
            

            
            while(rs.next()){
                
                Integer id = rs.getInt("fun_codigo"); 
                String codigo = String.valueOf(id);
                
                String nomeFun = rs.getString("fun_nome"); 
                String cpf = rs.getString("fun_cpf"); 
                String senha = rs.getString("fun_senha"); 
                String funcao = rs.getString("fun_funcao");
                
                String[] row = {codigo,nomeFun,cpf, senha, funcao};
                table.addRow(row);
 
            }
                    
                    
        }catch(SQLException ex){
            System.out.println("Erro ao buscar funcionario: " + ex.getMessage()); 
        }
       
    } 
    
    public void EditarFuncionario(int id, String nome, String cpf, String senha, String funcao){
        
          // Verifica se algum parâmetro está vazio
        if (nome.isEmpty() || cpf.isEmpty() || senha.isEmpty() || funcao.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;  // Interrompe o método se algum campo estiver vazio
        }
        
        
        Connection conn = Conexao.getConn(); 
        PreparedStatement stmt  = null; 

        
        try{
            
            stmt = conn.prepareStatement("UPDATE tb_funcionarios SET fun_nome = ? ,"
                    + " fun_cpf = ?, fun_senha = ?, fun_funcao = ?"
                    + " WHERE fun_codigo = ?");
            
            stmt.setString(1, nome); 
            stmt.setString(2, cpf); 
            stmt.setString(3, senha); 
            stmt.setString(4, funcao); 
            stmt.setInt(5, id);
            
            stmt.executeUpdate(); 
            
           JOptionPane.showMessageDialog(null, "Usuário Alterado com sucesso!");            
        
        }catch(SQLException ex){
            System.out.println("ERRO ao editar Funcionário: " + ex.getMessage()); 
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o usuário. "
                + "Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            
        
        }
        
    
    }
    
    
    public void RemoverFuncionario(int id){
        
        Connection conn = Conexao.getConn(); 
        PreparedStatement stmt  = null; 
        
         try{
            
            stmt = conn.prepareStatement("DELETE FROM tb_funcionarios"
                    + " WHERE fun_codigo = ?");
           
            stmt.setInt(1, id); 
            stmt.executeUpdate(); 
            
           JOptionPane.showMessageDialog(null, "Usuário Removido com sucesso!");            
        
        }catch(SQLException ex){
            System.out.println("ERRO ao Remover Funcionário: " + ex.getMessage()); 
            JOptionPane.showMessageDialog(null, "Erro ao Remover o usuário. "
                + "Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            
        
        }
    
    
    }
    
    
    
    //Método para adicionar funcionário
    public void AddFuncionario(int codigo, String nome, String cpf, String senha, String funcao){
        
        PreparedStatement stmt = null;
        
        
        try{
            
            stmt = Conexao.getConn().prepareStatement("INSERT INTO tb_funcionarios"
                    + " VALUES (?, ?, ?, ?, ?)"); 
              
            stmt.setInt(1, codigo); 
            stmt.setString(2, nome); 
            stmt.setString(3, cpf); 
            stmt.setString(4, senha); 
            stmt.setString(5, funcao); 
            
            int rowsAffected = stmt.executeUpdate(); 
            
             if(rowsAffected > 0){
                System.out.println("DONE: " + rowsAffected + "rows Affected");
            }else{
                System.out.println("No Rows Affected");
                
            }     
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.print(ex.getMessage());
            

        }
        
        
        
        
        
    }
    
    
    
    
}
