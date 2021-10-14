package br.unisul.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Service;
import br.unisul.domain.Cidade;

@Service
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	List<Cidade> findByNome(String nome);

}
