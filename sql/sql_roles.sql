--CRIAÇÃO DAS ROLES
CREATE ROLE role_admin;
CREATE ROLE role_gerente;
CREATE ROLE role_funcionario;
--CONCESSÃO DE PRIVILÉGIOS ADMIN

GRANT INSERT, UPDATE, DELETE, SELECT ON TABLE tb_funcionarios TO role_admin; 
GRANT INSERT, UPDATE, DELETE, SELECT ON TABLE tb_fornecedores TO role_admin;
GRANT INSERT, UPDATE, DELETE, SELECT ON TABLE tb_itens TO role_admin;
GRANT INSERT, UPDATE, DELETE, SELECT ON TABLE tb_produtos TO role_admin;
GRANT INSERT, UPDATE, DELETE, SELECT ON TABLE tb_vendas TO role_admin;
GRANT USAGE, SELECT, UPDATE ON SEQUENCE tb_vendas_ven_codigo_seq TO role_admin;


GRANT role_gerente TO role_admin WITH ADMIN OPTION; 
GRANT role_funcionario TO role_admin WITH ADMIN OPTION; 
 

ALTER ROLE role_admin WITH CREATEROLE;

--CONCESSÃO DE PRIVILÉGIOS GERENTE
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE tb_funcionarios TO role_gerente; 
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE tb_fornecedores TO role_gerente;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE tb_vendas TO role_gerente;
GRANT SELECT ON TABLE tb_produtos TO role_gerente;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE tb_itens TO role_gerente;
GRANT USAGE, SELECT, UPDATE ON SEQUENCE tb_vendas_ven_codigo_seq TO role_gerente;



GRANT role_funcionario TO role_gerente WITH ADMIN OPTION;

ALTER ROLE role_gerente WITH CREATEROLE;


--CONCESSÃO DE PRIVILÉGIOS FUNCIONARIO
GRANT INSERT ON TABLE tb_vendas TO role_funcionario;
GRANT SELECT, INSERT, DELETE, UPDATE ON TABLE tb_produtos TO role_funcionario;
GRANT SELECT, INSERT ON TABLE tb_itens TO role_funcionario;

-- Concessão a todos
GRANT USAGE, SELECT ON SEQUENCE tb_itens_ite_codigo_seq TO role_admin;
GRANT USAGE, SELECT ON SEQUENCE tb_itens_ite_codigo_seq TO role_funcionario;
GRANT USAGE, SELECT ON SEQUENCE tb_itens_ite_codigo_seq TO role_gerente;

GRANT USAGE, SELECT ON SEQUENCE tb_vendas_ven_codigo_seq TO role_gerente;
GRANT USAGE, SELECT ON SEQUENCE tb_vendas_ven_codigo_seq TO role_admin;
GRANT USAGE, SELECT ON SEQUENCE tb_vendas_ven_codigo_seq TO role_funcionario;

GRANT USAGE, SELECT ON SEQUENCE tb_funcionarios_fun_codigo_seq TO role_admin;
GRANT USAGE, SELECT ON SEQUENCE tb_funcionarios_fun_codigo_seq TO role_gerente;

GRANT USAGE, SELECT ON SEQUENCE tb_fornecedores_for_codigo_seq TO role_admin;
GRANT USAGE, SELECT ON SEQUENCE tb_fornecedores_for_codigo_seq TO role_gerente;


GRANT USAGE, SELECT ON SEQUENCE tb_produtos_pro_codigo_seq TO role_gerente;
GRANT USAGE, SELECT ON SEQUENCE tb_produtos_pro_codigo_seq TO role_admin;
GRANT USAGE, SELECT ON SEQUENCE tb_produtos_pro_codigo_seq TO role_funcionario;
