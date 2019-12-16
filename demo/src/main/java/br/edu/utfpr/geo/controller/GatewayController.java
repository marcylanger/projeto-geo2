package br.edu.utfpr.geo.controller;

import java.util.List;

import br.edu.utfpr.geo.dao.GatewayDAO;
import br.edu.utfpr.geo.entidade.Gateway;

public class GatewayController {

	GatewayDAO dao = GatewayDAO.getInstance();

	public void inserirGateway(Gateway gateway, Float x1, Float y1) {
		dao.inserirGateway(gateway, x1, y1);
	}
	

	public void removerGateway(String identificador) {
		dao.removerGateway(identificador);
	}
	
	public List<Gateway> listarGatewayFromArea(String identificadorArea) {
		return dao.listarGatewayFromArea(identificadorArea);
	}
	
	public List<Gateway> listarGateways() {
		return dao.listarGateways();
	}
}
