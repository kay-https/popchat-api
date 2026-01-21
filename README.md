# 💬 PopChat API — Day 3/30

Projeto desenvolvido durante o desafio **#30DaysOfJavaWithKay** com foco em prática real de backend usando Java e Spring Boot.

A **PopChat API** é um chatbot simples onde usuários podem enviar mensagens, receber respostas automáticas do bot e manter o histórico salvo no banco de dados.

---

## 🚀 Funcionalidades

- Cadastro de usuários
- Envio de mensagens
- Respostas automáticas do bot
- Persistência no banco de dados
- Histórico de conversas por usuário

---

## 🛠️ Tecnologias

- Java 21  
- Spring Boot  
- Spring Data JPA  
- H2 Database  
- Lombok  
- Maven  

---

## 📌 Endpoints

### ➕ Criar usuário  
POST `/api/users`

```json
{
  "name": "Kay",
  "email": "kay@chat.com"
}
