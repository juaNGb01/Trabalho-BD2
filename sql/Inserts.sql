-- Inserindo funcionarios
INSERT INTO tb_funcionarios (fun_nome, fun_cpf, fun_senha, fun_funcao) VALUES 
('administrador', '12358794562', 'administrador', 'admin'),
('gerente', '85469852587', 'gerente', 'gerente'),
('funcionario', '45875698521', 'funcionario', 'funcionario'),
('Ana Souza', '12345678901', 'senha123', 'gerente'),
('Carlos Lima', '23456789012', 'seguranca@456', 'funcionario'),
('Mariana Oliveira', '34567890123', 'pass789', 'funcionario'),
('João Santos', '45678901234', '1234abcd', 'funcionario'),
('Fernanda Alves', '56789012345', 'Fernanda@99', 'admin'),
('Rafael Mendes', '67890123456', 'R@fael321', 'gerente'),
('Juliana Pereira', '78901234567', 'Juliana#001', 'funcionario'),
('Lucas Rocha', '89012345678', 'Lukinhas2023', 'funcionario'),
('Amanda Nunes', '90123456789', 'AmandaXYZ', 'admin'),
('Bruno Martins', '01234567890', 'Bruno$$77', 'funcionario'),
('Patrícia Dias', '11122233344', 'P@tricia22', 'gerente'),
('Felipe Gomes', '22233344455', 'FGomes987', 'admin');

-- Inserindo fornecedores
INSERT INTO tb_fornecedores (for_descricao) VALUES 
('Fornecedor de Laticínios'), 
('Distribuidora de Bebidas'),
('Fornecedor de Carnes');


INSERT INTO tb_produtos (pro_descricao, pro_valor, pro_quantidade, tb_fornecedor_for_codigo) VALUES 
('Leite Integral', 4.50, 200, 4), 
('Queijo Mussarela', 34.90, 120, 4),  
('Iogurte Natural', 3.99, 150, 4),  
('Refrigerante Cola 2L', 7.99, 150, 5),  
('Vinho Tinto Seco', 39.90, 40, 5), 
('Suco de Laranja 1L', 6.50, 180, 5),  
('Carne Bovina Picanha', 49.90, 50, 6),  
('Frango Congelado', 19.90, 100, 6),  
('Linguiça Toscana', 14.99, 80, 6);  

