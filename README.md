# 📩 Microsserviço de envio de email
Projeto de estudo de microsserviços em Java, baseado no vídeo da Michelli Brito [Microsserviços na prática com Java Spring](https://www.youtube.com/watch?v=ZnECi2gatMs&t=4335s).

Esse microsserviço envia email para os usuários que se cadastram na aplicação, utilizando RabbitMQ para consumir mensagens da fila do Broker, publicadas pelo [Microsserviço de Usuários](https://github.com/yurioneix/microservices-java-user).

## Instalação e configuração
- Baixe o repositório na sua máquina:
```bash
  git clone git@github.com:yurioneix/microservices-java-email.git
```

- Abra sua IDE no repositório baixado

- Insira as variáveis de ambiente no application.properties.
  - Insira os mesmos dados de login do Postgre.
  - Insira os mesmos dados do RabbitMQ.
  - Cadastre uma [senha de aplicação do Google](https://support.google.com/accounts/answer/185833), sendo necessário haver a autentição de dois fatores na conta do Gmail utilizada, a fim de obter a senha. 
- Inicie a aplicação e comece consumir as mensagens da fila.
