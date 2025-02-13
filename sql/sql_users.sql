


--Add user por meio da procedure - nome do usuário/cpf/senha/funcao
--adm
CALL adduserandgrantrole('administrador', '12345678910', 'admin123', 'admin')
--gerente
CALL adduserandgrantrole('gerente', '74185296310', 'geret123', 'gerente');
--funcionario
CALL adduserandgrantrole('funcionario', '78945632152', 'fun123', 'funcionario');
CALL adduserandgrantrole('funcionario2', '32198745630', 'fun321', 'funcionario');

--convencional
CREATE USER gerente WITH PASSWORD 'gerente';
GRANT role_gerente TO gerente;

CREATE USER funcionario WITH PASSWORD 'funcionario'; 
GRANT role_funcionario TO funcionario;


CREATE USER administrador WITH PASSWORD 'administrador'; 
GRANT role_admin to administrador; 

insert into tb_funcionarios VALUES(1,'administrador','12345678902' ,'administrador', 'admin'); 
insert into tb_funcionarios VALUES (2, 'gerente','78945612393' ,'gerente', 'gerente'); 
insert into tb_funcionarios VALUES (3, 'funcionario','78945612385' ,'funcionario', 'funcionario'); 
