package br.com.cine.model.repository;

import java.sql.SQLException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.mindrot.jbcrypt.BCrypt;

import br.com.cine.model.entities.Usuario;
import br.com.cine.model.interfaces.IUsuarioRepository;
import br.com.cine.model.util.JPAUtil;
import br.com.cine.model.util.TransacaoUtil;

public class UsuarioRepository implements IUsuarioRepository {

	@Override
	public void cadastrarUsuario(Usuario usuario) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> maneger.persist(usuario));
	}

	@Override
	public Optional<Usuario> buscarUsuarioPorEmailESenha(String email, String senha) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Usuario usuario = null;

		try {
			transaction.begin();
			usuario = manager.createQuery("from Usuario u where u.email = :email and u.ativo = true", Usuario.class)
					.setParameter("email", email).getSingleResult();

			// Verificar se a senha fornecida corresponde à senha criptografada no banco de
			// dados
			if (usuario != null && BCrypt.checkpw(senha, usuario.getSenha())) {
				transaction.commit();
			} else {
				usuario = null;
				throw new IllegalArgumentException("Email ou senha inválidos!");
			}
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			manager.close();
		}

		return Optional.ofNullable(usuario);
	}

	@Override
	public Optional<Usuario> buscarUsuarioPeloID(Long id) throws SQLException {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Usuario usuario = null;

		try {
			transaction.begin();
			// buscar o usuario pelo id e verificar se ele está ativo
			usuario = manager.createQuery("from Usuario u where u.id = :id and u.ativo = true", Usuario.class)
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

		return Optional.ofNullable(usuario);
	}
	
	@Override
	public Optional<Usuario> buscarEmail(String email) throws SQLException {
		return TransacaoUtil.executarTransacaoComRetorno(manager -> {
	        try {
	            return Optional.of(
	                    manager.createQuery("from Usuario u where u.email = :email and u.ativo = true", Usuario.class)
	                            .setParameter("email", email).getSingleResult());
	        } catch (NoResultException e) {
	            return Optional.empty();
	        }
	    });
	}

	@Override
	public void alterarUsuario(Usuario usuario) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> maneger.merge(usuario));
	}

	@Override
	public void excluirUsuarioPeloId(Long id) throws SQLException {
		TransacaoUtil.executarTransacao(maneger -> {
			Usuario usuario = maneger.find(Usuario.class, id);
			usuario.setAtivo(false);
			maneger.merge(usuario);
		});
	}
}
