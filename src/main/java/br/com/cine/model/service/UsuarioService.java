package br.com.cine.model.service;

import java.sql.SQLException;
import java.util.Optional;
import br.com.cine.model.entities.Usuario;
import br.com.cine.model.repository.UsuarioRepository;
import br.com.cine.model.validation.ValidarUsuario;

public class UsuarioService {
	private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }

    public void cadastrarUsuario(Usuario usuario) throws Exception, SQLException {
        //Optional<Usuario> usuarioExistente = buscarUsuarioPorEmail(usuario.getEmail());

//        if (usuarioExistente.isPresent()) {
//            throw new IllegalArgumentException("Não foi possível cadastrar o usuário com esse email!");
//        }

        String senhaHash = EncriptarSenha.encriptarSenha(usuario.getSenha());
        usuario.setSenha(senhaHash);
        ValidarUsuario.validarUsuario(usuario);
        usuarioRepository.cadastrarUsuario(usuario);
    }

    public Optional<Usuario> buscarUsuarioPorEmailESenha(String email, String senha) throws Exception,SQLException {      
        ValidarUsuario.validarEmailESenha(email, senha);
        return usuarioRepository.buscarUsuarioPorEmailESenha(email, senha);
    }

//    public Optional<Usuario> buscarUsuarioPorEmail(String email) throws SQLException {
//        return usuarioRepository.buscarUsuarioPorEmail(email);
//    }

    public Optional<Usuario> buscarUsuarioPorID(Long id) throws SQLException{
        return usuarioRepository.buscarUsuarioPeloID(id);
    }

    public void alterarUsuario(Usuario usuario) throws Exception {
        String senhaHash = EncriptarSenha.encriptarSenha(usuario.getSenha());
        usuario.setSenha(senhaHash);
        ValidarUsuario.validarUsuario(usuario);
        usuarioRepository.alterarUsuario(usuario);
    }

    public void excluirUsuario(Long id) throws SQLException {
        usuarioRepository.excluirUsuarioPeloId(id);
    }
}


