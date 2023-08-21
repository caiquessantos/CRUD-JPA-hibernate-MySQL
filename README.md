# CRUD: LISTA TELEFÔNICA ALUNO X PROFESSOR

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)

> Status do Projeto: ✔️ Concluido ✔️

### Projeto pessoal desenvolvido para treinar as skills em JPA, Hibernate e em banco de dados relacionais(MySQL).

### A aplicação é uma CRUD, com todas as suas funcionalidades: CREATE, READ, UPDATE e DELETE.

## Task list:

- [x] Faz a leitura de todos os objetos cadastrados no banco de dados.
- [x] Faz o cadastro de novos objetos no banco de dados.
- [x] Faz a edição de vários atributos presentes nas entitys do projeto e atualiza no banco de dados.
- [x] Faz a remoção de objetos no banco de dados.

# 🛠️ Funcionalidades do projeto

- `Cadastrar Aluno`: Cadastra um aluno no banco de dados, passando como informações o nome, cpf, operadora e número.
- `Cadastrar Aluno`: Cadastra um professor no banco de dados, passando como informações o nome, cpf, operadora e número.
- `Consultar Todos`: Consulta no banco de dados todos os objetos da entidade 'Telefone' que foram criados.
- `Editar CPF`: Edita o CPF de um aluno ou professor.
- `Editar Nome`: Edita o nome de um aluno ou professor.
- `Editar Operadora`: Edita a operadora de um aluno ou professor.
- `Editar Número`: Edita o número de um aluno ou professor.
- `Remover Pessoa`: Remove um aluno ou professor do banco de dados e consequentemente o telefone que ele está associado.

# 🛠️ Abrir e rodar o projeto

**Para rodar o projeto é preciso ter o JAVA 13.02 ou superior instalado(de preferência entra as versões 13 e 18) na máquina. Basta seguir os passos:**
&nbsp;

### Ligando o banco de dados

1. Abrir o MySQL workbench e criar uma nova conexão com o nome de sua escolha.
2. Colocar como 'Hostname': localhost.
3. Abrir a nova conexao.
4. Escrever na query que for aberta '-- create database if not exists contato;' e executar o comando.
5. Dar refresh na aba de schemas, apertar com o botão direito do mouse em cima do schema 'contato' e selecionar a opção 'Set as Default Schema'

### Configurando o arquivo persistence e a aplicação

1. Abrir o EclipseIDE e apertar com o botão direito em cada arquivo presente na pasta 'MuitospraUm\libs' e selecionar a opção refactor para cada um deles.
2. Abrir o arquivo 'persistence_exemplo.xml' presente no caminho '\src\main\java\META-INF\persistence_exemplo.xml'
3. Procurar por 'property name="javax.persistence.jdbc.user" value="nome-de-usuario"' na aba source e trocar o "nome-de-usuario" pelo nome do seu usuário do MySQL.
4. Procurar por 'property name="javax.persistence.jdbc.password" value="senha"' na mesma aba e trocar "senha" pela sua senha do MySQL.
5. Salvar todos os arquivos

### Executando o projeto

1. Procurar pelo arquivo Main no caminho '\src\main\java\Main.java' e executá-lo com a conexão criada aberta.

### Opcional

- Caso deseje checar se todos os comandos feitos durante a execução da aplicação estão sendo realmente salvos no banco de dados, siga os passos seguintes:

1. Copie, cole e execute "select \* from aluno;" na query aberta da conexão criada para verificar todos os alunos cadastrados.
2. Copie, cole e execute "select \* from professor;" na query aberta da conexão criada para verificar todos os professores cadastrados.
3. Copie, cole e execute "select \* from telefone;" na query aberta da conexão criada para verificar todos os contatos cadastrados.

## ✔️ Técnicas e tecnologias utilizadas

- [JAVA PDF](https://docs.oracle.com/en/database/oracle/oracle-database/21/jjdev/java-developers-guide.pdf): versão 13.02
- Eclipse IDE
- Pricípios de POO
- JPA
- Hibernate
- Mysql
- Padrão DAO
