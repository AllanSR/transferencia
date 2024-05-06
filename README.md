
# Transferencias

Projeto teste para a avaliação Java




## Deploy

Para fazer o deploy desse projeto rode

```bash
  mvn clean install -U
```


## Demonstração

segue um objeto para teste de inserção de Transferência

{
  "accountTarget": "1212121212",
  "accountOrigin": "3434343434",
  "transferValue": 1000,
  "schedulingDate": "2024-05-07" 
}


No campo "schedulingDate" colocar, pelo menos, data atual. 
Coloquei como Regra de Negócio impedir o agendamento de uma data anterior a atual

