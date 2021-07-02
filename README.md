# Aula 3 - Introdução a MVC e Injeção de Dependências - TM

## Exercício 1 - Restaurante

Este repositório contém a melhoria da api de restaurante presente no repositório: https://github.com/mtocura/btcp-spring-gestao-clientes

- POST ```` /aula3/tt/clientes ````
    - cria um cliente no sistema
    - body request:
    ```` 
    {
        "nome": "Usuário Mock",
        "cpf": "99864598007",
        "email": "mock@teste.com.br",
        "telefone": "11912345678",
        "pedidos": [
            {
                "produtos": [
                    {
                        "descricao": "PS5",
                        "cor": "branco",
                        "quantidade": 1,
                        "preco": 4999.99
                    },
                    {
                        "descricao": "Nintendo Switch",
                        "cor": "cinza",
                        "quantidade": 1,
                        "preco": 2999.99
                    }
                ]
            },
            {
                "produtos": [
                    {
                        "descricao": "Mouse Logitech G403",
                        "cor": "preto",
                        "quantidade": 1,
                        "preco": 239.99
                    },
                    {
                        "descricao": "Teclado Mecânico Redragon Surara Pro",
                        "cor": "preto",
                        "quantidade": 1,
                        "preco": 259.99
                    }
                ]
            }
        ]
    }
    ````
    - retorno de onde foi criado no header


- GET ```` /aula3/tt/clientes ````
    - retorna uma lista com todos os clientes e seus pedidos
    - body response:
    `````
    [
        {
            "nome": "Usuário Mock",
            "cpf": "99864598007",
            "email": "mock@teste.com.br",
            "telefone": "11912345678",
            "pedidos": [
                {
                    "data": "2/7/2021",
                    "produtos": [
                        {
                            "descricao": "PS5",
                            "cor": "branco",
                            "quantidade": 1,
                            "preco": 4999.99
                        },
                        {
                            "descricao": "Nintendo Switch",
                            "cor": "cinza",
                            "quantidade": 1,
                            "preco": 2999.99
                        }
                    ],
                    "total": 7999.98
                },
                {
                    "data": "2/7/2021",
                    "produtos": [
                        {
                            "descricao": "Mouse Logitech G403",
                            "cor": "preto",
                            "quantidade": 1,
                            "preco": 239.99
                        },
                        {
                            "descricao": "Teclado Mecânico Redragon Surara Pro",
                            "cor": "preto",
                            "quantidade": 1,
                            "preco": 259.99
                        }
                    ],
                    "total": 499.98
                }
            ]
        },
    }
    `````

- GET ```` /aula3/tt/clientes/{id} ````
    - retorna todos os pedidos de um cliente através de seu cpf
    - body response:
    ````
    [
        {
            "data": "2/7/2021",
            "produtos": [
                {
                    "descricao": "PS5",
                    "cor": "branco",
                    "quantidade": 1,
                    "preco": 4999.99
                },
                {
                    "descricao": "Nintendo Switch",
                    "cor": "cinza",
                    "quantidade": 1,
                    "preco": 2999.99
                }
            ],
            "total": 7999.98
        },
        {
            "data": "2/7/2021",
            "produtos": [
                {
                    "descricao": "Notebook Acer Nitro 5",
                    "cor": "preto",
                    "quantidade": 1,
                    "preco": 2999.99
                },
                {
                    "descricao": "Teclado Mecânico Redragon Surara Pro",
                    "cor": "preto",
                    "quantidade": 1,
                    "preco": 259.99
                }
            ],
            "total": 3259.9799999999996
        },
        {
            "data": "2/7/2021",
            "produtos": [
                {
                    "descricao": "MacBook Pro",
                    "cor": "preto",
                    "quantidade": 1,
                    "preco": 29999.99
                },
                {
                    "descricao": "Teclado Mecânico Redragon Surara Pro",
                    "cor": "preto",
                    "quantidade": 1,
                    "preco": 259.99
                }
            ],
            "total": 30259.980000000003
        }
    ]
    ````
  
- GET ```` /aula3/tt/clientes/{dia}/{mes}/{ano} ````
    - retorna todos os pedidos registrados em um determinado dia
    - body response:
    ````
    [
        {
            "data": "2/7/2021",
            "produtos": [
                {
                    "descricao": "PS5",
                    "cor": "branco",
                    "quantidade": 1,
                    "preco": 4999.99
                },
                {
                    "descricao": "Nintendo Switch",
                    "cor": "cinza",
                    "quantidade": 1,
                    "preco": 2999.99
                }
            ],
            "total": 7999.98
        },
    ]
    ````
  
- PUT ```` /aula3/tt/{id} ````
    - atualiza o registro de pedidos de algum cliente
    - body request:
    ````
    {
        "nome": "Usuário Mock",
        "cpf": "99864598007",
        "email": "mock@teste.com.br",
        "telefone": "11912345678",
        "pedidos": [
            {
                "produtos": [
                    {
                        "descricao": "PS5",
                        "cor": "branco",
                        "quantidade": 1,
                        "preco": 4999.99
                    },
                    {
                        "descricao": "Nintendo Switch",
                        "cor": "cinza",
                        "quantidade": 1,
                        "preco": 2999.99
                    }
                ]
            }
        ]
    }
    ````
  
- DELETE ```` /aula3/tt/{id} ````
    - deleta o registro de algum usuário
    - se for deletado com sucesso o usuário deletado é retornado no body
    - body response:
    ```
    {
        "nome": "Usuário Mock",
        "cpf": "99864598007",
        "email": "mock@teste.com.br",
        "telefone": "11912345678",
        "pedidos": [
            {
                "data": "2/7/2021",
                "produtos": [
                    {
                        "descricao": "PS5",
                        "cor": "branco",
                        "quantidade": 1,
                        "preco": 4999.99
                    },
                    {
                        "descricao": "Nintendo Switch",
                        "cor": "cinza",
                        "quantidade": 1,
                        "preco": 2999.99
                    }
                ],
                "total": 7999.98
            },
            {
                "data": "2/7/2021",
                "produtos": [
                    {
                        "descricao": "Notebook Acer Nitro 5",
                        "cor": "preto",
                        "quantidade": 1,
                        "preco": 2999.99
                    },
                    {
                        "descricao": "Teclado Mecânico Redragon Surara Pro",
                        "cor": "preto",
                        "quantidade": 1,
                        "preco": 259.99
                    }
                ],
                "total": 3259.9799999999996
            },
            {
                "data": "2/7/2021",
                "produtos": [
                    {
                        "descricao": "MacBook Pro",
                        "cor": "preto",
                        "quantidade": 1,
                        "preco": 29999.99
                    },
                    {
                        "descricao": "Teclado Mecânico Redragon Surara Pro",
                        "cor": "preto",
                        "quantidade": 1,
                        "preco": 259.99
                    }
                ],
                "total": 30259.980000000003
            }
        ]
    }
    ```