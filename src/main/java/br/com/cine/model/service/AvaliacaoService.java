package br.com.cine.model.service;

import java.sql.SQLException;
import java.util.Optional;
import br.com.cine.model.entities.Avaliacoes;
import br.com.cine.model.entities.Conteudo;
import br.com.cine.model.entities.Usuario;
import br.com.cine.model.repository.AvaliacoesRepository;


public class AvaliacaoService {

	private UsuarioService usuarioService = new UsuarioService();
	private ConteudoService conteudoService = new ConteudoService();
	private AvaliacoesRepository avaliacoesRepository = new AvaliacoesRepository();

	public void cadastrarAvaliacao(String titulo, String avaliacao, Integer classificacao, Long usuarioID,
			Long conteudoID) throws SQLException {
		Optional<Usuario> usuarioEncontrado = usuarioService.buscarUsuarioPorID(usuarioID);
		Optional<Conteudo> conteudoEncontrado = conteudoService.buscarPeloID(conteudoID);

		if (usuarioEncontrado.isPresent() && conteudoEncontrado.isPresent()) {
			Usuario usuario = usuarioEncontrado.get();
			Conteudo conteudo = conteudoEncontrado.get();

			Avaliacoes avaliacoes = new Avaliacoes();

			avaliacoesRepository.salvarAvaliacao(avaliacoes);
		} else {
			throw new SQLException("Não foi encontrado nenhum conteudo");
		}
	}

	public Optional<Avaliacoes> buscarAvaliacaoPorID(Long id) throws SQLException {
		return avaliacoesRepository.buscarAvaliacaoPorID(id);
	}

	public void alterarAvaliacao(Avaliacoes avaliacoes) throws SQLException {
		avaliacoesRepository.atualizarAvaliacao(avaliacoes);
	}

	public void excluirAvaliacao(Long id) throws SQLException {
		avaliacoesRepository.removerAvaliacaoPeloID(id);
	}
}
