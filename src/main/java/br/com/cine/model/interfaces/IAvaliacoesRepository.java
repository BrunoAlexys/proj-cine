package br.com.cine.model.interfaces;

import java.sql.SQLException;
import java.util.Optional;
import br.com.cine.model.entities.Avaliacoes;

public interface IAvaliacoesRepository {
	void salvarAvaliacao(Avaliacoes avaliacoes) throws SQLException;
    Optional<Avaliacoes> buscarAvaliacaoPorID(Long id) throws SQLException;
    void atualizarAvaliacao(Avaliacoes avaliacoes) throws SQLException;
    void removerAvaliacaoPeloID(Long id) throws SQLException;
}
