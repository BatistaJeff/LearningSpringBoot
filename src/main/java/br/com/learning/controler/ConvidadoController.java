package br.com.learning.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.learning.email.EnviadorEmail;
import br.com.learning.modelo.ConvidadoModel;
import br.com.learning.repositorio.ConvidadoRepository;
import br.com.learning.servico.ConvidadoService;


@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoService service;
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {

		Iterable<ConvidadoModel> convidados = service.obterTodos();

		model.addAttribute("convidados", convidados);

		return "listaconvidados";

	}
	
	@RequestMapping(value = "salvar" , method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, 
						 @RequestParam("email") String email,
						 @RequestParam("telefone") String telefone,
						 Model model) {
		
		ConvidadoModel convidado = new ConvidadoModel(nome, email, telefone);

		service.salvar(convidado);

		//Esse trecho de 2 linhas são para enviar email, eu utilizo isso de um projeto externo "enviadorEmail"
		EnviadorEmail enviadorEmail = new EnviadorEmail();
		enviadorEmail.enviar(nome, email);
		
		return listaConvidados(model);
	}

}
