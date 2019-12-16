package br.edu.utfpr.geo.restful;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.geo.dao.GatewayDAO;
import br.edu.utfpr.geo.entidade.EndDevice;
import br.edu.utfpr.geo.entidade.Gateway;

@Component
@RestController
@RequestMapping( "/api/gateway" )
public class GatewayResource {
	
	
	private GatewayDAO gDAO;
	
	@GetMapping("/list")
	public List<Gateway> listar() {
		gDAO = GatewayDAO.getInstance();
		return this.gDAO.listarGateways();
	}
	

	@GetMapping("/listfromarea")
	public List<Gateway> listar(@RequestParam("areaNome") String areaNome) {
		System.out.println("listfromarea");
		gDAO = GatewayDAO.getInstance();
		return this.gDAO.listarGatewayFromArea(areaNome);
				
	}
	
	@PostMapping( "/insert" )
	public void cadastrar( @RequestBody Gateway gateway )
	{
		gDAO = GatewayDAO.getInstance();
		System.out.println(gateway);
		this.gDAO.inserirGateway(gateway, gateway.getX(), gateway.getY());
	}
	
	@GetMapping("/remove")
	public void remover(@RequestParam("identificador") String identificador) {
		gDAO = GatewayDAO.getInstance();
		this.gDAO.removerGateway(identificador);
	}

}
