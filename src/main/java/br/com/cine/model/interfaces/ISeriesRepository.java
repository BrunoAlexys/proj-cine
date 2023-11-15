package br.com.cine.model.interfaces;

import java.sql.SQLException;
import java.util.Optional;

import br.com.cine.model.entities.Series;

public interface ISeriesRepository {
	 void cadastrarSerie(Series serie) throws SQLException;
	    Optional<Series> buscarSeriePeloID(Long id) throws SQLException;
	    void alterarSerie(Series serie) throws SQLException;
	    void excluirSeriePeloID(Long id) throws SQLException;
}
