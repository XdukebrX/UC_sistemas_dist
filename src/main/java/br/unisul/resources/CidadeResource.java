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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.unisul.domain.Cidade;
import br.unisul.services.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {

	@Autowired
	CidadeService service;

	@GetMapping("/lista")
	public List<Cidade> listaTodos() {
		return service.listaTodos();
	}

	@PostMapping("/add")
	public void addAluno(@RequestBody Cidade c) {
		service.insereCidade(c);
	}

	@GetMapping("id/{id}")
	public Cidade buscaPorId(@PathVariable(name = "id") Integer id) {
		return service.buscaPorId(id);
	}

	@GetMapping("nome")
	public List<Cidade> buscaPorNome(@RequestParam(name = "nome") String nome) {
		return service.buscaPorNome(nome);
	}

	@DeleteMapping("exclui/{id}")
	public void exclui(@PathVariable(name = "id") Integer id) {
		service.exclui(id);
	}

	@PutMapping("altera/{id}")
	public Cidade altera(@PathVariable(name = "id") Integer id, @RequestBody Cidade c) {
		return service.altera(id, c);
	}

}
