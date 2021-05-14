package br.com.alura.loja.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.util.JPAUtil;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		// cadastrarProduto();
		procurarProduto(3l);

	}

	public static void procurarProduto(Long id) {
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		//produtoDao.buscarPrecoPorNome("Master System").forEach( p -> System.out.println(p.getNome()) );
	
		System.out.println(produtoDao.buscarPrecoPorNome("Master System"));
	}

	private static void cadastrarProduto() {
		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		// Start transaction
		em.getTransaction().begin();

		// Make the party

		Categoria c = new Categoria("s");
		categoriaDao.cadastrar(c);

		Produto p = new Produto("Master System II", "Videogame 8-bit", new BigDecimal("800"), c);
		produtoDao.cadastrar(p);

		// Commit to validate changes and close transaction
		em.getTransaction().commit();

		em.close();
	}
}
