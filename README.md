# JavaCrudProject
Trabalho final disciplina Banco de Dados 2

# Como Adicionar o Script `dump.bat` ao Task Scheduler do Windows

## Introdução
Este guia explica como adicionar um script Bash chamado `dump.bat` ao Agendador de Tarefas do Windows para ser executado diariamente.

## Requisitos
Antes de iniciar, certifique-se de que:
- O script `dump.bat` esteja salvo em um local acessível, como `C:\Scripts\dump.bat`.
- Criar um pasta com o nome `BackUp´ na raiz do disco C
- O PostgreSQL esteja instalado e configurado corretamente.
- O caminho do `pg_dump.exe` esteja correto no script.

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



