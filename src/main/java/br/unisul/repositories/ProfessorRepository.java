package br.unisul.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import br.unisul.domain.Professor;

	@Service
	public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

	}

