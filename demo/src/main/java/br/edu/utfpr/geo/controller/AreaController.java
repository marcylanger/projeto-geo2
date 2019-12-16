package br.edu.utfpr.geo.controller;

import java.util.List;

import br.edu.utfpr.geo.dao.AreaProdutivaDAO;
import br.edu.utfpr.geo.entidade.AreaProdutiva;

public class AreaController {

	AreaProdutivaDAO dao = AreaProdutivaDAO.getInstance();

	public void inserirAreaProdutiva(AreaProdutiva area, Float[] x1, Float[] y1) {
		dao.inserirAreaProdutiva(area, x1, y1);
	}
	
	
	public void inserirAreaProdutiva(AreaProdutiva area, String x1, String y1) {
		dao.inserirAreaProdutiva(area, x1, y1);
	}
	
	public void removerAreaProdutiva(String nome) {
		dao.removerAreaProdutiva(nome);
	}
	
	public List<AreaProdutiva> listarAreas() {
		return dao.listarAreas();
	}
	

}
