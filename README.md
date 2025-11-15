Análise de Código: Complexidade Ciclomática (Classe User)

Este repositório contém o código e a documentação técnica referente à análise de teste de caixa branca estática e métricas de complexidade do método `verificarUsuario`.

---

## 1. Métrica de Complexidade Ciclomática (V(G))

A análise foi focada no método **`verificarUsuario(String login, String senha)`**.

### Cálculo Ciclomático

O cálculo foi baseado no número de pontos de decisão (predicados) encontrados no fluxo do método.

* **Número de Predicados (P):** 2
    * O bloco `try/catch`
    * A estrutura `if (rs.next())`

* **Fórmula:** V(G) = P + 1
* **Resultado:** V(G) = 2 + 1 = **3**

**Conclusão:** A Complexidade Ciclomática é 3. Isso exige um mínimo de 3 testes para garantir a cobertura total das decisões.

---

## 2. Caminhos Básicos para Teste

Estes são os 3 caminhos de execução independentes que devem ser testados:

1.  **Caminho 1 (Sucesso e Match):** Fluxo que executa o `try` e entra no `if` (Usuário Válido).
2.  **Caminho 2 (Sucesso e No Match):** Fluxo que executa o `try`, mas pula o `if` (Usuário Inválido).
3.  **Caminho 3 (Falha/Exceção):** Fluxo que desvia para o bloco `catch` (Erro de Conexão ou SQL).

---

## 3. Anotação do Grafo de Fluxo

Esta é a lista dos elementos que formam o fluxo de controle do método:

* **Nós (N):** 12 (De N1 a N12)
* **Arestas (E):** 13
* **Nós de Decisão (Predicados):** N5 (`try`) e N8 (`if`)

---

## 4. Anexos do Projeto

* **Anexo 1 - Código Comentado:** Arquivo `User.java` com a marcação dos Nós (N1, N2, etc.).
* **Anexo 3 - Planilha de Teste de Caixa Branca:** Documento com a análise estática (falhas de documentação, NPE, etc.).
