package sm.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sm.daos.DadosDAO;
import sm.models.Dados;

@Controller
public class DadosController {

	DadosDAO ddao = new DadosDAO();
	Dados d = new Dados();
	
	@RequestMapping(value="dados/listar", method=RequestMethod.GET)
	public ModelAndView listar() {
		
		List<Dados> dados = ddao.getLista();
		
		ModelAndView modelAndView = new ModelAndView("dados/listar");
		modelAndView.addObject("dados", dados);
		
		return modelAndView;
	}
	
	@RequestMapping(value="dados/apagar", method=RequestMethod.GET)
	public ModelAndView apagar() {
		
		ModelAndView modelAndView = new ModelAndView("dados/apagar");
		return modelAndView;
	}
	
	@RequestMapping(value="dados/apagar", method=RequestMethod.POST)
	public ModelAndView apagar(String email, String senha) {
		
		d.setEmail(email);
		d.setSenha(senha);
		
		if(ddao.remover(d) == true) {
			System.out.println("Apagado com sucesso");
		}else {
			System.out.println("Erro ao apagar");
		}
		
		return listar();
	}

	
	//Alterar
	@RequestMapping(value="dados/alterar", method=RequestMethod.GET)
	public ModelAndView alterar(long id) {
		
		d = ddao.getByID(id);
		
		ModelAndView modelAndView = new ModelAndView("dados/alterar");
		modelAndView.addObject("dados", d);
		
		return modelAndView;
	}
	
	@RequestMapping(value="dados/alterar", method=RequestMethod.POST)
	public ModelAndView alterar(Dados d) {
		
		ddao.alterar(d);
		
		return listar();
	}
	
	
	//Chamados dos forms
	@RequestMapping("dados/cliente")
	public String cliente() {
		
		return "dados/cliente/form";
	}
	
	@RequestMapping("dados/entregador")
	public String entregador() {
		
		return "dados/entregador/form";
	}
	
	@RequestMapping("dados/asdf")
	public String gerente() {
		
		return "dados/gerente/form";
	}
	
	@RequestMapping("dados/qwerty")
	public String vendedor() {
		
		return "dados/vendedor/form";
	}
	
	
	//Cadastros
	@RequestMapping(value="dados/cliente", method=RequestMethod.POST)
	public ModelAndView cliente(Dados d) {
		
		d.setTipo(1);
		ddao.novo(d);
		
		return listar();
	}
	
	@RequestMapping(value="dados/ent", method=RequestMethod.POST)
	public ModelAndView entregador(Dados d) {
		
		d.setTipo(5);
		ddao.novo(d);
		
		return listar();
	}
	
	@RequestMapping(value="dados/gerente", method=RequestMethod.POST)
	public ModelAndView gerente(Dados d) {
		
		d.setTipo(3);
		ddao.novo(d);
		
		return listar();
	}
	
	@RequestMapping(value="dados/vendedor", method=RequestMethod.POST)
	public ModelAndView vendedor(Dados d) {
		
		d.setTipo(2);
		ddao.novo(d);
		
		return listar();
	}
	
}
