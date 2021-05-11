package br.com.alura.loja.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);

		// Start transaction
		em.getTransaction().begin();

		produtoDao.cadastrar(new Produto("Masyer System", "Videogame 8-bit", new BigDecimal("800")));

		// Commit to validate changes and close transaction
		em.getTransaction().commit();

	}
}
