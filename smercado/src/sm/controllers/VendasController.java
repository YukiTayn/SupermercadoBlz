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
import sm.daos.VendasDAO;
import sm.models.Produto;
import sm.models.Vendas;

@Controller
public class VendasController {

	ProdutoDAO pdao = new ProdutoDAO();
	VendasDAO vdao = new VendasDAO();
	DadosDAO ddao = new DadosDAO();

	@GetMapping("vendas/")
	public ModelAndView listar(HttpSession s) {

		String email = (String) s.getAttribute("email");
		ModelAndView mav = new ModelAndView();

		if (email != null && ddao.getTipoByEmail(email) == 3 || ddao.getTipoByEmail(email) == 4) {
			List<Vendas> vendas = vdao.getVendas();
			mav.setViewName("vendas/lista");
			mav.addObject("vendas", vendas);
		} else {
			mav.setViewName("bkp/acessoNegado");
		}

		return mav;

	}

	@GetMapping(value = "vendas/online")
	public ModelAndView online(long id) {

		Produto p = pdao.getProdutoByID(id);
		ModelAndView modelAndView = new ModelAndView("vendas/online");
		modelAndView.addObject("prod", p);

		return modelAndView;
	}

	@PostMapping(value = "vendas/online")
	public String online(Vendas vnd) {

		vdao.newVenda(vnd);
		return "redirect:/";
	}

	@GetMapping(value = "vendas/fisica")
	public ModelAndView fisica(long id) {

		Produto p = pdao.getProdutoByID(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("vendas/fisica");
		mav.addObject("prod", p);

		return mav;
	}

	public String fisica(Vendas vnd) {

		vdao.newVenda(vnd);
		return "redirect:/";
	}

}
