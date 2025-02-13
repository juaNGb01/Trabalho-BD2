package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import util.Conexao;
import util.UserSession;

public class VendaDAO {

    private static ArrayList<Produto> carrinho = new ArrayList<>();

        public void addCompra(Produto prod, DefaultTableModel table) {
            carrinho.add(prod);
            String[] row = {prod.getDescricao(), 
                            String.valueOf(prod.getValor()), 
                            String.valueOf(prod.getQuantidade())};
            table.addRow(row);
        }
        


    public void FinalizarVenda(){
                new Thread(() -> {
                    Connection conn = Conexao.getConn();;
                    try {
                        processarVenda(conn);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }).start();
        }
        
            
    
            

    public void processarVenda(Connection conn) throws InterruptedException {

        String updateProdutoSQL = "UPDATE tb_produtos SET pro_quantidade = pro_quantidade - ? WHERE pro_codigo = ?";
        String insertVendaSQL = "INSERT INTO tb_vendas (ven_horario, ven_valor_total, tb_funcionarios_fun_codigo) VALUES (NOW(), ?, ?)";
        String insertItemSQL = "INSERT INTO tb_itens (ite_quantidade, ite_valor_parcial, tb_produtos_pro_codigo, tb_vendas_ven_codigo)"
                + " VALUES (?, ?, ?, ?)";

        try{
           
            conn.setAutoCommit(false);  // Inicia transacao

            atualizarEstoque(conn, updateProdutoSQL);
            BigDecimal totalVenda = calcTotalVenda(); 
            long vendaId = InserirVenda(conn, insertVendaSQL, totalVenda);
            inserirItemVenda(conn, insertItemSQL, vendaId);
            
            conn.commit(); // Commita a transacao
           JOptionPane.showMessageDialog(null, "Venda Concluida", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Total vendido: " + totalVenda);
            carrinho.clear(); // Limpa o carrinho

        } catch (SQLException ex) {
            try {
                // Em caso de exceção, tenta fazer rollback
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            ex.printStackTrace();
        }
    }

    //método calcular o total vendido
    private BigDecimal calcTotalVenda(){
        BigDecimal total = BigDecimal.ZERO;
        for (Produto produto : carrinho) {
            
            BigDecimal qtd =  new BigDecimal(produto.getQuantidade());
            BigDecimal valorItem =  produto.getValor(); 
            total  = total.add(qtd.multiply(valorItem));
            
            System.out.println("Qtd: " + qtd + " | Valor: " + valorItem + " | Subtotal: " + qtd.multiply(valorItem));
        }
        return total;
    }
    
    //atualiza o estoque 
    private void atualizarEstoque(Connection conn, String updateSql) throws SQLException{
        try(PreparedStatement stmt = conn.prepareStatement(updateSql)){
             for (Produto produto : carrinho) {
             stmt.setInt(1, produto.getQuantidade());
             stmt.setLong(2, produto.getCodigo());
             stmt.executeUpdate();
                
             }
        }
    }
    //insere na tabela vendas
    private long InserirVenda(Connection conn, String insertSql, BigDecimal totalVendido) throws SQLException{
        //pega id do funcionario que vendeu
        long funcionarioId = UserSession.getUserLogged().getId();
        
        try(PreparedStatement stmt = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setBigDecimal(1, totalVendido);
            stmt.setLong(2, funcionarioId); 
            stmt.executeUpdate();
                
            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    return rs.getLong("ven_codigo");
                }else{
                    throw new SQLException("Falha ao obter o ID da venda.");
                }
            }
        }
    }
    //insere na tabela itens
    private void inserirItemVenda(Connection conn, String insertSql, long vendaId) throws SQLException{
            
        try(PreparedStatement stmt = conn.prepareStatement(insertSql)){

            for(Produto produto: carrinho){
                BigDecimal valorParcial = produto.getValor().multiply(BigDecimal.
                valueOf(produto.getQuantidade()));

                stmt.setInt(1, produto.getQuantidade());
                stmt.setBigDecimal(2, produto.getValor());
                stmt.setLong(3, produto.getCodigo());
                stmt.setLong(4, vendaId); 
                stmt.executeUpdate();     

            }
        }
    }
}       