package br.com.cine.model.validation;

import br.com.cine.model.entities.Avaliacoes;

public class ValidarAvaliacao {
    public static Boolean validarAvaliacao(Avaliacoes avaliacoes) {
        if (avaliacoes.getTitulo().isEmpty()) {
            throw new RuntimeException("O Titulo não pode ser vazio");
        }
        if (avaliacoes.getAvaliacao().isEmpty()) {
            throw new RuntimeException("A avaliação não pode ser vazia");
        }
        if (avaliacoes.getClassificacao() == null && avaliacoes.getClassificacao() < 0) {
            throw new RuntimeException("A avaliação não pode ser vazia e nem menor que 0");
        }
       
        return true;
    }
}
