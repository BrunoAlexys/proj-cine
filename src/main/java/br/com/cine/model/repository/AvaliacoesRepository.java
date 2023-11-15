package br.com.cine.model.repository;

import java.sql.SQLException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.cine.model.entities.Avaliacoes;
import br.com.cine.model.interfaces.IAvaliacoesRepository;
import br.com.cine.model.util.JPAUtil;

public class AvaliacoesRepository implements IAvaliacoesRepository {

	@Override
	public void salvarAvaliacao(Avaliacoes avaliacoes) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.persist(avaliacoes);
			transaction.commit();
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			manager.close();
		}
	}

	@Override
	public Optional<Avaliacoes> buscarAvaliacaoPorID(Long id) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Avaliacoes avaliacoes = null;

		try {
			transaction.begin();
			avaliacoes = manager.createQuery("from Avaliacoes a where a.id = :id and a.ativo = true", Avaliacoes.class)
					.setParameter("id", id).getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			manager.close();
		}

		return Optional.ofNullable(avaliacoes);
	}

	@Override
	public void atualizarAvaliacao(Avaliacoes avaliacoes) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.merge(avaliacoes);
			transaction.commit();
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			manager.close();
		}
	}

	@Override
	public void removerAvaliacaoPeloID(Long id) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Avaliacoes avaliacoes = null;

		try {
			transaction.begin();
			avaliacoes = manager.find(Avaliacoes.class, id);
			avaliacoes.setAtivo(false);
			manager.merge(avaliacoes);
			transaction.commit();
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			manager.close();
		}
	}
}
