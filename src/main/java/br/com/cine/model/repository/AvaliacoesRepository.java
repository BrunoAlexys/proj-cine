package br.com.cine.model.repository;

import java.sql.SQLException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.cine.model.entities.Avaliacoes;
import br.com.cine.model.entities.Conteudo;
import br.com.cine.model.interfaces.IAvaliacoesRepository;
import br.com.cine.model.util.JPAUtil;
import br.com.cine.model.util.TransacaoUtil;
import net.bytebuddy.asm.Advice.Return;

public class AvaliacoesRepository implements IAvaliacoesRepository {

	@Override
	public void salvarAvaliacao(Avaliacoes avaliacoes) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> maneger.persist(avaliacoes));
	}

	@Override
	public Optional<Avaliacoes> buscarAvaliacaoPorID(Long id) throws SQLException {
		return TransacaoUtil.executarTransacaoComRetorno(manager -> {
			return Optional.ofNullable(
					manager.createQuery("from Avaliacoes a where a.id = :id and a.ativo = true", Avaliacoes.class)
							.setParameter("id", id).getSingleResult());
		});
	}

	@Override
	public void atualizarAvaliacao(Avaliacoes avaliacoes) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> maneger.merge(avaliacoes));
	}

	@Override
	public void removerAvaliacaoPeloID(Long id) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> {
			Avaliacoes avaliacoes = maneger.find(Avaliacoes.class, id);
			avaliacoes.setAtivo(false);
			maneger.merge(avaliacoes);
		});
	}
}
