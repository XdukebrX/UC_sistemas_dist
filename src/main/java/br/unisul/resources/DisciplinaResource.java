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
import br.unisul.domain.Disciplina;
import br.unisul.services.DisciplinaService;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {

	@Autowired
	DisciplinaService service;

	@PostMapping("/add")
	public void addDisciplina(@RequestBody Disciplina d) {
		service.insereDisciplina(d);
	}

	@GetMapping("/lista")
	public List<Disciplina> listaTodos() {
		return service.listaTodos();
	}

	@GetMapping("id/{id}")
	public Disciplina buscaPorId(@PathVariable(name = "id") Integer id) {
		return service.buscaPorId(id);
	}

	@GetMapping("exclui/{id}")
	public void exclui(@PathVariable(name = "id") Integer id) {
		service.exclui(id);
	}

	@PutMapping("altera/{id}")
	public Disciplina altera(@PathVariable(name = "id") Integer id, @RequestBody Disciplina d) {
		return service.altera(id, d);
	}

}
