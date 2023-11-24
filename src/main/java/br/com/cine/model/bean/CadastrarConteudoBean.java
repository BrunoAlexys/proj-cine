package br.com.cine.model.bean;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cine.controller.TipoAcao;
import br.com.cine.model.entities.Conteudo;
import br.com.cine.model.entities.TipoConteudo;
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
		String tipo = this.req.getParameter("tipoConteudo");
		String titulo = this.req.getParameter("titulo");
		String descricao = this.req.getParameter("descricao");
		String diretor = this.req.getParameter("diretor");
		String genero = this.req.getParameter("genero");
		String dataDeLancamento = this.req.getParameter("dataDeLancamento");
		String duracao = this.req.getParameter("duracao");
		String temporadas = this.req.getParameter("temporadas");
		String urlImg = this.req.getParameter("urlImg");
		String urlTrailer = this.req.getParameter("urlTrailer");

		LocalDate data = LocalDate.parse(dataDeLancamento);
		Integer duracaoParse = Integer.parseInt(duracao);
		Integer temporadasParse = Integer.parseInt(temporadas);

		try {
			TipoConteudo tipoConteudoEnum = TipoConteudo.buscarPorDescricao(tipo);

			var conteudo = new Conteudo(titulo, descricao, diretor, duracaoParse, temporadasParse, genero, data, urlImg,
					urlTrailer, tipoConteudoEnum);
			
			cadastrar(conteudo);

			this.resp.sendRedirect("cine?action=LoginFormBean");
		} catch (IllegalArgumentException e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

	private void cadastrar(Conteudo conteudo) {

		try {
			var service = new ConteudoService();
			service.cadastrar(conteudo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
