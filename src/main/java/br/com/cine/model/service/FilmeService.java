package br.com.cine.model.service;

import java.sql.SQLException;
import java.util.Optional;

import br.com.cine.model.entities.Filmes;
import br.com.cine.model.repository.FilmeRepository;
import br.com.cine.model.validation.ValidarFilmes;

public class FilmeService {

	private FilmeRepository filmeRepository;

	public FilmeService() {
		this.filmeRepository = new FilmeRepository();
	}

	public void cadastrarFilme(Filmes filme) throws SQLException {
		ValidarFilmes.validarFilmes(filme);
		filmeRepository.cadastrarFilmes(filme);
	}

	public Optional<Filmes> buscarFilmesPeloID(Long filmeID) throws SQLException {
		return filmeRepository.buscarFilmesPeloID(filmeID);
	}

	public void alterarFilme(Filmes filme) throws SQLException {
		ValidarFilmes.validarFilmes(filme);
		filmeRepository.alterarFilmes(filme);
	}

	public void excluirFilmePeloId(Long filmeID) throws SQLException {
		filmeRepository.excluirFilmesPeloID(filmeID);
	}

}
