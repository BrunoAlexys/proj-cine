package br.com.cine.model.bean;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.cine.controller.TipoAcao;
import br.com.cine.model.entities.Usuario;
import br.com.cine.model.service.UsuarioService;

public class LoginBean implements TipoAcao {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	public LoginBean(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}

	@Override
	public void execute() throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("password");

		var service = new UsuarioService();

		Optional<Usuario> usuario = null;

		try {
			usuario = service.buscarUsuarioPorEmailESenha(email, senha);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Usuario não foi encontrado");
		}

		if (usuario.isPresent()) {
			adicionarUsuarioNaSessao(usuario.get());
			this.resp.sendRedirect("cine?action=CineBean");
		} else if (usuario.isPresent() && usuario.get().getEmail().equals("admin")
				&& usuario.get().getSenha().equals("admin")) {
			adicionarUsuarioNaSessao(usuario.get());
			this.resp.sendRedirect("cine?action=AdminBean");
		} else {
			this.resp.sendRedirect("cine?action=LoginFormBean");
		}

	}

	private void adicionarUsuarioNaSessao(Usuario usuario) {
		HttpSession session = req.getSession();
		session.setAttribute("usuarioLogado", usuario);
	}

}
