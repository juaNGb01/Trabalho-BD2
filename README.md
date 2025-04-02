# JavaCrudProject
Trabalho final disciplina Banco de Dados 2

O objetivo do projeto é criar um sistema para controle de estoque, permitindo que o usuário possa inserir, ler, deletar e atualizar os dados do banco. 

O Trabalho foi realizado em grupo e inteiramente utilizando a linguagem Java juntamente ao framework do java swing para desenvolvimento da interface gráfica. Já na parte de banco foi utilizado PostgresSQL junto a linguagem plpgSQL para auxiliar na criação de funções.

Para garantir o funcionamento correto é preciso que o banco de dados sejam criado com o nome de trabalhoFinal, dessa forma o acesso a ele poderá ser feito sem a necessidade de alterar a aplicação. Caso deseje outro nome, basta alterar a verificação na classe Conexao do pacote util. 


Para a realização da funcionalidade de backup, é necessário alterar o path para o local onde deseja que o arquivo seja criado. Além disso o pgdumpPath também precisa ser adaptado conforme o local de origem do pg_dump do usuário. Novamente, caso seja alterado o nome do banco de dados, é importante alterar o valor da variável dbase da classe BackUp para que coincida com o banco de dados.


Por fim, crie todas as tabelas e funções e faça a inserção dos dados dos usuários que serão utilizados para acessar o sistema por meio da procedure chamada addUserAndGrantRole(), ela é responsável por adicionar e garantir os privilégios de maneira automática para os usuários. A utilização dessa procedure está disponível no arquivo sql_user.


# Como Adicionar o Script `dump.bat` ao Task Scheduler do Windows

## Introdução
Este guia explica como adicionar um script Bash chamado `dump.bat` ao Agendador de Tarefas do Windows para ser executado diariamente.

## Requisitos
Antes de iniciar, certifique-se de que:
- O script `dump.bat` esteja salvo em um local acessível como a raiz do projeto.
- O PostgreSQL esteja instalado e configurado corretamente.
- O caminho do `pg_dump.exe` esteja correto no script.
- O caminho da pasta de backups no script esteja configurado e verificar que a pasta existe no caminho.

## Passo a Passo

### 1. Abrir o Agendador de Tarefas
1. Pressione `Win + R`, digite `taskschd.msc` e pressione `Enter`.
2. No painel direito, clique em **Criar Tarefa**.

### 2. Configurar as Propriedades da Tarefa
1. Na aba **Geral**:
   - Dê um nome para a tarefa, como `Backup PostgreSQL`.
   - Marque a opção **Executar mesmo que o usuário não esteja conectado**.
   - Em **Configurar para**, selecione `Windows 10` (ou a versão do seu sistema).

### 3. Definir o Gatilho (Trigger)
1. Vá até a aba **Gatilhos** e clique em **Novo**.
2. Escolha **Diariamente** e defina o horário de execução.
3. Confirme clicando em **OK**.

### 4. Configurar a Ação (Action)
1. Vá até a aba **Ações** e clique em **Nova**.
2. Em **Ação**, escolha **Iniciar um programa**.
3. Em **Programa/script**, clique em **Procurar** e selecione `dump.bat`.
4. Em **Iniciar em (opcional)**, informe o diretório onde o script está salvo, como `C:\Scripts`.
5. Clique em **OK**.

### 5. Configurar as Condições e Opções Avançadas
1. Na aba **Condições**, desmarque a opção **Iniciar a tarefa somente se o computador estiver ligado na energia**.
2. Na aba **Configurações**, marque **Permitir que a tarefa seja executada sob demanda** e **Executar a tarefa o mais rápido possível caso a execução seja perdida**.

### 6. Salvar e Testar a Tarefa
1. Clique em **OK** e forneça a senha do usuário, se solicitado.
2. Para testar, selecione a tarefa criada, clique com o botão direito e escolha **Executar**.
3. Verifique se o backup foi criado corretamente na pasta `C:\BackUp`.



