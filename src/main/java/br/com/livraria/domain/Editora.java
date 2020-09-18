package br.com.livraria.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "editora_id")
	private List<Livro> livrosPublicados;

	public Editora(String nome) {
		super();
		this.nome = nome;
		this.livrosPublicados = new ArrayList<Livro>();;
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

	public List<Livro> getLivrosPublicados() {
		return livrosPublicados;
	}

	public void adicionarLivro(Livro livro) {
		this.livrosPublicados.add(livro);
	}
	
	
}
