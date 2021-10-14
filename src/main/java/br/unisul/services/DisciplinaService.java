package br.unisul.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import br.unisul.domain.Disciplina;
import br.unisul.domain.Professor;
import br.unisul.repositories.DisciplinaRepository;
import br.unisul.repositories.ProfessorRepository;

@Service
public class DisciplinaService {

	@Autowired
	DisciplinaRepository repository;

	@Autowired
	ProfessorRepository professorRepository;

	public void insereDisciplina(Disciplina d) {
		Professor p = professorRepository.getById(d.getProfessor().getId());
		if (p != null)
			d.setProfessor(p);
		repository.save(d);
	}

	public List<Disciplina> listaTodos() {
		return repository.findAll();
	}

	public Disciplina buscaPorId(Integer id) {
		return repository.findById(id).get();

	}

	public void exclui(Integer id) {
		Disciplina d = buscaPorId(id);
		if (d != null)
			repository.delete(d);
	}

	@PutMapping("altera/{id}")
	public Disciplina altera(Integer id, Disciplina d) {
		Disciplina db = buscaPorId(id);
		db.setNome(d.getNome());
		Professor p = professorRepository.getById(d.getProfessor().getId());
		db.setProfessor(p);
		repository.save(db);
		return db;
	}

}
