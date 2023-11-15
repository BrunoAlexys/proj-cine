package br.com.cine.model.validation;

import br.com.cine.model.entities.Series;

public class ValidarSerie {
	public static Boolean validarSerie(Series series) {
		if (series.getTitulo().isEmpty()) {
			throw new IllegalArgumentException("Titulo não pode ser vazio");
		}

		if (series.getDescricao().isEmpty()) {
			throw new IllegalArgumentException("Descrição não pode ser vazia");
		}

		if (series.getTemporadas() == null) {
			throw new IllegalArgumentException("Temporadas não pode ser vazio");
		}

		if (series.getDiretor().isEmpty()) {
			throw new IllegalArgumentException("Diretor não pode ser vazio");
		}

		if (series.getDataDeLancamento() == null) {
			throw new IllegalArgumentException("Data de lançamento não pode ser vazio");
		}

		if (series.getGenero().isEmpty()) {
			throw new IllegalArgumentException("Genero não pode ser vazio");
		}

		if (series.getUrlImg().isEmpty()) {
			throw new IllegalArgumentException("Url da imagem não pode ser vazio");
		}

		if (series.getUrlTrailer().isEmpty()) {
			throw new IllegalArgumentException("Url do trailer não pode ser vazio");
		}

		return true;
	}
}
