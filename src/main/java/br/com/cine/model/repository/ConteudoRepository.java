package br.com.cine.model.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.cine.model.entities.Conteudo;
import br.com.cine.model.entities.Filmes;
import br.com.cine.model.entities.Series;
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
					manager.createQuery("from Conteudo c where c.id = :id and c.ativo = true", Conteudo.class)
							.setParameter("id", id).getSingleResult());
		});
	}

	@Override
	public List<Filmes> listarFilmes() throws SQLException {
		return TransacaoUtil.executarTransacaoComRetorno(manager -> {
			return manager.createQuery("from Filmes f where f.ativo = true", Filmes.class).getResultList();
		});
	}

	@Override
	public List<Series> listarSeries() throws SQLException {
		return TransacaoUtil.executarTransacaoComRetorno(manager -> {
			return manager.createQuery("from Series s where s.ativo = true", Series.class).getResultList();
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
