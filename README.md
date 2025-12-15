# 🚀 ClientAPI – Aplicação de Gerenciamento de Clientes

![Java](https://img.shields.io/badge/Java-25-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.x-green?logo=spring)
![Maven](https://img.shields.io/badge/Maven-3.9.6-red?logo=apache-maven)
![H2 Database](https://img.shields.io/badge/H2%20DB-in%20memory-orange)

API para gerenciamento de clientes utilizando **Clean Architecture**, **DDD** e **Result Pattern**, desenvolvida em **Java 25** com **Spring Boot 3.5.x**.
O projeto utiliza **H2 em memória** para facilitar desenvolvimento e testes locais.

---

## 📦 Estrutura do Projeto

O projeto segue **Clean Architecture**, com responsabilidades bem definidas:

```text
com.github.diegolins10.clientapi
├── api
│   ├── controllers      # Controllers REST
│   ├── dto              # DTOs de Request / Response
│   ├── mappers          # Mappers API (Entity → Response)
│   └── responses        # RestResult (contrato HTTP)
│
├── application
│   ├── usecases         # Casos de uso (Result Pattern)
│   └── common           # Result Pattern
│
├── domain
│   ├── entities         # Entidades de domínio
│   └── repositories    # Interfaces de repositório
│
└── infrastructure
    └── persistence     # Implementações JPA / configs
```

---

## ⚙️ Dependências

| Dependência              | Descrição                      |
| ------------------------ | ------------------------------ |
| **Spring Boot Web**      | Criação de endpoints REST      |
| **Spring Data JPA**      | Persistência com JPA/Hibernate |
| **Validation**           | Validações automáticas em DTOs |
| **Lombok**               | Redução de boilerplate         |
| **H2 Database**          | Banco em memória (dev/test)    |
| **Spring Boot DevTools** | Hot reload                     |
| **Springdoc OpenAPI**    | Documentação automática        |

---

## 🧠 Padrões Utilizados

### ✔ Clean Architecture

* API não conhece domínio
* UseCases não conhecem HTTP
* Domínio isolado

### ✔ Result Pattern

Usado nos **UseCases** para retorno explícito de sucesso ou falha:

```java
Result.success(data)
Result.failure("Mensagem de erro")
```

### ✔ RestResult

Usado na **API** para padronizar respostas HTTP:

```json
{
  "success": true,
  "data": { ... }
}
```

---

## 🌐 Endpoints da API

> Base URL: `http://localhost:8080/api/clients`

| Método | Endpoint       | Descrição               |
| ------ | -------------- | ----------------------- |
| `POST` | `/api/clients` | Cria um cliente         |
| `GET`  | `/api/clients` | Lista todos os clientes |

---

## 📬 Exemplo – Criar Cliente (`curl`)

```bash
curl --location 'http://localhost:8080/api/clients' \
--header 'Content-Type: application/json' \
--data-raw '{
  "firstName": "Diego",
  "lastName": "Lins",
  "email": "diego@email.com",
  "phone": "11987549239",
  "cep": "08132470"
}'
```

### 🔹 Resposta

```json
{
  "success": true,
  "data": {
    "id": 1,
    "firstName": "Diego",
    "lastName": "Lins",
    "email": "diego@email.com",
    "phone": "11987549239",
    "cep": "08132470"
  }
}
```

---

## 🧪 Testes

O projeto possui **testes unitários** para:

* ✔ UseCases (com Mockito + ArgumentCaptor)
* ✔ Controllers (mockando UseCases)
* ✔ Validação de Result Pattern

### Executar testes

```bash
mvn test
```

---

## 🚀 Como rodar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/DiegoLins10/clientapi.git
```

2. Entre no projeto:

```bash
cd clientapi
```

3. Compile e execute:

```bash
mvn clean install
mvn spring-boot:run
```

4. Acesse:

```text
http://localhost:8080/api/clients
```

---

## 🛠 Tecnologias

* 🟢 **Java 25**
* 🌱 **Spring Boot 3.5.x**
* 💾 **H2 (in-memory)**
* ⚙️ **Maven**
* ✂️ **Lombok**
* 🏛️ **JPA / Hibernate**
* 🧪 **JUnit 5 + Mockito**

---

## 🚀 Próximos Passos

* [x] ✅ Result Pattern
* [x] ✅ RestResult
* [x] ✅ Clean Architecture
* [x] ✅ Testes unitários
* [ ] 🔌 Integração com ViaCEP
* [ ] 🔒 Autenticação JWT
* [ ] 🐘 PostgreSQL (produção)
* [ ] 📑 Swagger UI customizado
* [ ] 🧪 Testes de integração
* [ ] 🔀 MapStruct

---

## 📖 Observações

* Entidades **não são expostas** na API
* DTOs de Request/Response ficam na camada **API**
* UseCases retornam apenas **Result**
* Tratamento de erro é previsível e explícito

---

✨ **by Diego Lins**

---

Se quiser, no próximo passo posso:

* montar um **diagrama de arquitetura**
* ajustar o README para **portfólio**
* ou deixar ele **mais “enterprise”** (padrão Itaú/IBM 😄)
