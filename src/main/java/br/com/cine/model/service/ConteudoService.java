package br.com.cine.model.service;

import java.sql.SQLException;
import java.util.Optional;
import br.com.cine.model.entities.Conteudo;
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
	
	public void listarFilmes() throws SQLException {
		conteudoRepository.listarFilmes();
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
