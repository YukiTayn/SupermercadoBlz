package sm.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sm.daos.DadosDAO;
import sm.daos.ProdutoDAO;
import sm.models.Produto;

@Controller
public class ProdutosController {

	ProdutoDAO pdao = new ProdutoDAO();
	DadosDAO ddao = new DadosDAO();

	// Link
	@RequestMapping("produtos/novo")
	public ModelAndView linkCadastro(HttpSession s) {

		String email = (String) s.getAttribute("email");
		ModelAndView mav = new ModelAndView();

		if (email != null && ddao.getTipoByEmail(email) == 3) {
			mav.setViewName("produtos/form");
		} else {
			mav.setViewName("acesso negado");
		}

		return mav;
	}

	// Funções
	@RequestMapping(value = "produtos/novo", method = RequestMethod.POST)
	public String cadastro(Produto p, HttpSession s) {

		String email = (String) s.getAttribute("email");

		if (email != null && ddao.getTipoByEmail(email) == 3) {
			pdao.inserir(p);
			return "redirect:produtos";
		} else {
			return "acesso negado";
		}

	}

	@RequestMapping(value = "produtos", method = RequestMethod.GET)
	public ModelAndView listar(HttpSession s) {

		String email = (String) s.getAttribute("email");
		ModelAndView mav = new ModelAndView();

		if (email != null && ddao.getTipoByEmail(email) == 3 || ddao.getTipoByEmail(email) == 2) {
			List<Produto> prod = pdao.getProdutos();

			ModelAndView m = new ModelAndView("produtos/lista");
			mav.setViewName("produtos/lista");
			mav.addObject("prod", prod);
		} else {
			List<Produto> prod = pdao.getProdutos();
			
			mav.setViewName("produtos/lista");
			mav.addObject("prod", prod);
		}

		return mav;

	}

	@RequestMapping(value = "produtos/pesquisa", method = RequestMethod.POST)
	public ModelAndView pesquisa(Produto p) {

		List<Produto> pesq = pdao.prodByName(p.getNome());
		ModelAndView modelAndView = new ModelAndView("produtos/pesquisa");
		modelAndView.addObject("pesq", pesq);

		return modelAndView;
	}

	@RequestMapping(value = "produtos/remover", method = RequestMethod.GET)
	public String remover(long id, HttpSession s) {

		String email = (String) s.getAttribute("email");

		if (email != null && ddao.getTipoByEmail(email) == 3) {
			pdao.apagar(id);
			return "redirect:produtos";
		} else {
			return "acesso negado";
		}

	}

}
