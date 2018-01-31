package sm.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sm.daos.ProdutoDAO;
import sm.daos.VendasDAO;
import sm.models.Produto;
import sm.models.Vendas;

@Controller
public class VendasController {

	ProdutoDAO pdao = new ProdutoDAO();
	VendasDAO vdao = new VendasDAO();
	Produto p = new Produto();
	Vendas v = new Vendas();
	
	@RequestMapping("vendas/")
	public ModelAndView listar() {
		
		List<Vendas> vendas = vdao.getVendas();
		
		ModelAndView modelAndView = new ModelAndView("vendas/lista");
		modelAndView.addObject("vendas", vendas);
		
		return modelAndView;
	}
	
	
	//Venda online
	@RequestMapping(value="vendas/online", method=RequestMethod.GET)
	public ModelAndView online(long id) {
		
		p = pdao.getProdutoByID(id);
		ModelAndView modelAndView = new ModelAndView("vendas/online");
		modelAndView.addObject("prod", p);
		
		return modelAndView;
	}
	
	@RequestMapping(value="vendas/online", method=RequestMethod.POST)
	public ModelAndView online(Vendas vnd) {
		
		vdao.newVenda(vnd);
		return listar();
	}
	
	//Venda física
	@RequestMapping(value="vendas/fisica", method=RequestMethod.GET)
	public ModelAndView fisica(long id) {
		
		p = pdao.getProdutoByID(id);
		ModelAndView modelAndView = new ModelAndView("vendas/fisica");
		modelAndView.addObject("prod", p);
		
		return modelAndView;
	}
	
	public ModelAndView fisica(Vendas vnd) {
		
		vdao.newVenda(vnd);
		return listar();
	}
	
}
