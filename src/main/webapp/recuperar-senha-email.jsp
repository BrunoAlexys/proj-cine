<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>	
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/recuperar-senha-email.css">
  <title>Redefinir Senha</title>
</head>
<body>

<div class="container" id="container">
  <div class="form-container sign-in-container">
    <form action="cine?action=RecuperarSenhaBean" method="post" id="resetForm">
      <h1>Informe seu Email</h1>
      <span>Esqueceu a senha?</span>
      <input type="email" id="emailInput" name="email" placeholder="Email" required="required"/>
      <a href="cine?action=LoginFormBean">Voltar</a>
      <button type="submit">Enviar</button>
    </form>
  </div>
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-right">
        <h1>Esqueceu sua senha?</h1>
        <p>
          Sem problemas! Nós encaminharemos um e-mail com as instruções para
          que você possa redefinir sua senha.
        </p>
      </div>
    </div>
  </div>
</div>

<script src="js/recuperar-senha-email.js"></script>
</body>
</html>
