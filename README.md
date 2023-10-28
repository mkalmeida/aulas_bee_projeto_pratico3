# Projeto de Exemplo de Gestão de Produtos 📦

Este é um projeto de exemplo de gestão de produtos que permite criar e salvar produtos do tipo "Água" 💧 ou "Refrigerante" 🥤 no MongoDB 🍃 e demonstra como utilizar o RabbitMQ 🐰 para comunicação assíncrona.

## Pré-requisitos 🛠️

Antes de começar, certifique-se de que você possui os seguintes pré-requisitos instalados em seu sistema:

- Java ☕
- Spring Boot 🚀
- MongoDB 🏦
- RabbitMQ 🐇

#### Execução do Projeto 🏃

Para executar o projeto, você pode usar o Apache Maven. Antes de tudo, certifique-se de estar no diretório raiz do projeto (onde o arquivo `pom.xml` está localizado). Execute os seguintes comandos:

**Limpar e Compilar o Projeto (Ignorando Testes) 🧹**

```bash
mvn clean install -DskipTests
```
Isso irá compilar o projeto, ignorando os testes.

#### Inicializando os Containers 🐳
Para facilitar o uso do MongoDB e RabbitMQ, utilizamos scripts para iniciar e parar os containers. Você pode usar os seguintes comandos para gerenciar os containers:

1. Inicialize os Containers 🚀

Execute o script ./createContainers.sh localizado na pasta env. Esse script iniciará os containers do MongoDB e RabbitMQ em segundo plano.

```bash
./createContainers.sh
```

2. Encerre os Containers 🛑

Após o uso do projeto, você pode parar os containers usando o script ./destroyContainers.sh. Basta rodar o comando:

```bash
./destroyContainers.sh
```
Lembre-se de que, na primeira execução desses scripts, pode ser necessário torná-los executáveis com o comando chmod +x.
Exemplo:
```bash
chmod +x destroyContainers.sh
```
#### Uso 🚀
O aplicativo permite criar e salvar produtos do tipo "Água" 💧 ou "Refrigerante" 🥤 no MongoDB 🍃 e utiliza o RabbitMQ 🐇 para comunicação assíncrona.

###### Criar um Produto 🛍️
Para criar um produto, você pode enviar uma solicitação POST para o endpoint /api/produto com um JSON no corpo da solicitação. Aqui estão exemplos de JSON para criar um produto "Água" ou "Refrigerante":

###### Exemplo de JSON para criar um produto "Água" 💧:

```json
curl -X POST -H "Content-Type: application/json" -d '{
  "tipo": "Agua",
  "descricao": "Minalba",
  "preco": 1.99,
  "comGas": false
}' http://localhost:8080/api/produtos
```

###### Exemplo de JSON para criar um produto "Refrigerante" 🥤:

```json
curl -X POST -H "Content-Type: application/json" -d '{
  "tipo": "Refrigerante",
  "descricao": "Coca Cola",
  "preco": 2.49,
  "comAcucar": true
}' http://localhost:8080/api/produtos```

Os dados serão salvos no MongoDB e uma mensagem será enviada pelo RabbitMQ, que já está configurado com autoack. Para visualizar as mensagens, será necessário desligar o consumer.

Observação
O atributo "tipo" não faz parte das classes de produtos (Água ou Refrigerante) e é um parâmetro criado no momento da ingestão de dados. Ele permite que os produtos do tipo "Água" 💧 e "Refrigerante" 🥤 sejam salvos em suas respectivas collections no MongoDB 🍃.



