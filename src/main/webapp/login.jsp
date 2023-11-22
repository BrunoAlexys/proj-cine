<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/login.css">
    <title>Login</title>
</head>
<body>
	<div class="container" id="container">
    <div class="container" id="container">
        <div class="form-container sign-up-container">
            <form action="cine?action=CadastroUsuarioBean" method="post">
                <h1>Criar uma conta</h1>
                <span>ou use seu e-mail para cadastro</span>
                <input type="text" placeholder="First name" name="name" />
                <input type="text" placeholder="Last name" name="lastName" />
                <input type="email" placeholder="Email" name="email" />
                <input type="password" placeholder="Password" name="password" />
                <input type="date" placeholder="Date" name="date" />
                <select id="sexo" name="genero">
                    <option value="" disabled selected>Selecione uma opção</option>
                    <option value="masculino">Masculino</option>
                    <option value="feminino">Feminino</option>
                    <option value="outros">Outros</option>
                </select>
               
                <button type="submit">Inscrever-se</button>
            </form>
        </div>

        <div class="form-container sign-in-container">
            <form action="cine?action=LoginBean" method="post">
                <h1>Entrar</h1>
                <span>ou se inscrever-se</span>
                <input type="email" placeholder="Email" name="email" />
                <input type="password" placeholder="Password" name="password" />
                <a href="cine?action=RecuperarSenhaEmailBean">Esqueceu a senha?</a>
                <button>Entrar</button>
            </form>
        </div>

        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Bem-vindo de volta!</h1>
                    <p>Para se manter conectado conosco, faça login com suas informações</p>
                    <button class="ghost" id="signIn">Entrar</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>Olá, Amigo!</h1>
                    <p>Insira seus dados e comece sua diversão conosco</p>
                    <button class="ghost" id="signUp">Inscrever-se</button>
                </div>
            </div>
        </div>
    </div>

    <script src="js/login.js"></script>
</body>
</html>