/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Funcionario;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanb
 */
public class FuncionarioDAO {

    //Método Listar todos os funcionarios
    public void listarFuncionarios(DefaultTableModel table) {

        Connection conn = Conexao.getConn();

        Statement stmt = null;

        table.setRowCount(0);

        try {
            String sql = "select * from tb_funcionarios order by fun_codigo";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Integer codigo = rs.getInt("fun_codigo");
                String id = String.valueOf(codigo);

                String nome = rs.getString("fun_nome");
                String cpf = rs.getString("fun_cpf");
                String senha = rs.getString("fun_senha");
                String funcao = rs.getString("fun_funcao");

                //Adiciona os dados na tabela
                String[] row = {id, nome, cpf, senha, funcao};
                table.addRow(row);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar funcionarios" + ex.getMessage());
        }

    }

    //Método buscar Funcionário por Nome 
    public void buscarPorNome(String nome, DefaultTableModel table) {

        Connection conn = Conexao.getConn();

        PreparedStatement stmt = null;

        try {
            String sql = "SELECT * FROM tb_funcionarios WHERE fun_nome LIKE ?";
            stmt = conn.prepareStatement(sql);
            //add o nome que deseja ser buscado na query
            stmt.setString(1, "%" + nome + "%");

            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {

                Integer id = rs.getInt("fun_codigo");
                String codigo = String.valueOf(id);

                String nomeFun = rs.getString("fun_nome");
                String cpf = rs.getString("fun_cpf");
                String senha = rs.getString("fun_senha");
                String funcao = rs.getString("fun_funcao");

                String[] row = {codigo, nomeFun, cpf, senha, funcao};
                table.addRow(row);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar funcionario: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

    //Método buscar Funcionário por Nome 
    public void buscarPorId(Integer idInput, DefaultTableModel table) {

        Connection conn = Conexao.getConn();

        PreparedStatement stmt = null;

        try {
            String sql = "select * from tb_funcionarios where fun_codigo = ? ";
            stmt = conn.prepareStatement(sql);

            //add o nome que deseja ser buscado na query
            stmt.setInt(1, idInput);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Integer id = rs.getInt("fun_codigo");
                String codigo = String.valueOf(id);

                String nomeFun = rs.getString("fun_nome");
                String cpf = rs.getString("fun_cpf");
                String senha = rs.getString("fun_senha");
                String funcao = rs.getString("fun_funcao");

                String[] row = {codigo, nomeFun, cpf, senha, funcao};
                table.addRow(row);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar funcionario: " + ex.getMessage());
        }

    }

    public void editarFuncionario(int id, String nome, String cpf, String senha, String funcao, String revokeFunc) {

        // Verifica se algum parâmetro está vazio
        if (nome.isEmpty() || cpf.isEmpty() || funcao.isEmpty()|| senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;  // Interrompe o método se algum campo estiver vazio
        }
        Connection conn = null;

        try {
            conn = Conexao.getConn();
            conn.setAutoCommit(false); // Iniciando a transação
            PreparedStatement stmt = null;

            stmt = conn.prepareStatement("CALL editarUsuario(?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, id);
            stmt.setString(2, nome);
            stmt.setString(3, cpf);
            stmt.setString(4, senha);
            stmt.setString(5, funcao);
            stmt.setString(6, revokeFunc);

            stmt.executeUpdate();
            conn.commit();

            JOptionPane.showMessageDialog(null, "Usuário Alterado com sucesso!");
        } catch (SQLException ex) {
            if (conn != null) {
                try {
                    conn.rollback(); // Revertendo a transação em caso de erro
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            //System.out.println("ERRO ao editar Funcionário: " + ex.printStackTrace());
            JOptionPane.showMessageDialog(null, "Erro ao editar o usuário. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void removerFuncionario(int id, String userName) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
         
            conn = Conexao.getConn();
            conn.setAutoCommit(false); // Iniciando a transação

         
            stmt = conn.prepareStatement("CALL removerUser(?, ?)");
            stmt.setInt(1, id);
            stmt.setString(2, userName);
            stmt.executeUpdate();

            conn.commit(); // Confirmando a transação
            JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");

        } catch (SQLException ex) {
            if (conn != null) {
                try {
                    conn.rollback(); // Revertendo a transação em caso de erro
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }

            System.out.println("ERRO ao Remover Funcionário: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao remover o usuário. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true); // Restaurando o modo padrão
                }
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addFuncionario(Funcionario func) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexao.getConn();
            conn.setAutoCommit(false); // inicio da transação

            criarUsuarioPostgres(func); 
            conn.commit(); // fim da transação
            JOptionPane.showMessageDialog(null, "Cadastro Concluído", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Rolback concluído com sucesso!");
                } catch (SQLException rollbackEx) {
                    System.out.println("Erro ao tentar das rollbacks!");
                }
            }

            System.out.print(ex.getMessage());
            if (ex.getMessage().contains("permissão negada")) {
                JOptionPane.showMessageDialog(null, "Permissão negada", "Erro", JOptionPane.INFORMATION_MESSAGE);
            } else if (ex.getMessage().contains("CPF inválido!")) {
                JOptionPane.showMessageDialog(null, "CPF inválido", "Erro", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro desconhecido", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true); 
                }
            } catch (SQLException closeEx) {
                System.out.print(closeEx.getMessage());
            }
        }
    }


    // Já é executado dentro de uma transaç"
    public void criarUsuarioPostgres(Funcionario func) throws SQLException {
        PreparedStatement stmt = null;

        try {
            
            stmt = Conexao.getConn().prepareStatement("CALL addUserAndGrantRole (?, ?, ?, ?)");

            //Integer userId = func.getCodigo(); 
            String username = func.getNome().toLowerCase().replaceAll(" ", "_");
            String userCpf = func.getCpf();
            String senha = func.getSenha();
            String funcao = func.getFuncao().toLowerCase();
            
            //stmt.setInt(1, userId);
            stmt.setString(1, username); 
            stmt.setString(2, userCpf);
            stmt.setString(3, senha);
            stmt.setString(4, funcao); 
            
            stmt.executeUpdate();
            

        } catch (SQLException ex) {
            ex.printStackTrace() ;
            throw ex; 
            
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
