package br.com.cine.model.validation;

import br.com.cine.model.entities.Filmes;

public class ValidarFilmes {
	public static Boolean validarFilmes(Filmes filmes) {
		if (filmes.getTitulo().isEmpty()) {
			throw new IllegalArgumentException("Titulo não pode ser vazio");
		}

		if (filmes.getDescricao().isEmpty()) {
			throw new IllegalArgumentException("Descrição não pode ser vazia");
		}

		if (filmes.getDuracao() == null) {
			throw new IllegalArgumentException("Temporadas não pode ser vazio");
		}

		if (filmes.getDiretor().isEmpty()) {
			throw new IllegalArgumentException("Diretor não pode ser vazio");
		}

		if (filmes.getDataDeLancamento() == null) {
			throw new IllegalArgumentException("Data de lançamento não pode ser vazio");
		}

		if (filmes.getGenero().isEmpty()) {
			throw new IllegalArgumentException("Genero não pode ser vazio");
		}

		if (filmes.getUrlImg().isEmpty()) {
			throw new IllegalArgumentException("Url da imagem não pode ser vazio");
		}

		if (filmes.getUrlTrailer().isEmpty()) {
			throw new IllegalArgumentException("Url do trailer não pode ser vazio");
		}

		return true;
	}
}
