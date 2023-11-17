package br.com.cine.model.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "series")
@DiscriminatorValue("SERIE")
public class Series extends Conteudo {

	@Column(name = "temporadas")
	private Integer temporadas;

	public Series(String titulo, String descricao, String diretor, String genero, LocalDate dataDeLancamento,
			String urlImg, String urlTrailer, Integer temporadas) {
		super(titulo, descricao, diretor, genero, dataDeLancamento, urlImg, urlTrailer);
		this.temporadas = temporadas;
	}

	public Series() {}

	public Integer getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(Integer temporadas) {
		this.temporadas = temporadas;
	}

	@Override
	protected String definirTipoConteudo() {
		return "Series";
	}
}
