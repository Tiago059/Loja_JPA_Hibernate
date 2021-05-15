package br.com.alura.loja.main;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

@SuppressWarnings("unused")
public class Main {
	
	private static final EntityManager em = JPAUtil.getEntityManager();
	private static final ProdutoDao produtoDao = new ProdutoDao(em);
	private static final CategoriaDao categoriaDao = new CategoriaDao(em);
	private static final PedidoDao pedidoDao = new PedidoDao(em);
	private static final ClienteDao clienteDao = new ClienteDao(em);

	public static void main(String[] args) {
		//cadastrarProduto();
		// procurarProduto(3l);
		// cadastrarNovoPedido(6, 1l, 3l);
		// System.out.println(pedidoDao.valorTotalVendido());
		// pedidoDao.relatorioDeVendas().forEach(System.out::println);
		Pedido p = pedidoDao.buscarPedidoComCliente(1l);
		System.out.println(p.getCliente().getDadosPessoais().getNome());
		//produtoDao.buscarPorParametros(null, new BigDecimal("800"), null).forEach(System.out::println);;
		
		
		em.close();
		

	}

	public static void cadastrarNovoPedido(int qtd, Long clienteId, Long produtoId) {
			// Start transaction
			em.getTransaction().begin();
	
			// Make the party
			// clienteDao.cadastrar(new Cliente("Inglyd", "15061998"));
			
			Produto produto = produtoDao.buscarPorId(produtoId);
			
			Pedido pedido = new Pedido(clienteDao.buscarPorId(clienteId));
			pedido.adicionarItem(new ItemPedido(qtd, pedido, produto));
			pedido.adicionarItem(new ItemPedido(qtd * 2, pedido, produto));
			
			pedidoDao.cadastrar(pedido);
			
			// Commit to validate changes and close transaction
			em.getTransaction().commit();
	}

	public static void procurarProduto(Long id) {
		//produtoDao.buscarPrecoPorNome("Master System").forEach( p -> System.out.println(p.getNome()) );
	
		System.out.println(produtoDao.buscarPrecoPorNome("Master System"));
	}

	private static void cadastrarProduto() {
		// Start transaction
		em.getTransaction().begin();

		// Make the party

		Categoria c = new Categoria("Celulares");
		categoriaDao.cadastrar(c);

		Produto p = new Produto("Xiaomi Redmi 6A", "Celular", new BigDecimal("500"), c);
		produtoDao.cadastrar(p);

		// Commit to validate changes and close transaction
		em.getTransaction().commit();

	}
}