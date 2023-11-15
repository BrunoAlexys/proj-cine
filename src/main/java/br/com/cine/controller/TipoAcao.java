package br.com.cine.controller;

import java.io.IOException;

import javax.servlet.ServletException;

public interface TipoAcao {
	void execute() throws ServletException, IOException;
}
