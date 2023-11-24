package br.com.cine.model.entities;

public enum TipoConteudo {
    FILME("Filmes"),
    SERIE("Series");

    private String descricao;

    private TipoConteudo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    // Método estático para buscar um valor pelo nome
    public static TipoConteudo buscarPorDescricao(String descricao) {
        for (TipoConteudo tipo : values()) {
            if (tipo.descricao.equalsIgnoreCase(descricao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de conteúdo não encontrado para a descrição: " + descricao);
    }
}
