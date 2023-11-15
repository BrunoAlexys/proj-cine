package br.com.cine.model.repository;

import java.sql.SQLException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.cine.model.entities.Series;
import br.com.cine.model.interfaces.ISeriesRepository;
import br.com.cine.model.util.JPAUtil;

public class SerieRepository implements ISeriesRepository {

	@Override
	public void cadastrarSerie(Series serie) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();

		try {
			transacao.begin();
			manager.persist(serie);
			transacao.commit();
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			if (transacao.isActive()) {
				transacao.rollback();
			}
			manager.close();
		}
	}

	@Override
	public Optional<Series> buscarSeriePeloID(Long id) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();

		Series serie = null;

		try {
			transacao.begin();
			serie = manager.createQuery("from Series s where s.id = :id and s.ativo = true", Series.class)
					.setParameter("id", id).getSingleResult();
			transacao.commit();
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			if (transacao.isActive()) {
				transacao.rollback();
			}
			manager.close();
		}
		return Optional.ofNullable(serie);
	}

	@Override
	public void alterarSerie(Series serie) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();

		try {
			transacao.begin();
			manager.merge(serie);
			transacao.commit();
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			if (transacao.isActive()) {
				transacao.rollback();
			}
			manager.close();
		}
	}

	@Override
	public void excluirSeriePeloID(Long id) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();

		Series serie = null;

		try {
			transacao.begin();
			serie = manager.find(Series.class, id);
			serie.setAtivo(false);
			manager.merge(serie);
			transacao.commit();
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			if (transacao.isActive()) {
				transacao.rollback();
			}
			manager.close();
		}
	}
}
