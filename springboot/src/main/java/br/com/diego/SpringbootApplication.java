package br.com.diego;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.diego.domain.Categoria;
import br.com.diego.domain.Produto;
import br.com.diego.repositories.CategoriaRepository;
import br.com.diego.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Escritorio");
		Categoria cat2 = new Categoria(null, "Informática");
		Categoria cat3 = new Categoria(null, "Acessorios");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Notebook", 2999.00);
		Produto p3 = new Produto(null, "Tablet", 999.00);
		Produto p4 = new Produto(null, "Relogio", 799.00);
		Produto p5 = new Produto(null, "Impressora", 299.00);
		Produto p6 = new Produto(null, "Mouse", 20.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p5,p6));
		cat2.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat3.getProdutos().addAll(Arrays.asList(p4));
		
		p1.getCategorias().addAll(Arrays.asList(cat2));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		p4.getCategorias().addAll(Arrays.asList(cat3));
		p5.getCategorias().addAll(Arrays.asList(cat1));
		p6.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
	}

}
