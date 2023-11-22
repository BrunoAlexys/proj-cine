package br.com.cine.model.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "conteudos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_conteudo", discriminatorType = DiscriminatorType.STRING)
public abstract class Conteudo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "conteudo_id")
	private Long id;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "diretor")
	private String diretor;

	@Column(name = "genero")
	private String genero;

	@Column(name = "data_de_lancamento")
	private LocalDate dataDeLancamento;

	@Column(name = "url_img")
	private String urlImg;

	@Column(name = "url_trailer")
	private String urlTrailer;

	@Column(name = "ativo")
	private Boolean ativo;

	@Column(name = "tipo_conteudo", insertable = false, updatable = false)
	private String tipoConteudo;
	
	@Column(name = "avaliacao_id")
	@OneToMany
	private List<Avaliacoes> listAvaliacoes;

	public Conteudo(String titulo, String descricao, String diretor, String genero, LocalDate dataDeLancamento,
			String urlImg, String urlTrailer) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.diretor = diretor;
		this.genero = genero;
		this.dataDeLancamento = dataDeLancamento;
		this.urlImg = urlImg;
		this.urlTrailer = urlTrailer;
		this.ativo = true;
		this.tipoConteudo = definirTipoConteudo();
	}

	public Conteudo() {}
	
	protected abstract String definirTipoConteudo();

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

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getDataDeLancamento() {
		return dataDeLancamento;
	}

	public void setDataDeLancamento(LocalDate dataDeLancamento) {
		this.dataDeLancamento = dataDeLancamento;
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Conteudo [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", genero=" + genero
				+ ", urlImg=" + urlImg + ", urlTrailer=" + urlTrailer + ", ativo=" + ativo + "]";
	}
}
