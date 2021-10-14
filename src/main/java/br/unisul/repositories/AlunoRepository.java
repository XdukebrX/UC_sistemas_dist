package br.unisul.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.unisul.domain.Aluno;

@Service
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
	
	List<Aluno> findByNome(String nome);

}
