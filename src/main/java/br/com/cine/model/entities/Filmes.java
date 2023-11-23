package br.com.cine.model.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "filmes")
@DiscriminatorValue("FILME")
public class Filmes extends Conteudo {

	@Column(name = "duracao")
	private Integer duracao;

	public Filmes(String titulo, String descricao, String diretor, String genero, LocalDate dataDeLancamento,
			String urlImg, String urlTrailer, Integer duracao) {
		super(titulo, descricao, diretor, genero, dataDeLancamento, urlImg, urlTrailer);
		this.duracao = duracao;
	}

	public Filmes() {}
	
	@Override
	protected String definirTipoConteudo() {
		return "Filmes";
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	@Override
	public String toString() {
		return "Filmes [duracao=" + duracao + "]";
	}
	
}
