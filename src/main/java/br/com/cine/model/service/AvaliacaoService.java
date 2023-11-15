package br.com.cine.model.service;

import java.sql.SQLException;
import java.util.Optional;

import br.com.cine.model.entities.Avaliacoes;
import br.com.cine.model.entities.Filmes;
import br.com.cine.model.entities.Series;
import br.com.cine.model.entities.Usuario;
import br.com.cine.model.repository.AvaliacoesRepository;
import br.com.cine.model.validation.ValidarAvaliacao;

public class AvaliacaoService {

	private UsuarioService usuarioService = new UsuarioService();
	private FilmeService filmeService = new FilmeService();
	private SerieService serieService = new SerieService();
	private AvaliacoesRepository avaliacoesRepository = new AvaliacoesRepository();

	public void cadastrarAvaliacaoFilme(String titulo, String avaliacao, Integer classificacao, Long usuarioID,
			Long filmeID) throws SQLException {
		Optional<Usuario> usuarioEncontrado = usuarioService.buscarUsuarioPorID(usuarioID);
		Optional<Filmes> filmeEncontrado = filmeService.buscarFilmesPeloID(filmeID);

		if (usuarioEncontrado.isPresent() && filmeEncontrado.isPresent()) {
			Usuario usuario = usuarioEncontrado.get();
			Filmes filme = filmeEncontrado.get();

			Avaliacoes avaliacoes = new Avaliacoes();
			avaliacoes.setTitulo(titulo);
			avaliacoes.setAvaliacao(avaliacao);
			avaliacoes.setClassificacao(classificacao);
			avaliacoes.setUsuario(usuario);
			avaliacoes.setFilmes(filme);

			ValidarAvaliacao.validarAvaliacao(avaliacoes);

			avaliacoesRepository.salvarAvaliacao(avaliacoes);
		} else {
			throw new SQLException("Usuário ou filme não encontrado");
		}
	}

	public void cadastrarAvaliacaoSerie(String titulo, String avaliacao, Integer classificacao, Long usuarioID,
			Long serieID) throws SQLException {
		Optional<Usuario> usuarioEncontrado = usuarioService.buscarUsuarioPorID(usuarioID);
		Optional<Series> serieEncontrada = serieService.buscarSeriePeloID(serieID);

		if (usuarioEncontrado.isPresent() && serieEncontrada.isPresent()) {
			Usuario usuario = usuarioEncontrado.get();
			Series series = serieEncontrada.get();

			Avaliacoes avaliacoes = new Avaliacoes();
			avaliacoes.setTitulo(titulo);
			avaliacoes.setAvaliacao(avaliacao);
			avaliacoes.setClassificacao(classificacao);
			avaliacoes.setUsuario(usuario);
			avaliacoes.setSeries(series);

			ValidarAvaliacao.validarAvaliacao(avaliacoes);

			avaliacoesRepository.salvarAvaliacao(avaliacoes);
		} else {
			throw new SQLException("Usuário ou série não encontrado");
		}
	}

	public Optional<Avaliacoes> buscarAvaliacaoPorID(Long id) throws SQLException {
		return avaliacoesRepository.buscarAvaliacaoPorID(id);
	}

	public void alterarAvaliacao(Avaliacoes avaliacoes) throws SQLException {
		ValidarAvaliacao.validarAvaliacao(avaliacoes);
		avaliacoesRepository.atualizarAvaliacao(avaliacoes);
	}

	public void excluirAvaliacao(Long id) throws SQLException {
		avaliacoesRepository.removerAvaliacaoPeloID(id);
	}
}
