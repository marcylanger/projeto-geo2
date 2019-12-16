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
import br.edu.utfpr.geo.entidade.AreaProdutiva;

@Component
@RestController
@RequestMapping( "/api/areaprodutiva" )
public class AreaProdutivaResource {
	
	
	private AreaProdutivaDAO areaDAO;
	
	@GetMapping("/list")
	public List<AreaProdutiva> listar() {
		areaDAO = AreaProdutivaDAO.getInstance();
		return this.areaDAO.listarAreas();
	}
	
	@PostMapping( "/insert" )
	public void cadastrar( @RequestBody AreaProdutiva area )
	{
		areaDAO = AreaProdutivaDAO.getInstance();
		this.areaDAO.inserirAreaProdutiva(area, area.getX(), area.getY());
	}
	
	@GetMapping("/remove")
	public void remover(@RequestParam("nome") String nome) {
		areaDAO = AreaProdutivaDAO.getInstance();
		this.areaDAO.removerAreaProdutiva(nome);
	}
	
	@GetMapping("/find")
	public List<AreaProdutiva> detalhar(@RequestParam("nome") String nome) {
		areaDAO = AreaProdutivaDAO.getInstance();
		return this.areaDAO.detalharAreaProdutiva(nome);
	}
	
	

}
