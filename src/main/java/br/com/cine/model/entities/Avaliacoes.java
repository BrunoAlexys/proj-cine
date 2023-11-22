package br.com.cine.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacoes")
public class Avaliacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "avaliacoes_id")
	private Long id;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "avaliacoes")
	private String avaliacao;

	@Column(name = "classificacao")
	private Integer classificacao;

	@Column(name = "ativo")
	private Boolean ativo = true;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "conteudo_id")
	private Conteudo conteudo;

	public Avaliacoes(String titulo, String avaliacao, Integer classificacao, Usuario usuario, Conteudo conteudo) {
		this.titulo = titulo;
		this.avaliacao = avaliacao;
		this.classificacao = classificacao;
		this.usuario = usuario;
		this.conteudo = conteudo;
		this.ativo = true;
	}

	public Avaliacoes() {
	}

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

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Integer getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Avaliacoes [id=" + id + ", titulo=" + titulo + ", avaliacao=" + avaliacao + ", classificacao="
				+ classificacao + ", ativo=" + ativo + ", usuario=" + usuario + ", conteudo=" + conteudo + "]";
	}

}
