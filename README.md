📘 Cálculo de IMC – Spring Boot

Aplicação REST API em Spring Boot para calcular o IMC (Índice de Massa Corporal) a partir do peso e da altura informados.
O sistema também retorna um identificador incremental e organiza os dados em um objeto DTO.

📌 Funcionalidade Principal

O endpoint /dados recebe:
peso (kg)
altura (m)

E retorna:
ID
altura
peso
imc (com duas casas decimais)

📐 Cálculo do IMC

A fórmula utilizada é:
IMC = peso / (altura * altura)

Exemplo:
peso = 78

altura = 1.72

IMC = 26.38

🚀 Endpoint
GET /dados

Exemplo de requisição:
http://localhost:8080/dados?peso=78&altura=1.72

Resposta JSON:
{
  "id": 1,
  
  "altura": 1.72,
  
  "peso": 78.0,
  
  "imc": 26.38
}

🛠️ Tecnologias Utilizadas:
Java 17+

Spring Boot 3+

Spring Web

Maven


🙋‍♂️ Autor
Alisson Moura

Desenvolvedor Java • Spring Boot • APIs REST

🔗 GitHub: https://github.com/moura92
