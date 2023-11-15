package br.com.cine.model.service;

import org.mindrot.jbcrypt.BCrypt;

public class EncriptarSenha {
	public static String encriptarSenha(String senha) throws Exception {
        String salt = BCrypt.gensalt();
        String senhaCriptografada = BCrypt.hashpw(senha, salt);
        return senhaCriptografada;
    }
}
