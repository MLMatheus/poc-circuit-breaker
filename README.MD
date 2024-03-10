# Circuit Breaker
## O que é?
Circuit Breaker é um padrão de projeto usado para melhorar a resiliência e a estabilidade em sistemas distribuídos.
Este padrão atua como um disjuntor em um circuito. Ao detectar uma falha, como uma chamada a uma API externa, o circuito é aberto, fazendo que novas chamadas ao serviço sejam interrompidas, afim de evitar sobrecarga ao serviço com falha e a propagação do problema para outros sistemas.
Depois de um determinado tempo, são feitas tentativas para que novas conexões sejam estabelecidas, isso chamamos de "estado semiaberto do circuito".
Caso essas tentativas tenham sucesso, o circuito vai para o estado fechado, executando todo o fluxo normal da aplicação. Caso a falha continue, o circuito volta para o estado aberto.
Ainda, o Circuit Breaker pode trazer uma melhor experiência para o usuário, já que enquanto está aberto, poderá devolver uma resposta personalizada, fazendo muitas vezes que o usuário não perceba a falha, e ainda enviar a solicitação para uma fila de reprocessamento, para que esta seja concluída quando o circuito ficar fechado novamente.

## Executando o projeto
Tendo o Docker Desktop em seu Windows, ou Docker + Docker Compose em sua distribuição Linux, execute o comando a baixo para construir as imagens e os containers das aplicações

```bach
    docker-compose up
    #WSL
    docker compose up
```

## Testando a aplicação
Para testar a aplicação, basta criar uma request usando algum client de sua preferência, com base no arquivo [requests](requests.http)
Estas requests podem ser executadas sem ennhuma alteração, usando a extensão [Rest Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client) no [VS Code](https://code.visualstudio.com/download).

## Coletando métricas
Para coletar as métricas do Circuit Breaker, você pode usar a request GET disponível. Para filtrar por uma métrica específica, use o endpoint a baixo:

```text
    /actuator/metrics/metric.name
```