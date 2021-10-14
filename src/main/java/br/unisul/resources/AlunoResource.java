package br.unisul.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.unisul.domain.Aluno;
import br.unisul.services.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoResource {

	@Autowired
	AlunoService service;

	@PostMapping("/add")
	public void addAluno(@RequestBody Aluno a) {
		service.insereAluno(a);
	}

	@GetMapping("/lista")
	public List<Aluno> listaTodos() {
		return service.listaTodos();
	}

	@GetMapping("id/{id}")
	public Aluno buscaPorId(@PathVariable(name = "id") Integer id) {
		return service.buscaPorId(id);
	}

	@GetMapping("nome")
	public List<Aluno> buscaPorNome(@RequestParam(name = "nome") String nome) {
		return service.buscaPorNome(nome);
	}

	@GetMapping("exclui/{id}")
	public void exclui(@PathVariable(name = "id") Integer id) {
		service.exclui(id);
	}

	@PutMapping("altera/{id}")
	public Aluno altera(@PathVariable(name = "id") Integer id, @RequestBody Aluno a) {
		return service.altera(id, a);
	}

}
