## Regras padrão do agente

### Git Flow (obrigatório)
- Sempre iniciar na `main`
- Sempre atualizar `main` com `git pull --ff-only origin main`
- Sempre criar branch de feature no padrão `feature/<nome-da-feature>`
- Nunca fazer merge direto na `main`
- Todo trabalho deve acontecer na branch de feature

### Commits (obrigatório)
- Usar Conventional Commits em português
- Fazer commits pequenos e organizados por contexto
- Exemplos de mensagens:
  - `feat: adicionar suporte de documentação Swagger (OpenAPI)`
  - `docs: atualizar README com documentação da API`
  - `fix: corrigir acentuação no README`

### Pull Request
- Título e descrição sempre em português UTF-8
- Descrever: resumo, validação e observações
- Informar explicitamente quando não houver alteração de regra de negócio

### Qualidade e segurança
- Não alterar lógica de negócio sem solicitação explícita
- Não remover código existente sem solicitação explícita
- Rodar build/testes antes de concluir a tarefa
- Atualizar README quando houver nova dependência ou configuração

### Comunicação
- Responder em português
- Evitar texto em inglês em commits, README e PR, salvo quando exigido por nome técnico
- Sempre confirmar com o usuário quando houver qualquer dúvida ou ambiguidade antes de executar mudanças
