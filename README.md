# API Transportadora

> Projeto API transportadora para Praxio

##### Criar uma transportadora

> Headers: Content-Type: application/json
> URI: http://localhost:8080/transportadoras
> Method: POST
> Body: 

```json
{
    "id": 2,
    "cnpj": "59291534000167",
    "email": "karinykeny@gmail.com",
    "nome": "Kariny Keny",
    "empresa": "Empresa Kariny",
    "telefone": "81996912471",
    "modal": "AEREO",
    "rua": "Rua da Laareira",
    "numero": 66,
    "bairro": "Rio Doce",
    "cidade": "Olinda",
    "uf": "PE",
    "cep": "53080310"
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
    "id": 2,
    "cnpj": "59291534000167",
    "email": "keny2050@gmail.com",
    "nome": "Kariny Keny",
    "empresa": "Empresa Kariny",
    "telefone": "81996912471",
    "modal": "AEREO",
    "rua": "Rua da Laareira",
    "numero": 66,
    "bairro": "Rio Doce",
    "cidade": "Olinda",
    "uf": "PE",
    "cep": "53080310"
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