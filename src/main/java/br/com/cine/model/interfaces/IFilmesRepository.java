package br.com.cine.model.interfaces;

import java.sql.SQLException;
import java.util.Optional;
import br.com.cine.model.entities.Filmes;

public interface IFilmesRepository {
	void cadastrarFilmes(Filmes filmes) throws SQLException;
    Optional<Filmes> buscarFilmesPeloID(long id) throws SQLException;
    void alterarFilmes(Filmes filmes) throws SQLException;
    void excluirFilmesPeloID(Long id) throws SQLException;
}
