package br.com.cine.model.service;

import java.sql.SQLException;
import java.util.Optional;

import br.com.cine.model.entities.Series;
import br.com.cine.model.repository.SerieRepository;
import br.com.cine.model.validation.ValidarSerie;

public class SerieService {

	private SerieRepository serieRepository;

	public SerieService() {
		this.serieRepository = new SerieRepository();
	}

	public Optional<Series> buscarSeriePeloID(Long id) throws SQLException {
		return serieRepository.buscarSeriePeloID(id);
	}

	public void cadastrarSerie(Series serie) throws SQLException {
		ValidarSerie.validarSerie(serie);
		serieRepository.cadastrarSerie(serie);
	}

	public void alterarSerie(Series serie) throws SQLException {
		serieRepository.alterarSerie(serie);
	}

	public void excluirSeriePeloId(Long id) throws SQLException {
		serieRepository.excluirSeriePeloID(id);
		;
	}
}
