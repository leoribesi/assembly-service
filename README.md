# Assembly Service

## Descrição
Assembly Service é um desafio técnico do SICREDI onde serviço tem como objetivo gerenciar pautas e sessões de votação. 

## Tecnologias Utilizadas
- **Spring Boot**: 3.5.9
- **Java**: 21
- **FlyWay**
- **Lombok**

## Como Iniciar a Aplicação

### Para iniciar a aplicação via docker
1. Build e executa o container:
    ```sh
    ./gradlew clean build && docker-compose up -d
    ```
2. A aplicação estará disponível em [http://localhost:8080](http://localhost:8080).
3. Para acessar a documentação da API, acesse [Swagger](http://localhost:8080/swagger-ui/index.html).
4. Para acessar o banco de dados via DBeaver ou outra ferramenta, utilize as seguintes credenciais:
   - Host: localhost
   - Porta: 5432
   - Database: assembly_db
   - User: postgres
   - Password: postgres

## Como acessar via cloud

1. A aplicação estará disponível em [http://174.138.83.174](http://174.138.83.174).
2. Para acessar a documentação da API, acesse [Swagger](http://174.138.83.174/swagger-ui/index.html).
3. Para acessar o banco de dados via DBeaver ou outra ferramenta, utilize as seguintes credenciais:
   - Host: 174.138.83.174
   - Porta: 5432
   - Database: assembly_db
   - User: postgres
   - Password: postgres
