# language: pt
@accenture
Funcionalidade: Desafio Accenture - Realizar cadastro de seguro para um veículo

  Cenário: Acessar site e preencher todos os campos corretamente
    Dado que acesso o site do desafio
    E preencho os dados do veículo
    E preencho os dados pessoais
    E seleciono os dados do produto
    E seleciono um plano de seguro
    E preencho o orçamento
    Então quando enviado a resposta deverá ser "Sending e-mail success!"
