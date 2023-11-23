package br.com.cine.model.bean;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.cine.controller.TipoAcao;
import br.com.cine.model.entities.Conteudo;
import br.com.cine.model.service.ConteudoService;

public class ListarConteudoBean implements TipoAcao {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	public ListarConteudoBean(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}

	@Override
	public void execute() throws ServletException, IOException {

		var service = new ConteudoService();

		List<Conteudo> listConteudo = null;
		try {
			listConteudo = service.listarConteudo();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.req.setAttribute("conteudo", listConteudo);

		RequestDispatcher dispatcher = this.req.getRequestDispatcher("/admin.jsp");
		dispatcher.forward(this.req, this.resp);

	}

}
