package br.com.cine.model.bean;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cine.controller.TipoAcao;
import br.com.cine.model.entities.Conteudo;
import br.com.cine.model.interfaces.IConteudoRepository;
import br.com.cine.model.repository.ConteudoRepository;
import br.com.cine.model.service.ConteudoService;

public class CadastrarConteudoBean implements TipoAcao {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	public CadastrarConteudoBean(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}

	@Override
	public void execute() throws ServletException, IOException {
		var service = new ConteudoService();

		String pTipoConteudo = req.getParameter("tipoConteudo");
		String pTitulo = req.getParameter("titulo");
		String pDescricao = req.getParameter("descricao");
		String pDiretor = req.getParameter("diretor");
		String pGenero = req.getParameter("genero");
		String pData = req.getParameter("dataDeLancamento");
		String pDuracao = req.getParameter("duracao");
		String pTemporadas = req.getParameter("temporadas");
		String pImage = req.getParameter("urlImg");
		String pTrailer = req.getParameter("urlTrailer");
		LocalDate data = LocalDate.parse(pData);

		try {
			Class<?> classeConteudo = Class.forName("br.com.cine.model.entities." + pTipoConteudo);
			Constructor<?> construtor = classeConteudo.getConstructor(String.class, String.class, String.class,
					String.class, LocalDate.class, String.class, String.class);

			Object conteudo;
			if ("Filmes".equals(pTipoConteudo)) {
				Integer duracao = Integer.parseInt(pDuracao);
				conteudo = construtor.newInstance(pTitulo, pDescricao, pDiretor, pGenero, data, pImage, pTrailer,
						duracao);
				salvarConteudo((Conteudo) conteudo);
			} else {
				Integer temporadas = Integer.parseInt(pTemporadas);
				conteudo = construtor.newInstance(pTitulo, pDescricao, pDiretor, pGenero, data, pImage, pTrailer,
						temporadas);
				salvarConteudo((Conteudo) conteudo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.resp.sendRedirect("LoginFormBean");
	}

	private void salvarConteudo(Conteudo conteudo) {
		try {
			IConteudoRepository conteudoRepository = new ConteudoRepository();
			conteudoRepository.cadastrar(conteudo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
