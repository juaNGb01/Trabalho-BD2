package model;
import java.math.BigDecimal;

public class Produto {
    private long codigo;
    private String descricao;
    private BigDecimal valor;
    private int quantidade;
    private long fornecedorCodigo;

    public Produto( String descricao, BigDecimal valor, int quantidade, long fornecedorCodigo) {
       // this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
        this.fornecedorCodigo = fornecedorCodigo;
    }
    
     public Produto(long codigo ,String descricao, BigDecimal valor, int quantidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
        
    }
    

    public long getCodigo() { return codigo; }
    public void setCodigo(long codigo) { this.codigo = codigo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public long getFornecedorCodigo() { return fornecedorCodigo; }
    public void setFornecedorCodigo(long fornecedorCodigo) { this.fornecedorCodigo = fornecedorCodigo; }
}
