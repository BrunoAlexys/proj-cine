package br.com.cine.model.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import br.com.cine.model.entities.Conteudo;
import br.com.cine.model.interfaces.IConteudoRepository;
import br.com.cine.model.util.TransacaoUtil;

public class ConteudoRepository implements IConteudoRepository {

	@Override
	public void cadastrar(Conteudo conteudo) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> maneger.persist(conteudo));
	}

	@Override
	public Optional<Conteudo> buscarPeloID(long id) throws SQLException {
		return TransacaoUtil.executarTransacaoComRetorno(manager -> {
			return Optional.ofNullable(
					manager.createQuery("select c from Conteudo c where c.id = :id and c.ativo = true", Conteudo.class)
							.setParameter("id", id).getSingleResult());
		});
	}
	
	@Override
	public List<Conteudo> listarConteudos() throws SQLException {
		return TransacaoUtil.executarTransacaoComRetorno(manager -> {
			return manager.createQuery("select c from Conteudo c where c.ativo = true", Conteudo.class).getResultList();
		});
	}
 
	@Override
	public List<Conteudo> listarFilmes() throws SQLException {
		return TransacaoUtil.executarTransacaoComRetorno(manager -> {
			return manager.createQuery("select c from Conteudo c where c.ativo = true", Conteudo.class).getResultList();
		});
	}
	
	@Override
	public List<Conteudo> listarTop10Filmes() throws SQLException {
		return TransacaoUtil.executarTransacaoComRetorno(maneger -> {
			return maneger.createQuery("SELECT DISTINCT c FROM Conteudo c " +
										"JOIN c.listAvaliacoes a " +
										"GROUP BY c " +
										"ORDER BY AVG(a.classificacao) DESC " +
										"LIMIT 10 ", Conteudo.class).getResultList();
		});
	}
		
	@Override
	public List<Conteudo> listarSeries() throws SQLException {
		return TransacaoUtil.executarTransacaoComRetorno(manager -> {
			return manager.createQuery("select c from Conteudo c where c.ativo = true", Conteudo.class).getResultList();
		});
	}
	
	@Override
	public List<Conteudo> listarTop10Series() throws SQLException {
		return TransacaoUtil.executarTransacaoComRetorno(maneger -> {
			return maneger.createQuery("SELECT DISTINCT c FROM Conteudo c " +
									   "JOIN c.listAvaliacoes a " +
									   "GROUP BY c " +
									   "ORDER BY AVG(a.classificacao) DESC " +
									   "LIMIT 10", Conteudo.class).getResultList();
		});
	}

	@Override
	public void alterar(Optional<Conteudo> conteudo) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> maneger.merge(conteudo));
	}

	@Override
	public void excluirPeloID(Long id) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> {
			Conteudo conteudo = maneger.find(Conteudo.class, id);
			conteudo.setAtivo(false);
			maneger.merge(conteudo);
		});

	}

}
