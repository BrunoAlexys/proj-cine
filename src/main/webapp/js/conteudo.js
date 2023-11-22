function exibirCamposEspecificos() {
    var tipoConteudo = document.getElementById("tipoConteudo").value;

    var duracaoDiv = document.getElementById("duracaoDiv");
    var temporadasDiv = document.getElementById("temporadasDiv");
    var duracaoInput = document.getElementById("duracao");

    if (tipoConteudo === "Filmes") {
        duracaoDiv.style.display = "block";
        temporadasDiv.style.display = "none";
        duracaoInput.required = true; // Adiciona o atributo required quando o campo é mostrado
    } else if (tipoConteudo === "Series") {
        duracaoDiv.style.display = "none";
        temporadasDiv.style.display = "block";
        duracaoInput.required = false; // Remove o atributo required quando o campo é oculto
    }
}
