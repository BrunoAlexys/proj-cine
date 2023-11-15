package br.com.cine.model.validation;

import br.com.cine.model.entities.Usuario;
import br.com.cine.model.repository.UsuarioRepository;

public class ValidarUsuario {

	private UsuarioRepository repository;

	public ValidarUsuario() {
		this.repository = new UsuarioRepository();
	}

	public static Boolean validarUsuario(Usuario usuario) {
		if (usuario.getNome().isEmpty()) {
			throw new IllegalArgumentException("Nome não pode ser vazio");
		}

		validarEmailESenha(usuario.getEmail(), usuario.getSenha());

		if (usuario.getDataDeNascimento() == null) {
			throw new IllegalArgumentException("Data de nascimento não pode ser vazia");
		}

		return true;
	}

	public static Boolean validarEmailESenha(String email, String senha) {
		if (email.isEmpty()) {
			throw new IllegalArgumentException("Email não pode ser vazio");
		}

		if (senha.isEmpty()) {
			throw new IllegalArgumentException("Senha não pode ser vazia");
		}

		return true;
	}
}
