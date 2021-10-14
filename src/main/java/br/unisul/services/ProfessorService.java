package br.unisul.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import br.unisul.domain.Professor;
import br.unisul.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository repository;

	public void insereProfessor(Professor p) {
		repository.save(p);
	}

	public List<Professor> listaTodos() {
		return repository.findAll();
	}

	public Professor buscaPorId(Integer id) {
		return repository.findById(id).get();

	}

	public void exclui(Integer id) {
		Professor p = buscaPorId(id);
		if (p != null)
			repository.delete(p);
	}

	@PutMapping("altera/{id}")
	public Professor altera(Integer id, Professor p) {
		Professor db = buscaPorId(id);
		db.setNome(p.getNome());
		db.setFormacao(p.getFormacao());
		repository.save(db);
		return db;
	}

}
