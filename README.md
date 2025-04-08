# Atividade Strategy & Adapter

Este projeto demonstra o uso dos padrões **Strategy** e **Adapter** em uma API REST Spring Boot para cálculo de frete, com notificação via console.

---

## Tecnologias

- Java 21
- Spring Boot 3.7.7
- Maven

---

## Pré‑requisitos

- JDK 21 instalado
- Maven instalado

## Endpoints
GET /fretes
Calcula o valor do frete de acordo com o peso e a modalidade escolhida.

Query Parameters

Parâmetro	Tipo	 Obrigatório	Descrição
peso	    Double	    Sim	        Peso do pacote em kg.
modalidade	String	    Sim	        Modalidade de frete. Valores válidos (case‑insensitive): 
• Entrega economica
• Entrega expressa
• terceirizada

Resposta de Sucesso

Código: 200 OK

Corpo: valor numérico (double) representando o preço do frete.

Erros Comuns

400 Bad Request — se faltar peso ou modalidade, ou se a modalidade for inválida.



Exemplo de entrada e saída:

Frete Econômico

Entrada:

curl -X GET "http://localhost:8080/fretes?peso=5.0&modalidade=Entrega%20economica"

Resposta:

0.25

Notificação no console:

Frete calculado: R$0.25 para modalidade Entrega economica


## Arquitetura e Componentes

Controller

FreteController — expõe o endpoint /fretes.

Service

FreteService — orquestra as estratégias de cálculo e notificação.

Estratégias (FreteStrategy):

EntregaEconomica — 5% do peso.

EntregaExpressa — 20% do peso.

TransportadoraTercerizadaAdapter — adapta APIExternaTransportadora (peso × 7.5 + 15).

Notificadores (Notificador):

EmailNotificador — simula envio de e‑mail via System.out.println.

Adapter

TransportadoraTercerizadaAdapter — implementa FreteStrategy chamando a API externa.

