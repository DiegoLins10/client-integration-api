Objetivo:
Adicionar Swagger (OpenAPI) na aplicação Java 25 e atualizar o README.
Seguir Git Flow corretamente criando uma branch de feature.

Contexto:
- Projeto backend Java 25
- Verificar se usa Maven ou Gradle antes de implementar
- Aplicação já funcional
- Utilizar Git Flow
- Não alterar regras de negócio existentes

Tarefas:

1) Git Flow

- Garantir que está na branch `main`
- Atualizar a `main` com a versão mais recente
- Criar uma nova branch seguindo Git Flow:

  feature/add-swagger-openapi

- Toda implementação deve ser feita nessa branch

2) Adicionar Swagger

- Identificar o framework utilizado (ex: Spring Boot)
- Se for Spring Boot:
    - Utilizar `springdoc-openapi`
    - Adicionar dependência compatível com a versão do Spring Boot
- Configurar Swagger UI
- Garantir que esteja acessível em:
    /swagger-ui.html ou /swagger-ui/index.html
- Garantir que o endpoint OpenAPI JSON esteja disponível

3) Garantias Técnicas

- Projeto deve compilar sem erros
- Aplicação deve subir normalmente
- Nenhum endpoint existente deve ser alterado ou removido
- Não modificar lógica de negócio

4) Atualizar README

Adicionar seção:

## Documentação da API

- Como rodar o projeto
- URL do Swagger UI
- URL do OpenAPI JSON
- Dependências adicionadas
- Observações (porta, perfil, etc.)

5) Commit

- Realizar commits organizados
- Seguir padrão de commit message:

  feat: add swagger (OpenAPI) documentation support

- Caso README seja commit separado:

  docs: update README with Swagger documentation section

Critérios de Aceite:

- Branch criada seguindo Git Flow
- Implementação isolada na branch de feature
- Swagger funcionando corretamente
- README atualizado
- Mensagens de commit padronizadas (Conventional Commits)
- Nenhuma alteração indevida na lógica existente

Importante:

- Não fazer merge direto na main
- Não remover código existente
- Seguir boas práticas de organização do projeto
- Manter padrão já utilizado no repositório
