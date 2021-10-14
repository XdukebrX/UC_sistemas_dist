package br.unisul.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.domain.Aluno;
import br.unisul.domain.Disciplina;
import br.unisul.domain.Matricula;
import br.unisul.repositories.AlunoRepository;
import br.unisul.repositories.DisciplinaRepository;
import br.unisul.repositories.MatrículaRepository;

@Service
public class MatrículaService {

	@Autowired
	MatrículaRepository repository;

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	DisciplinaRepository disciplinaRepository;

	public void insereMatricula(Matricula m) {
		Aluno a = alunoRepository.getById(m.getId().getAluno().getId());
		Disciplina d = disciplinaRepository.getById(m.getId().getDisciplina().getId());
		if (a != null && d != null) {
			m.getId().setAluno(a);
			m.getId().setDisciplina(d);
			repository.save(m);
		}
	}

	public List<Matricula> listaTodos() {
		return repository.findAll();
	}

	public Matricula buscaPorId(Integer id) {
		return repository.findById(id).get();
	}

	public void exclui(Integer id) {
		Matricula m = buscaPorId(id);
		if (m != null)
			repository.delete(m);
	}

	public Matricula altera(Integer id, Matricula m) {
		Matricula bd = buscaPorId(id);
		bd.setSemestre(m.getSemestre());
		Aluno a = alunoRepository.getById(m.getId().getAluno().getId());
		Disciplina d = disciplinaRepository.getById(m.getId().getDisciplina().getId());
		if (a != null && d != null) {
			m.getId().setAluno(a);
			m.getId().setDisciplina(d);
			repository.save(m);
		}
		return bd;
	}

}