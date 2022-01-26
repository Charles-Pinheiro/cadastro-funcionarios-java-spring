# API para Cadastro de Funcionários


##### Tecnologias Utilizadas:
Java Spring Boot
Postgres


## Endpoints:

#### GET: localhost:8080/api/funcionarios
Retorna lista com todos os funcionários registrados:

    [
	    {
		    "id": 1,
		    "nome": "Alan Maggi",
		    "cargo": "CEO",
		    "idade": 25,
		    "salario": 30000.00,
		    "imgURL": "url_teste"
	    },
      {
		    "id": 2,
		    "nome": "Rodrigo Ferraz",
		    "cargo": "Dev Jr Nv.3",
		    "idade": 21,
		    "salario": 4000.00,
		    "imgURL": "url_teste"
      },
	    {
		    "id": 3,
		    "nome": "Igor Ribeiro",
		    "cargo": "Dev Jr Nv.1",
		    "idade": 22,
		    "salario": 3500.00,
		    "imgURL": "url_teste"
	    },
	    {
		    "id": 4,
		    "nome": "Luis Gustavo",
		    "cargo": "Tech Leader",
		    "idade": 25,
		    "salario": 11000.00,
		    "imgURL": "url_teste"
	    },
	    {
		    "id": 5,
		    "nome": "Gustavo Pinto",
		    "cargo": "Tech Leader",
		    "idade": 25,
		    "salario": 11000.00,
		    "imgURL": "url_teste"
	    },
	    {
		    "id": 6,
		    "nome": "Charles Pinheiro",
		    "cargo": "Dev Jr Nv.1",
		    "idade": 25,
		    "salario": 3500.00,
		    "imgURL": "url_teste"
	    }
    ]

#### GET: localhost:8080/api/funcionarios/:id
Retorna o funcionário com id correspondente.

    {
	    "id": 1,
	    "nome": "Alan Maggi",
	    "cargo": "CEO",
	    "idade": 25,
	    "salario": 30000.00,
	    "imgURL": "url_teste"
    }
Caso não tenha nenhum funcionário com o id pesquisado, retorna status 404(Not found)

#### POST: localhost:8080/api/funcionarios
Registra um novo funcionário, e retorna esse funcionário.

REQUEST:

    {
	    "nome": "Charles",
	    "cargo": "Dev Jr",
	    "idade": 25,
	    "salario": 3500.00,
	    "imgURL": "url_teste"
    }

RESPONSE:

    {
	    "id": 9,
	    "nome": "Charles",
	    "cargo": "Dev Jr",
	    "idade": 25,
	    "salario": 3500.00,
	    "imgURL": "url_teste"
    }
Caso algum campo não seja fornecido, retorna status 400(Bad Request)

#### PUT: localhost:8080/api/funcionarios/:id
Faz a atualização dos dados do funcionário com o id especificado na rota.

REQUEST:

      {
	      "nome": "Funcionário Atualizado",
	      "cargo": "Tester",
	      "idade": 25,
	      "salario": 3100.00,
	      "imgURL": "url_teste"
      }

RESPONSE:

    {
	    "id": 5,
	    "nome": "Funcionário Atualizado",
	    "cargo": "Tester",
	    "idade": 25,
	    "salario": 3100.00,
	    "imgURL": "url_teste"
    }
  Caso algum campo não seja fornecido, retorna status 400(Bad Request)

#### DELETE: localhost:8080/api/funcionarios/:id
Exclui o funcionário com o id especificado na rota e retorna status 204(No content)
