# swiftJavaFinance

Este é um projeto Java Spring Boot que implementa um sistema simples de transações financeiras entre clientes e empresas, utilizando SQLite3 como banco de dados.

## Pré-requisitos

Certifique-se de ter o seguinte instalado antes de começar:

- Java Development Kit (JDK)
- Gradle
- Git
- Seu IDE favorito (recomendado: Visual Studio Code)

## Executar e Testar o Projeto

Siga os passos abaixo para executar e testar o projeto em sua máquina local:

1. **Clonar o Repositório:**
    ```bash
    git clone https://github.com/seu-usuario/swiftJavaFinance.git
    cd swiftJavaFinance
    ```

2. **Executar o Aplicativo:**
    ```bash
    ./gradlew bootRun
    ```

    O aplicativo será iniciado em http://localhost:8080.

3. **Testar Endpoints:**

   Você pode testar os endpoints usando ferramentas como o [Postman](https://www.postman.com/) ou simplesmente seu navegador. Aqui estão alguns exemplos:

   - **Listar todos os clientes:**
     ```bash
     curl http://localhost:8080/api/clientes
     ```

   - **Listar todas as empresas:**
     ```bash
     curl http://localhost:8080/api/empresas
     ```

   - **Cadastrar um novo cliente:**
     ```bash
     curl -X POST -H "Content-Type: application/json" -d '{"nome": "Nome do Cliente", "cpf": "123.456.789-00"}' http://localhost:8080/api/clientes
     ```

   - **Cadastrar uma nova empresa:**
     ```bash
     curl -X POST -H "Content-Type: application/json" -d '{"nome": "Nome da Empresa", "cnpj": "12.345.678/0001-90"}' http://localhost:8080/api/empresas
     ```

4. **Encerrar o Aplicativo:**

   Após testar, encerre o aplicativo pressionando `Ctrl + C` no terminal onde ele está sendo executado.

