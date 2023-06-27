# API Spring Boot - Microserviço de Envio de Email

Esta é uma API Spring Boot que fornece um microserviço para envio de emails. Ele utiliza o banco de dados PostgreSQL para armazenar informações relacionadas aos emails a serem enviados.

## Instalação e Configuração

### Pré-requisitos
1. Uma IDE de sua preferência
2. Java
2. Maven
3. PostgreSQL
4. Um gmail

### Configuração do Banco de Dados

Antes de executar a API, siga as etapas abaixo para configurar o banco de dados:

1.  Crie um banco de dados PostgreSQL.
    
2.  Abra o arquivo `application.properties` localizado na raiz do projeto e configure as seguintes propriedades relacionadas ao banco de dados:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ms-email
spring.datasource.username=postgres
spring.datasource.password=senha
```

Certifique-se de substituir "ms-email" pelo nome do banco, "postgres" pelo user e "senha" pela senha do seu banco de dados.

### Configuração do Email

Para enviar emails, é necessário configurar as informações de acesso à conta de email. Siga as etapas abaixo:

1.  É necessário gerar uma senha de aplicativo para o Gmail. Siga este [guia](https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbVJIUng3WFExTzNzQjc1QzAtU2JPN3RULUQtZ3xBQ3Jtc0trNnlXUXZXQXJXNjdFb1VxQTgxRDJXSGVZNXAxZERoSER2RnRtSmFmdlFXRDBvUjdqS3VZVnRsYms3Y0FMaVBjRklJbE5ZelRhWkVZbnNyeU92aFJmb2psSFYzVmE0Q3p2UTYwbGc2clV4QTNMMlBNZw&q=https%3A%2F%2Fsupport.google.com%2Faccounts%2Fanswer%2F185833&v=ZBleZzJf6ro) para aprender como gerar a senha de aplicativo.
    
2.  Crie um arquivo chamado `secret.properties` no caminho `src/java/resources` e adicione o seguinte conteúdo:
    
```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=********@gmail.com
spring.mail.password=********
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
``` 
substitua username pelo seu email e password pela senha de app gerada

### Instalar Dependências
Para baixar as dependências e executar a API, Navegue até o diretório raiz do projeto e execute o seguinte comando:

```shell
mvn clean install
``` 

## Uso da API
Execute este comando para iniciar a API. Ela usara a porta 8080

```shell
mvn spring-boot:run
```

### Envio de Email
1.  Faça uma requisição HTTP POST para a seguinte rota: 

```shel
http://localhost:8080/sending-email
```
    
2.  No corpo da requisição, envie um JSON com os seguintes campos preenchidos. Certifique-se de substituir os valores com as informações relevantes

```json
{
    "ownerRef": "seu-nome",
    "emailFrom": "seu.email@gmail",
    "emailTo": "outro.email@gmail.com",
    "subject": "assunto do email",
    "text": "conteudo do email"
}
```

3. Como resultado, a API irá enviar seu email, salva-lo no banco de dados e retornar, como resposta, um JSON contendo os dados do email.

## Licença

Este projeto está licenciado sob a [MIT License](https://chat.openai.com/LICENSE).