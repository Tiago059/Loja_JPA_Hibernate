package br.com.alura.loja.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
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
