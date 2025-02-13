package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;
import model.Produto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import util.UserSession;

public class ProdutoDAO {

    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO tb_produtos(pro_descricao, pro_valor, pro_quantidade, tb_fornecedor_for_codigo) "
                + "VALUES(?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Obtendo a conexão e iniciando a transação
            conn = Conexao.getConn();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getDescricao());
            stmt.setBigDecimal(2, produto.getValor());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setLong(4, produto.getFornecedorCodigo());

            stmt.executeUpdate();

            conn.commit(); // Confirma a transação
            System.out.println("Produto adicionado com sucesso!");
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "cadastro concluido", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            if (conn != null) {
                try {
                    conn.rollback(); // Reverte a transação em caso de erro
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }

            System.out.println("Erro ao adicionar produto: " + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true); // Restaurando o comportamento padrão
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    public void buscarProdutoPorNome(String nomeProd, DefaultTableModel table)  {
        String sql = "SELECT * FROM tb_produtos WHERE pro_descricao = ?";
        table.setRowCount(0);

        try {
            Connection conn = Conexao.getConn();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, nomeProd);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String prod_id = String.valueOf(rs.getInt("pro_codigo"));
                String desc = rs.getString("pro_descricao");
                String price = String.valueOf(rs.getDouble("pro_valor"));
                String qtt = rs.getString("pro_quantidade");
                

                //Adiciona os dados na tabela
                String[] row = {prod_id, desc, price, qtt};
                table.addRow(row);
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println("ERRO ao buscar produto: " + ex.getMessage()); 
            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void listarTodosProdutos(DefaultTableModel table)  {
    Connection conn = Conexao.getConn();

        PreparedStatement stmt = null;

        table.setRowCount(0);

        try {
            
            //puxa apenas os produtos do fornecedor
            String sql = "select * from tb_produtos where pro_quantidade > 0";
            stmt = conn.prepareStatement(sql);
           
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                
                String prod_id = String.valueOf(rs.getInt("pro_codigo"));
                String desc = rs.getString("pro_descricao");
                String price = String.valueOf(rs.getDouble("pro_valor"));
                String qtt = rs.getString("pro_quantidade");
                

                //Adiciona os dados na tabela
                String[] row = {prod_id, desc, price, qtt};
                table.addRow(row);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar prdutos" + ex.getMessage());
        }

    }
    
    

    public void listarProdutos(DefaultTableModel table)  {
    Connection conn = Conexao.getConn();

        PreparedStatement stmt = null;

        table.setRowCount(0);

        try {
            
            //pega o id do fornecedor logado
           // Usuario user = UserSession.getUserLogged();
            //int userID = user.getId();
            
            //puxa apenas os produtos do fornecedor
            String sql = "select * from tb_produtos";
            stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                
                String prod_id = String.valueOf(rs.getInt("pro_codigo"));
                String desc = rs.getString("pro_descricao");
                String price = String.valueOf(rs.getDouble("pro_valor"));
                String qtt = rs.getString("pro_quantidade");
                

                //Adiciona os dados na tabela
                String[] row = {prod_id, desc, price, qtt};
                table.addRow(row);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar prdutos" + ex.getMessage());
        }

    }
    

    public void atualizarProduto(Produto produto) {
        String sql = "UPDATE tb_produtos SET pro_descricao = ?, pro_valor = ?, pro_quantidade = ? WHERE pro_codigo = ?";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Obtendo a conexão e iniciando a transação
            conn = Conexao.getConn();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getDescricao());
            stmt.setBigDecimal(2, produto.getValor());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setLong(4, produto.getCodigo());

            stmt.executeUpdate();

            conn.commit(); // Confirma a transação
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            if (conn != null) {
                try {
                    conn.rollback(); // Reverte a transação em caso de erro
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }

            JOptionPane.showMessageDialog(null, "Erro ao editar o produto. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println("ERRO ao atualizar produto: " + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true); // Restaurando o comportamento padrão
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    public void removerProduto(long codigo) {
        String sql = "DELETE FROM tb_produtos WHERE pro_codigo = ?";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Obtendo a conexão e iniciando a transação
            conn = Conexao.getConn();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, codigo);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                conn.commit();
                System.out.println("Produto removido com sucesso!");
            } else {
                conn.rollback();
                System.out.println("Nenhum produto encontrado com o código especificado.");
            }
            
            JOptionPane.showMessageDialog(null, "Removido com sucesso!", "remoção concluido", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }

            System.out.println("Erro ao remover produto: " + e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
