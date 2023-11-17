package br.com.cine.model.util;

import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TransacaoUtil {
	public static <T> T executarTransacaoComRetorno(Function<EntityManager, T> function) throws SQLException {
        EntityManager manager = null;
        EntityTransaction transaction = null;

        try {
            manager = JPAUtil.getEntityManager();
            transaction = manager.getTransaction();
            transaction.begin();
            T result = function.apply(manager);
            transaction.commit();
            return result;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new SQLException(e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public static void executarTransacao(Consumer<EntityManager> consumer) throws SQLException {
        executarTransacaoComRetorno(manager -> {
            consumer.accept(manager);
            return null;
        });
    }
}
