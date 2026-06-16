# Banco Java Simples
# 🏦 Banco Simples no Terminal

Um sistema bancário simples rodando no terminal feito em Java. Dá pra criar contas, depositar, sacar, ver saldo e consultar extrato.

## 🚀 Como rodar

```bash
javac Banco.java
java Banco
```

## 🔧 Funcionalidades

- **Criar conta** — cadastra um novo titular
- **Depositar** — adiciona saldo na conta
- **Sacar** — retira saldo (valida se tem saldo suficiente)
- **Ver saldo** — mostra o saldo atual
- **Ver extrato** — lista todas as movimentações

## 📌 Exemplo

```
=== Banco ===
1. Criar conta
2. Depositar
...
Escolha: 2

Titular: João
Valor: R$ 500
Depósito realizado! Saldo: R$ 500.0
```

## 🧠 Conceitos praticados

- `boolean` — controla o loop do menu
- `while` — mantém o programa rodando
- `double` — valores monetários
- Arrays paralelos — titulares, saldos e extratos
- Métodos — cada funcionalidade separada
- `equalsIgnoreCase()` — comparação de Strings
- Validações — saldo insuficiente, conta inexistente, valor inválido
