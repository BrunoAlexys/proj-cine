package br.com.cine.model.repository;

import java.sql.SQLException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.cine.model.entities.Filmes;
import br.com.cine.model.interfaces.IFilmesRepository;
import br.com.cine.model.util.JPAUtil;

public class FilmeRepository implements IFilmesRepository {

	@Override
	public void cadastrarFilmes(Filmes filmes) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.persist(filmes);
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
	public Optional<Filmes> buscarFilmesPeloID(long id) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Filmes filmes = null;

		try {
			transaction.begin();
			filmes = manager.createQuery("from Filmes f where f.id = :id and f.ativo = true", Filmes.class)
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
		return Optional.ofNullable(filmes);
	}

	@Override
	public void alterarFilmes(Filmes filmes) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.merge(filmes);
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
	public void excluirFilmesPeloID(Long id) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Filmes filmes = null;
		try {
			transaction.begin();
			filmes = manager.find(Filmes.class, id);
			filmes.setAtivo(false);
			manager.merge(filmes);
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
