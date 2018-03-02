package sm.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("produtos/novo")
	public ModelAndView linkCadastro(HttpSession s) {

		String email = (String) s.getAttribute("email");
		ModelAndView mav = new ModelAndView();

		if (email != null && ddao.getTipoByEmail(email) == 3 || ddao.getTipoByEmail(email) == 4) {
			mav.setViewName("produtos/form");
		} else {
			mav.setViewName("bkp/acessoNegado");
		}

		return mav;
	}

	// Funções
	@PostMapping(value = "produtos/novo")
	public String cadastro(Produto p, HttpSession s) {

		String email = (String) s.getAttribute("email");

		if (email != null && ddao.getTipoByEmail(email) == 3 || ddao.getTipoByEmail(email) == 4) {
			pdao.inserir(p);
			return "redirect:produtos";
		} else {
			return "redirect:bkp/acessoNegado";
		}

	}

	@GetMapping(value = "produtos")
	public ModelAndView listar(HttpSession s) {

		String email = (String) s.getAttribute("email");
		ModelAndView mav = new ModelAndView();

		if (email != null) {
			List<Produto> prod = pdao.getProdutosValidos();

			mav.setViewName("produtos/lista");
			mav.addObject("prod", prod);
		} else {

			mav.setViewName("login/cadastro");

		}

		return mav;

	}

	@PostMapping(value = "produtos/pesquisa")
	public ModelAndView pesquisa(Produto p) {

		List<Produto> pesq = pdao.prodByName(p.getNome());
		ModelAndView mav = new ModelAndView("produtos/pesquisa");
		mav.addObject("pesq", pesq);

		return mav;
	}

	@GetMapping(value = "produtos/remover")
	public String remover(long id, HttpSession s) {

		String email = (String) s.getAttribute("email");

		if (email != null && ddao.getTipoByEmail(email) == 3 || ddao.getTipoByEmail(email) == 4) {
			pdao.apagar(id);
			return "redirect:produtos";
		} else {
			return "redirect:bkp/acessoNegado";
		}

	}

}
