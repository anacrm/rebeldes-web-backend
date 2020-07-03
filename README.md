# rebeldes-web-backend

## Descrição

Projeto para avaliação técnica.

Descrição do problema: https://gitlab.com/phoebus/backend-java-test

## Instalação

Pré-requisitos:

- Java
- Gradle

Clone o repositório e execute a build pelo Gradle:
```
git clone https://github.com/anacrm/rebeldes-web-backend.git
cd rebeldes-web-backend
gradle build
```
## Uso 

Para iniciar a aplicação:
```
java -jar ./build/libs/rebeldes-web-backend-1.0
```
## Endpoints

Coleção Postman: https://www.getpostman.com/collections/c3f2c04af8a631c4eb9b

#### POST /api/rebel
Cria um rebelde
```
{
   "name" : "Joaquin Phoenix",
   "age": 45,
   "gender": "M",
   "location": {
       "latitude":52.58,
       "longitude":25.68,
       "name":"SpaceX Base III"
   },
    "inventory": {
       "weapons": 2,
       "ammo":36,
       "water": 8,
       "food": 13
   }
}
```

#### PUT /api/rebel/{idRebelde}/location
Atualiza a localização do Rebelde com id == idRebelde
```
{
    "latitude": 47.58,
    "longitude": 11.68,
    "name": "Jupiter moon Europa"
}
```

#### PUT /api/rebel/{idRebelde}/report
Denuncia como traidor o Rebelde com id == idRebelde


#### PUT /api/negotiate
Realiza troca de itens entre dois Rebeldes

```
{
   "buyerId" : 1,
   "buyerOffer": {
       "weapons": 2,
       "ammo":4,
       "water": 0,
       "food": 0
   },
   "sellerId" : 2,
   "sellerOffer": {
       "weapons": 0,
       "ammo":0,
       "water": 5,
       "food": 10
   }
}
```

#### GET /api/completeReport

Retorna um relatório completo com informações sobre a resistência

#### GET /api/completeReport

Retorna os Rebeldes (traidores ou não) cadastrados no sistema










