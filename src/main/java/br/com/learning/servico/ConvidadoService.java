package br.com.learning.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.learning.modelo.ConvidadoModel;
import br.com.learning.repositorio.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository repositorio;
	
	public Iterable<ConvidadoModel> obterTodos(){
		
		Iterable<ConvidadoModel> convidados = repositorio.findAll();
		
		return convidados;
	}

	public void salvar(ConvidadoModel convidado) {
		
		repositorio.save(convidado);
	}
	
}
