# Voll.med API

API REST para gerenciamento de clínica médica, desenvolvida com foco no aprendizado de Spring Boot e boas práticas de arquitetura Java.

## 📋 Descrição do Projeto
O projeto consiste em um sistema de gerenciamento que permite o cadastro de médicos e pacientes, além do agendamento e cancelamento de consultas. A aplicação segue os princípios da arquitetura REST e utiliza persistência em banco de dados relacional.



## 🛠️ Tecnologias Utilizadas
Com base na configuração do `pom.xml`, o projeto utiliza:

* **Java 17**: Versão da linguagem.
* **Spring Boot 4.0.2**: Framework base da aplicação.
* **Spring Data JPA**: Abstração da camada de persistência.
* **MySQL & Flyway**: Banco de dados e controle de migrações de esquema.
* **Spring Security**: Implementação de autenticação e autorização via JWT.
* **Auth0 Java JWT (4.2.1)**: Biblioteca para manipulação de tokens.
* **SpringDoc OpenAPI (2.8.5)**: Documentação dos endpoints.
* **Lombok**: Utilizado para redução de código repetitivo em DTOs e entidades.

## 🏗️ Padrões de Projeto Aplicados
* **Injeção de Dependências**: Utilizada para promover o baixo acoplamento entre os componentes.
* **Polimorfismo em Validações**: Implementação de interface comum para diversas regras de negócio de agendamento, permitindo que o sistema execute todas as validações de forma desacoplada e facilitando a inclusão de novas regras (seguindo o princípio de Aberto/Fechado).
* **Tratamento de Exceções**: Uso de `@RestControllerAdvice` para padronização de erros da API.
* **Data Transfer Objects (DTOs)**: Uso de Records para entrada e saída de dados, garantindo a imutabilidade e segurança.

## 🧪 Testes Automatizados
A aplicação inclui suítes de testes para validar o comportamento das camadas de persistência, segurança e controladores, utilizando as seguintes bibliotecas:

* `spring-boot-starter-test`
* `spring-boot-starter-security-test`
* `spring-boot-starter-data-jpa-test`

---
