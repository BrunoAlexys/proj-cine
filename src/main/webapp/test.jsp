<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/cine?action=CadastrarConteudoBean" var="cadastro"/>

<html>
<head>
    <title>Cadastro de Conteúdo</title>
</head>
<body>

<h2>Cadastro de Conteúdo</h2>

<h2>Cadastro de Conteúdo</h2>

<form action="/cine?action=CadastrarConteudoBean" method="post">

    <label for="tipoConteudo">Tipo de Conteúdo:</label>
    <select name="tipoConteudo" id="tipoConteudo" onchange="exibirCamposEspecificos()">
        <option value="Filmes">Filmes</option>
        <option value="Series">Séries</option>
    </select>

    <br/>

    <!-- Campos comuns a Conteudo, Filmes e Series -->
    <br/>
    <label for="titulo">Título:</label>
    <input type="text" name="titulo" required>

    <br/>
    <label for="descricao">Descrição:</label>
    <textarea name="descricao" required></textarea>

    <br/>
    <label for="diretor">Diretor:</label>
    <input type="text" name="diretor" required>

    <br/>
    <label for="genero">Gênero:</label>
    <input type="text" name="genero" required>

    <br/>
    <label for="dataDeLancamento">Data de Lançamento:</label>
    <input type="date" name="dataDeLancamento" required>
    
     <!-- Div para campos específicos de Filmes -->
    <div id="duracaoDiv">
        <label for="duracao">Duração (minutos):</label>
        <input type="number" name="duracao" required>
    </div>

    <!-- Div para campos específicos de Séries -->
    <div id="temporadasDiv" style="display: none;">
        <label for="temporadas">Número de Temporadas:</label>
        <input type="number" name="temporadas" required>
    </div>

    <br/>
    <label for="urlImg">URL da Imagem:</label>
    <input type="text" name="urlImg" required>

    <br/>
    <label for="urlTrailer">URL do Trailer:</label>
    <input type="text" name="urlTrailer" required>

    <!-- ... (outros campos) ... -->

    <br/><br/>
    <input type="submit" value="Salvar">

</form>

<script src="js/test.js"></script>
</body>
</html>
