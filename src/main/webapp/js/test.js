function exibirCamposEspecificos() {
	var tipoConteudo = document.getElementById("tipoConteudo").value;

	var duracaoDiv = document.getElementById("duracaoDiv");
	var temporadasDiv = document.getElementById("temporadasDiv");

	if (tipoConteudo === "Filmes") {
		duracaoDiv.style.display = "block";
		temporadasDiv.style.display = "none";
	} else if (tipoConteudo === "Series") {
		duracaoDiv.style.display = "none";
		temporadasDiv.style.display = "block";
	}
}