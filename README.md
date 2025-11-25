# 🧮 Cálculo de IMC — API com Spring Boot

Este projeto é uma API desenvolvida em **Spring Boot** para realizar o cálculo do **IMC (Índice de Massa Corporal)** e retornar a classificação de acordo com a tabela oficial da OMS.

---

## 🚀 Tecnologias utilizadas

- **Java 21**
- **Spring Boot 4**
- **Spring Web (Spring MVC)**
- **Maven**

---

## 📌 Objetivo

A API recebe **peso** e **altura** e retorna:

- IMC calculado
- Classificação:
  - Abaixo do peso
  - Peso normal
  - Sobrepeso
  - Obesidade I, II ou III

---

## 📡 Endpoints

### **POST /imc/calcular**

Calcula o IMC e retorna a classificação.

#### **📥 Exemplo de requisição**
```json
{
  "peso": 80,
  "altura": 1.75
}
_______________________________________________________________________________
📘 Tabela Oficial de IMC (OMS)

| Classificação      | IMC (kg/m²) |
| ------------------ | ----------- |
| Abaixo do peso     | < 18.5      |
| Peso normal        | 18.5 - 24.9 |
| Sobrepeso          | 25.0 - 29.9 |
| Obesidade Grau I   | 30.0 - 34.9 |
| Obesidade Grau II  | 35.0 - 39.9 |
| Obesidade Grau III | ≥ 40        |
