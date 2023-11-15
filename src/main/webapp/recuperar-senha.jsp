<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/recuperar-senha.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container" id="container">
      <div class="form-container sign-in-container">
        <form action="#" method="post" id="resetForm">
          <h1>Redefinir senha</h1>

          <label for="password">Nova senha</label>
          <input type="password" id="newPassword" placeholder="Password" required="required"/>
          <label for="password">Confirmar senha</label>
          <input type="password" id="confirmPassword" placeholder="Password" required="required"/>
          <a href="cine?action=RecuperarSenhaEmailBean">Cancelar</a>
          <button type="submit" id="resetButton">Redefinir</button>
        </form>
      </div>
      <div class="overlay-container">
        <div class="overlay">
          <div class="overlay-panel overlay-right">
            <h1>Redefinir senha</h1>
            <p>
              Caro usuário, você está prestes a redefinir a senha da sua conta. Este processo é fundamental para garantir a segurança e proteção dos seus dados. Por favor, escolha uma nova senha forte e única. 
              Certifique-se de armazená-la em um local seguro e não compartilhá-la com terceiros.
			  Após a conclusão deste processo, sua senha será atualizada, proporcionando maior tranquilidade quanto à segurança da sua conta.
            </p>
          </div>
        </div>
      </div>
    </div>
    <script src="js/recuperar-senha.js"></script>
</body>
</html>
