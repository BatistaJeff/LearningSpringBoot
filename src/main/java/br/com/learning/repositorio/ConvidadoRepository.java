package br.com.learning.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.learning.modelo.ConvidadoModel;

public interface ConvidadoRepository extends CrudRepository<ConvidadoModel, Long> {

	
}
