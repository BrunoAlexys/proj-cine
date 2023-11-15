package br.com.cine.model.entities;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "series")
public class Series {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "series_id")
	private Long id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "temporadas")
	private Integer temporadas;
	@Column(name = "diretor")
	private String diretor;
	@Column(name = "data_lancamento")
	private LocalDate dataDeLancamento;
	private String genero;
	@Column(name = "url_img")
	private String urlImg;
	@Column(name = "url_trailer")
	private String urlTrailer;
	@Column(name = "ativo")
	private boolean ativo;
	
    @OneToMany(mappedBy = "series")
	private List<Avaliacoes> listAvaliacoes;
    
	public Series(String titulo, String descricao, Integer temporadas, String diretor, LocalDate dataDeLancamento,
			String genero, String urlImg, String urlTrailer) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.temporadas = temporadas;
		this.diretor = diretor;
		this.dataDeLancamento = dataDeLancamento;
		this.genero = genero;
		this.urlImg = urlImg;
		this.urlTrailer = urlTrailer;
		this.ativo = true;
	}
	
	public Series() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(Integer temporadas) {
		this.temporadas = temporadas;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public LocalDate getDataDeLancamento() {
		return dataDeLancamento;
	}

	public void setDataDeLancamento(LocalDate dataDeLancamento) {
		this.dataDeLancamento = dataDeLancamento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public String getUrlTrailer() {
		return urlTrailer;
	}

	public void setUrlTrailer(String urlTrailer) {
		this.urlTrailer = urlTrailer;
	}

    public List<Avaliacoes> getListAvaliacoes() {
        return listAvaliacoes;
    }

    public void setListAvaliacoes(List<Avaliacoes> listAvaliacoes) {
        this.listAvaliacoes = listAvaliacoes;
    }

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}



