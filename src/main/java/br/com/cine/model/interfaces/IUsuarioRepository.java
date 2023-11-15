package br.com.cine.model.interfaces;

import java.sql.SQLException;
import java.util.Optional;

import br.com.cine.model.entities.Usuario;

public interface IUsuarioRepository {
	void cadastrarUsuario(Usuario usuario) throws SQLException;
    Optional<Usuario> buscarUsuarioPorEmailESenha(String email, String senha) throws SQLException;
    Optional<Usuario> buscarUsuarioPeloID(Long id) throws SQLException;
    void alterarUsuario(Usuario usuario) throws SQLException;
    void excluirUsuarioPeloId(Long id) throws SQLException;
}
