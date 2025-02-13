---FUNÇÃO PARA VALIDAR O CPF

CREATE OR REPLACE FUNCTION validar_cpf()
RETURNS TRIGGER AS $$
BEGIN
    -- Verifica se o CPF tem exatamente 11 caracteres ou se é composto apenas por zeros
    IF LENGTH(NEW.fun_cpf) <> 11 OR NEW.fun_cpf = '00000000000' THEN
        RAISE EXCEPTION 'CPF inválido!';
    END IF;
    
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_validar_cpf
BEFORE INSERT OR UPDATE ON tb_funcionarios
FOR EACH ROW
EXECUTE FUNCTION validar_cpf();


--PROCEDURE PERMITE ADICIONAR USUÁRIO E GARANTIR OS PRIVILÉGIOS

CREATE OR REPLACE PROCEDURE adduserAndGrantRole(
    username text,
    usercpf text,
    userpassword text,
    userfunc text)

AS $$
DECLARE 
    grantRole text; 
BEGIN
    -- Definindo a variável para concatenar a função
    grantRole := 'role_' || userfunc;

    -- Inserindo os dados do usuário na tabela tb_funcionarios
    INSERT INTO tb_funcionarios (fun_nome, fun_cpf, fun_senha, fun_funcao)
    VALUES (username, usercpf, userpassword, userfunc);

    -- Cria um usuário no PostgreSQL com o nome e senha fornecidos
    EXECUTE format('CREATE USER %I WITH PASSWORD %L', username, userpassword);

    -- Concede permissões com base na função (role)
    EXECUTE format('GRANT %I TO %I', grantRole, username);

    -- Se a função for 'gerente' ou 'admin', concede a permissão CREATEROLE
    IF userfunc IN ('gerente', 'admin') THEN
        EXECUTE format('ALTER USER %I CREATEROLE', username);
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        -- Em caso de erro, desfaz a transação
        RAISE EXCEPTION 'Erro durante a execução da transação: %', SQLERRM;

END;
$$
LANGUAGE 'plpgsql';

--FUNÇÃO QUE EDITA O USUÁRIO
CREATE OR REPLACE PROCEDURE editarusuario(
    usercodigo integer,
    newuser text,
    usercpf text,
    usersenha text,
    userfunc text,
    revoke_func text)
    AS $$
DECLARE
    role_func TEXT;
    role_revoke TEXT;
    currentUser TEXT; -- Variável para armazenar o nome atual do usuário
BEGIN
    -- Definição das variáveis com concatenação
    role_func := 'role_' || userfunc;
    role_revoke := 'role_' || revoke_func;

    -- Obtém o nome atual do usuário da tabela tb_funcionarios
    SELECT fun_nome INTO currentUser
    FROM tb_funcionarios
    WHERE fun_codigo = usercodigo;

    -- Atualizando informações nas tabelas
    UPDATE tb_funcionarios 
    SET fun_nome = newuser, 
        fun_cpf = usercpf, 
        fun_senha = usersenha, 
        fun_funcao = userfunc 
    WHERE fun_codigo = usercodigo; 

    -- Modifica o nome do usuário no PostgreSQL, se necessário
    IF currentUser <> newuser THEN
        EXECUTE format('ALTER ROLE %I RENAME TO %I', currentUser, newuser);  
        currentUser := newuser; -- Atualiza a variável currentUser
    END IF;

    -- Modificando privilégios 
    IF role_func <> role_revoke THEN
        EXECUTE format('REVOKE %I FROM %I', role_revoke, currentUser); -- Revoga a função antiga
        EXECUTE format('GRANT %I TO %I', role_func, currentUser); -- Concede a nova função
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        -- Em caso de erro, desfaz a transação
        RAISE EXCEPTION 'Erro durante a execução da transação: %', SQLERRM;

END
    $$
LANGUAGE 'plpgsql';


--PARA VENDA
CREATE OR REPLACE FUNCTION finalizarCompra(
    idProd BIGINT, 
    qtd INTEGER, 
    valorParcial DOUBLE PRECISION, 
    funId BIGINT
) 
RETURNS BIGINT 
AS $$
DECLARE 
    valorTotal DOUBLE PRECISION := qtd * valorParcial;
    venCodigo BIGINT;
BEGIN
    -- Atualizar a quantidade do produto no estoque
    UPDATE tb_produtos 
    SET pro_quantidade = pro_quantidade - qtd 
    WHERE pro_codigo = idProd; 

    -- Inserir a venda e capturar o ID gerado
    INSERT INTO tb_vendas (data_venda, valor_total, fun_id)
    VALUES (NOW(), valorTotal, funId)
    RETURNING ven_codigo INTO venCodigo;

    -- Retornar o código da venda inserida
    RETURN venCodigo;
END; 
$$
LANGUAGE plpgsql ;


--REMOVER FUNCIONARIO
CREATE OR REPLACE PROCEDURE removeruser(
	 userid integer,
	 username text)
AS $$
BEGIN
    EXECUTE format('DROP USER IF EXISTS %I', userName);
    EXECUTE format('DELETE FROM tb_funcionarios WHERE fun_codigo = %L', userId);

END;
$$
LANGUAGE plpgsql ;;

