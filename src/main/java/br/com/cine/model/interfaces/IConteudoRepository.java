package br.com.cine.model.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import br.com.cine.model.entities.Conteudo;
import br.com.cine.model.entities.Filmes;
import br.com.cine.model.entities.Series;

public interface IConteudoRepository {
	void cadastrar(Conteudo conteudo) throws SQLException;
    Optional<Conteudo> buscarPeloID(long id) throws SQLException;
    List<Conteudo> listarConteudos() throws SQLException;
    List<Filmes> listarFilmes() throws SQLException;
    List<Filmes> listarTop10Filmes() throws SQLException;
    List<Series> listarSeries() throws SQLException;
    List<Series> listarTop10Series() throws SQLException;
    void alterar(Optional<Conteudo> conteudo) throws SQLException;
    void excluirPeloID(Long id) throws SQLException;
}
