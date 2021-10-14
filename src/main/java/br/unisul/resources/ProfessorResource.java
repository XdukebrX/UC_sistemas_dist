package br.unisul.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.unisul.domain.Professor;
import br.unisul.services.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {

	@Autowired
	ProfessorService service;

	@PostMapping("/add")
	public void addProfessor(@RequestBody Professor p) {
		service.insereProfessor(p);
	}

	@GetMapping("/lista")
	public List<Professor> listaTodos() {
		return service.listaTodos();
	}

	@GetMapping("id/{id}")
	public Professor buscaPorId(@PathVariable(name = "id") Integer id) {
		return service.buscaPorId(id);
	}

	@GetMapping("exclui/{id}")
	public void exclui(@PathVariable(name = "id") Integer id) {
		service.exclui(id);
	}

	@PutMapping("altera/{id}")
	public Professor altera(@PathVariable(name = "id") Integer id, @RequestBody Professor p) {
		return service.altera(id, p);
	}

}
