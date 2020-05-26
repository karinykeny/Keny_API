# API Transportadora [![Build Status](https://travis-ci.com/karinykeny/Transportadora_API.svg?branch=master)(https://travis-ci.com/karinykeny/Transportadora_API)

> Projeto API transportadora para Praxio

##### Criar uma transportadora

> Headers: Content-Type: application/json
> URI: http://localhost:8080/transportadoras
> Method: POST
> Body:

```json
{
  "id": 1,
  "cnpj": "61189288000189",
  "email": "testeteste@gmail.com",
  "nome": "Teste1",
  "empresa": "Empresa Test1",
  "telefone": "81996999999",
  "modal": "AEREO",
  "rua": "Rua teste1",
  "numero": 1,
  "bairro": "teste1",
  "cidade": "teste1",
  "uf": "PE",
  "cep": "50000000"
}
```

- Response:

> Status Code: 201

##### Obter uma transportadora

> URI: http://localhost:8080/transportadoras/1
> Method: GET

- Response:

> Status Code: 200

##### Alterar uma transportadora

> Headers: Content-Type: application/json
> URI: http://localhost:8080/transportadoras
> Method: PUT
> Body:

```json
{
  "id": 1,
  "cnpj": "61189288000189",
  "email": "testeteste@gmail.com",
  "nome": "Teste1",
  "empresa": "Empresa Test1",
  "telefone": "81996999999",
  "modal": "AEREO",
  "rua": "Rua teste1",
  "numero": 1,
  "bairro": "teste1",
  "cidade": "teste1",
  "uf": "PE",
  "cep": "50000000"
}
```

- Response:

> Status Code: 200

##### Excluir uma transportadora

> URI: http://localhost:8080/transportadoras/2
> Method: DELETE

- Response:

> Status Code: 204

##### Listar transportadoras

> URI: http://localhost:8080/transportadoras
> Method: GET

- Response:

> Status Code: 200

##### Filtra transportadoras por multiplos parâmetros

> URI: http://localhost:8080/transportadoras?filter&nome=teste5&uf=SP
> Method: GET

- Response:

> Status Code: 200
