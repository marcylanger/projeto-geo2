package br.edu.utfpr.geo.controller;

import java.util.List;

import br.edu.utfpr.geo.dao.EndDeviceDAO;
import br.edu.utfpr.geo.entidade.EndDevice;

public class EndDeviceController {

	EndDeviceDAO dao = EndDeviceDAO.getInstance();

	public void inserirEndDevice(EndDevice no, Float x1, Float y1) {
		dao.inserirEndDevice(no, x1, y1);
	}
	
	public void removerEndDevice(String identificador) {
		dao.removerEndDevice(identificador);
	}
	
	public List<EndDevice> listarNosFromArea(String identificadorArea) {
		return dao.listarNosFromArea(identificadorArea);
	}
	
	public List<EndDevice> listarNos() {
		return dao.listarNos();
	}
	
	public Integer getQuantidadeNosFromArea(String identificadorArea) {
		return dao.getQuantidadeNosFromArea(identificadorArea);
	}
	
	public Boolean verificaPosicaoNo(String identificadorNo, String identificadorGateway) {
		System.out.println("Nó " + identificadorNo);
		System.out.println("Gateway " + identificadorGateway);
		return dao.verificaPosicaoNo(identificadorNo, identificadorGateway);
	}
	

}
