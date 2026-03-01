# 🚀 ClientAPI - Aplicação de Gerenciamento de Clientes

![Java](https://img.shields.io/badge/Java-25-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.x-green?logo=spring)
![Maven](https://img.shields.io/badge/Maven-3.9.6-red?logo=apache-maven)
![H2 Database](https://img.shields.io/badge/H2%20DB-in%20memory-orange?logo=h2-database)

API para gerenciamento de clientes utilizando **Clean Architecture** e **Domain-Driven Design (DDD)**, desenvolvida em **Java 25** com **Spring Boot 3.5.x**.
O projeto utiliza um banco de dados em memória (**H2**) para facilitar desenvolvimento e testes locais. 💻🛠️

---

## 📦 Estrutura do Projeto

O projeto segue os princípios da **Clean Architecture**, com separação clara de camadas:

```
com.github.diegolins10.clientapi
├── application         # Casos de uso e DTOs 📝
├── domain              # Entidades e interfaces de repositório 🏛️
├── infrastructure      # Persistência, mapeamentos e configurações 🗄️
└── api                 # Controllers REST 🌐
```

### 🧠 Padrões Arquiteturais Aplicados

Além da separação em camadas da **Clean Architecture**, o projeto utiliza os seguintes padrões:

* **Result Pattern** na camada de aplicação para representar explicitamente sucesso ou falha nos casos de uso.
* **RestResult** na camada de API para padronizar respostas HTTP de sucesso e erro.
* **DTOs de Request/Response** para evitar exposição direta de entidades de domínio.
* **Mappers** para conversão entre Entidades e DTOs.

Esses padrões ajudam a manter o domínio isolado, melhorar a legibilidade do código e tornar o fluxo de erros previsível.

---

## ⚙️ Dependências

| Dependência                                             | Para que serve                                                         |
| ------------------------------------------------------- | ---------------------------------------------------------------------- |
| **Spring Boot Web** 🌐 (`spring-boot-starter-web`)      | Permite criar **endpoints REST** e construir a camada web da aplicação |
| **Spring Data JPA** 💾 (`spring-boot-starter-data-jpa`) | Facilita a **persistência de dados** usando JPA/Hibernate              |
| **Validation** ✅ (`spring-boot-starter-validation`)     | Adiciona **validações automáticas** em DTOs e entidades                |
| **Lombok** ✂️ (`lombok`)                                | Reduz **boilerplate code**                                             |
| **H2 Database** 🏗️ (`com.h2database:h2`)               | Banco de dados **em memória**                                          |
| **Spring Boot DevTools** 🔄 (`spring-boot-devtools`)    | **Hot reload**                                                         |
| **Swagger/OpenAPI** 📑 (`springdoc-openapi`)            | **Documentação automática da API**                                     |

---

Dependências opcionais para futuras evoluções:

| Dependência                                 | Para que serve                 |
| ------------------------------------------- | ------------------------------ |
| **PostgreSQL Driver** 🐘 (`org.postgresql`) | Banco relacional para produção |
| **MapStruct** 🔀 (`org.mapstruct`)          | Mapeamento DTO ↔ Entity        |
| **Spring Boot Actuator** 📊                 | Métricas e health checks       |
| **Spring Security** 🔒                      | Autenticação e autorização     |

---

## 🌐 Endpoints da API

| Método   | Endpoint             | Descrição                  |
| -------- | -------------------- | -------------------------- |
| `POST`   | `/api/clientes`      | Cria um cliente ➕          |
| `GET`    | `/api/clientes`      | Lista todos os clientes 📃 |
| `GET`    | `/api/clientes/{id}` | Busca cliente por ID 🔎    |
| `PUT`    | `/api/clientes/{id}` | Atualiza cliente ✏️        |
| `DELETE` | `/api/clientes/{id}` | Deleta cliente 🗑️         |

### 📌 Padrão de Resposta da API

Todos os endpoints retornam respostas padronizadas no seguinte formato:

#### ✔ Sucesso

```json
{
  "success": true,
  "data": {}
}
```

#### ❌ Erro

```json
{
  "success": false,
  "error": "Mensagem de erro"
}
```

Esse padrão garante consistência entre os endpoints e facilita o consumo da API por clientes frontend ou outros serviços.

---

## 📬 Teste da API com `curl`

Você pode criar um novo cliente utilizando o seguinte comando **`curl`**:

```bash
curl --location 'http://localhost:8080/api/clients' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Diego",
    "lastName": "Lins",
    "email": "diegofernandeslins@gmail.com",
    "phone": "11987549239"
}'
```

### 🔹 Exemplo de Resposta

```json
{
    "success": true,
    "data": {
        "id": 1,
        "firstName": "Diego",
        "lastName": "Lins",
        "email": "diegofernandeslins@gmail.com",
        "phone": "11987549239"
    }
}
```

### 🔹 Observações

* Certifique-se de que a API está rodando localmente em `http://localhost:8080`
* O endpoint para criação de clientes é `/api/clients`
* O cabeçalho `Content-Type` deve ser `application/json`
* Esse comando irá criar um **novo cliente** no banco de dados em memória (H2)

---

## 🚀 Como rodar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/DiegoLins10/clientapi.git
```

2. Entre na pasta do projeto:

```bash
cd clientapi
```

3. Compile e rode com Maven:

```bash
mvn clean install
mvn spring-boot:run
```

4. Acesse a API em:

```
http://localhost:8080/api/clientes
```

---

## 🛠 Tecnologias

* 🟢 **Java 25**
* 🌐 **Spring Boot 3.5.x**
* 💾 **H2 Database (in-memory)**
* ⚙️ **Maven**
* ✂️ **Lombok**
* 🏛️ **JPA/Hibernate**

---

## 🧪 Testes

O projeto possui **testes unitários** para os principais fluxos:

* Casos de uso testados com **JUnit 5** e **Mockito**
* Uso de **ArgumentCaptor** para validação de dados enviados ao repositório
* Testes focados em comportamento, não em implementação

Para executar os testes:

```bash
mvn test
```

---


## Documentação da API

### Como rodar o projeto

```bash
mvn clean install
mvn spring-boot:run
```

### URLs de documentação

- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- Swagger UI (atalho): `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

### Dependência adicionada

- `org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.13`

### Observações

- Porta padrão da aplicação: `8080`
- Perfil Spring: configuração padrão de `src/main/resources/application.properties` (sem perfil explícito)

### 🚀 Próximos Passos

* [x] 🎯 **Adicionar Result Pattern** para retorno consistente de sucesso ou falha nas operações.
* [x] 🌐 **Adicionar RestResult** para padronização das respostas HTTP da API.
* [x] 🔄 **Implementar middleware / interceptadores** para logs, tratamento de erros unificado e validações globais.
* [ ] 🏠 **Integrar API do ViaCEP** para preencher e validar endereços automaticamente ao criar ou atualizar clientes.
  Fonte: [ViaCEP - API](https://viacep.com.br/)
* [ ] 🔒 **Adicionar autenticação JWT** para proteger os endpoints da API.
* [x] 📑 **Documentar a API com Swagger / OpenAPI** para facilitar testes e integração com outros sistemas.
* [ ] 🐘 **Substituir H2 por PostgreSQL** ou outro banco relacional para persistência em produção.
* [ ] 🧪 **Adicionar testes de integração** que validem fluxos completos da API.
* [ ] ✅ **Adicionar validações avançadas de campos** como email, telefone e CPF.
* [ ] 🔀 **Implementar mapeamento DTO ↔ Entity com MapStruct** para reduzir boilerplate.
* [ ] 🔀 **Implementar uma autenticação de dois fatores para a confirmação do email.

### ***Indicadores de Conclusão***

* [ ] = tarefa pendente
* [x] = tarefa concluída

---

## 📖 Observações

* O projeto segue o **padrão Clean Architecture**, com camadas separadas para **domínio**, **aplicação**, **infraestrutura** e **interfaces**.
* Banco H2 é **volátil** (dados desaparecem ao parar a aplicação). Para produção, substituir por **PostgreSQL** ou outro banco relacional.
* Swagger/OpenAPI is implemented and available at `/swagger-ui/index.html` and `/v3/api-docs`; JWT authentication remains a future improvement.

---

✨ **by Diego Lins**

---

