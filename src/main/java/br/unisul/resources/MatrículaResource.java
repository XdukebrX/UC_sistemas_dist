package br.unisul.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.unisul.domain.Matricula;
import br.unisul.services.MatrículaService;

@RestController
@RequestMapping("/matricula")
public class MatrículaResource {
	
	@Autowired
	MatrículaService service;
	
	@PostMapping("/add")
	public void addMatricula(@RequestBody Matricula m) {
		service.insereMatricula(m);
	}
	
	@GetMapping("/lista")
	public List<Matricula> listaTodos(){
		return service.listaTodos();
	}
	
	@GetMapping("id/{id}")
	public Matricula buscaPorId(@PathVariable(name = "id") Integer id) {
		return service.buscaPorId(id);
	}
	
	@DeleteMapping("exclui/{id}")
	public void exclui(@PathVariable(name = "id") Integer id) {
		service.exclui(id);
	}
	
	@PutMapping("altera/{id}")
	public Matricula altera(@PathVariable(name = "id") Integer id, @RequestBody Matricula m) {
		return service.altera(id, m);
	}

}