package br.com.livraria.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	
	private Calendar anoPublicacao;
	
	public Livro(String titulo, Calendar anoPublicacao) {
		super();
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
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

	public Calendar getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Calendar anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	
	
	

}
