package br.edu.utfpr.geo.restful;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.geo.dao.AreaProdutivaDAO;
import br.edu.utfpr.geo.dao.EndDeviceDAO;
import br.edu.utfpr.geo.dao.GatewayDAO;
import br.edu.utfpr.geo.entidade.AreaProdutiva;
import br.edu.utfpr.geo.entidade.EndDevice;
import br.edu.utfpr.geo.entidade.Gateway;

@Component
@RestController
@RequestMapping( "/api/enddevice" )
public class EndDeviceResource {
	
	
	private EndDeviceDAO noDAO;
	
	@GetMapping("/list")
	public List<EndDevice> listar() {
		noDAO = EndDeviceDAO.getInstance();
		return this.noDAO.listarNos();
	}
	
	@GetMapping("/listfromarea")
	public List<EndDevice> listar(@RequestParam("areaNome") String areaNome) {
		noDAO = EndDeviceDAO.getInstance();
		return this.noDAO.listarNosFromArea(areaNome);
	}
	
	@PostMapping( "/insert" )
	public void cadastrar( @RequestBody EndDevice no )
	{
		noDAO = EndDeviceDAO.getInstance();
		System.out.println(no);
		this.noDAO.inserirEndDevice(no, no.getX(), no.getY());
	}
	
	@GetMapping("/remove")
	public void remover(@RequestParam("identificador") String identificador) {
		noDAO = EndDeviceDAO.getInstance();
		this.noDAO.removerEndDevice(identificador);
	}

}
