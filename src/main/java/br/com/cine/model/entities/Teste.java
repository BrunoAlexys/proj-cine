package br.com.cine.model.entities;

import java.sql.SQLException;
import java.time.LocalDate;

import br.com.cine.model.repository.UsuarioRepository;

public class Teste {

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setNome("test");
		usuario.setSobrenome("test");
		usuario.setEmail("test@gmail.com");
		usuario.setSenha("test123");
		usuario.setDataDeNascimento(LocalDate.of(2000, 02, 20));
		usuario.setGenero("test");
		
		UsuarioRepository repository = new UsuarioRepository();
		
		try {
			repository.cadastrarUsuario(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
