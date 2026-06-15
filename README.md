# 📋 Sistema de Gerenciamento de Tarefas

Uma API REST estruturada para o gerenciamento de tarefas diárias, desenvolvida para fins de estudo e prática da arquitetura Java com o ecossistema Spring Boot. O projeto lida com a criação, listagem, validação e atualização de estados de tarefas.

---

## 🛠️ Tecnologias Utilizadas

O projeto foi construído utilizando as seguintes tecnologias e dependências:

* **Java 21**
* **Spring Boot 4.1.0**
* **Spring Data JPA** — Para persistência de dados e comunicação com o banco.
* **Jakarta Validation (Bean Validation)** — Para validação rigorosa dos dados de entrada (`@NotBlank`, `@Size`).
* **H2 Database** — Banco de dados em memória ideal para desenvolvimento e testes rápidos.
* **Maven** — Gerenciador de dependências e automação do escopo do projeto.

---

## 📐 Estrutura e Arquitetura do Projeto

O projeto segue os padrões de mercado utilizando uma arquitetura em camadas para separação de responsabilidades, garantindo segurança e escalabilidade através do uso de DTOs:

* **Controllers**: Camada responsável por expor os endpoints da API, interceptar as requisições HTTP e validar os dados de entrada usando `@Valid`.
* **Services**: Camada de regras de negócio, onde os DTOs (`Request`) são processados e convertidos em Entidades JPA antes de interagir com o banco de dados.
* **Repositories**: Interfaces que herdam de `JpaRepository` para lidar com as operações tradicionais de CRUD e transações do banco.
* **DTOs (Records)**: Classes imutáveis (`GerenciamentoRequest` e `GerenciamentoResponse`) mapeando dados exatos de entrada e saída para isolar as entidades do banco de dados contra exposição desnecessária.
* **Exception Handlers**: Mecanismo global criado com `@RestControllerAdvice` para capturar exceções de validação (`MethodArgumentNotValidException`) e formatar respostas de erro customizadas de maneira elegante para o cliente.

---

## 🚀 Endpoints da API

Abaixo estão listadas as rotas configuradas na aplicação:

### Criar Nova Tarefa
* **Rota:** `POST /savetask`
* **Corpo da Requisição (JSON):**
  ```json
  {
    "task": "Estudar Spring Boot",
    "descricao": "Praticar arquitetura em camadas e Bean Validation",
    "status": "A_FAZER"
  }
