package br.com.diego;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.diego.domain.Categoria;
import br.com.diego.domain.Cidade;
import br.com.diego.domain.Cliente;
import br.com.diego.domain.Endereco;
import br.com.diego.domain.Estado;
import br.com.diego.domain.Produto;
import br.com.diego.domain.enums.TipoCliente;
import br.com.diego.repositories.CategoriaRepository;
import br.com.diego.repositories.CidadeRepository;
import br.com.diego.repositories.ClienteRepository;
import br.com.diego.repositories.EnderecoRepository;
import br.com.diego.repositories.EstadoRepository;
import br.com.diego.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

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
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est1);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Diego", "diegoesilveira@gmail.com", "0123456789", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("05133643101", "05133445566"));
		
		Endereco e1 = new Endereco(null, "Rua Jose Huberto Bronca", "60", "Apto 300", "Sarandi", "91120010", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua João", "20", "", "São João", "91120010", cli1, c1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
	}

}
