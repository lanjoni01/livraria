package br.com.livraria.repository;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.com.livraria.domain.Autor;
import br.com.livraria.domain.Editora;
import br.com.livraria.domain.Endereco;
import br.com.livraria.domain.Livro;


@SpringBootApplication
public class AppRepository implements CommandLineRunner {
	
	@Autowired
	private EntityManagerFactory factory;
	
	public static void main(String[] args) {
        SpringApplication.run(AppRepository.class, args).close();
    }
	
	
    public void run(String... args) throws Exception {
    	EntityManager em = factory.createEntityManager();
		
		Autor autor = new Autor("Leo");
		Endereco endereco = new Endereco("Rua Brasil", "Centro", "Maringá", 4875);
		autor.setEndereco(endereco);
		Editora editora = new Editora("Editora A");

		Livro livro = new Livro("Clean code", Calendar.getInstance());
		editora.adicionarLivro(livro);
		autor.adicionarLivro(livro);

		em.getTransaction().begin();

		em.persist(livro);
		em.persist(endereco);
		em.persist(autor);
		em.persist(autor);
		em.persist(editora);

		em.getTransaction().commit();
		em.close();
	}

}
