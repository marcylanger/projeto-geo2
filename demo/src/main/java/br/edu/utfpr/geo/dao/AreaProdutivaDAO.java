package br.edu.utfpr.geo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.utfpr.geo.entidade.AreaProdutiva;

public class AreaProdutivaDAO {

	private static AreaProdutivaDAO instance;
	protected EntityManager entityManager;

	public static AreaProdutivaDAO getInstance() {
		if (instance == null) {
			instance = new AreaProdutivaDAO();
		}

		return instance;
	}

	private AreaProdutivaDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("meuProjetoJpa");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
	
	public void inserirAreaProdutiva(AreaProdutiva area, String x1, String y1) {
		/*
		 * SELECT * FROM adicionar_area('', 'ÁREA PRODUTIVA MISSAL 2', array[-54.1445, -54.1443, -54.1440, -54.1440, -54.1445], 
							 array[-25.0456, -25.0453, -25.0454, -25.0456, -25.0456]);

		 */
		
		String x1Array = "array["+x1+"]";
		
		
		System.out.println(x1Array);
		
		String y1Array = "array["+y1+"]";
		
		
		System.out.println(y1Array);
		
		Query query = this.entityManager.createNativeQuery("SELECT adicionar_area(:descricao, :nome, "+ x1Array+", "+ y1Array +")");
		query.setParameter("descricao", area.getDescricao());
		query.setParameter("nome", area.getNome());

		
		query.getResultList();
		System.out.println("Inseriu area produtiva");
	}
	
	public void inserirAreaProdutiva(AreaProdutiva area, Float[] x1, Float[] y1) {
		/*
		 * SELECT * FROM adicionar_area('', 'ÁREA PRODUTIVA MISSAL 2', array[-54.1445, -54.1443, -54.1440, -54.1440, -54.1445], 
							 array[-25.0456, -25.0453, -25.0454, -25.0456, -25.0456]);

		 */
		
		String x1Array = "array[";
		for (int i = 0; i < x1.length; i++) {
			x1Array = x1Array + x1[i];
			if((i+1) == x1.length) {
				x1Array = x1Array + "]";
			} else {
				x1Array = x1Array + ", ";
			}
			
		}
		
		System.out.println(x1Array);
		
		String y1Array = "array[";
		for (int i = 0; i < y1.length; i++) {
			y1Array = y1Array + y1[i];
			if((i+1) == y1.length) {
				y1Array = y1Array + "]";
			} else {
				y1Array = y1Array + ", ";
			}
			
		}
		
		System.out.println(y1Array);
		
		Query query = this.entityManager.createNativeQuery("SELECT adicionar_area(:descricao, :nome, "+ x1Array+", "+ y1Array +")");
		query.setParameter("descricao", area.getDescricao());
		query.setParameter("nome", area.getNome());

		
		query.getResultList();
		System.out.println("Inseriu area produtiva");
	}
	
	public void removerAreaProdutiva(String nome) {
		Query query = this.entityManager.createNativeQuery("SELECT * FROM remover_area(:nome)");
		query.setParameter("nome", nome);
		
		query.getResultList();
		System.out.println("Removeu área produtiva");
	}

	
	public List<AreaProdutiva> listarAreas() {
		System.out.println("Listou todas as áreas");
		return entityManager.createQuery("FROM " + AreaProdutiva.class.getName()).getResultList();

	}
	
	public List<AreaProdutiva> detalharAreaProdutiva(String nome) {
		System.out.println("Detalhou área produtiva "+nome);
		return entityManager.createQuery("FROM " + AreaProdutiva.class.getName() + " where nome = '" + nome +"'").getResultList();

	}



}
