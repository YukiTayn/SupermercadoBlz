package sm.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sm.daos.DadosDAO;
import sm.daos.EntregasDAO;
import sm.daos.ProdutoDAO;
import sm.daos.VendasDAO;
import sm.models.Dados;
import sm.models.Entregas;
import sm.models.Produto;
import sm.models.Vendas;

@Controller
public class DadosController {

	VendasDAO vdao = new VendasDAO();
	DadosDAO ddao = new DadosDAO();
	EntregasDAO edao = new EntregasDAO();
	ProdutoDAO pdao = new ProdutoDAO();

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
	
	
	//Login
	
	@RequestMapping(value="dados/login", method=RequestMethod.GET)
	public String login() {
		return "login/form";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView login(Dados d, HttpSession s) {
		
		ModelAndView mav = new ModelAndView();
		
		if(ddao.existe(d.getEmail()) == 1 ) {
			
			if(ddao.login(d) == 1) {
				
				s.setAttribute("email", d.getEmail());
				int tipo = ddao.getTipo(d.getEmail(), d.getSenha());
				
				System.out.println(d.getEmail());
				System.out.println(d.getSenha());
				System.out.println(tipo);
				
				if(tipo == 1) {
					return loginCliente(d.getEmail());
				}
				if(tipo == 2) {
					return loginVend(d.getEmail());
				}
				if(tipo == 3){
					return loginGerente(d.getEmail());
				}
				if(tipo == 4) {
					return loginAdmin(d.getEmail());
				}
				if(tipo == 5) {
					return loginEntreg(d.getEmail());
				}

				
			}else {
				System.out.println("Erro nas entradas");
				return null;
			}
			
		}else {
			System.out.println("Email não existe");
			return null;
		}
		
		return null;
		
	}
	
	public ModelAndView loginCliente(String email) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("usuarios/1");
		
		long id = ddao.getID(email);
		
		List<Vendas> compras = vdao.getVendasByID(id);
		List<Vendas> comprasOn = vdao.getVendasOnline(id);
		mav.addObject("compras", compras);
		mav.addObject("comprasOn", comprasOn);
		
		return mav;
		
	}
	
	public ModelAndView loginVend(String email) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("usuarios/2");
		
		long id = ddao.getID(email);
		
		List<Vendas> vendas = vdao.getVendasVend(id);
		List<Produto> produtos = pdao.getProdutos();
		mav.addObject("vendas", vendas);
		mav.addObject("produtos", produtos);
		
		return mav;
	}
	
	public ModelAndView loginGerente(String email) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("usuarios/3");
		
		List<Entregas> abertas = edao.Abertas();
		List<Entregas> pegas = edao.Pegas();
		List<Entregas> conc = edao.Concluidos();
		List<Entregas> neg = edao.Negados();
		mav.addObject("abertas", abertas);
		mav.addObject("pegas", pegas);
		mav.addObject("conc", conc);
		mav.addObject("neg", neg);
		
		return mav;
	}
	
	public ModelAndView loginAdmin(String email) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("usuarios/4");
		
		List<Vendas> vendas = vdao.getVendas();
		mav.addObject("vendas", vendas);
		
		return mav;
	}
	
	public ModelAndView loginEntreg(String email) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("usuarios/5");
		
		long id = ddao.getID(email);
		
		List<Entregas> abertas = edao.getEntAbID(id);
		List<Entregas> pegas = edao.getEntPgID(id);
		List<Entregas> conc = edao.getEntConcID(id);
		List<Entregas> neg = edao.getEntNegID(id);
		mav.addObject("abertas", abertas);
		mav.addObject("pegas", pegas);
		mav.addObject("conc", conc);
		mav.addObject("neg", neg);
		
		return mav;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession s) {
		
		s.invalidate();
		return "redirect:/";
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
