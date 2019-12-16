package br.edu.utfpr.geo.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.edu.utfpr.geo.entidade.EndDevice;
import br.edu.utfpr.geo.entidade.Gateway;

public class GatewayDAO {

	private static GatewayDAO instance;
	protected EntityManager entityManager;

	public static GatewayDAO getInstance() {
		if (instance == null) {
			instance = new GatewayDAO();
		}

		return instance;
	}

	private GatewayDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("meuProjetoJpa");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
	
	public void inserirGateway(Gateway gateway, Float x1, Float y1) {
		System.out.println(x1);
		System.out.println(y1);
		Query query = this.entityManager.createNativeQuery("SELECT adicionar_gateway(:identificador, :raio, :x1, :y1)");
		query.setParameter("identificador", gateway.getIdentificador());
		query.setParameter("raio", gateway.getRaioAlcance());
		query.setParameter("x1", x1);
		query.setParameter("y1", y1);
		
		query.getResultList();
		System.out.println("Inseriu gateway");
	}
	
	public void removerGateway(String identificador) {
		Query query = this.entityManager.createNativeQuery("SELECT * FROM remover_gateway(:identificador)");
		query.setParameter("identificador", identificador);
		
		query.getResultList();
		System.out.println("Removeu gateway");
	}

	public List<Gateway> listarGatewayFromArea(String identificadorArea) {

		Query query = this.entityManager.createNativeQuery("SELECT id FROM gateways_area(:identificador)");
		query.setParameter("identificador", identificadorArea);

		List<BigInteger> ids = (List<BigInteger>) query.getResultList();

		/*List<Gateway> gateways = new ArrayList<Gateway>();
		for (BigInteger id : ids) {
			Gateway gateway = entityManager.find(Gateway.class, Long.parseLong(id.toString()));
			gateways.add(gateway);
		}*/
		System.out.println("Listou gateways de uma área produtiva");

		String filtroIds = "(";
		for (int i = 0; i < ids.size(); i++) {
			filtroIds = filtroIds + ids.get(i);
			if((i+1) == ids.size()) {
				filtroIds = filtroIds + ")";
			} else {
				filtroIds = filtroIds + ", ";
			}
			
		}
		return entityManager.createQuery("FROM " + Gateway.class.getName() + " where id IN "+filtroIds).getResultList();


	}


	public List<Gateway> listarGateways() {
		System.out.println("Listou todos os gateways");
		return entityManager.createQuery("FROM " + Gateway.class.getName()).getResultList();

	}

}
