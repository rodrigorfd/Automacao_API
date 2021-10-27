# Observações
### Desafio de Automação de APIs

- No teste que o 'header' de uma solicitação é invalido a API retorna 500, o 'statusCode' esperado é 418,
ja que o erro é por falta de um parâmetro válido da api e não um problema de servidor. 

- A API retorna 403 ao solicitar alteração em uma reserva sem um token ou com token inválido, um retorno adequado
ja que caso a solicitação fosse cumprida resultaria numa falha de segurança.

- Notei que a ide não retorna parametros, que não estejam pre-definidos na documentação, na hora de criar uma 
nova reserva.

- A API retorna 405 ao tentar alterar uma reserva que não existe.

- A API retorna 403 ao tentar alterar uma reserva com o parâmetro 'Basic Auth' ou com um 'token' inválido, porem 
com um 'token' válido o teste passa, então concluo que o 'Basic Auth' informado na documentação está incorreto.

- No teste em que o objetivo é validar o retorno 500 de uma solicitação com 'Payload' inválido, eu defini o 
StatusCode(500), pois se o teste passar eu sei mesmo sem consultar que o retorno está sendo o esperado.

- A API retorna 500 quando feita uma solicitação com filtro mal formatado.