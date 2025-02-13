CREATE TABLE tb_funcionarios (
	fun_codigo BIGSERIAL PRIMARY KEY, 
	fun_nome VARCHAR(45), 
	fun_cpf VARCHAR(45),
	fun_senha VARCHAR(45),
	fun_funcao VARCHAR(45)
);


CREATE TABLE tb_fornecedores(
	for_codigo BIGSERIAL PRIMARY KEY, 
	for_descricao VARCHAR(45)

);

CREATE TABLE tb_vendas(
	ven_codigo BIGSERIAL PRIMARY KEY, 
	ven_horario TIMESTAMP, 
	ven_valor_total DECIMAL(7,2), 
	tb_funcionarios_fun_codigo BIGINT, 
	FOREIGN KEY (tb_funcionarios_fun_codigo) REFERENCES tb_funcionarios(fun_codigo)
);


CREATE TABLE tb_produtos(
	pro_codigo BIGSERIAL PRIMARY KEY  , 
	pro_descricao VARCHAR(45),
	pro_valor DECIMAL(7,2), 
	pro_quantidade INTEGER, 
	tb_fornecedor_for_codigo BIGINT, 
	FOREIGN KEY (tb_fornecedor_for_codigo) REFERENCES tb_fornecedores (for_codigo)

);  

CREATE TABLE tb_itens(
	ite_codigo BIGSERIAL PRIMARY KEY, 
	ite_quantidade INTEGER, 
	ite_valor_parcial DECIMAL(7,2), 
	tb_produtos_pro_codigo BIGINT, 
	tb_vendas_ven_codigo BIGINT, 
	FOREIGN KEY(tb_produtos_pro_codigo)REFERENCES tb_produtos(pro_codigo), 
	FOREIGN KEY(tb_vendas_ven_codigo) REFERENCES tb_vendas (ven_codigo)
);
