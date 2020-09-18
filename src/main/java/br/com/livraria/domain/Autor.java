package br.com.livraria.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "autor_id")
	private List<Livro> livrosEscritos;
	
	@OneToOne
	@Column(name = "endereco_id")
	private Endereco endereco;

	public Autor(String nome) {
		super();
		this.nome = nome;
		livrosEscritos = new ArrayList<Livro>();
	}

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

	public List<Livro> getLivrosEscritos() {
		return livrosEscritos;
	}

	public void adicionarLivro(Livro livrosEscritos) {
		this.livrosEscritos.add(livrosEscritos);
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	

}
