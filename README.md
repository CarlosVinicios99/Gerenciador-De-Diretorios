# Gerenciador De Diretórios
<p>
  Projeto full-stack de gerenciador de diretórios para um desafio de Desenvolvedor Java. O objetivo do projeto é desenvolver uma API com CRUD completo para arquivos e diretórios e uma interface para visualizar e listar.
</p>

## Funcionamento
<p>
  A aplicação inicia exibindo o conteúdo do diretório root padrão (criado automaticamente), o usuário pode adicionar arquivos e diretórios nos botões no canto superior direito da tela.
  Também possível retornar ao diretório anterior ao clicar no botão no canto esquerdo superior da tela.
  O usuário também pode navegar entre os dretórios listando o conteúdo dos mesmos (como foi pedido).
</p>
<img src="https://github.com/CarlosVinicios99/Gerenciador-De-Diretorios/blob/main/gerenciador-de-arquivos.jpg?raw=true" alt="">
<img src="https://github.com/CarlosVinicios99/Gerenciador-De-Diretorios/blob/main/gerenciador-de-diretorios.gif?raw=true" alt="">

## Modelagem
<img src="https://github.com/CarlosVinicios99/Gerenciador-De-Diretorios/blob/main/DER_gerenciador_de_diretorios.png?raw=true" alt="">

## Documentação Swagger
<img src="https://github.com/CarlosVinicios99/Gerenciador-De-Diretorios/blob/main/Documentacao-swagger.jpg?raw=true" alt="">

## Tecnologias Utilizadas
<ul>
  <li>Java</li>
  <li>PostgreSQL</li>
  <li>FLyway</li>
  <li>Spring</li>
  <li>Swagger</li>
  <li>ReactJS</li>
  <li>Typescript</li>
  <li>CSS</li>
</ul>

## Execução Do Projeto Local

<ol>
  <li>Ter o Postgres, Java 17 e o Maven instalados e criar o banco "gerenciador_de_diretorios"</li>
  <li>Editar o arquivo applicattion.properties da API para colocar o usuário e senha do banco local</li>
  <li>Entrar na pasta "back-end -> gerenciador-de-diretorios" e executar os comandos "mvn clean install", "java -jar target/gerenciador-de-diretorios.jar" e "mvn spring-boot:run"</li>
  <li>Com isso a API iniciará no endereço "http://localhost:8080", é possível checar a documentação swagger acessando "http://localhost:8080/swagger-ui/index.html"</li>
  <li>Entrar na pasta "front-end -> gerenciador-de-diretórios" e executar os comandos "npm install" e "npm run dev", após isso a aplicação será iniciada em "http://localhost:5173"</li>
</ol>


