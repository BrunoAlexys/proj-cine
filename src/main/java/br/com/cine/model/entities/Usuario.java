package br.com.cine.model.entities;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "sobrenome")
	private String sobrenome;
	@Column(name = "email")
	private String email;
	@Column(name = "senha")
	private String senha;
	@Column(name = "data_nascimento")
	private LocalDate dataDeNascimento;
	@Column(name = "genero")
	private String genero;
	@Column(name = "ativo")
	private Boolean ativo;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<Avaliacoes> listAvaliacoes;
	
	public Usuario(String nome, String sobrenome, String email, String senha, LocalDate dataDeNascimento,
			String genero) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.dataDeNascimento = dataDeNascimento;
		this.genero = genero;
		this.ativo = true;
	}	
	
	public Usuario() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public List<Avaliacoes> getListAvaliacoes() {
		return listAvaliacoes;
	}

	public void setListAvaliacoes(List<Avaliacoes> listAvaliacoes) {
		this.listAvaliacoes = listAvaliacoes;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", senha="
				+ senha + ", dataDeNascimento=" + dataDeNascimento + ", genero=" + genero + ", ativo=" + ativo
				+ ", listAvaliacoes=" + listAvaliacoes + "]";
	}

}

