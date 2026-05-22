# BuySystem
# BuySystem - Sistema de Gestão de Vendas em Java

## Descrição

O BuySystem é um sistema simples de gestão de vendas desenvolvido em Java utilizando Programação Orientada a Objetos (POO).  
O projeto simula o funcionamento básico de uma loja, permitindo gerir produtos, clientes, pedidos e histórico de compras.

O objetivo principal é praticar conceitos fundamentais de POO e estruturação de aplicações em Java.

---

## Funcionalidades

- Adicionar produtos  
- Adicionar clientes  
- Realizar pedidos  
- Gestão automática de stock  
- Listar produtos  
- Listar clientes  
- Histórico de pedidos  
- Geração de fatura simples  

---

## Estrutura do Projeto

### Produto
Representa um produto da loja.

- Nome  
- Preço  
- Stock  
- Métodos para adicionar e remover stock  

---

### Cliente
Representa um cliente.

- Nome  
- ID  

---

### ProdutoPedido
Representa um produto dentro de um pedido.

- Produto associado  
- Quantidade  
- Preço unitário fixado no momento do pedido  
- Cálculo de subtotal  
- Método `toString` para formatação  

---

### Pedido
Representa uma compra realizada por um cliente.

- Cliente associado  
- Lista de ProdutoPedido  
- Cálculo do total da fatura  
- Remoção automática de stock  
- Impressão da fatura  

---

### Main
Interface em consola com menu interativo.

- Gestão de produtos  
- Gestão de clientes  
- Criação de pedidos  
- Visualização de histórico  
- Atualização de stock  

---

## Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos
- ArrayList
- Aplicação em linha de comando (CLI)

---

## Conceitos Aplicados

- Encapsulamento  
- Associação entre classes  
- Separação de responsabilidades  
- Estruturas de dados dinâmicas  
- Modularização de código  

