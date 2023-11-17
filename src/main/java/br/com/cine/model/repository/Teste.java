package br.com.cine.model.repository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import br.com.cine.model.entities.Conteudo;
import br.com.cine.model.entities.Filmes;
import br.com.cine.model.entities.Series;
import br.com.cine.model.service.ConteudoService;

public class Teste {

	public static void main(String[] args) {
		Filmes filme = new Filmes("Título do Filme", "Descrição do Filme", "Diretor do Filme", "Gênero do Filme",
				LocalDate.of(2022, 1, 1), "url_imagem_filme.jpg", "url_trailer_filme.mp4", 120);

		Series serie = new Series("Título da Série 2", "Descrição da Série 2", "Diretor da Série 2", "Gênero da Série",
				LocalDate.of(2022, 1, 1), "url_imagem_serie.jpg", "url_trailer_serie.mp4", 5);
		
		
	}

}
