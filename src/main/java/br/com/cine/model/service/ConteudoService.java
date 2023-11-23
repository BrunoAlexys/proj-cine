package br.com.cine.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import br.com.cine.model.entities.Conteudo;
import br.com.cine.model.entities.Filmes;
import br.com.cine.model.repository.ConteudoRepository;

public class ConteudoService {
	private ConteudoRepository conteudoRepository;
	
	public ConteudoService() {
		this.conteudoRepository = new ConteudoRepository();
	}
	
	public void cadastrar(Conteudo conteudo) throws SQLException {
		conteudoRepository.cadastrar(conteudo);
	}
	
	public Optional<Conteudo> buscarPeloID(Long id) throws SQLException {
		return conteudoRepository.buscarPeloID(id);
	}
	
	public List<Conteudo> listarConteudo() throws SQLException {
		return conteudoRepository.listarConteudos();
	}
	
	public List<Filmes> listarFilmes() throws SQLException {
		return conteudoRepository.listarFilmes();
	}
	
	public void listarSeries()throws SQLException {
		conteudoRepository.listarSeries();
	}
	
	public void alterar(Optional<Conteudo> conteudo) throws SQLException {
		conteudoRepository.alterar(conteudo);
	}
	
	public void excluir(Long id) throws SQLException {
		conteudoRepository.excluirPeloID(id);
	}
}
