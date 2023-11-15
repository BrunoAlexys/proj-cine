package br.com.cine.model.bean;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.cine.controller.TipoAcao;
import br.com.cine.model.entities.Usuario;
import br.com.cine.model.service.UsuarioService;

public class CadastroUsuarioBean implements TipoAcao {
	
	private HttpServletRequest req;
    private HttpServletResponse resp;
    
	public CadastroUsuarioBean(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}

	@Override
	public void execute() throws ServletException, IOException {
		String nome = req.getParameter("name");
		String sobrenome = req.getParameter("lastName");
		String email = req.getParameter("email");
		String senha = req.getParameter("password");
		String dataDeNascimento = req.getParameter("date");
		String genero = req.getParameter("genero");
		
		LocalDate data = LocalDate.parse(dataDeNascimento);
		
		var usuario = new Usuario(nome, sobrenome, email, senha, data, genero);
		
		var usuarioService = new UsuarioService();
		
		try {
			usuarioService.cadastrarUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.resp.sendRedirect("cine?action=LoginFormBean");
		
	}
    
    
}

