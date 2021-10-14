package br.unisul.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.domain.Cidade;
import br.unisul.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository repository;

	public List<Cidade> buscaPorNome(String nome) {
		return repository.findByNome(nome);
	}

	public void insereCidade(Cidade c) {
		repository.save(c);
	}

	public List<Cidade> listaTodos() {
		return repository.findAll();
	}

	public Cidade buscaPorId(Integer id) {
		return repository.findById(id).get();
	}

	public void exclui(Integer id) {
		repository.delete(buscaPorId(id));
	}

	public Cidade altera(Integer id, Cidade c) {
		Cidade bd = buscaPorId(id);
		bd.setNome(c.getNome());
		bd.setUf(c.getUf());
		repository.save(bd);
		return bd;
	}

}
