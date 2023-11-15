package br.com.cine.model.bean;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.cine.controller.TipoAcao;

public class LoginFormBean implements TipoAcao{
	private HttpServletRequest req;
    private HttpServletResponse resp;
    
	public LoginFormBean(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}

	@Override
	public void execute() throws ServletException, IOException {
		RequestDispatcher rd = this.req.getRequestDispatcher("/login.jsp");
        rd.forward(this.req, this.resp);
	}
}
