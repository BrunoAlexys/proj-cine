package br.com.cine.model.service;

import java.sql.SQLException;
import java.util.Optional;
import br.com.cine.model.entities.Usuario;
import br.com.cine.model.repository.UsuarioRepository;

public class UsuarioService {
	private UsuarioRepository usuarioRepository;
	
	public UsuarioService() {
		this.usuarioRepository = new UsuarioRepository();
	}

	public void cadastrarUsuario(Usuario usuario) throws Exception, SQLException {
		
		Optional<Usuario> usuarioEncontrado = usuarioRepository.buscarEmail(usuario.getEmail());
		
		usuarioEncontrado.ifPresent(usuarioExistente -> {
	        throw new IllegalArgumentException("Não é possível cadastrar esse email");
	    });
		
		String senhaHash = EncriptarSenha.encriptarSenha(usuario.getSenha());
		usuario.setSenha(senhaHash);
		usuarioRepository.cadastrarUsuario(usuario);
	}

	public Optional<Usuario> buscarUsuarioPorEmailESenha(String email, String senha) throws Exception, SQLException {
		return usuarioRepository.buscarUsuarioPorEmailESenha(email, senha);
	}

	public Optional<Usuario> buscarUsuarioPorID(Long id) throws SQLException {
		return usuarioRepository.buscarUsuarioPeloID(id);
	}

	public void alterarUsuario(Usuario usuario) throws Exception {
		String senhaHash = EncriptarSenha.encriptarSenha(usuario.getSenha());
		usuario.setSenha(senhaHash);
		usuarioRepository.alterarUsuario(usuario);
	}

	public void excluirUsuario(Long id) throws SQLException {
		usuarioRepository.excluirUsuarioPeloId(id);
	}
}
