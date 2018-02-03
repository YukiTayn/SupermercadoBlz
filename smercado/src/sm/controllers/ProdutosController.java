package sm.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sm.daos.ProdutoDAO;
import sm.models.Produto;

@Controller
public class ProdutosController {

	ProdutoDAO pdao = new ProdutoDAO();
	Produto p = new Produto();
	
	//Link
	@RequestMapping("produtos/novo")
	public ModelAndView linkCadastro() {
		
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		
		return modelAndView;
	}
	
	
	//Funções
	@RequestMapping(value="produtos/novo", method=RequestMethod.POST)
	public ModelAndView cadastro(Produto p) {
		
		pdao.inserir(p);
		return listar();
		
	}
	
	@RequestMapping(value="produtos", method=RequestMethod.GET)
	public ModelAndView listar() {
		
		List<Produto> prod = pdao.getProdutos();
		
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("prod", prod);
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="produtos/pesquisa", method=RequestMethod.POST)
	public ModelAndView pesquisa(String algo) {
		
		List<Produto> pesq = pdao.prodByName(algo);
		ModelAndView modelAndView = new ModelAndView("produtos/pesquisa");
		modelAndView.addObject("pesq", pesq);
		
		return modelAndView;
	}
	
	@RequestMapping(value="produtos/remover", method=RequestMethod.GET)
	public ModelAndView remover(long id) {
		
		pdao.apagar(id);
		return listar();
		
	}
	
	
	
}
