package br.unisul.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import br.unisul.domain.Aluno;
import br.unisul.domain.Cidade;
import br.unisul.repositories.AlunoRepository;
import br.unisul.repositories.CidadeRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repository;

	@Autowired
	CidadeRepository cidadeRepository;

	public List<Aluno> buscaPorNome(String nome) {
		return repository.findByNome(nome);
	}

	public void insereAluno(Aluno a) {
		Cidade c = cidadeRepository.getById(a.getCidade().getId());
		if (c != null) {
			a.setCidade(c);
			repository.save(a);
		}
	}

	public List<Aluno> listaTodos() {
		return repository.findAll();
	}

	public Aluno buscaPorId(Integer id) {
		return repository.findById(id).get();

	}

	public void exclui(Integer id) {
		Aluno a = buscaPorId(id);
		if (a != null)
			repository.delete(a);
	}

	@PutMapping("altera/{id}")
	public Aluno altera(Integer id, Aluno a) {
		Aluno db = buscaPorId(id);
		db.setNome(a.getNome());
		db.setN1(a.getN1());
		db.setN2(a.getN2());
		db.setN3(a.getN3());
		Cidade c = cidadeRepository.getById(a.getCidade().getId());
		db.setCidade(c);
		repository.save(db);
		return db;
	}

}
