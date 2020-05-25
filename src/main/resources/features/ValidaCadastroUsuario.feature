#language:pt
#Author:wagnerdix@gmail.com

Funcionalidade: Validacao Cadastro de Usuario

  Cenário: Valida Cadatro com Sucesso
    Dado que o usuário está no site "https://automacaocombatista.herokuapp.com/home/index"
    E acessa o menu para cadastro 
    Entao preenche o formuário
    E valida a mensagem de sucesso 
    
  Cenário: Valida Funcionalidade Voltar
    Dado que o usuário está no site "https://automacaocombatista.herokuapp.com/home/index"
    E acessa o menu para cadastro 
    Entao preenche o formuário
    E clica no botao voltar
    E valida a pagina de retorno
    
   Cenário: Valida Campos Obrigatórios
    Dado que o usuário está no site "https://automacaocombatista.herokuapp.com/home/index"
    E acessa o menu para cadastro 
    Entao preenche o formulário exceto os campos obrigatorios
    E valida a mensagem de obrigatoriedade 
      